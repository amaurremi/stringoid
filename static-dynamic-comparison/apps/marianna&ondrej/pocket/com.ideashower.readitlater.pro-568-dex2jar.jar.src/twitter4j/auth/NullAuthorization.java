package twitter4j.auth;

import java.io.Serializable;
import twitter4j.internal.http.HttpRequest;

public class NullAuthorization
  implements Serializable, Authorization
{
  private static NullAuthorization SINGLETON = new NullAuthorization();
  private static final long serialVersionUID = -8748173338942663960L;
  
  public static NullAuthorization getInstance()
  {
    return SINGLETON;
  }
  
  private Object readResolve()
  {
    return SINGLETON;
  }
  
  public boolean equals(Object paramObject)
  {
    return SINGLETON == paramObject;
  }
  
  public String getAuthorizationHeader(HttpRequest paramHttpRequest)
  {
    return null;
  }
  
  public boolean isEnabled()
  {
    return false;
  }
  
  public String toString()
  {
    return "NullAuthentication{SINGLETON}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/auth/NullAuthorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */