package com.scoreloop.client.android.core.server;

import org.json.JSONArray;
import org.json.JSONObject;

public class Response
{
  private final String a;
  private final Object b;
  private final int c;
  private final Integer d;
  private final boolean e;
  
  public Response(Object paramObject, String paramString, int paramInt, Integer paramInteger)
  {
    this.b = paramObject;
    this.a = paramString;
    this.c = paramInt;
    this.d = paramInteger;
    this.e = (paramObject instanceof JSONArray);
  }
  
  public Object a()
  {
    return this.b;
  }
  
  public Integer b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public JSONArray d()
  {
    return (JSONArray)this.b;
  }
  
  public JSONObject e()
  {
    return (JSONObject)this.b;
  }
  
  public int f()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */