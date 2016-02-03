package com.amazonaws.org.apache.http.params;

public abstract class AbstractHttpParams
  implements HttpParams
{
  public boolean getBooleanParameter(String paramString, boolean paramBoolean)
  {
    paramString = getParameter(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public int getIntParameter(String paramString, int paramInt)
  {
    paramString = getParameter(paramString);
    if (paramString == null) {
      return paramInt;
    }
    return ((Integer)paramString).intValue();
  }
  
  public boolean isParameterFalse(String paramString)
  {
    boolean bool = false;
    if (!getBooleanParameter(paramString, false)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isParameterTrue(String paramString)
  {
    return getBooleanParameter(paramString, false);
  }
  
  public HttpParams setBooleanParameter(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      setParameter(paramString, localBoolean);
      return this;
    }
  }
  
  public HttpParams setIntParameter(String paramString, int paramInt)
  {
    setParameter(paramString, new Integer(paramInt));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/params/AbstractHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */