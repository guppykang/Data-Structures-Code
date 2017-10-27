package cs113.miracosta.edu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Joshua Kang
 * @version
 * Program Name: navigator
 * Program Description: creates a new looking themed GUI formatter, and shows the map, and allows the user to go from 
 * one city to another the fastest way possible
 *
 */
public class Navigator
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		City sanDiego = new City();
		
	}
}
