//16310034 - Ivan Emmanuel Arredondo Martinez

import java.rmi.*;
import java.rmi.activation.*;
import java.util.Properties;
import java.net.InetAddress;

public class MiClaseRemota2 extends Activatable implements MiInterfazRemota{
    public MiClaseRemota2(ActivationID a, MarshalledObject m) throws RemoteException{        
        super(a,0);
    }

    public void miMetodo1(String txt) throws RemoteException{
        System.out.println("miMetodo1(), texto: "+txt);
    }
    public int miMetodo2() throws RemoteException{
        return 5;
    }

    public static void main(String[] args) {
        System.out.println("Entra a main!!!");
        try {
            System.setProperty("java.rmi.server.hostname", args[0]);

            System.setSecurityManager(new RMISecurityManager());
            //se establece el archivo de política de seguridad
            Properties p = new Properties();
            p.put("java.security.policy","java.policy");

            //Necesitamos un grupo de activacion para activar objetos
            //remotos y los puedan acceder los clientes
            ActivationGroupDesc.CommandEnvironment ace=null;
            ActivationGroupDesc ejemplo=new ActivationGroupDesc(p, ace);

            System.out.println("ejemplo: "+ejemplo.toString());

            //Se registra el grupo creado con el ActivationGroupDesc,
            //y se obtiene el identificador del registro
            ActivationGroupID agi=ActivationGroup.getSystem().registerGroup(ejemplo);

            //Objeto para indicar datos de inicializacion, si se requieren
            MarshalledObject m = null;

            //Descripcion y registro del objeto en el demonio rmid 
            ActivationDesc desc = new ActivationDesc(agi, "MiClaseRemota2", 
            "file:///home/ivan/Documentos/7M2/Computacion_Paralela/3P/02-RMI_Automatico/", m);

            System.out.println("desc: "+desc.toString());

            MiInterfazRemota mir = (MiInterfazRemota) Activatable.register(desc);

            Naming.rebind("//"+InetAddress.getLocalHost().getHostAddress()+":"+args[1]+"/PruebaRMI2",mir);            

            //if(mir.ActivatableRef.remoteRef!=null)
                System.out.println("********Inicializacion finalizada correctamente!*******");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            System.exit(0);
        }
    }
}