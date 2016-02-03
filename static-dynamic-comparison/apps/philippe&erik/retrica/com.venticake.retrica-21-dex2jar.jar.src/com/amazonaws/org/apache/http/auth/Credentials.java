package com.amazonaws.org.apache.http.auth;

import java.security.Principal;

public abstract interface Credentials
{
  public abstract String getPassword();
  
  public abstract Principal getUserPrincipal();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */