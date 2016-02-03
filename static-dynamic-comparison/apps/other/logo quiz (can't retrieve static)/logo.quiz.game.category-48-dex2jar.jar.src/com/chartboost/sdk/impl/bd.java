package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class bd
  implements Serializable, Comparable<bd>
{
  static final Logger a = Logger.getLogger("org.bson.ObjectId");
  private static AtomicInteger f = new AtomicInteger(new Random().nextInt());
  private static final int g;
  final int b;
  final int c;
  final int d;
  boolean e;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   5: putstatic 36	com/chartboost/sdk/impl/bd:a	Ljava/util/logging/Logger;
    //   8: new 38	java/util/concurrent/atomic/AtomicInteger
    //   11: dup
    //   12: new 40	java/util/Random
    //   15: dup
    //   16: invokespecial 43	java/util/Random:<init>	()V
    //   19: invokevirtual 47	java/util/Random:nextInt	()I
    //   22: invokespecial 50	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   25: putstatic 52	com/chartboost/sdk/impl/bd:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   28: new 54	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   35: astore_3
    //   36: invokestatic 61	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   39: astore 4
    //   41: aload 4
    //   43: invokeinterface 67 1 0
    //   48: ifeq +209 -> 257
    //   51: aload_3
    //   52: aload 4
    //   54: invokeinterface 71 1 0
    //   59: checkcast 57	java/net/NetworkInterface
    //   62: invokevirtual 75	java/net/NetworkInterface:toString	()Ljava/lang/String;
    //   65: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -28 -> 41
    //   72: astore_3
    //   73: getstatic 36	com/chartboost/sdk/impl/bd:a	Ljava/util/logging/Logger;
    //   76: getstatic 85	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   79: aload_3
    //   80: invokevirtual 88	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   83: aload_3
    //   84: invokevirtual 92	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: new 40	java/util/Random
    //   90: dup
    //   91: invokespecial 43	java/util/Random:<init>	()V
    //   94: invokevirtual 47	java/util/Random:nextInt	()I
    //   97: bipush 16
    //   99: ishl
    //   100: istore_0
    //   101: getstatic 36	com/chartboost/sdk/impl/bd:a	Ljava/util/logging/Logger;
    //   104: new 54	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   111: ldc 94
    //   113: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_0
    //   117: invokestatic 100	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   120: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 105	java/util/logging/Logger:fine	(Ljava/lang/String;)V
    //   129: new 40	java/util/Random
    //   132: dup
    //   133: invokespecial 43	java/util/Random:<init>	()V
    //   136: invokevirtual 47	java/util/Random:nextInt	()I
    //   139: istore_2
    //   140: ldc 2
    //   142: invokevirtual 111	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +126 -> 273
    //   150: aload_3
    //   151: invokestatic 117	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   154: istore_1
    //   155: new 54	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: iload_2
    //   165: invokestatic 100	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   168: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_3
    //   173: iload_1
    //   174: invokestatic 100	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   177: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 122	java/lang/String:hashCode	()I
    //   188: ldc 123
    //   190: iand
    //   191: istore_1
    //   192: getstatic 36	com/chartboost/sdk/impl/bd:a	Ljava/util/logging/Logger;
    //   195: new 54	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   202: ldc 125
    //   204: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload_1
    //   208: invokestatic 100	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   211: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 105	java/util/logging/Logger:fine	(Ljava/lang/String;)V
    //   220: iload_1
    //   221: iload_0
    //   222: ior
    //   223: putstatic 127	com/chartboost/sdk/impl/bd:g	I
    //   226: getstatic 36	com/chartboost/sdk/impl/bd:a	Ljava/util/logging/Logger;
    //   229: new 54	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   236: ldc -127
    //   238: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: getstatic 127	com/chartboost/sdk/impl/bd:g	I
    //   244: invokestatic 100	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   247: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokevirtual 105	java/util/logging/Logger:fine	(Ljava/lang/String;)V
    //   256: return
    //   257: aload_3
    //   258: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 122	java/lang/String:hashCode	()I
    //   264: istore_0
    //   265: iload_0
    //   266: bipush 16
    //   268: ishl
    //   269: istore_0
    //   270: goto -169 -> 101
    //   273: iconst_0
    //   274: istore_1
    //   275: goto -120 -> 155
    //   278: astore_3
    //   279: new 131	java/lang/RuntimeException
    //   282: dup
    //   283: aload_3
    //   284: invokespecial 134	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   287: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   100	170	0	i	int
    //   154	121	1	j	int
    //   139	26	2	k	int
    //   35	17	3	localStringBuilder	StringBuilder
    //   72	12	3	localThrowable	Throwable
    //   145	113	3	localObject	Object
    //   278	6	3	localException	Exception
    //   39	14	4	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   28	41	72	java/lang/Throwable
    //   41	69	72	java/lang/Throwable
    //   257	265	72	java/lang/Throwable
    //   28	41	278	java/lang/Exception
    //   41	69	278	java/lang/Exception
    //   73	101	278	java/lang/Exception
    //   101	146	278	java/lang/Exception
    //   150	155	278	java/lang/Exception
    //   155	256	278	java/lang/Exception
    //   257	265	278	java/lang/Exception
  }
  
  public bd()
  {
    this.b = ((int)(System.currentTimeMillis() / 1000L));
    this.c = g;
    this.d = f.getAndIncrement();
    this.e = true;
  }
  
  public bd(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = false;
  }
  
  public bd(String paramString)
  {
    this(paramString, false);
  }
  
  public bd(String paramString, boolean paramBoolean)
  {
    if (!a(paramString)) {
      throw new IllegalArgumentException("invalid ObjectId [" + paramString + "]");
    }
    String str = paramString;
    if (paramBoolean) {
      str = b(paramString);
    }
    paramString = new byte[12];
    int i = 0;
    while (i < paramString.length)
    {
      paramString[i] = ((byte)Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    paramString = ByteBuffer.wrap(paramString);
    this.b = paramString.getInt();
    this.c = paramString.getInt();
    this.d = paramString.getInt();
    this.e = false;
  }
  
  public static bd a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof bd)) {
      return (bd)paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = paramObject.toString();
      if (a((String)paramObject)) {
        return new bd((String)paramObject);
      }
    }
    return null;
  }
  
  static String a(String paramString, int paramInt)
  {
    return paramString.substring(paramInt * 2, paramInt * 2 + 2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    int j;
    do
    {
      return false;
      j = paramString.length();
    } while (j != 24);
    int i = 0;
    label19:
    if (i < j)
    {
      int k = paramString.charAt(i);
      if ((k >= 48) && (k <= 57)) {}
      for (;;)
      {
        i += 1;
        break label19;
        if ((k < 97) || (k > 102)) {
          if ((k < 65) || (k > 70)) {
            break;
          }
        }
      }
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (!a(paramString)) {
      throw new IllegalArgumentException("invalid object id: " + paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder(24);
    int i = 7;
    while (i >= 0)
    {
      localStringBuilder.append(a(paramString, i));
      i -= 1;
    }
    i = 11;
    while (i >= 8)
    {
      localStringBuilder.append(a(paramString, i));
      i -= 1;
    }
    return localStringBuilder.toString();
  }
  
  int a(int paramInt1, int paramInt2)
  {
    long l = (paramInt1 & 0xFFFFFFFF) - (paramInt2 & 0xFFFFFFFF);
    if (l < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public int a(bd parambd)
  {
    int i;
    if (parambd == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = a(this.b, parambd.b);
        i = j;
      } while (j != 0);
      j = a(this.c, parambd.c);
      i = j;
    } while (j != 0);
    return a(this.d, parambd.d);
  }
  
  public String a()
  {
    byte[] arrayOfByte = b();
    StringBuilder localStringBuilder = new StringBuilder(24);
    int i = 0;
    while (i < arrayOfByte.length)
    {
      String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[12];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    localByteBuffer.putInt(this.b);
    localByteBuffer.putInt(this.c);
    localByteBuffer.putInt(this.d);
    return arrayOfByte;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      paramObject = a(paramObject);
      if (paramObject == null) {
        return false;
      }
    } while ((this.b == ((bd)paramObject).b) && (this.c == ((bd)paramObject).c) && (this.d == ((bd)paramObject).d));
    return false;
  }
  
  public int hashCode()
  {
    return this.b + this.c * 111 + this.d * 17;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */