import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class RegisterWindow{
    Users u;
    public RegisterWindow(Users users) {

        this.u = users;

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(500, 250);
        window.setTitle("Rejestracja");
        window.setLocationRelativeTo(null);

        JLabel loginLabel = new JLabel();
        loginLabel.setBounds(30, 30, 100, 20);
        loginLabel.setText("Login:");
        window.add(loginLabel);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBounds(30, 60, 100, 20);
        passwordLabel.setText("Password:");
        window.add(passwordLabel);

        JLabel passwordLabel2 = new JLabel();
        passwordLabel2.setBounds(30, 90, 160, 20);
        passwordLabel2.setText("Repeat password:");
        window.add(passwordLabel2);

        JLabel infoLabel = new JLabel();
        infoLabel.setBounds(170, 180, 200, 20);
        window.add(infoLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(230, 30, 200, 20);
        window.add(loginField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(230, 60, 200, 20);
        window.add(passwordField);

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setBounds(230, 90, 200, 20);
        window.add(passwordField2);

        JButton registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setBounds(130, 120, 90, 30);
        registerButton.addActionListener(e -> {
            if (!u.users.containsKey(loginField.getText())) {
                if (Arrays.equals(passwordField.getPassword(), passwordField2.getPassword())) {
                    window.getContentPane().setBackground(Color.GREEN);
                    infoLabel.setText("Registered succesfully");
                    registerButton.setEnabled(false);
                    u.users.put(loginField.getText(),passwordField.getPassword());
                } else {
                    registerButton.setEnabled(false);
                    window.getContentPane().setBackground(Color.RED);
                    infoLabel.setText("Passwords are not the same");
                }
            } else {
                registerButton.setEnabled(false);
                window.getContentPane().setBackground(Color.RED);
                infoLabel.setText("This login is taken");
            }
        });
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        window.add(registerButton);

        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(240, 120, 90, 30);
        clearButton.addActionListener(e -> {
            registerButton.setEnabled(true);
            window.getContentPane().setBackground(Color.WHITE);
            loginField.setText("");
            passwordField.setText("");
            passwordField2.setText("");
            infoLabel.setText("");
        });
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        window.add(clearButton);


        window.setLayout(null);
        window.setVisible(true);
    }
}
