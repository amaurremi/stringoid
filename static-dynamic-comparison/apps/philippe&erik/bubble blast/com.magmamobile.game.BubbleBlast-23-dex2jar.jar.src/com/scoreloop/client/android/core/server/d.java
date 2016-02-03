package com.scoreloop.client.android.core.server;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

class d
  extends b
{
  private final Cipher a;
  private final byte[] b;
  
  d(URI paramURI, byte[] paramArrayOfByte)
  {
    super(paramURI);
    try
    {
      this.a = Cipher.getInstance("AES/CBC/PKCS7Padding");
      this.b = paramArrayOfByte;
      return;
    }
    catch (NoSuchAlgorithmException paramURI)
    {
      throw new IllegalStateException();
    }
    catch (NoSuchPaddingException paramURI)
    {
      throw new IllegalStateException();
    }
  }
  
  /* Error */
  String a(org.apache.http.client.methods.HttpPost paramHttpPost, String paramString)
    throws java.io.IOException, org.apache.http.client.ClientProtocolException
  {
    // Byte code:
    //   0: new 44	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: getfield 29	com/scoreloop/client/android/core/server/d:b	[B
    //   8: ldc 46
    //   10: invokespecial 49	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 27	com/scoreloop/client/android/core/server/d:a	Ljavax/crypto/Cipher;
    //   18: iconst_1
    //   19: aload_3
    //   20: new 51	javax/crypto/spec/IvParameterSpec
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/scoreloop/client/android/core/server/d:b	[B
    //   28: invokespecial 54	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   31: invokevirtual 58	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   34: aload_0
    //   35: getfield 27	com/scoreloop/client/android/core/server/d:a	Ljavax/crypto/Cipher;
    //   38: aload_2
    //   39: ldc 60
    //   41: invokevirtual 66	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   44: invokevirtual 70	javax/crypto/Cipher:doFinal	([B)[B
    //   47: astore_2
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: invokespecial 73	com/scoreloop/client/android/core/server/b:a	(Lorg/apache/http/client/methods/HttpPost;[B)[B
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 27	com/scoreloop/client/android/core/server/d:a	Ljavax/crypto/Cipher;
    //   59: iconst_2
    //   60: aload_3
    //   61: new 51	javax/crypto/spec/IvParameterSpec
    //   64: dup
    //   65: aload_0
    //   66: getfield 29	com/scoreloop/client/android/core/server/d:b	[B
    //   69: invokespecial 54	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   72: invokevirtual 58	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   75: new 62	java/lang/String
    //   78: dup
    //   79: aload_0
    //   80: getfield 27	com/scoreloop/client/android/core/server/d:a	Ljavax/crypto/Cipher;
    //   83: aload_1
    //   84: invokevirtual 70	javax/crypto/Cipher:doFinal	([B)[B
    //   87: ldc 60
    //   89: invokespecial 74	java/lang/String:<init>	([BLjava/lang/String;)V
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: astore_1
    //   96: new 31	java/lang/IllegalStateException
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 77	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: astore_1
    //   106: new 31	java/lang/IllegalStateException
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 77	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	d
    //   0	115	1	paramHttpPost	org.apache.http.client.methods.HttpPost
    //   0	115	2	paramString	String
    //   13	48	3	localSecretKeySpec	javax.crypto.spec.SecretKeySpec
    // Exception table:
    //   from	to	target	type
    //   14	48	95	java/security/GeneralSecurityException
    //   55	93	105	java/security/GeneralSecurityException
  }
  
  protected String b()
  {
    return "x-application/sjson";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */