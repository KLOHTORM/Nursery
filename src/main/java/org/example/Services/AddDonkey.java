package org.example.Services;

import org.example.Data.Donkey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddDonkey extends AddAnimal implements IAddAnimal {
    @Override
    public void addAnimal() {
        Donkey donkey;
        List<String> donkeyCommands = new ArrayList<>();
        String my_input;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя осла");
        name = scanner.nextLine();
        System.out.println("Введите команду");
        my_input = scanner.nextLine();
        donkeyCommands.add(my_input);
        if (name.isEmpty() || my_input.isEmpty()) {
            try {
                throw new Exception("не все поля заполненны");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else
            try {
                donkey = new Donkey(name, donkeyCommands);
                counter.add();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
