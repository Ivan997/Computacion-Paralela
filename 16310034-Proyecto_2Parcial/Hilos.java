//16310034 - Ivan Emmanuel Arredondo Martinez
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hilos extends JFrame{

	static JPanel panel = new JPanel();
	static int velT = 2, velR = 5, totalVueltas = 1;
	static boolean inic = false, tiempo = true;
	static Hilos principal = new Hilos();
	static Sol sol = new Sol(principal, panel, 0.037);
	static Mercurio mercurio = new Mercurio(principal, panel, 0.017);
	static Venus venus = new Venus(principal, panel, 0.0042);// jfrme, jpanel, grado de rotacion en radianes
	static Tierra tierra = new Tierra(principal, panel, 1);
	static Marte marte = new Marte(principal, panel, 1.026);
	static Jupiter jupiter = new Jupiter(principal, panel, 2.4);
	static PaneldeControl panelControl = new PaneldeControl(panel, principal, velT, velR, totalVueltas, inic, tiempo);
	static AnalizadordeSistema system = new AnalizadordeSistema(panel, principal, "Concurrente");
	

	public Hilos() {
		super("Sistema Solar Concurrente");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		getContentPane().setLayout(new FlowLayout());

		panel.setBackground(Color.black);
		panel.setPreferredSize(new Dimension(1360, 700));
		panel.setLayout(null);
	}

	public synchronized void repintar(){
		principal.setVisible(true);
	}

	public void actualizaObjetos(int velTT, int velRR,int totalVueltass){		
		velT = velTT; 
		velR = velRR;
		totalVueltas = totalVueltass;
		sol.setVelocidad(velT, velR) ;
		mercurio.setVelocidad(velT, velR) ;
		venus.setVelocidad(velT, velR); 
		tierra.setVelocidad(velT, velR); 
		marte.setVelocidad(velT, velR); 
		jupiter.setVelocidad(velT, velR); 
		tierra.vueltas=0;
	}
	
}
