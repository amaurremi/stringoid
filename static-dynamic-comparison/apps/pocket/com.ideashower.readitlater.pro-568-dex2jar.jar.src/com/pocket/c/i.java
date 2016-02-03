package com.pocket.c;

import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class i
  extends f
{
  public i()
  {
    super(2);
  }
  
  protected com.ideashower.readitlater.objects.a k()
  {
    return new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/abt", true);
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        com.ideashower.readitlater.a.a.b((ObjectNode)l.a().readTree(paramAnonymousInputStream));
        return 1;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */