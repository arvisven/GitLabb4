import java.util.Collection;

import javax.swing.DefaultListModel;

public class Queue<Customer> {
	
	private DefaultListModel<Customer> _queue;
	
	//Skapar tom k�.
	//Pre: Sant
	//Post: Tom k� skapas
	public Queue() {
		
		_queue = new DefaultListModel<Customer>();
		
	}
	
	//L�gger till element i k�
	//Pre: Sant
	//Post: Elementet har lagts sist i k�n
	public void enqueue(Customer _customer) {
		
		_queue.addElement(_customer);
		
	}
	
	//Tar bort element ur k�.
	//Pre: !isEmpty()
	//Post: F�rsta elementet �r borttaget ur k�n och returnerat.
	public Customer dequeue() {
				
		return (Customer) _queue.remove(0);
		
	}
	
	//Kollar om k�n �r tom.
	//Pre: sant
	//Post: resultat = sant om k�n �r tom, annars falskt.
	public boolean isEmpty() {
		
		return _queue.isEmpty();
		
	}
	
	//Skickar tillbaka lista
	//Pre: Sant
	//Post: Returnera k�n
	public DefaultListModel<Customer> getDefaultList() {
		
		return _queue;
		
	}
	
}