package org.apache.a.a.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a
{
  public static MessageDigest a()
  {
    return a("MD5");
  }
  
  public static MessageDigest a(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a().digest(paramArrayOfByte);
  }
  
  public static MessageDigest b()
  {
    return a("SHA-256");
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    return b().digest(paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */