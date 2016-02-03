package com.gau.go.gostaticsdk.c;

import android.content.ContentResolver;
import android.content.Context;
import com.gau.go.gostaticsdk.f.d;
import com.gau.go.launcherex.gowidget.weatherwidget.StaticDataContentProvider;

public class f
{
  private Context a;
  private a b;
  private boolean c = false;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private a b()
  {
    try
    {
      if (this.b == null) {
        this.b = new a(this.a);
      }
      a locala = this.b;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  public java.util.LinkedList a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 19	com/gau/go/gostaticsdk/c/f:a	Landroid/content/Context;
    //   6: invokevirtual 36	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: getstatic 41	com/gau/go/launcherex/gowidget/weatherwidget/StaticDataContentProvider:a	Landroid/net/Uri;
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 47	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +174 -> 195
    //   24: aload_1
    //   25: astore_2
    //   26: new 49	java/util/LinkedList
    //   29: dup
    //   30: invokespecial 50	java/util/LinkedList:<init>	()V
    //   33: astore 4
    //   35: aload_1
    //   36: astore_2
    //   37: aload_1
    //   38: iconst_m1
    //   39: invokeinterface 56 2 0
    //   44: pop
    //   45: aload_1
    //   46: astore_2
    //   47: aload 4
    //   49: astore_3
    //   50: aload_1
    //   51: invokeinterface 60 1 0
    //   56: ifeq +191 -> 247
    //   59: aload_1
    //   60: astore_2
    //   61: new 62	com/gau/go/gostaticsdk/a/a
    //   64: dup
    //   65: invokespecial 63	com/gau/go/gostaticsdk/a/a:<init>	()V
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: aload_1
    //   73: invokevirtual 66	com/gau/go/gostaticsdk/a/a:a	(Landroid/database/Cursor;)V
    //   76: aload_1
    //   77: astore_2
    //   78: aload 4
    //   80: aload_3
    //   81: invokevirtual 70	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   84: pop
    //   85: goto -40 -> 45
    //   88: astore_2
    //   89: aload 4
    //   91: astore_2
    //   92: ldc 72
    //   94: ldc 74
    //   96: invokestatic 79	com/gau/go/gostaticsdk/f/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokespecial 81	com/gau/go/gostaticsdk/c/f:b	()Lcom/gau/go/gostaticsdk/c/a;
    //   103: getstatic 84	com/gau/go/gostaticsdk/c/a:a	Ljava/lang/String;
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: aconst_null
    //   110: invokevirtual 87	com/gau/go/gostaticsdk/c/a:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +148 -> 263
    //   118: aload_3
    //   119: astore_2
    //   120: new 49	java/util/LinkedList
    //   123: dup
    //   124: invokespecial 50	java/util/LinkedList:<init>	()V
    //   127: astore 4
    //   129: aload_3
    //   130: astore_2
    //   131: aload_3
    //   132: iconst_m1
    //   133: invokeinterface 56 2 0
    //   138: pop
    //   139: aload_3
    //   140: astore_2
    //   141: aload 4
    //   143: astore_1
    //   144: aload_3
    //   145: invokeinterface 60 1 0
    //   150: ifeq +115 -> 265
    //   153: aload_3
    //   154: astore_2
    //   155: new 62	com/gau/go/gostaticsdk/a/a
    //   158: dup
    //   159: invokespecial 63	com/gau/go/gostaticsdk/a/a:<init>	()V
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: aload_1
    //   166: aload_3
    //   167: invokevirtual 66	com/gau/go/gostaticsdk/a/a:a	(Landroid/database/Cursor;)V
    //   170: aload_3
    //   171: astore_2
    //   172: aload 4
    //   174: aload_1
    //   175: invokevirtual 70	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   178: pop
    //   179: goto -40 -> 139
    //   182: astore_1
    //   183: aload_2
    //   184: ifnull +9 -> 193
    //   187: aload_2
    //   188: invokeinterface 90 1 0
    //   193: aload_1
    //   194: athrow
    //   195: aload_1
    //   196: ifnonnull +49 -> 245
    //   199: aload_1
    //   200: astore_2
    //   201: aload_0
    //   202: getfield 17	com/gau/go/gostaticsdk/c/f:c	Z
    //   205: ifeq +40 -> 245
    //   208: aload_1
    //   209: astore_2
    //   210: new 92	java/lang/IllegalArgumentException
    //   213: dup
    //   214: new 94	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   221: ldc 97
    //   223: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: getstatic 41	com/gau/go/launcherex/gowidget/weatherwidget/StaticDataContentProvider:a	Landroid/net/Uri;
    //   229: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 111	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   238: athrow
    //   239: astore_2
    //   240: aload_3
    //   241: astore_2
    //   242: goto -150 -> 92
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore_2
    //   249: aload_1
    //   250: ifnull +11 -> 261
    //   253: aload_1
    //   254: invokeinterface 90 1 0
    //   259: aload_3
    //   260: astore_2
    //   261: aload_2
    //   262: areturn
    //   263: aload_2
    //   264: astore_1
    //   265: aload_1
    //   266: astore_2
    //   267: aload_3
    //   268: ifnull -7 -> 261
    //   271: aload_3
    //   272: invokeinterface 90 1 0
    //   277: aload_1
    //   278: areturn
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: goto -99 -> 183
    //   285: astore_3
    //   286: aload_1
    //   287: astore_2
    //   288: aload_3
    //   289: astore_1
    //   290: goto -107 -> 183
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_3
    //   297: astore_2
    //   298: goto -206 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	f
    //   19	156	1	localObject1	Object
    //   182	72	1	localObject2	Object
    //   264	14	1	localObject3	Object
    //   279	8	1	localObject4	Object
    //   289	1	1	localObject5	Object
    //   293	1	1	localException1	Exception
    //   295	1	1	localObject6	Object
    //   25	53	2	localObject7	Object
    //   88	1	2	localException2	Exception
    //   91	119	2	localObject8	Object
    //   239	1	2	localException3	Exception
    //   241	57	2	localObject9	Object
    //   1	271	3	localObject10	Object
    //   285	12	3	localObject11	Object
    //   33	140	4	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   37	45	88	java/lang/Exception
    //   50	59	88	java/lang/Exception
    //   61	69	88	java/lang/Exception
    //   71	76	88	java/lang/Exception
    //   78	85	88	java/lang/Exception
    //   26	35	182	finally
    //   37	45	182	finally
    //   50	59	182	finally
    //   61	69	182	finally
    //   71	76	182	finally
    //   78	85	182	finally
    //   120	129	182	finally
    //   131	139	182	finally
    //   144	153	182	finally
    //   155	163	182	finally
    //   165	170	182	finally
    //   172	179	182	finally
    //   201	208	182	finally
    //   210	239	182	finally
    //   26	35	239	java/lang/Exception
    //   201	208	239	java/lang/Exception
    //   210	239	239	java/lang/Exception
    //   2	20	279	finally
    //   92	114	285	finally
    //   2	20	293	java/lang/Exception
  }
  
  public void a(com.gau.go.gostaticsdk.a.a parama)
  {
    try
    {
      if (this.a.getContentResolver().insert(StaticDataContentProvider.a, parama.b()) != null) {
        parama.a(true);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        d.a("StatisticsManager", "insertPostData Unknown URL");
        this.c = true;
      } while (b().a(a.a, parama.b()) == -1L);
      parama.a(true);
    }
  }
  
  public void b(com.gau.go.gostaticsdk.a.a parama)
  {
    parama = a.c + "=" + parama.b;
    try
    {
      this.a.getContentResolver().delete(StaticDataContentProvider.a, parama, null);
      return;
    }
    catch (Exception localException)
    {
      int i = b().a(a.a, parama, null);
      d.a("StatisticsManager", "delete " + i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */