import java.util.Collection;

import javax.swing.DefaultListModel;

public class Queue<Customer> {
	
	private DefaultListModel<Customer> _queue;
	
	public Queue() {
		
		_queue = new DefaultListModel<Customer>();
		
	}
	
	public void enqueue(Customer _customer) {
		
		_queue.addElement(_customer);
		
	}
	
	
	public Customer dequeue() {
		
		if(!isEmpty()) {
			
			System.out.println("Tom kö");
			
		}
		
		_queue.remove(0);
		return _queue.getElementAt(0);
		
	}
	
	public boolean isEmpty() {
		
		if(_queue == null) {
			
			return true;
			
		} else {	
			
			return false;
			
		}
		
	}
		
	public DefaultListModel<Customer> getDefaultList() {
		
		return _queue;
		
	}
	
}