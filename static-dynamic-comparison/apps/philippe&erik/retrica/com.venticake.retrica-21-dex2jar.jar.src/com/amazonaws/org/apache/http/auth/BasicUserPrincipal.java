package com.amazonaws.org.apache.http.auth;

import com.amazonaws.org.apache.http.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;
import org.apache.http.annotation.Immutable;

@Immutable
public final class BasicUserPrincipal
  implements Serializable, Principal
{
  private final String username;
  
  public BasicUserPrincipal(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("User name may not be null");
    }
    this.username = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof BasicUserPrincipal)) {
        break;
      }
      paramObject = (BasicUserPrincipal)paramObject;
    } while (LangUtils.equals(this.username, ((BasicUserPrincipal)paramObject).username));
    return false;
  }
  
  public String getName()
  {
    return this.username;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(17, this.username);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[principal: ");
    localStringBuilder.append(this.username);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/BasicUserPrincipal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */