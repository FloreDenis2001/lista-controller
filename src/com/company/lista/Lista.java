package com.company.lista;

public class Lista<T extends Comparable<T>> {

    private Node<T> head = null;

    public void add(T t) {
        if (head == null) {
            head = new Node<T>();
            head.setData(t);
            head.setNext(null);
        } else {
            Node<T> node = new Node<T>();
            node.setData(t);
            node.setNext(head);
            head = node;
        }
    }

    public Node<T> iterator() {
        return this.head;
    }

    public void afisareLista() {
        Node<T> it = head;
        while (it != null) {
            System.out.println(it.getData());
            it = it.getNext();
        }
    }

    public void erase(int pozitie) {
        int count = 0;
        Node<T> it = head;
        Node<T> prev = null;
        if (pozitie == 0) {
            head = it.getNext();
        } else {
            while (count <= pozitie - 1) {
                prev = it;
                it = it.getNext();
                count++;
            }
            prev.setNext(it.getNext());
        }
    }

    public void add(int pozitie, T obiect) {
        int count = 0;
        Node<T> it = head;
        Node<T> nodeNou = new Node<>();
        if (pozitie == 0) {
            this.add(obiect);
        } else {
            while (count < pozitie - 1) {
                it = it.getNext();
                count++;
            }
            nodeNou.setData(obiect);
            nodeNou.setNext(it.getNext());
            it.setNext(nodeNou);
        }
    }

    public int findposition(T object) {
        int pozitie = 0;
        Node it = head;
        while (it != null && it.getData().equals(object) == false) {
            it = it.getNext();
            pozitie++;
        }
        return pozitie;
    }


    public void erase(T object) {
        this.erase(findposition(object));
    }

    public T get(int pozitie) {
        Node<T> it = head;
        int count = 0;
        while (count <= pozitie - 1) {
            it = it.getNext();
            count++;
        }
        return it.getData();
    }

    public void set(int pozitie, T object) {
        Node<T> it = head;
        int count = 0;
        while (count <= pozitie - 1) {
            it = it.getNext();
            count++;
        }
        it.setData(object);
    }

    public int sizeList() {
        int count = 0;
        Node<T> it = head;
        while (it != null) {
            it = it.getNext();
            count++;
        }
        return count;
    }

    public void sortList() {
        for (int i = 0; i < this.sizeList() - 1; i++) {
            for (int j = i + 1; j < this.sizeList(); j++) {
                if (this.get(i).compareTo(this.get(j)) > 0) {
                    T t = this.get(i);
                    this.set(i, this.get(j));
                    this.set(j, t);
                }
            }
        }
    }

}