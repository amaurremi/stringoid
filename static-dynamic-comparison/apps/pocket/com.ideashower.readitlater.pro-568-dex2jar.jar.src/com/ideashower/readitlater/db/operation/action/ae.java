package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.util.l;
import com.pocket.n.e;
import com.pocket.n.g;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class ae
  extends c
{
  public ae(g paramg, UiContext paramUiContext)
  {
    super("recent_search", true, paramUiContext);
    this.a.put("search", paramg.b());
    if (paramg.a() != null)
    {
      this.a.put("scxt_key", paramg.a().a());
      this.a.put("scxt_val", paramg.a().b());
    }
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(j paramj)
  {
    paramj.a(this.a.get("search").asText(), l.a(this.a, "scxt_key", null), l.a(this.a, "scxt_val", null));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */