package com.scoreloop.client.android.core.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchSpec
{
  private final List<b> a = new ArrayList();
  private final int b = 25;
  private final i c;
  
  public SearchSpec()
  {
    this.c = null;
  }
  
  public SearchSpec(i parami)
  {
    this.c = parami;
  }
  
  public JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("per_page", this.b);
    if (this.c != null)
    {
      localJSONObject1.put("order_by", this.c.a());
      localJSONObject1.put("order_as", this.c.b());
    }
    if (this.a != null)
    {
      localJSONObject2 = new JSONObject();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        localJSONObject2.put(localb.a(), localb.b());
      }
      localJSONObject1.put("conditions", localJSONObject2);
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("search", localJSONObject1);
    return localJSONObject2;
  }
  
  public void a(b paramb)
  {
    this.a.add(paramb);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/SearchSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */