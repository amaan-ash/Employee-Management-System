package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//this is the coding of splash screen of my application
public class Splash implements ActionListener {
    JFrame jFrame;
    Splash(){
        //creating a JFrame
        jFrame=new JFrame();
        jFrame.setSize(1170,650);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setLocation(200,50);
        jFrame.setTitle("Employee Management Software");



        //creating a label
        JLabel heading=new JLabel();
        heading.setText("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(150,30,1200,60);
        heading.setFont(new Font("calibri",Font.BOLD,60));
        heading.setForeground(Color.BLACK);
        heading.setToolTipText("Welcome to The Employee Management System, Thankyou");
        jFrame.add(heading);


        ImageIcon i1=new ImageIcon("C:\\Users\\Amaan Ali\\IdeaProjects\\Advance Java\\Employee Management Application\\src\\icons\\front.jpg");

        JLabel l2=new JLabel(i1);
        l2.setBounds(50,100,1050,500);
        jFrame.add(l2);

        JButton continueButton=new JButton();
        continueButton.setText("Click Here to Continue");
        continueButton.setBounds(400,400,300,70);
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(this);
        l2.add(continueButton);




    }
    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new Splash();
    }


}
