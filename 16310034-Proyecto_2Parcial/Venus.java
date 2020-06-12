import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
         
public class Venus extends Planetas{
	public boolean positivo=true; 
	int paso=3, pasobandera=3;
	public Venus(JFrame marco, JPanel panel) {
		this.marco = marco;
		this.panel = panel;
		this.setValores(40, 40, 30, 0, 170);//Ancho del planeta, alto del planeta, separacionx, separaciony,tamaniosAnteriores
		this.cuerpoCeleste= new ImageIcon("./venus.png");
	}
	public Venus(JFrame marco, JPanel panel, double rotacion) {
		this.marco = marco;
		this.panel = panel;
		this.setValores(40, 40, 30, 0, 170);//Ancho del planeta, alto del planeta, separacionx, separaciony,tamaniosAnteriores
		this.cuerpoCeleste= new ImageIcon("./venus.png");
		this.rotacion=rotacion;
		this.rotacionbandera=rotacion;
	}

	public void setVelocidad(int velT, int velR) {
		this.paso=pasobandera+velT;
		this.rotacion=rotacionbandera*velR;
	}
	
	@Override
	public void pintar() {
		int ancho=(int) panel.getWidth();//screenSize.getWidth();
		int alto=(int) panel.getHeight();//screenSize.getHeight();
		anchoCuerpoCeleste =30;
		altoCuerpoCeleste=30;
		posCuerpoCelestex= (int) (ancho/2 - anchoCuerpoCeleste-(tamaniosAnteriores/2)-separacionx);
		posCuerpoCelestey= (int) (alto/2 - altoCuerpoCeleste/2-separaciony);
		
		BufferedImage bi = new BufferedImage(cuerpoCeleste.getIconWidth(),cuerpoCeleste.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		cuerpoCeleste.paintIcon(null, g, 0, 0);
		bi=rotar(bi,(rotacion*(-1)));
		if(this.firstTime) {
			//System.out.prin
			this.setRadio_posInit((int)(ancho/2 + anchoCuerpoCeleste+40+separacionx),posCuerpoCelestex);
			this.firstTime=false;
		}else {
			bandera=yTraslacion;
			while(bandera==yTraslacion) {
				if(xTraslacion<=radio && positivo) {
					this.constante=1;
					xTraslacion+=paso;
				}else {
					positivo=false;
					xTraslacion-=paso;
					this.constante=(-1);
					if(xTraslacion<=(radio*(-1)))
						positivo=true;
				}
				trasladar();
			}
		}
		cuerpoCeleste = new ImageIcon(bi);
		//System.out.println("posicion en x: "+posCuerpoCelestex+"posicion en y:"+posCuerpoCelestey);
		label.setBounds(posCuerpoCelestex,posCuerpoCelestey,anchoCuerpoCeleste, altoCuerpoCeleste);
		label.setIcon(new ImageIcon(cuerpoCeleste.getImage().getScaledInstance(anchoCuerpoCeleste,altoCuerpoCeleste,Image.SCALE_SMOOTH)));
		panel.add(label);
        marco.add(panel);
        marco.repaint();
	}
}
