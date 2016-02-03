package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class dp
{
  private final dn a;
  
  public dp(dn paramdn, SecureRandom paramSecureRandom)
  {
    this.a = paramdn;
  }
  
  public final byte[] a(String paramString)
  {
    int i = 0;
    try
    {
      paramString = this.a.a(paramString, false);
      if (paramString.length != 32) {
        throw new dq(this);
      }
    }
    catch (IllegalArgumentException paramString)
    {
      throw new dq(this, paramString);
    }
    paramString = ByteBuffer.wrap(paramString, 4, 16);
    byte[] arrayOfByte = new byte[16];
    paramString.get(arrayOfByte);
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ 0x44));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte.length != 16) {
      throw new dq(this);
    }
    try
    {
      arrayOfByte = this.a.a(paramString, false);
      if (arrayOfByte.length <= 16) {
        throw new dq(this);
      }
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
      Object localObject = ByteBuffer.allocate(arrayOfByte.length);
      ((ByteBuffer)localObject).put(arrayOfByte);
      ((ByteBuffer)localObject).flip();
      paramString = new byte[16];
      byte[] arrayOfByte = new byte[arrayOfByte.length - 16];
      ((ByteBuffer)localObject).get(paramString);
      ((ByteBuffer)localObject).get(arrayOfByte);
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(2, paramArrayOfByte, new IvParameterSpec(paramString));
      paramArrayOfByte = ((Cipher)localObject).doFinal(arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      throw new dq(this, paramArrayOfByte);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */