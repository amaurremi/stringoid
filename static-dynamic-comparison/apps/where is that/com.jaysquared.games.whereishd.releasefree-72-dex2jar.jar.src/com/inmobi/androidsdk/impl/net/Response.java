package com.inmobi.androidsdk.impl.net;

public class Response
{
  String a = null;
  String b = null;
  
  public Response(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getAdResponse()
  {
    return this.b;
  }
  
  public String getImpressionId()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/impl/net/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */