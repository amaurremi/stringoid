package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.util.EncodingUtils;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

final class NTLMEngineImpl
  implements NTLMEngine
{
  private static final SecureRandom RND_GEN;
  private static byte[] SIGNATURE;
  private String credentialCharset = "ASCII";
  
  static
  {
    Object localObject = null;
    try
    {
      SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG");
      localObject = localSecureRandom;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    RND_GEN = (SecureRandom)localObject;
    localObject = EncodingUtils.getBytes("NTLMSSP", "ASCII");
    SIGNATURE = new byte[localObject.length + 1];
    System.arraycopy(localObject, 0, SIGNATURE, 0, localObject.length);
    SIGNATURE[localObject.length] = 0;
  }
  
  static int F(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | (paramInt1 ^ 0xFFFFFFFF) & paramInt3;
  }
  
  static int G(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  static int H(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  static byte[] RC4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramArrayOfByte2, "RC4"));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new NTLMEngineException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  private static String convertDomain(String paramString)
  {
    return stripDotSuffix(paramString);
  }
  
  private static String convertHost(String paramString)
  {
    return stripDotSuffix(paramString);
  }
  
  private static byte[] createBlob(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] tmp7_5 = arrayOfByte1;
    tmp7_5[0] = 1;
    byte[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 1;
    byte[] tmp17_12 = tmp12_7;
    tmp17_12[2] = 0;
    byte[] tmp22_17 = tmp17_12;
    tmp22_17[3] = 0;
    tmp22_17;
    byte[] arrayOfByte2 = new byte[4];
    byte[] tmp35_33 = arrayOfByte2;
    tmp35_33[0] = 0;
    byte[] tmp40_35 = tmp35_33;
    tmp40_35[1] = 0;
    byte[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 0;
    byte[] tmp50_45 = tmp45_40;
    tmp50_45[3] = 0;
    tmp50_45;
    byte[] arrayOfByte3 = new byte[4];
    byte[] tmp63_61 = arrayOfByte3;
    tmp63_61[0] = 0;
    byte[] tmp68_63 = tmp63_61;
    tmp68_63[1] = 0;
    byte[] tmp73_68 = tmp68_63;
    tmp73_68[2] = 0;
    byte[] tmp78_73 = tmp73_68;
    tmp78_73[3] = 0;
    tmp78_73;
    byte[] arrayOfByte4 = new byte[4];
    byte[] tmp91_89 = arrayOfByte4;
    tmp91_89[0] = 0;
    byte[] tmp96_91 = tmp91_89;
    tmp96_91[1] = 0;
    byte[] tmp101_96 = tmp96_91;
    tmp101_96[2] = 0;
    byte[] tmp106_101 = tmp101_96;
    tmp106_101[3] = 0;
    tmp106_101;
    byte[] arrayOfByte5 = new byte[arrayOfByte1.length + arrayOfByte2.length + paramArrayOfByte3.length + 8 + arrayOfByte3.length + paramArrayOfByte2.length + arrayOfByte4.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, arrayOfByte1.length);
    int i = arrayOfByte1.length + 0;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, i, arrayOfByte2.length);
    i += arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte5, i, paramArrayOfByte3.length);
    i += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte5, i, 8);
    i += 8;
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte5, i, paramArrayOfByte2.length);
    i += paramArrayOfByte2.length;
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, i, arrayOfByte4.length);
    i = arrayOfByte4.length;
    return arrayOfByte5;
  }
  
  private static Key createDESKey(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[7];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 7);
    paramArrayOfByte = new byte[8];
    paramArrayOfByte[0] = arrayOfByte[0];
    paramArrayOfByte[1] = ((byte)(arrayOfByte[0] << 7 | (arrayOfByte[1] & 0xFF) >>> 1));
    paramArrayOfByte[2] = ((byte)(arrayOfByte[1] << 6 | (arrayOfByte[2] & 0xFF) >>> 2));
    paramArrayOfByte[3] = ((byte)(arrayOfByte[2] << 5 | (arrayOfByte[3] & 0xFF) >>> 3));
    paramArrayOfByte[4] = ((byte)(arrayOfByte[3] << 4 | (arrayOfByte[4] & 0xFF) >>> 4));
    paramArrayOfByte[5] = ((byte)(arrayOfByte[4] << 3 | (arrayOfByte[5] & 0xFF) >>> 5));
    paramArrayOfByte[6] = ((byte)(arrayOfByte[5] << 2 | (arrayOfByte[6] & 0xFF) >>> 6));
    paramArrayOfByte[7] = ((byte)(arrayOfByte[6] << 1));
    oddParity(paramArrayOfByte);
    return new SecretKeySpec(paramArrayOfByte, "DES");
  }
  
  static byte[] hmacMD5(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new NTLMEngineImpl.HMACMD5(paramArrayOfByte2);
    paramArrayOfByte2.update(paramArrayOfByte1);
    return paramArrayOfByte2.getOutput();
  }
  
  private static byte[] lmHash(String paramString)
  {
    try
    {
      paramString = paramString.toUpperCase(Locale.US).getBytes("US-ASCII");
      int i = Math.min(paramString.length, 14);
      Object localObject = new byte[14];
      System.arraycopy(paramString, 0, localObject, 0, i);
      paramString = createDESKey((byte[])localObject, 0);
      localObject = createDESKey((byte[])localObject, 7);
      byte[] arrayOfByte = "KGS!@#$%".getBytes("US-ASCII");
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(1, paramString);
      paramString = localCipher.doFinal(arrayOfByte);
      localCipher.init(1, (Key)localObject);
      localObject = localCipher.doFinal(arrayOfByte);
      arrayOfByte = new byte[16];
      System.arraycopy(paramString, 0, arrayOfByte, 0, 8);
      System.arraycopy(localObject, 0, arrayOfByte, 8, 8);
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      throw new NTLMEngineException(paramString.getMessage(), paramString);
    }
  }
  
  private static byte[] lmResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Object localObject2 = new byte[21];
      System.arraycopy(paramArrayOfByte1, 0, localObject2, 0, 16);
      paramArrayOfByte1 = createDESKey((byte[])localObject2, 0);
      Object localObject1 = createDESKey((byte[])localObject2, 7);
      localObject2 = createDESKey((byte[])localObject2, 14);
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(1, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2);
      localCipher.init(1, (Key)localObject1);
      localObject1 = localCipher.doFinal(paramArrayOfByte2);
      localCipher.init(1, (Key)localObject2);
      paramArrayOfByte2 = localCipher.doFinal(paramArrayOfByte2);
      localObject2 = new byte[24];
      System.arraycopy(paramArrayOfByte1, 0, localObject2, 0, 8);
      System.arraycopy(localObject1, 0, localObject2, 8, 8);
      System.arraycopy(paramArrayOfByte2, 0, localObject2, 16, 8);
      return (byte[])localObject2;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new NTLMEngineException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  private static byte[] lmv2Response(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = new NTLMEngineImpl.HMACMD5(paramArrayOfByte1);
    paramArrayOfByte1.update(paramArrayOfByte2);
    paramArrayOfByte1.update(paramArrayOfByte3);
    paramArrayOfByte1 = paramArrayOfByte1.getOutput();
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, paramArrayOfByte1.length, paramArrayOfByte3.length);
    return paramArrayOfByte2;
  }
  
  private static byte[] makeRandomChallenge()
  {
    if (RND_GEN == null) {
      throw new NTLMEngineException("Random generator not available");
    }
    byte[] arrayOfByte = new byte[8];
    synchronized (RND_GEN)
    {
      RND_GEN.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
  }
  
  private static byte[] makeSecondaryKey()
  {
    if (RND_GEN == null) {
      throw new NTLMEngineException("Random generator not available");
    }
    byte[] arrayOfByte = new byte[16];
    synchronized (RND_GEN)
    {
      RND_GEN.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
  }
  
  static byte[] ntlm2SessionResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte2);
      localMessageDigest.update(paramArrayOfByte3);
      paramArrayOfByte2 = localMessageDigest.digest();
      paramArrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 0, 8);
      paramArrayOfByte1 = lmResponse(paramArrayOfByte1, paramArrayOfByte3);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      if ((paramArrayOfByte1 instanceof NTLMEngineException)) {
        throw ((NTLMEngineException)paramArrayOfByte1);
      }
      throw new NTLMEngineException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  private static byte[] ntlmHash(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UnicodeLittleUnmarked");
      NTLMEngineImpl.MD4 localMD4 = new NTLMEngineImpl.MD4();
      localMD4.update(paramString);
      paramString = localMD4.getOutput();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new NTLMEngineException("Unicode not supported: " + paramString.getMessage(), paramString);
    }
  }
  
  private static byte[] ntlmv2Hash(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = new NTLMEngineImpl.HMACMD5(ntlmHash(paramString3));
      paramString3.update(paramString2.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked"));
      paramString3.update(paramString1.getBytes("UnicodeLittleUnmarked"));
      paramString1 = paramString3.getOutput();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new NTLMEngineException("Unicode not supported! " + paramString1.getMessage(), paramString1);
    }
  }
  
  private static void oddParity(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      if (((j >>> 1 ^ j >>> 7 ^ j >>> 6 ^ j >>> 5 ^ j >>> 4 ^ j >>> 3 ^ j >>> 2) & 0x1) == 0)
      {
        j = 1;
        label48:
        if (j == 0) {
          break label73;
        }
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] | 0x1));
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label48;
        label73:
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] & 0xFFFFFFFE));
      }
    }
  }
  
  private static byte[] readSecurityBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = readUShort(paramArrayOfByte, paramInt);
    paramInt = readULong(paramArrayOfByte, paramInt + 4);
    if (paramArrayOfByte.length < paramInt + i) {
      throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  private static int readULong(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length < paramInt + 4) {
      throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
    }
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  private static int readUShort(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length < paramInt + 2) {
      throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
    }
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8;
  }
  
  static int rotintlft(int paramInt1, int paramInt2)
  {
    return paramInt1 << paramInt2 | paramInt1 >>> 32 - paramInt2;
  }
  
  private static String stripDotSuffix(String paramString)
  {
    int i = paramString.indexOf(".");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  static void writeULong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public String generateType1Msg(String paramString1, String paramString2)
  {
    return getType1Message(paramString2, paramString1);
  }
  
  public String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString5 = new NTLMEngineImpl.Type2Message(paramString5);
    return getType3Message(paramString1, paramString2, paramString4, paramString3, paramString5.getChallenge(), paramString5.getFlags(), paramString5.getTarget(), paramString5.getTargetInfo());
  }
  
  String getType1Message(String paramString1, String paramString2)
  {
    return new NTLMEngineImpl.Type1Message(paramString2, paramString1).getResponse();
  }
  
  String getType3Message(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte1, int paramInt, String paramString5, byte[] paramArrayOfByte2)
  {
    return new NTLMEngineImpl.Type3Message(paramString4, paramString3, paramString1, paramString2, paramArrayOfByte1, paramInt, paramString5, paramArrayOfByte2).getResponse();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */