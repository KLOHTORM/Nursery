package org.example.Services;

import org.example.Data.Horse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddHorse extends AddAnimal implements IAddAnimal {
    @Override
    public void addAnimal() {
        Horse horse;
        List<String> horseCommands = new ArrayList<>();
        String my_input;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя лошади");
        name = scanner.nextLine();
        System.out.println("Введите команду");
        my_input = scanner.nextLine();
        horseCommands.add(my_input);
        if (name.isEmpty() || my_input.isEmpty()) {
            try {
                throw new Exception("не все поля заполненны");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else
            try {
                horse = new Horse(name, horseCommands);
                counter.add();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
