import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {
    public static void main(String[] args) {
        String rawPassword = "TestAdminUser1";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword1 = passwordEncoder.encode(rawPassword);

        // Test if the raw password matches the encoded password
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword1);
        System.out.println("Password matches: " + matches);
    }
}
