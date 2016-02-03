package b.a.a;

import b.a.c.b;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;

public class c
  implements b
{
  private HttpUriRequest a;
  private HttpEntity b;
  
  public c(HttpUriRequest paramHttpUriRequest)
  {
    this.a = paramHttpUriRequest;
    if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest)) {
      this.b = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
    }
  }
  
  public String a()
  {
    return this.a.getRequestLine().getMethod();
  }
  
  public String a(String paramString)
  {
    paramString = this.a.getFirstHeader(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getValue();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.setHeader(paramString1, paramString2);
  }
  
  public String b()
  {
    return this.a.getURI().toString();
  }
  
  public String c()
  {
    if (this.b == null) {}
    Header localHeader;
    do
    {
      return null;
      localHeader = this.b.getContentType();
    } while (localHeader == null);
    return localHeader.getValue();
  }
  
  public InputStream d()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.getContent();
  }
  
  public Object e()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */