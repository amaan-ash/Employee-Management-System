package com.application;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Remove_Employee implements ActionListener {
    DatabaseConnectionManager connectionManager;
    Choice cEmpId;
    JButton deleteBtn, backBtn;
    JFrame jFrame;

    Remove_Employee() {
        connectionManager=new DatabaseConnectionManager();
        jFrame=new JFrame();

        jFrame.setSize(1000, 400);
        jFrame.setLocation(300, 150);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setTitle("Employee Management Software");
        jFrame.setResizable(false);

        Container c=jFrame.getContentPane();
        c.setBackground(Color.white);


        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 100, 30);
        jFrame.add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        jFrame.add(cEmpId);

        //here we are first time adding only adding the empid
        try {
            connectionManager.openConnection();
            Connection con=connectionManager.getConnection();

            Statement st=con.createStatement();
            String query = "select * from employee";
            ResultSet rs =st.executeQuery(query);

            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        jFrame.add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        jFrame.add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        jFrame.add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        jFrame.add(lblphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        jFrame.add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        jFrame.add(lblemail);

        //here we are first time displaying the details of the employee with the help of employee id
        try {
            connectionManager.openConnection();
            Connection con=connectionManager.getConnection();
            Statement st=con.createStatement();

            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //here we are displaying the details of each employee everytime the choice is changed
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    connectionManager.openConnection();
                    Connection con=connectionManager.getConnection();

                    Statement st=con.createStatement();

                    String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //delete button
        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(80, 300, 100,30);
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.addActionListener(this);
        jFrame.add(deleteBtn);

        //back button
        backBtn = new JButton("Back");
        backBtn.setBounds(220, 300, 100,30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        jFrame.add(backBtn);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Amaan Ali\\IdeaProjects\\Advance Java\\Employee Management Application\\src\\icons\\delete.png");
        JLabel image = new JLabel(i1);
        image.setBounds(400, 0, 600, 400);
        jFrame.add(image);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteBtn) {
            try {
              int value =  JOptionPane.showConfirmDialog(null,"Do you really want to remove employee?");
              if(value==0){
                  System.out.println("yes is clicked");

                  connectionManager.openConnection();
                  Connection con=connectionManager.getConnection();
                  Statement st=con.createStatement();

                  String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                  st.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");

                  connectionManager.closeConnection();
                  System.out.println("connection is closed");

                  jFrame.setVisible(false);
                  new DashBoard();
              }
              else {
                  System.out.println("no is clicked");
              }


            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==backBtn){
            jFrame.setVisible(false);
            new DashBoard();
        }
    }

    public static void main(String[] args) {
        new Remove_Employee();
    }
}
