package com.ideashower.readitlater.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class g
{
  private final int a;
  private final int b;
  private final int c;
  private final i d;
  private final i e;
  private final h f;
  private final ColorStateList g;
  
  public g(ObjectNode paramObjectNode)
  {
    this.a = paramObjectNode.get("group_id").asInt();
    this.b = a(paramObjectNode, "color");
    this.d = new i(this, (ObjectNode)paramObjectNode.get("name"), null);
    Object localObject = paramObjectNode.get("icons");
    if (localObject != null)
    {
      this.f = new h(this, (ObjectNode)localObject, null);
      if (!paramObjectNode.has("dark_color")) {
        break label233;
      }
    }
    label233:
    for (this.c = a(paramObjectNode, "dark_color");; this.c = this.b)
    {
      localObject = m.d;
      int[] arrayOfInt1 = m.a;
      int[] arrayOfInt2 = m.c;
      int i = this.c;
      int j = this.c;
      int k = this.b;
      int m = this.b;
      this.g = new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2, new int[0] }, new int[] { i, j, k, m });
      if (paramObjectNode.get("desc") == null) {
        break label244;
      }
      this.e = new i(this, (ObjectNode)paramObjectNode.get("desc"), null);
      return;
      this.f = null;
      break;
    }
    label244:
    this.e = null;
  }
  
  private static int a(ObjectNode paramObjectNode, String paramString)
  {
    paramObjectNode = (ObjectNode)paramObjectNode.get(paramString);
    return Color.argb(l.a(paramObjectNode, "a", 255), paramObjectNode.get("r").asInt(), paramObjectNode.get("g").asInt(), paramObjectNode.get("b").asInt());
  }
  
  private static int b(String paramString)
  {
    int i = 640;
    if (paramString.equals("1x")) {
      i = 160;
    }
    do
    {
      return i;
      if (paramString.equals("1_33x")) {
        return 213;
      }
      if (paramString.equals("1_5x")) {
        return 240;
      }
      if (paramString.equals("2x")) {
        return 320;
      }
      if (paramString.equals("3x")) {
        return 480;
      }
    } while (paramString.equals("4x"));
    e.a("unexpected value " + paramString);
    return 640;
  }
  
  private static String b(float paramFloat, ObjectNode paramObjectNode)
  {
    if (paramFloat <= 1.0F) {
      return "1x";
    }
    if ((paramFloat <= 1.34D) && (paramObjectNode.has("1_33x"))) {
      return "1_33x";
    }
    if (paramFloat <= 1.5D) {
      return "1_5x";
    }
    if (paramFloat <= 2.0F) {
      return "2x";
    }
    if (paramFloat <= 3.0F) {
      return "3x";
    }
    return "4x";
  }
  
  public int a()
  {
    return this.a;
  }
  
  public BitmapDrawable a(Context paramContext, j paramj)
  {
    if (this.f != null) {
      return h.a(this.f, paramContext, paramj);
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    i.a(this.d, paramContext);
    h.a(this.f, paramContext, null);
  }
  
  public ColorStateList b()
  {
    return this.g;
  }
  
  public String b(Context paramContext)
  {
    return i.a(this.d, paramContext);
  }
  
  public String c(Context paramContext)
  {
    if (this.e != null) {
      return i.a(this.e, paramContext);
    }
    return null;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.f != null) && (h.a(this.f) != null))
    {
      Iterator localIterator = h.a(this.f).getElements();
      while (localIterator.hasNext()) {
        localArrayList.add(((JsonNode)localIterator.next()).asText());
      }
    }
    return localArrayList;
  }
  
  public boolean d()
  {
    return this.f != null;
  }
  
  public String toString()
  {
    return i.a(this.d, com.ideashower.readitlater.a.g.c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */