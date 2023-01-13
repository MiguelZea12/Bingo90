package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class Bingo90 extends JFrame {

    private ArrayList<Integer> bolaList; 
    private Tablero tablero;    
    private JLabel lblNumeroSacado;    
    private JButton btnSacarBola;
    
    public Bingo90() {
    	getContentPane().setBackground(Color.CYAN);
        setTitle("Bingo");    
        setSize(833, 676);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        getContentPane().setLayout(null);

        bolaList = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolaList.add(i);
        }
        Collections.shuffle(bolaList);
        tablero = new Tablero();
        tablero.setBackground(new Color(255, 0, 0));
        tablero.setBounds(10, 46, 503, 569);
        tablero.setSacados(bolaList);
        getContentPane().add(tablero);

        lblNumeroSacado = new JLabel();
        lblNumeroSacado.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        lblNumeroSacado.setForeground(new Color(0, 0, 0));
        lblNumeroSacado.setFont(new Font("Dialog", Font.PLAIN, 36));
        lblNumeroSacado.setBounds(518, 168, 289, 178);
        getContentPane().add(lblNumeroSacado);

        btnSacarBola = new JButton("Sacar bola");
        btnSacarBola.setBackground(SystemColor.inactiveCaption);
        btnSacarBola.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnSacarBola.setBounds(595, 380, 149, 95);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolaList.size() > 0 && !tablero.tablaLlena()) {
                    int numero = bolaList.remove(0);

                    lblNumeroSacado.setText(Integer.toString(numero));
                    tablero.marcarNumero(numero);
                } else {
                btnSacarBola.setEnabled(false);             
                }
                }
                });
                getContentPane().add(btnSacarBola);
                JButton btnTerminarJuego = new JButton("Terminar Juego");
                btnTerminarJuego.setBackground(new Color(191, 205, 219));
                btnTerminarJuego.setFont(new Font("Tahoma", Font.PLAIN, 22));
                btnTerminarJuego.setBounds(595, 486, 185, 90);
                btnTerminarJuego.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                getContentPane().add(btnTerminarJuego);

                JLabel lblNewLabel = new JLabel("Bingo");
                lblNewLabel.setBorder(new MatteBorder(5, 0, 0, 5, (Color) new Color(192, 192, 192)));
                lblNewLabel.setBackground(Color.BLACK);
                lblNewLabel.setForeground(Color.RED);
                lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 90));
                lblNewLabel.setBounds(538, 46, 242, 111);
                getContentPane().add(lblNewLabel);
            }


            public static void main(String[] args) {
            	Bingo90 bingo = new Bingo90();
            	bingo.setVisible(true);
            	}
         }