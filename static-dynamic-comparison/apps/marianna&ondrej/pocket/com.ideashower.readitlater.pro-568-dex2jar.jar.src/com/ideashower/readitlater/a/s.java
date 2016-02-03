package com.ideashower.readitlater.a;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

class s
  implements Callable
{
  private s(r paramr) {}
  
  public u a()
  {
    final u localu = new u();
    a locala = new a("https://getpocket.com/v3/guid", false);
    locala.a(false);
    locala.a(new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = l.d().createJsonParser(paramAnonymousInputStream);
        paramAnonymousInputStream.nextToken();
        while ((paramAnonymousInputStream.nextToken() != JsonToken.END_OBJECT) && (!paramAnonymousInputStream.isClosed()))
        {
          String str = paramAnonymousInputStream.getCurrentName();
          paramAnonymousInputStream.nextToken();
          if ("guid".equals(str)) {
            localu.a(l.a(paramAnonymousInputStream));
          } else {
            paramAnonymousInputStream.skipChildren();
          }
        }
        paramAnonymousInputStream.close();
        return 1;
      }
    });
    locala.b();
    if (locala.d() == 503) {
      localu.a(locala.f());
    }
    return q.a(localu, r.b(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */