import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Window {
    public Window() {
        Users u = new Users();
        final int[] tries = {3};

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(400, 250);
        window.setTitle("Logowanie");
        window.setLocationRelativeTo(null);

        JLabel loginLabel = new JLabel();
        loginLabel.setBounds(30, 30, 100, 20);
        loginLabel.setText("Login:");
        window.add(loginLabel);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBounds(30, 60, 100, 20);
        passwordLabel.setText("Password:");
        window.add(passwordLabel);

        JLabel infoLabel = new JLabel();
        infoLabel.setBounds(170, 180, 200, 20);
        window.add(infoLabel);

        JLabel registerLabel = new JLabel();
        registerLabel.setBounds(170,160,200,20);
        registerLabel.setText("<HTML><U>Create new account</U></HTML>");
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                RegisterWindow registerWindow = new RegisterWindow(u);
            }
        });
        window.add(registerLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(130, 30, 200, 20);
        window.add(loginField);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(130, 60, 200, 20);
        window.add(passwordField);

        JButton loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setBounds(130, 120, 90, 30);
        loginButton.addActionListener(e -> {
            if (u.users.get(loginField.getText()) != null) {
                if (Arrays.equals(passwordField.getPassword(), u.users.get(loginField.getText()))) {
                    window.getContentPane().setBackground(Color.GREEN);
                    infoLabel.setText("Logined succesfully");
                    loginButton.setEnabled(false);
                }
            } else {
                loginButton.setEnabled(false);
                tries[0]--;
                window.getContentPane().setBackground(Color.RED);
                infoLabel.setText(tries[0] + " tries left");
            }
            if (tries[0] == 0) {
                System.exit(0);
            }
        });
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        window.add(loginButton);

        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(240, 120, 90, 30);
        clearButton.addActionListener(e -> {
            loginButton.setEnabled(true);
            window.getContentPane().setBackground(Color.WHITE);
            loginField.setText("");
            passwordField.setText("");
            infoLabel.setText("");
        });
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        window.add(clearButton);


        window.setLayout(null);
        window.setVisible(true);
    }
}
