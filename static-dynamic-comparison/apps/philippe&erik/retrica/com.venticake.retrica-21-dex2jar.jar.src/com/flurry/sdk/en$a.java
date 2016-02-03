package com.flurry.sdk;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;

public enum en$a
{
  private en$a() {}
  
  public HttpRequestBase a(String paramString)
  {
    switch (en.3.a[ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new HttpPost(paramString);
    case 2: 
      return new HttpPut(paramString);
    case 3: 
      return new HttpDelete(paramString);
    case 4: 
      return new HttpHead(paramString);
    }
    return new HttpGet(paramString);
  }
  
  public String toString()
  {
    switch (en.3.a[ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "POST";
    case 2: 
      return "PUT";
    case 3: 
      return "DELETE";
    case 4: 
      return "HEAD";
    }
    return "GET";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/en$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */