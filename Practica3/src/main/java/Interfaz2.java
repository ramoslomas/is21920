import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz2{

	private JFrame frame;
	private AlarmaHogar alarm;
	
	/**
	 * Create the frame.
	 */
	public Interfaz2(AlarmaHogar alarm) {
		this.alarm=alarm;
		initialize();
	}
	public JFrame getFrame() {
		return frame;
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIntruso = new JButton("Intruso");
		btnIntruso.setBounds(120, 120, 80, 30);
		frame.getContentPane().add(btnIntruso);
		btnIntruso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alarm.intruso();
			}
		});
		
		JButton btnOff = new JButton("Off");
		btnOff.setBounds(360, 120, 80, 30);
		frame.getContentPane().add(btnOff);
		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alarm.off();
			}
		});
		
		
	}
	
	
}
