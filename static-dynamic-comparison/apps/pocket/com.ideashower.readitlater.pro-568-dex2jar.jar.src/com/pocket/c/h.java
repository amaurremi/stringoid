package com.pocket.c;

import com.ideashower.readitlater.db.operation.p;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.objects.b;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class h
  extends f
{
  private final boolean a;
  private final long b;
  private final int h;
  private final int p;
  private final int q;
  
  public h(int paramInt)
  {
    this(true, paramInt, 0L, 0, 0, 0);
  }
  
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    this(false, paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
  }
  
  private h(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.a = paramBoolean;
    this.b = paramLong;
    this.h = paramInt2;
    this.p = paramInt3;
    this.q = paramInt4;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool, this.q);
      return;
    }
  }
  
  protected com.ideashower.readitlater.objects.a k()
  {
    com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/fetch", true);
    locala.a("shares");
    if (!this.a)
    {
      locala.a("updatedBefore", this.b);
      locala.a("offset", this.h);
      locala.a("count", this.p);
      locala.a("chunk", this.q);
    }
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        if (h.this.a_()) {
          return 3;
        }
        if (!paramAnonymousBoolean) {
          return 2;
        }
        if (h.a(h.this))
        {
          paramAnonymousInputStream = (ObjectNode)com.ideashower.readitlater.util.l.a().readTree(paramAnonymousInputStream);
          ObjectNode localObjectNode = (ObjectNode)paramAnonymousInputStream.get("passthrough");
          i.b().a(com.ideashower.readitlater.h.a.aH, localObjectNode.get("firstChunkSize").asInt()).a(com.ideashower.readitlater.h.a.aJ, localObjectNode.get("fetchChunkSize").asInt()).a(com.ideashower.readitlater.h.a.aL, com.ideashower.readitlater.util.l.a(paramAnonymousInputStream, "total", 0)).a(com.ideashower.readitlater.h.a.aN, paramAnonymousInputStream.get("since").asInt()).a(com.ideashower.readitlater.h.a.ac, paramAnonymousInputStream.get("since").asInt()).a();
          i.b().a(com.ideashower.readitlater.h.a.aO, false).a();
        }
        for (paramAnonymousInputStream = new p(com.ideashower.readitlater.util.l.d().createJsonParser(paramAnonymousInputStream.toString()));; paramAnonymousInputStream = new p(paramAnonymousInputStream)) {
          switch (paramAnonymousInputStream.d())
          {
          default: 
            return 2;
          }
        }
        return 1;
        return 3;
      }
    };
  }
  
  protected void s()
  {
    e.a(false, this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */