package org.example.AnimalManager;

import org.example.Data.*;
import org.example.Services.*;
import org.example.View.ViewCats;
import org.example.View.ViewDogs;
import org.example.View.ViewDonkeys;
import org.example.View.ViewHorses;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AnimalManager {
    AddDog addDog = new AddDog();
    AddCat addCat = new AddCat();
    AddHorse addHorse = new AddHorse();
    AddDonkey addDonkey = new AddDonkey();

    Scanner scanner = new Scanner(System.in);

    ViewDogs viewAllDogs = new ViewDogs();
    ViewCats viewAllCats = new ViewCats();
    ViewHorses viewAllHorses = new ViewHorses();
    ViewDonkeys viewAllDonkeys = new ViewDonkeys();

    public void sortAnimalsByBirthday(){
        List<Animal> union = new ArrayList<>();
        union.addAll(Dog.listOfDogs);
        union.addAll(Cat.listOfCats);
        union.addAll(Horse.listOfHorses);
        union.addAll(Donkey.listOfDonkeys);
        Collections.sort(union);
        System.out.println("----------");
        for (Animal animal : union) {
            System.out.println(animal);
        }
    }

    public void addCommandToAnimal() {
        Integer my_input;
        while (true) {
            System.out.println("1 - Выбрать собаку\n" +
                    "2 - Выбрать кошку\n" +
                    "3 - Выбрать лошадь\n" +
                    "4 - Выбрать осла\n" +
                    "5 - Выход");
            System.out.println("Выберите действие");
            my_input = scanner.nextInt();
            if (my_input.equals(1)) {
                System.out.println("Вы выбрали 1 опцию");
                addCommandToDog();
                break;

            } else if (my_input.equals(2)) {
                System.out.println("Вы выбрали 2 опцию");
                addCommandToCat();
                break;

            } else if (my_input.equals(3)) {
                System.out.println("Вы выбрали 3 опцию");
                addCommandToHorse();
                break;


            } else if (my_input.equals(4)) {
                System.out.println("Вы выбрали 4 опцию");
                addCommandToDonkey();
                break;

            } else if (my_input.equals(5)) {
                System.out.println("Вы выбрали 5 опцию");
                break;
            }
        }
    }

    public void viewAnimal() {
        Integer my_input;
        while (true) {
            System.out.println("1 - Посмотреть собак\n" +
                    "2 - Посмотреть кошек\n" +
                    "3 - Посмотреть лошадей\n" +
                    "4 - Посмотреть ослов\n" +
                    "5 - Выход");
            System.out.println("Выберите действие");
            my_input = scanner.nextInt();
            if (my_input.equals(1)) {
                System.out.println("Вы выбрали 1 опцию");
                viewAllDogs.viewDogList(Dog.listOfDogs);
                break;

            } else if (my_input.equals(2)) {
                System.out.println("Вы выбрали 2 опцию");
                viewAllCats.viewCatList(Cat.listOfCats);
                break;

            } else if (my_input.equals(3)) {
                System.out.println("Вы выбрали 3 опцию");
                viewAllHorses.viewHorseList(Horse.listOfHorses);
                break;

            } else if (my_input.equals(4)) {
                System.out.println("Вы выбрали 4 опцию");
                viewAllDonkeys.viewDonkeyList(Donkey.listOfDonkeys);
                break;

            } else if (my_input.equals(5)) {
                System.out.println("Вы выбрали 5 опцию");
                break;
            }
        }
    }


    public void addAnimal() {
        Integer my_input;
        while (true) {
            System.out.println("1 - Завести собаку\n" +
                    "2 - Завести кошку\n" +
                    "3 - Завести лошадь\n" +
                    "4 - Завести осла\n" +
                    "5 - Выход");
            System.out.println("Выберите действие");
            my_input = scanner.nextInt();
            if (my_input.equals(1)) {
                System.out.println("Вы выбрали 1 опцию");
                addDog.addAnimal();
                break;

            } else if (my_input.equals(2)) {
                System.out.println("Вы выбрали 2 опцию");
                addCat.addAnimal();
                break;

            } else if (my_input.equals(3)) {
                System.out.println("Вы выбрали 3 опцию");
                addHorse.addAnimal();
                break;

            } else if (my_input.equals(4)) {
                System.out.println("Вы выбрали 4 опцию");
                addDonkey.addAnimal();
                break;

            } else if (my_input.equals(5)) {
                System.out.println("Вы выбрали 5 опцию");
                break;
            }
        }
    }

    private void addCommandToDog() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Integer my_input;
        String my_command;
        viewAllDogs.viewDogList(Dog.listOfDogs);
        System.out.println("Выберите id собаки, которой добавим команду");
        my_input = scanner.nextInt();
        if ((my_input < 0) || (my_input > Dog.listOfDogs.size() - 1)) {
            System.out.println("такого id нет");
        } else {
            System.out.println("Введите команду");
            my_command = scanner2.nextLine();
            System.out.println(Dog.listOfDogs.get(my_input));
            List<String> dogCommands = Dog.listOfDogs.get(my_input).getCommands();
            dogCommands.add(my_command);
            System.out.println(dogCommands);
            Dog.listOfDogs.get(my_input).setCommands(dogCommands);
        }
    }

    private void addCommandToCat() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Integer my_input;
        String my_command;
        viewAllCats.viewCatList(Cat.listOfCats);
        System.out.println("Выберите id кошки, которой добавим команду");
        my_input = scanner.nextInt();
        if ((my_input < 0) || (my_input > Cat.listOfCats.size() - 1)) {
            System.out.println("такого id нет");
        } else {
            System.out.println("Введите команду");
            my_command = scanner2.nextLine();
            System.out.println(Cat.listOfCats.get(my_input));
            List<String> allCommands = Cat.listOfCats.get(my_input).getCommands();
            allCommands.add(my_command);
            System.out.println(allCommands);
            Cat.listOfCats.get(my_input).setCommands(allCommands);
        }
    }

    private void addCommandToHorse() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Integer my_input;
        String my_command;
        viewAllHorses.viewHorseList(Horse.listOfHorses);
        System.out.println("Выберите id лошади, которой добавим команду");
        my_input = scanner.nextInt();
        if ((my_input < 0) || (my_input > Dog.listOfDogs.size() - 1)) {
            System.out.println("такого id нет");
        } else {
            System.out.println("Введите команду");
            my_command = scanner2.nextLine();
            System.out.println(Dog.listOfDogs.get(my_input));
            List<String> allCommands = Dog.listOfDogs.get(my_input).getCommands();
            allCommands.add(my_command);
            System.out.println(allCommands);
            Dog.listOfDogs.get(my_input).setCommands(allCommands);
        }
    }

    private void addCommandToDonkey() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Integer my_input;
        String my_command;
        viewAllDonkeys.viewDonkeyList(Donkey.listOfDonkeys);
        System.out.println("Выберите id ослика, которой добавим команду");
        my_input = scanner.nextInt();
        if ((my_input < 0) || (my_input > Donkey.listOfDonkeys.size() - 1)) {
            System.out.println("такого id нет");
        } else {
            System.out.println("Введите команду");
            my_command = scanner2.nextLine();
            System.out.println(Donkey.listOfDonkeys.get(my_input));
            List<String> allCommands = Donkey.listOfDonkeys.get(my_input).getCommands();
            allCommands.add(my_command);
            System.out.println(allCommands);
            Donkey.listOfDonkeys.get(my_input).setCommands(allCommands);
        }
    }
}
