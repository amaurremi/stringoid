package twitter4j.auth;

import java.io.Serializable;
import twitter4j.internal.http.HttpRequest;

public abstract interface Authorization
  extends Serializable
{
  public abstract String getAuthorizationHeader(HttpRequest paramHttpRequest);
  
  public abstract boolean isEnabled();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/auth/Authorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */