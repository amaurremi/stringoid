package com.ideashower.readitlater.db.operation.action;

import org.codehaus.jackson.node.ObjectNode;

public class g
  extends f
{
  public g(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super("pv_wt", null);
    this.a.put("view", "mobile");
    this.a.put("type_id", paramInt);
    this.a.put("section", paramString1);
    this.a.put("page", paramString2);
    this.a.put("action_identifier", paramString3);
    this.a.put("page_params", paramString4);
    this.a.put("source", paramString5);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramString4, 0, 0, 0, 0);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super("pv", null);
    this.a.put("section", paramString1);
    this.a.put("view", paramString2);
    this.a.put("version", paramString4);
    this.a.put("event", paramString3);
    if (paramInt1 != 0)
    {
      this.a.put("event_type", paramInt1);
      this.a.put("event_id_x", paramInt2);
      this.a.put("event_id_y", paramInt3);
      this.a.put("event_id_z", paramInt4);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */