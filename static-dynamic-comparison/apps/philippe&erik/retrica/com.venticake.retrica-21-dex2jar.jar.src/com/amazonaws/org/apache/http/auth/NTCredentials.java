package com.amazonaws.org.apache.http.auth;

import com.amazonaws.org.apache.http.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public class NTCredentials
  implements Credentials, Serializable
{
  private final String password;
  private final NTUserPrincipal principal;
  private final String workstation;
  
  public NTCredentials(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("User name may not be null");
    }
    this.principal = new NTUserPrincipal(paramString4, paramString1);
    this.password = paramString2;
    if (paramString3 != null)
    {
      this.workstation = paramString3.toUpperCase(Locale.ENGLISH);
      return;
    }
    this.workstation = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NTCredentials)) {
        break;
      }
      paramObject = (NTCredentials)paramObject;
    } while ((LangUtils.equals(this.principal, ((NTCredentials)paramObject).principal)) && (LangUtils.equals(this.workstation, ((NTCredentials)paramObject).workstation)));
    return false;
  }
  
  public String getDomain()
  {
    return this.principal.getDomain();
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getUserName()
  {
    return this.principal.getUsername();
  }
  
  public Principal getUserPrincipal()
  {
    return this.principal;
  }
  
  public String getWorkstation()
  {
    return this.workstation;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(17, this.principal), this.workstation);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[principal: ");
    localStringBuilder.append(this.principal);
    localStringBuilder.append("][workstation: ");
    localStringBuilder.append(this.workstation);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/NTCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */