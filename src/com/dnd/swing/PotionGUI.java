/**
 * Copyright 2016 Dillon Lynch
 */
package com.dnd.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.dnd.util.PotionBuilder;

public class PotionGUI extends JFrame {

	private JPanel panel;
	private GroupLayout layout;
	private JTextArea area;
	
	public PotionGUI() {
		initialize();
	}

	private void initialize() {
		area = new JTextArea();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		JLabel title = new JLabel("Welcome to the Random Potion Generator");
		JLabel credits = new JLabel("Credit for content goes to reddit user olirant");
		JButton button = new JButton("Generate");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String p = PotionBuilder.getInstance().buildPotion();
					area.setText(p);
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(title).addComponent(credits).addComponent(button).addComponent(area)));

		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addComponent(title)
				.addComponent(credits)
				.addComponent(button)
				.addComponent(area)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)));
		pack();
		setSize(750, 350);
		setVisible(true);
	}

}
