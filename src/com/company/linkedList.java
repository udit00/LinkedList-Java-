package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class linkedList {
        Node head;
        static class Node{
            int data;
            Node next;
            Node(int data){
                this.data=data;
            }
        }

        public static void printList(linkedList linkedList){
            Node temp=linkedList.head;
            while (temp!=null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("\n----------------------------------------");
        }

        public static linkedList createLinkedList(){
            linkedList newList=new linkedList();
            Scanner sc=new Scanner(System.in);
            System.out.println("\nPlease enter the number of Nodes you want : \n" +
                    "[Note: Don't enter a big number as it'll be hard to enter such a huge input]\n" +
                    "Choice:");
            int elementCount=sc.nextInt();
            while (elementCount!=0){
                elementCount--;
                System.out.println("Element : ");
                int element=sc.nextInt();
                System.out.println("1. Insert "+element+" @ start of linked list.");
                System.out.println("2. Insert "+element+" @ end of linked list");
                System.out.println("Choice : ");
                short choiceEndStart=(short) sc.nextInt();
                switch (choiceEndStart) {
                    case 1 -> insertAtStart(newList, element);
                    case 2 -> insertAtEnd(newList, element);
                    default -> System.out.println("Since wrong input was given by you, inserting " + element + " @ the start.");
                }
            }

            return newList;
        }
        public static void insertAtStart(linkedList linkedList, int data){
            Node newNode=new Node(data);
            if(linkedList.head!=null) {
                newNode.next = linkedList.head;
            }
            else{
                newNode.next=null;
            }
            linkedList.head=newNode;
        }
        public static void insertAtEnd(linkedList linkedList, int data){
            Node newNode=new Node(data);
            if(linkedList.head != null){
                Node traverseTemp=linkedList.head;
                while(traverseTemp.next!=null){
                    traverseTemp=traverseTemp.next;
                }
                traverseTemp.next=newNode;
            }
            else{
                linkedList.head=newNode;
            }
        }
        /*private static void createLinkedList(linkedList list, short count){
            Scanner sc=new Scanner(System.in);
            System.out.println("This is Linked List Number "+count+
                    "\nPlease enter the number of Nodes you want : \n" +
                    "[Note: Don't enter a big number as it'll be hard to enter such a huge input]\n" +
                    "Choice:");
            int elementCount=sc.nextInt();
            while (elementCount!=0){
                System.out.println("Element : ");
                int element=sc.nextInt();
                elementCount--;
                System.out.println("1. To insert "+element+" @ the start of this linked list.");
                System.out.println("2. To insert "+element+" @ the end of this linked list");
                System.out.println("Choice : ");
                short choiceEndStart=(short) sc.nextInt();
                switch (choiceEndStart) {
                    case 1 -> insertAtStart(list, element);
                    case 2 -> insertAtEnd(list, element);
                    default -> System.out.println("Since wrong input was given by you, inserting " + element + " @ the start.");
                }
            }
        }*/
        private static void menu(ArrayList<linkedList> arrayLinkedList){

            Scanner sc=new Scanner(System.in);
            System.out.println("---------------------------------------------------");
            System.out.println("LINKED LIST IMPLEMENTATION");
            System.out.println("1. Create a new linked list");
            System.out.println("2. Print Linked List");
            System.out.println("3. Exit");
            short Choice=(short) sc.nextInt();
            switch (Choice) {
                case 1 -> {
                    arrayLinkedList.add(createLinkedList());
                    menu(arrayLinkedList);
                }
                case 2 -> {
                    short choice = (short) sc.nextInt();
                    if(arrayLinkedList.size()>0 && arrayLinkedList.size()<choice) {
                        System.out.println("Please enter the linked list you want to print.");
                        System.out.println("Choice : ");
                        printList(arrayLinkedList.get(choice-1));
                    }
                    else System.out.println("No linked list exist yet, you can make one @ the menu.");

                    menu(arrayLinkedList);

                }

                case 3 -> {
                    System.out.println("Exiting the program");
                }
                default -> {
                    System.out.println("Wrong Input.\nReturning Back to Main Menu... [Please select the option from 1 to 3");
                    menu(arrayLinkedList);
                }
            }
        }

        public static void main(String[] args) {
            ArrayList<linkedList> arrayLinkedList=new ArrayList<>();
            menu(arrayLinkedList);
        }
    }
