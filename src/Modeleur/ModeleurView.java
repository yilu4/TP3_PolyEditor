/**
 * PT3 Poly Editor
 * DUT Informatique 2016/2017 
 * Auteur : HUANG Qijia
 * 			LU Yi
 * Tuteur : P. Even
 * */

package Modeleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Blueprint.Vertex;

/** 
 * class MoeleurView 
 * celui-ci construit l'interface de modeleur. 
 * */
public class ModeleurView extends JFrame {
	/** ModeleurModel qui fournit tous les variables et instances */
	private ModeleurModel mm;
	/** ModeleurController qui gere les fonctions de souris */
	private ModeleurController mc;
	
	//code Model
	private JPanel bg, toolbar, options, save;
	private Menu menu;
	private JButton bSave;
	
	
	
	public ModeleurView(String titre){
		super(titre);
		mm = new ModeleurModel();
		mc = new ModeleurController(mm);
		
		bg = new JPanel();
		bg.setLayout(new BorderLayout(10,10));
		bg.setBackground(ModeleurModel.GREY);
		bg.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// toolbar contient menu et save
		toolbar = new JPanel();
		toolbar.setLayout(new BorderLayout(10,10));
		toolbar.setBackground(ModeleurModel.DARKGREY2);
		
		// menu contient options
		menu = new Menu();
		menu.setPreferredSize(new Dimension(130*2,420*2));
		
		options = new JPanel();
		options.setBackground(ModeleurModel.DARKGREY4);
		options.setPreferredSize(new Dimension(120*2,50*2));
		
		// save contient bsave
		save = new JPanel();
		save.setBackground(ModeleurModel.DARKGREY2);
		save.setPreferredSize(new Dimension(130*2,45*2));
		
		Font font = new Font("Arial", Font.BOLD, 20);
		bSave = new JButton("ENREGISTRER");
		bSave.setFont(font);
		bSave.setForeground(ModeleurModel.BLACK);
		bSave.setBackground(ModeleurModel.DARKGREY4);
		bSave.setPreferredSize(new Dimension(110*2,70));
		bSave.setFocusPainted(false);;
		save.add(bSave);
		
		mm.graph.setPreferredSize(new Dimension(550*2,340*2));
		mm.graph.addMouseListener(mc);
		mm.graph.addMouseMotionListener(mc);
		
		toolbar.add(menu, BorderLayout.CENTER);
		toolbar.add(save, BorderLayout.SOUTH);
		
		bg.add(mm.graph, BorderLayout.CENTER);
		bg.add(toolbar, BorderLayout.WEST);
		
		this.add(bg);
		
	}
	
	
	/**
	 * 
	 * */
	class Menu extends JPanel {
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			this.setBackground(ModeleurModel.DARKGREY2);
			g.setColor(ModeleurModel.DARKGREY4);
			g.fillRoundRect(20, 20, 110*2,410*2, 50, 50);
		}
	}

}