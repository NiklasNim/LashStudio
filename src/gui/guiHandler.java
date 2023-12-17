package gui;
import java.util.*;
import javax.swing.JFrame;

public class guiHandler  {
	private static ArrayList<JFrame> windows = new ArrayList<JFrame>();
	
	
	public static void createMainWindow() {
		disableCurrent();
		MainWindow mainWindow = new MainWindow();
        windows.add(mainWindow);
        mainWindow.setVisible(true);
        setSize(mainWindow);
    }
	
	public static void createBookingOptionsUI() {
		disableCurrent();
		BookingOptionsUI bookingOptions = new BookingOptionsUI();
        windows.add(bookingOptions);
        bookingOptions.setVisible(true);
        setSize(bookingOptions);
    }
	
	public static void createBookingUI() {
		disableCurrent();
		CreateBookingUI createBookingUI = new CreateBookingUI();
        windows.add(createBookingUI);
        createBookingUI.setVisible(true);
        setSize(createBookingUI);
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
		 frame.setSize(800, 600);
	     frame.setLocationRelativeTo(null);
	}
}