package StyleOne;
import java.rmi.*;

public interface IUser extends Remote{
    public boolean find (String filename) throws RemoteException;

}
