//16310034 - Ivan Emmanuel Arredondo Martinez
public interface MiInterfazRemota extends java.rmi.Remote{
    public void miMetodo1(String texto) throws java.rmi.RemoteException;
    public int miMetodo2() throws java.rmi.RemoteException;
}
