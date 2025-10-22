import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginForm extends JFrame {

    public LoginForm() {
        Connection conn=Db.dbConnectClients();
        // Frame properties
        setTitle("Login Form");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Panel for the form
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Name Label and Field
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Name:"), gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Email Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc);

        JTextField emailField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        // Password Label and Field
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Password:"), gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);



        gbc.gridx=1;
        gbc.gridy=4;
        JButton loginButton = new JButton("Login");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);

        panel.add(buttonPanel,gbc);

        // Button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    String ok=LogIn.check(conn,name,password);
                    if(!ok.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Logged in successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Invalid credentials","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(null,"Invalid credentials","Error",JOptionPane.ERROR_MESSAGE);



            }
        });

        add(panel);
        setVisible(true);
    }

}
