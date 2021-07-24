/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morvak;

/**
 *
 * @author Thulani Mpofu ask TOLANY-LANNIE
 */
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom; 
public class HashFunction
{
    public static String hashString(String input)throws NoSuchAlgorithmException{
        String securePasword = get_SHA_224_SecurePassword(input);
        return securePasword;
    }
    
    private static String get_SHA_224_SecurePassword(String passwordToHash)
    {
      
        try {
            // getInstance() method is called with algorithm SHA-224
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            /* digest() method is called 
            / to calculate message digest of the passwordToHash string 
            / returned as array of byte
            */ 
            byte[] digestedMessage = md.digest(passwordToHash.getBytes());
            
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, digestedMessage);
            
            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            }
            
            // return the HashText 
            return hashtext; 
        } 
        catch (NoSuchAlgorithmException e) 
        {
             throw new RuntimeException(e);
        }
        
    }
}
