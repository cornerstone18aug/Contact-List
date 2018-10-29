package contacts;

import java.util.ArrayList;

public class ContactList {

    ArrayList<Contact> list;

    public ContactList() {
        list = new ArrayList<Contact>();
    }

    public void add(Contact contact) {
        list.add(contact);
    }

    public void remove(int position) {
        list.remove(position);
    }

    public ContactList search(String word) {
        ContactList result = new ContactList();
        for (int i = 0; i < list.size(); i++) {
            Contact contact = list.get(i);
            if (contact.getFirstName().toLowerCase().indexOf(word.toLowerCase()) >= 0) {
                result.add(contact);
            } else if (contact.getLastName().toLowerCase().indexOf(word.toLowerCase()) >= 0) {
                result.add(contact);
            }
        }
        return result;
    }

    public int length() {
        return list.size();
    }

    public void list() {
        System.out.println(String.format("** Number of Contacts: %d **", list.size()));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("** Contact number %d **", i + 1));
            System.out.println(list.get(i));
        }
    }

    public void show(ContactList a,int index)
    {
        if(index >= 0 && index < length())
        {
            System.out.println(a.list.get(index).toString());
        }
        else
        {
            System.out.println("Error: ID Not Found");
        }
    }

    public void find(ContactList a,String id)
    {
        for(Contact i:a.list)
        {
            if(i.getFirstName().equals(id))
            {
                System.out.println(i.toString());
            }
            else if(i.getLastName().equals(id))
            {
                System.out.println(i.toString());
            }
            else if (i.getEmailAddress().equals(id))
            {
                System.out.println(i.toString());
            }
            else
            {
                System.out.println("Error: User not Found\n");
            }
        }
    }
    public boolean check(ContactList a,String email)
    {
        for(Contact i:a.list){
            if(i.getEmailAddress().equals(email))
            {
                System.out.println("This email is already exist");
                return false;
            }
        }
        if (email.matches("[A-Za-z0-9.]+@[A-Za-z0-9.]+\\.[A-Za-z0-9.]+")) {

            return true;
        } else {
            System.out.println("Error: Invalid Email address");
            return false;
        }
    }

    public Contact getContact(int i) {
        return list.get(i);
    }



}
