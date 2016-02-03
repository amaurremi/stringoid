package com.gau.go.launcherex.gowidget.weather.e;

import android.content.ContentResolver;
import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

public class h
{
  /* Error */
  public static String a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 14	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: new 16	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   12: ldc 22
    //   14: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_1
    //   18: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_0
    //   26: getstatic 39	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:i	Landroid/net/Uri;
    //   29: aconst_null
    //   30: aload_2
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 45	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +14 -> 52
    //   41: aload_2
    //   42: astore_0
    //   43: aload_2
    //   44: invokeinterface 51 1 0
    //   49: ifne +22 -> 71
    //   52: ldc 53
    //   54: astore_3
    //   55: aload_3
    //   56: astore_0
    //   57: aload_2
    //   58: ifnull +11 -> 69
    //   61: aload_3
    //   62: astore_0
    //   63: aload_2
    //   64: invokeinterface 56 1 0
    //   69: aload_0
    //   70: areturn
    //   71: aload_2
    //   72: astore_0
    //   73: aload_2
    //   74: invokeinterface 60 1 0
    //   79: pop
    //   80: aload_2
    //   81: astore_0
    //   82: aload_2
    //   83: aload_2
    //   84: ldc 62
    //   86: invokeinterface 66 2 0
    //   91: invokeinterface 70 2 0
    //   96: astore_3
    //   97: aload_2
    //   98: astore_0
    //   99: aload_3
    //   100: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +55 -> 158
    //   106: ldc 53
    //   108: astore_3
    //   109: aload_3
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull -43 -> 69
    //   115: aload_3
    //   116: astore_0
    //   117: goto -54 -> 63
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_0
    //   125: aload_3
    //   126: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   129: ldc 53
    //   131: astore_3
    //   132: aload_3
    //   133: astore_0
    //   134: aload_2
    //   135: ifnull -66 -> 69
    //   138: aload_3
    //   139: astore_0
    //   140: goto -77 -> 63
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +9 -> 156
    //   150: aload_0
    //   151: invokeinterface 56 1 0
    //   156: aload_2
    //   157: athrow
    //   158: aload_3
    //   159: astore_0
    //   160: aload_2
    //   161: ifnull -92 -> 69
    //   164: aload_3
    //   165: astore_0
    //   166: goto -103 -> 63
    //   169: astore_2
    //   170: goto -24 -> 146
    //   173: astore_3
    //   174: goto -51 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   0	177	1	paramInt	int
    //   24	111	2	localObject1	Object
    //   143	18	2	localObject2	Object
    //   169	1	2	localObject3	Object
    //   54	62	3	str1	String
    //   120	6	3	localException1	Exception
    //   131	34	3	str2	String
    //   173	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	37	120	java/lang/Exception
    //   5	37	143	finally
    //   43	52	169	finally
    //   73	80	169	finally
    //   82	97	169	finally
    //   99	106	169	finally
    //   125	129	169	finally
    //   43	52	173	java/lang/Exception
    //   73	80	173	java/lang/Exception
    //   82	97	173	java/lang/Exception
    //   99	106	173	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: invokevirtual 14	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: astore 4
    //   15: new 16	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   22: ldc 22
    //   24: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_1
    //   28: invokevirtual 29	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload 4
    //   38: getstatic 39	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:i	Landroid/net/Uri;
    //   41: aconst_null
    //   42: aload 5
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 45	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +14 -> 65
    //   54: aload_3
    //   55: astore_0
    //   56: aload_3
    //   57: invokeinterface 51 1 0
    //   62: ifne +78 -> 140
    //   65: aload_3
    //   66: astore_0
    //   67: new 83	android/content/ContentValues
    //   70: dup
    //   71: invokespecial 84	android/content/ContentValues:<init>	()V
    //   74: astore 5
    //   76: aload_3
    //   77: astore_0
    //   78: aload 5
    //   80: ldc 86
    //   82: iload_1
    //   83: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: invokevirtual 96	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   89: aload_3
    //   90: astore_0
    //   91: aload 5
    //   93: ldc 62
    //   95: aload_2
    //   96: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: astore_0
    //   101: aload 4
    //   103: getstatic 39	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:i	Landroid/net/Uri;
    //   106: aload 5
    //   108: invokevirtual 103	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +15 -> 128
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokeinterface 56 1 0
    //   126: iconst_1
    //   127: ireturn
    //   128: aload_3
    //   129: ifnull +9 -> 138
    //   132: aload_3
    //   133: invokeinterface 56 1 0
    //   138: iconst_0
    //   139: ireturn
    //   140: aload_3
    //   141: astore_0
    //   142: new 83	android/content/ContentValues
    //   145: dup
    //   146: invokespecial 84	android/content/ContentValues:<init>	()V
    //   149: astore 6
    //   151: aload_3
    //   152: astore_0
    //   153: aload 6
    //   155: ldc 62
    //   157: aload_2
    //   158: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: astore_0
    //   163: aload 4
    //   165: getstatic 39	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:i	Landroid/net/Uri;
    //   168: aload 6
    //   170: aload 5
    //   172: aconst_null
    //   173: invokevirtual 107	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   176: istore_1
    //   177: iload_1
    //   178: ifle +15 -> 193
    //   181: aload_3
    //   182: ifnull +9 -> 191
    //   185: aload_3
    //   186: invokeinterface 56 1 0
    //   191: iconst_1
    //   192: ireturn
    //   193: aload_3
    //   194: ifnull +9 -> 203
    //   197: aload_3
    //   198: invokeinterface 56 1 0
    //   203: iconst_0
    //   204: ireturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_3
    //   208: aload_3
    //   209: astore_0
    //   210: aload_2
    //   211: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   214: aload_3
    //   215: ifnull +9 -> 224
    //   218: aload_3
    //   219: invokeinterface 56 1 0
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_0
    //   229: aload_0
    //   230: ifnull +9 -> 239
    //   233: aload_0
    //   234: invokeinterface 56 1 0
    //   239: aload_2
    //   240: athrow
    //   241: astore_2
    //   242: goto -13 -> 229
    //   245: astore_2
    //   246: goto -38 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	Context
    //   0	249	1	paramInt	int
    //   0	249	2	paramString	String
    //   49	170	3	localCursor	android.database.Cursor
    //   13	151	4	localContentResolver	ContentResolver
    //   34	137	5	localObject	Object
    //   149	20	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   15	50	205	java/lang/Exception
    //   15	50	226	finally
    //   56	65	241	finally
    //   67	76	241	finally
    //   78	89	241	finally
    //   91	99	241	finally
    //   101	112	241	finally
    //   142	151	241	finally
    //   153	161	241	finally
    //   163	177	241	finally
    //   210	214	241	finally
    //   56	65	245	java/lang/Exception
    //   67	76	245	java/lang/Exception
    //   78	89	245	java/lang/Exception
    //   91	99	245	java/lang/Exception
    //   101	112	245	java/lang/Exception
    //   142	151	245	java/lang/Exception
    //   153	161	245	java/lang/Exception
    //   163	177	245	java/lang/Exception
  }
  
  public static boolean b(Context paramContext, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    for (;;)
    {
      try
      {
        paramContext = "widget_id=" + paramInt;
        paramInt = localContentResolver.delete(WeatherContentProvider.i, paramContext, null);
        if (paramInt <= 0) {
          break label94;
        }
        bool1 = true;
        bool2 = true;
        if (0 == 0) {
          continue;
        }
        bool1 = bool2;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        if (0 == 0) {
          continue;
        }
        bool1 = bool2;
        continue;
      }
      finally
      {
        if (0 == 0) {
          continue;
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
      return bool1;
      label94:
      if (0 != 0) {
        bool1 = bool2;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */