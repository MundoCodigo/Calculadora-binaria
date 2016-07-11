import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroUno;
	private JTextField tfNumeroDos;
	private JTextField tfResultado;
	private Calculadora calculadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 30, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Numero uno");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		tfNumeroUno = new JTextField();
		tfNumeroUno.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfNumeroUno = new GridBagConstraints();
		gbc_tfNumeroUno.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNumeroUno.anchor = GridBagConstraints.EAST;
		gbc_tfNumeroUno.gridwidth = 3;
		gbc_tfNumeroUno.insets = new Insets(0, 0, 5, 5);
		gbc_tfNumeroUno.gridx = 1;
		gbc_tfNumeroUno.gridy = 0;
		contentPane.add(tfNumeroUno, gbc_tfNumeroUno);
		tfNumeroUno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero Dos");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfNumeroDos = new JTextField();
		tfNumeroDos.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfNumeroDos = new GridBagConstraints();
		gbc_tfNumeroDos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNumeroDos.anchor = GridBagConstraints.EAST;
		gbc_tfNumeroDos.gridwidth = 3;
		gbc_tfNumeroDos.insets = new Insets(0, 0, 5, 5);
		gbc_tfNumeroDos.gridx = 1;
		gbc_tfNumeroDos.gridy = 2;
		contentPane.add(tfNumeroDos, gbc_tfNumeroDos);
		tfNumeroDos.setColumns(10);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(calculadora == null)
					calculadora = new Calculadora();
				
				if(!tfNumeroDos.equals("") && !tfNumeroUno.equals(""))
					tfResultado.setText(calculadora.resolverOperacion("-", tfNumeroUno.getText(), tfNumeroDos.getText()));
			}
		});
		GridBagConstraints gbc_btnMenos = new GridBagConstraints();
		gbc_btnMenos.insets = new Insets(0, 0, 5, 5);
		gbc_btnMenos.gridx = 2;
		gbc_btnMenos.gridy = 4;
		contentPane.add(btnMenos, gbc_btnMenos);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(calculadora == null)
					calculadora = new Calculadora();
				
				if(!tfNumeroDos.equals("") && !tfNumeroUno.equals(""))
					tfResultado.setText(calculadora.resolverOperacion("+", tfNumeroUno.getText(), tfNumeroDos.getText()));
			}
		});
		GridBagConstraints gbc_btnMas = new GridBagConstraints();
		gbc_btnMas.insets = new Insets(0, 0, 5, 5);
		gbc_btnMas.gridx = 3;
		gbc_btnMas.gridy = 4;
		contentPane.add(btnMas, gbc_btnMas);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfResultado = new JTextField();
		tfResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfResultado = new GridBagConstraints();
		gbc_tfResultado.insets = new Insets(0, 0, 5, 5);
		gbc_tfResultado.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfResultado.anchor = GridBagConstraints.EAST;
		gbc_tfResultado.gridwidth = 3;
		gbc_tfResultado.gridx = 1;
		gbc_tfResultado.gridy = 6;
		contentPane.add(tfResultado, gbc_tfResultado);
		tfResultado.setColumns(10);
	}

}
