package com.google.tagmanager.protobuf;

import java.io.IOException;

public class InvalidProtocolBufferException
  extends IOException
{
  private static final long serialVersionUID = -1616151763072450476L;
  private n unfinishedMessage = null;
  
  public InvalidProtocolBufferException(String paramString)
  {
    super(paramString);
  }
  
  static InvalidProtocolBufferException BO()
  {
    return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static InvalidProtocolBufferException BP()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static InvalidProtocolBufferException BQ()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
  }
  
  static InvalidProtocolBufferException BR()
  {
    return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
  }
  
  static InvalidProtocolBufferException BS()
  {
    return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
  }
  
  static InvalidProtocolBufferException BT()
  {
    return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
  }
  
  static InvalidProtocolBufferException BU()
  {
    return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static InvalidProtocolBufferException BV()
  {
    return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static InvalidProtocolBufferException BW()
  {
    return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
  }
  
  public n BN()
  {
    return this.unfinishedMessage;
  }
  
  public InvalidProtocolBufferException h(n paramn)
  {
    this.unfinishedMessage = paramn;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/InvalidProtocolBufferException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */