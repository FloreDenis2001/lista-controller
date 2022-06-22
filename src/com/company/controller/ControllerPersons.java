package com.company.controller;

import com.company.Exceptions.IdStatus;
import com.company.lista.Lista;
import com.company.model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControllerPersons {

    private Lista<Person> listapersoane;

    public ControllerPersons() {
        listapersoane = new Lista<>();
        this.load();
    }

    public void load() {
        try {
            File f = new File("C:\\Users\\flore\\Desktop\\javacodes\\controllerListaGeneric\\src\\com\\company\\res\\person");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Person x = new Person(line);
                this.listapersoane.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo afisare
    public void afisare() {
        listapersoane.afisareLista();
    }


    //todo findById

    public Person findById(int person_id) {
        for (int i = 0; i <= listapersoane.sizeList() - 1; i++) {
            if (listapersoane.get(i).getId() == person_id) {
                return listapersoane.get(i);
            }
        }
        return null;
    }


    //todo adaugare
    public void addPersons(Person nouaPersoana) throws IdStatus {
        Person x = findById(nouaPersoana.getId());
        if (x == null) {
            this.listapersoane.add(nouaPersoana);
        } else {
            throw new IdStatus("Exista persoana");
        }

    }

    //todo stergere

    public void stergerePersoana(int persoana_id) throws IdStatus {
        Person x = findById(persoana_id);
        if (x != null) {
            this.listapersoane.erase(x);
        } else {
            throw new IdStatus("Persoana nu exista!");
        }
    }


    //todo update

    public void updatePersoana(int persoana_id,int varstaNoua) throws IdStatus{
         Person x =findById(persoana_id);
         if(x!=null){
             x.setVarsta(varstaNoua);
         }else {
             throw new IdStatus("Persoana nu exista");
         }
    }

    //todo nextid

    public int nextId(){
        return listapersoane.sizeList()+1;
    }


}
