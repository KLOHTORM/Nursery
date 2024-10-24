package org.example.Services;

import org.example.Data.Dog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AddDog extends AddAnimal implements IAddAnimal {
    @Override
    public  void addAnimal() {
        Dog dog;
        List<String> dogCommands = new ArrayList<>();
        String my_input;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя собаки");
        name = scanner.nextLine();
        System.out.println("Введите команду");
        my_input = scanner.nextLine();
        dogCommands.add(my_input);
        if (name.isEmpty() || my_input.isEmpty()) {
            try {
                throw new Exception("не все поля заполненны");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else
            try {
                dog = new Dog(name, dogCommands);
                counter.add();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
