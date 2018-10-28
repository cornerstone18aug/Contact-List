package contacts;

import java.util.Scanner;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

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
            System.out.print("Phone Number:");
            setPhoneNumber(scanner.nextLine());
        } while (getPhoneNumber() == null);


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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\(?\\d{3}\\)?[\\s.-]?\\d{3}?[\\s.-]?\\d{4}")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Error: Invalid phone number");
        }
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