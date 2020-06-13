//16310034 - Ivan Emmanuel Arredondo Martinez
public class MiClienteRMI{
    public static void main(String[] args) {
        try {
            MiInterfazRemota mir = (MiInterfazRemota) java.rmi.Naming.lookup("//"+args[0]+":"+args[1]+"/PruebaRMI");

            for (int i = 0; i < mir.miMetodo2(); i++) {
                mir.miMetodo1("Cliente local");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
javac MiClienteRMI.java
java MiClienteRMI 127.0.1.1 1234
*/
