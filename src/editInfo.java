import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;




public class editInfo {
    editInfo(String name, String cid) {
        Details d=Operation.getDetail(cid);
        JFrame f = new JFrame("Edit information");
        JLabel namLabel = new JLabel("Name :");
        JTextField namArea=new JTextField(d.name);
        JLabel phonLabel=new JLabel("Phone :");
        JTextField phonArea=new JTextField(d.phone);
        JLabel emaiLabel=new JLabel("Email :");
        JTextField emailArea=new JTextField(d.email);
        JLabel dobJLabel = new JLabel("Date of birth : ");
        JComboBox dateBox = new JComboBox<>(Tools.dateString());
        JComboBox monthBox = new JComboBox<>(Tools.monthString());
        JComboBox yearBox = new JComboBox<>(Tools.yeaString());
        ButtonGroup gendeGroup = new ButtonGroup();
        JLabel genderJLabel = new JLabel("Gender");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JButton okButton = new JButton("OK");
        JButton backButton = new JButton("Back");
        dateBox.setSelectedIndex(Tools.stringDate(d.dob));
        monthBox.setSelectedIndex(Tools.stringMonth(d.dob));
        yearBox.setSelectedIndex(Tools.stringYear(d.dob));

        namLabel.setBounds(200, 200, 200, 40);
        namLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        namArea.setBounds(450, 200, 400, 40);
        namArea.setFont(new Font("Arial", Font.PLAIN, 30));
        phonLabel.setBounds(200, 250, 200, 40);
        phonLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        phonArea.setBounds(450, 250, 400, 40);
        phonArea.setFont(new Font("arial", Font.PLAIN, 30));
        emaiLabel.setBounds(200, 300, 200, 40);
        emaiLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        emailArea.setBounds(450, 300, 400, 40);
        emailArea.setFont(new Font("Arial", Font.PLAIN, 30));
        genderJLabel.setBounds(200, 350, 200, 40);
        genderJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        maleButton.setBounds(450, 350, 200, 40);
        maleButton.setFont(new Font("Arial", Font.PLAIN, 30));
        maleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        femaleButton.setBounds(650, 350, 200, 40);
        femaleButton.setFont(new Font("Arial", Font.PLAIN, 30));
        femaleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dobJLabel.setBounds(200, 400, 200, 40);
        dobJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        dateBox.setBounds(450, 400, 80, 40);
        dateBox.setFont(new Font("Arial", Font.PLAIN, 30));
        monthBox.setBounds(530, 400, 220, 40);
        monthBox.setFont(new Font("Arial", Font.PLAIN, 30));
        yearBox.setBounds(750, 400, 100, 40);
        yearBox.setFont(new Font("Arial", Font.PLAIN, 30));
        okButton.setBounds(900, 600, 150, 50);
        okButton.setFont(new Font("Arial", Font.PLAIN, 30));
        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        okButton.setBackground(new Color(8, 78, 137, 255));
        backButton.setBounds(200, 600, 150, 50);
        backButton.setFont(new Font("Arial", Font.PLAIN, 30));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(8, 78, 137, 255));
        if (d.gender.equals("Male")) {
            maleButton.setSelected(true);
        } else {
            femaleButton.setSelected(true);
        }
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
                backButton.setBackground(new Color(37,150,190));
                
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                backButton.setBackground(new Color(8,78,137,255));
                
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
        okButton.addMouseListener(new MouseListener() {       
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                okButton.setBackground(new Color(37,150,190));
                
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                okButton.setBackground(new Color(8,78,137,255));
                
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
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int opt=JOptionPane.showConfirmDialog(f, "Are you confirm to update?");
                if (opt == 0) {
                    int d = dateBox.getSelectedIndex() + 1;
                        int m = monthBox.getSelectedIndex() + 1;
                        int y = 2005 - yearBox.getSelectedIndex();
                        String date = Tools.getDate(y, m, d);
                    Details details = new Details(namArea.getText(), phonArea.getText(),
                            maleButton.isSelected() ? "Male" : "Female", date, emailArea.getText());
                    JOptionPane.showMessageDialog(f, Operation.editDetail(details,cid) );
                    f.setVisible(false);
                    new MainPage(name, cid);
                }
                else if (opt == 1) {
                    
                }
                else {
                    f.setVisible(false);
                    new MainPage(name, cid);
                }
            }
        });
        

        gendeGroup.add(femaleButton);
        gendeGroup.add(maleButton);
        f.add(femaleButton);
        f.add(maleButton);
        f.add(namArea);
        f.add(namLabel);
        f.add(phonArea);
        f.add(phonLabel);
        f.add(emaiLabel);
        f.add(emailArea);
        f.add(genderJLabel);
        f.add(dobJLabel);
        f.add(dateBox);
        f.add(monthBox);
        f.add(yearBox);
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
