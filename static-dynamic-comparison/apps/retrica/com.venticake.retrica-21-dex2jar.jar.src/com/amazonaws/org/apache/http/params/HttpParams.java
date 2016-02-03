package com.amazonaws.org.apache.http.params;

public abstract interface HttpParams
{
  public abstract boolean getBooleanParameter(String paramString, boolean paramBoolean);
  
  public abstract int getIntParameter(String paramString, int paramInt);
  
  public abstract Object getParameter(String paramString);
  
  public abstract boolean isParameterFalse(String paramString);
  
  public abstract boolean isParameterTrue(String paramString);
  
  public abstract HttpParams setBooleanParameter(String paramString, boolean paramBoolean);
  
  public abstract HttpParams setIntParameter(String paramString, int paramInt);
  
  public abstract HttpParams setParameter(String paramString, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/params/HttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */