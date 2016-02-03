package com.amazonaws;

import java.util.Map;

public class ResponseMetadata
{
  protected final Map<String, String> metadata;
  
  public ResponseMetadata(Map<String, String> paramMap)
  {
    this.metadata = paramMap;
  }
  
  public String getRequestId()
  {
    return (String)this.metadata.get("AWS_REQUEST_ID");
  }
  
  public String toString()
  {
    if (this.metadata == null) {
      return "{}";
    }
    return this.metadata.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/ResponseMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */