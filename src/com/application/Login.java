package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener {
    JTextField jTextField;
    JPasswordField jPasswordField;
    JFrame jFrame;
    DatabaseConnectionManager connectionManager;

    Login(){
        connectionManager=new DatabaseConnectionManager();

        jFrame=new JFrame();
        jFrame.setSize(600,300);
        jFrame.setLocation(450,200);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setTitle("Employee Management Software");


        Container c=jFrame.getContentPane();
        c.setBackground(Color.WHITE);

        JLabel username=new JLabel("Username");
        username.setBounds(40,20,100,30);
        jFrame.add(username);

        JLabel password=new JLabel("Password");
        password.setBounds(40,60,100,30);
        jFrame.add(password);

         jTextField=new JTextField(30);
        jTextField.setBounds(120,20,150,30);
        jFrame.add(jTextField);


        jPasswordField=new JPasswordField(30);
        jPasswordField.setBounds(120,60,150,30);
        jFrame.add(jPasswordField);

        JButton loginBtn=new JButton("Login");
        loginBtn.setBounds(100,130,140,30);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(this);//adding action listener to button
        jFrame.add(loginBtn);


        String filename="C:\\Users\\Amaan Ali\\IdeaProjects\\Advance Java\\Employee Management Application\\src\\icons\\second.jpg";
        ImageIcon i1=new ImageIcon(filename);

        JLabel l2=new JLabel(i1);
        l2.setBounds(350,0,200,400);
        jFrame.add(l2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //getting the input from the user(admin) and storing the credentials in variables
            String username=jTextField.getText();
            String password=jPasswordField.getText();

            connectionManager.openConnection();
            Connection con=connectionManager.getConnection();

            String query = "SELECT * FROM login WHERE username = ? AND password = ?";

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet resultSet = pstm.executeQuery();

            //if username and password is present in the ResultSet then it will move to next class
            if(resultSet.next()){
                jFrame.setVisible(false);
                new DashBoard();
            }
            else {
                JOptionPane.showMessageDialog(null,"invalid username or password");
                jFrame.setVisible(false);
            }
            connectionManager.closeConnection();
        }
        catch (Exception obj){
            System.out.println(obj);
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}