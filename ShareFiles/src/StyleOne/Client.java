package StyleOne;

import StyleOne.ICoordinator;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    protected Client ()throws RemoteException{
    }
    public static void main(String args[]){
        try {
            Registry registry = LocateRegistry.getRegistry(6666);
            ICoordinator IC = (ICoordinator) registry.lookup("share");
            System.out.println("client..set your name");
            Scanner input = new Scanner(System.in);
            String name = input.next();
            IUser u =  new UserImp();
            System.out.println("register..");
            IC.register((UserImp)u , name);
            boolean More = true;
            do {
                System.out.println("1 - search \n" +
                        "2 - set files\n" +
                        "3 - view the users in the Group \n" +
                        "4 - Exit... ");
                int ch = input.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Write the file name you want search for ..");
                        Scanner inputfile = new Scanner(System.in);
                        String fn = inputfile.next();
                        UserImp addname = IC.search(fn);
                        if (addname == null)
                            System.out.println("This file not in the group ");
                        else
                            System.out.println("Download file from " + addname.getUsername());
                        break;
                    case 2:
                        System.out.println("Write The File Name You want set in your files ..");
                        String fn1 = input.next();
                        File f = new File(fn1, 22);
                        ((UserImp) u).setFiles(f);
                        break;
                    case 3:
                        System.out.println("There are you member group ");
                        ArrayList<UserImp> groupU = IC.getUsers();
                        System.out.println("size " + groupU.size());
                        for (int i = 0; i < groupU.size(); i++) {
                            UserImp uim = groupU.get(i);
                            System.out.println("User Name : " + uim.getUsername());
                        }
                        break;
                    case 4:
                        More = false;
                        break;
                }
            }
            while (More);


        }catch (Exception e){
            System.out.println("error : " + e);
        }
    }
}
