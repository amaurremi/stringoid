package com.jiubang.playsdk.a;

import com.jiubang.playsdk.g.e;
import com.jiubang.playsdk.main.c;
import java.util.HashMap;
import java.util.Map;

class j
  implements p
{
  public j(d paramd) {}
  
  /* Error */
  public com.android.a.t a(com.android.a.m paramm)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 21	java/lang/String
    //   5: dup
    //   6: aload_1
    //   7: getfield 27	com/android/a/m:b	[B
    //   10: invokespecial 30	java/lang/String:<init>	([B)V
    //   13: astore 7
    //   15: new 32	org/json/JSONObject
    //   18: dup
    //   19: aload 7
    //   21: invokespecial 35	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: ldc 37
    //   26: lconst_0
    //   27: invokevirtual 41	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   30: lstore_3
    //   31: new 43	com/jiubang/playsdk/g/k
    //   34: dup
    //   35: aload_0
    //   36: getfield 12	com/jiubang/playsdk/a/j:a	Lcom/jiubang/playsdk/a/d;
    //   39: invokestatic 49	com/jiubang/playsdk/a/d:c	(Lcom/jiubang/playsdk/a/d;)Landroid/content/Context;
    //   42: ldc 51
    //   44: invokespecial 54	com/jiubang/playsdk/g/k:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   47: astore 7
    //   49: aload 7
    //   51: ldc 56
    //   53: lconst_0
    //   54: invokevirtual 58	com/jiubang/playsdk/g/k:b	(Ljava/lang/String;J)J
    //   57: lstore 5
    //   59: lload 5
    //   61: lconst_0
    //   62: lcmp
    //   63: ifne +28 -> 91
    //   66: aload 7
    //   68: ldc 56
    //   70: lload_3
    //   71: invokevirtual 61	com/jiubang/playsdk/g/k:a	(Ljava/lang/String;J)V
    //   74: aload 7
    //   76: invokevirtual 63	com/jiubang/playsdk/g/k:a	()V
    //   79: iload_2
    //   80: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   83: aload_1
    //   84: invokestatic 74	com/android/a/a/i:a	(Lcom/android/a/m;)Lcom/android/a/c;
    //   87: invokestatic 79	com/android/a/t:a	(Ljava/lang/Object;Lcom/android/a/c;)Lcom/android/a/t;
    //   90: areturn
    //   91: lload_3
    //   92: lload 5
    //   94: lcmp
    //   95: ifgt -29 -> 66
    //   98: iconst_0
    //   99: istore_2
    //   100: goto -34 -> 66
    //   103: astore 7
    //   105: iconst_0
    //   106: istore_2
    //   107: aload 7
    //   109: invokevirtual 82	org/json/JSONException:printStackTrace	()V
    //   112: goto -33 -> 79
    //   115: astore 7
    //   117: goto -10 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	j
    //   0	120	1	paramm	com.android.a.m
    //   1	106	2	bool	boolean
    //   30	62	3	l1	long
    //   57	36	5	l2	long
    //   13	62	7	localObject	Object
    //   103	5	7	localJSONException1	org.json.JSONException
    //   115	1	7	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   15	59	103	org/json/JSONException
    //   66	79	115	org/json/JSONException
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key", "themeNewMark");
    localHashMap.put("clientid", aa.a().b().o() + "");
    localHashMap.put("channel", e.f(aa.a().d()));
    localHashMap.put("local", e.e(aa.a().d()));
    return localHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */