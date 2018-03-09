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
				
		return (Customer) _queue.remove(0);
		
	}
	
	public boolean isEmpty() {
		
		return _queue.isEmpty();
		
	}
		
	public DefaultListModel<Customer> getDefaultList() {
		
		return _queue;
		
	}
	
}