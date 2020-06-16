import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiInterfazRemota extends Remote{
    public void miMetodo1(String txt) throws RemoteException;
    public int miMetodo2() throws RemoteException;
}