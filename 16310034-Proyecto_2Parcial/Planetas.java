//16310034 - Ivan Emmanuel Arredondo Martinez
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Planetas extends JPanel{

	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 JLabel label = new JLabel();
	 JPanel panel = new JPanel();
	 JFrame marco;
	 ImageIcon cuerpoCeleste;// = new ImageIcon("./planetas/sol.png"); 
	 double rotacion=0.01, rotacionbandera=0.01;
	 int anchoCuerpoCeleste =80, altoCuerpoCeleste=80, posCuerpoCelestex=0,posCuerpoCelestey=0, separacionx=0, separaciony=0;
	 int xTraslacion=0, yTraslacion=0, radio=0, tamaniosAnteriores=80, constante=1, bandera=0;
	 boolean firstTime=true;
	 
	 void setValores(int ancho, int alto, int separacionX, int separacionY, int tamaniosAnteriores) {
		this.anchoCuerpoCeleste=ancho;
		this.altoCuerpoCeleste=alto;
		this.separacionx=separacionX;
		this.separaciony=separacionY;
		this.tamaniosAnteriores=tamaniosAnteriores;
	}

	void pintar() {}
	
	public void setRadio_posInit(int radio, int posInit) {
		//System.out.println("ancho de pantalla/2: "+(screenSize.getWidth()/2)+" Distancia de la orilla "+(screenSize.getWidth()/2 - anchoCuerpoCeleste-tamaniosAnteriores/2));
		//System.out.println("alto de pantalla/2: "+(screenSize.getHeight()/2)+" Distancia de la orilla "+((screenSize.getHeight()/2) - altoCuerpoCeleste/2-this.separaciony));
		this.radio=anchoCuerpoCeleste+tamaniosAnteriores/2;
		this.xTraslacion=posInit;
		//System.out.println("Radio = "+this.radio+"xTraslacion="+this.xTraslacion);
	}
	
	public void trasladar() {	    
	    yTraslacion=(int) Math.sqrt(Math.pow(radio, 2)-Math.pow(xTraslacion, 2));
	    this.posCuerpoCelestex=660+xTraslacion;
	    this.posCuerpoCelestey=329-(yTraslacion*constante);
	    return;
	}
	 
	static BufferedImage rotar(BufferedImage image, double angle) { 
	    int w = image.getWidth(), h = image.getHeight(); 
	    int neww=w, newh=h;
	    GraphicsConfiguration gc = getDefaultConfiguration(); 
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT); 
	    Graphics2D g = result.createGraphics(); 
	    g.translate((neww - w)/2, (newh - h)/2); 
	    g.rotate(angle, w/2, h/2); 
	    g.drawRenderedImage(image, null); 
	    g.dispose(); 
	    return result; 
	} 
	
	static GraphicsConfiguration getDefaultConfiguration() { 
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
	    GraphicsDevice gd = ge.getDefaultScreenDevice(); 
	    return gd.getDefaultConfiguration(); 
	}
}
