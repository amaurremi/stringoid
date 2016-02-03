package com.appfireworks.android.util;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AppEncryption
{
  private static final String HEX = "0123456789ABCDEF";
  private final Cipher cipher;
  private final SecretKeySpec key;
  private AlgorithmParameterSpec spec;
  
  public AppEncryption(String paramString)
    throws Exception
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    localMessageDigest.update(paramString.getBytes("UTF-8"));
    paramString = new byte[32];
    System.arraycopy(localMessageDigest.digest(), 0, paramString, 0, paramString.length);
    this.cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    this.key = new SecretKeySpec(paramString, "AES");
    this.spec = getIV();
  }
  
  private static void appendHexAES(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public static byte[] base64decode(String paramString)
  {
    Object localObject;
    if (paramString.length() == 0) {
      localObject = new byte[0];
    }
    int j;
    int i;
    byte[] arrayOfByte;
    label58:
    do
    {
      return (byte[])localObject;
      j = 0;
      i = paramString.length() - 1;
      if ((i > 0) && (paramString.charAt(i) == '=')) {
        break;
      }
      arrayOfByte = new byte[paramString.length() * 6 / 8 - j];
      j = 0;
      i = 0;
      localObject = arrayOfByte;
    } while (i >= paramString.length());
    int m = getValue(paramString.charAt(i));
    int n = getValue(paramString.charAt(i + 1));
    int i1 = getValue(paramString.charAt(i + 2));
    int i2 = getValue(paramString.charAt(i + 3));
    int k = 0;
    for (;;)
    {
      if ((k >= 3) || (j + k >= arrayOfByte.length))
      {
        j += 3;
        i += 4;
        break label58;
        j += 1;
        i -= 1;
        break;
      }
      arrayOfByte[(j + k)] = ((byte)((m << 18) + (n << 12) + (i1 << 6) + i2 >> (2 - k) * 8 & 0xFF));
      k += 1;
    }
  }
  
  public static String base64encode(byte[] paramArrayOfByte)
  {
    String str = "";
    int j = (3 - paramArrayOfByte.length % 3) % 3;
    byte[] arrayOfByte = zeroPad(paramArrayOfByte.length + j, paramArrayOfByte);
    int i = 0;
    paramArrayOfByte = str;
    for (;;)
    {
      if (i >= arrayOfByte.length) {
        return paramArrayOfByte.substring(0, paramArrayOfByte.length() - j) + "==".substring(0, j);
      }
      int k = ((arrayOfByte[i] & 0xFF) << 16) + ((arrayOfByte[(i + 1)] & 0xFF) << 8) + (arrayOfByte[(i + 2)] & 0xFF);
      paramArrayOfByte = paramArrayOfByte + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k >> 18 & 0x3F) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k >> 12 & 0x3F) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k >> 6 & 0x3F) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k & 0x3F);
      i += 3;
    }
  }
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
    throws Exception
  {
    String str = "";
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return str;
      }
      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
  }
  
  public static String decryptAES(String paramString1, String paramString2)
    throws Exception
  {
    return new String(decryptAES(getRawKeyAES(paramString1.getBytes()), toByteAES(paramString2)));
  }
  
  private static byte[] decryptAES(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  public static String encrypt(String paramString)
  {
    paramString = paramString + '\023';
    int k = paramString.length();
    String str1 = paramString;
    if (k % 16 != 0) {
      str1 = paramString + repeat('\000', 16 - k % 16);
    }
    int j = 0;
    Object localObject2 = getRndIv().getBytes();
    byte[] arrayOfByte = xor("tiJ8e+8Fb^21xd|5".getBytes(), (byte[])localObject2);
    Object localObject1 = localObject2;
    int i = j;
    paramString = arrayOfByte;
    if (arrayOfByte.length > 512)
    {
      paramString = new byte['Ȁ'];
      i = 0;
      if (i < 512) {
        break label144;
      }
      i = j;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (i >= k)
      {
        return replaceChars(base64encode((byte[])localObject1), "+/=", "-_~");
        label144:
        paramString[i] = arrayOfByte[i];
        i += 1;
        break;
      }
      arrayOfByte = pack(sha1(paramString));
      try
      {
        localObject2 = str1.substring(i, i + 16);
        arrayOfByte = xor(((String)localObject2).getBytes(), arrayOfByte);
        localObject2 = new byte[localObject1.length + arrayOfByte.length];
        j = 0;
        if (j >= localObject1.length)
        {
          j = 0;
          if (j < arrayOfByte.length) {
            break label324;
          }
          localObject1 = localObject2;
          localObject2 = new byte[arrayOfByte.length + paramString.length];
          j = 0;
          if (j < arrayOfByte.length) {
            break label343;
          }
          j = 0;
          if (j < paramString.length) {
            break label358;
          }
          paramString = (String)localObject2;
          if (localObject2.length > 512)
          {
            paramString = new byte['Ȁ'];
            j = 0;
            if (j < 512) {
              break label376;
            }
          }
          paramString = xor("tiJ8e+8Fb^21xd|5".getBytes(), paramString);
          i += 16;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = str1.substring(i);
          continue;
          str2[j] = localObject1[j];
          j += 1;
          continue;
          label324:
          str2[(localObject1.length + j)] = arrayOfByte[j];
          j += 1;
          continue;
          label343:
          str2[j] = arrayOfByte[j];
          j += 1;
          continue;
          label358:
          str2[(arrayOfByte.length + j)] = paramString[j];
          j += 1;
          continue;
          label376:
          paramString[j] = str2[j];
          j += 1;
        }
      }
    }
  }
  
  public static String encryptAES(String paramString1, String paramString2)
    throws Exception
  {
    return toHexAES(encryptAES(getRawKeyAES(paramString1.getBytes("UTF-8")), paramString2.getBytes()));
  }
  
  private static byte[] encryptAES(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  private static byte[] getRawKeyAES(byte[] paramArrayOfByte)
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    return localKeyGenerator.generateKey().getEncoded();
  }
  
  private static String getRndIv()
  {
    String str1 = "";
    int i = 16;
    for (;;)
    {
      if (i <= 0) {
        return str1;
      }
      int j = (int)(Math.random() * 62.0D);
      String str2 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, j + 1);
      str1 = str1 + str2;
      i -= 1;
    }
  }
  
  private static int getValue(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      return paramChar - 'A';
    }
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      return paramChar - 'a' + 26;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0' + 52;
    }
    if (paramChar == '+') {
      return 62;
    }
    if (paramChar == '/') {
      return 63;
    }
    if (paramChar != '=') {
      return -1;
    }
    return 0;
  }
  
  private static byte[] pack(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[1];
    int i = 0;
    for (;;)
    {
      if (i >= Math.ceil(j / 2)) {
        return arrayOfByte;
      }
      try
      {
        String str1 = paramString.substring(i * 2, i * 2 + 2);
        arrayOfByte[i] = ((byte)Integer.parseInt(str1, 16));
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString.substring(i * 2, i * 2 + 1) + "0";
        }
      }
    }
  }
  
  private static String repeat(char paramChar, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramChar);
      i += 1;
    }
  }
  
  private static String replaceChars(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    String str;
    int j;
    int m;
    int i;
    do
    {
      return paramString1;
      str = paramString3;
      if (paramString3 == null) {
        str = "";
      }
      j = 0;
      m = str.length();
      int n = paramString1.length();
      paramString3 = new StringBuffer(n);
      i = 0;
      if (i < n) {
        break;
      }
    } while (j == 0);
    return paramString3.toString();
    char c = paramString1.charAt(i);
    int i1 = paramString2.indexOf(c);
    if (i1 >= 0)
    {
      int k = 1;
      j = k;
      if (i1 < m)
      {
        paramString3.append(str.charAt(i1));
        j = k;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      paramString3.append(c);
    }
  }
  
  public static String sha1(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
        localObject = localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        continue;
      }
      try
      {
        paramArrayOfByte = byteArrayToHexString(((MessageDigest)localObject).digest(paramArrayOfByte));
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        return "";
      }
    }
  }
  
  private static byte[] toByteAES(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return arrayOfByte;
      }
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
  }
  
  private static String toHexAES(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuffer.toString();
      }
      appendHexAES(localStringBuffer, paramArrayOfByte[i]);
      i += 1;
    }
  }
  
  private static byte[] xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        return arrayOfByte;
      }
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)]));
      i += 1;
    }
  }
  
  private static byte[] zeroPad(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String decrypt128(String paramString)
    throws Exception
  {
    for (;;)
    {
      if (!paramString.contains("=;+;="))
      {
        this.cipher.init(2, this.key, this.spec);
        paramString = Base64.decode(paramString, 0);
        return new String(this.cipher.doFinal(paramString), "UTF-8");
      }
      paramString = paramString.replace("=;+;=", "\n");
    }
  }
  
  public String encrypt128(String paramString)
    throws Exception
  {
    this.cipher.init(1, this.key, this.spec);
    for (paramString = new String(Base64.encode(this.cipher.doFinal(paramString.getBytes("UTF-8")), 0), "UTF-8");; paramString = paramString.replace("\n", "=;+;=")) {
      if (!paramString.contains("\n")) {
        return paramString;
      }
    }
  }
  
  public AlgorithmParameterSpec getIV()
  {
    return new IvParameterSpec(new byte[16]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/util/AppEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */