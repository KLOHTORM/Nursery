package org.example.Services;

import org.example.Data.Cat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddCat extends AddAnimal implements IAddAnimal {
    @Override
    public void addAnimal() {
        Cat cat;
        List<String> catCommands = new ArrayList<>();
        String my_input;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя кошки");
        name = scanner.nextLine();
        System.out.println("Введите команду");
        my_input = scanner.nextLine();
        catCommands.add(my_input);
        if (name.isEmpty() || my_input.isEmpty()) {
            try {
                throw new Exception("не все поля заполненны");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else
            try {
                cat = new Cat(name, catCommands);
                counter.add();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
