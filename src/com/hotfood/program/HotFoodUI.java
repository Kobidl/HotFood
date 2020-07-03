package com.hotfood.program;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.hotfood.controllers.MainController;
import com.hotfood.models.MainModel;
import com.hotfood.views.LoginView;
import com.hotfood.views.MainView;

import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;

public class HotFoodUI {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView mainView = new MainView();
//					MainModel mainModel = new MainModel();
//					MainController mainController = new MainController(mainView,mainModel);
					
					mainView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public static JFrame createMainUI() {
		
		return new MainView();
	}
	



}
