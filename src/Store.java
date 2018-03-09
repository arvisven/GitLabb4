import javax.swing.JFrame;


//Vår funktion som skapar ett fönster med vissa egenskaper.
public class Store extends JFrame {

	public Store () {
		
		this.add(new StorePanel());
		
		this.setSize(490, 550);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
}
