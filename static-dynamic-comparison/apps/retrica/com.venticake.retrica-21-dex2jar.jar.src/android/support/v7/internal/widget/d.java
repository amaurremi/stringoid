package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
  extends DataSetObservable
{
  private static final String a = d.class.getSimpleName();
  private static final Object b = new Object();
  private static final Map<String, d> c = new HashMap();
  private final Object d;
  private final List<e> e;
  private final List<g> f;
  private final Context g;
  private final String h;
  private Intent i;
  private f j;
  private int k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private h p;
  
  private boolean a(g paramg)
  {
    boolean bool = this.f.add(paramg);
    if (bool)
    {
      this.n = true;
      l();
      e();
      i();
      notifyChanged();
    }
    return bool;
  }
  
  private void e()
  {
    if (!this.m) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.n) {}
    do
    {
      return;
      this.n = false;
    } while (TextUtils.isEmpty(this.h));
    if (Build.VERSION.SDK_INT >= 11)
    {
      g();
      return;
    }
    f();
  }
  
  private void f()
  {
    new i(this, null).execute(new Object[] { new ArrayList(this.f), this.h });
  }
  
  private void g()
  {
    new i(this, null).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Object[] { new ArrayList(this.f), this.h });
  }
  
  private void h()
  {
    boolean bool1 = j();
    boolean bool2 = k();
    l();
    if ((bool1 | bool2))
    {
      i();
      notifyChanged();
    }
  }
  
  private boolean i()
  {
    if ((this.j != null) && (this.i != null) && (!this.e.isEmpty()) && (!this.f.isEmpty()))
    {
      this.j.a(this.i, this.e, Collections.unmodifiableList(this.f));
      return true;
    }
    return false;
  }
  
  private boolean j()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (this.i != null)
      {
        this.o = false;
        this.e.clear();
        List localList = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int i2 = localList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i1);
          this.e.add(new e(this, localResolveInfo));
          i1 += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean k()
  {
    if ((this.l) && (this.n) && (!TextUtils.isEmpty(this.h)))
    {
      this.l = false;
      this.m = true;
      m();
      return true;
    }
    return false;
  }
  
  private void l()
  {
    int i2 = this.f.size() - this.k;
    if (i2 <= 0) {}
    for (;;)
    {
      return;
      this.n = true;
      int i1 = 0;
      while (i1 < i2)
      {
        g localg = (g)this.f.remove(0);
        i1 += 1;
      }
    }
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	android/support/v7/internal/widget/d:g	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 88	android/support/v7/internal/widget/d:h	Ljava/lang/String;
    //   8: invokevirtual 210	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 216	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: aconst_null
    //   19: invokeinterface 222 3 0
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iconst_1
    //   28: if_icmpeq +18 -> 46
    //   31: iload_1
    //   32: iconst_2
    //   33: if_icmpeq +13 -> 46
    //   36: aload_3
    //   37: invokeinterface 225 1 0
    //   42: istore_1
    //   43: goto -17 -> 26
    //   46: ldc -29
    //   48: aload_3
    //   49: invokeinterface 230 1 0
    //   54: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifne +53 -> 110
    //   60: new 204	org/xmlpull/v1/XmlPullParserException
    //   63: dup
    //   64: ldc -19
    //   66: invokespecial 238	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: astore_3
    //   71: getstatic 45	android/support/v7/internal/widget/d:a	Ljava/lang/String;
    //   74: new 240	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   81: ldc -13
    //   83: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 88	android/support/v7/internal/widget/d:h	Ljava/lang/String;
    //   90: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aload_3
    //   97: invokestatic 255	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   100: pop
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 260	java/io/FileInputStream:close	()V
    //   109: return
    //   110: aload_0
    //   111: getfield 67	android/support/v7/internal/widget/d:f	Ljava/util/List;
    //   114: astore 4
    //   116: aload 4
    //   118: invokeinterface 164 1 0
    //   123: aload_3
    //   124: invokeinterface 225 1 0
    //   129: istore_1
    //   130: iload_1
    //   131: iconst_1
    //   132: if_icmpne +14 -> 146
    //   135: aload_2
    //   136: ifnull -27 -> 109
    //   139: aload_2
    //   140: invokevirtual 260	java/io/FileInputStream:close	()V
    //   143: return
    //   144: astore_2
    //   145: return
    //   146: iload_1
    //   147: iconst_3
    //   148: if_icmpeq -25 -> 123
    //   151: iload_1
    //   152: iconst_4
    //   153: if_icmpeq -30 -> 123
    //   156: ldc_w 262
    //   159: aload_3
    //   160: invokeinterface 230 1 0
    //   165: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifne +56 -> 224
    //   171: new 204	org/xmlpull/v1/XmlPullParserException
    //   174: dup
    //   175: ldc_w 264
    //   178: invokespecial 238	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   181: athrow
    //   182: astore_3
    //   183: getstatic 45	android/support/v7/internal/widget/d:a	Ljava/lang/String;
    //   186: new 240	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   193: ldc -13
    //   195: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: getfield 88	android/support/v7/internal/widget/d:h	Ljava/lang/String;
    //   202: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: aload_3
    //   209: invokestatic 255	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   212: pop
    //   213: aload_2
    //   214: ifnull -105 -> 109
    //   217: aload_2
    //   218: invokevirtual 260	java/io/FileInputStream:close	()V
    //   221: return
    //   222: astore_2
    //   223: return
    //   224: aload 4
    //   226: new 200	android/support/v7/internal/widget/g
    //   229: dup
    //   230: aload_3
    //   231: aconst_null
    //   232: ldc_w 266
    //   235: invokeinterface 270 3 0
    //   240: aload_3
    //   241: aconst_null
    //   242: ldc_w 272
    //   245: invokeinterface 270 3 0
    //   250: invokestatic 278	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   253: aload_3
    //   254: aconst_null
    //   255: ldc_w 280
    //   258: invokeinterface 270 3 0
    //   263: invokestatic 286	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   266: invokespecial 289	android/support/v7/internal/widget/g:<init>	(Ljava/lang/String;JF)V
    //   269: invokeinterface 73 2 0
    //   274: pop
    //   275: goto -152 -> 123
    //   278: astore_3
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 260	java/io/FileInputStream:close	()V
    //   287: aload_3
    //   288: athrow
    //   289: astore_2
    //   290: return
    //   291: astore_2
    //   292: goto -5 -> 287
    //   295: astore_2
    //   296: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	d
    //   25	129	1	i1	int
    //   11	129	2	localFileInputStream	java.io.FileInputStream
    //   144	74	2	localIOException1	java.io.IOException
    //   222	62	2	localIOException2	java.io.IOException
    //   289	1	2	localIOException3	java.io.IOException
    //   291	1	2	localIOException4	java.io.IOException
    //   295	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   15	34	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   70	90	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   182	72	3	localIOException5	java.io.IOException
    //   278	10	3	localObject	Object
    //   114	111	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	24	70	org/xmlpull/v1/XmlPullParserException
    //   36	43	70	org/xmlpull/v1/XmlPullParserException
    //   46	70	70	org/xmlpull/v1/XmlPullParserException
    //   110	123	70	org/xmlpull/v1/XmlPullParserException
    //   123	130	70	org/xmlpull/v1/XmlPullParserException
    //   156	182	70	org/xmlpull/v1/XmlPullParserException
    //   224	275	70	org/xmlpull/v1/XmlPullParserException
    //   139	143	144	java/io/IOException
    //   12	24	182	java/io/IOException
    //   36	43	182	java/io/IOException
    //   46	70	182	java/io/IOException
    //   110	123	182	java/io/IOException
    //   123	130	182	java/io/IOException
    //   156	182	182	java/io/IOException
    //   224	275	182	java/io/IOException
    //   217	221	222	java/io/IOException
    //   12	24	278	finally
    //   36	43	278	finally
    //   46	70	278	finally
    //   71	101	278	finally
    //   110	123	278	finally
    //   123	130	278	finally
    //   156	182	278	finally
    //   183	213	278	finally
    //   224	275	278	finally
    //   105	109	289	java/io/IOException
    //   283	287	291	java/io/IOException
    //   0	12	295	java/io/FileNotFoundException
  }
  
  public int a()
  {
    synchronized (this.d)
    {
      h();
      int i1 = this.e.size();
      return i1;
    }
  }
  
  public int a(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i1;
      synchronized (this.d)
      {
        h();
        List localList = this.e;
        int i2 = localList.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (((e)localList.get(i1)).a == paramResolveInfo) {
            return i1;
          }
        }
        else {
          return -1;
        }
      }
      i1 += 1;
    }
  }
  
  public ResolveInfo a(int paramInt)
  {
    synchronized (this.d)
    {
      h();
      ResolveInfo localResolveInfo = ((e)this.e.get(paramInt)).a;
      return localResolveInfo;
    }
  }
  
  public Intent b(int paramInt)
  {
    synchronized (this.d)
    {
      if (this.i == null) {
        return null;
      }
      h();
      Object localObject2 = (e)this.e.get(paramInt);
      localObject2 = new ComponentName(((e)localObject2).a.activityInfo.packageName, ((e)localObject2).a.activityInfo.name);
      Intent localIntent1 = new Intent(this.i);
      localIntent1.setComponent((ComponentName)localObject2);
      if (this.p != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.p.a(this, localIntent2)) {
          return null;
        }
      }
      a(new g((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo b()
  {
    synchronized (this.d)
    {
      h();
      if (!this.e.isEmpty())
      {
        ResolveInfo localResolveInfo = ((e)this.e.get(0)).a;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int c()
  {
    synchronized (this.d)
    {
      h();
      int i1 = this.f.size();
      return i1;
    }
  }
  
  public void c(int paramInt)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        h();
        e locale1 = (e)this.e.get(paramInt);
        e locale2 = (e)this.e.get(0);
        if (locale2 != null)
        {
          f1 = locale2.b - locale1.b + 5.0F;
          a(new g(new ComponentName(locale1.a.activityInfo.packageName, locale1.a.activityInfo.name), System.currentTimeMillis(), f1));
          return;
        }
      }
      float f1 = 1.0F;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */