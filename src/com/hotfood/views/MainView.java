package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.hotfood.controllers.LoginController;

public class MainView extends JFrame {

	public MainView() {
		this.setTitle("HOTFOOD");
		this.setBounds(100, 100, 546, 498);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);

		LoginView loginPane = new LoginView();
		LoginController loginController = new LoginController(loginPane);
		loginPane.setBounds(0, 0, 546, 498);

		layeredPane.removeAll();
		layeredPane.add(loginPane);
		layeredPane.repaint();
		layeredPane.revalidate();

	}
}
