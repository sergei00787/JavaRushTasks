package com.javarush.task.task29.task2909.human;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class University {

    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        students = new ArrayList<>();
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return students.stream().filter(st -> st.getAverageGrade() >= averageGrade).findFirst().orElse(null);
//        for (Student student : students
//        ) {
//            if(student.getAverageGrade() >= averageGrade) return student;
//        }
//        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return students.stream().max(Comparator.comparing(Student::getAverageGrade)).orElse(null);
    }
    
    public Student getStudentWithMinAverageGrade(){
        return students.stream().min(Comparator.comparing(Student::getAverageGrade)).orElse(null);
    }

    public void expel(Student student){
        students.remove(student);
    }

}