package com.hotfood.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.hotfood.interfaces.DishListView;
import com.hotfood.models.Dish;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.util.List;
import java.util.Observable;

import java.awt.Color;

public class ResturantOwnerView extends Observable implements DishListView{
	private JPanel panel;
    private JFileChooser fileChooser;
    private JPanel innerPanel;
	private JScrollPane scroller;
	private JLabel menuHeaderLabel;
	private JButton uploadMenuBtn;
	private JButton saveBtn;
	
	public ResturantOwnerView(){
	
		
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file (.csv)","csv");
		fileChooser.setFileFilter(filter);
		
		panel = new JPanel();
		panel.setBounds(0, 50, 546, 520);;
		panel.setBackground(Color.WHITE);
		innerPanel = new JPanel();
		innerPanel.setVisible(true);
		panel.setLayout(null);

		scroller = new JScrollPane( innerPanel );
		GridBagLayout gbl_innerPanel = new GridBagLayout();
		gbl_innerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_innerPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_innerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_innerPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		innerPanel.setLayout(gbl_innerPanel);
		
		scroller.setBounds(10, 22, 520, 460);
		scroller.getViewport().setViewPosition(new Point(0,0));
		scroller.getVerticalScrollBar().setUnitIncrement(16);
		
		panel.add(scroller);
		
		menuHeaderLabel = new JLabel("Menu");
		menuHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuHeaderLabel.setBounds(133, 1, 274, 22);
		panel.add(menuHeaderLabel);
		
		uploadMenuBtn = new JButton("Upload Menu");
		uploadMenuBtn.setBounds(10, 0, 113, 23);
		panel.add(uploadMenuBtn);
		
		uploadMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(panel);
		        if (result == JFileChooser.APPROVE_OPTION) {
		        	activeDeactiveButtons(false);
		        	setChanged();
		        	notifyObservers(fileChooser.getSelectedFile());
		        } 
			}
		});
		
		
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveBtn.setEnabled(false);
				setChanged();
				notifyObservers();
			}
		});
		saveBtn.setBounds(417, 0, 113, 22);
		panel.add(saveBtn);
		
		activeDeactiveButtons(false);
	}
	
	@Override
	public JPanel getView() {
		return panel;
	}
	
	public void printDishes(List<Dish> dishes) {
		this.scroller.setVisible(false);
		activeDeactiveButtons(true);
		this.innerPanel.removeAll();
		for(int i=0;i<dishes.size();i++) {
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = i+1;
			this.innerPanel.add(new DishRender(i,dishes.get(i),this),gbc_panel);
		}
		
		this.innerPanel.repaint();
		this.innerPanel.revalidate();

		Thread scrollTop=new Thread(){
	          public void run() {
	              try{
	                  Thread.sleep(200);
	                  scroller.setVisible(true);
	                  scroller.getViewport().setViewPosition( new Point(0, 0) );
	              } catch(InterruptedException v){System.out.println(v);}
	          }
	      };
	      scrollTop.start();
	}

	public void activeDeactiveButtons(boolean active) {
		this.uploadMenuBtn.setEnabled(active);
		this.saveBtn.setEnabled(active);
	}
	
	public void setHeader(String string) {
		
	}

	@Override
	public boolean customerMode() {
		return false;
	}

	@Override
	public void addDish(int index, int option) {
		
	}

}