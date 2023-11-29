package StyleTwo;

import StyleOne.File;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1190476516911661470L;
    private String username;
    private List<File> files = new ArrayList<>();

    public User (String name) throws RemoteException {
        super();
        this.username = name;
    }

    public void setFiles(File file){
        files.add(file);
    }
    public List<File> getFiles(){
        return files;
    }
    public String getUsername(){
        return username;
    }
    public void setFiles(List<File> _files){
        this.files=_files;
    }

}
