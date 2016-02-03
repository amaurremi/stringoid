package b.a.a;

import b.a.c.c;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class d
  implements c
{
  private HttpResponse a;
  
  public d(HttpResponse paramHttpResponse)
  {
    this.a = paramHttpResponse;
  }
  
  public InputStream a()
  {
    return this.a.getEntity().getContent();
  }
  
  public int b()
  {
    return this.a.getStatusLine().getStatusCode();
  }
  
  public String c()
  {
    return this.a.getStatusLine().getReasonPhrase();
  }
  
  public Object d()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */