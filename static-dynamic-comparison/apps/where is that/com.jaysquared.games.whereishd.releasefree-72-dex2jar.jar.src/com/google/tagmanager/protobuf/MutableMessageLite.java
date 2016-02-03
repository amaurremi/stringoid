package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface MutableMessageLite
  extends MessageLite, Cloneable
{
  public abstract MutableMessageLite clear();
  
  public abstract MutableMessageLite clone();
  
  public abstract int getCachedSize();
  
  public abstract MessageLite getDefaultInstanceForType();
  
  public abstract MessageLite immutableCopy();
  
  public abstract boolean mergeDelimitedFrom(InputStream paramInputStream);
  
  public abstract boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergeFrom(ByteString paramByteString);
  
  public abstract boolean mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergeFrom(CodedInputStream paramCodedInputStream);
  
  public abstract boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergeFrom(InputStream paramInputStream);
  
  public abstract boolean mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergeFrom(ByteBuffer paramByteBuffer);
  
  public abstract boolean mergeFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergeFrom(byte[] paramArrayOfByte);
  
  public abstract boolean mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract boolean mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean mergePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract MutableMessageLite newMessageForType();
  
  public abstract boolean parseDelimitedFrom(InputStream paramInputStream);
  
  public abstract boolean parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean parseFrom(ByteString paramByteString);
  
  public abstract boolean parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean parseFrom(InputStream paramInputStream);
  
  public abstract boolean parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean parseFrom(ByteBuffer paramByteBuffer);
  
  public abstract boolean parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean parseFrom(byte[] paramArrayOfByte);
  
  public abstract boolean parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract boolean parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/MutableMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */