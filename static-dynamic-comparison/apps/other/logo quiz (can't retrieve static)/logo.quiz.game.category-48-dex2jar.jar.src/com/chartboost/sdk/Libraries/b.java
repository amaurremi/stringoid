package com.chartboost.sdk.Libraries;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class b
{
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte != null) {}
    try
    {
      localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      return (byte[])localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    BigInteger localBigInteger = new BigInteger(1, paramArrayOfByte);
    return String.format(Locale.US, "%0" + (paramArrayOfByte.length << 1) + "x", new Object[] { localBigInteger });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */