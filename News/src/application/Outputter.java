package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class Outputter {
	
	//private Boolean type; // Output types: Console 0, GUI 1 (not implemented jet) replaced by ENUM Type 
	enum Type {
		CONSOLE,
		GUI
	}
	private static Boolean debuggingEnabled = false;
	
	static Date date;
	static SimpleDateFormat dateFormat;
	
	
	public Outputter(String text) {
		out(text);
	}
	
	public Outputter(String text, Type type) {
		out(text, type);
	}
	
	
	
	public static void out(String text) {
		out(text, Outputter.Type.CONSOLE);
	}
	
	public static void out(String text, Type type) {
		date = new Date();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		if (debuggingEnabled) {
			switch (type) {
			case CONSOLE:
					System.out.println(dateFormat.format(date)+" [INFO]: "+text);
				break;
			case GUI:
				JOptionPane.showMessageDialog(null, text, "Info", 1);
				break;
			default:
				System.out.println("OutputType not known! Outputting as Console...");
				new Outputter(text, Type.CONSOLE);
				break;
			}
		}
	}
	
	public static void err(String text) {
		err(text, Outputter.Type.CONSOLE);
	}
	
	public static void err(String text, Type type) {
		date = new Date();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		if (debuggingEnabled) {
			switch (type) {
			case CONSOLE:
					System.err.println(dateFormat.format(date)+" [INFO]: "+text);
				break;
			case GUI:
				JOptionPane.showMessageDialog(null, text, "Info", 0);
				break;
			default:
				System.err.println("OutputType not known! Outputting as Console...");
				new Outputter(text, Type.CONSOLE);
				break;
			}
		}
	}
	
}
