/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Console;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author User
 */
public class Criptografia {
    
    
   public static String getMD5(String texto){
       try{
           MessageDigest md = MessageDigest.getInstance("MD5");
           
           byte[] messageDigest = md.digest(texto.getBytes());
           
           BigInteger no = new BigInteger(1,messageDigest);
           
           String hashtext = no.toString(16);
           
           while (hashtext.length() <32){
               hashtext = "0" + hashtext;
           }
           return hashtext;
       }
       catch(NoSuchAlgorithmException e){
       throw new RuntimeException (e);
   }
   } 
    
    
}
