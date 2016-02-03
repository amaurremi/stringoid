package com.scoreloop.client.android.core.controller;

import java.util.Collection;
import org.json.JSONArray;

class b
{
  private final String a;
  private final h b;
  private final Object c;
  
  public b(String paramString1, h paramh, String paramString2)
  {
    this.a = paramString1;
    this.b = paramh;
    this.c = paramString2;
  }
  
  public b(String paramString, h paramh, Collection<String> paramCollection)
  {
    this.a = paramString;
    this.b = paramh;
    this.c = new JSONArray(paramCollection);
  }
  
  public String a()
  {
    String str = this.b.getName();
    if (str == null) {
      return this.a;
    }
    return String.format("%s_%s", new Object[] { this.a, str });
  }
  
  public Object b()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */