package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class n
  extends f
{
  protected ArrayNode a;
  private final int b;
  private final String h;
  private final ArrayList p = new ArrayList();
  
  public n(int paramInt, String paramString, g paramg)
  {
    super(2);
    if ((paramInt == 0) && (k.c(paramString))) {
      e.a("must supply an item identifier");
    }
    this.b = paramInt;
    this.h = paramString;
    a(paramg);
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/suggested_tags", true);
    if (this.b != 0)
    {
      locala.a("item_id", this.b);
      return locala;
    }
    locala.a("url", this.h);
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        if (n.this.a_()) {
          return 3;
        }
        if (!paramAnonymousBoolean) {
          return 2;
        }
        paramAnonymousInputStream = (ArrayNode)((ObjectNode)l.a().readTree(paramAnonymousInputStream)).get("suggested_tags");
        Iterator localIterator = paramAnonymousInputStream.iterator();
        while (localIterator.hasNext())
        {
          ObjectNode localObjectNode = (ObjectNode)localIterator.next();
          n.a(n.this).add(localObjectNode.get("tag").asText());
        }
        n.this.a = paramAnonymousInputStream;
        return 1;
      }
    };
  }
  
  public ArrayList n()
  {
    return this.p;
  }
  
  public ArrayNode o()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */