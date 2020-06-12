//16310034 - Ivan Emmanuel Arredondo Martinez
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal_Secuencial extends JFrame implements ActionListener {

	static JPanel panel = new JPanel();
	static int velT = 2, velR = 5, totalVueltas = 1;
	static boolean inic = false, tiempo = true;;
	static Principal_Secuencial principal = new Principal_Secuencial();
	static Sol sol = new Sol(principal, panel, 0.037);
	static Mercurio mercurio = new Mercurio(principal, panel, 0.017);
	static Venus venus = new Venus(principal, panel, 0.0042);// jfrme, jpanel, grado de rotacion en radianes
	static Tierra tierra = new Tierra(principal, panel, 1);
	static Marte marte = new Marte(principal, panel, 1.026);
	static Jupiter jupiter = new Jupiter(principal, panel, 2.4);
	static AnalizadordeSistema sistem=new AnalizadordeSistema(panel, principal, "Secuencial");
	JButton botIncrementarVR, botReducirVR, botIncrementarVT, botReducirVT, start, stop, incremetaTraslaciones,
			reduceTraslaciones;
	static JLabel texto, velTraslacion, velRotacion, cantVueltas, tiempoResultante;

	public Principal_Secuencial() {
		super("Sistema Solar Secuencial");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setSize(1156,653);
		// this.setResizable(false);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		getContentPane().setLayout(new FlowLayout());

		panel.setBackground(Color.black);
		// panel.setBounds(0, 0, 1360, 768);
		panel.setPreferredSize(new Dimension(1360, 700));
		panel.setLayout(null);

		botIncrementarVR = new JButton("+R");
		botIncrementarVR.setBounds(150, 150, 60, 30);
		botIncrementarVR.addActionListener(this);
		panel.add(botIncrementarVR);
		botReducirVR = new JButton("-R");
		botReducirVR.setBounds(20, 150, 60, 30);
		botReducirVR.addActionListener(this);
		panel.add(botReducirVR);
		velRotacion = new JLabel("" + velR);
		velRotacion.setForeground(Color.green);
		velRotacion.setBounds(110, 150, 220, 40);
		panel.add(velRotacion);
		texto = new JLabel("Velocidad de Rotacion General");
		texto.setForeground(Color.white);
		texto.setBounds(20, 110, 220, 40);
		panel.add(texto);

		botIncrementarVT = new JButton("+T");
		botIncrementarVT.setBounds(150, 220, 60, 30);
		botIncrementarVT.addActionListener(this);
		panel.add(botIncrementarVT);
		botReducirVT = new JButton("-T");
		botReducirVT.setBounds(20, 220, 60, 30);
		botReducirVT.addActionListener(this);
		panel.add(botReducirVT);
		velTraslacion = new JLabel("" + velT);
		velTraslacion.setForeground(Color.green);
		velTraslacion.setBounds(110, 220, 220, 40);
		panel.add(velTraslacion);
		texto = new JLabel("Velocidad de Traslacion General");
		texto.setForeground(Color.white);
		texto.setBounds(20, 180, 220, 40);
		panel.add(texto);

		incremetaTraslaciones = new JButton("+TT");
		incremetaTraslaciones.setBounds(150, 290, 60, 30);
		incremetaTraslaciones.addActionListener(this);
		panel.add(incremetaTraslaciones);
		reduceTraslaciones = new JButton("-TT");
		reduceTraslaciones.setBounds(20, 290, 60, 30);
		reduceTraslaciones.addActionListener(this);
		panel.add(reduceTraslaciones);
		cantVueltas = new JLabel("" + totalVueltas);
		cantVueltas.setForeground(Color.green);
		cantVueltas.setBounds(110, 290, 220, 40);
		panel.add(cantVueltas);
		texto = new JLabel("Cantidad de vueltas al redededor del sol, solo el planeta Tierra");
		texto.setForeground(Color.white);
		texto.setBounds(20, 250, 700, 40);
		panel.add(texto);

		start = new JButton("START");
		start.setBounds(20, 360, 200, 30);
		start.addActionListener(this);
		panel.add(start);

		texto = new JLabel(".");
		texto.setForeground(Color.ORANGE);
		texto.setBounds(20, 395, 800, 40);
		panel.add(texto);
		tiempoResultante = new JLabel(".");
		tiempoResultante.setForeground(Color.orange);
		tiempoResultante.setBounds(20, 430, 370, 40);
		panel.add(tiempoResultante);
	}

	public static void main(String[] args) {
		double tInicio = 0.0, tFin = 0.0, tTotal = 0.0;
		int banderaVueltas = -1;
		while (true) {
			while (tierra.vueltas < totalVueltas) {
				sistem.imprime_Estado_Planeta("sol",1);//1 enciende indicador del planeta, 0 lo apaga
				sol.pintar();
				sistem.imprime_Estado_Planeta("sol",0);
				sistem.imprime_Estado_Planeta("mercurio",1);
				mercurio.pintar();
				sistem.imprime_Estado_Planeta("mercurio",0);
				sistem.imprime_Estado_Planeta("venus",1);
				venus.pintar();
				sistem.imprime_Estado_Planeta("venus",0);
				sistem.imprime_Estado_Planeta("tierra",1);
				tierra.pintar();
				sistem.imprime_Estado_Planeta("tierra",0);
				sistem.imprime_Estado_Planeta("marte",1);
				marte.pintar();
				sistem.imprime_Estado_Planeta("marte",0);
				sistem.imprime_Estado_Planeta("jupiter",1);
				jupiter.pintar();
				sistem.imprime_Estado_Planeta("jupiter",0);
				principal.setVisible(true);
				while (!inic) {
					sistem.imprime_Estado_Planeta("0",0);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				sistem.imprimeUso();
				if(tiempo) {
					panel.remove(texto);
					panel.remove(tiempoResultante);
					tiempoResultante=new JLabel("");
			        tiempoResultante.setForeground(Color.orange);
			        tiempoResultante.setBounds(20,400,370,40);
			        panel.add(tiempoResultante);
					tInicio=System.currentTimeMillis(); //SE TOMA EL TIEMPO INICIAL		
					System.out.println("T Inicio: "+tInicio);
			        tiempo=false;
				}

				if(banderaVueltas!=tierra.vueltas) {
					banderaVueltas=tierra.vueltas;
					panel.remove(tiempoResultante);
					tiempoResultante=new JLabel("Vuelta Numero: "+(banderaVueltas+1));
			        tiempoResultante.setForeground(Color.orange);
			        tiempoResultante.setBounds(20,400,370,40);
			        panel.add(tiempoResultante);
				}
			}
			if(tierra.vueltas>=totalVueltas) {
				int formato=0, minutos=0, segundos=0, banderaTiempo=0, milis=0;
				tFin=System.currentTimeMillis(); //SE TOMA EL TIEMPO FINAL			
				System.out.println("T Final: "+tFin);
				tTotal=tFin-tInicio;//SE CALCULA EL TIEMPO TOTAL DE TRABAJO
				formato = (int) tTotal;
				minutos=(int)formato/60000;
				banderaTiempo=formato-(minutos*60000);
				segundos = (int) banderaTiempo/1000;
				milis=(int) formato - (minutos*60000) - (segundos*1000);
				System.out.println("Tiempo total: "+formato+" ms = "+minutos+" min "+segundos+" seg "+milis+" ms");
				//System.out.println("formato = "+formato);
				panel.remove(texto);
				panel.remove(tiempoResultante);
				texto=new JLabel("Tiempo total transcurrido en "+totalVueltas+" traslaciones de la tierra");
		        texto.setForeground(Color.ORANGE);
		        texto.setBounds(20,395,800,40);
		        panel.add(texto);
				tiempoResultante=new JLabel(""+formato+" ms = "+minutos+" min "+segundos+" seg "+milis+" ms");
		        tiempoResultante.setForeground(Color.orange);
		        tiempoResultante.setBounds(20,430,370,40);
		        panel.add(tiempoResultante);
				inic=false;
				tiempo=true;
				tierra.vueltas=0;
			}
		}
	}
	public void actualizaObjetos(){		
		sol.setVelocidad(velT, velR);//
		mercurio.setVelocidad(velT, velR);//.pintar();
		venus.setVelocidad(velT, velR);//.pintar();
		tierra.setVelocidad(velT, velR);//.pintar();
		marte.setVelocidad(velT, velR);//.pintar();
		jupiter.setVelocidad(velT, velR);//.pintar();
		tierra.vueltas=0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!inic) {
			if(e.getSource()==botIncrementarVR) {
				velR++;
				if(velR>10)
					velR=10;
				panel.remove(velRotacion);
		        velRotacion=new JLabel(""+velR);
		        velRotacion.setBounds(110,150,220,40);
		        velRotacion.setForeground(Color.green);
		        panel.add(velRotacion);
		        principal.add(panel);
				principal.repaint();
			}
			if(e.getSource()==botReducirVR) {
				velR--;
				panel.remove(velRotacion);
		        velRotacion=new JLabel(""+velR);
		        velRotacion.setForeground(Color.green);
		        velRotacion.setBounds(110,150,220,40);
		        panel.add(velRotacion);
		        principal.add(panel);
				principal.repaint();
			}
			if(e.getSource()==botIncrementarVT) {
				velT++;
				if(velT>10)
					velT=10;
				panel.remove(velTraslacion);
				velTraslacion=new JLabel(""+velT);
				velTraslacion.setForeground(Color.green);
				velTraslacion.setBounds(110,220,220,40);
		        panel.add(velTraslacion);
		        principal.add(panel);
				principal.repaint();
			}
			if(e.getSource()==botReducirVT) {
				velT--;
				if(velT<0)
					velT=0;
				panel.remove(velTraslacion);
				velTraslacion=new JLabel(""+velT);
				velTraslacion.setForeground(Color.green);
		        velTraslacion.setBounds(110,220,220,40);
		        panel.add(velTraslacion);
		        principal.add(panel);
				principal.repaint();
			}
			if(e.getSource()==incremetaTraslaciones) {
				totalVueltas++;
				if(totalVueltas>10)
					totalVueltas=10;
				panel.remove(cantVueltas);
				cantVueltas=new JLabel(""+totalVueltas);
				cantVueltas.setForeground(Color.green);
				cantVueltas.setBounds(110,290,220,40);
		        panel.add(cantVueltas);
		        principal.add(panel);
				principal.repaint();
			}
			if(e.getSource()==reduceTraslaciones) {
				totalVueltas--;
				if(totalVueltas<0)
					totalVueltas=0;
				panel.remove(cantVueltas);
				cantVueltas=new JLabel(""+totalVueltas);
				cantVueltas.setBounds(110,290,220,40);
				cantVueltas.setForeground(Color.green);
		        panel.add(cantVueltas);
		        principal.add(panel);
				principal.repaint();
			}
			if(e.getSource()==start) {
				actualizaObjetos();
				inic=true;
			}
		}
	}

}
