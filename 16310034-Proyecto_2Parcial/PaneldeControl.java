//16310034 - Ivan Emmanuel Arredondo Martinez
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaneldeControl implements ActionListener{

    
    static int velT = 1, velR = 1, totalVueltas = 1;
	static boolean inic = false, tiempo = true;
    static JPanel panel = new JPanel();
    static Hilos principal = new Hilos();
    static JButton botIncrementarVR, botReducirVR, botIncrementarVT, botReducirVT, start, stop, incremetaTraslaciones,reduceTraslaciones;
    static JLabel texto, velTraslacion, velRotacion, cantVueltas, tiempoResultante;
    
    public PaneldeControl(JPanel pane, Hilos p, int velTT,int velRR,int totalVueltass,boolean inicc,boolean tiempoo){
        panel=pane;
        principal = p;
        velT=velTT; velR=velRR; totalVueltas=totalVueltass;
        inic=inicc; tiempo=tiempoo;

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

	public void muestraTiempo(double tInicio,double tFin,double tTotal){
		int formato, minutos, banderaTiempo, segundos, milis;
		formato = (int) tTotal;
		minutos=(int)formato/60000;
		banderaTiempo=formato-(minutos*60000);
		segundos = (int) banderaTiempo/1000;
		milis=(int) formato - (minutos*60000) - (segundos*1000);
		System.out.println("Tiempo total: "+formato+" ms = "+minutos+" min "+segundos+" seg "+milis+" ms");
		//System.out.println("formato = "+formato);
		panel.remove(texto);
		panel.remove(tiempoResultante);
		panel.remove(texto);
		texto=new JLabel("Tiempo total transcurrido en "+totalVueltas+" traslaciones de la tierra");
		texto.setForeground(Color.ORANGE);
		texto.setBounds(20,395,800,40);
		panel.add(texto);
		tiempoResultante=new JLabel(""+formato+" ms = "+minutos+" min "+segundos+" seg "+milis+" ms");
		tiempoResultante.setForeground(Color.orange);
		tiempoResultante.setBounds(20,430,370,40);
		panel.add(tiempoResultante);
	}

	public void muestraVueltas(int vueltas){
		panel.remove(texto);
		texto=new JLabel("Vuelta numero: "+vueltas);
		texto.setForeground(Color.ORANGE);
		texto.setBounds(20,400,800,40);
		panel.add(texto);
	}


    @Override
	public void actionPerformed(ActionEvent e) {
		if(!principal.inic) {
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
				principal.actualizaObjetos(velT, velR, totalVueltas);
                principal.inic=true;
               // System.out.println("=======================================\nSTART "+principal.inic+"\n=======================================\n");
			}
		}
	}
}