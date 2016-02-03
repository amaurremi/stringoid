package com.google.tagmanager.protobuf;

public abstract class c<MessageType extends n>
  implements q<MessageType>
{
  private static final g ajb = ;
  
  private UninitializedMessageException a(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof a)) {
      return ((a)paramMessageType).AE();
    }
    if ((paramMessageType instanceof b)) {
      return ((b)paramMessageType).AE();
    }
    return new UninitializedMessageException(paramMessageType);
  }
  
  private MessageType b(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized())) {
      throw a(paramMessageType).Cp().h(paramMessageType);
    }
    return paramMessageType;
  }
  
  /* Error */
  public MessageType a(e parame, g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 71	com/google/tagmanager/protobuf/e:AM	()Lcom/google/tagmanager/protobuf/f;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 74	com/google/tagmanager/protobuf/c:b	(Lcom/google/tagmanager/protobuf/f;Lcom/google/tagmanager/protobuf/g;)Ljava/lang/Object;
    //   11: checkcast 45	com/google/tagmanager/protobuf/n
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 80	com/google/tagmanager/protobuf/f:eT	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 61	com/google/tagmanager/protobuf/InvalidProtocolBufferException:h	(Lcom/google/tagmanager/protobuf/n;)Lcom/google/tagmanager/protobuf/InvalidProtocolBufferException;
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: new 82	java/lang/RuntimeException
    //   36: dup
    //   37: ldc 84
    //   39: aload_1
    //   40: invokespecial 87	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	c
    //   0	44	1	parame	e
    //   0	44	2	paramg	g
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   0	15	29	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   23	29	29	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   0	15	32	java/io/IOException
    //   15	20	32	java/io/IOException
    //   23	29	32	java/io/IOException
  }
  
  public MessageType b(e parame, g paramg)
  {
    return b(a(parame, paramg));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */