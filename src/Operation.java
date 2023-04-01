import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Details {
    String name;
    String phone;
    String gender;
    String dob;
    String email;

    /**
     * @param name
     * @param phone
     * @param gender
     * @param dob
     * @param email
     */
    public Details(String name, String phone, String gender, String dob, String email) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Details [name=" + name + ", phone=" + phone + ", gender=" + gender + ", dob=" + dob + ", email=" + email
                + "]";
    }

}

public class Operation {

    public static boolean login(String cid, String password) {
        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();

            ResultSet rs = con
                    .prepareStatement(
                            "Select name from consumer where cid='" + cid + "' and password='" + password + "'")
                    .executeQuery();
            if (rs.next()) {
                new MainPage(rs.getString(1), cid);
                return true;

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid Uid or password.");
                return false;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }

    }

    public static String createAccount(String name, String password, String deposit, long phone, String email,
            String dob, String gender) {
        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            con.prepareStatement("insert into consumer(name,password,balance) values('" + name + "','" + password
                    + "','" + deposit + "');").executeUpdate();
            ResultSet rs = con.prepareStatement("select last_insert_id();").executeQuery();
            int x;
            if (rs.next()) {
                x = rs.getInt(1);
                String s = Tools.cidGenerator(x);
                con.prepareStatement("update consumer set cid='" + s + "' where cno= " + x + ";").executeUpdate();
                con.prepareStatement("insert into information values('" + phone + "','" + email + "','" + dob + "','"
                        + gender + "','" + x + "');").executeUpdate();
                return "Your consumer id is : " + s + " (please note it down)";
            } else {
                return "Please recheck values";
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "some exception occured";
        }
    }

    public static String showBalance(String cid, String password) {
        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            ResultSet rs = con.prepareStatement(
                    "select balance from consumer where cid='" + cid + "'and password='" + password + "';")
                    .executeQuery();
            if (rs.next()) {
                String s = rs.getString(1);
                return "Your current acount balance is :" + s;

            } else {
                return "Wrong password";
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Some Error Occured";
        }
    }

    public static String withdrawMoney(String cid, String password, int amount) {

        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            ResultSet rs = con
                    .prepareStatement(
                            "select balance,cno from consumer where cid='" + cid + "' and password='" + password + "';")
                    .executeQuery();
            int balance;
            int cno;
            if (rs.next()) {
                balance = rs.getInt(1);
                cno = rs.getInt(2);

                if ((balance -= amount) >= 1000) {
                    con.prepareStatement("update consumer set balance='" + balance + "' where cid='" + cid + "';")
                            .executeUpdate();

                    con.prepareStatement(
                            "insert into transactions values('" + (-1 * amount) + "',curdate(),curtime()," + cno
                                    + ");")
                            .executeUpdate();
                    return "Successfully updated";
                } else {
                    return "Cannot reduce balance from 1000";
                }

            } else {
                return "Wrong password";
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Some error Occured";
        }
    }

    public static Object depositMoney(String cid, String password, int amount) {
        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            ResultSet rs = con
                    .prepareStatement(
                            "select balance,cno from consumer where cid='" + cid + "' and password='" + password + "';")
                    .executeQuery();
            int balance, cno;
            if (rs.next()) {
                balance = rs.getInt(1);
                balance += amount;
                cno = rs.getInt(2);
                con.prepareStatement("update consumer set balance='" + balance + "' where cid='" + cid + "';")
                        .executeUpdate();

                con.prepareStatement(
                        "insert into transactions values('" + amount + "',curdate(),curtime()," + cno
                                + ");")
                        .executeUpdate();

                return "Successfully updated";

            } else {
                return "Wrong Password";
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Some error occured";
        }
    }

    public static String fetchTransactioString(String cid, String password) {
        try {
            String resulString = "-----------------------------------------\n";
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            ResultSet rs = con
                    .prepareStatement(
                            "select cno from consumer where cid='" + cid + "' and password='" + password + "';")
                    .executeQuery();
            if (rs.next()) {
                int cno = rs.getInt(1);
                rs = con.prepareStatement(
                        "select transaction,transactionDate,transactionTime from transactions where cno=" + cno + ";")
                        .executeQuery();
                while (rs.next()) {
                    resulString += "Transaction : " + rs.getString(1) + "\nTime : " + rs.getString(3) + "\nDate : "
                            + rs.getString(2) + " \n------------------------------\n";
                }
                return resulString;
            } else {
                return "Wrong Password";
            }
        } catch (

        Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Some error occured";
        }

    }

    public static Details getDetail(String cid) {
        Details d;

        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            ResultSet rs = con.prepareStatement("Select cno,name from consumer where cid='" + cid + "';")
                    .executeQuery();
            int cno;
            String name;
            String phone;
            String gender;
            String dob;
            String email;
            if (rs.next()) {
                cno = rs.getInt(1);
                name = rs.getString(2);

                ResultSet ps = con
                        .prepareStatement("Select phone,dob,gender,email from information where cno=" + cno + ";")
                        .executeQuery();
                if (ps.next()) {
                    phone = ps.getString(1);

                    gender = ps.getString(3);
                    dob = ps.getString(2);
                    email = ps.getString(4);
                    d = new Details(name, phone, gender, dob, email);
                    // System.out.println(d.toString());
                    return d;
                }
            }
            return null;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

            return null;
        }

    }

    public static String editDetail(Details details, String cid) {
        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank;").executeUpdate();
            con.prepareStatement("update consumer set name='" + details.name + "' where cid='" + cid + "';")
                    .executeUpdate();
            ResultSet rs = con.prepareStatement("Select cno from consumer where cid='" + cid + "';").executeQuery();
            if (rs.next()) {
                int cno = rs.getInt(1);
                con.prepareStatement("update information set phone=" + details.phone + ",email='" + details.email
                        + "',dob='" + details.dob + "',gender='" + details.gender + "' where cno=" + cno + ";")
                        .executeUpdate();

            }
            return "Updated Successfully";

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Some Error Occured";
        }
    }

    public static boolean changePString(String cid, String op, String np, String rep) {
        try {
            Connection con = Connections.buildConnection();
            con.prepareStatement("use mybank").executeUpdate();
            if (Tools.validatePassword(np, rep)) {
                ResultSet rs = con
                        .prepareStatement("Select cno from consumer where cid='" + cid + "' and password='" + op + "';")
                        .executeQuery();
                if (rs.next()) {
                    con.prepareStatement(
                            "update consumer set password='" + np + "' where cid='" + cid + "' and password='" + op
                                    + "';")
                            .executeUpdate();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Wrong password");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Enter equal and valid password");
                return false;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Some error Occured");
            return false;
        }
    }
}
