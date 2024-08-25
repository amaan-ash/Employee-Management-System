package com.application;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class View_Employees implements ActionListener{

    JTable table;
    Choice choiceEmpId;
    JButton searchBtn, updateBtn, backBtn;
    JFrame jFrame;
    DatabaseConnectionManager connectionManager;

    View_Employees() {
        connectionManager=new DatabaseConnectionManager();

        jFrame=new JFrame();
        Container c=jFrame.getContentPane();
        c.setBackground(Color.white);

        jFrame.setSize(900, 700);
        jFrame.setLocation(300, 100);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setResizable(false);

        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        jFrame.add(searchlbl);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(180, 20, 150, 20);
        jFrame.add(choiceEmpId);

        try {
            connectionManager.openConnection();
            Connection con=connectionManager.getConnection();

            Statement st=con.createStatement();

            String query="select * from employee";
            ResultSet rs =st.executeQuery(query);

            while(rs.next()) {
                choiceEmpId.add(rs.getString("empId"));
            }
            connectionManager.closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            connectionManager.openConnection();
            Connection con=connectionManager.getConnection();

            Statement st=con.createStatement();

            String query="select * from employee";
            ResultSet rs = st.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

          connectionManager.closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        jFrame.add(jsp);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80, 20);
        jFrame.add(searchBtn);


        updateBtn = new JButton("Update");
        updateBtn.setBounds(120, 70, 80, 20);
        jFrame.add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(220, 70, 80, 20);
        jFrame.add(backBtn);


        //adding action listeners to the buttons
        searchBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        backBtn.addActionListener(this);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchBtn) {
            String query = "select * from employee where empId = '"+ choiceEmpId.getSelectedItem()+"'";
            try {
                connectionManager.openConnection();
                Connection con=connectionManager.getConnection();

                Statement st=con.createStatement();

                ResultSet rs = st.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

                connectionManager.closeConnection();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (ae.getSource() == updateBtn) {
            jFrame.setVisible(false);
            new UpdateEmployee(choiceEmpId.getSelectedItem());
        }
        else if(ae.getSource()== backBtn) {
            jFrame.setVisible(false);
            new DashBoard();
        }
    }

    public static void main(String[] args) {
        new View_Employees();
    }
}
