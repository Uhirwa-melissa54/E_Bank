import javax.swing.*;
import java.awt.*;

public class SignUpForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Signup Form");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(1, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));




        // Form panel (no border)
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //title
        gbc.gridx=1;
        gbc.gridy=0;
        JLabel titleLabel = new JLabel("Signup", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        formPanel.add(titleLabel,gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        JTextField name=new JTextField(15);
        formPanel.add(name, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        JTextField email=new JTextField(15);
        formPanel.add(email, gbc);

        // Location
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Location:"), gbc);
        gbc.gridx = 1;
        JTextField location=new JTextField(15);
        formPanel.add(location, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        JTextField password=new JTextField(15);
        formPanel.add(password, gbc);

        // Signup button at the bottom
        gbc.gridx=1;
        gbc.gridy=5;
        JButton signupButton = new JButton("Signup");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(signupButton);

        formPanel.add(buttonPanel,gbc );

        mainPanel.add(formPanel, BorderLayout.CENTER);



        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
