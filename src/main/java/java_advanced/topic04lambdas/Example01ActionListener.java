package java_advanced.topic04lambdas;

import javax.swing.*;

public class Example01ActionListener {

    public static void main(String[] args) {
        // Zorg dat GUI op de Event Dispatch Thread wordt gebouwd
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lambda Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);

            JButton button = new JButton("Klik mij!");

            // Lambda-expressie ipv anonieme ActionListener-klasse
            button.addActionListener(e ->
                    JOptionPane.showMessageDialog(frame, "Hello World!")
            );

            frame.getContentPane().add(button);
            frame.setLocationRelativeTo(null); // centreer het venster
            frame.setVisible(true);
        });
    }
}
