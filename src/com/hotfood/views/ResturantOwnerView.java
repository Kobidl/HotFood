package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hotfood.handlers.JFilePicker;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ResturantOwnerView extends JFrame {
	private JPanel contentPane;

	
	 public ResturantOwnerView() {
		 
		    
	        getContentPane().setLayout(new FlowLayout());
	        
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(200, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
	         
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(0, 0, 0, 0);
			contentPane.add(layeredPane);
			layeredPane.setLayout(new CardLayout(0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			layeredPane.add(panel, "name_36958296240000");
			panel.setLayout(null);
			
	        
			this.setTitle("HOTFOOD");
			this.setBounds(100, 100, 546, 498);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
	        // set up a file picker component
	        JFilePicker filePicker = new JFilePicker("Upload Menu");
	        filePicker.setBounds(0, 16, 488, 249);
	        filePicker.setMode(JFilePicker.MODE_SAVE);
	        filePicker.addFileTypeFilter(".jpg", "JPEG Images");
	        filePicker.addFileTypeFilter(".mp4", "MPEG-4 Videos");
	         
	        // access JFileChooser class directly
	        JFileChooser fileChooser = filePicker.getFileChooser();
	        fileChooser.setCurrentDirectory(new File("D:/"));
	         
	        // add the component to the frame
	        getContentPane().add(filePicker);
	         
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(520, 315);
	        setLocationRelativeTo(null);    // center on screen
	    }
	     
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new ResturantOwnerView().setVisible(true);
	            }
	        });
	    }
	 
	
}
	
	
	
