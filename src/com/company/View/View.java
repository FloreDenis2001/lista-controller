package com.company.View;

import com.company.Exceptions.IdStatus;
import com.company.controller.ControllerPersons;
import com.company.model.Person;

import java.util.Scanner;

public class View {
    private Scanner scanner;
    private ControllerPersons controllerPersons;

    public View() {
        this.scanner = new Scanner(System.in);
        this.controllerPersons = new ControllerPersons();
    }

    public void meniu() {
        System.out.println("-----------------List Managment-----------------");
        System.out.println("Apasa 1 pentru afisare persoane");
        System.out.println("Apasa 2 pentru gasire persoana");
        System.out.println("Apasa 3 pentru adaugare persoana");
        System.out.println("Apasa 4 pentru stergere persoana din lista");
        System.out.println("Apasa 5 pentru update varsta persoana");
        System.out.println("Exit");
        System.out.println("-------------------------------------------------\n");
    }


    public void play() throws IdStatus {
        int choose;
        boolean run = true;
        while (run) {
            meniu();
            System.out.println("Alege optiunea dorita : ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    controllerPersons.afisare();
                    break;
                case 2:
                    find();
                    break;
                case 3:
                    adauga();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    meniu();
            }
        }
    }

    public void find() {
        System.out.println("Introduceti id-ul persoanei : \n");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(controllerPersons.findById(id));

    }

    public void remove() throws IdStatus {
        System.out.println("Introduceti id-ul persoanei : ");
        int id = Integer.parseInt(scanner.nextLine());
        controllerPersons.stergerePersoana(id);
    }

    public void update() throws IdStatus {
        System.out.println("Introduceti id-ul persoanei : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Varsta noua : ");
        int varstaNoua= Integer.parseInt(scanner.nextLine());
        controllerPersons.updatePersoana(id,varstaNoua);
    }

    public void adauga() throws IdStatus{
        System.out.println("Nume : ");
        String nume= scanner.nextLine();
        System.out.println("Prenume : ");
        String prenume= scanner.nextLine();
        System.out.println("Varsta noua : ");
        int varstaNoua= Integer.parseInt(scanner.nextLine());
        System.out.println("Mobile : ");
        String mobile= scanner.nextLine();
        Person x = new Person(controllerPersons.nextId(),nume,prenume,varstaNoua,mobile);
        controllerPersons.addPersons(x);
    }
}
