package b.a.a;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class b
  extends b.a.b
{
  private transient HttpClient a = new DefaultHttpClient();
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected b.a.c.b a(String paramString)
  {
    return new c(new HttpPost(paramString));
  }
  
  protected b.a.c.c a(b.a.c.b paramb)
  {
    return new d(this.a.execute((HttpUriRequest)paramb.e()));
  }
  
  protected void a(b.a.c.b paramb, b.a.c.c paramc)
  {
    if (paramc != null)
    {
      paramb = ((HttpResponse)paramc.d()).getEntity();
      if (paramb == null) {}
    }
    try
    {
      paramb.consumeContent();
      return;
    }
    catch (IOException paramb)
    {
      paramb.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */