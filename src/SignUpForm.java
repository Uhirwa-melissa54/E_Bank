import javax.swing.*;
import java.awt.*;

public class SignUpForm {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Signup Form");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame

        // Create a panel with a border
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Signup"));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name Label and TextField
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Email Label and TextField
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        // Location Label and TextField
        JLabel locationLabel = new JLabel("Location:");
        JTextField locationField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(locationLabel, gbc);
        gbc.gridx = 1;
        panel.add(locationField, gbc);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Signup button at the bottom
        JButton signupButton = new JButton("Signup");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(signupButton, gbc);

        // Add panel to frame
        frame.add(panel);

        // Make frame visible
        frame.setVisible(true);
    }
}
