/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
 
import java.awt.Color;
 
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
 

import static javax.swing.JFrame.EXIT_ON_CLOSE;
 
public class ChatBot extends JFrame implements KeyListener{
 
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
 

 
	public static void main(String[] args){
		new ChatBot();
	}
 
	public ChatBot(){
		super("Chat Bot");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
 
		dialog.setEditable(false);
		
 
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(255,200,0));
		add(p);
 
		setVisible(true);
	}
 
       
	public void keyPressed(KeyEvent e){
		
	}
 
	public void keyReleased(KeyEvent e){

	}
 
	public void keyTyped(KeyEvent e){}
 
	
}