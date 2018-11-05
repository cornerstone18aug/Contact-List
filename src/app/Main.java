package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import contacts.Contact;
import contacts.ContactList;

public class Main {

    public static final String ADD = "1";
    public static final String REMOVE = "2";
    public static final String SEARCH = "3";
    public static final String LIST = "4";
    public static final String UPDATE = "5";
    public static final String SHOW = "6";
    public static final String FIND = "7";
    public static final String HISTORY = "8";
    public static final String EXIT = "0";

    static ContactList list;
    static ArrayList<String> histories = new ArrayList<>();

    public static void main(String[] args) {
        list = new ContactList();
        createInitialContacts();

        String option = "";
        do {
            Scanner scanner = new Scanner(System.in);
            menu();
            option = scanner.nextLine();
            if (option.equals(ADD)) {
                Contact c = new Contact();
                System.out.println("Please enter the email you want to add");
                String email = scanner.nextLine();
                if (list.check(list, email)) {
                    c.fill(scanner, email);
                    list.add(c);
                }
                System.out.println(saveHistory(option));
            }
            if (option.equals(SEARCH)) {
                System.out.print("Find a contact by name or last name: ");
                String word = scanner.nextLine();
                ContactList tmp = list.search(word);
                tmp.list();
                System.out.println(saveHistory(option));
            }
            if (option.equals(UPDATE)) {
                System.out.print("Find a contact by name or last name to update: ");
                String word = scanner.nextLine();
                ContactList tmp = list.search(word);
                tmp.list();
                System.out.println("Number of the contact to edit: ");
                String pos;
                pos = scanner.nextLine();
                int position = Integer.parseInt(pos);
                if (position - 1 >= list.length() || position < 1) {
                    System.out.println("Invalid position " + position);
                } else {
                    list.getContact(position - 1).fill(scanner, null);
                }
                System.out.println(saveHistory(option));
            }
            if (option.equals(REMOVE)) {
                System.out.print("Find a contact by name or last name to remove: ");
                String word = scanner.nextLine();
                ContactList tmp = list.search(word);
                tmp.list();
                System.out.println("Number of the contact to remove: ");
                String pos;
                pos = scanner.nextLine();
                int position = Integer.parseInt(pos);
                if (position - 1 >= list.length() || position < 1) {
                    System.out.println("Invalid position " + position);
                } else {
                    list.remove(position - 1);
                }
                System.out.println(saveHistory(option));
            }
            if (option.equals(LIST)) {
                list.list();
                System.out.println(saveHistory(option));
            }
            if (option.equals(SHOW)) {
                boolean s = false;
                do {
                    try {
                        System.out.println("Please enter the id");
                        String a = scanner.nextLine();
                        list.show(list, Integer.parseInt(a));
                        s = true;
                    } catch (Exception e) {
                        System.out.println("Error, pls enter again\n");
                    }
                } while (!s);
                System.out.println(saveHistory(option));
            }
            if (option.equals(FIND)) {
                boolean s = false;
                do {
                    try {
                        System.out.println("Please enter the User (First or Last) Name or Email Address");
                        String a = scanner.nextLine();
                        list.find(list, a);
                        s = true;
                    } catch (Exception e) {
                        System.out.println("Error, pls enter again\n");
                    }
                } while (!s);
                System.out.println(saveHistory(option));
            }
            if (option.equals(HISTORY)) {
                System.out.println("Your histories are: ");
                showHistory();
                System.out.println(saveHistory(option));
            }
        } while (!option.equals("0"));
    }

    public static void createInitialContacts() {
        list.add(new Contact(
                "Murillo",
                "Camargo",
                "2367775334",
                "murillo@murillocamargo.com.br"
        ));
    }

    public static String saveHistory(String option) {
        if (histories.size() < 3) {
            histories.add(option);
        } else {
            histories.remove(0);
        }
        return "Ok";
    }

    public static String[] showHistory() {
        String[] currentHistory = new String[3];
        // loop array to show each item inside
        for (int i = 0; i < histories.size(); i++) {
            System.out.println(histories.get(i));
            currentHistory[i] = histories.get(i);
        }
        return currentHistory;
    }

    public static void menu() {
        System.out.println("Contact List");
        System.out.println("============");
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Search Contact");
        System.out.println("4. List Contact");
        System.out.println("5. Update Contact");
        System.out.println("6. Show Contact");
        System.out.println("7. Find Contact");
        System.out.println("8. History");
        System.out.println("0. Exit");
        System.out.println("============");
        System.out.print("Enter an option: ");
    }
}