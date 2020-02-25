/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carreraatletismo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Usuario DAM 2
 */
public class CifradoAES {
    private static Cipher cipher = null;

    public CifradoAES() throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    // Clave -> Clave en base 64
        // 1234567891234567 -> MTIzNDU2Nzg5MTIzNDU2Nw==
        // decode the base64 encoded string
        byte[] decodedKey = Base64.getDecoder().decode("MTIzNDU2Nzg5MTIzNDU2Nw==");

        // rebuild key using SecretKeySpec
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        System.out.println("originalKey: " + decodedKey);

        cipher = Cipher.getInstance("AES");

        String clearText = "hola esto es una prueba de cifrado AES";
        byte[] clearTextBytes = clearText.getBytes("UTF8");
        System.out.println("Texto en claro: " + clearText);

        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        byte[] cipherBytes = cipher.doFinal(clearTextBytes);
        String cipherText = new String(cipherBytes, "UTF8");
        System.out.println("Texto cifrado: " + cipherText);

        cipher.init(Cipher.DECRYPT_MODE, originalKey);
        byte[] decryptedBytes = cipher.doFinal(cipherBytes);
        String decryptedText = new String(decryptedBytes, "UTF8");
        System.out.println("Texto descifrado: " + decryptedText);
    }
    
    
    
    
    }
    
    
    
     
