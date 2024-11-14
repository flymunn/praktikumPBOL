import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormLoginRegister extends JFrame {
    private JPanel cards;
    private CardLayout cl;
    
    public FormLoginRegister() {
        // Mengatur frame
        setTitle("Form Login dan Register");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Membuat card layout
        cl = new CardLayout();
        cards = new JPanel(cl);
        
        // Menambahkan panel login dan register
        cards.add(buatPanelLogin(), "Login");
        cards.add(buatPanelRegister(), "Register");
        
        // Menambahkan cards ke frame
        add(cards);
    }
    
    private JPanel buatPanelLogin() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(200, 200, 255));
        
        // Label judul
        JLabel judul = new JLabel("LOGIN");
        judul.setBounds(120, 20, 100, 30);
        judul.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(judul);
        
        // Form login
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 70, 100, 25);
        panel.add(labelEmail);
        
        JTextField email = new JTextField();
        email.setBounds(30, 95, 220, 25);
        panel.add(email);
        
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(30, 130, 100, 25);
        panel.add(labelPassword);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(30, 155, 220, 25);
        panel.add(password);
        
        // Button login
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(30, 200, 220, 30);
        btnLogin.setBackground(new Color(100, 149, 237));
        btnLogin.setForeground(Color.WHITE);
        panel.add(btnLogin);
        
        // Button ke register
        JButton btnKeRegister = new JButton("Daftar Akun Baru");
        btnKeRegister.setBounds(30, 250, 220, 30);
        panel.add(btnKeRegister);
        
        // Aksi button
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputEmail = email.getText();
                String inputPassword = new String(password.getPassword());
                
                if(inputEmail.isEmpty() || inputPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email dan Password harus diisi!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login berhasil!");
                }
            }
        });
        
        btnKeRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(cards, "Register");
            }
        });
        
        return panel;
    }
    
    private JPanel buatPanelRegister() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(200, 255, 200));
        
        // Label judul
        JLabel judul = new JLabel("REGISTER");
        judul.setBounds(100, 20, 150, 30);
        judul.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(judul);
        
        // Form register
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(30, 70, 100, 25);
        panel.add(labelNama);
        
        JTextField nama = new JTextField();
        nama.setBounds(30, 95, 220, 25);
        panel.add(nama);
        
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 130, 100, 25);
        panel.add(labelEmail);
        
        JTextField email = new JTextField();
        email.setBounds(30, 155, 220, 25);
        panel.add(email);
        
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(30, 190, 100, 25);
        panel.add(labelPassword);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(30, 215, 220, 25);
        panel.add(password);
        
        // Button register
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(30, 260, 220, 30);
        btnRegister.setBackground(new Color(46, 139, 87));
        btnRegister.setForeground(Color.WHITE);
        panel.add(btnRegister);
        
        // Button ke login
        JButton btnKeLogin = new JButton("Sudah Punya Akun");
        btnKeLogin.setBounds(30, 300, 220, 30);
        panel.add(btnKeLogin);
        
        // Aksi button
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputNama = nama.getText();
                String inputEmail = email.getText();
                String inputPassword = new String(password.getPassword());
                
                if(inputNama.isEmpty() || inputEmail.isEmpty() || inputPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                } else {
                    JOptionPane.showMessageDialog(null, "Register berhasil!");
                }
            }
        });
        
        btnKeLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(cards, "Login");
            }
        });
        
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormLoginRegister().setVisible(true);
            }
        });
    }
}