package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class ag
  extends s
{
  protected ag(ah paramah, o paramo)
  {
    super("shared_to", paramo, true, false, ah.a(paramah));
    a(paramah);
  }
  
  protected ag(ah paramah, String paramString)
  {
    super("shared_to", paramString, true, false, ah.a(paramah));
    a(paramah);
  }
  
  private void a(ah paramah)
  {
    if ((ah.b(paramah).size() == 0) && (ah.c(paramah).size() == 0)) {
      throw new RuntimeException("A share must have at least one receipient");
    }
    ArrayNode localArrayNode = l.c();
    Iterator localIterator = ah.b(paramah).iterator();
    Object localObject;
    ObjectNode localObjectNode;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localObjectNode = l.b();
      localObjectNode.put("email", (String)localObject);
      localArrayNode.add(localObjectNode);
    }
    localIterator = ah.c(paramah).iterator();
    while (localIterator.hasNext())
    {
      localObject = (f)localIterator.next();
      localObjectNode = l.b();
      localObjectNode.put("friend_id", ((f)localObject).b());
      localArrayNode.add(localObjectNode);
    }
    this.a.put("to", localArrayNode);
    if (!k.c(ah.d(paramah))) {
      this.a.put("comment", ah.d(paramah));
    }
    if (!k.c(ah.e(paramah))) {
      this.a.put("quote", ah.e(paramah));
    }
  }
  
  protected int a()
  {
    return 1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((ObjectNode)this.a.get("to").get(paramInt1)).put("local_friend_id", paramInt2);
  }
  
  public void a(j paramj)
  {
    paramj.a(this);
  }
  
  protected void h()
  {
    super.h();
    Iterator localIterator = k().iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = (JsonNode)localIterator.next();
      String str = l.a((ObjectNode)localJsonNode, "email", null);
      int i = l.a((ObjectNode)localJsonNode, "friend_id", 0);
      if ((str == null) && (i == 0)) {
        throw new RuntimeException("no friend indentifier provided");
      }
      if (!localJsonNode.has("local_friend_id")) {
        throw new RuntimeException("missing local friend id");
      }
    }
  }
  
  public ArrayNode k()
  {
    return (ArrayNode)this.a.get("to");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */