package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collection;

public abstract class AbstractMutableMessageLite
  implements MutableMessageLite
{
  protected int cachedSize = -1;
  private boolean isMutable = true;
  
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
  {
    AbstractMessageLite.Builder.addAll(paramIterable, paramCollection);
  }
  
  protected static <T extends MutableMessageLite> Parser<T> internalNewParserForType(T paramT)
  {
    new AbstractParser()
    {
      public T parsePartialFrom(CodedInputStream paramAnonymousCodedInputStream, ExtensionRegistryLite paramAnonymousExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        MutableMessageLite localMutableMessageLite = this.val$defaultInstance.newMessageForType();
        if (!localMutableMessageLite.mergeFrom(paramAnonymousCodedInputStream, paramAnonymousExtensionRegistryLite)) {
          throw InvalidProtocolBufferException.parseFailure().setUnfinishedMessage(localMutableMessageLite);
        }
        return localMutableMessageLite;
      }
    };
  }
  
  protected static UninitializedMessageException newUninitializedMessageException(MessageLite paramMessageLite)
  {
    return new UninitializedMessageException(paramMessageLite);
  }
  
  protected void assertMutable()
  {
    if (!this.isMutable) {
      throw new IllegalStateException("Try to modify an immutable message.");
    }
  }
  
  public MutableMessageLite clone()
  {
    throw new UnsupportedOperationException("clone() should be implemented by subclasses.");
  }
  
  public final int getCachedSize()
  {
    return this.cachedSize;
  }
  
  protected boolean isProto1Group()
  {
    return false;
  }
  
  protected void makeImmutable()
  {
    this.isMutable = false;
  }
  
  public boolean mergeDelimitedFrom(InputStream paramInputStream)
  {
    return mergeDelimitedFrom(paramInputStream, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  public boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return false;
      }
      boolean bool = mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, CodedInputStream.readRawVarint32(i, paramInputStream)), paramExtensionRegistryLite);
      return bool;
    }
    catch (IOException paramInputStream) {}
    return false;
  }
  
  public boolean mergeFrom(ByteString paramByteString)
  {
    paramByteString = paramByteString.newCodedInput();
    return (mergeFrom(paramByteString)) && (paramByteString.getLastTag() == 0);
  }
  
  public boolean mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramByteString = paramByteString.newCodedInput();
    return (mergeFrom(paramByteString, paramExtensionRegistryLite)) && (paramByteString.getLastTag() == 0);
  }
  
  public boolean mergeFrom(CodedInputStream paramCodedInputStream)
  {
    return mergeFrom(paramCodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  public boolean mergeFrom(InputStream paramInputStream)
  {
    paramInputStream = CodedInputStream.newInstance(paramInputStream);
    return (mergeFrom(paramInputStream)) && (paramInputStream.getLastTag() == 0);
  }
  
  public boolean mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramInputStream = CodedInputStream.newInstance(paramInputStream);
    return (mergeFrom(paramInputStream, paramExtensionRegistryLite)) && (paramInputStream.getLastTag() == 0);
  }
  
  public boolean mergeFrom(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = CodedInputStream.newInstance(paramByteBuffer);
    return (mergeFrom(paramByteBuffer)) && (paramByteBuffer.getLastTag() == 0);
  }
  
  public boolean mergeFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramByteBuffer = CodedInputStream.newInstance(paramByteBuffer);
    return (mergeFrom(paramByteBuffer, paramExtensionRegistryLite)) && (paramByteBuffer.getLastTag() == 0);
  }
  
  public boolean mergeFrom(byte[] paramArrayOfByte)
  {
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = CodedInputStream.newInstance(paramArrayOfByte, paramInt1, paramInt2);
    return (mergeFrom(paramArrayOfByte)) && (paramArrayOfByte.getLastTag() == 0);
  }
  
  public boolean mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramArrayOfByte = CodedInputStream.newInstance(paramArrayOfByte, paramInt1, paramInt2);
    return (mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)) && (paramArrayOfByte.getLastTag() == 0);
  }
  
  public boolean mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
  
  public boolean mergePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return mergeFrom(paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public MutableMessageLite mutableCopy()
  {
    throw new UnsupportedOperationException("mutableCopy() is not supported in mutable messages. Use clone() if you need to make a copy of the mutable message.");
  }
  
  public MessageLite.Builder newBuilderForType()
  {
    throw new UnsupportedOperationException("newBuilderForType() is not supported in mutable messages.");
  }
  
  UninitializedMessageException newUninitializedMessageException()
  {
    return new UninitializedMessageException(this);
  }
  
  public boolean parseDelimitedFrom(InputStream paramInputStream)
  {
    clear();
    return mergeDelimitedFrom(paramInputStream);
  }
  
  public boolean parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public boolean parseFrom(ByteString paramByteString)
  {
    clear();
    return mergeFrom(paramByteString);
  }
  
  public boolean parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public boolean parseFrom(CodedInputStream paramCodedInputStream)
  {
    clear();
    return mergeFrom(paramCodedInputStream);
  }
  
  public boolean parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeFrom(paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public boolean parseFrom(InputStream paramInputStream)
  {
    clear();
    return mergeFrom(paramInputStream);
  }
  
  public boolean parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public boolean parseFrom(ByteBuffer paramByteBuffer)
  {
    clear();
    return mergeFrom(paramByteBuffer);
  }
  
  public boolean parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public boolean parseFrom(byte[] paramArrayOfByte)
  {
    clear();
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    clear();
    return mergeFrom(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeFrom(paramArrayOfByte, paramInt1, paramInt2, paramExtensionRegistryLite);
  }
  
  public boolean parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    clear();
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
  
  public MessageLite.Builder toBuilder()
  {
    throw new UnsupportedOperationException("toBuilder() is not supported in mutable messages.");
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(arrayOfByte);
      writeTo(localCodedOutputStream);
      localCodedOutputStream.checkNoSpaceLeft();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public ByteString toByteString()
  {
    try
    {
      Object localObject = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(((ByteString.CodedBuilder)localObject).getCodedOutput());
      localObject = ((ByteString.CodedBuilder)localObject).build();
      return (ByteString)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream)
    throws IOException
  {
    int i = getSerializedSize();
    paramOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(i) + i));
    paramOutputStream.writeRawVarint32(i);
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException
  {
    getSerializedSize();
    writeToWithCachedSizes(paramCodedOutputStream);
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/AbstractMutableMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */