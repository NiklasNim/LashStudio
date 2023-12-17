package gui;
import java.util.*;
import javax.swing.JFrame;

public class guiHandler  {
	private static ArrayList<JFrame> windows = new ArrayList<JFrame>();
	
	
	public static void createMainWindow() {
		createWindow(new MainWindow());
    }
	
	public static void createBookingOptionsUI() {
		createWindow(new BookingOptionsUI());
    }
	
	public static void createBookingUI() {
		createWindow(new CreateBookingUI());
    }
	
	public static void createWindow(JFrame window) {
		if (canCreateWindow(window)) {
			return;
		}
		disableCurrent();
		windows.add(window);
		window.setVisible(true);
		setSize(window);
	}
		
	
	public static void goBack() {
		JFrame window = windows.get(windows.size() - 1);
		window.dispose();
		windows.remove(windows.size() - 1);
		window = windows.get(windows.size() - 1);
		window.setVisible(true);
	}
	
	private static void disableCurrent() {
		if(windows.size() <= 0) {
			return;
		}
		
		JFrame window = windows.get(windows.size() - 1);
	    window.setVisible(false);
	}
	
	private static void setSize(JFrame frame) {
		 frame.setSize(900, 600);
	     frame.setLocationRelativeTo(null);
	}
	
	private static boolean canCreateWindow(JFrame window) {
		return windows.size() > 0 && window.getClass().getName() == windows.get(windows.size() - 1).getClass().getName();
	}
}