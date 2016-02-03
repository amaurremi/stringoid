package com.ideashower.readitlater.a.a;

import android.content.Context;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.e;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

class b
  extends com.ideashower.readitlater.g.g
{
  private final int a;
  private final ObjectMapper b = com.ideashower.readitlater.util.l.a();
  private ObjectNode c;
  private ObjectNode d;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  private int a(InputStream paramInputStream)
  {
    paramInputStream = com.ideashower.readitlater.util.l.d().createJsonParser(paramInputStream);
    paramInputStream.nextToken();
    String str;
    while ((paramInputStream.nextToken() != JsonToken.END_OBJECT) && (!paramInputStream.isClosed()))
    {
      if (a_()) {
        return 3;
      }
      str = paramInputStream.getCurrentName();
      paramInputStream.nextToken();
      if (!"status".equals(str)) {
        if ("list".equals(str)) {
          this.c = ((ObjectNode)this.b.readTree(paramInputStream));
        } else if ("aliases".equals(str)) {
          this.d = ((ObjectNode)this.b.readTree(paramInputStream));
        }
      }
    }
    paramInputStream.close();
    if (a_()) {
      return 3;
    }
    paramInputStream = this.c.getElements();
    while (paramInputStream.hasNext())
    {
      str = ((JsonNode)paramInputStream.next()).get("host").getTextValue();
      this.d.put(str, str);
    }
    return 1;
  }
  
  private boolean k()
  {
    try
    {
      File localFile = com.pocket.m.d.d.a(new File(com.ideashower.readitlater.a.g.c().getFilesDir(), "subscriptionTemplates.json").getAbsolutePath());
      if (localFile == null) {
        return false;
      }
      this.b.writeValue(localFile, this.c);
      localFile = com.pocket.m.d.d.a(new File(com.ideashower.readitlater.a.g.c().getFilesDir(), "subscriptionAliases.json").getAbsolutePath());
      if (localFile != null)
      {
        this.b.writeValue(localFile, this.d);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      e.a(localThrowable);
    }
    return false;
  }
  
  protected void a()
  {
    boolean bool = false;
    ??? = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/loginlist", false);
    ((com.ideashower.readitlater.objects.a)???).a("hash", "1");
    ((com.ideashower.readitlater.objects.a)???).a(new com.ideashower.readitlater.objects.b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        return b.a(b.this, paramAnonymousInputStream);
      }
    });
    ((com.ideashower.readitlater.objects.a)???).b();
    switch (((com.ideashower.readitlater.objects.a)???).c())
    {
    }
    for (;;)
    {
      if (bool)
      {
        a.b(new d(this.c, this.d, a.f()));
        if (this.a != -1) {
          i.b().a(com.ideashower.readitlater.h.a.bo, this.a).a();
        }
      }
      synchronized (a.h())
      {
        do
        {
          a.b(null);
          return;
          bool = k();
          break;
        } while (a.i() == null);
        a.b(a.i());
        a.a(null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */