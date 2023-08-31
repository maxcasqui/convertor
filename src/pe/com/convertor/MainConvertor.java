package pe.com.convertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainConvertor {
    public static void main(String[] args) {
        CreateWindow();
    }

    private static void CreateWindow(){
        JFrame frame = new JFrame("Convertor");
        frame.setContentPane(new ConvertorForm().GetMainPanel());
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Seguro que quiere Salir?",
                        "Salir",
                        JOptionPane.YES_NO_OPTION
                );

                // Exit when clicked in YES_OPTION
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                // Don't close when clicked in NO_OPTION
                if (choice == JOptionPane.NO_OPTION){
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
}
