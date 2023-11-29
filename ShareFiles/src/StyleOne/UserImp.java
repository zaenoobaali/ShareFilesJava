package StyleOne;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class UserImp implements IUser , Serializable {
    ArrayList<File> files = new ArrayList();
    private String username;
    //private ArrayList<File> files = new ArrayList<>();
    public UserImp () throws RemoteException {}

    public UserImp (String name) throws RemoteException{
        this.username = name;
    }
    public void setUsername(String name){this.username = name;}
    public void setFiles(File file){
        files.add(file);
    }
    public String getUsername(){
        return username;
    }

    @Override
    public boolean find(String filename) throws RemoteException {
        System.out.println("fffffffff");
        for(int i =0 ; i<files.size() ; i++){
            File f = files.get(i);
            if(f.getName().equals(filename))
                return true;
        }
        return false;
    }
}
