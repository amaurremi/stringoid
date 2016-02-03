package com.ideashower.readitlater.db.operation.action;

import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;
import org.codehaus.jackson.node.ObjectNode;

public class y
  extends f
{
  public y(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, int paramInt)
  {
    super("search", null);
    this.a.put("state", paramReadOnlyItemQuery.K());
    if (paramReadOnlyItemQuery.h()) {
      this.a.put("shared", 1);
    }
    if ((paramReadOnlyItemQuery.C() != null) && (paramReadOnlyItemQuery.C().intValue() != 0)) {
      this.a.put("contentType", paramReadOnlyItemQuery.M());
    }
    ObjectNode localObjectNode;
    if (paramReadOnlyItemQuery.u() != null)
    {
      localObjectNode = this.a;
      if (!paramReadOnlyItemQuery.u().booleanValue()) {
        break label186;
      }
    }
    label186:
    for (String str = "1";; str = "0")
    {
      localObjectNode.put("favorite", str);
      this.a.put("sort", paramReadOnlyItemQuery.L());
      if (paramReadOnlyItemQuery.A() != null) {
        this.a.put("tag", paramReadOnlyItemQuery.A());
      }
      if (paramReadOnlyItemQuery.x() != null)
      {
        str = paramReadOnlyItemQuery.x();
        paramReadOnlyItemQuery = str;
        if (str.length() > 100) {
          paramReadOnlyItemQuery = str.substring(0, 100);
        }
        this.a.put("search", paramReadOnlyItemQuery);
      }
      this.a.put("resultsCnt", paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */