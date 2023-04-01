import java.util.Arrays;
import java.util.Random;

public class Tools {
    public static String cidGenerator(int x) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz", z = "";
        int len = 10 - ("" + x).length();
        for (int i = 0; i < len; i++) {
            z += s.charAt(new Random().nextInt(s.length()));
        }
        z += x;
        return z;
    }

    public static String[] dateString() {
        String[] dates = new String[31];
        Arrays.fill(dates, "");
        for (int i = 0; i < 31; i++) {
            dates[i] += (i + 1);
        }

        return dates;
    }

    public static int stringDate(String dob) {
        return Integer.parseInt(dob.substring(8)) - 1;
    }

    public static String[] monthString() {
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };
        return months;
    }

    public static int stringMonth(String dobString) {
        return Integer.parseInt(dobString.substring(5, 7)) - 1;
    }

    public static String[] yeaString() {
        String[] years = new String[80];
        Arrays.fill(years, "");
        for (int i = 0; i < 80; i++) {
            years[i] += (2005 - i);
        }
        return years;
    }

    public static int stringYear(String dobString) {
        return 2005 - Integer.parseUnsignedInt(dobString.substring(0, 4));
    }

    public static String intoString(char[] s) {
        String t = "";
        for (int i = 0; i < s.length; i++) {
            t = t + s[i];
        }
        return t;
    }

    public static boolean validatePassword(String a, String b) {

        if (a.length() > 8 || a.length() != b.length() || !a.equals(b)) {
            return false;
        }

        return true;
    }

    public static String getDate(int y, int m, int d) {
        String s;
        s = y + "/" + (m <= 10 ? "0" + m : m) + "/" + (d <= 10 ? "0" + d : d);
        return s;
    }

}
