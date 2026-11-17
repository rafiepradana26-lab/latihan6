
import javax.swing.*;
import java.awt.*;

public class tugas2week5 extends JFrame {

    // Membuat panel untuk tombol
    JPanel panelTombol;

    // Constructor
    public tugas2week5() {

        // Mengatur jendela
        setTitle("Tugas 2 - Layout Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat panel dengan FlowLayout
        panelTombol = new JPanel(new FlowLayout());

        // Membuat tiga tombol
        JButton tombol1 = new JButton("PLAY");
        JButton tombol2 = new JButton("GARAGE");
        JButton tombol3 = new JButton("PENGATURAN");

        // Memasukkan tombol ke panel
        panelTombol.add(tombol1);
        panelTombol.add(tombol2);
        panelTombol.add(tombol3);

        // Memasukkan panel ke jendela
        add(panelTombol, BorderLayout.CENTER);

        // Membuat Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menuLayout = new JMenu("Layout");

        JMenuItem flow = new JMenuItem("FlowLayout");
        JMenuItem grid = new JMenuItem("GridLayout 1 x 3");

        // Mengubah ke FlowLayout
        flow.addActionListener(e -> {
            panelTombol.setLayout(new FlowLayout());

            panelTombol.revalidate();
            panelTombol.repaint();
        });

        // Mengubah ke GridLayout 1 x 3
        grid.addActionListener(e -> {
            panelTombol.setLayout(new GridLayout(1, 3, 5, 5));

            panelTombol.revalidate();
            panelTombol.repaint();
        });

        // Memasukkan menu
        menuLayout.add(flow);
        menuLayout.add(grid);

        menuBar.add(menuLayout);

        setJMenuBar(menuBar);
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new tugas2week5().setVisible(true);
        });

    }
}
