package com.venticake.retrica.engine.a;

import android.annotation.SuppressLint;
import java.util.AbstractList;
import java.util.ArrayList;

public class b
  extends AbstractList<g>
{
  private ArrayList<g> a;
  private String b;
  private String c;
  
  /* Error */
  public b(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 18	java/util/AbstractList:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 20	com/venticake/retrica/engine/a/b:a	Ljava/util/ArrayList;
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 22
    //   13: invokevirtual 28	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokevirtual 31	com/venticake/retrica/engine/a/b:a	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_1
    //   21: ldc 33
    //   23: invokevirtual 28	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 35	com/venticake/retrica/engine/a/b:b	(Ljava/lang/String;)V
    //   29: new 37	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 38	java/util/ArrayList:<init>	()V
    //   36: astore_3
    //   37: new 40	org/json/JSONArray
    //   40: dup
    //   41: aload_1
    //   42: ldc 42
    //   44: invokevirtual 28	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: invokespecial 44	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: iconst_0
    //   52: istore_2
    //   53: iload_2
    //   54: aload_1
    //   55: invokevirtual 48	org/json/JSONArray:length	()I
    //   58: if_icmplt +28 -> 86
    //   61: aload_0
    //   62: aload_3
    //   63: putfield 20	com/venticake/retrica/engine/a/b:a	Ljava/util/ArrayList;
    //   66: return
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 51	org/json/JSONException:printStackTrace	()V
    //   72: return
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 51	org/json/JSONException:printStackTrace	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: invokevirtual 35	com/venticake/retrica/engine/a/b:b	(Ljava/lang/String;)V
    //   83: goto -54 -> 29
    //   86: aload_3
    //   87: new 53	com/venticake/retrica/engine/a/g
    //   90: dup
    //   91: aload_1
    //   92: iload_2
    //   93: invokevirtual 57	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   96: invokespecial 59	com/venticake/retrica/engine/a/g:<init>	(Lorg/json/JSONObject;)V
    //   99: invokevirtual 63	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   102: pop
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -54 -> 53
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 51	org/json/JSONException:printStackTrace	()V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 20	com/venticake/retrica/engine/a/b:a	Ljava/util/ArrayList;
    //   120: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	b
    //   0	121	1	paramJSONObject	org.json.JSONObject
    //   52	55	2	i	int
    //   36	27	3	localArrayList	ArrayList
    //   73	14	3	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   9	19	67	org/json/JSONException
    //   19	29	73	org/json/JSONException
    //   37	51	110	org/json/JSONException
    //   53	66	110	org/json/JSONException
    //   86	103	110	org/json/JSONException
  }
  
  public g a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.a.size() - 1)) {
      return null;
    }
    return (g)this.a.get(paramInt);
  }
  
  @SuppressLint({"DefaultLocale"})
  public String a()
  {
    return "pk_".concat(this.b.toLowerCase());
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(g paramg)
  {
    int i = 0;
    for (;;)
    {
      if (i >= size()) {
        return false;
      }
      if (paramg == a(i)) {
        return true;
      }
      i += 1;
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean c(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= size()) {
        return false;
      }
      if (a(i).v().equals(paramString)) {
        return true;
      }
      i += 1;
    }
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public String toString()
  {
    return "[" + this.b + "] " + this.c + " : " + size() + " lenses";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */