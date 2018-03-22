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
																//Panelen högst upp i programmet.
		_newCustomer = new JButton("Lägg till kund");
		_newCustomer.addActionListener(this);
		
		_name = new JTextField("Skriv namn här:", 15);
		_items = new JTextField("Skriv antal varor:", 15);
		
		top_panel = new JPanel();
		top_panel.add(_name);
		top_panel.add(_items);
		top_panel.add(_newCustomer);
		top_panel.setBackground(java.awt.Color.red);
		this.add(top_panel, BorderLayout.NORTH);
		
																//Listerna i mitten av programmet
		JPanel center_panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Lägger till mellanrum mellan köerna
		c.insets = new Insets(2,2,2,2);
		
		//Skapar en lista och två köer
		m1 = new DefaultListModel<Customer>();
		_queue1 = new Queue<Customer>();
		_queue2 = new Queue<Customer>();
		
		//Text som visar listan med kunderna i affären.
		_infoStore = new JLabel("Kunder i affären");
		c.gridx = 0;
		c.gridy = 0;
		center_panel.add(_infoStore, c);
		
		//Skapar listan i affären
		_inStoreList = new JList<Customer>(m1);
		_inStoreList.setPreferredSize(new Dimension(150,250));
		c.gridx = 0;
		c.gridy = 1;
		_inStoreList.setBackground(java.awt.Color.cyan);
		center_panel.add(_inStoreList, c);
		
		//Text som visar första kön
		_infoLine1 = new JLabel("Kunder i kö 1");
		c.gridx = 1;
		c.gridy = 0;
		center_panel.add(_infoLine1, c);
		
		//Skapar första kön
		_line1 = new JList<Customer>(_queue1.getDefaultList());
		_line1.setPreferredSize(new Dimension(150,250));
		c.gridx = 1;
		c.gridy = 1;
		_line1.setBackground(java.awt.Color.orange);
		center_panel.add(_line1, c);
		
		//Text som visar vilken som är kö 2
		_infoLine2 = new JLabel("Kunder i kö 2");
		c.gridx = 2;
		c.gridy = 0;
		center_panel.add(_infoLine2, c);
		
		//skapar kö 2
		_line2 = new JList<Customer>(_queue2.getDefaultList());
		_line2.setPreferredSize(new Dimension(150,250));
		c.gridx = 2;
		c.gridy = 1;
		_line2.setBackground(java.awt.Color.orange);
		center_panel.add(_line2, c);
		
		//Skapar knapp för att flytta kund från affären till kö 1. Skickar med till aktivitetslyssnaren.
		_moveToLine1 = new JButton("Flytta kund till kö 1");
		_moveToLine1.addActionListener(this);
		c.gridx = 0;
		c.gridy = 2;
		center_panel.add(_moveToLine1, c);
		
		//Skapar knapp för att flytta kund från affären till kö 2. Skickar med till aktivitetslyssnaren.
		_moveToLine2 = new JButton("Flytta kund till kö 2");
		_moveToLine2.addActionListener(this);
		c.gridx = 0;
		c.gridy = 3;
		center_panel.add(_moveToLine2, c);
		
		//Skapar knapp för att betjäna en kund, skickar till aktivitetslyssnaren.
		_serveQ1 = new JButton("Betjäna kund");
		_serveQ1.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2;
		center_panel.add(_serveQ1, c);
		
		//Skapar knapp för att betjäna en kund, skickar till aktivitetslyssnaren.
		_serveQ2 = new JButton("Betjäna kund");
		_serveQ2.addActionListener(this);
		c.gridx = 2;
		c.gridy = 2;
		center_panel.add(_serveQ2, c);
		
		//Lägger till hela center-panelen till den tidigare skapade borderlayouten.
		center_panel.setBackground(java.awt.Color.PINK);
		this.add(center_panel, BorderLayout.CENTER);
		
		
		//Panelen längst ner i programmet. Skapar en panel, har en textrad som uppdateras med information om vad som händer (Denna uppdateras i ActionListener).
		bottom_panel = new JPanel();
		_infoText = new JLabel("Lägg till kund i affär");
		bottom_panel.add(_infoText);
		bottom_panel.setBackground(java.awt.Color.magenta);
		this.add(bottom_panel, BorderLayout.SOUTH);
		
	}
	
	//Händelsehantering
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _newCustomer){ //Om knappen "lägg till kund" används går programmet in i if-satsen. 
			try {
			String name = _name.getText();
			int items = Integer.parseInt(_items.getText());
		    m1.addElement(new Customer(name,items)); //Lägger ihop namn och antal varor i samma sträng genom toString som finns i Customer-klassen.
			_infoText.setText("Kund tillagd");		 //Lägger sedan till den strängen till m1 som är en lista på kunder i affären
			}
		    catch (NumberFormatException ie) { //Fångar upp undantag om felaktig inmatning av heltal i _items textfältet.
		    	
		    	_infoText.setText("Felaktig inmatning av antal varor.");
		    
		    }
			catch (Exception ye) { //Fångar upp övriga fel som kan uppstå. (Inte kommit fram något så bara säkerhet)
				
				_infoText.setText("Inmatning felaktig.");
				
			}
		
		}
		
		else if (e.getSource() == _moveToLine1) { //går in i satsen om _moteToLine1 används.
			
			if(!m1.isEmpty()) { //Kontrollerar om listan är tom, annars går den in.
							
				if(_inStoreList.getSelectedIndex() >= 0) {
					
					//Lägger till från listan till kön och tar bort elmentet från listan.
					_queue1.enqueue(m1.elementAt(_inStoreList.getSelectedIndex()));
					m1.remove(_inStoreList.getSelectedIndex());
					_infoText.setText("Kund flyttad till kö 1");
					
				} else {
					
					_infoText.setText("Du måste markera en kund att flytta");
					
				}
				
			} else {
				
				_infoText.setText("Finns ingen kund att flytta!");
			}
			

		}
		
		else if (e.getSource() == _moveToLine2) { //går in i satsen om _moteToLine1 används.
			
			//Kontrollerar om listan är tom, annars går den in.
			if(!m1.isEmpty()) {
				
				if(_inStoreList.getSelectedIndex() >= 0) {
				
					//Lägger till från listan till kön och tar bort elmentet från listan.
					_queue2.enqueue(m1.elementAt(_inStoreList.getSelectedIndex()));
					m1.remove(_inStoreList.getSelectedIndex());
					_infoText.setText("Kund flyttad till kö 1");
				
				} else {
					
					_infoText.setText("Du måste markera en kund att flytta");
					
				}
				
			} else {
				
				_infoText.setText("Finns ingen kund att flytta!");
				
			}
			
		}
		
		else if (e.getSource() == _serveQ1) { //Aktiveras när kö 1 betjänas
				
			if(!_queue1.isEmpty()) { //Kontrollera ratt kön inte är tom.
				
				//Tar bort kund ur kön
				_infoText.setText("\"" + _queue1.dequeue() + "\"" + " är nu betjänad");
				
				
			} else {
				
				_infoText.setText("Kön är tom");
				
			}
			
		}
		
		else if (e.getSource() == _serveQ2) { //Aktiveras när kö 2 betjänas
			
			if(!_queue2.isEmpty()) { //Kontrollerar att kön inte är tom.
				
				//Tar bort kund ur kön
				_infoText.setText("\"" + _queue2.dequeue() + "\"" + " är nu betjänad");
				
			} else {
				
				_infoText.setText("Kön är tom");
				
			}
			
		}
	}

}
