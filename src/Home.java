import javax.swing.*;
import java.awt.*;

public class Home {
    public static void main(String[] args) {
        // Main frame
        JFrame frame = new JFrame("Dashboard");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Sidebar panel
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(220, 220, 220)); // light gray
        sidebar.setPreferredSize(new Dimension(200, 0)); // width 200px
        sidebar.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // border
        sidebar.setLayout(new GridLayout(5, 1, 10, 10)); // 5 buttons with spacing

        // Add some buttons or menu items to sidebar
        sidebar.add(new JButton("Home"));
        sidebar.add(new JButton("Profile"));
        sidebar.add(new JButton("Settings"));
        sidebar.add(new JButton("Help"));
        sidebar.add(new JButton("Logout"));

        // Main content panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Your Account", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 36)); // big handwriting-like font
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Add panels to frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
