package com.google.tagmanager.protobuf;

import java.io.InputStream;

public abstract interface Parser<MessageType>
{
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialDelimitedFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/protobuf/Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */