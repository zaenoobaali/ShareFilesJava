package StyleTwo;

import StyleOne.File;
import java.rmi.*;
import java.util.List;

public interface CoordinatorIn extends Remote{
    public void register(User u, List<File> files) throws RemoteException;
    public List<User> search(String filename) throws RemoteException;
    public List<User> allusers() throws RemoteException;
}
