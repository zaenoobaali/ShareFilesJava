package StyleOne;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import static StyleOne.CoordinatorImp.Inti;

public class Server extends CoordinatorImp{

    protected Server() throws RemoteException {
    }

    public static void main(String args[]){
        try {
            LocateRegistry.createRegistry(6666);
            ICoordinator IC = new CoordinatorImp(Inti());
            Registry registry = LocateRegistry.getRegistry("localhost",6666);
            //UnicastRemoteObject.exportObject(IC);
            registry.bind("share", IC);

            System.err.println("Server is Ready ....");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
