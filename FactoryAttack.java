






import java.io.*;
import java.util.*;

class FactoryAttack {
    
    public static Attack getInstance(int x)  {
        Attack attack = null;
    if(x==1) {
        attack = new BruteForceAttack();
    }
    else if(x==2) {
        attack = new DictionaryAttack();
    }
    else {
        System.out.println("There is no other option");
    }
    return attack;
    }
}