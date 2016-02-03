package com.gau.go.launcherex.gowidget.weather.d;

import android.content.Context;
import android.content.Intent;
import android.sax.Element;
import android.sax.RootElement;
import android.text.TextUtils;
import android.util.Xml;
import android.util.Xml.Encoding;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xml.sax.ContentHandler;

public class g
{
  private Context a;
  private String b = "";
  private String c;
  private String d;
  private o e;
  private String f;
  private String g;
  
  g(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    paramContext = null;
    try
    {
      paramString = this.b.getBytes("utf-8");
      paramContext = paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    this.f = a.a(paramContext, 0).replace("\n", "").replace("=", "");
    this.c = ("/data/data/" + this.a.getPackageName() + "/files");
    e.a(this.c);
    this.d = (this.c + "/" + this.f);
    c();
  }
  
  private String a(String paramString, int paramInt)
  {
    paramString = paramString + this.b + paramInt;
    try
    {
      paramString = d.a(paramString.getBytes("utf-8"));
      String str = d.a(paramInt + "", paramString);
      paramString = paramString + str;
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return "";
  }
  
  private ContentHandler a(o paramo)
  {
    RootElement localRootElement = new RootElement("root");
    localRootElement.getChild("installDate").setEndTextElementListener(new h(this, paramo));
    localRootElement.getChild("currentDate").setEndTextElementListener(new i(this, paramo));
    localRootElement.getChild("serialRamdonKey").setEndTextElementListener(new j(this, paramo));
    localRootElement.getChild("serialCode").setEndTextElementListener(new k(this, paramo));
    localRootElement.getChild("paid").setEndTextElementListener(new l(this, paramo));
    return localRootElement.getContentHandler();
  }
  
  private int b()
  {
    return new SecureRandom().nextInt(9000) + 1000;
  }
  
  /* Error */
  private void b(o paramo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 173	com/gau/go/launcherex/gowidget/weather/d/o:f	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: ldc 29
    //   8: invokevirtual 35	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   11: invokestatic 176	com/gau/go/launcherex/gowidget/weather/d/d:c	([B)[B
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 72	com/gau/go/launcherex/gowidget/weather/d/g:c	Ljava/lang/String;
    //   19: invokestatic 77	com/gau/go/launcherex/gowidget/weather/d/e:a	(Ljava/lang/String;)Z
    //   22: ifeq +40 -> 62
    //   25: new 178	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 81	com/gau/go/launcherex/gowidget/weather/d/g:d	Ljava/lang/String;
    //   33: iconst_0
    //   34: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: aload_3
    //   44: arraylength
    //   45: invokevirtual 185	java/io/FileOutputStream:write	([BII)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: invokevirtual 188	java/io/FileOutputStream:flush	()V
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   62: return
    //   63: astore_1
    //   64: ldc -63
    //   66: aload_1
    //   67: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   70: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: pop
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   80: return
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: ldc -63
    //   88: aload_3
    //   89: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   92: invokestatic 201	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: aload_2
    //   97: ifnull -35 -> 62
    //   100: aload_2
    //   101: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   104: return
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   110: return
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   122: aload_2
    //   123: athrow
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   129: goto -7 -> 122
    //   132: astore_2
    //   133: goto -19 -> 114
    //   136: astore_3
    //   137: goto -53 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	g
    //   0	140	1	paramo	o
    //   37	64	2	localFileOutputStream	java.io.FileOutputStream
    //   111	12	2	localObject1	Object
    //   132	1	2	localObject2	Object
    //   14	30	3	arrayOfByte	byte[]
    //   81	8	3	localException1	Exception
    //   136	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	15	63	java/lang/Exception
    //   58	62	75	java/io/IOException
    //   25	38	81	java/lang/Exception
    //   100	104	105	java/io/IOException
    //   25	38	111	finally
    //   118	122	124	java/io/IOException
    //   40	48	132	finally
    //   50	54	132	finally
    //   86	96	132	finally
    //   40	48	136	java/lang/Exception
    //   50	54	136	java/lang/Exception
  }
  
  private void c()
  {
    Object localObject = e.b(this.d);
    this.e = new o();
    if (localObject == null)
    {
      d();
      return;
    }
    try
    {
      localObject = new ByteArrayInputStream(d.d((byte[])localObject));
      ContentHandler localContentHandler = a(this.e);
      Xml.parse((InputStream)localObject, Xml.Encoding.UTF_8, localContentHandler);
      ((InputStream)localObject).close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      d();
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      d();
    }
  }
  
  private void d()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    this.e.a(str);
    this.e.b(str);
    this.e.a(false);
    if (TextUtils.isEmpty(this.g)) {
      this.g = f();
    }
    int i = b();
    this.e.a(i);
    this.e.c(a(this.g, i));
    new m(this).start();
  }
  
  private void e()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PAYINFO_SAVE_FINISH");
    this.a.sendBroadcast(localIntent);
  }
  
  private String f()
  {
    try
    {
      String str = r.a(this.a);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.e.e()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(this.g)) {
        this.g = f();
      }
      int i = b();
      this.e.a(i);
      String str = a(this.g, i);
      this.e.c(str);
      this.e.a(paramBoolean);
      new n(this).start();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */