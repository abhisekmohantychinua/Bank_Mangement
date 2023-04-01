import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

public class deposit {
    deposit(String name, String cid) {
        JFrame f = new JFrame("deposit");
        JLabel depositJLabel = new JLabel("Enter amount to be deposit :");
        JTextField amounTextField = new JTextField();
        JButton okButton = new JButton("Ok");
        JButton backButton = new JButton("Back");
        Font font = new Font("Roboto", Font.PLAIN, 30);
        depositJLabel.setBounds(400, 200, 400, 40);
        depositJLabel.setFont(font);
        amounTextField.setBounds(500, 260, 200, 40);
        amounTextField.setFont(font);
        amounTextField.setBorder(BorderFactory.createEmptyBorder());
        okButton.setBounds(1100, 310, 100, 40);
        okButton.setFont(font);
        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        okButton.setBackground(new Color(8, 78, 137, 255));
        backButton.setBounds(200, 310, 100, 40);
        backButton.setFont(font);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(8, 78, 137, 255));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (amounTextField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(f, "Please enter an amount");
                } else {
                    String s = JOptionPane.showInputDialog(f, "Enter password");
                    JOptionPane.showMessageDialog(f,
                            Operation.depositMoney(cid, s, Integer.parseInt(amounTextField.getText())));
                    amounTextField.setText("");
                }
            }
        });
        okButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                okButton.setBackground(new Color(37, 150, 190));

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                okButton.setBackground(new Color(8, 78, 137, 255));

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
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                f.setVisible(false);
                new MainPage(name, cid);
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

        f.add(depositJLabel);
        f.add(amounTextField);
        f.add(backButton);
        f.add(okButton);

        f.setSize(1300, 720);
        f.getContentPane().setBackground(new Color(157, 221, 231, 255));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
}
