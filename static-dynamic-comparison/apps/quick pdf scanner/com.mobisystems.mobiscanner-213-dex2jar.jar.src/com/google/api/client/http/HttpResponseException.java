package com.google.api.client.http;

import com.google.api.client.util.ab;
import com.google.api.client.util.x;
import java.io.IOException;

public class HttpResponseException
  extends IOException
{
  private static final long serialVersionUID = -1875819453475890043L;
  private final transient n abp;
  private final String content;
  private final int statusCode;
  private final String statusMessage;
  
  protected HttpResponseException(a parama)
  {
    super(parama.message);
    this.statusCode = parama.statusCode;
    this.statusMessage = parama.statusMessage;
    this.abp = parama.abp;
    this.content = parama.content;
  }
  
  public HttpResponseException(t paramt)
  {
    this(new a(paramt));
  }
  
  public static StringBuilder d(t paramt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramt.getStatusCode();
    if (i != 0) {
      localStringBuilder.append(i);
    }
    paramt = paramt.xM();
    if (paramt != null)
    {
      if (i != 0) {
        localStringBuilder.append(' ');
      }
      localStringBuilder.append(paramt);
    }
    return localStringBuilder;
  }
  
  public static class a
  {
    n abp;
    String content;
    String message;
    int statusCode;
    String statusMessage;
    
    public a(int paramInt, String paramString, n paramn)
    {
      eF(paramInt);
      ch(paramString);
      c(paramn);
    }
    
    public a(t paramt)
    {
      this(paramt.getStatusCode(), paramt.xM(), paramt.xC());
      try
      {
        this.content = paramt.xQ();
        if (this.content.length() == 0) {
          this.content = null;
        }
        paramt = HttpResponseException.d(paramt);
        if (this.content != null) {
          paramt.append(ab.aeg).append(this.content);
        }
        this.message = paramt.toString();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    
    public a c(n paramn)
    {
      this.abp = ((n)x.ad(paramn));
      return this;
    }
    
    public a cg(String paramString)
    {
      this.message = paramString;
      return this;
    }
    
    public a ch(String paramString)
    {
      this.statusMessage = paramString;
      return this;
    }
    
    public a ci(String paramString)
    {
      this.content = paramString;
      return this;
    }
    
    public a eF(int paramInt)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        x.av(bool);
        this.statusCode = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/HttpResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */