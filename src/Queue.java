import java.util.Collection;

public interface Queue<Customer> extends Collection{
	
	public void enqueue(Customer _customer);
	public Customer dequeue();
	public boolean isEmpty();
	
}
