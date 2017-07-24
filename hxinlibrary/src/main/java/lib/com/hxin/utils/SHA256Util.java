package lib.com.hxin.utils;
import java.security.MessageDigest; 

import java.security.NoSuchAlgorithmException;

public class SHA256Util {
	  public static final String ALGORITHM = "SHA-256";



	    public static String SHA256Encrypt(String orignal) { 

	        MessageDigest md = null; 

	        try { 

	            md = MessageDigest.getInstance(ALGORITHM); 

	        } catch (NoSuchAlgorithmException e) { 

	            e.printStackTrace(); 

	        } 

	        if (null != md) { 

	            byte[] origBytes = orignal.getBytes(); 

	            md.update(origBytes); 

	            byte[] digestRes = md.digest(); 

	            String digestStr = getDigestStr(digestRes); 

	            return digestStr; 

	        }
	        return null; 

	    }



	    private static String getDigestStr(byte[] origBytes) { 

	        String tempStr = null; 

	        StringBuilder stb = new StringBuilder(); 

	        for (int i = 0; i < origBytes.length; i++) { 


	            tempStr = Integer.toHexString(origBytes[i] & 0xff); 

	            if (tempStr.length() == 1) { 

	                stb.append("0"); 

	            } 

	            stb.append(tempStr);



	        } 

	        return stb.toString(); 

	    }


}
