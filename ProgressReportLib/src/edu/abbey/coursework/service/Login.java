package edu.abbey.coursework.service;

import edu.abbey.coursework.model.Credentials;

import javax.security.sasl.AuthenticationException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public abstract class Login {

    public void login(Credentials credentials) 
            throws NoSuchAlgorithmException, AuthenticationException, SQLException {
        
        byte[] inputPwdHash = generatePasswordHash(credentials.getPassword());

        String inputPwdHashString = bytesToHex(inputPwdHash);
        
        String dbPwdHash = getPassworFromDB(credentials.getUsername());
        
         if(!inputPwdHashString.equals(dbPwdHash)){
            throw new AuthenticationException("Invalid username or password");
        }

    }

    private byte[] generatePasswordHash(String password) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(
                password.getBytes(StandardCharsets.UTF_8));        
    }
    
    protected abstract String getPassworFromDB(String userName) throws SQLException;
    
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
}


/*


*/