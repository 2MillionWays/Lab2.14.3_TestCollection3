package com.brainacad.oop.testcollection3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listOne = new ArrayList<>();
        LinkedList<String> listTwo = new LinkedList<>();

        for (int i = 0; i <= 10; i++) {
            listOne.add("number_" + i);
            listTwo.add("number_" + i);
        }
        Iterator<String> iteratorOne = listOne.iterator();
        while (iteratorOne.hasNext()) {
            System.out.print(iteratorOne.next()+" ");
        }
        System.out.println();
        Iterator<String> iteratorTwo = listTwo.iterator();
        while (iteratorTwo.hasNext()){
            System.out.print(iteratorTwo.next()+" ");
        }
        System.out.println();

        /*insert one list into the other by using a ListIterator, inserting at every other location - as far as I
        * understood it meant to place each element in a random location of listTwo*/
        ListIterator<String> listIteratorOne = listOne.listIterator();
        while (listIteratorOne.hasNext()){
            Random rnd = new Random();
            int insetLoc = rnd.nextInt(listTwo.size());
            listTwo.add(insetLoc,listIteratorOne.next());
        }//each element of listOne is being placed at a random position of listTwo

        //Now perform the insertion starting at the end of the first list and moving backward.
        for(ListIterator<String> listIteratorEnd = listTwo.listIterator(listTwo.size());listIteratorEnd.hasPrevious();){
            listOne.add(listIteratorEnd.previous());
        }//elements of listTwo are being inserted at the end of listOne and in reversed order - Last-In First-Out
        System.out.println();

        //checking the results and output
        printElements(listTwo); //NOTE: elements of listOne were randomly placed int listTwo
        printElements(listOne); //NOTE: listTwo was added in reversed order to listOne at the end of listOne

    }
    public static <E> void printElements(Collection<E> collection){
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
    }
}