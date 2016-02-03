package com.gau.go.launcherex.gowidget.weather.d;

import java.io.File;

public class e
{
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      boolean bool = paramString.mkdir();
      return bool;
    }
    catch (Exception paramString) {}
    return true;
    return false;
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: ifnonnull +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: new 30	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 35	java/io/FileInputStream:available	()I
    //   29: istore_1
    //   30: aload 6
    //   32: astore_0
    //   33: iload_1
    //   34: ifeq +95 -> 129
    //   37: iload_1
    //   38: newarray <illegal type>
    //   40: astore_0
    //   41: iconst_0
    //   42: istore_1
    //   43: aload_3
    //   44: invokevirtual 38	java/io/FileInputStream:read	()I
    //   47: istore_2
    //   48: iload_2
    //   49: iconst_m1
    //   50: if_icmpeq +79 -> 129
    //   53: aload_0
    //   54: iload_1
    //   55: iload_2
    //   56: i2b
    //   57: bastore
    //   58: iload_1
    //   59: iconst_1
    //   60: iadd
    //   61: istore_1
    //   62: goto -19 -> 43
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +7 -> 76
    //   72: aload_3
    //   73: invokevirtual 42	java/io/FileInputStream:close	()V
    //   76: aload_0
    //   77: athrow
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull -69 -> 13
    //   85: aload_3
    //   86: invokevirtual 42	java/io/FileInputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aload 5
    //   94: astore_3
    //   95: aload_0
    //   96: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   99: aload_3
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull -92 -> 13
    //   108: aload_3
    //   109: invokevirtual 42	java/io/FileInputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload 5
    //   117: astore_3
    //   118: goto -23 -> 95
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   126: goto -50 -> 76
    //   129: aload_0
    //   130: astore 4
    //   132: aload_3
    //   133: ifnull -120 -> 13
    //   136: aload_3
    //   137: invokevirtual 42	java/io/FileInputStream:close	()V
    //   140: aload_0
    //   141: areturn
    //   142: astore 4
    //   144: aload_0
    //   145: astore_3
    //   146: aload 4
    //   148: astore_0
    //   149: goto -54 -> 95
    //   152: astore_0
    //   153: goto -85 -> 68
    //   156: astore_0
    //   157: goto -53 -> 104
    //   160: astore_0
    //   161: goto -80 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   29	33	1	i	int
    //   47	9	2	j	int
    //   24	94	3	localObject1	Object
    //   121	16	3	localException1	Exception
    //   145	1	3	str	String
    //   7	124	4	localObject2	Object
    //   142	5	4	localException2	Exception
    //   1	115	5	localObject3	Object
    //   4	27	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	25	65	finally
    //   16	25	78	java/io/FileNotFoundException
    //   85	89	91	java/lang/Exception
    //   16	25	101	java/io/IOException
    //   108	112	114	java/lang/Exception
    //   72	76	121	java/lang/Exception
    //   136	140	142	java/lang/Exception
    //   25	30	152	finally
    //   37	41	152	finally
    //   43	48	152	finally
    //   25	30	156	java/io/IOException
    //   37	41	156	java/io/IOException
    //   43	48	156	java/io/IOException
    //   25	30	160	java/io/FileNotFoundException
    //   37	41	160	java/io/FileNotFoundException
    //   43	48	160	java/io/FileNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */