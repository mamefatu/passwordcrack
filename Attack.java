import java.io.*;
import java.util.*;

interface Attack  {

    public void AttackPassword(User user);
   
}

 class DictionaryAttack implements Attack  {
    public void AttackPassword(User user)  {
        int count = 0;
        try {
            File myFile = new File("dicofile.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String password = myReader.nextLine();
                System.out.println(password);
                count++;
                if(user.authentificate(password)) {
                    System.out.println("Password hacked successfully in " + count + " attempts : " + password);
                    myReader.close();
                    return;
                }
            }
            System.out.println("Password not foud");
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}


class BruteForceAttack implements Attack {

    public void AttackPassword(User user){
      
    String []arr = { "a", "b", "c","d","e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v","w", "x", "y", "z"};
      String[] ml = arr;
    
    int X = 12;  
    int attempts=0, count = ml.length;
    String pwd = "";

   
    for(int z = 4; z < X - 1; z++)
    {
        Vector<String> tmp = new Vector<String>();
    
        for(int i = 0; i < arr.length; i++)
        {
            for(int k = 0; k < ml.length; k++)
            {
                    tmp.add(ml[k] + arr[i]);
                    count += 1;
            }
        }                
                   

        for(int i = 0; i < tmp.size(); i++)
        {
            System.out.println(tmp.get(i) + " ");
            attempts++;
            pwd = tmp.get(i);
             if(user.authentificate(pwd))
                    {
                        System.out.println("Password suucessfully hacked in " +  attempts + " attempts  ! :" + pwd);
                        return;
                    }
        }
        ml = tmp.toArray(new String[tmp.size()]);;
    }
}
}