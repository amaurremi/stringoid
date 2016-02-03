package com.amazonaws.org.apache.http;

import java.io.InputStream;
import java.io.OutputStream;

public abstract interface HttpEntity
{
  public abstract InputStream getContent();
  
  public abstract Header getContentEncoding();
  
  public abstract long getContentLength();
  
  public abstract Header getContentType();
  
  public abstract boolean isChunked();
  
  public abstract boolean isRepeatable();
  
  public abstract boolean isStreaming();
  
  public abstract void writeTo(OutputStream paramOutputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */