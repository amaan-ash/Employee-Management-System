package com.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard implements ActionListener {

    JButton addBtn, removeBtn, viewBtn, updateBtn;
    JFrame jFrame;

    DashBoard() {
        // Initialize the frame
        jFrame = new JFrame();
        jFrame.setSize(1100, 600);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocation(250, 100);
        jFrame.setLayout(null);
        jFrame.setTitle("Employee Management Software");

        // Create a label that covers the entire frame
        JLabel l2 = new JLabel();
        l2.setBounds(0, 0, 1100, 600);

        // Set the background color of the label (container) to cyan
        l2.setOpaque(true);  // Make the label opaque so that the background color is visible
        l2.setBackground(Color.decode("#E0F7FA"));

        // Add the label to the frame
        jFrame.add(l2);

        // Title label
        JLabel j1 = new JLabel("Employee Management System");
        j1.setBounds(340, 50, 700, 60);
        j1.setForeground(Color.DARK_GRAY);
        j1.setFont(new Font("Calibri", Font.BOLD, 40));
        j1.setBackground(Color.BLACK);
        l2.add(j1);

        // Add Employee button
        addBtn = new JButton("Add Employee");
        addBtn.setBounds(415, 150, 150, 40);
        l2.add(addBtn);

        // Remove Employee button
        removeBtn = new JButton("Remove Employee");
        removeBtn.setBounds(630, 150, 150, 40);
        l2.add(removeBtn);

        // View Employees button
        viewBtn = new JButton("View Employees");
        viewBtn.setBounds(415, 250, 150, 40);
        l2.add(viewBtn);

        // Update Employee button
        updateBtn = new JButton("Update Employee");
        updateBtn.setBounds(630, 250, 150, 40);
        l2.add(updateBtn);

        // Add action listeners to the buttons
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

        if (e.getSource() == addBtn) {
            new Add_Employee();
        } else if (e.getSource() == removeBtn) {
            new Remove_Employee();
        } else if (e.getSource() == updateBtn) {
            new View_Employees();
        } else if (e.getSource() == viewBtn) {
            new View_Employees();
        }
    }
}
