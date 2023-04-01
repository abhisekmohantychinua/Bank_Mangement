import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class CreateAccount {

    CreateAccount() {
        JFrame f = new JFrame("Create Account");
        JLabel titJLabel = new JLabel("Create Account");
        JLabel namLabel = new JLabel("Name : ");
        JTextField namField = new JTextField(null);
        JLabel passJLabel = new JLabel("Password : ");
        JPasswordField pass1Field = new JPasswordField(null);
        JPasswordField pass2Field = new JPasswordField(null);
        JLabel phonJLabel = new JLabel("Phone no : ");
        JTextField phonField = new JTextField(null);
        JLabel depositJLabel = new JLabel("First Deposit : ");
        JTextField deposTextField = new JTextField(null);
        JButton submiJButton = new JButton("Submit");
        JLabel emaiJLabel = new JLabel("Email : ");
        JTextField emaiJTextField = new JTextField(null);
        JLabel dobJLabel = new JLabel("Date of birth : ");
        JComboBox dateBox = new JComboBox<>(Tools.dateString());
        JComboBox monthBox = new JComboBox<>(Tools.monthString());
        JComboBox yearBox = new JComboBox<>(Tools.yeaString());
        ButtonGroup gendeGroup = new ButtonGroup();
        JLabel genderJLabel = new JLabel("Gender");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JCheckBox termBox = new JCheckBox("     Accept terms and conditions.");
        JButton backButton = new JButton("Back");

        titJLabel.setBounds(350, 0, 600, 70);
        titJLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        namLabel.setBounds(200, 100, 200, 40);
        namLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        namField.setBounds(450, 100, 400, 40);
        namField.setFont(new Font("Arial", Font.PLAIN, 30));
        passJLabel.setBounds(200, 150, 200, 40);
        passJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        pass1Field.setBounds(450, 150, 400, 40);
        pass1Field.setFont(new Font("Arial", Font.PLAIN, 30));
        pass2Field.setBounds(450, 200, 400, 40);
        pass2Field.setFont(new Font("Arial", Font.PLAIN, 30));
        phonJLabel.setBounds(200, 250, 200, 40);
        phonJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        phonField.setBounds(450, 250, 400, 40);
        phonField.setFont(new Font("arial", Font.PLAIN, 30));
        emaiJLabel.setBounds(200, 300, 200, 40);
        emaiJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        emaiJTextField.setBounds(450, 300, 400, 40);
        emaiJTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        depositJLabel.setBounds(200, 350, 200, 40);
        depositJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        deposTextField.setBounds(450, 350, 400, 40);
        deposTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        genderJLabel.setBounds(200, 400, 200, 40);
        genderJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        maleButton.setBounds(450, 400, 200, 40);
        maleButton.setFont(new Font("Arial", Font.PLAIN, 30));
        maleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        femaleButton.setBounds(650, 400, 200, 40);
        femaleButton.setFont(new Font("Arial", Font.PLAIN, 30));
        femaleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dobJLabel.setBounds(200, 450, 200, 40);
        dobJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        dateBox.setBounds(450, 450, 80, 40);
        dateBox.setFont(new Font("Arial", Font.PLAIN, 30));
        monthBox.setBounds(530, 450, 220, 40);
        monthBox.setFont(new Font("Arial", Font.PLAIN, 30));
        yearBox.setBounds(750, 450, 100, 40);
        yearBox.setFont(new Font("Arial", Font.PLAIN, 30));
        termBox.setBounds(300, 500, 500, 40);
        termBox.setFont(new Font("Arial", Font.PLAIN, 30));
        termBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submiJButton.setBounds(800, 600, 150, 50);
        submiJButton.setFont(new Font("Arial", Font.PLAIN, 30));
        submiJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submiJButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        submiJButton.setBackground(new Color(8, 78, 137, 255));
        backButton.setBounds(200, 600, 150, 50);
        backButton.setFont(new Font("Arial", Font.PLAIN, 30));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backButton.setBackground(new Color(8, 78, 137, 255));

        gendeGroup.add(maleButton);
        gendeGroup.add(femaleButton);
        f.add(titJLabel);
        f.add(namLabel);
        f.add(namField);
        f.add(passJLabel);
        f.add(pass1Field);
        f.add(pass2Field);
        f.add(phonJLabel);
        f.add(phonField);
        f.add(deposTextField);
        f.add(depositJLabel);
        f.add(submiJButton);
        f.add(termBox);
        f.add(maleButton);
        f.add(femaleButton);
        f.add(emaiJLabel);
        f.add(emaiJTextField);
        f.add(dateBox);
        f.add(monthBox);
        f.add(yearBox);
        f.add(dobJLabel);
        f.add(genderJLabel);
        f.add(backButton);

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
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                f.setVisible(false);
                new Login();
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
        submiJButton.addActionListener(new ActionListener() {
            long i = 0;
            String date = "";

            public void actionPerformed(ActionEvent e) {
                boolean[] check = new boolean[8];
                Arrays.fill(check, false);
                if (namField.getText().length() > 0) {
                    System.out.println(namField.getText());
                    check[0] = true;
                } else {
                    JOptionPane.showMessageDialog(f, "Enter your name");
                }

                if (Tools.validatePassword(Tools.intoString(pass1Field.getPassword()),
                        Tools.intoString(pass2Field.getPassword()))) {
                    check[1] = true;
                } else {
                    JOptionPane.showMessageDialog(f, "Both Passwords mismatch");
                }
                if (phonField.getText().length() > 0) {
                    try {
                        String s = phonField.getText();
                        i = Long.parseLong(s);
                        System.out.println(i);
                        check[2] = true;
                    } catch (Exception event) {
                        event.printStackTrace();
                        JOptionPane.showMessageDialog(f, "Enter valid phone number");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Enter phone no");
                }
                check[3] = true;
                if (deposTextField.getText().length() > 0) {
                    try {
                        if (Integer.parseInt(deposTextField.getText()) >= 1000) {
                            check[4] = true;
                            System.out.println(Integer.parseInt(deposTextField.getText()));
                        } else {
                            JOptionPane.showMessageDialog(f, "Deposit amount more than 1000");
                        }
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(f, "Enter valid amount");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Enter deposit amount");
                }
                if (dateBox.getSelectedItem() != null || monthBox.getSelectedItem() != null
                        || yearBox.getSelectedItem() != null) {
                    try {
                        int d = dateBox.getSelectedIndex() + 1;
                        int m = monthBox.getSelectedIndex() + 1;
                        int y = 2005 - yearBox.getSelectedIndex();
                        var a = LocalDate.of(y, m, d);
                        date = Tools.getDate(y, m, d);
                        System.out.println(date);
                        var b = LocalDate.now();
                        var p = Period.between(a, b);
                        if (p.getYears() >= 18) {
                            check[5] = true;
                        } else {
                            JOptionPane.showMessageDialog(f,
                                    "You are not eligible to create account.You are below 18!");
                        }
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(f, "Enter valid date of birth");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Enter date of birth.");
                }
                if (gendeGroup.getSelection() != null) {
                    check[6] = true;

                } else {
                    JOptionPane.showMessageDialog(f, "Select gender.");
                }

                if (termBox.isSelected()) {
                    check[7] = true;
                } else {
                    JOptionPane.showMessageDialog(f, "Please agree to our terms and conditions");
                }
                boolean flag = true;
                for (int i = 0; i < check.length; i++) {
                    if (check[i] == false) {
                        flag = false;

                    }
                }
                if (flag) {
                    try {
                        JOptionPane.showMessageDialog(f,
                                Operation.createAccount(namField.getText(), Tools.intoString(pass1Field.getPassword()),
                                        deposTextField.getText(), i, emaiJTextField.getText(), date,
                                        maleButton.isSelected() ? "Male" : "Female"));
                        f.setVisible(false);
                        new Login();

                    } catch (Exception event) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(f, "Some error occured");
                        event.printStackTrace();
                        namField.setText(null);
                        pass1Field.setText(null);
                        pass2Field.setText(null);
                        phonField.setText(null);
                        emaiJTextField.setText(null);
                        deposTextField.setText(null);
                        termBox.setSelected(false);
                        gendeGroup.clearSelection();
                        dateBox.setSelectedIndex(0);
                        monthBox.setSelectedIndex(0);
                        yearBox.setSelectedIndex(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Cannot create account");
                    namField.setText(null);
                    pass1Field.setText(null);
                    pass2Field.setText(null);
                    phonField.setText(null);
                    emaiJTextField.setText(null);
                    deposTextField.setText(null);
                    termBox.setSelected(false);
                    gendeGroup.clearSelection();
                    dateBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);

                }
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