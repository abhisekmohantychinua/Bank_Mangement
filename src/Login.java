import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class Login {
    public Login() {
        JFrame fJFrame = new JFrame("Login");
        JLabel lJLabel = new JLabel("Login");
        JLabel userJLabel = new JLabel("Client ID : ");
        JTextField userJTextField = new JTextField(34);
        JLabel passwordJLabel = new JLabel("Password : ");
        JPasswordField pJPasswordField = new JPasswordField(8);
        JButton submiJButton = new JButton("Submit");
        JButton cJButton = new JButton("Create account");

        lJLabel.setBounds(500, 0, 400, 90);
        lJLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        userJLabel.setBounds(250, 200, 200, 80);
        userJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        userJTextField.setBounds(430, 220, 500, 40);
        userJTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        passwordJLabel.setBounds(250, 300, 200, 80);
        passwordJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        pJPasswordField.setBounds(430, 320, 500, 40);
        pJPasswordField.setFont(new Font("Arial", Font.PLAIN, 30));
        submiJButton.setBounds(500, 400, 150, 50);
        submiJButton.setFont(new Font("Arial", Font.PLAIN, 20));
        submiJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submiJButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        submiJButton.setBackground(new Color(8, 78, 137, 255));

        cJButton.setBounds(700, 400, 150, 50);
        cJButton.setFont(new Font("Arial", Font.PLAIN, 20));
        cJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cJButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        cJButton.setBackground(new Color(8, 78, 137, 255));

        fJFrame.add(lJLabel);
        fJFrame.add(userJLabel);
        fJFrame.add(userJTextField);
        fJFrame.add(passwordJLabel);
        fJFrame.add(pJPasswordField);
        fJFrame.add(submiJButton);
        fJFrame.add(cJButton);

        submiJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Operation.login(userJTextField.getText(), String.valueOf(pJPasswordField.getPassword()))) {
                    fJFrame.setVisible(false);
                } else {
                    userJTextField.setText(null);
                    pJPasswordField.setText(null);
                }
            }
        });
        submiJButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                submiJButton.setBackground(new Color(37, 150, 190));

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                submiJButton.setBackground(new Color(8, 78, 137, 255));

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
        cJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fJFrame.setVisible(false);
                new CreateAccount();
            }
        });
        cJButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                cJButton.setBackground(new Color(37, 150, 190));

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                cJButton.setBackground(new Color(8, 78, 137, 255));

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

        // finishing
        fJFrame.setSize(1300, 720);
        fJFrame.getContentPane().setBackground(new Color(157, 221, 231, 255));
        fJFrame.setLocationRelativeTo(null);
        fJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fJFrame.setLayout(null);
        fJFrame.setVisible(true);
    }

}
