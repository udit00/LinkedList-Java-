package com.company;


import org.w3c.dom.NodeList;
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

        public void printList(){
            Node temp=head;
            while (temp!=null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("\n----------------------------------------");
            return;
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
        private static void createLinkedList(linkedList list, short count){
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
        }
        private static void menu(short countLinkedList, linkedList list1, linkedList list2, linkedList list3){
            Scanner sc=new Scanner(System.in);
            System.out.println("---------------------------------------------------");
            System.out.println("LINKED LIST IMPLEMENTATION");
            System.out.println("1. Create a new linked list [ Can Create Only 3 ]");
            System.out.println("2. Print Linked List [ must remember the number(Linked List) ]");
            System.out.println("3. Exit");
            short Choice=(short) sc.nextInt();
            switch (Choice) {
                case 1 -> {
                    if (countLinkedList > 3) {
                        System.out.println("Cannot Create linked list more than 3");
                        menu(countLinkedList, list1, list2, list3);
                    } else {
                        switch (countLinkedList) {
                            case 1:
                                createLinkedList(list1, countLinkedList);
                                menu((short) (countLinkedList+1),list1, list2, list3);
                                break;
                            case 2:
                                createLinkedList(list2, countLinkedList);
                                menu((short) (countLinkedList+1), list1, list2, list3);
                                break;
                            case 3:
                                createLinkedList(list3, countLinkedList);
                                menu((short) (countLinkedList+1), list1, list2, list3);
                                break;
                            default:
                                System.out.println("Wrong Menu");
                                menu(countLinkedList, list1, list2, list3);
                        }
                    }
                }
                case 2 -> {
                    if ((countLinkedList-1) < 1) {
                        System.out.println("No Linked List has been created yet.");
                        menu(countLinkedList, list1, list2, list3);
                    } else {
                        System.out.println("Please enter the linked list you want to print.");
                        System.out.println("Choice : ");
                        short choice = (short) sc.nextInt();
                        switch (choice) {
                            case 1 -> list1.printList();
                            case 2 -> list2.printList();
                            case 3 -> list3.printList();
                            default -> {
                                System.out.println("Wrong Input");
                                menu(countLinkedList, list1, list2, list3);
                            }
                        }
                        menu( countLinkedList, list1, list2, list3);
                    }
                }
                case 3 -> {
                    System.out.println("Exiting the program");
                }
                default -> {
                    System.out.println("Wrong Input.\nReturning Back to Main Menu... [Please select the option from 1 to 3");
                    menu(countLinkedList, list1, list2, list3);
                }
            }
        }

        public static void main(String[] args) {
            linkedList list1, list2, list3;
            list1=list2=list3=new linkedList();
            menu((short) 1, list1, list2, list3);
        }
    }
