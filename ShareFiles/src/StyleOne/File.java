package StyleOne;

import java.io.Serializable;
import java.rmi.RemoteException;

public class File implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private long size;

    public File () throws RemoteException {}

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

}
