package com.amazonaws.org.apache.http.impl.auth;

public abstract interface NTLMEngine
{
  public abstract String generateType1Msg(String paramString1, String paramString2);
  
  public abstract String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */