import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {
    private JTextField adSoyadField;
    private JTextField emailField;
    private JTextField telefonField;
    private JComboBox<String> cinsiyetCombo;

    public Main() {
        // Frame ayarları
        setTitle("LAB-Swing Uygulaması");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Set layout manager to null

        // Bilgiler
        JLabel adSoyadLabel = new JLabel("Ad-Soyad: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel telefonLabel = new JLabel("Telefon Numarası: ");
        JLabel cinsiyetLabel = new JLabel("Cinsiyet: ");

        // Text alanları
        adSoyadField = new JTextField(20);
        emailField = new JTextField(20);
        telefonField = new JTextField(20);

        // Cinsiyet seçimi için ComboBox
        String[] cinsiyetler = {"Kadın", "Erkek", "Belirtmek istemiyorum"}; //Cinsiyet seçeneklerini belirttik.
        cinsiyetCombo = new JComboBox<>(cinsiyetler);

        // Kayıt Et butonu
        JButton kaydetButton = new JButton("Kayıt Et");
        kaydetButton.addActionListener(this);

        // Ekranda görüntüyü düzenleme
        adSoyadLabel.setBounds(10, 10, 120, 25);
        adSoyadField.setBounds(130, 10, 200, 25);
        emailLabel.setBounds(10, 40, 120, 25);
        emailField.setBounds(130, 40, 200, 25);
        telefonLabel.setBounds(10, 70, 120, 25);
        telefonField.setBounds(130, 70, 200, 25);
        cinsiyetLabel.setBounds(10, 100, 120, 25);
        cinsiyetCombo.setBounds(130, 100, 200, 25);
        kaydetButton.setBounds(130, 130, 200, 25);

        // Arayüz bileşenlerini ekleme
        add(adSoyadLabel);
        add(adSoyadField);
        add(emailLabel);
        add(emailField);
        add(telefonLabel);
        add(telefonField);
        add(cinsiyetLabel);
        add(cinsiyetCombo);
        add(kaydetButton);

        // Frame Boyutunu ve görünürlüğünü belirleme
        setSize(350, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Kayıt Et")) {
            String adSoyad = adSoyadField.getText();
            String email = emailField.getText();
            String telefon = telefonField.getText();
            String cinsiyet = (String) cinsiyetCombo.getSelectedItem();

            // Bilgileri dosyaya kaydetme
            try {
                FileWriter writer = new FileWriter("kayit_dosyasi.txt", true);
                writer.write(adSoyad + "\t" + email + "\t" + telefon + "\t" + cinsiyet + "\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Kaydedildi.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Dosya Hatası: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}



