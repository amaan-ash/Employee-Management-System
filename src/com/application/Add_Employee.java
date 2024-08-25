package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;
public class Add_Employee implements ActionListener {
Random ran=new Random();
int id=ran.nextInt(999 );
String num= String.valueOf(id);

JButton addBtn,backBtn;
JTextField inputName,inputFather,inputSalary,inputAddress,inputEmail,inputPhone,inputDesignation,inputAdhar;
JTextField inputDob;
JComboBox inputEducation;
JLabel inputEmpid;
JFrame jFrame;
DatabaseConnectionManager connectionManager;
    Add_Employee(){
        connectionManager=new DatabaseConnectionManager();

        jFrame=new JFrame();
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(900,700);
        jFrame.setLocation(300,50);
        jFrame.setTitle("Employee Management Software");

        Container c=jFrame.getContentPane();
        c.setBackground(Color.WHITE);

        JLabel heading=new JLabel();
        heading.setText("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("Calibri",Font.BOLD,25));
        jFrame.add(heading);

        JLabel labelName=new JLabel();
        labelName.setText("Name");
        labelName.setFont(new Font("serif",Font.PLAIN,20));
        labelName.setBounds(50,150,150,30);
        jFrame.add(labelName);

       inputName=new JTextField(20);
        inputName.setBounds(200,150,150,30);
        jFrame.add(inputName);

        JLabel labelFather=new JLabel();
        labelFather.setText("Father's Name");
        labelFather.setFont(new Font("serif",Font.PLAIN,20));
        labelFather.setBounds(400,150,150,30);
        jFrame.add(labelFather);

        inputFather=new JTextField(20);
        inputFather.setBounds(600,150,150,30);
        jFrame.add(inputFather);


        JLabel labelBirth=new JLabel();
        labelBirth.setText("Date of birth");
        labelBirth.setFont(new Font("serif",Font.PLAIN,20));
        labelBirth.setBounds(50,200,150,30);
        jFrame.add(labelBirth);


        inputDob=new JTextField(20);
        inputDob.setBounds(200,200,150,30);
        jFrame.add(inputDob);


        JLabel labelSalary=new JLabel();
        labelSalary.setText("Salary");
        labelSalary.setFont(new Font("serif",Font.PLAIN,20));
        labelSalary.setBounds(400,200,150,30);
        jFrame.add(labelSalary);

         inputSalary=new JTextField(20);
        inputSalary.setBounds(600,200,150,30);
        jFrame.add(inputSalary);

        JLabel labelAddress=new JLabel();
        labelAddress.setText("Address");
        labelAddress.setFont(new Font("serif",Font.PLAIN,20));
        labelAddress.setBounds(50,250,150,30);
        jFrame.add(labelAddress);

        inputAddress=new JTextField(20);
        inputAddress.setBounds(200,250,150,30);
        jFrame.add(inputAddress);

        JLabel labelPhone=new JLabel();
        labelPhone.setText("Phone");
        labelPhone.setFont(new Font("serif",Font.PLAIN,20));
        labelPhone.setBounds(400,250,150,30);
        jFrame.add(labelPhone);

        inputPhone=new JTextField(20);
        inputPhone.setBounds(600,250,150,30);
        jFrame.add(inputPhone);

        JLabel labelEmail=new JLabel();
        labelEmail.setText("Email");
        labelEmail.setFont(new Font("serif",Font.PLAIN,20));
        labelEmail.setBounds(50,300,150,30);
        jFrame.add(labelEmail);

        inputEmail=new JTextField(20);
        inputEmail.setBounds(200,300,150,30);
        jFrame.add(inputEmail);


        JLabel labelEducation=new JLabel();
        labelEducation.setText("Highest Education");
        labelEducation.setFont(new Font("serif",Font.PLAIN,20));
        labelEducation.setBounds(400,300,150,30);
        jFrame.add(labelEducation);

        String[] degree={"Diploma IT","Diploma CO","BTECH IT","BTECH CS","BE CS","BE IT","BCA","MCA","BSC IT","MBA","MTECH"};
         inputEducation=new JComboBox(degree);
        inputEducation.setBackground(Color.WHITE);
        inputEducation.setBounds(600,300,150,30);
        jFrame.add(inputEducation);

        JLabel labelDesignation=new JLabel();
        labelDesignation.setText("Designation");
        labelDesignation.setFont(new Font("serif",Font.PLAIN,20));
        labelDesignation.setBounds(50,350,150,30);
        jFrame.add(labelDesignation);

         inputDesignation=new JTextField(20);
        inputDesignation.setBounds(200,350,150,30);
        jFrame.add(inputDesignation);

        JLabel labelAdhar=new JLabel();
        labelAdhar.setText("Aadhar Number");
        labelAdhar.setFont(new Font("serif",Font.PLAIN,20));
        labelAdhar.setBounds(400,350,150,30);
        jFrame.add(labelAdhar);

         inputAdhar=new JTextField(20);
        inputAdhar.setBounds(600,350,150,30);
        jFrame.add(inputAdhar);

        JLabel labelEmpid=new JLabel();
        labelEmpid.setText("Employee Id");
        labelEmpid.setFont(new Font("serif",Font.PLAIN,20));
        labelEmpid.setBounds(50,400,150,30);
        jFrame.add(labelEmpid);

         inputEmpid=new JLabel(num);
        inputEmpid.setBounds(200,400,150,30);
        jFrame.add(inputEmpid);


        addBtn=new JButton();
        addBtn.setText("Add Details");
        addBtn.setBounds(250,550,150,40);
        addBtn.setForeground(Color.WHITE);
        addBtn.setBackground(Color.BLACK);
        jFrame.add(addBtn);


        backBtn=new JButton();
        backBtn.setText("Back");
        backBtn.setBounds(450,550,150,40);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(Color.BLACK);
        jFrame.add(backBtn);


        //adding action listeners to the buttons
        addBtn.addActionListener(this);
        backBtn.addActionListener(this);


    }
    public static void main(String[] args) {
        new Add_Employee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addBtn){
            System.out.println("add button is clicked");

            //storing the inputs from text-field to variables
            String name=inputName.getText();
            String fatherName=inputFather.getText();
            String dateofBirth=inputDob.getText();
            String salary=inputSalary.getText();
            String email=inputEmail.getText();
            String address=inputAddress.getText();
            String phone=inputPhone.getText();
            String edu= (String) inputEducation.getSelectedItem();
            String designation=inputDesignation.getText();
            String adhar=inputAdhar.getText();
            String empid=inputEmpid.getText();

            try {
                connectionManager.openConnection();
                Connection con=connectionManager.getConnection();

                String query = "INSERT into employee VALUES(?,?,?,?,?,?,?,?,?,?,?)";

                //inserting values
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setString(1, name);
                pstm.setString(2, fatherName);
                pstm.setString(3, dateofBirth);
                pstm.setString(4, salary);
                pstm.setString(5, address);
                pstm.setString(6, phone);
                pstm.setString(7, email);
                pstm.setString(8, edu);
                pstm.setString(9, designation);
                pstm.setString(10,adhar);
                pstm.setString(11,empid);

                pstm.executeUpdate();
                System.out.println(" query executed");

                connectionManager.closeConnection();
                System.out.println("connection is closed");

                JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                jFrame.setVisible(false);
                connectionManager.closeConnection();

                new DashBoard();
            }
            catch (Exception o){
                System.out.println(o);
            }
        }
        else if(e.getSource()==backBtn){
            System.out.println("back button is clicked");

            jFrame.setVisible(false);
            new DashBoard();
        }
    }
}
