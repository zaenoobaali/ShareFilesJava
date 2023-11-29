package StyleOne;

import StyleOne.File;
import StyleOne.UserImp;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CoordinatorImp extends UnicastRemoteObject implements ICoordinator {
     ArrayList<UserImp> users;

     CoordinatorImp() throws RemoteException {
         super();
     }

    protected CoordinatorImp(ArrayList<UserImp> list) throws RemoteException {
        super();
        this.users=list;
    }

    protected static ArrayList<UserImp> Inti() throws RemoteException {
        File f = new File("file1",22);
        File f1 = new File("file2",22);
        File f2 = new File("file3",22);
        File f3 = new File("file4",22);
        File f4 = new File("file5",22);
        UserImp u1 = new UserImp("user1");
        UserImp u2 = new UserImp("user2");
        UserImp u3 = new UserImp("user3");
        u1.setFiles(f);  u1.setFiles(f1);
        u2.setFiles(f2); u2.setFiles(f4);
        u3.setFiles(f3);
        ArrayList<UserImp> lists = new ArrayList<>();
        lists.add(u1);  lists.add(u2);  lists.add(u3);
        System.out.println("init ..");
        return lists;
    }

    @Override
    public void register(UserImp u , String name) throws RemoteException {
         System.out.println("rrrrrrrr");
         u = new UserImp();
         u.setUsername(name);
         users.add(u);
    }

    @Override
    public UserImp search(String filename) throws RemoteException {
         System.out.println("ssssss");
        for(int i =0 ; i<users.size() ; i++){
            UserImp u = users.get(i);
            if(u.find(filename))
                return u;
        }
        return null;
    }

    @Override
    public ArrayList<UserImp> getUsers() throws RemoteException {
        System.out.println("users..");
        return this.users;
    }

}
