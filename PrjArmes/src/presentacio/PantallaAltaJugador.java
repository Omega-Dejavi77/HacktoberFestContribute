package presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaAltaJugador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAltaJugador frame = new PantallaAltaJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaAltaJugador() {
		setTitle("Alta Jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomJugador = new JLabel("Nom Jugador");
		lblNomJugador.setBounds(25, 90, 93, 14);
		contentPane.add(lblNomJugador);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botoPremut();
			}
		});
		textField.setBounds(120, 87, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnFerAlta = new JButton("Fer alta");
		btnFerAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botoPremut();
			}
		});
		btnFerAlta.setBounds(149, 195, 89, 23);
		contentPane.add(btnFerAlta);
	}

	protected void botoPremut() {
		if (textField.getText().length() < 2) {
			JOptionPane.showMessageDialog(this, "cal entrar mínim dos caràcters", "ERROR nom jugador",
					JOptionPane.ERROR_MESSAGE);
		} else {
			new PantallaJugar(textField.getText());
			this.dispose();
		}
	}
}