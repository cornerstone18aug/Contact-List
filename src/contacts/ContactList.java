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
	
	public ContactList search(String word){
		ContactList result=new ContactList();
		for (int i = 0; i < list.size(); i++) {
			Contact contact=list.get(i);
			if (contact.getFirstName().toLowerCase().indexOf(word.toLowerCase())>=0){
				result.add(contact);
			}
			else if (contact.getLastName().toLowerCase().indexOf(word.toLowerCase())>=0){
				result.add(contact);
			}
		}
		return result;
	}
	
	public int length(){
		return list.size();
	}
	
	public void list(){
		System.out.println(String.format("** Number of Contacts: %d **",list.size()));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(String.format("** Contact number %d **",i+1));
			System.out.println(list.get(i));
		}
	}
	
	public Contact getContact(int i) {
		return list.get(i);
	}
	

}
