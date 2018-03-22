import java.util.Collection;

import javax.swing.DefaultListModel;

public class Queue<Customer> {
	
	private DefaultListModel<Customer> _queue;
	
	//Skapar tom kö.
	//Pre: Sant
	//Post: Tom kö skapas
	public Queue() {
		
		_queue = new DefaultListModel<Customer>();
		
	}
	
	//Lägger till element i kö
	//Pre: Sant
	//Post: Elementet har lagts sist i kön
	public void enqueue(Customer _customer) {
		
		_queue.addElement(_customer);
		
	}
	
	//Tar bort element ur kö.
	//Pre: !isEmpty()
	//Post: Första elementet är borttaget ur kön och returnerat.
	public Customer dequeue() {
				
		return (Customer) _queue.remove(0);
		
	}
	
	//Kollar om kön är tom.
	//Pre: sant
	//Post: resultat = sant om kön är tom, annars falskt.
	public boolean isEmpty() {
		
		return _queue.isEmpty();
		
	}
	
	//Skickar tillbaka lista
	//Pre: Sant
	//Post: Returnera kön
	public DefaultListModel<Customer> getDefaultList() {
		
		return _queue;
		
	}
	
}