package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard implements ActionListener {

    JButton addBtn,removeBtn,viewBtn,updateBtn;
    JFrame jFrame;
    DashBoard(){
         jFrame=new JFrame();
        jFrame.setSize(1100,600);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocation(250,100);
        jFrame.setLayout(null);
        jFrame.setTitle("Employee Management Software");

        ImageIcon image=new ImageIcon("C:\\Users\\Amaan Ali\\IdeaProjects\\Advance Java\\Employee Management Application\\src\\icons\\home.jpg");
        JLabel l2=new JLabel(image);
        l2.setBounds(0,0,1100,600);
        jFrame.add(l2);

        JLabel j1=new JLabel("Employee Management System");
        j1.setBounds(420,90,400,30);
        j1.setForeground(Color.darkGray);
        j1.setFont(new Font("calibri",Font.BOLD,25));
        l2.add(j1);

        addBtn=new JButton("Add Employee");
        addBtn.setBounds(415,150,150,40);
        l2.add(addBtn);

         removeBtn=new JButton("Remove Employee");
        removeBtn.setBounds(630,150,150,40);
        l2.add(removeBtn);

         viewBtn=new JButton("View Employees");
        viewBtn.setBounds(415,250,150,40);
        l2.add(viewBtn);

         updateBtn=new JButton("Update Employee");
        updateBtn.setBounds(630,250,150,40);
        l2.add(updateBtn);

        //adding action listeners to the buttons
        addBtn.addActionListener(this);
        removeBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        updateBtn.addActionListener(this);


    }
    public static void main(String[] args) {
        new DashBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.setVisible(false);

        if(e.getSource()==addBtn){
            new Add_Employee();
        }
        else if(e.getSource()==removeBtn){
            new Remove_Employee();
        }
        else if(e.getSource()==updateBtn){
            new View_Employees();
        }
        else if(e.getSource()==viewBtn) {
           new View_Employees();
        }
    }
}
