package gui;

import javax.swing.SwingUtilities;

public class StartProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow mainWindow = new MainWindow();
                    mainWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
