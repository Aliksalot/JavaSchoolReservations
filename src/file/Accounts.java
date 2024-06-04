package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Accounts {
  public static boolean createAccount(String username, String password){
    try{
      File accountsFile = new File("accounts.txt");
      if(!accountsFile.exists()){
        accountsFile.createNewFile();
      }

      FileWriter wr = new FileWriter(accountsFile, true);
      wr.append(username + " " + password + "\n");
      wr.close();
    }catch(IOException e){
      System.out.println("error");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  public static String getPasswordByAccountName(String username){

    try{
      File accountsFile = new File("accounts.txt");

      Scanner rd = new Scanner(accountsFile);

      while(rd.hasNextLine()){
        var line = rd.nextLine();

        if(!line.contains(username))
          continue;

        var password = line.split(" ")[1];
        rd.close();
        return password;
      }

      rd.close();
    }catch(IOException e){
      System.out.println("some error idk");
    }catch(Exception e){
      System.out.println("some error idk");
    }
    return "";
  }

}
