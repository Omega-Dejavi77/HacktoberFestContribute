package presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domini.Jugador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaJugar extends JFrame {

	private JPanel contentPane;
	private Jugador jugador;
	private JLabel lblArma;
	private JLabel lblVides;
	private JButton btnDisparar;
	private JLabel lblResultatDisparar;
	private JLabel lblMunici;
	private JLabel lblMunicio;
	private JButton btnRecarregarArma;

	/**
	 * Create the frame.
	 * 
	 * @param nomJugador
	 */
	public PantallaJugar(String nomJugador) {
		setTitle("Jugador " + nomJugador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblArmaActual = new JLabel("Arma actual");
		lblArmaActual.setBounds(33, 32, 70, 14);

		JLabel lblNumeroDeVides = new JLabel("Numero de vides");
		lblNumeroDeVides.setBounds(33, 76, 103, 14);

		lblArma = new JLabel("New label");
		lblArma.setBounds(142, 32, 77, 14);

		lblVides = new JLabel("New label");
		lblVides.setBounds(142, 76, 46, 14);
		contentPane.setLayout(null);
		contentPane.add(lblArmaActual);
		contentPane.add(lblNumeroDeVides);
		contentPane.add(lblArma);
		contentPane.add(lblVides);

		btnDisparar = new JButton("disparar");
		btnDisparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botoDispararPremut();
			}
		});
		btnDisparar.setBounds(47, 170, 89, 23);
		contentPane.add(btnDisparar);

		lblResultatDisparar = new JLabel("");
		lblResultatDisparar.setBounds(187, 128, 103, 14);
		contentPane.add(lblResultatDisparar);

		lblMunici = new JLabel("munici\u00F3");
		lblMunici.setBounds(245, 32, 46, 14);
		contentPane.add(lblMunici);

		lblMunicio = new JLabel("New label");
		lblMunicio.setBounds(316, 32, 46, 14);
		contentPane.add(lblMunicio);

		btnRecarregarArma = new JButton("recarregar arma");
		btnRecarregarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botoRecarregarPremut();
			}
		});
		btnRecarregarArma.setBounds(219, 170, 153, 23);
		contentPane.add(btnRecarregarArma);
		this.jugador = new Jugador(nomJugador);
		this.informacioJoc();
		this.setVisible(true);
	}

	protected void botoRecarregarPremut() {
		try {
			this.jugador.recarregar();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR recarregar", JOptionPane.ERROR_MESSAGE);
		}
		this.informacioJoc();
	}

	private void informacioJoc() {
		this.lblArma.setText(this.jugador.getTipusArma());
		this.lblMunicio.setText(String.valueOf(this.jugador.getMunicio()));
		this.lblVides.setText(String.valueOf(this.jugador.getVides()));
	}

	protected void botoDispararPremut() {
		try {
			if (this.jugador.disparar()) {
				this.lblResultatDisparar.setText("Enemic mort");
			} else {
				this.lblResultatDisparar.setText("Has fallat");
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR disparar", JOptionPane.ERROR_MESSAGE);
		}
		this.informacioJoc();
	}
}
