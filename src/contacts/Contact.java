package contacts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private ArrayList<String> newPhoneNumber = new ArrayList<>();

    public Contact() {

    }

    public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
    }

    public String toString() {
        String result = "";
        result += ("First Name:");
        result += (getFirstName());
        result += "\n";
        result += ("Last Name:");
        result += (getLastName());
        result += "\n";
        result += ("Phone Number:");
        result += (getPhoneNumber());
        result += "\n";
        result += ("Email Address:");
        result += (getEmailAddress());
        result += "\n";
        return result;
    }

    public void fill(Scanner scanner,String email) {
        String action = "Create";
        setEmailAddress(email);
        if (this.getFirstName() != null) {
            action = "Update";
        }
        System.out.println("*** " + action + " Contact ***");
        System.out.println("============================");
        if(getEmailAddress() == null)
        {
            do {
                System.out.print("Email Address:");
                setEmailAddress(scanner.nextLine());
            } while (getEmailAddress() == null);
        }
        do {
            System.out.print("First Name:");
            setFirstName(scanner.nextLine());
        } while (getFirstName() == null);
        do {
            System.out.print("Last Name:");
            setLastName(scanner.nextLine());
        } while (getLastName() == null);
        do {
            int choice;
            System.out.print("Phone Number:");
            setPhoneNumber(scanner.nextLine());
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);

            do {
                System.out.print("Do you want to add another?: 1.Yes 2 No: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.println("Phone Number:");
                    setPhoneNumber(sc2.nextLine());

                }

            }while(choice == 1);

        } while (getPhoneNumber() == null && getPhoneNumber().isEmpty());

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<String> getPhoneNumber() {
        return newPhoneNumber;
    }

    public ArrayList setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\(?\\d{3}\\)?[\\s.-]?\\d{3}?[\\s.-]?\\d{4}")) {
//            this.phoneNumber = phoneNumber;
            newPhoneNumber.add(phoneNumber);
        } else {
            System.out.println("Error: Invalid phone number");
        }
        return newPhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {

        if (emailAddress.matches("[A-Za-z0-9.]+@[A-Za-z0-9.]+\\.[A-Za-z0-9.]+")) {

            this.emailAddress = emailAddress;
        } else {
            System.out.println("Error: Invalid Email address");
        }
    }

}