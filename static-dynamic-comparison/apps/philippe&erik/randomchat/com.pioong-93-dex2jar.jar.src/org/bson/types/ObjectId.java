package org.bson.types;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class ObjectId
  implements Comparable<ObjectId>, Serializable
{
  static final Logger LOGGER = Logger.getLogger("org.bson.ObjectId");
  private static final int _genmachine;
  private static AtomicInteger _nextInc = new AtomicInteger(new Random().nextInt());
  private static final long serialVersionUID = -4415279469780082174L;
  final int _inc;
  final int _machine;
  boolean _new;
  final int _time;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 32
    //   2: invokestatic 38	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   5: putstatic 40	org/bson/types/ObjectId:LOGGER	Ljava/util/logging/Logger;
    //   8: new 42	java/util/concurrent/atomic/AtomicInteger
    //   11: dup
    //   12: new 44	java/util/Random
    //   15: dup
    //   16: invokespecial 47	java/util/Random:<init>	()V
    //   19: invokevirtual 51	java/util/Random:nextInt	()I
    //   22: invokespecial 54	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   25: putstatic 56	org/bson/types/ObjectId:_nextInc	Ljava/util/concurrent/atomic/AtomicInteger;
    //   28: new 58	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   35: astore_3
    //   36: invokestatic 65	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   39: astore 4
    //   41: aload 4
    //   43: invokeinterface 71 1 0
    //   48: ifeq +223 -> 271
    //   51: aload_3
    //   52: aload 4
    //   54: invokeinterface 75 1 0
    //   59: checkcast 61	java/net/NetworkInterface
    //   62: invokevirtual 79	java/net/NetworkInterface:toString	()Ljava/lang/String;
    //   65: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -28 -> 41
    //   72: astore_3
    //   73: getstatic 40	org/bson/types/ObjectId:LOGGER	Ljava/util/logging/Logger;
    //   76: getstatic 89	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   79: aload_3
    //   80: invokevirtual 92	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   83: aload_3
    //   84: invokevirtual 96	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: new 44	java/util/Random
    //   90: dup
    //   91: invokespecial 47	java/util/Random:<init>	()V
    //   94: invokevirtual 51	java/util/Random:nextInt	()I
    //   97: bipush 16
    //   99: ishl
    //   100: istore_0
    //   101: getstatic 40	org/bson/types/ObjectId:LOGGER	Ljava/util/logging/Logger;
    //   104: new 58	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   111: ldc 98
    //   113: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_0
    //   117: invokestatic 104	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   120: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 109	java/util/logging/Logger:fine	(Ljava/lang/String;)V
    //   129: new 44	java/util/Random
    //   132: dup
    //   133: invokespecial 47	java/util/Random:<init>	()V
    //   136: invokevirtual 51	java/util/Random:nextInt	()I
    //   139: istore_1
    //   140: invokestatic 115	java/lang/management/ManagementFactory:getRuntimeMXBean	()Ljava/lang/management/RuntimeMXBean;
    //   143: invokeinterface 120 1 0
    //   148: invokevirtual 125	java/lang/String:hashCode	()I
    //   151: istore_2
    //   152: iload_2
    //   153: istore_1
    //   154: ldc 2
    //   156: invokevirtual 131	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: astore_3
    //   160: aload_3
    //   161: ifnull +126 -> 287
    //   164: aload_3
    //   165: invokestatic 137	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   168: istore_2
    //   169: new 58	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   176: astore_3
    //   177: aload_3
    //   178: iload_1
    //   179: invokestatic 104	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   182: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_3
    //   187: iload_2
    //   188: invokestatic 104	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   191: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokevirtual 125	java/lang/String:hashCode	()I
    //   202: ldc -118
    //   204: iand
    //   205: istore_1
    //   206: getstatic 40	org/bson/types/ObjectId:LOGGER	Ljava/util/logging/Logger;
    //   209: new 58	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   216: ldc -116
    //   218: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload_1
    //   222: invokestatic 104	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   225: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokevirtual 109	java/util/logging/Logger:fine	(Ljava/lang/String;)V
    //   234: iload_0
    //   235: iload_1
    //   236: ior
    //   237: putstatic 142	org/bson/types/ObjectId:_genmachine	I
    //   240: getstatic 40	org/bson/types/ObjectId:LOGGER	Ljava/util/logging/Logger;
    //   243: new 58	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   250: ldc -112
    //   252: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: getstatic 142	org/bson/types/ObjectId:_genmachine	I
    //   258: invokestatic 104	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   261: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 109	java/util/logging/Logger:fine	(Ljava/lang/String;)V
    //   270: return
    //   271: aload_3
    //   272: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokevirtual 125	java/lang/String:hashCode	()I
    //   278: istore_0
    //   279: iload_0
    //   280: bipush 16
    //   282: ishl
    //   283: istore_0
    //   284: goto -183 -> 101
    //   287: iconst_0
    //   288: istore_2
    //   289: goto -120 -> 169
    //   292: astore_3
    //   293: new 146	java/lang/RuntimeException
    //   296: dup
    //   297: aload_3
    //   298: invokespecial 149	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   301: athrow
    //   302: astore_3
    //   303: goto -149 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   100	184	0	i	int
    //   139	98	1	j	int
    //   151	138	2	k	int
    //   35	17	3	localStringBuilder	StringBuilder
    //   72	12	3	localThrowable1	Throwable
    //   159	113	3	localObject	Object
    //   292	6	3	localException	Exception
    //   302	1	3	localThrowable2	Throwable
    //   39	14	4	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   28	41	72	java/lang/Throwable
    //   41	69	72	java/lang/Throwable
    //   271	279	72	java/lang/Throwable
    //   28	41	292	java/lang/Exception
    //   41	69	292	java/lang/Exception
    //   73	101	292	java/lang/Exception
    //   101	140	292	java/lang/Exception
    //   140	152	292	java/lang/Exception
    //   154	160	292	java/lang/Exception
    //   164	169	292	java/lang/Exception
    //   169	270	292	java/lang/Exception
    //   271	279	292	java/lang/Exception
    //   140	152	302	java/lang/Throwable
  }
  
  public ObjectId()
  {
    this._time = ((int)(System.currentTimeMillis() / 1000L));
    this._machine = _genmachine;
    this._inc = _nextInc.getAndIncrement();
    this._new = true;
  }
  
  public ObjectId(int paramInt1, int paramInt2, int paramInt3)
  {
    this._time = paramInt1;
    this._machine = paramInt2;
    this._inc = paramInt3;
    this._new = false;
  }
  
  public ObjectId(String paramString)
  {
    this(paramString, false);
  }
  
  public ObjectId(String paramString, boolean paramBoolean)
  {
    if (!isValid(paramString)) {
      throw new IllegalArgumentException("invalid ObjectId [" + paramString + "]");
    }
    String str = paramString;
    if (paramBoolean) {
      str = babbleToMongod(paramString);
    }
    paramString = new byte[12];
    int i = 0;
    while (i < paramString.length)
    {
      paramString[i] = ((byte)Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    paramString = ByteBuffer.wrap(paramString);
    this._time = paramString.getInt();
    this._machine = paramString.getInt();
    this._inc = paramString.getInt();
    this._new = false;
  }
  
  public ObjectId(Date paramDate)
  {
    this(paramDate, _genmachine, _nextInc.getAndIncrement());
  }
  
  public ObjectId(Date paramDate, int paramInt)
  {
    this(paramDate, _genmachine, paramInt);
  }
  
  public ObjectId(Date paramDate, int paramInt1, int paramInt2)
  {
    this._time = ((int)(paramDate.getTime() / 1000L));
    this._machine = paramInt1;
    this._inc = paramInt2;
    this._new = false;
  }
  
  public ObjectId(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 12) {
      throw new IllegalArgumentException("need 12 bytes");
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    this._time = paramArrayOfByte.getInt();
    this._machine = paramArrayOfByte.getInt();
    this._inc = paramArrayOfByte.getInt();
    this._new = false;
  }
  
  public static int _flip(int paramInt)
  {
    return 0x0 | paramInt << 24 & 0xFF000000 | paramInt << 8 & 0xFF0000 | paramInt >> 8 & 0xFF00 | paramInt >> 24 & 0xFF;
  }
  
  static String _pos(String paramString, int paramInt)
  {
    return paramString.substring(paramInt * 2, paramInt * 2 + 2);
  }
  
  public static String babbleToMongod(String paramString)
  {
    if (!isValid(paramString)) {
      throw new IllegalArgumentException("invalid object id: " + paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder(24);
    int i = 7;
    while (i >= 0)
    {
      localStringBuilder.append(_pos(paramString, i));
      i -= 1;
    }
    i = 11;
    while (i >= 8)
    {
      localStringBuilder.append(_pos(paramString, i));
      i -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static ObjectId get()
  {
    return new ObjectId();
  }
  
  public static int getCurrentInc()
  {
    return _nextInc.get();
  }
  
  public static int getGenMachineId()
  {
    return _genmachine;
  }
  
  public static boolean isValid(String paramString)
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
  
  public static ObjectId massageToObjectId(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof ObjectId)) {
      return (ObjectId)paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = paramObject.toString();
      if (isValid((String)paramObject)) {
        return new ObjectId((String)paramObject);
      }
    }
    return null;
  }
  
  int _compareUnsigned(int paramInt1, int paramInt2)
  {
    long l = (0xFFFFFFFF & paramInt1) - (0xFFFFFFFF & paramInt2);
    if (l < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public int _inc()
  {
    return this._inc;
  }
  
  public int _machine()
  {
    return this._machine;
  }
  
  public int _time()
  {
    return this._time;
  }
  
  public int compareTo(ObjectId paramObjectId)
  {
    int i;
    if (paramObjectId == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = _compareUnsigned(this._time, paramObjectId._time);
        i = j;
      } while (j != 0);
      j = _compareUnsigned(this._machine, paramObjectId._machine);
      i = j;
    } while (j != 0);
    return _compareUnsigned(this._inc, paramObjectId._inc);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      paramObject = massageToObjectId(paramObject);
      if (paramObject == null) {
        return false;
      }
    } while ((this._time == ((ObjectId)paramObject)._time) && (this._machine == ((ObjectId)paramObject)._machine) && (this._inc == ((ObjectId)paramObject)._inc));
    return false;
  }
  
  public int getInc()
  {
    return this._inc;
  }
  
  public int getMachine()
  {
    return this._machine;
  }
  
  public long getTime()
  {
    return this._time * 1000L;
  }
  
  public int getTimeSecond()
  {
    return this._time;
  }
  
  public int hashCode()
  {
    return this._time + this._machine * 111 + this._inc * 17;
  }
  
  public boolean isNew()
  {
    return this._new;
  }
  
  public void notNew()
  {
    this._new = false;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[12];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    localByteBuffer.putInt(this._time);
    localByteBuffer.putInt(this._machine);
    localByteBuffer.putInt(this._inc);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return toStringMongod();
  }
  
  public String toStringBabble()
  {
    return babbleToMongod(toStringMongod());
  }
  
  public String toStringMongod()
  {
    byte[] arrayOfByte = toByteArray();
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/ObjectId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */