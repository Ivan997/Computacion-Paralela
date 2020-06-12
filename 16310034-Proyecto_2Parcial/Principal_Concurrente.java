//16310034 - Ivan Emmanuel Arredondo Martinez

import javax.swing.JPanel;

public class Principal_Concurrente extends Thread {

	static Hilos principal = new Hilos();
	static int vueltasTotales = principal.totalVueltas;

	public boolean sol = false, merc = false, ven = false, tie = false, mart = false, jup = false, analisis = false;

	public Principal_Concurrente(String planeta) {
		switch (planeta) {
			case "sol":
				sol = true;
				break;
			case "mercurio":
				merc = true;
				break;
			case "venus":
				ven = true;
				break;
			case "tierra":
				tie = true;
				break;
			case "marte":
				mart = true;
				break;
			case "jupiter":
				jup = true;
				break;
			case "analisis":
				analisis = true;
				break;
			default:
				sol = false;
				merc = false;
				ven = false;
				tie = false;
				mart = false;
				jup = false;
				analisis = false;
				break;
		}
	}

	public static void main(String[] args) {
		Principal_Concurrente sool = new Principal_Concurrente("sol");
		Principal_Concurrente mercurio = new Principal_Concurrente("mercurio");
		Principal_Concurrente venus = new Principal_Concurrente("venus");
		Principal_Concurrente tierra = new Principal_Concurrente("tierra");
		Principal_Concurrente marte = new Principal_Concurrente("marte");
		Principal_Concurrente jupiter = new Principal_Concurrente("jupiter");
		Principal_Concurrente analizar = new Principal_Concurrente("analisis");
		sool.start();
		mercurio.start();
		venus.start();
		tierra.start();
		marte.start();
		jupiter.start();
		analizar.start();
	}

	public void run() {
		System.out.println("RUN!!");
		// principal.setVisible(true);
		// System.out.println();

		if (merc)
			pintarMercurio();
		if (ven)
			pintarVenus();
		if (tie)
			pintarTierra();
		if (mart)
			pintarMarte();
		if (jup)
			pintarJupiter();
		if (sol)
			pintarSol();
		if (analisis)
			pintarAnalisis();
		// principal.pintaBotones();

		principal.repaint();
		principal.setVisible(true);
	}

	private void pintarAnalisis() {
		while (true) {
			principal.system.imprimeUso();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintarMercurio() {
		while(true){
			while (principal.tierra.vueltas < principal.totalVueltas) {
				principal.system.imprime_Estado_Planeta("mercurio",1);
				principal.mercurio.pintar();// principal.repaint();
				principal.repintar();
				principal.system.imprime_Estado_Planeta("mercurio",0);
				
				while (!principal.inic) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(" ");
		}
	}

	public void pintarVenus() {
		while(true){
			while (principal.tierra.vueltas < principal.totalVueltas) {
				principal.system.imprime_Estado_Planeta("venus",1);
				principal.venus.pintar();// principal.repaint();
				principal.repintar();
				principal.system.imprime_Estado_Planeta("venus",0);
				
				while (!principal.inic) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(" ");
		}
	}

	public void pintarTierra() {
		boolean primerRonda=true;
		double tInicio = 0.0, tFin = 0.0, tTotal = 0.0;
		int banderavueltas=-1;
		while (true) {
			while (principal.tierra.vueltas < principal.totalVueltas) {
				principal.system.imprime_Estado_Planeta("tierra",1);
				principal.tierra.pintar();// principal.repaint();
				principal.repintar();
				principal.system.imprime_Estado_Planeta("tierra",0);
				while (!principal.inic) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(primerRonda){
					tInicio = System.currentTimeMillis();
					primerRonda=false;
				}
				if(banderavueltas != principal.tierra.vueltas) {
					banderavueltas=principal.tierra.vueltas;
					principal.panelControl.muestraVueltas(banderavueltas);
				}
			}
			if(principal.tierra.vueltas>=vueltasTotales) {
				tFin=System.currentTimeMillis();
				tTotal=tFin-tInicio;
				principal.panelControl.muestraTiempo(tInicio, tFin, tTotal);
				principal.inic=false;
				principal.tierra.vueltas=0;
				primerRonda=true;
			}
		}
	}
	public void pintarMarte() {
		while(true){
			while (principal.tierra.vueltas < principal.totalVueltas) {
				principal.system.imprime_Estado_Planeta("marte",1);
				principal.marte.pintar();// principal.repaint();
				principal.repintar();
				principal.system.imprime_Estado_Planeta("marte",0);
				
				while (!principal.inic) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(" ");
		}
	}
	public void pintarJupiter() {
		while(true){
			while (principal.tierra.vueltas < principal.totalVueltas) {
				principal.system.imprime_Estado_Planeta("jupiter",1);
				principal.jupiter.pintar();// principal.repaint();
				principal.repintar();				
				principal.system.imprime_Estado_Planeta("jupiter",0);
				while (!principal.inic) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(" ");
		}
	}
	public void pintarSol() {
		while(true){
			while (principal.tierra.vueltas < principal.totalVueltas) {
				principal.system.imprime_Estado_Planeta("sol",1);
				principal.sol.pintar();// principal.repaint();
				principal.repintar();				
				principal.system.imprime_Estado_Planeta("sol",0);
				while (!principal.inic) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(" ");
		}
	}
}
