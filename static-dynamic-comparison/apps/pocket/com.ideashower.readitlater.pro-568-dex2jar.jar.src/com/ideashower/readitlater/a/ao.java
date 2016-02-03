package com.ideashower.readitlater.a;

import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.n;
import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

class ao
  extends m
{
  private final String b;
  private boolean c;
  
  public ao(an paraman, String paramString)
  {
    this.b = paramString;
  }
  
  protected void a()
  {
    if (q.d().a() == null) {
      throw new NullPointerException("guid missing");
    }
    a locala = new a("https://getpocket.com/v3/send", true);
    ArrayNode localArrayNode = l.c();
    String str = this.b;
    if (an.a(this.a) != null) {}
    for (UiContext localUiContext = UiContext.a(an.a(this.a));; localUiContext = null)
    {
      localArrayNode.add(l.a(new n(str, true, localUiContext).f()));
      locala.a("actions", localArrayNode.toString());
      locala.a(new b()
      {
        public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
        {
          if (ao.this.a_()) {
            return 3;
          }
          if (((ArrayNode)((ObjectNode)l.a().readTree(l.d().createJsonParser(paramAnonymousInputStream))).get("action_results")).get(0).asBoolean()) {
            return 1;
          }
          return 2;
        }
      });
      locala.b();
      if (locala.c() != 1) {
        break;
      }
      this.c = true;
      return;
    }
    this.c = false;
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if (paramBoolean) {
      am.e();
    }
    for (;;)
    {
      an.a(this.a, this.c, null);
      return;
      am.a(g.c(), false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */