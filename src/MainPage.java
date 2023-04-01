import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

public class MainPage {

    public MainPage(String name, String cid) {
        JFrame f = new JFrame("Operation");
        JLabel titJLabel = new JLabel("Welcome Mr/Mrs " + name);
        JButton chekButton = new JButton("Check Balance");
        JButton withdrawButton = new JButton("Withdraw");
        JButton deposButton = new JButton("Deposit");
        JButton viewtransactiButton = new JButton("View Transactions");
        JButton infoButton = new JButton("Edit Information");
        Font fo = new Font("Arial", Font.PLAIN, 30);
        JButton backButton = new JButton("Back");
        JButton changepButton = new JButton("Change Password");

        titJLabel.setBounds(100, 20, 1100, 80);
        titJLabel.setFont(new Font("Arial", Font.PLAIN, 45));
        chekButton.setBounds(250, 200, 350, 50);
        chekButton.setFont(fo);
        withdrawButton.setBounds(250, 270, 350, 50);
        withdrawButton.setFont(fo);
        deposButton.setBounds(250, 340, 350, 50);
        deposButton.setFont(fo);
        viewtransactiButton.setBounds(700, 200, 350, 50);
        viewtransactiButton.setFont(fo);
        infoButton.setBounds(700, 270, 350, 50);
        infoButton.setFont(fo);
        changepButton.setBounds(700, 340, 350, 50);
        changepButton.setFont(fo);
        backButton.setBounds(200, 600, 150, 50);
        backButton.setFont(new Font("Arial", Font.PLAIN, 30));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(8, 78, 137, 255));

        chekButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog(f, "Enter Password");
                JOptionPane.showMessageDialog(f, Operation.showBalance(cid, s));

            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                f.setVisible(false);
                new withdraw(name, cid);
            }
        });
        deposButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                f.setVisible(false);
                new deposit(name, cid);
            }
        });
        viewtransactiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String s = JOptionPane.showInputDialog(f, "Enter password");
                JOptionPane.showMessageDialog(f, Operation.fetchTransactioString(cid, s));
            }
        });
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                f.setVisible(false);
                new editInfo(name, cid);
            }
        });
        changepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                f.setVisible(false);
                new changePassword(name, cid);
            }
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                // TODO Auto-generated method stub
                new Login();
            }
        });
        backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                backButton.setBackground(new Color(37, 150, 190));

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                backButton.setBackground(new Color(8, 78, 137, 255));

            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        f.add(titJLabel);
        f.add(chekButton);
        f.add(withdrawButton);
        f.add(deposButton);
        f.add(viewtransactiButton);
        f.add(infoButton);
        f.add(backButton);
        f.add(changepButton);

        f.setSize(1300, 720);
        f.getContentPane().setBackground(new Color(157, 221, 231, 255));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }

}