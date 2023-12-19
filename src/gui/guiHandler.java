package gui;
import java.util.*;
import javax.swing.JFrame;

public class guiHandler  {
	private static ArrayList<JFrame> windows = new ArrayList<JFrame>();
	
	// Opret og vis hovedvinduet
	public static void createMainWindow() {
		createWindow(new MainWindow());
    }
	
	// Opret og vis bookingOptionsUI
	public static void createBookingOptionsUI() {
		createWindow(new BookingOptionsUI());
    }
	
	// Opret og vis createBookingUI
	public static void createBookingUI() {
		createWindow(new CreateBookingUI());
    }
	
	// Metode til at oprette et vindue
	public static void createWindow(JFrame window) {
		if (canCreateWindow(window)) {
			return;
		}
		disableCurrent();
		windows.add(window);
		window.setVisible(true);
		setSize(window);
	}
		
	// Gå tilbage til forrige vindue
	public static void goBack() {
		JFrame window = windows.get(windows.size() - 1);
		window.dispose();
		windows.remove(windows.size() - 1);
		window = windows.get(windows.size() - 1);
		window.setVisible(true);
	}
	
	// Deaktiver det nuværende vindue
	private static void disableCurrent() {
		if(windows.size() <= 0) {
			return;
		}
		
		JFrame window = windows.get(windows.size() - 1);
	    window.setVisible(false);
	}
	
	// Indstil størrelsen på et vindue
	private static void setSize(JFrame frame) {
		 frame.setSize(900, 600);
	     frame.setLocationRelativeTo(null);
	}
	
	// Kontroller om et vindue kan oprettes igen af samme type
	private static boolean canCreateWindow(JFrame window) {
		return windows.size() > 0 && window.getClass().getName() == windows.get(windows.size() - 1).getClass().getName();
	}
}