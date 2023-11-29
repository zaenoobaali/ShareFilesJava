package StyleTwo;

import StyleOne.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ImpCoordiantor extends UnicastRemoteObject implements CoordinatorIn {

    //private Map<String, List<File>> Users  ;
    private Map<User, List<File>> Users  ;
    public ImpCoordiantor()throws RemoteException{}

    protected ImpCoordiantor(Map<User, List<File>> users ) throws RemoteException {
    super();
    this.Users= users;
    }


    @Override
    public void register(User u , List<File> files) throws RemoteException {
      Users.put(u, files);
    }

    @Override
    public List<User> search(String filename) throws RemoteException {
        List<User> names = new ArrayList<>();
        for(Map.Entry<User,List<File>> entry : Users.entrySet()){
            User key = entry.getKey();
            List<File> files = entry.getValue();
            for (File file : files){
                if(file.getName().equals(filename)){
                    names.add(key);
                }
            }
        }
        return names;
    }

    @Override
    public List<User> allusers() throws RemoteException{
        List<User> allusers = new ArrayList<>();
        for(Map.Entry<User,List<File>> entry : Users.entrySet()){
            User key = entry.getKey();
            allusers.add(key);
        }
        return allusers;
    }

    private static Map<User, List<File>> init () throws  RemoteException{
        Map<User,List<File>> mapping = new HashMap<>();
        File f = new File("file1",22);
        File f1 = new File("file2",22);
        File f2 = new File("file3",22);
        File f3 = new File("file4",22);
        File f4 = new File("file2",22);
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        List<File> fs1 = new ArrayList<>();
        List<File> fs2 = new ArrayList<>();
        List<File> fs3 = new ArrayList<>();
        fs1.add(f);  fs1.add(f1); fs3.add(f2); fs2.add(f3); fs3.add(f4);
        user1.setFiles(fs1); user2.setFiles(fs2); user3.setFiles(fs3);
        mapping.put(user1,fs1);
        mapping.put(user2,fs2);
        mapping.put(user3,fs3);

        return mapping;
    }

    public static void main(String[] args){
        try {
            LocateRegistry.createRegistry(6666);
            ImpCoordiantor IMC = new ImpCoordiantor(init());
            Registry registry = LocateRegistry.getRegistry("localhost",6666);
            registry.bind("ShareFiles",IMC);

            System.err.println("Server is ready ...  ");

        }catch (Exception e){
            System.out.println(e);
        }

    }



}
