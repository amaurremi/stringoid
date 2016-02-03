package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.gtp.a.a.b.c;

public class ae
{
  private u a;
  private Context b;
  private boolean c;
  
  public ae(Context paramContext)
  {
    this.b = paramContext;
    this.a = new u();
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString, z paramz)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 34	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: astore 5
    //   6: aload 5
    //   8: aload_2
    //   9: ldc 36
    //   11: ldc 38
    //   13: invokevirtual 44	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: ldc 46
    //   18: ldc 48
    //   20: invokevirtual 52	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   23: ldc 54
    //   25: aload_1
    //   26: invokevirtual 58	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 64	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   32: istore 4
    //   34: iload 4
    //   36: ifeq +78 -> 114
    //   39: aload 5
    //   41: iload 4
    //   43: invokevirtual 68	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   46: astore 6
    //   48: aload 6
    //   50: astore 5
    //   52: aload 6
    //   54: ifnonnull +13 -> 67
    //   57: aload_1
    //   58: invokevirtual 72	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   61: aload_2
    //   62: invokevirtual 78	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +67 -> 136
    //   72: invokestatic 84	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   75: astore_1
    //   76: aload_1
    //   77: iconst_1
    //   78: invokevirtual 88	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   81: aload_1
    //   82: invokevirtual 92	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   85: astore_1
    //   86: aload_1
    //   87: aload 5
    //   89: ldc 94
    //   91: invokeinterface 100 3 0
    //   96: aload_0
    //   97: getfield 22	com/gau/go/launcherex/gowidget/scriptengine/parser/ae:a	Lcom/gau/go/launcherex/gowidget/scriptengine/parser/u;
    //   100: aload_1
    //   101: aload_3
    //   102: invokevirtual 103	com/gau/go/launcherex/gowidget/scriptengine/parser/u:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/gau/go/launcherex/gowidget/scriptengine/parser/z;)V
    //   105: iconst_1
    //   106: ireturn
    //   107: astore 5
    //   109: aload 5
    //   111: invokevirtual 106	android/content/res/Resources$NotFoundException:printStackTrace	()V
    //   114: aconst_null
    //   115: astore 6
    //   117: goto -69 -> 48
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   125: aconst_null
    //   126: astore 5
    //   128: goto -61 -> 67
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   136: iconst_0
    //   137: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ae
    //   0	138	1	paramContext	Context
    //   0	138	2	paramString	String
    //   0	138	3	paramz	z
    //   32	10	4	i	int
    //   4	84	5	localObject1	Object
    //   107	3	5	localNotFoundException	android.content.res.Resources.NotFoundException
    //   126	1	5	localObject2	Object
    //   46	70	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   39	48	107	android/content/res/Resources$NotFoundException
    //   57	67	120	java/lang/Exception
    //   72	105	131	java/lang/Exception
  }
  
  public z a(String paramString1, String paramString2)
  {
    z localz = new z();
    if (paramString2.equals(this.b.getPackageName()))
    {
      a(this.b, paramString1, localz);
      this.c = true;
      return localz;
    }
    Context localContext = this.b;
    try
    {
      paramString2 = this.b.createPackageContext(paramString2, 3);
      i = 1;
    }
    catch (PackageManager.NameNotFoundException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        int i = 0;
        paramString2 = localContext;
      }
      this.c = true;
      return localz;
    }
    if (i != 0) {
      if (!a(paramString2, paramString1, localz))
      {
        this.c = false;
        localz.i();
        a(this.b, paramString1, localz);
        return localz;
      }
    }
    this.c = false;
    a(this.b, paramString1, localz);
    return localz;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public z b(String paramString1, String paramString2)
  {
    this.c = false;
    z localz = new z();
    if (paramString2.equals(this.b.getPackageName())) {
      this.c = a(this.b, paramString1, localz);
    }
    for (;;)
    {
      paramString1 = localz;
      if (!this.c) {
        paramString1 = null;
      }
      return paramString1;
      Context localContext = this.b;
      int i = 1;
      try
      {
        paramString2 = this.b.createPackageContext(paramString2, 3);
        if (i == 0) {
          continue;
        }
        this.c = a(paramString2, paramString1, localz);
      }
      catch (PackageManager.NameNotFoundException paramString2)
      {
        for (;;)
        {
          if (c.a()) {
            paramString2.printStackTrace();
          }
          i = 0;
          paramString2 = localContext;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */