import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class changePassword {

    changePassword(String name, String cid) {

        JFrame f = new JFrame("Change Password");
        JLabel opLabel = new JLabel("Old Password :");
        JPasswordField opArea = new JPasswordField();
        JLabel npLabel = new JLabel("New Password :");
        JPasswordField npArea = new JPasswordField();
        JLabel repJLabel = new JLabel("Re-enter Password :");
        JPasswordField repArea = new JPasswordField();
        JButton okButton = new JButton("OK");
        JButton backButton = new JButton("Back");
        Font font = new Font("Roboto", Font.PLAIN, 30);
        opLabel.setBounds(250, 200, 450, 40);
        opArea.setBounds(550, 200, 450, 40);
        npLabel.setBounds(250, 250, 450, 40);
        npArea.setBounds(550, 250, 450, 40);
        repJLabel.setBounds(250, 300, 450, 40);
        repArea.setBounds(550, 300, 450, 40);
        okButton.setBounds(900, 350, 150, 50);
        okButton.setFont(new Font("Arial", Font.PLAIN, 30));
        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        okButton.setBackground(new Color(8, 78, 137, 255));
        backButton.setBounds(200, 600, 150, 50);
        backButton.setFont(new Font("Arial", Font.PLAIN, 30));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(8, 78, 137, 255));

        opLabel.setFont(font);
        opArea.setFont(font);
        npArea.setFont(font);
        npLabel.setFont(font);
        repArea.setFont(font);
        repJLabel.setFont(font);

        f.add(repArea);
        f.add(repJLabel);
        f.add(npArea);
        f.add(npLabel);
        f.add(opArea);
        f.add(opLabel);
        f.add(okButton);
        f.add(backButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (Operation.changePString(cid, Tools.intoString(opArea.getPassword()),
                        Tools.intoString(npArea.getPassword()),
                        Tools.intoString(repArea.getPassword()))) {
                    JOptionPane.showMessageDialog(f, "Update successful");
                    f.setVisible(false);
                    new MainPage(name, cid);
                } else {
                    JOptionPane.showMessageDialog(f, "Update unsuccessful");
                    f.setVisible(false);
                    new MainPage(name, cid);
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

        f.setSize(1300, 720);
        f.getContentPane().setBackground(new Color(157, 221, 231, 255));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }
}
