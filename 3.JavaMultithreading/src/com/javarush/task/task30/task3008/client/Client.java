package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private boolean clientConnected = false;

    public static void main(String... args){
        Client client = new Client();
        client.run();
    }

    public void run() {
        synchronized (this){
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();

            try {
                wait();
                if (clientConnected) {
                    ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                    while (clientConnected){
                        String message = ConsoleHelper.readString();
                        if (message.equals("exit")){
                            break;
                        } else {
                            if(shouldSendTextFromConsole()){
                                sendTextMessage(message);
                            }
                        }
                    }
                } else {
                    ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error client. Client was closing");
                return;
            }
        }

    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Input server address");
        String serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Input server port");
        int port = ConsoleHelper.readInt();
        return port;
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Input user name");
        String name = ConsoleHelper.readString();
        return name;
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error send message");
            clientConnected = false;
        }

    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAddress,serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "come to chat");
        }
        
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "go away from chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();

                if (message.getType() == MessageType.NAME_REQUEST) { // Сервер запросил имя пользователя
                    // Запрашиваем ввод имени с консоли
                    String name = getUserName();
                    // Отправляем имя на сервер
                    connection.send(new Message(MessageType.USER_NAME, name));

                } else if (message.getType() == MessageType.NAME_ACCEPTED) { // Сервер принял имя пользователя
                    // Сообщаем главному потоку, что он может продолжить работу
                    notifyConnectionStatusChanged(true);
                    return;

                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // Цикл обработки сообщений сервера
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) { // Сервер прислал сообщение с текстом
                    processIncomingMessage(message.getData());
                } else if (MessageType.USER_ADDED == message.getType()) {
                    informAboutAddingNewUser(message.getData());
                } else if (MessageType.USER_REMOVED == message.getType()) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

    }

}
