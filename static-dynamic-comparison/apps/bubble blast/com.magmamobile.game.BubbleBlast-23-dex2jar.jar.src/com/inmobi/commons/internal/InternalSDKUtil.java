package com.inmobi.commons.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.view.Display;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class InternalSDKUtil
{
  public static final String INMOBI_SDK_RELEASE_VERSION = "3.6.1";
  static final String a = "IMCOMMONS_3.6.1";
  private static final String b = "3.6.1";
  private static final String c = "C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B";
  private static final String d = "010001";
  private static final String e = "1";
  private static int f = 0;
  private static String g;
  private static final String h = "getRotation";
  private static final String i = "getOrientation";
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
      byte[] arrayOfByte = new byte[paramString1.length];
      paramString2 = paramString2.getBytes("UTF-8");
      int j = 0;
      for (;;)
      {
        if (j >= paramString1.length) {
          return new String(Base64.encode(arrayOfByte, 2), "UTF-8");
        }
        arrayOfByte[j] = ((byte)(paramString1[j] ^ paramString2[(j % paramString2.length)]));
        j += 1;
      }
      return "";
    }
    catch (Exception paramString1)
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Exception in xor with random integer", paramString1);
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt, Cipher paramCipher)
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (paramInt == 1) {}
    int k = paramArrayOfByte.length;
    Object localObject3 = new byte[64];
    Object localObject1 = new byte[0];
    paramInt = 0;
    if (paramInt >= k) {
      return a((byte[])localObject1, paramCipher.doFinal((byte[])localObject3));
    }
    Object localObject4 = localObject3;
    Object localObject2 = localObject1;
    if (paramInt > 0)
    {
      localObject4 = localObject3;
      localObject2 = localObject1;
      if (paramInt % 64 == 0)
      {
        localObject2 = a((byte[])localObject1, paramCipher.doFinal((byte[])localObject3));
        if (paramInt + 64 <= k) {
          break label124;
        }
      }
    }
    label124:
    for (int j = k - paramInt;; j = 64)
    {
      localObject4 = new byte[j];
      localObject4[(paramInt % 64)] = paramArrayOfByte[paramInt];
      paramInt += 1;
      localObject3 = localObject4;
      localObject1 = localObject2;
      break;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    int j = 0;
    if (j >= paramArrayOfByte1.length) {
      j = k;
    }
    for (;;)
    {
      if (j >= paramArrayOfByte2.length)
      {
        return arrayOfByte;
        arrayOfByte[j] = paramArrayOfByte1[j];
        j += 1;
        break;
      }
      arrayOfByte[(paramArrayOfByte1.length + j)] = paramArrayOfByte2[j];
      j += 1;
    }
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
  
  public static boolean checkNetworkAvailibility(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext.getActiveNetworkInfo() == null) {
      return false;
    }
    return paramContext.getActiveNetworkInfo().isConnected();
  }
  
  public static String encryptRSA(String paramString)
  {
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
      IMLog.debug("IMCOMMONS_3.6.1", "Exception in encryptRSA", paramString);
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
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      return (String)localObject2;
    }
    catch (Exception paramContext)
    {
      return (String)localObject1;
    }
  }
  
  public static String getAndroidIdMD5(Context paramContext)
  {
    try
    {
      paramContext = getAndroidId(paramContext);
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramContext.getBytes());
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int j = 0;
      for (;;)
      {
        if (j >= paramContext.length) {
          return ((StringBuffer)localObject).toString();
        }
        ((StringBuffer)localObject).append(Integer.toString((paramContext[j] & 0xFF) + 256, 16).substring(1));
        j += 1;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      IMLog.internal("IMCOMMONS_3.6.1", "Exception in getting MD5 Android Id", paramContext);
    }
  }
  
  public static String getConnectivityType(Context paramContext)
  {
    int k;
    label79:
    label83:
    do
    {
      try
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
          break label79;
        }
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          break label79;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        int j = paramContext.getType();
        k = paramContext.getSubtype();
        if (j == 1) {
          return "wifi";
        }
        if (j != 0) {
          break label79;
        }
        paramContext = "carrier";
        if (k != 1) {
          break label83;
        }
        return "gprs";
      }
      catch (Exception paramContext)
      {
        IMLog.internal("IMCOMMONS_3.6.1", "Error getting the network info", paramContext);
        return null;
      }
      if (k == 0)
      {
        return "carrier";
        paramContext = null;
      }
      return paramContext;
      if (k == 2) {
        return "edge";
      }
    } while (k != 3);
    return "umts";
  }
  
  public static int getDisplayRotation(Display paramDisplay)
  {
    Object localObject = null;
    try
    {
      Method localMethod1 = Display.class.getMethod("getRotation", null);
      localObject = localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          int j = ((Integer)((Method)localObject).invoke(paramDisplay, null)).intValue();
          return j;
          localNoSuchMethodException1 = localNoSuchMethodException1;
        }
        catch (Exception paramDisplay)
        {
          try
          {
            Method localMethod2 = Display.class.getMethod("getOrientation", null);
            localObject = localMethod2;
          }
          catch (NoSuchMethodException localNoSuchMethodException2) {}
          paramDisplay = paramDisplay;
          return 64537;
        }
      }
    }
    if (localObject != null) {}
    return 64537;
  }
  
  public static String getODIN1(String paramString)
  {
    if (paramString != null) {
      try
      {
        if ("".equals(paramString.trim())) {
          return null;
        }
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new StringBuffer();
        int j = 0;
        for (;;)
        {
          if (j >= paramString.length) {
            return ((StringBuffer)localObject).toString();
          }
          ((StringBuffer)localObject).append(Integer.toString((paramString[j] & 0xFF) + 256, 16).substring(1));
          j += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        IMLog.debug("IMCOMMONS_3.6.1", "Exception in getting ODIN-1", paramString);
      }
    }
  }
  
  public static String getODIN1MD5(String paramString)
  {
    if (paramString != null) {
      try
      {
        if ("".equals(paramString.trim())) {
          return null;
        }
        paramString = getODIN1(paramString);
        if (paramString != null)
        {
          Object localObject = MessageDigest.getInstance("MD5");
          ((MessageDigest)localObject).update(paramString.getBytes());
          paramString = ((MessageDigest)localObject).digest();
          localObject = new StringBuffer();
          int j = 0;
          for (;;)
          {
            if (j >= paramString.length) {
              return ((StringBuffer)localObject).toString();
            }
            ((StringBuffer)localObject).append(Integer.toString((paramString[j] & 0xFF) + 256, 16).substring(1));
            j += 1;
          }
        }
        return null;
      }
      catch (Exception paramString)
      {
        IMLog.debug("IMCOMMONS_3.6.1", "Error generating Odin1");
      }
    }
  }
  
  public static String getRSAKeyVersion()
  {
    return "1";
  }
  
  public static String getUIDMap(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    localStringBuilder.append("{");
    if (paramString1 != null)
    {
      paramString1 = a(paramString1, paramString5);
      localStringBuilder.append("LID:'");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("'");
      k = 1;
    }
    int j = k;
    if (paramString2 != null)
    {
      if (k == 1) {
        localStringBuilder.append(",");
      }
      paramString1 = a(paramString2, paramString5);
      localStringBuilder.append("SID:'");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("'");
      j = 1;
    }
    k = j;
    if (paramString4 != null)
    {
      if (j == 1) {
        localStringBuilder.append(",");
      }
      paramString1 = a(paramString4, paramString5);
      localStringBuilder.append("UM5:'");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("'");
      k = 1;
    }
    if (paramInt <= 0)
    {
      j = k;
      if (paramString3 != null)
      {
        if (k == 1) {
          localStringBuilder.append(",");
        }
        paramString1 = a(paramString3, paramString5);
        localStringBuilder.append("O1:'");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("'");
        j = 1;
      }
    }
    for (;;)
    {
      localStringBuilder.append("}");
      if (j != 1) {
        break;
      }
      return encryptRSA(localStringBuilder.toString());
      j = k;
      if (paramString3 != null)
      {
        j = k;
        if ((paramInt & 0x2) != 2)
        {
          j = k;
          if ((paramInt & 0x1) == 1)
          {
            if (k == 1) {
              localStringBuilder.append(",");
            }
            paramString1 = a(paramString3, paramString5);
            localStringBuilder.append("O1:'");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("'");
            j = 1;
          }
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String getUserAgent(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 330	com/inmobi/commons/internal/InternalSDKUtil:g	Ljava/lang/String;
    //   3: ifnonnull +34 -> 37
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 330	com/inmobi/commons/internal/InternalSDKUtil:g	Ljava/lang/String;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +20 -> 34
    //   17: new 332	android/webkit/WebView
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 335	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   25: invokevirtual 339	android/webkit/WebView:getSettings	()Landroid/webkit/WebSettings;
    //   28: invokevirtual 344	android/webkit/WebSettings:getUserAgentString	()Ljava/lang/String;
    //   31: putstatic 330	com/inmobi/commons/internal/InternalSDKUtil:g	Ljava/lang/String;
    //   34: ldc 2
    //   36: monitorexit
    //   37: getstatic 330	com/inmobi/commons/internal/InternalSDKUtil:g	Ljava/lang/String;
    //   40: areturn
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    //   47: astore_0
    //   48: goto -14 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramContext	Context
    //   12	2	1	str	String
    // Exception table:
    //   from	to	target	type
    //   9	13	41	finally
    //   17	34	41	finally
    //   34	37	41	finally
    //   42	45	41	finally
    //   17	34	47	java/lang/Exception
  }
  
  public static boolean getWhetherTablet(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 > paramInt3) && ((paramInt1 == 0) || (paramInt1 == 2))) {}
    while ((paramInt2 < paramInt3) && ((paramInt1 == 1) || (paramInt1 == 3))) {
      return true;
    }
    return false;
  }
  
  public static int incrementBaseUrl()
  {
    try
    {
      f += 1;
      int j = f;
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean validateAppId(String paramString)
  {
    if (paramString == null)
    {
      IMLog.debug("IMCOMMONS_3.6.1", "appId is null");
      return false;
    }
    if (paramString.matches("(x)+"))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "appId is all xxxxxxx");
      return false;
    }
    if ("".equals(paramString.trim()))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "appId is all blank");
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/internal/InternalSDKUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */