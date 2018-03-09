import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		top_panel.setBackground(java.awt.Color.cyan);
		this.add(top_panel, BorderLayout.NORTH);
		
																//Listerna i mitten av programmet
		JPanel center_panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		m1 = new DefaultListModel<Customer>();
		_queue1 = new Queue<Customer>();
		_queue2 = new Queue<Customer>();
		
		
		_inStoreList = new JList<Customer>(m1);
		_inStoreList.setPreferredSize(new Dimension(150,250));
		c.gridx = 0;
		c.gridy = 0;
		center_panel.add(_inStoreList, c);
		
		_line1 = new JList<Customer>(_queue1.getDefaultList());
		_line1.setPreferredSize(new Dimension(150,250));
		c.gridx = 1;
		c.gridy = 0;
		center_panel.add(_line1, c);
		
		_line2 = new JList<Customer>(_queue2.getDefaultList());
		_line2.setPreferredSize(new Dimension(150,250));
		c.gridx = 2;
		c.gridy = 0;
		center_panel.add(_line2, c);
		
		_moveToLine1 = new JButton("Flytta kund till kö 1");
		_moveToLine1.addActionListener(this);
		c.gridx = 0;
		c.gridy = 1;
		center_panel.add(_moveToLine1, c);
		
		_moveToLine2 = new JButton("Flytta kund till kö 2");
		_moveToLine2.addActionListener(this);
		c.gridx = 0;
		c.gridy = 2;
		center_panel.add(_moveToLine2, c);
		
		_serveQ1 = new JButton("Betjäna kund");
		_serveQ1.addActionListener(this);
		c.gridx = 1;
		c.gridy = 1;
		center_panel.add(_serveQ1, c);
		
		_serveQ2 = new JButton("Betjäna kund");
		_serveQ2.addActionListener(this);
		c.gridx = 2;
		c.gridy = 1;
		center_panel.add(_serveQ2, c);
		
		this.add(center_panel, BorderLayout.CENTER);
		
		
																//Panelen längst ner i programmet

		
		bottom_panel = new JPanel();
		_infoText = new JLabel("Lägg till kund i affär");
		bottom_panel.add(_infoText);
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
			
			_queue1.enqueue(m1.elementAt(0));
			m1.remove(0);
			_infoText.setText("Kund flyttad till kö 1");
			

		}
		else if (e.getSource() == _moveToLine2) {
			
			_queue2.enqueue(m1.elementAt(0));
			m1.remove(0);
			_infoText.setText("Kund flyttad till kö 1");
			
		}
	}

}
