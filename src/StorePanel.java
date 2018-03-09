import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class StorePanel extends JPanel implements ActionListener{
	
	JTextField _name;
	JTextField _items;
	DefaultListModel<Customer> m1;
	JList<Customer> _inStoreList;
	JList<Customer> _line1;
	JList<Customer> _line2;
	Queue<Customer> _queue1;
	Queue<Customer> _queue2;
	
	JLabel _infoStore;
	JLabel _infoLine1;
	JLabel _infoLine2;
	
	JPanel top_panel;
	JPanel center_panel;
	JPanel bottom_panel;
	JButton _newCustomer;
	JButton _moveToLine1;
	JButton _moveToLine2;
	JButton _serveQ1;
	JButton _serveQ2;
	
	JLabel _infoText;
	
	public StorePanel () {
	
		this.setLayout(new BorderLayout());
																//Panelen h�gst upp i programmet.
		_newCustomer = new JButton("L�gg till kund");
		_newCustomer.addActionListener(this);
		
		_name = new JTextField("Skriv namn h�r:", 15);
		_items = new JTextField("Skriv antal varor:", 15);
		
		top_panel = new JPanel();
		top_panel.add(_name);
		top_panel.add(_items);
		top_panel.add(_newCustomer);
		top_panel.setBackground(java.awt.Color.cyan);
		this.add(top_panel, BorderLayout.NORTH);
		
																//Listerna i mitten av programmet
		JPanel center_panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//L�gger till mellanrum mellan k�erna
		c.insets = new Insets(2,2,2,2);
		
		//Skapar en lista och tv� k�er
		m1 = new DefaultListModel<Customer>();
		_queue1 = new Queue<Customer>();
		_queue2 = new Queue<Customer>();
		
		//Text som visar listan med kunderna i aff�ren.
		_infoStore = new JLabel("Customers in store");
		c.gridx = 0;
		c.gridy = 0;
		center_panel.add(_infoStore, c);
		
		//Skapar listan i aff�ren
		_inStoreList = new JList<Customer>(m1);
		_inStoreList.setPreferredSize(new Dimension(150,250));
		c.gridx = 0;
		c.gridy = 1;
		_inStoreList.setBackground(java.awt.Color.cyan);
		center_panel.add(_inStoreList, c);
		
		//Text som visar f�rsta k�n
		_infoLine1 = new JLabel("Customers in Line 1");
		c.gridx = 1;
		c.gridy = 0;
		center_panel.add(_infoLine1, c);
		
		//Skapar f�rsta k�n
		_line1 = new JList<Customer>(_queue1.getDefaultList());
		_line1.setPreferredSize(new Dimension(150,250));
		c.gridx = 1;
		c.gridy = 1;
		_line1.setBackground(java.awt.Color.orange);
		center_panel.add(_line1, c);
		
		//Text som visar vilken som �r k� 2
		_infoLine2 = new JLabel("Customers in Line 2");
		c.gridx = 2;
		c.gridy = 0;
		center_panel.add(_infoLine2, c);
		
		//skapar k� 2
		_line2 = new JList<Customer>(_queue2.getDefaultList());
		_line2.setPreferredSize(new Dimension(150,250));
		c.gridx = 2;
		c.gridy = 1;
		_line2.setBackground(java.awt.Color.orange);
		center_panel.add(_line2, c);
		
		//Skapar knapp f�r att flytta kund fr�n aff�ren till k� 1. Skickar med till aktivitetslyssnaren.
		_moveToLine1 = new JButton("Flytta kund till k� 1");
		_moveToLine1.addActionListener(this);
		c.gridx = 0;
		c.gridy = 2;
		center_panel.add(_moveToLine1, c);
		
		//Skapar knapp f�r att flytta kund fr�n aff�ren till k� 2. Skickar med till aktivitetslyssnaren.
		_moveToLine2 = new JButton("Flytta kund till k� 2");
		_moveToLine2.addActionListener(this);
		c.gridx = 0;
		c.gridy = 3;
		center_panel.add(_moveToLine2, c);
		
		//Skapar knapp f�r att betj�na en kund, skickar till aktivitetslyssnaren.
		_serveQ1 = new JButton("Betj�na kund");
		_serveQ1.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2;
		center_panel.add(_serveQ1, c);
		
		//Skapar knapp f�r att betj�na en kund, skickar till aktivitetslyssnaren.
		_serveQ2 = new JButton("Betj�na kund");
		_serveQ2.addActionListener(this);
		c.gridx = 2;
		c.gridy = 2;
		center_panel.add(_serveQ2, c);
		
		//L�gger till hela center-panelen till den tidigare skapade borderlayouten.
		center_panel.setBackground(java.awt.Color.PINK);
		this.add(center_panel, BorderLayout.CENTER);
		
		
		//Panelen l�ngst ner i programmet. Skapar en panel, har en textrad som uppdateras med information om vad som h�nder (Denna uppdateras i ActionListener).
		bottom_panel = new JPanel();
		_infoText = new JLabel("L�gg till kund i aff�r");
		bottom_panel.add(_infoText);
		bottom_panel.setBackground(java.awt.Color.magenta);
		this.add(bottom_panel, BorderLayout.SOUTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _newCustomer){
			
			String name = _name.getText();
			int items = Integer.parseInt(_items.getText());
		    m1.addElement(new Customer(name,items));
		    _infoText.setText("Kund tillagd");
		
		}
		
		else if (e.getSource() == _moveToLine1) {
			
			if(!m1.isEmpty()) {
				
				_queue1.enqueue(m1.elementAt(0));
				m1.remove(0);
				_infoText.setText("Kund flyttad till k� 1");
				
			} else {
				
				_infoText.setText("Finns ingen kund att flytta!");
			}
			

		}
		
		else if (e.getSource() == _moveToLine2) {
			
			if(!m1.isEmpty()) {
				
				_queue2.enqueue(m1.elementAt(0));
				m1.remove(0);
				_infoText.setText("Kund flyttad till k� 1");
				
			} else {
				
				_infoText.setText("Finns ingen kund att flytta!");
				
			}
			
		}
		
		else if (e.getSource() == _serveQ1) {
				
			if(!_queue1.isEmpty()) {
				
				_queue1.dequeue();
				_infoText.setText("Kund i k� 1 betj�nad");
				
			} else {
				
				_infoText.setText("K�n �r tom");
				
			}
			
		}
		
		else if (e.getSource() == _serveQ2) {
			
			if(!_queue2.isEmpty()) {
				
				_queue2.dequeue();
				_infoText.setText("Kund i k� 2 betj�nad");
				
			} else {
				
				_infoText.setText("K�n �r tom");
				
			}
			
		}
	}

}
