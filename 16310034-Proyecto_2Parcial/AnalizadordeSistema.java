//16310034 - Ivan Emmanuel Arredondo Martinez
import java.lang.management.ManagementFactory;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.sun.management.OperatingSystemMXBean;

public class AnalizadordeSistema{
    public static JFrame principal;// = new Principal();
    public static JPanel panel = new JPanel();
    public static JLabel texto, cpuLoadSystem, solR, solT, mercR, mercT, venR, venT, tieR, tieT, marR, marT, jupR, jupT;
    public static double cpuLoadSystemValor;
    OperatingSystemMXBean pcMediciones = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    public AnalizadordeSistema(JPanel pan, JFrame pr, String programa) {
        panel=pan;
        principal=pr;
		texto = new JLabel("16310034 - Ivan Emmanuel Arredondo Martinez");
		texto.setForeground(Color.green);
		texto.setBounds(20, 0, 770, 40);
        panel.add(texto);
		texto = new JLabel("Uso de CPU programa: "+programa);
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, 15, 300, 40);
        panel.add(texto);

        int separacion=30, posInic=450, s1,s2,s3,s4,s5;
        s1=posInic+separacion;
        s2=s1+separacion;
        s3=s2+separacion;
        s4=s3+separacion;
        s5=s4+separacion;
		texto = new JLabel("Sol");
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, posInic, 300, 40);
        panel.add(texto);
		texto = new JLabel("Mercurio");
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, s1, 300, 40);
        panel.add(texto);
		texto = new JLabel("Venus");
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, s2, 300, 40);
        panel.add(texto);
		texto = new JLabel("Tierra");
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, s3, 300, 40);
        panel.add(texto);
		texto = new JLabel("Marte");
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, s4, 300, 40);
        panel.add(texto);
		texto = new JLabel("Jupiter");
		texto.setForeground(Color.YELLOW);
		texto.setBounds(20, s5, 300, 40);
        panel.add(texto);

        if(programa.equals("Concurrente")){
            texto = new JLabel("En este programa corren 7 hilos");//1 por planeta y el de analisis de sistema
            texto.setForeground(Color.YELLOW);
            texto.setBounds(20, 70, 300, 40);
            panel.add(texto);
            texto = new JLabel("1 por planeta y el de analisis de sistema");//
            texto.setForeground(Color.YELLOW);
            texto.setBounds(20, 85, 300, 40);
            panel.add(texto);
        }else{
            texto = new JLabel("En este programa corre 1 hilo, el principal");//1 por planeta y el de analisis de sistema
            texto.setForeground(Color.YELLOW);
            texto.setBounds(20, 70, 300, 40);
            panel.add(texto);
        }

        imprimeUso();
    }

    public void imprimeUso(){
        try {
            panel.remove(cpuLoadSystem);            
        } catch (Exception e) {}
        cpuLoadSystemValor=pcMediciones.getSystemCpuLoad();
        cpuLoadSystemValor=cpuLoadSystemValor*100;

        cpuLoadSystem = new JLabel("Proceso de CPU: "+String.format("%.2f",cpuLoadSystemValor)+"%");
        cpuLoadSystem.setForeground(Color.YELLOW);
        cpuLoadSystem.setBounds(20,35,220,40);
        panel.add(cpuLoadSystem);

        principal.add(panel);
        principal.repaint();
    }

    public void imprime_Estado_Planeta(String planeta, int estado){
        int separacion=30, posInic=450, s1,s2,s3,s4,s5;
        s1=posInic+separacion;
        s2=s1+separacion;
        s3=s2+separacion;
        s4=s3+separacion;
        s5=s4+separacion;
        switch(planeta){
            case "sol":
                try {
                    panel.remove(solR);
                } catch (Exception e) {}
                if(estado==1){
                    solR=new JLabel("Rotando    Trasladando");
                    solR.setForeground(Color.green);
                    solR.setBounds(100, posInic, 300, 40);
                    panel.add(solR);
                }
            break;
            case "mercurio":
                try {
                    panel.remove(mercR);
                } catch (Exception e) {}
                if(estado==1){
                    mercR=new JLabel("Rotando    Trasladando");
                    mercR.setForeground(Color.green);
                    mercR.setBounds(100, s1, 300, 40);
                    panel.add(mercR);
                }
            break;
            case "venus":
                try {
                    panel.remove(venR);
                } catch (Exception e) {}
                if(estado==1){
                    venR=new JLabel("Rotando    Trasladando");
                    venR.setForeground(Color.green);
                    venR.setBounds(100, s2, 300, 40);
                    panel.add(venR);
                }
            break;
            case "tierra":
                try {
                    panel.remove(tieR);
                } catch (Exception e) {}
                if(estado==1){
                    tieR=new JLabel("Rotando    Trasladando");
                    tieR.setForeground(Color.green);
                    tieR.setBounds(100, s3, 300, 40);
                    panel.add(tieR);
                }
            break;
            case "marte":
                try {
                    panel.remove(marR);
                } catch (Exception e) {}
                if(estado==1){
                    marR=new JLabel("Rotando    Trasladando");
                    marR.setForeground(Color.green);
                    marR.setBounds(100, s4, 300, 40);
                    panel.add(marR);    
                }
            break;
            case "jupiter":
                try {
                    panel.remove(jupR);
                } catch (Exception e) {}
                if(estado==1){
                    jupR=new JLabel("Rotando    Trasladando");
                    jupR.setForeground(Color.green);
                    jupR.setBounds(100, s5, 300, 40);
                    panel.add(jupR);
                }
            break;
            default:
                try {
                    panel.remove(solR);
                    panel.remove(mercR);
                    panel.remove(venR);
                    panel.remove(tieR);
                    panel.remove(marR);
                    panel.remove(jupR);
                } catch (Exception e) {}
            break;
        }
        principal.add(panel);
        principal.repaint();
    }
}