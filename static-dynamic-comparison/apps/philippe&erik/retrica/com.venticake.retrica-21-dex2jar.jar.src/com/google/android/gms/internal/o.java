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

public class o
{
  private final m jQ;
  private final SecureRandom kl;
  
  public o(m paramm, SecureRandom paramSecureRandom)
  {
    this.jQ = paramm;
    this.kl = paramSecureRandom;
  }
  
  static void c(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0x44));
      i += 1;
    }
  }
  
  public byte[] b(String paramString)
  {
    try
    {
      paramString = this.jQ.a(paramString, false);
      if (paramString.length != 32) {
        throw new o.a(this);
      }
    }
    catch (IllegalArgumentException paramString)
    {
      throw new o.a(this, paramString);
    }
    paramString = ByteBuffer.wrap(paramString, 4, 16);
    byte[] arrayOfByte = new byte[16];
    paramString.get(arrayOfByte);
    c(arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte.length != 16) {
      throw new o.a(this);
    }
    try
    {
      arrayOfByte = this.jQ.a(paramString, false);
      if (arrayOfByte.length <= 16) {
        throw new o.a(this);
      }
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new o.a(this, paramArrayOfByte);
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
      throw new o.a(this, paramArrayOfByte);
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      throw new o.a(this, paramArrayOfByte);
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      throw new o.a(this, paramArrayOfByte);
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      throw new o.a(this, paramArrayOfByte);
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte)
    {
      throw new o.a(this, paramArrayOfByte);
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      throw new o.a(this, paramArrayOfByte);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */