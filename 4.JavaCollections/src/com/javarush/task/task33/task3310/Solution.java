package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Shortener (1)
 * Давай напишем укорачиватель Shortener. Это будет некий аналог укорачивателя
 * ссылок Google URL Shortener (https://goo.gl), но мы расширим его функциональность и
 * сделаем консольным. Он будет сокращать не только ссылки, но и любые строки.
 * Наш Shortener - это класс, который может для любой строки вернуть некий
 * уникальный идентификатор и наоборот, по ранее полученному идентификатору
 * вернуть строку.
 *
 * Два дополнительных требования к Shortener:
 * - для двух одинаковых строк должен возвращаться один и тот же идентификатор;
 * - он должен поддерживать столько строк, сколько значений может принимать long,
 * именно этот тип будет использоваться для идентификатора.
 * Первое требование очень сильно влияет на производительность, т.к. при получении
 * идентификатора для новой строки мы должны проверить не обрабатывалась ли эта
 * строка ранее, чтобы вернуть старый идентификатор.
 *
 * 1.1. Объяви класс Shortener.
 * 1.2. Добавь методы заглушки в объявленный класс:
 * 1.2.1. Long getId(String string) - будет возвращать идентификатор id для заданной
 * строки.
 * 1.2.2. String getString(Long id) - будет возвращать строку для заданного
 * идентификатора или null, если передан неверный идентификатор.
 *
 * 1.3. Создай класс Solution с пустым методом main.
 *
 * P.S. Все методы делай публичными, а поля приватными, если нет явных указаний касательно модификаторов доступа.
 *
 *
 * Требования:
 * 1. В классе Shortener должен быть объявлен метод public Long getId(String string).
 * 2. В классе Shortener должен быть объявлен метод public String getString(Long id).
 * 3. В классе Solution должен быть объявлен метод public static void main(String[] args).
 *
 *
 * Shortener (2)
 * Укорачиватель Shortener будет поддерживать разные стратегии хранения данных (строк и их идентификаторов). Все эти стратегии будут наследоваться от интерфейса StorageStrategy. Почитай подробнее про паттерн Стратегия на Вики.
 * Наше хранилище будет оперировать двумя понятиями: ключ и значение. Ключом будет идентификатор строки, а значением сама строка.
 *
 * 2.1. Добавь интерфейс StorageStrategy в пакет strategy.
 * 2.2. Добавь в интерфейс следующие методы:
 * 2.2.1. boolean containsKey(Long key) - должен вернуть true, если хранилище
 * содержит переданный ключ.
 * 2.2.2. boolean containsValue(String value) - должен вернуть true, если хранилище
 * содержит переданное значение.
 * 2.2.3. void put(Long key, String value) - добавить в хранилище новую пару ключ -
 * значение.
 * 2.2.4. Long getKey(String value) - вернуть ключ для переданного значения.
 * 2.2.5. String getValue(Long key) - вернуть значение для переданного ключа.
 *
 * Требования:
 * •	В интерфейсе StorageStrategy должен быть объявлен метод boolean containsKey(Long key).
 * •	В интерфейсе StorageStrategy должен быть объявлен метод boolean containsValue(String value).
 * •	В интерфейсе StorageStrategy должен быть объявлен метод void put(Long key, String value).
 * •	В интерфейсе StorageStrategy должен быть объявлен метод Long getKey(String value).
 * •	В интерфейсе StorageStrategy должен быть объявлен метод boolean String getValue(Long key).
 * •	Интерфейс StorageStrategy должен быть создан в пакете strategy.
 *
 *
 *
 * Shortener (3)
 * Вернемся к классу Shortener:
 * 3.1. Добавь в него поле Long lastId. Проинициализируй его нулем. Это поле будет
 * отвечать за последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище.
 * 3.2. Добавь поле StorageStrategy storageStrategy в котором будет храниться стратегия хранения данных.
 * 3.3. Добавь конструктор, который принимает StorageStrategy и инициализирует соответствующее поле класса.
 * 3.4. Реализуй метод getId, он должен:
 * 3.4.1. Проверить есть ли переданное значение в хранилище, если есть - вернуть его ключ.
 * 3.4.2. Если преданного значения нет в хранилище, то:
 * 3.4.2.1. Увеличить значение lastId на единицу;
 * 3.4.2.2. Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку);
 * 3.4.2.3. Вернуть новое значение lastId.
 * 3.5. Реализуй метод getString, он должен вернуть строку по заданному идентификатору (ключу).
 * 3.6. Предусмотреть возможность вызова методов getId и getString из разных потоков добавив соответствующий модификатор к заголовкам методов.
 *
 * Требования:
 * •	В классе Shortener должно быть создано приватное поле Long lastId инициализированное нулем.
 * •	В классе Shortener должно быть создано приватное поле storageStrategy типа StorageStrategy.
 * •	Конструктор класса Shortener должен принимать один параметр типа StorageStrategy и инициализировать им поле storageStrategy.
 * •	Метод getId должен быть реализован в соответствии с условием задачи.
 * •	Метод getString должен быть реализован в соответствии с условием задачи.
 *
 *
 * Shortener (4)
 * Нам потребуется несколько вспомогательных классов:
 * 4.1. Создай класс Helper.
 * 4.1.1. Добавь в него статический публичный метод String generateRandomString(), который будет генерировать случайную строку. Воспользуйся для этого классами SecureRandom и BigInteger. Подсказка: гугли запрос "random string java". Строка может состоять из цифр и любой из 26 маленьких букв английского алфавита.
 * 4.1.2. Добавь в класс статический метод printMessage(String message). Он должен выводить переданный текст в консоль. Весь дальнейший вывод в программе должен быть реализован через этот метод!
 * 4.2. Создай класс ExceptionHandler.
 * 4.2.1. Добавь в него статический метод log(Exception e), который будет выводить краткое описание исключения.
 *
 *
 * Требования:
 * 1. Метод generateRandomString класса Helper должен генерировать случайную строку используя способ описанный в условии задачи.
 * 2. Метод printMessage класса Helper должен выводить переданный текст на экран.
 * 3. Метод log класса ExceptionHandler должен выводить на экран краткое описание исключения.
 *
 *
 *
 * Shortener (5)
 * Давай напишем наше первое хранилище (стратегию хранилища). Внутри оно будет содержать обычный HashMap. Все стратегии будем хранить в пакете strategy.
 * 5.1. Создай класс HashMapStorageStrategy, реализующий интерфейс StorageStrategy.
 * 5.2. Добавь в класс поле HashMap<Long, String> data. В нем будут храниться наши данные.
 * 5.3. Реализуй в классе все необходимые методы. Реализации методов должны использовать поле data. Дополнительные поля не создавать.
 *
 *
 * Требования:
 * 1. Класс HashMapStorageStrategy должен поддерживать интерфейс StorageStrategy.
 * 2. В классе HashMapStorageStrategy должно быть создано и инициализировано приватное поле data типа HashMap.
 * 3. В классе HashMapStorageStrategy должен быть корректно реализован метод containsKey.
 * 4. В классе HashMapStorageStrategy должен быть корректно реализован метод containsValue.
 * 5. В классе HashMapStorageStrategy должен быть корректно реализован метод put.
 * 6. В классе HashMapStorageStrategy должен быть корректно реализован метод getValue.
 * 7. В классе HashMapStorageStrategy должен быть корректно реализован метод getKey.
 *
 *
 *
 *
 * Shortener (6)
 * Первая стратегия готова, пришло время ее протестить. Для этого:
 * 6.1. Создай класс Solution, если ты не сделал это раньше.
 * 6.2. Добавь в класс Solution реализации вспомогательных статических методов:
 * 6.2.1. Set<Long> getIds(Shortener shortener, Set<String> strings). Этот метод должен для переданного множества строк возвращать множество идентификаторов. Идентификатор для каждой отдельной строки нужно получить, используя shortener.
 * 6.2.2. Set<String> getStrings(Shortener shortener, Set<Long> keys). Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
 * При реальном использовании Shortener, задача получить из множества строк множество идентификаторов и наоборот скорее всего не встретится, это нужно исключительно для тестирования.
 * 6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber. Реализация метода должна:
 * 6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
 * 6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
 * 6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
 * 6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества элементов. Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением процессора на другие потоки, временем, которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием объектов типа Date.
 * 6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.
 * 6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings. Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".
 * 6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
 * 6.3. Проверь, что программа работает и тест пройден.
 *
 *
 * Требования:
 * 1. Метод getIds должен для переданного множества строк возвращать множество идентификаторов.
 * 2. Метод getStrings должен для переданного множества идентификаторов возвращать множество строк.
 * 3. Метод testStrategy должен выводить на экран имя класса стратегии.
 * 4. Метод testStrategy должен генерировать тестовое множество строк используя метод generateRandomString класса Helper (количество элементов должно быть равно параметру elementsNumber).
 * 5. Метод testStrategy должен создавать объект типа Shortener используя переданную стратегию.
 * 6. Метод testStrategy должен замерять количество времени выполнения методов getIds и getStrings используя объекты типа Date.
 * 7. Метод testStrategy должен сравнивать количество сгенерированных строк и строк в множестве полученном в результате работы метода getStrings и выводить на экран результат прохождения теста.
 * 8. В методе main должен быть вызван метод testStrategy.
 *
 *
 *
 * Shortener (7)
 * Приступим к реализации второй стратегии OurHashMapStorageStrategy. Она не будет использовать готовый HashMap из стандартной библиотеки, а будет сама являться коллекцией.
 *
 * 7.1. Разберись как работает стандартный HashMap, посмотри его исходники или погугли статьи на эту тему.
 * 7.2. Если ты честно выполнил предыдущий пункт, то ты знаешь для чего используется класс Node поддерживающий интерфейс Entry внутри HashMap. Создай свой аналог внутри пакета strategy. Это должен быть обычный, не вложенный, не generic класс. Сделай его публичным.
 * В отличии от класса Node из HashMap, наш класс будет поддерживать только интерфейс Serializable и будет называться Entry.
 * 7.3. Добавь в Entry следующие поля: Long key, String value, Entry next, int hash. Как видишь, наша реализация будет поддерживать только тип Long для ключа и только String для значения. Область видимости полей оставь по умолчанию.
 * 7.4. Добавь и реализуй конструктор Entry(int hash, Long key, String value, Entry next).
 * 7.5. Добавь и реализуй методы: Long getKey(), String getValue(), int hashCode(), boolean equals() и String toString(). Реализовывать остальные методы оригинального Entry не нужно, мы пишем упрощенную версию.
 *
 *
 * Требования:
 * 1. В классе Entry должны быть созданы поля перечисленные в условии задачи.
 * 2. В классе Entry должен быть реализован публичный конструктор с четырьмя параметрами (int, Long, String, Entry) инициализирующий соответствующие поля класса.
 * 3. Метод getKey должен возвращать значение поля key.
 * 4. Метод getValue должен возвращать значение поля value.
 * 5. Метод toString должен возвращать строку формата key + "=" + value.
 * 6. Методы hashCode и equals должны быть корректно реализованы используя для сравнения поля key и value.
 *
 *
 * Shortener (8)
 * Добавь и реализуй класс OurHashMapStorageStrategy, используя класс Entry из предыдущей подзадачи. Класс OurHashMapStorageStrategy должен реализовывать интерфейс StorageStrategy.
 * 8.1. Добавь в класс следующие поля:
 * 8.1.1. static final int DEFAULT_INITIAL_CAPACITY = 16;
 * 8.1.2. static final float DEFAULT_LOAD_FACTOR = 0.75f;
 * 8.1.3. Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
 * 8.1.4. int size;
 * 8.1.5. int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
 * 8.1.6. float loadFactor = DEFAULT_LOAD_FACTOR;
 * 8.2. Реализуй в классе следующие вспомогательные методы:
 * 8.2.1. int hash(Long k)
 * 8.2.2. int indexFor(int hash, int length)
 * 8.2.3. Entry getEntry(Long key)
 * 8.2.4. void resize(int newCapacity)
 * 8.2.5. void transfer(Entry[] newTable)
 * 8.2.6. void addEntry(int hash, Long key, String value, int bucketIndex)
 * 8.2.7. void createEntry(int hash, Long key, String value, int bucketIndex)
 * 8.3. Добавь в класс публичные методы, которые требует интерфейс StorageStrategy.
 * Какие-либо дополнительные поля класса не использовать. Методы, не описанные в задании, реализовывать не нужно. Если возникнут вопросы как реализовать какой-то метод или что он должен делать, то ты всегда можешь посмотреть, как работает похожий метод в HashMap.
 * Можешь добавить в метод main класса Solution тестирование новой стратегии. Запусти и сравни время работы двух стратегий на одинаковом количестве элементов.
 *
 *
 * Требования:
 * 1. Класс OurHashMapStorageStrategy должен поддерживать интерфейс StorageStrategy.
 * 2. В классе OurHashMapStorageStrategy должны быть созданы все необходимые поля (согласно условию задачи).
 * 3. Методы интерфейса StorageStrategy должны быть реализованы в OurHashMapStorageStrategy таким образом, чтобы обеспечивать корректную работу Shortener созданного на его основе.
 * 4. В классе OurHashMapStorageStrategy должны присутствовать все вспомогательные методы перечисленные в условии задачи.
 */

public class Solution {
    public static void main(String[] args){
        testStrategy(new HashMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result = new HashSet<>();
        Long curId = null;
        for (String str : strings) {
            curId = shortener.getId(str);
           if (curId != null) result.add(curId);
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> result = new HashSet<>();
        String curString = null;
        for (Long num: keys) {
            curString = shortener.getString(num);
            if (curString != null) result.add(curString);
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> setString = new HashSet<>();
        Set<Long> setLong = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++) {
            setString.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date dateStart = new Date();
        setLong = getIds(shortener, setString);
        Date dateFinish = new Date();

        System.out.println(dateFinish.getTime()-dateStart.getTime());

        Set<String> setString2 = new HashSet<>();
        Date dateStart2 = new Date();
        setString2 = getStrings(shortener, setLong);
        Date dateFinish2 = new Date();

        System.out.println(dateFinish2.getTime()-dateStart2.getTime());

        String resultStr = setString.equals(setString2) ? "Тест пройден." : "Тест не пройден.";
        System.out.println(resultStr);

        }
}
