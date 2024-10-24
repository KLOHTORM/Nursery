package org.example.Data;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Animal implements Comparable<Animal> {
    private String name;
    public static Integer globalCounter = 0;
    private LocalDate dateOfBirth;



    @Override
    public int compareTo(Animal o) {
        if (getDateOfBirth() == null || o.getDateOfBirth() == null){
            return 0;
        }
        return getDateOfBirth().compareTo(o.getDateOfBirth());
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth() {
        int year;
        int month;
        int day;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год рождения");
        year = scanner.nextInt();
        System.out.println("Введите месяц рождения");
        month = scanner.nextInt();
        System.out.println("Введите день рождения");
        day = scanner.nextInt();
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public Animal(String name) {
        this.name = name;
    }


    public static Integer getGlobalCounter() {
        return globalCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
