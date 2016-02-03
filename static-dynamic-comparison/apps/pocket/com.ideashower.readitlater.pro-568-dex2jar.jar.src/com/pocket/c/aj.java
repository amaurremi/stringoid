package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class aj
  extends f
{
  private final String a;
  private final String b;
  private String h;
  
  public aj(String paramString1, String paramString2)
  {
    super(2);
    this.a = paramString1;
    this.b = paramString2;
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/shorten", true);
    locala.a("url", this.a);
    locala.a("service", this.b);
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = l.d().createJsonParser(paramAnonymousInputStream);
        paramAnonymousInputStream.nextToken();
        while ((paramAnonymousInputStream.nextToken() != JsonToken.END_OBJECT) && (!paramAnonymousInputStream.isClosed()))
        {
          String str = paramAnonymousInputStream.getCurrentName();
          paramAnonymousInputStream.nextToken();
          if ("shortUrl".equals(str)) {
            aj.a(aj.this, l.a(paramAnonymousInputStream));
          } else {
            paramAnonymousInputStream.skipChildren();
          }
        }
        paramAnonymousInputStream.close();
        return 1;
      }
    };
  }
  
  public String n()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */