package com.google.api.a.a;

import com.google.api.client.util.o;

public abstract class b<T>
  extends com.google.api.client.googleapis.a.a.b<T>
{
  @o
  private String alt;
  @o
  private String fields;
  @o
  private String key;
  @o(yS="oauth_token")
  private String oauthToken;
  @o
  private Boolean prettyPrint;
  @o
  private String quotaUser;
  @o
  private String userIp;
  
  public b(a parama, String paramString1, String paramString2, Object paramObject, Class<T> paramClass)
  {
    super(parama, paramString1, paramString2, paramObject, paramClass);
  }
  
  public b<T> k(String paramString, Object paramObject)
  {
    return (b)super.f(paramString, paramObject);
  }
  
  public final a za()
  {
    return (a)super.xh();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */