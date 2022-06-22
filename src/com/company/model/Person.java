package com.company.model;

public class Person implements Comparable<Person> {
    private int id;
    private String nume;
    private String prenume;
    private int varsta;
    private String mobile;

    public Person(int id, String nume, String prenume, int varsta, String mobile) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.mobile = mobile;
    }

    public Person(String text){
        String [] path=text.split(",");
        this.id=Integer.parseInt(path[0]);
        this.nume=path[1];
        this.prenume=path[2];
        this.varsta=Integer.parseInt(path[3]);
        this.mobile=path[4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        String text = "Id : " + this.id + "\n";
        text += "Nume : " + this.nume + "\n";
        text += "Prenume : " + this.prenume + "\n";
        text += "Varsta : " + this.varsta + "\n";
        text += "Mobile : " + this.mobile + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Person x = (Person) o;
        return this.getId() == x.getId();
    }

    @Override
    public int compareTo(Person x) {
        if (this.getVarsta() > x.getVarsta()) {
            return 1;
        } else if (this.getVarsta() < x.getVarsta()) {
            return -1;
        } else {
            return 0;
        }
    }
}