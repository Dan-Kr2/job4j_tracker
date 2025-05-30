package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("KDA");
        student.setGroupe("gmu");
        student.setStart(new Date());

        System.out.println(student.getFio() + " learn in groupe - " + student.getGroupe() + " : " + student.getStart());
    }
}
