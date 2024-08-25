package com.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{

    JTextField inputEducation, fatherInput, addressInput, phoneInput, aadharInput, emailInput, salaryInput, designationInput;
    JLabel labelEmpID;
    JButton addBtn, backBtn;
    String empId;
    DatabaseConnectionManager connectionManager;

    UpdateEmployee(String empId) {
        connectionManager=new DatabaseConnectionManager();

        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
        setResizable(false);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 150, 150, 30);
        labelName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelName);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        fatherInput = new JTextField();
        fatherInput.setBounds(600, 150, 150, 30);
        add(fatherInput);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel labelSalary = new JLabel("Salary");
        labelSalary.setBounds(400, 200, 150, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);

        salaryInput = new JTextField();
        salaryInput.setBounds(600, 200, 150, 30);
        add(salaryInput);

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(50, 250, 150, 30);
        labelAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAddress);

        addressInput = new JTextField();
        addressInput.setBounds(200, 250, 150, 30);
        add(addressInput);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(400, 250, 150, 30);
        labelPhone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelPhone);

        phoneInput = new JTextField();
        phoneInput.setBounds(600, 250, 150, 30);
        add(phoneInput);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 300, 150, 30);
        labelEmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmail);

        emailInput = new JTextField();
        emailInput.setBounds(200, 300, 150, 30);
        add(emailInput);

        JLabel labelEducation = new JLabel("Higest Education");
        labelEducation.setBounds(400, 300, 150, 30);
        labelEducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEducation);

        inputEducation = new JTextField();
        inputEducation.setBounds(600, 300, 150, 30);
        add(inputEducation);

        JLabel labelDesignation = new JLabel("Designation");
        labelDesignation.setBounds(50, 350, 150, 30);
        labelDesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelDesignation);

        designationInput = new JTextField();
        designationInput.setBounds(200, 350, 150, 30);
        add(designationInput);

        JLabel labelAdhar = new JLabel("Aadhar Number");
        labelAdhar.setBounds(400, 350, 150, 30);
        labelAdhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelAdhar);

        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);

        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        labelEmpID = new JLabel();
        labelEmpID.setBounds(200, 400, 150, 30);
        labelEmpID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpID);

        try {
            connectionManager.openConnection();
            Connection con=connectionManager.getConnection();

            Statement st=con.createStatement();

            String query = "select * from employee where empid = '"+empId+"'";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                fatherInput.setText(rs.getString("father"));
                lbldob.setText(rs.getString("dob"));
                addressInput.setText(rs.getString("address"));
                salaryInput.setText(rs.getString("salary"));
                phoneInput.setText(rs.getString("phone"));
                emailInput.setText(rs.getString("email"));
                inputEducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("adhar"));
                labelEmpID.setText(rs.getString("empid"));
                designationInput.setText(rs.getString("designation"));

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //setting up update button
        addBtn = new JButton("Update Details");
        addBtn.setBounds(250, 550, 150, 40);
        addBtn.addActionListener(this);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        add(addBtn);

        //setting up back button
        backBtn = new JButton("Back");
        backBtn.setBounds(450, 550, 150, 40);
        backBtn.addActionListener(this);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        add(backBtn);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            String fname = fatherInput.getText();
            String salary = salaryInput.getText();
            String address = addressInput.getText();
            String phone = phoneInput.getText();
            String email = emailInput.getText();
            String education = inputEducation.getText();
            String designation = designationInput.getText();

            try {
                connectionManager.openConnection();
                Connection con=connectionManager.getConnection();


                String query = "UPDATE employee SET father = ?, salary = ?, address = ?, phone = ?, email = ?, education = ?, designation = ? WHERE empid = ?";

                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, fname);
                preparedStatement.setString(2, salary);
                preparedStatement.setString(3, address);
                preparedStatement.setString(4, phone);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, education);
                preparedStatement.setString(7, designation);
                preparedStatement.setString(8, empId);

                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                connectionManager.closeConnection();

                new DashBoard();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new DashBoard();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
