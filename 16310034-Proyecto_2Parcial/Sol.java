//16310034 - Ivan Emmanuel Arredondo Martinez
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sol extends Planetas{
	public Sol(JFrame marco, JPanel panel, double rotacion) {
		this.marco = marco;
		this.panel = panel;
		this.rotacion=rotacion;
		this.rotacionbandera=rotacion;
		this.cuerpoCeleste=new ImageIcon("./sol.png"); 
	}
	public Sol(JFrame marco, JPanel panel) {
		this.marco = marco;
		this.panel = panel;
		this.cuerpoCeleste=new ImageIcon("./sol.png"); 
	}

	public void setVelocidad(int velT, int velR) {
		this.rotacion=this.rotacionbandera*velR;
	}

	@Override
	public void pintar() {
		BufferedImage bi = new BufferedImage(cuerpoCeleste.getIconWidth(),cuerpoCeleste.getIconHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		cuerpoCeleste.paintIcon(null, g, 0, 0);
		bi=rotar(bi,rotacion);
		cuerpoCeleste = new ImageIcon(bi);
		
		int ancho=(int) panel.getWidth();
		int alto=(int) panel.getHeight();
		int posCuerpoCelestex= (int) (ancho/2 - this.anchoCuerpoCeleste/2);
		int posCuerpoCelestey= (int) (alto/2 - this.altoCuerpoCeleste/2);
		label.setBounds(posCuerpoCelestex,posCuerpoCelestey,this.anchoCuerpoCeleste, this.altoCuerpoCeleste);
		label.setIcon(new ImageIcon(cuerpoCeleste.getImage().getScaledInstance(this.anchoCuerpoCeleste,this.altoCuerpoCeleste,Image.SCALE_SMOOTH)));
		panel.add(label);
        marco.add(panel);
        marco.repaint();
	}
	
}
