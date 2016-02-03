package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.params.AbstractHttpParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ClientParamsStack
  extends AbstractHttpParams
{
  protected final HttpParams applicationParams;
  protected final HttpParams clientParams;
  protected final HttpParams overrideParams;
  protected final HttpParams requestParams;
  
  public ClientParamsStack(HttpParams paramHttpParams1, HttpParams paramHttpParams2, HttpParams paramHttpParams3, HttpParams paramHttpParams4)
  {
    this.applicationParams = paramHttpParams1;
    this.clientParams = paramHttpParams2;
    this.requestParams = paramHttpParams3;
    this.overrideParams = paramHttpParams4;
  }
  
  public Object getParameter(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Parameter name must not be null.");
    }
    Object localObject2 = null;
    if (this.overrideParams != null) {
      localObject2 = this.overrideParams.getParameter(paramString);
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.requestParams != null) {
        localObject1 = this.requestParams.getParameter(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.clientParams != null) {
        localObject2 = this.clientParams.getParameter(paramString);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.applicationParams != null) {
        localObject1 = this.applicationParams.getParameter(paramString);
      }
    }
    return localObject1;
  }
  
  public HttpParams setParameter(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/ClientParamsStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */