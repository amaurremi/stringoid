package com.venticake.retrica.engine.a;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a b = null;
  private static Context c = null;
  private List<b> a = null;
  
  protected a(Context paramContext) {}
  
  public static Context a()
  {
    return c;
  }
  
  public static void a(Context paramContext)
  {
    c = paramContext;
  }
  
  public static a b()
  {
    if (b == null)
    {
      if (c == null) {
        throw new Exception("YOU MUST set Default Context!!!");
      }
      b(c);
    }
    return b;
  }
  
  public static void b(Context paramContext)
  {
    if (b != null) {
      return;
    }
    c = paramContext;
    b = new a(paramContext);
  }
  
  /* Error */
  private List<b> c(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 48	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_1
    //   5: aload_1
    //   6: ldc 50
    //   8: invokevirtual 56	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_2
    //   12: new 58	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   19: astore_1
    //   20: new 61	java/io/BufferedReader
    //   23: dup
    //   24: new 63	java/io/InputStreamReader
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 66	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   32: invokespecial 69	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 73	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnonnull +23 -> 65
    //   45: aload_2
    //   46: invokevirtual 76	java/io/BufferedReader:close	()V
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 83	com/venticake/retrica/engine/a/a:d	(Ljava/lang/String;)Ljava/util/List;
    //   57: areturn
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   63: aconst_null
    //   64: areturn
    //   65: aload_1
    //   66: aload_3
    //   67: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -35 -> 36
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	a
    //   0	81	1	paramContext	Context
    //   11	35	2	localObject	Object
    //   40	27	3	str	String
    // Exception table:
    //   from	to	target	type
    //   5	12	58	java/io/IOException
    //   20	36	74	java/io/IOException
    //   36	41	74	java/io/IOException
    //   45	49	74	java/io/IOException
    //   65	71	74	java/io/IOException
  }
  
  private List<b> d(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramString = new JSONArray(paramString.toString());
        localArrayList = new ArrayList(paramString.length());
        i = 0;
        if (i >= paramString.length()) {
          return localArrayList;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      try
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList.add(new b(localJSONObject));
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      i += 1;
    }
  }
  
  public b a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.a.size() - 1)) {
      return null;
    }
    return (b)this.a.get(paramInt);
  }
  
  public b a(g paramg)
  {
    Iterator localIterator = this.a.iterator();
    b localb;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localb = (b)localIterator.next();
    } while (!localb.a(paramg));
    return localb;
  }
  
  public g a(int paramInt1, int paramInt2)
  {
    b localb = a(paramInt1);
    if (localb == null) {
      return null;
    }
    return localb.a(paramInt2);
  }
  
  public g a(String paramString)
  {
    g localg;
    do
    {
      Iterator localIterator1 = this.a.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          return null;
        }
        localIterator2 = ((b)localIterator1.next()).iterator();
      }
      localg = (g)localIterator2.next();
    } while (!paramString.equals(localg.v()));
    return localg;
  }
  
  public int b(String paramString)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= this.a.size()) {}
      label79:
      for (;;)
      {
        j = -1;
        return j;
        b localb = (b)this.a.get(i);
        if (!localb.c(paramString)) {
          break;
        }
        i = j;
        for (;;)
        {
          if (i >= localb.size()) {
            break label79;
          }
          j = i;
          if (localb.a(i).v().equals(paramString)) {
            break;
          }
          i += 1;
        }
      }
      i += 1;
    }
  }
  
  public g b(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      b localb = (b)localIterator.next();
      if (paramInt < localb.size()) {
        return localb.a(paramInt);
      }
      paramInt -= localb.size();
    }
  }
  
  public boolean b(g paramg)
  {
    if (com.venticake.retrica.setting.a.a().u()) {}
    do
    {
      do
      {
        return false;
        paramg = a(paramg);
      } while (paramg == null);
      paramg = paramg.b();
    } while ((paramg == null) || (!paramg.startsWith("P")));
    return true;
  }
  
  public int c(String paramString)
  {
    int i = 0;
    for (;;)
    {
      int j;
      if (i >= this.a.size()) {
        j = -1;
      }
      do
      {
        return j;
        j = i;
      } while (((b)this.a.get(i)).c(paramString));
      i += 1;
    }
  }
  
  public List<b> c()
  {
    return this.a;
  }
  
  public void c(g paramg)
  {
    Log.d("retrica", "clearMemory except: " + paramg);
    Iterator localIterator1 = c().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      Iterator localIterator2 = ((b)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        g localg = (g)localIterator2.next();
        if (localg != paramg)
        {
          localg.b();
          localg.h();
        }
      }
    }
  }
  
  public int d()
  {
    return this.a.size();
  }
  
  public int e()
  {
    Iterator localIterator = this.a.iterator();
    for (int i = 0;; i = ((b)localIterator.next()).size() + i) {
      if (!localIterator.hasNext()) {
        return i;
      }
    }
  }
  
  public g f()
  {
    return b(new Random().nextInt(e() - 1));
  }
  
  public g g()
  {
    if (this.a.size() < 1) {
      return null;
    }
    b localb = (b)this.a.get(0);
    if (localb.size() < 1) {
      return null;
    }
    return localb.a(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */