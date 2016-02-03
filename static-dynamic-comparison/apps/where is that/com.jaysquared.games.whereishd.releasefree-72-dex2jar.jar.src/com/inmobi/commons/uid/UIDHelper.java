package com.inmobi.commons.uid;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thirdparty.Base64;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class UIDHelper
{
  private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  private static String b = null;
  
  static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
      byte[] arrayOfByte = new byte[paramString1.length];
      paramString2 = paramString2.getBytes("UTF-8");
      int i = 0;
      while (i < paramString1.length)
      {
        arrayOfByte[i] = ((byte)(paramString1[i] ^ paramString2[(i % paramString2.length)]));
        i += 1;
      }
      paramString1 = new String(Base64.encode(arrayOfByte, 2), "UTF-8");
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.debug("[InMobi]-4.1.1", "Exception in xor with random integer", paramString1);
    }
    return "";
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt, Cipher paramCipher)
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (paramInt == 1) {}
    int j = paramArrayOfByte.length;
    Object localObject3 = new byte[64];
    Object localObject1 = new byte[0];
    paramInt = 0;
    Object localObject4;
    Object localObject2;
    if (paramInt < j)
    {
      localObject4 = localObject3;
      localObject2 = localObject1;
      if (paramInt > 0)
      {
        localObject4 = localObject3;
        localObject2 = localObject1;
        if (paramInt % 64 == 0)
        {
          localObject2 = a((byte[])localObject1, paramCipher.doFinal((byte[])localObject3));
          if (paramInt + 64 <= j) {
            break label124;
          }
        }
      }
    }
    label124:
    for (int i = j - paramInt;; i = 64)
    {
      localObject4 = new byte[i];
      localObject4[(paramInt % 64)] = paramArrayOfByte[paramInt];
      paramInt += 1;
      localObject3 = localObject4;
      localObject1 = localObject2;
      break;
      return a((byte[])localObject1, paramCipher.doFinal((byte[])localObject3));
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      try
      {
        if (!"".equals(paramString1.trim()))
        {
          paramString2 = MessageDigest.getInstance(paramString2);
          paramString2.update(paramString1.getBytes());
          paramString1 = paramString2.digest();
          paramString2 = new StringBuffer();
          int i = 0;
          while (i < paramString1.length)
          {
            paramString2.append(Integer.toString((paramString1[i] & 0xFF) + 256, 16).substring(1));
            i += 1;
          }
          paramString1 = paramString2.toString();
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        Log.debug("[InMobi]-4.1.1", "Exception in getting ODIN-1", paramString1);
        return null;
      }
    }
    return "TEST_EMULATOR";
  }
  
  public static String byteToHex(byte paramByte)
  {
    try
    {
      Object localObject = new char[16];
      Object tmp6_5 = localObject;
      tmp6_5[0] = 48;
      Object tmp11_6 = tmp6_5;
      tmp11_6[1] = 49;
      Object tmp16_11 = tmp11_6;
      tmp16_11[2] = 50;
      Object tmp21_16 = tmp16_11;
      tmp21_16[3] = 51;
      Object tmp26_21 = tmp21_16;
      tmp26_21[4] = 52;
      Object tmp31_26 = tmp26_21;
      tmp31_26[5] = 53;
      Object tmp36_31 = tmp31_26;
      tmp36_31[6] = 54;
      Object tmp42_36 = tmp36_31;
      tmp42_36[7] = 55;
      Object tmp48_42 = tmp42_36;
      tmp48_42[8] = 56;
      Object tmp54_48 = tmp48_42;
      tmp54_48[9] = 57;
      Object tmp60_54 = tmp54_48;
      tmp60_54[10] = 97;
      Object tmp66_60 = tmp60_54;
      tmp66_60[11] = 98;
      Object tmp72_66 = tmp66_60;
      tmp72_66[12] = 99;
      Object tmp78_72 = tmp72_66;
      tmp78_72[13] = 100;
      Object tmp84_78 = tmp78_72;
      tmp84_78[14] = 101;
      Object tmp90_84 = tmp84_78;
      tmp90_84[15] = 102;
      tmp90_84;
      localObject = new String(new char[] { localObject[(paramByte >> 4 & 0xF)], localObject[(paramByte & 0xF)] });
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String encryptRSA(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    try
    {
      Object localObject1 = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
      Object localObject2 = new BigInteger("010001", 16);
      localObject1 = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec((BigInteger)localObject1, (BigInteger)localObject2));
      localObject2 = Cipher.getInstance("RSA/ECB/nopadding");
      ((Cipher)localObject2).init(1, (Key)localObject1);
      paramString = new String(Base64.encode(a(paramString.getBytes("UTF-8"), 1, (Cipher)localObject2), 0));
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.debug("[InMobi]-4.1.1", "Exception in encryptRSA", paramString);
    }
    return null;
  }
  
  public static String getAndroidId(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
          return (String)localObject2;
        }
        catch (Exception paramContext)
        {
          Log.internal("commons", "Unable to retrieve android id.");
        }
        localException = localException;
        Log.internal("commons", "Unable to retrieve android id.");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return (String)localObject1;
  }
  
  public static String getAppId()
  {
    return b;
  }
  
  public static String getFBId(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getContentResolver().query(a, new String[] { "aid" }, null, null, null);
      if ((paramContext != null) && (paramContext.moveToFirst()))
      {
        paramContext = paramContext.getString(paramContext.getColumnIndex("aid"));
        if (paramContext != null)
        {
          int i = paramContext.length();
          if (i != 0) {
            return paramContext;
          }
        }
        return null;
      }
    }
    catch (Exception paramContext)
    {
      Log.internal("[InMobi]-4.1.1", "Unable to retrieve Facebook attrib id: " + paramContext);
      return null;
    }
    paramContext = null;
    return paramContext;
  }
  
  public static String getODIN1(String paramString)
  {
    return b(paramString, "SHA-1");
  }
  
  public static String getRSAKeyVersion()
  {
    return "1";
  }
  
  public static String getUM5(String paramString)
  {
    return b(paramString, "MD5");
  }
  
  public static void setAppId(String paramString)
  {
    b = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/uid/UIDHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */