package com.jirbo.adcolony;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

class ADCDownload
  extends j
  implements Runnable
{
  d a;
  ADCDownload.Listener b;
  String c;
  File d;
  Object e;
  String f;
  String g;
  boolean h;
  boolean i;
  boolean j;
  SSLContext k;
  int l;
  String m;
  
  ADCDownload(d paramd, String paramString, ADCDownload.Listener paramListener)
  {
    this(paramd, paramString, paramListener, null);
  }
  
  ADCDownload(d paramd, String paramString1, ADCDownload.Listener paramListener, String paramString2)
  {
    super(paramd, false);
    this.c = paramString1;
    this.b = paramListener;
    if (paramString2 != null) {
      this.d = new File(paramString2);
    }
  }
  
  ADCDownload a(Object paramObject)
  {
    this.e = paramObject;
    return this;
  }
  
  ADCDownload a(String paramString1, String paramString2)
  {
    this.f = paramString1;
    this.g = paramString2;
    return this;
  }
  
  void a()
  {
    this.b.on_download_finished(this);
  }
  
  public void b()
  {
    aa.a(this);
  }
  
  public void run()
  {
    i1 = 1;
    if (i1 <= 3) {}
    try
    {
      if (this.f == null) {
        break label730;
      }
      l.a.b("Performing POST");
      try
      {
        localObject5 = this.c;
        Object localObject3 = this.c;
        Object localObject1 = "";
        if (this.c.toLowerCase().startsWith("http://")) {
          this.c = this.c.substring(7);
        }
        n = this.c.indexOf('/');
        if (n != -1)
        {
          localObject1 = this.c.substring(n);
          localObject3 = this.c.substring(0, n);
        }
        localObject6 = new Socket((String)localObject3, 80);
        ((Socket)localObject6).setSoTimeout(30000);
        PrintStream localPrintStream = new PrintStream(((Socket)localObject6).getOutputStream());
        InputStream localInputStream2 = ((Socket)localObject6).getInputStream();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("POST ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" HTTP/1.1\r\n");
        localStringBuilder.append("Host: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Content-Type: ");
        localStringBuilder.append(this.f);
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Content-Length: ");
        localStringBuilder.append(this.g.length() + 4);
        localStringBuilder.append("\r\n\r\n");
        localStringBuilder.append(this.g);
        localStringBuilder.append("\r\n\r\n");
        localObject1 = localStringBuilder.toString();
        localPrintStream.print((String)localObject1);
        localPrintStream.flush();
        l.a.b("Submitting POST:").b(localObject1);
        localObject1 = new StringBuilder();
        for (n = localInputStream2.read();; n = localInputStream2.read()) {
          if (n != -1)
          {
            ((StringBuilder)localObject1).append((char)n);
            if ((((StringBuilder)localObject1).length() < 4) || (((StringBuilder)localObject1).indexOf("\r\n\r\n", ((StringBuilder)localObject1).length() - 4) < 0)) {}
          }
          else
          {
            localObject1 = ((StringBuilder)localObject1).toString();
            n = ((String)localObject1).indexOf("Content-Length:");
            if (n < 0) {
              break label576;
            }
            n = "Content-Length:".length() + n;
            for (localObject1 = ((String)localObject1).substring(n, ((String)localObject1).indexOf("\r\n", n));; localObject1 = ((String)localObject1).substring(1))
            {
              localObject3 = localObject1;
              if (((String)localObject1).charAt(0) != ' ') {
                break;
              }
            }
          }
        }
        while (((String)localObject3).charAt(((String)localObject3).length() - 1) == ' ') {
          localObject3 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
        }
        n = Integer.parseInt((String)localObject3);
        localObject1 = new StringBuilder();
        for (;;)
        {
          if (n != 0) {
            i1 = n;
          }
          try
          {
            i2 = localInputStream2.read();
            if (i2 != -1) {
              break label611;
            }
          }
          catch (SocketTimeoutException localSocketTimeoutException)
          {
            char c1;
            while (i1 <= 0) {}
            throw localSocketTimeoutException;
          }
          ((Socket)localObject6).close();
          this.m = ((StringBuilder)localObject1).toString();
          this.l = this.m.length();
          l.a.a("POST response (").a((String)localObject5).b("):");
          l.a.b(this.m);
          this.i = true;
          a.a(this);
          return;
          label576:
          a.e("Missing Content-Length in response header (" + this.c + ").");
          n = -1;
          break;
          label611:
          c1 = (char)i2;
          i1 = n;
          ((StringBuilder)localObject1).append(c1);
          if (n > 0)
          {
            i2 = n - 1;
            n = i2;
            if (i2 == 0)
            {
              i1 = i2;
              i3 = localInputStream2.available();
              n = i2;
              if (i3 > 0) {
                n = -1;
              }
            }
          }
        }
        a.c("Download of " + this.c + " failed:\n" + localIOException1.toString());
      }
      catch (IOException localIOException1)
      {
        n = 3;
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Object localObject5;
        Object localObject6;
        int i2;
        int i3;
        label730:
        Object localObject2;
        Object localObject4;
        label1214:
        label1311:
        label1326:
        label1463:
        int n = i1;
      }
    }
    if (n == 3)
    {
      this.i = false;
      a.a(this);
      return;
      localObject2 = null;
      localObject4 = null;
      localObject5 = (HttpURLConnection)new URL(this.c).openConnection();
      ((HttpURLConnection)localObject5).setReadTimeout(30000);
      if (this.h) {
        ((HttpURLConnection)localObject5).setInstanceFollowRedirects(false);
      }
      if (this.d != null)
      {
        if ((this.a != null) && (this.a.f != null)) {
          this.a.f.b();
        }
        localObject2 = this.d.getAbsolutePath();
        localObject4 = new FileOutputStream((String)localObject2);
        localObject6 = ((HttpURLConnection)localObject5).getInputStream();
        i2 = ((HttpURLConnection)localObject5).getContentLength();
        this.l = 0;
        localObject5 = new byte['Ѐ'];
        n = ((InputStream)localObject6).read((byte[])localObject5, 0, 1024);
        break label1463;
      }
    }
    for (;;)
    {
      this.l += i3;
      ((OutputStream)localObject4).write((byte[])localObject5, 0, i3);
      n = ((InputStream)localObject6).read((byte[])localObject5, 0, 1024);
      i2 = i4;
      if (i4 == 0) {}
      while (n == -1)
      {
        ((InputStream)localObject6).close();
        ((OutputStream)localObject4).flush();
        ((OutputStream)localObject4).close();
        l.b.a("Downloaded ").a(this.c).a(" to ").b(localObject2);
        this.i = true;
        a.a(this);
        return;
        if (this.h)
        {
          localObject2 = localObject4;
          if (this.c.startsWith("https://"))
          {
            localObject2 = localObject4;
            if (Build.VERSION.SDK_INT >= 10)
            {
              localObject2 = (HttpsURLConnection)new URL(this.c).openConnection();
              this.j = true;
            }
          }
          if (this.j) {}
          for (n = ((HttpsURLConnection)localObject2).getResponseCode(); n > 0; n = ((HttpURLConnection)localObject5).getResponseCode())
          {
            l.a.a("Got HTTP response ").a(n).b(" - counting as completed submission for 3rd party tracking.");
            l.b.a("Downloaded ").b(this.c);
            this.m = "";
            this.l = 0;
            this.i = true;
            a.a(this);
            return;
          }
        }
        if ((this.c.startsWith("https://")) && (Build.VERSION.SDK_INT >= 10))
        {
          localObject2 = (HttpsURLConnection)new URL(this.c).openConnection();
          this.j = true;
          l.a.b("ADCDownload - use ssl!");
          l.a.b("ADCDownload - before pause");
        }
        try
        {
          Thread.sleep(3000L);
          l.a.b("ADCDownload - getInputStream");
          if (this.j)
          {
            localObject2 = ((HttpsURLConnection)localObject2).getInputStream();
            localObject4 = new StringBuilder();
            localObject5 = new byte['Ѐ'];
          }
          InputStream localInputStream1;
          for (n = ((InputStream)localObject2).read((byte[])localObject5, 0, 1024);; n = localInputStream1.read((byte[])localObject5, 0, 1024))
          {
            if (n == -1) {
              break label1326;
            }
            i2 = -1;
            for (;;)
            {
              i2 += 1;
              if (i2 >= n) {
                break label1311;
              }
              try
              {
                ((StringBuilder)localObject4).append((char)localObject5[i2]);
              }
              catch (OutOfMemoryError localOutOfMemoryError1)
              {
                l.d.b("Out of memory, disabling AdColony");
                AdColony.disable();
                return;
              }
            }
            this.j = false;
            break;
            localInputStream1 = ((HttpURLConnection)localObject5).getInputStream();
            break label1214;
          }
          localInputStream1.close();
          try
          {
            this.m = ((StringBuilder)localObject4).toString();
            this.l = this.m.length();
            if (this.c.contains("androidads21")) {
              a.X = System.currentTimeMillis();
            }
            l.b.a("Downloaded ").b(this.c);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            l.d.b("Out of memory, disabling AdColony");
            AdColony.disable();
            return;
          }
          l1 = (n + 1) * 10 * 1000;
        }
        catch (Exception localException)
        {
          try
          {
            long l1;
            Thread.sleep(l1);
            l.b.a("Trying again (").a(n + 1).b("/3)");
            i1 = n + 1;
            break;
            localException = localException;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
        }
      }
      i3 = n;
      int i4 = i2;
      if (i2 > 0)
      {
        i3 = n;
        if (n > i2) {
          i3 = i2;
        }
        i4 = i2 - i3;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */