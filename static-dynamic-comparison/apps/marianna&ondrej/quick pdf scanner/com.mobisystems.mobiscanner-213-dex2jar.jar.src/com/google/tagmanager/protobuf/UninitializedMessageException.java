package com.google.tagmanager.protobuf;

import java.util.List;

public class UninitializedMessageException
  extends RuntimeException
{
  private static final long serialVersionUID = -7466929953374883507L;
  private final List<String> missingFields = null;
  
  public UninitializedMessageException(n paramn)
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
  }
  
  public InvalidProtocolBufferException Cp()
  {
    return new InvalidProtocolBufferException(getMessage());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/UninitializedMessageException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */