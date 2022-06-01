import java.util.*;
import java.io.*;

public class PasswordAttack {

    public static void main(String[] args) {
        
        FactoryAttack factoryAttack = new FactoryAttack();

        Scanner sc = new Scanner(System.in);

        User user = new User();

        System.out.println("Welcome for your registration !");
        System.out.println("Enter your login:");
        String login = sc.nextLine();
        System.out.println("Enter your password:");
        String pwd = sc.nextLine();

        user.SetLogin(login);
        user.SetPassword(pwd);
      

        System.out.println("What method do you want to use for the crack? Enter 1 for Brut Force method or 2 for Dictionary method");
        int x = sc.nextInt();
        if(x==1)
         {
            Attack bruteForce = factoryAttack.getInstance(1);
            long debut = System.currentTimeMillis();
            bruteForce.AttackPassword(user);
            
            long end = System.currentTimeMillis();
            System.out.println("it tooks "+ (end-debut)+ " milliseconds");
         }
        if(x==2)
         {
            Attack dictionary = factoryAttack.getInstance(2);
            long debut1 = System.currentTimeMillis();
            dictionary.AttackPassword(user);
            long end1 = System.currentTimeMillis();
            System.out.println("it tooks "+ (end1-debut1)+ " milliseconds");
         }
    }
}    