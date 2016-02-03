package com.pocket.c;

import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.y;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.File;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class ai
  extends f
{
  private final File a;
  
  public ai(File paramFile)
  {
    super(1);
    this.a = paramFile;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt != 3) {
      e.a(paramInt, this.d, this.c, this.f, true);
    }
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/setAvatar", true);
    locala.a("image", this.a);
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        Object localObject = l.d().createJsonParser(paramAnonymousInputStream);
        ((JsonParser)localObject).nextToken();
        int i = 0;
        paramAnonymousInputStream = null;
        while ((((JsonParser)localObject).nextToken() != JsonToken.END_OBJECT) && (!((JsonParser)localObject).isClosed()))
        {
          String str = ((JsonParser)localObject).getCurrentName();
          ((JsonParser)localObject).nextToken();
          if ("status".equals(str)) {
            i = ((JsonParser)localObject).getIntValue();
          } else if ("url".equals(str)) {
            paramAnonymousInputStream = l.a((JsonParser)localObject);
          } else {
            ((JsonParser)localObject).skipChildren();
          }
        }
        ((JsonParser)localObject).close();
        if ((i == 1) && (paramAnonymousInputStream != null))
        {
          localObject = o.c().e();
          if (new y(((com.ideashower.readitlater.db.operation.f)localObject).b(), ((com.ideashower.readitlater.db.operation.f)localObject).c(), paramAnonymousInputStream, ((com.ideashower.readitlater.db.operation.f)localObject).d()).d() == 4) {
            return 1;
          }
          return 2;
        }
        return 2;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */