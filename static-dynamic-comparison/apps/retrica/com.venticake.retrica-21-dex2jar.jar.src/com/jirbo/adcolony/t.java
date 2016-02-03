package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class t
{
  d a;
  ArrayList<t.a> b = new ArrayList();
  HashMap<Integer, Integer> c = new HashMap();
  HashMap<String, Integer> d = new HashMap();
  boolean e = false;
  boolean f = false;
  
  t(d paramd)
  {
    this.a = paramd;
  }
  
  int a(int paramInt)
  {
    return a(paramInt, 86400.0D);
  }
  
  int a(int paramInt, double paramDouble)
  {
    try
    {
      double d1 = ab.c();
      int i = 0;
      int j = this.b.size() - 1;
      if (j >= 0)
      {
        double d2 = ((t.a)this.b.get(j)).d;
        if (d2 >= d1 - paramDouble) {}
      }
      else
      {
        return i;
      }
      int k = ((t.a)this.b.get(j)).b;
      if (paramInt == k) {
        i += 1;
      }
      for (;;)
      {
        j -= 1;
        break;
      }
    }
    finally {}
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 40	com/jirbo/adcolony/t:a	Lcom/jirbo/adcolony/d;
    //   8: getfield 74	com/jirbo/adcolony/d:e	Lcom/jirbo/adcolony/v;
    //   11: getfield 80	com/jirbo/adcolony/v:i	Ljava/lang/String;
    //   14: astore 6
    //   16: aload_0
    //   17: getfield 27	com/jirbo/adcolony/t:b	Ljava/util/ArrayList;
    //   20: invokevirtual 56	java/util/ArrayList:size	()I
    //   23: iconst_1
    //   24: isub
    //   25: istore 4
    //   27: iconst_0
    //   28: istore_3
    //   29: iload 4
    //   31: iflt +37 -> 68
    //   34: aload_0
    //   35: getfield 27	com/jirbo/adcolony/t:b	Ljava/util/ArrayList;
    //   38: iload 4
    //   40: invokevirtual 60	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   43: ifnull +25 -> 68
    //   46: aload_0
    //   47: getfield 27	com/jirbo/adcolony/t:b	Ljava/util/ArrayList;
    //   50: iload 4
    //   52: invokevirtual 60	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   55: checkcast 62	com/jirbo/adcolony/t$a
    //   58: getfield 82	com/jirbo/adcolony/t$a:c	Ljava/lang/String;
    //   61: astore 7
    //   63: aload 7
    //   65: ifnonnull +7 -> 72
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_2
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 27	com/jirbo/adcolony/t:b	Ljava/util/ArrayList;
    //   76: iload 4
    //   78: invokevirtual 60	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   81: checkcast 62	com/jirbo/adcolony/t$a
    //   84: getfield 82	com/jirbo/adcolony/t$a:c	Ljava/lang/String;
    //   87: aload 6
    //   89: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +46 -> 138
    //   95: iconst_1
    //   96: istore_3
    //   97: aload_0
    //   98: getfield 27	com/jirbo/adcolony/t:b	Ljava/util/ArrayList;
    //   101: iload 4
    //   103: invokevirtual 60	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   106: checkcast 62	com/jirbo/adcolony/t$a
    //   109: getfield 90	com/jirbo/adcolony/t$a:a	Ljava/lang/String;
    //   112: aload_1
    //   113: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: istore 5
    //   118: iload 5
    //   120: ifeq +22 -> 142
    //   123: iload_2
    //   124: iconst_1
    //   125: iadd
    //   126: istore_2
    //   127: iconst_1
    //   128: istore_3
    //   129: iload 4
    //   131: iconst_1
    //   132: isub
    //   133: istore 4
    //   135: goto -106 -> 29
    //   138: iload_3
    //   139: ifne -71 -> 68
    //   142: goto -13 -> 129
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	t
    //   0	150	1	paramString	String
    //   1	126	2	i	int
    //   28	111	3	j	int
    //   25	109	4	k	int
    //   116	3	5	bool	boolean
    //   14	74	6	str1	String
    //   61	3	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	27	145	finally
    //   34	63	145	finally
    //   72	95	145	finally
    //   97	118	145	finally
  }
  
  int a(String paramString, double paramDouble)
  {
    try
    {
      double d1 = ab.c();
      int i = 0;
      int j = this.b.size() - 1;
      if (j >= 0)
      {
        double d2 = ((t.a)this.b.get(j)).d;
        if (d2 >= d1 - paramDouble) {}
      }
      else
      {
        return i;
      }
      boolean bool = paramString.equals(((t.a)this.b.get(j)).a);
      if (bool) {
        i += 1;
      }
      for (;;)
      {
        j -= 1;
        break;
      }
    }
    finally {}
  }
  
  void a()
  {
    b();
    this.e = false;
  }
  
  void a(String paramString, int paramInt)
  {
    l.a.b("Adding play event to play history");
    this.e = true;
    this.b.add(new t.a(this.a.e.i, ab.c(), paramString, paramInt));
    paramString = (Integer)this.c.get(Integer.valueOf(paramInt));
    l.a.a("Got play count of ").a(paramString).b(" for this ad");
    if (paramString == null)
    {
      this.c.put(Integer.valueOf(paramInt), Integer.valueOf(1));
      return;
    }
    this.c.put(Integer.valueOf(paramInt), Integer.valueOf(paramString.intValue() + 1));
  }
  
  int b(int paramInt)
  {
    return a(paramInt, 604800.0D);
  }
  
  int b(String paramString)
  {
    return a(paramString, 86400.0D);
  }
  
  void b()
  {
    int j = 0;
    a.r = true;
    if ((this.f) && (((t.a)this.b.get(this.b.size() - 1)).c == this.a.e.i)) {}
    do
    {
      return;
      localg = k.b(new f("play_history_info.txt"));
    } while (localg == null);
    this.b.clear();
    this.d = new HashMap();
    Object localObject1 = localg.b("reward_credit");
    int i = 0;
    Object localObject2;
    int k;
    while (i < ((ADCData.g)localObject1).o())
    {
      localObject2 = ((ADCData.g)localObject1).a(i);
      k = ((ADCData.g)localObject1).g((String)localObject2);
      this.d.put(localObject2, Integer.valueOf(k));
      i += 1;
    }
    localObject1 = localg.c("play_events");
    i = 0;
    while (i < ((ADCData.c)localObject1).i())
    {
      localObject2 = ((ADCData.c)localObject1).b(i);
      double d1 = ((ADCData.g)localObject2).f("timestamp");
      String str = ((ADCData.g)localObject2).e("zone_id");
      k = ((ADCData.g)localObject2).g("ad_id");
      if ((d1 != 0.0D) && (str != null) && (k != 0)) {
        this.b.add(new t.a(null, d1, str, k));
      }
      i += 1;
    }
    this.c = new HashMap();
    ADCData.g localg = localg.b("play_counts");
    i = j;
    while (i < localg.o())
    {
      j = Integer.parseInt(localg.a(i));
      k = localg.g("" + j);
      this.c.put(Integer.valueOf(j), Integer.valueOf(k));
      i += 1;
    }
    this.f = true;
  }
  
  void b(String paramString, int paramInt)
  {
    this.d.put(paramString, Integer.valueOf(paramInt));
    this.e = true;
  }
  
  int c(int paramInt)
  {
    return a(paramInt, 2628000.0D);
  }
  
  int c(String paramString)
  {
    paramString = (Integer)this.d.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  void c()
  {
    Object localObject1 = new ADCData.c();
    ADCData.g localg1 = new ADCData.g();
    ADCData.g localg2 = new ADCData.g();
    double d1 = ab.c();
    int i = this.b.size() - 1;
    Object localObject2;
    for (;;)
    {
      if (i >= 0)
      {
        localObject2 = (t.a)this.b.get(i);
        if (((t.a)localObject2).d >= d1 - 2678400.0D) {}
      }
      else
      {
        localg1.a("play_events", (ADCData.i)localObject1);
        localObject1 = this.c.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          int j = ((Integer)this.c.get(Integer.valueOf(i))).intValue();
          localg2.b("" + i, j);
        }
      }
      ADCData.g localg3 = new ADCData.g();
      localg3.b("zone_id", ((t.a)localObject2).a);
      localg3.b("ad_id", ((t.a)localObject2).b);
      localg3.b("timestamp", ((t.a)localObject2).d);
      ((ADCData.c)localObject1).a(localg3);
      i -= 1;
    }
    localg1.a("play_counts", localg2);
    localg2 = new ADCData.g();
    if (this.d.size() > 0)
    {
      localObject1 = this.d.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localg2.b((String)localObject2, ((Integer)this.d.get(localObject2)).intValue());
      }
    }
    localg1.a("reward_credit", localg2);
    l.a.a("Saving play history");
    k.a(new f("play_history_info.txt"), localg1);
  }
  
  int d(int paramInt)
  {
    return a(paramInt, 1.5768E7D);
  }
  
  void d()
  {
    if (this.e)
    {
      this.e = false;
      c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */