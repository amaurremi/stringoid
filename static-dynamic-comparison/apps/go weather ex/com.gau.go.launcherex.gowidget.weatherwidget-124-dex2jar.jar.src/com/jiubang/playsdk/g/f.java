package com.jiubang.playsdk.g;

import android.content.Context;
import com.jiubang.playsdk.a.w;
import com.jiubang.playsdk.main.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
{
  private static final String a = f.class.getSimpleName();
  private static final String b = b.c + "/mg";
  private final List c = new ArrayList();
  private k d;
  private volatile boolean e = false;
  
  public f(Context paramContext)
  {
    this.d = new k(paramContext, "manage_good");
    c();
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (this.e) {
      return;
    }
    if (this.d == null)
    {
      d.a(a, "请先初始化");
      return;
    }
    this.e = true;
    long l = this.d.b("manage_good_last", 0L);
    if (System.currentTimeMillis() - l >= 28800000L)
    {
      new Thread(new g(this, paramContext), "managergood_network").start();
      return;
    }
    new Thread(new h(this, paramContext), "managergood_local").start();
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte1 = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte1);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      }
      try
      {
        byte[] arrayOfByte2;
        paramInputStream.close();
        if (localByteArrayOutputStream != null) {
          localByteArrayOutputStream.close();
        }
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          d.a(a, paramInputStream.getMessage() + " ", paramInputStream);
        }
      }
    }
    catch (Exception localException)
    {
      d.a(a, localException.getMessage() + "", localException);
      if (paramInputStream != null) {}
      try
      {
        paramInputStream.close();
        if (localByteArrayOutputStream != null) {
          localByteArrayOutputStream.close();
        }
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          d.a(a, paramInputStream.getMessage() + " ", paramInputStream);
        }
      }
      paramInputStream = null;
      for (;;)
      {
        return paramInputStream;
        localByteArrayOutputStream.flush();
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        if (paramInputStream != null) {}
        try
        {
          paramInputStream.close();
          paramInputStream = arrayOfByte2;
          if (localByteArrayOutputStream != null)
          {
            localByteArrayOutputStream.close();
            return arrayOfByte2;
          }
        }
        catch (Exception paramInputStream)
        {
          d.a(a, paramInputStream.getMessage() + " ", paramInputStream);
          return arrayOfByte2;
        }
      }
    }
    finally
    {
      if (paramInputStream == null) {}
    }
    throw ((Throwable)localObject);
  }
  
  private boolean b()
  {
    File localFile = new File(b);
    if (!localFile.exists()) {
      return false;
    }
    try
    {
      String str = new String(a(new FileInputStream(localFile)));
      if (str != null) {
        c(str);
      }
      return true;
    }
    catch (Exception localException)
    {
      d.a(a, localException.getMessage() + " ", localException);
      localFile.delete();
    }
    return false;
  }
  
  private boolean b(Context paramContext)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    paramContext = new HttpGet(m.d(paramContext));
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "utf-8");
    ConnManagerParams.setTimeout(localBasicHttpParams, 3000L);
    paramContext.setParams(localBasicHttpParams);
    try
    {
      paramContext = localDefaultHttpClient.execute(paramContext);
      if (paramContext.getStatusLine().getStatusCode() == 200)
      {
        paramContext = paramContext.getEntity();
        if (paramContext != null)
        {
          paramContext = l.a(a(paramContext.getContent()));
          if (paramContext != null)
          {
            c(paramContext);
            c.a(paramContext.getBytes(), b);
            this.d.a("manage_good_last", System.currentTimeMillis());
          }
        }
      }
      return true;
    }
    catch (Exception paramContext)
    {
      d.a("ManageGood", paramContext.getMessage() + "", paramContext);
    }
    return false;
  }
  
  private void c()
  {
    w localw;
    if (!d("com.gau.go.weatherex.appbilling.dynamicsbg.mount"))
    {
      localw = new w();
      localw.a("com.gau.go.weatherex.appbilling.dynamicsbg.mount");
      localw.b("02c80bb90000000000000006");
      this.c.add(localw);
    }
    if (!d("com.gau.go.weatherex.appbilling.systemwidgetskin.mountskin"))
    {
      localw = new w();
      localw.a("com.gau.go.weatherex.appbilling.systemwidgetskin.mountskin");
      localw.b("02c80bb90000000000000007");
      this.c.add(localw);
    }
    if (!d("com.gau.go.weatherex.appbilling.systemwidgetskin.locusskin"))
    {
      localw = new w();
      localw.a("com.gau.go.weatherex.appbilling.systemwidgetskin.locusskin");
      localw.b("02c80bb90000000000000008");
      this.c.add(localw);
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      a();
      paramString = new JSONArray(paramString);
      int i = paramString.length();
      while (i > 0)
      {
        i -= 1;
        JSONObject localJSONObject = paramString.getJSONObject(i);
        w localw = new w();
        localw.b(localJSONObject.getString("offerid"));
        localw.a(localJSONObject.getString("pkgname"));
        this.c.add(localw);
      }
      return;
    }
    catch (Exception paramString)
    {
      d.a(a, paramString.getMessage() + "", paramString);
      c();
    }
  }
  
  private boolean d(String paramString)
  {
    if (this.c.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((w)localIterator.next()).a())) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.clear();
    }
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if ((this.c == null) || (this.c.isEmpty())) {
      return false;
    }
    int i = this.c.size();
    while (i > 0)
    {
      Object localObject = this.c;
      i -= 1;
      localObject = (w)((List)localObject).get(i);
      if ((paramString != null) && (((w)localObject).a() != null) && (((w)localObject).a().equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ((this.c == null) || (this.c.isEmpty())) {
      return null;
    }
    int i = this.c.size();
    while (i > 0)
    {
      Object localObject = this.c;
      i -= 1;
      localObject = (w)((List)localObject).get(i);
      if ((paramString != null) && (((w)localObject).a() != null) && (((w)localObject).a().equals(paramString))) {
        return ((w)localObject).b();
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */