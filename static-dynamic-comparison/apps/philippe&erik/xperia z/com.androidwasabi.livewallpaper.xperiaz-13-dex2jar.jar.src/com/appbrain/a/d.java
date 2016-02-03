package com.appbrain.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.appbrain.e.e;
import com.appbrain.e.f;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  private static List a(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = new DataInputStream(paramContext.openFileInput("com.appbrain.conv_events"));
      try
      {
        int j = paramContext.readInt();
        int i = 0;
        while (i < j)
        {
          byte[] arrayOfByte = new byte[paramContext.readInt()];
          paramContext.readFully(arrayOfByte);
          localArrayList.add(e.a(arrayOfByte));
          i += 1;
        }
        return localArrayList;
      }
      finally
      {
        paramContext.close();
      }
      return localArrayList;
    }
    catch (Exception paramContext) {}
  }
  
  /* Error */
  public static void a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: invokestatic 59	com/appbrain/e/q:n	()Lcom/appbrain/e/r;
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: invokestatic 61	com/appbrain/a/d:a	(Landroid/content/Context;)Ljava/util/List;
    //   9: invokevirtual 66	com/appbrain/e/r:a	(Ljava/lang/Iterable;)Lcom/appbrain/e/r;
    //   12: pop
    //   13: aload_1
    //   14: ifnull +39 -> 53
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 69	com/appbrain/e/r:a	(Lcom/appbrain/e/e;)Lcom/appbrain/e/r;
    //   22: pop
    //   23: aload_2
    //   24: invokevirtual 73	com/appbrain/e/r:d	()Lcom/appbrain/e/q;
    //   27: astore_2
    //   28: aload_0
    //   29: invokestatic 78	com/appbrain/a/am:a	(Landroid/content/Context;)Lcom/appbrain/a/am;
    //   32: aload_2
    //   33: invokevirtual 81	com/appbrain/a/am:a	(Lcom/appbrain/e/q;)Lcom/appbrain/e/h;
    //   36: astore_1
    //   37: aload_0
    //   38: ldc 18
    //   40: invokevirtual 85	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 91	com/appbrain/e/h:h	()Lcom/appbrain/e/k;
    //   49: invokestatic 96	com/appbrain/a/ae:a	(Landroid/content/Context;Lcom/appbrain/e/k;)V
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 99	com/appbrain/e/r:f	()I
    //   57: ifle -34 -> 23
    //   60: aload_2
    //   61: iconst_1
    //   62: invokevirtual 102	com/appbrain/e/r:a	(Z)Lcom/appbrain/e/r;
    //   65: pop
    //   66: goto -43 -> 23
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 106	com/appbrain/e/q:m	()Ljava/util/List;
    //   74: astore_2
    //   75: new 108	java/io/DataOutputStream
    //   78: dup
    //   79: aload_0
    //   80: ldc 18
    //   82: iconst_0
    //   83: invokevirtual 112	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   86: invokespecial 115	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: astore_0
    //   90: aload_0
    //   91: aload_2
    //   92: invokeinterface 118 1 0
    //   97: invokevirtual 122	java/io/DataOutputStream:writeInt	(I)V
    //   100: aload_2
    //   101: invokeinterface 126 1 0
    //   106: astore_2
    //   107: aload_2
    //   108: invokeinterface 132 1 0
    //   113: ifeq +40 -> 153
    //   116: aload_2
    //   117: invokeinterface 136 1 0
    //   122: checkcast 37	com/appbrain/e/e
    //   125: invokevirtual 140	com/appbrain/e/e:b	()[B
    //   128: astore_3
    //   129: aload_0
    //   130: aload_3
    //   131: arraylength
    //   132: invokevirtual 122	java/io/DataOutputStream:writeInt	(I)V
    //   135: aload_0
    //   136: aload_3
    //   137: invokevirtual 143	java/io/DataOutputStream:write	([B)V
    //   140: goto -33 -> 107
    //   143: astore_2
    //   144: aload_0
    //   145: invokevirtual 144	java/io/DataOutputStream:close	()V
    //   148: aload_2
    //   149: athrow
    //   150: astore_0
    //   151: aload_1
    //   152: athrow
    //   153: aload_0
    //   154: invokevirtual 144	java/io/DataOutputStream:close	()V
    //   157: goto -6 -> 151
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 147	java/lang/Throwable:printStackTrace	()V
    //   165: return
    //   166: astore_2
    //   167: goto -123 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramContext	Context
    //   0	170	1	parame	e
    //   3	114	2	localObject1	Object
    //   143	6	2	localObject2	Object
    //   166	1	2	localException	Exception
    //   128	9	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	37	69	java/lang/Exception
    //   90	107	143	finally
    //   107	140	143	finally
    //   75	90	150	java/lang/Exception
    //   144	150	150	java/lang/Exception
    //   153	157	150	java/lang/Exception
    //   44	52	160	java/lang/Throwable
    //   37	44	166	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!TextUtils.equals(paramIntent.getAction(), "com.appbrain.CONVERSION"))) {
      return false;
    }
    if ((aw.a().c()) || (aw.a().a("convoff", 0) != 0)) {
      return true;
    }
    String str2 = paramIntent.getStringExtra("com.appbrain.NAME");
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 20) {
        str1 = str2.substring(0, 20);
      }
    }
    int i = paramIntent.getIntExtra("com.appbrain.VALUE", 0);
    paramIntent = e.l().a(System.currentTimeMillis()).a(str1).a(i).d();
    try
    {
      a(paramContext, paramIntent);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */