package com.ideashower.readitlater.f;

import com.pocket.m.a.a;
import java.net.URI;
import org.apache.http.client.methods.HttpUriRequest;

public class d
{
  private final String a;
  private final HttpUriRequest b;
  private final a c;
  private final int d;
  private c e;
  
  public d(a parama)
  {
    this.a = parama.e();
    this.b = null;
    this.c = parama;
    this.d = parama.g();
  }
  
  public d(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = null;
    this.c = null;
    this.d = paramInt;
  }
  
  public d(HttpUriRequest paramHttpUriRequest, int paramInt)
  {
    this.a = paramHttpUriRequest.getURI().toString();
    this.b = paramHttpUriRequest;
    this.c = null;
    this.d = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */