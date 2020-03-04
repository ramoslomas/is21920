import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

public class Interfaz {
	
	private AlarmaHogar alarm;
	private JFrame frame;
	private JTextField estadoLed;
	private JLabel lblNewLabel;
	private JTextField cuadroNumeros;
	protected Timer timer3;
	protected Parpadeo tarea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alarm=new AlarmaHogar();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Interfaz2  inter= new Interfaz2(alarm);
		inter.getFrame().setVisible(true);
		
		
		estadoLed =new JTextField("");
		estadoLed.setEditable(false);
		estadoLed.setColumns(10);
		estadoLed.setBounds(76,263,166,30);
		frame.getContentPane().add(estadoLed);
		
		lblNewLabel =new JLabel("");
		lblNewLabel.setBounds(447, 172, 50, 50);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setOpaque(true);
		frame.getContentPane().add(lblNewLabel);
		
		timer3=new Timer();
		tarea=new Parpadeo();
		timer3.schedule(tarea,0, 200);
		
		
		final JButton button = new JButton("1");
		button.setBounds(60, 60, 50, 25);
		frame.getContentPane().add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button,cuadroNumeros);
			}
		});
	
		
		final JButton button_1 = new JButton("2");
		button_1.setBounds(134, 60, 50, 25);
		frame.getContentPane().add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_1,cuadroNumeros);
			}
		});
		
		final JButton button_2 = new JButton("3");
		button_2.setBounds(208, 60, 50, 25);
		frame.getContentPane().add(button_2);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_2,cuadroNumeros);
			}
		});
		
		
		final JButton button_3 = new JButton("4");
		button_3.setBounds(60, 116, 50, 25);
		frame.getContentPane().add(button_3);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_3,cuadroNumeros);
			}
		});
		
		final JButton button_4 = new JButton("5");
		button_4.setBounds(134, 116, 50, 25);
		frame.getContentPane().add(button_4);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_4,cuadroNumeros);
			}
		});
		
		final JButton button_5 = new JButton("6");
		button_5.setBounds(208, 116, 50, 25);
		frame.getContentPane().add(button_5);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_5,cuadroNumeros);
			}
		});
		
		
		
		final JButton button_6 = new JButton("7");
		button_6.setBounds(60, 172, 50, 25);
		frame.getContentPane().add(button_6);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_6,cuadroNumeros);
			}
		});
		
		final JButton button_7 = new JButton("8");
		button_7.setBounds(134, 172, 50, 25);
		frame.getContentPane().add(button_7);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_7,cuadroNumeros);
			}
		});
		
		final JButton button_8 = new JButton("9");
		button_8.setBounds(208, 172, 50, 25);
		frame.getContentPane().add(button_8);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_8,cuadroNumeros);
			}
		});
		
		
		
		final JButton button_9 = new JButton("0");
		button_9.setBounds(134, 228, 50, 25);
		frame.getContentPane().add(button_9);
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setNumber(button_9,cuadroNumeros);
			}
		});
		
		cuadroNumeros = new JTextField("");
		cuadroNumeros.setBounds(104, 20, 96, 19);
		frame.getContentPane().add(cuadroNumeros);
		cuadroNumeros.setColumns(10);
		
		
		JButton btnAlarmaon = new JButton("AlarmaOn");
		btnAlarmaon.setBounds(432, 60, 100, 25);
		frame.getContentPane().add(btnAlarmaon);
		btnAlarmaon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				alarm.alarmaOn();

			}
		});
		
		
		JButton btnAlarmaoff = new JButton("AlarmaOff");
		btnAlarmaoff.setBounds(432, 116, 100, 25);
		frame.getContentPane().add(btnAlarmaoff);
		btnAlarmaoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				alarm.alarmaOff(cuadroNumeros.getText());

				cuadroNumeros.setText("");
			}
		});
		
		
		
		
	}
	public class Parpadeo extends TimerTask {
		
		public void run() {
			switch(alarm.getPiloto().getState()) {
				case 0: 

					estadoLed.setText("Apagado");
					lblNewLabel.setBackground(Color.RED);
					
					break;
				case 1:

					estadoLed.setText("Encendido");
					lblNewLabel.setBackground(Color.GREEN);
					break;
				case 2:

					estadoLed.setText("Parpadeando");
					if(lblNewLabel.getBackground()==Color.LIGHT_GRAY) {
						lblNewLabel.setBackground(Color.RED);
					}else {
						lblNewLabel.setBackground(Color.LIGHT_GRAY);
					}
					break;
			}
		}
	}
	
	private void setNumber(JButton button,JTextField field) {
		String number = button.getText();
		String old=field.getText();
		number=old + number;
		field.setText(number);
	}
	
}
