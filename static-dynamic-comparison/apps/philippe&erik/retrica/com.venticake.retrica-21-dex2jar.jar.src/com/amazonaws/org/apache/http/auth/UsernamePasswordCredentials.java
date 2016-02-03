package com.amazonaws.org.apache.http.auth;

import com.amazonaws.org.apache.http.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;
import org.apache.http.annotation.Immutable;

@Immutable
public class UsernamePasswordCredentials
  implements Credentials, Serializable
{
  private final String password;
  private final BasicUserPrincipal principal;
  
  public UsernamePasswordCredentials(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Username:password string may not be null");
    }
    int i = paramString.indexOf(':');
    if (i >= 0)
    {
      this.principal = new BasicUserPrincipal(paramString.substring(0, i));
      this.password = paramString.substring(i + 1);
      return;
    }
    this.principal = new BasicUserPrincipal(paramString);
    this.password = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UsernamePasswordCredentials)) {
        break;
      }
      paramObject = (UsernamePasswordCredentials)paramObject;
    } while (LangUtils.equals(this.principal, ((UsernamePasswordCredentials)paramObject).principal));
    return false;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public Principal getUserPrincipal()
  {
    return this.principal;
  }
  
  public int hashCode()
  {
    return this.principal.hashCode();
  }
  
  public String toString()
  {
    return this.principal.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/UsernamePasswordCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */