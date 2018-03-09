//Vår funktion för hur våra kunder.
public class Customer {
	
	//Alla kunder har ett namn och ett antal varor.
	private String _name;
	private int _items;
	
	public Customer(String name, int items) {
		
		_name = name;
		_items = items;
		
	}
	
	
	public String toString() {	//Funktion som skriver ut informationen om kunden på ett fint sätt.
		
		return _name + ", Antal varor: " + _items;
		
	}
	

}
