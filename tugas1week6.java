

import javax.swing.*;
import java.awt.*;

public class tugas1week5 extends JFrame {

    // Komponen input
    JTextField txtNama;
    JTextField txtEmail;
    JPasswordField txtSandi;

    JRadioButton rbLaki;
    JRadioButton rbPerempuan;

    JComboBox<String> cbProdi;

    JCheckBox cbMusik;
    JCheckBox cbBelajar;
    JCheckBox cbCoding;

    JButton btnDaftar;

    // Constructor
    public tugas1week5() {

        // 1. Pengaturan JFrame
        super("Form Registrasi");

        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // 2. Membuat Menu
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenu menuBantuan = new JMenu("Bantuan");

        JMenuItem menuKeluar = new JMenuItem("Keluar");
        JMenuItem menuTentang = new JMenuItem("Tentang");

        menuKeluar.addActionListener(e -> {
            System.exit(0);
        });

        menuTentang.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Aplikasi Form Registrasi Mahasiswa",
                "Tentang",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        menuFile.add(menuKeluar);
        menuBantuan.add(menuTentang);

        menuBar.add(menuFile);
        menuBar.add(menuBantuan);

        setJMenuBar(menuBar);

        // 3. Membuat Panel Utama
        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBackground(Color.WHITE);

        panel.setBorder(
            BorderFactory.createTitledBorder("Data Registrasi")
        );

        GridBagConstraints g = new GridBagConstraints();

        g.insets = new Insets(6, 5, 6, 5);
        g.anchor = GridBagConstraints.WEST;

        // 4. Input Nama
        g.gridx = 0;
        g.gridy = 0;

        panel.add(new JLabel("Nama:"), g);

        txtNama = new JTextField(18);

        g.gridx = 1;
        panel.add(txtNama, g);

        // 5. Input Email
        g.gridx = 0;
        g.gridy = 1;

        panel.add(new JLabel("Email:"), g);

        txtEmail = new JTextField(18);

        g.gridx = 1;
        panel.add(txtEmail, g);

        // 6. Input Password
        g.gridx = 0;
        g.gridy = 2;

        panel.add(new JLabel("Sandi:"), g);

        txtSandi = new JPasswordField(18);

        g.gridx = 1;
        panel.add(txtSandi, g);

        // 7. Pilihan Gender
        g.gridx = 0;
        g.gridy = 3;

        panel.add(new JLabel("Gender:"), g);

        JPanel panelGender = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 3, 0)
        );

        panelGender.setBackground(Color.WHITE);

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        rbLaki.setBackground(Color.WHITE);
        rbPerempuan.setBackground(Color.WHITE);

        ButtonGroup grupGender = new ButtonGroup();

        grupGender.add(rbLaki);
        grupGender.add(rbPerempuan);

        rbLaki.setSelected(true);

        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        g.gridx = 1;
        panel.add(panelGender, g);

        // 8. Pilihan Program Studi
        g.gridx = 0;
        g.gridy = 4;

        panel.add(new JLabel("Prodi:"), g);

        cbProdi = new JComboBox<>(
            new String[]{
                "Informatika",
                "Sistem Informasi",
                "Manajemen",
                "Akuntansi",
                "Teknik Kimia",
                "Ekonomi Syariah"
            }
        );

        cbProdi.setPreferredSize(new Dimension(175, 25));

        g.gridx = 1;
        panel.add(cbProdi, g);

        // 9. Pilihan Hobi
        g.gridx = 0;
        g.gridy = 5;

        panel.add(new JLabel("Hobi:"), g);

        JPanel panelHobi = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 3, 0)
        );

        panelHobi.setBackground(Color.WHITE);

        cbMusik = new JCheckBox("Musik");
        cbBelajar = new JCheckBox("Belajar");
        cbCoding = new JCheckBox("Coding");

        cbMusik.setBackground(Color.WHITE);
        cbBelajar.setBackground(Color.WHITE);
        cbCoding.setBackground(Color.WHITE);

        panelHobi.add(cbMusik);
        panelHobi.add(cbBelajar);
        panelHobi.add(cbCoding);

        g.gridx = 1;
        panel.add(panelHobi, g);

        // 10. Tombol Daftar
        btnDaftar = new JButton("Daftar");

        g.gridx = 1;
        g.gridy = 6;
        g.fill = GridBagConstraints.HORIZONTAL;

        panel.add(btnDaftar, g);

        // 11. Event Tombol Daftar
        btnDaftar.addActionListener(e -> daftar());

        // 12. Memasukkan Panel ke JFrame
        add(panel);

    }

    // Method untuk proses registrasi
    public void daftar() {

        String nama = txtNama.getText().trim();
        String email = txtEmail.getText().trim();

        char[] sandi = txtSandi.getPassword();

        // Validasi input
        if (nama.isEmpty() || email.isEmpty() || sandi.length == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Semua data harus diisi!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Mengambil Gender
        String gender;

        if (rbLaki.isSelected()) {
            gender = "Laki-laki";
        } else {
            gender = "Perempuan";
        }

        // Mengambil Prodi
        String prodi = (String) cbProdi.getSelectedItem();

        // Mengambil Hobi
        String hobi = "";

        if (cbMusik.isSelected()) {
            hobi += "Musik, ";
        }

        if (cbBelajar.isSelected()) {
            hobi += "Belajar, ";
        }

        if (cbCoding.isSelected()) {
            hobi += "Coding, ";
        }

        if (hobi.isEmpty()) {
            hobi = "Tidak ada";
        } else {
            hobi = hobi.substring(0, hobi.length() - 2);
        }

        // Menampilkan Ringkasan
        String hasil =
            "REGISTRASI BERHASIL!\n\n" +
            "Nama       : " + nama + "\n" +
            "Email      : " + email + "\n" +
            "Gender     : " + gender + "\n" +
            "Prodi      : " + prodi + "\n" +
            "Hobi       : " + hobi;

        JOptionPane.showMessageDialog(
            this,
            hasil,
            "Ringkasan Registrasi",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Membersihkan password dari array
        java.util.Arrays.fill(sandi, '\0');
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new tugas1week5().setVisible(true);
        });

    }
}
