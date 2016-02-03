package com.amazonaws.util;

public class ResponseMetadataCache
{
  private final ResponseMetadataCache.InternalCache internalCache;
  
  public ResponseMetadataCache(int paramInt)
  {
    this.internalCache = new ResponseMetadataCache.InternalCache(paramInt);
  }
  
  /* Error */
  public void add(Object paramObject, com.amazonaws.ResponseMetadata paramResponseMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 17	com/amazonaws/util/ResponseMetadataCache:internalCache	Lcom/amazonaws/util/ResponseMetadataCache$InternalCache;
    //   13: aload_1
    //   14: invokestatic 26	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   17: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aload_2
    //   21: invokevirtual 36	com/amazonaws/util/ResponseMetadataCache$InternalCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: pop
    //   25: goto -19 -> 6
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ResponseMetadataCache
    //   0	33	1	paramObject	Object
    //   0	33	2	paramResponseMetadata	com.amazonaws.ResponseMetadata
    // Exception table:
    //   from	to	target	type
    //   9	25	28	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/ResponseMetadataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */