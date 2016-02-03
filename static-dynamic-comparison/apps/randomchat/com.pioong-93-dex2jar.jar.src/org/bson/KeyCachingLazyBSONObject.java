package org.bson;

import java.util.HashMap;
import org.bson.io.BSONByteBuffer;

public class KeyCachingLazyBSONObject
  extends LazyBSONObject
{
  private HashMap<String, LazyBSONObject.ElementRecord> fieldIndex = new HashMap();
  
  public KeyCachingLazyBSONObject(BSONByteBuffer paramBSONByteBuffer, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramInt, paramLazyBSONCallback);
  }
  
  public KeyCachingLazyBSONObject(BSONByteBuffer paramBSONByteBuffer, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramBSONByteBuffer, paramLazyBSONCallback);
  }
  
  public KeyCachingLazyBSONObject(byte[] paramArrayOfByte, int paramInt, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramInt, paramLazyBSONCallback);
  }
  
  public KeyCachingLazyBSONObject(byte[] paramArrayOfByte, LazyBSONCallback paramLazyBSONCallback)
  {
    super(paramArrayOfByte, paramLazyBSONCallback);
  }
  
  /* Error */
  private void ensureFieldList()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	org/bson/KeyCachingLazyBSONObject:fieldIndex	Ljava/util/HashMap;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 35	org/bson/KeyCachingLazyBSONObject:_doc_start_offset	I
    //   20: iconst_4
    //   21: iadd
    //   22: istore_1
    //   23: aload_0
    //   24: iload_1
    //   25: invokevirtual 39	org/bson/KeyCachingLazyBSONObject:isElementEmpty	(I)Z
    //   28: ifne -15 -> 13
    //   31: aload_0
    //   32: iload_1
    //   33: invokevirtual 43	org/bson/KeyCachingLazyBSONObject:sizeCString	(I)I
    //   36: istore_2
    //   37: iload_1
    //   38: iconst_1
    //   39: iadd
    //   40: istore_3
    //   41: aload_0
    //   42: iload_1
    //   43: invokevirtual 46	org/bson/KeyCachingLazyBSONObject:getElementBSONSize	(I)I
    //   46: istore_1
    //   47: aload_0
    //   48: getfield 50	org/bson/KeyCachingLazyBSONObject:_input	Lorg/bson/io/BSONByteBuffer;
    //   51: iload_3
    //   52: invokevirtual 56	org/bson/io/BSONByteBuffer:getCString	(I)Ljava/lang/String;
    //   55: astore 4
    //   57: new 58	org/bson/LazyBSONObject$ElementRecord
    //   60: dup
    //   61: aload_0
    //   62: aload 4
    //   64: iload_3
    //   65: invokespecial 61	org/bson/LazyBSONObject$ElementRecord:<init>	(Lorg/bson/LazyBSONObject;Ljava/lang/String;I)V
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 18	org/bson/KeyCachingLazyBSONObject:fieldIndex	Ljava/util/HashMap;
    //   74: aload 4
    //   76: aload 5
    //   78: invokevirtual 65	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: iload_3
    //   83: iload_2
    //   84: iload_1
    //   85: iadd
    //   86: iadd
    //   87: istore_1
    //   88: goto -65 -> 23
    //   91: astore 4
    //   93: aload_0
    //   94: new 13	java/util/HashMap
    //   97: dup
    //   98: invokespecial 16	java/util/HashMap:<init>	()V
    //   101: putfield 18	org/bson/KeyCachingLazyBSONObject:fieldIndex	Ljava/util/HashMap;
    //   104: goto -91 -> 13
    //   107: astore 4
    //   109: aload_0
    //   110: monitorexit
    //   111: aload 4
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	KeyCachingLazyBSONObject
    //   22	66	1	i	int
    //   36	50	2	j	int
    //   40	47	3	k	int
    //   6	69	4	localObject1	Object
    //   91	1	4	localException	Exception
    //   107	5	4	localObject2	Object
    //   68	9	5	localElementRecord	LazyBSONObject.ElementRecord
    // Exception table:
    //   from	to	target	type
    //   16	23	91	java/lang/Exception
    //   23	37	91	java/lang/Exception
    //   41	82	91	java/lang/Exception
    //   2	8	107	finally
    //   16	23	107	finally
    //   23	37	107	finally
    //   41	82	107	finally
    //   93	104	107	finally
  }
  
  public boolean containsField(String paramString)
  {
    ensureFieldList();
    if (!this.fieldIndex.containsKey(paramString)) {
      return false;
    }
    return super.containsField(paramString);
  }
  
  public Object get(String paramString)
  {
    ensureFieldList();
    return super.get(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/KeyCachingLazyBSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */