package StyleOne;

import StyleOne.UserImp;

import java.rmi.*;
import java.util.ArrayList;

public interface ICoordinator extends Remote{
    public void register(UserImp u ,String name) throws RemoteException;
    public UserImp search(String filename) throws RemoteException;
    public ArrayList<UserImp> getUsers() throws RemoteException;
}
