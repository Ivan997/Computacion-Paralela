//16310034 - Ivan Emmanuel Arredondo Martinez

public class MiClienteRMI2 {
    public static void main(String[] args)//Se aceptan 2 argumentos, la ip en red LAN del servidor y el puerto
    {
        try{
            MiInterfazRemota mir = (MiInterfazRemota) java.rmi.Naming.lookup("//"+args[0]+":"+args[1]+"/PruebaRMI2");

            mir.miMetodo1("holi");
            int i = mir.miMetodo2();

            System.out.println("Valor de miMetodo2: " + i);

            for (int j = 0; j < i; j++) {
                mir.miMetodo1("for Local"+(j+1));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error, no encuentro: " + e.getMessage());
        }
    }
}
