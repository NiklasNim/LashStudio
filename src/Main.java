import gui.guiHandler;
import javax.swing.SwingUtilities;

// Main til at starte hele programmet på en sikker måde
public class Main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    guiHandler.createMainWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}