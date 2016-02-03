package com.amazonaws.auth;

public enum SignatureVersion
{
  V1("1"),  V2("2");
  
  private String value;
  
  private SignatureVersion(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/SignatureVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */