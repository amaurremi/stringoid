package com.bubble.play.services.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class SerializationUtils
{
  public static Object clone(Serializable paramSerializable)
  {
    return deserialize(serialize(paramSerializable));
  }
  
  /* Error */
  public static Object deserialize(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 26	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 28
    //   10: invokespecial 31	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore_1
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore_2
    //   20: new 33	java/io/ObjectInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 36	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 40	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   33: astore_1
    //   34: aload_0
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   42: aload_1
    //   43: areturn
    //   44: astore_0
    //   45: aload_2
    //   46: astore_1
    //   47: new 45	com/bubble/play/services/utils/SerializationException
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 48	com/bubble/play/services/utils/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_0
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 43	java/io/ObjectInputStream:close	()V
    //   65: aload_0
    //   66: athrow
    //   67: astore_0
    //   68: aload_3
    //   69: astore_1
    //   70: new 45	com/bubble/play/services/utils/SerializationException
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 48	com/bubble/play/services/utils/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: astore_0
    //   80: aload_1
    //   81: areturn
    //   82: astore_1
    //   83: goto -18 -> 65
    //   86: astore_2
    //   87: aload_0
    //   88: astore_1
    //   89: aload_2
    //   90: astore_0
    //   91: goto -34 -> 57
    //   94: astore_2
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: goto -29 -> 70
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: goto -60 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramInputStream	java.io.InputStream
    //   15	66	1	localObject1	Object
    //   82	1	1	localIOException1	java.io.IOException
    //   88	17	1	localInputStream	java.io.InputStream
    //   19	27	2	localObject2	Object
    //   86	4	2	localObject3	Object
    //   94	4	2	localIOException2	java.io.IOException
    //   102	4	2	localClassNotFoundException	ClassNotFoundException
    //   17	52	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	44	java/lang/ClassNotFoundException
    //   20	29	56	finally
    //   47	56	56	finally
    //   70	79	56	finally
    //   20	29	67	java/io/IOException
    //   38	42	79	java/io/IOException
    //   61	65	82	java/io/IOException
    //   29	34	86	finally
    //   29	34	94	java/io/IOException
    //   29	34	102	java/lang/ClassNotFoundException
  }
  
  public static Object deserialize(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("The byte[] must not be null");
    }
    return deserialize(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  /* Error */
  public static void serialize(Serializable paramSerializable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 26	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 60
    //   10: invokespecial 31	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore_3
    //   18: new 62	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 65	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 69	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 70	java/io/ObjectOutputStream:close	()V
    //   40: return
    //   41: astore_0
    //   42: aload_3
    //   43: astore_2
    //   44: new 45	com/bubble/play/services/utils/SerializationException
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 48	com/bubble/play/services/utils/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   52: athrow
    //   53: astore_0
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 70	java/io/ObjectOutputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: return
    //   66: astore_1
    //   67: goto -5 -> 62
    //   70: astore_0
    //   71: aload_1
    //   72: astore_2
    //   73: goto -19 -> 54
    //   76: astore_0
    //   77: aload_1
    //   78: astore_2
    //   79: goto -35 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramSerializable	Serializable
    //   0	82	1	paramOutputStream	java.io.OutputStream
    //   15	64	2	localObject1	Object
    //   17	26	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	41	java/io/IOException
    //   18	27	53	finally
    //   44	53	53	finally
    //   36	40	64	java/io/IOException
    //   58	62	66	java/io/IOException
    //   27	32	70	finally
    //   27	32	76	java/io/IOException
  }
  
  public static byte[] serialize(Serializable paramSerializable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    serialize(paramSerializable, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/utils/SerializationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */