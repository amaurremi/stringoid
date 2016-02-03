package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser<MessageType extends MessageLite>
  implements Parser<MessageType>
{
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  
  private MessageType checkMessageInitialized(MessageType paramMessageType)
    throws InvalidProtocolBufferException
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized())) {
      throw newUninitializedMessageException(paramMessageType).asInvalidProtocolBufferException().setUnfinishedMessage(paramMessageType);
    }
    return paramMessageType;
  }
  
  private UninitializedMessageException newUninitializedMessageException(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof AbstractMessageLite)) {
      return ((AbstractMessageLite)paramMessageType).newUninitializedMessageException();
    }
    if ((paramMessageType instanceof AbstractMutableMessageLite)) {
      return ((AbstractMutableMessageLite)paramMessageType).newUninitializedMessageException();
    }
    return new UninitializedMessageException(paramMessageType);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException
  {
    return parseDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return parseFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialFrom(paramByteString, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream)
    throws InvalidProtocolBufferException
  {
    return parseFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized((MessageLite)parsePartialFrom(paramCodedInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException
  {
    return parseFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return parseFrom(paramArrayOfByte, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException
  {
    return parseFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return parseFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException
  {
    return parsePartialDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      i = CodedInputStream.readRawVarint32(i, paramInputStream);
      return parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, i), paramExtensionRegistryLite);
    }
    catch (IOException paramInputStream)
    {
      throw new InvalidProtocolBufferException(paramInputStream.getMessage());
    }
  }
  
  public MessageType parsePartialFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 166	com/google/tagmanager/protobuf/ByteString:newCodedInput	()Lcom/google/tagmanager/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 96	com/google/tagmanager/protobuf/AbstractParser:parsePartialFrom	(Lcom/google/tagmanager/protobuf/CodedInputStream;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   11: checkcast 29	com/google/tagmanager/protobuf/MessageLite
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 170	com/google/tagmanager/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 47	com/google/tagmanager/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/tagmanager/protobuf/MessageLite;)Lcom/google/tagmanager/protobuf/InvalidProtocolBufferException;
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: new 172	java/lang/RuntimeException
    //   36: dup
    //   37: ldc -82
    //   39: aload_1
    //   40: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	AbstractParser
    //   0	44	1	paramByteString	ByteString
    //   0	44	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   0	15	29	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   23	29	29	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   0	15	32	java/io/IOException
    //   15	20	32	java/io/IOException
    //   23	29	32	java/io/IOException
  }
  
  public MessageType parsePartialFrom(CodedInputStream paramCodedInputStream)
    throws InvalidProtocolBufferException
  {
    return (MessageLite)parsePartialFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    paramInputStream = CodedInputStream.newInstance(paramInputStream);
    paramExtensionRegistryLite = (MessageLite)parsePartialFrom(paramInputStream, paramExtensionRegistryLite);
    try
    {
      paramInputStream.checkLastTagWas(0);
      return paramExtensionRegistryLite;
    }
    catch (InvalidProtocolBufferException paramInputStream)
    {
      throw paramInputStream.setUnfinishedMessage(paramExtensionRegistryLite);
    }
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: iload_3
    //   3: invokestatic 184	com/google/tagmanager/protobuf/CodedInputStream:newInstance	([BII)Lcom/google/tagmanager/protobuf/CodedInputStream;
    //   6: astore_1
    //   7: aload_0
    //   8: aload_1
    //   9: aload 4
    //   11: invokevirtual 96	com/google/tagmanager/protobuf/AbstractParser:parsePartialFrom	(Lcom/google/tagmanager/protobuf/CodedInputStream;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   14: checkcast 29	com/google/tagmanager/protobuf/MessageLite
    //   17: astore 4
    //   19: aload_1
    //   20: iconst_0
    //   21: invokevirtual 170	com/google/tagmanager/protobuf/CodedInputStream:checkLastTagWas	(I)V
    //   24: aload 4
    //   26: areturn
    //   27: astore_1
    //   28: aload_1
    //   29: aload 4
    //   31: invokevirtual 47	com/google/tagmanager/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/tagmanager/protobuf/MessageLite;)Lcom/google/tagmanager/protobuf/InvalidProtocolBufferException;
    //   34: athrow
    //   35: astore_1
    //   36: aload_1
    //   37: athrow
    //   38: astore_1
    //   39: new 172	java/lang/RuntimeException
    //   42: dup
    //   43: ldc -70
    //   45: aload_1
    //   46: invokespecial 177	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	AbstractParser
    //   0	50	1	paramArrayOfByte	byte[]
    //   0	50	2	paramInt1	int
    //   0	50	3	paramInt2	int
    //   0	50	4	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   19	24	27	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   0	19	35	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   28	35	35	com/google/tagmanager/protobuf/InvalidProtocolBufferException
    //   0	19	38	java/io/IOException
    //   19	24	38	java/io/IOException
    //   28	35	38	java/io/IOException
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/AbstractParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */