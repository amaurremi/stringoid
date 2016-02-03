package com.parse.signpost.http;

import java.io.IOException;
import java.io.InputStream;

public abstract interface HttpResponse
{
  public abstract InputStream getContent()
    throws IOException;
  
  public abstract String getReasonPhrase()
    throws Exception;
  
  public abstract int getStatusCode()
    throws IOException;
  
  public abstract Object unwrap();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/http/HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */