package com.google.api.client.googleapis.a.a;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.t;

public abstract class b<T>
  extends com.google.api.client.googleapis.a.b<T>
{
  private final Object aaM;
  
  protected b(a parama, String paramString1, String paramString2, Object paramObject, Class<T> paramClass) {}
  
  protected GoogleJsonResponseException c(t paramt)
  {
    return GoogleJsonResponseException.a(xh().xg(), paramt);
  }
  
  public b<T> f(String paramString, Object paramObject)
  {
    return (b)super.e(paramString, paramObject);
  }
  
  public a xh()
  {
    return (a)super.xb();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */