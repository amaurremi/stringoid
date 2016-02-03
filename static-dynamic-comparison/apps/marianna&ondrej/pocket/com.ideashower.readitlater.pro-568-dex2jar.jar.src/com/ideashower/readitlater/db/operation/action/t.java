package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public abstract class t
  extends s
{
  protected ArrayList e;
  
  public t(String paramString1, String paramString2, ArrayList paramArrayList, UiContext paramUiContext)
  {
    super(paramString1, paramString2, true, false, paramUiContext);
    a(paramArrayList);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    this.e = paramArrayList;
    if (paramArrayList == null) {
      return;
    }
    ArrayNode localArrayNode = l.c();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayNode.add((String)paramArrayList.next());
    }
    this.a.put("tags", localArrayNode);
  }
  
  public ArrayNode k()
  {
    return l.b(this.a, "tags");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */