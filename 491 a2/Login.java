/*
 * Decompiled with CFR 0_102.
 */
import java.io.PrintStream;

public class Login {
    public static void main(String[] arrstring) {
        Login login = new Login();
        System.out.println(login.login("user1", "Apr11988"));
    }

    public boolean login(String string, String string2) {
        if (string.equals("user1") ? string2.equals("Jun51979") : (string.equals("user2") ? string2.equals("MeganFox") : (string.equals("user3") ? string2.equals("Iloveyou") : (string.equals("user4") ? string2.equals("abcdefgh") : (string.equals("user5") ? string2.equals("password") : string.equals("user6") && string2.equals("Lisa1234")))))) {
            return true;
        }
        return false;
    }
}