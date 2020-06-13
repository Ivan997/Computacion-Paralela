//16310034 - Ivan Emmanuel Arredondo Martinez
//ES necesario renombrar el hostname de la computadora servidor, por la IP ESTATICA con la que cuenta la computadora, seguir los siguientes pasos:
//https://stackoverflow.com/questions/15685686/java-rmi-connectexception-connection-refused-to-host-127-0-1-1
public class MiClaseRemota extends java.rmi.server.UnicastRemoteObject implements MiInterfazRemota{
  public MiClaseRemota() throws  java.rmi.RemoteException{}

  public void miMetodo1(String texto) throws  java.rmi.RemoteException{
    System.out.println("Estoy en miMetodo1(), texto enviado: "+texto);
  }

  public int miMetodo2() throws java.rmi.RemoteException{
    return 5;
  }

  public void otroMetodo(){

  }

  public static void main(String[] args) {
    String rmimr="";
    try {
      System.setProperty("java.rmi.server.hostname", ""+args[0]);
      MiInterfazRemota mir = new MiClaseRemota();
      rmimr="//"+java.net.InetAddress.getLocalHost().getHostAddress()+":"+args[1]+"/PruebaRMI";
      //rmimr="//192.168.1.23:"+args[0]+"/PruebaRMI";
      java.rmi.Naming.rebind(rmimr,mir);
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
}

/*
javac MiInterfazRemota.java
javac MiClaseRemota.java
rmic -d . MiClaseRemota
rmiregistry 1234
*/
