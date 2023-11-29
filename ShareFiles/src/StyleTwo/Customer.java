package StyleTwo;

import StyleOne.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    public Customer() throws RemoteException {}
    public static void main(String args[]){
        try {
            Registry registry = LocateRegistry.getRegistry(6666);
            CoordinatorIn IC = (CoordinatorIn) registry.lookup("ShareFiles");
            System.out.println("client..set your name");
            Scanner input = new Scanner(System.in);
            String name = input.next();
            User u = new User(name);
            System.out.println("Set number file you want share ");
            int numf = input.nextInt();
            for (int f = 0 ; f < numf ; f++) {
                System.out.println("set file name ");
                String fileN = input.next();
                File file = new File(fileN, 22);
                u.setFiles(file);
            }
            IC.register(u,u.getFiles());
            boolean findmore = true;
            do {
                System.out.println("//////////////////\n" +
                        "1 - search \n" +
                        "2 - set files\n" +
                        "3 - view the users in the Group\n" +
                        "4 - Exit ... ");
                int ch = input.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Write the file name you want search for ..");
                        int i = 1;
                        String fn = input.next();
                        List<User> addnames = IC.search(fn);
                        System.out.println("This users have the file you want : ");
                        for (User N : addnames) {
                            System.out.println(i + " - User Name :" + N.getUsername());
                            i++;
                        }
                        System.out.println("there are a " + (i - 1)+" user/s ,\n " +
                                "choice the user you want download from ");
                        int index = input.nextInt();
                        System.out.println("Downloading from "+ addnames.get(index-1).getUsername());
                        break;
                    case 2:
                        System.out.println("Write The File Name You want set in your files ..");
                        String fn1 = input.next();
                        File f = new File(fn1, 22);
                        u.setFiles(f);
                        break;
                    case 3:
                        System.out.println("There are you member group ");
                    List<User> groupU = IC.allusers();
                    System.out.println("size "+ groupU.size());
                    for(int j = 0 ; j< groupU.size(); j++){
                        User uim = groupU.get(j);
                        System.out.println("User Name : "+ uim.getUsername());
                    }
                        break;
                    case 4:
                        findmore=false;
                }
            }while (findmore);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
