package com.ideashower.readitlater.f;

import com.ideashower.readitlater.a.ax;
import com.ideashower.readitlater.a.l;
import com.ideashower.readitlater.a.w;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class a
  extends k
{
  protected final com.pocket.m.a.a a;
  protected b b = e_();
  private final String c;
  private final int d;
  private final HttpUriRequest e;
  private final boolean f;
  private final boolean g;
  private com.e.a.a.a h;
  private final c p;
  private com.ideashower.readitlater.d.b q;
  private int r;
  
  public a(d paramd, com.ideashower.readitlater.d.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = d.a(paramd);
    this.e = d.b(paramd);
    this.a = d.c(paramd);
    this.d = d.d(paramd);
    this.p = d.e(paramd);
    this.h = w.c();
    this.q = paramb;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
  }
  
  private int a(HttpEntity paramHttpEntity, boolean paramBoolean)
  {
    org.apache.a.b.a.a locala = null;
    int k = 0;
    Object localObject1 = paramHttpEntity.getContent();
    if (paramBoolean) {
      localObject1 = new GZIPInputStream((InputStream)localObject1);
    }
    for (;;)
    {
      paramHttpEntity = this.b.d();
      int i;
      if (((this.d == 0) && (!this.b.g())) || (this.d == 2))
      {
        i = 1;
        if ((this.d != 2) || ((paramHttpEntity != null) && (paramHttpEntity.length() <= 0))) {
          break label375;
        }
        paramHttpEntity = "UTF-8";
      }
      label372:
      label375:
      for (int j = 0;; j = 1)
      {
        if ((i != 0) && (j == 0)) {}
        try
        {
          this.b.a(org.apache.a.b.d.a((InputStream)localObject1, paramHttpEntity));
          i = k;
          this.b.b(paramHttpEntity);
          return i;
        }
        catch (IOException paramHttpEntity)
        {
          byte[] arrayOfByte;
          this.r = -4;
          throw paramHttpEntity;
        }
        finally
        {
          ((InputStream)localObject1).close();
        }
        i = 0;
        break;
        Object localObject2 = locala;
        if (i != 0)
        {
          localObject2 = locala;
          if (j != 0) {
            localObject2 = new org.b.a.c(null);
          }
        }
        locala = new org.apache.a.b.a.a();
        arrayOfByte = new byte['က'];
        for (;;)
        {
          j = ((InputStream)localObject1).read(arrayOfByte, 0, arrayOfByte.length);
          if ((j == -1) || (locala.a() > 4194304L)) {
            break;
          }
          locala.write(arrayOfByte, 0, j);
          if ((localObject2 != null) && (!((org.b.a.c)localObject2).a())) {
            ((org.b.a.c)localObject2).a(arrayOfByte, 0, j);
          }
        }
        if (localObject2 != null)
        {
          ((org.b.a.c)localObject2).c();
          paramHttpEntity = ((org.b.a.c)localObject2).b();
        }
        if (locala.a() <= 4194304L)
        {
          locala.flush();
          locala.close();
          if (i != 0)
          {
            if (paramHttpEntity != null) {
              break label372;
            }
            paramHttpEntity = "UTF-8";
          }
        }
        for (;;)
        {
          this.b.a(new String(locala.b(), paramHttpEntity));
          i = k;
          break;
          this.b.a(locala.b());
          i = k;
          break;
          locala.close();
          i = 3;
          this.r = -9;
          break;
        }
      }
    }
  }
  
  public static b a(a parama)
  {
    try
    {
      parama.E();
      return parama.e();
    }
    catch (Exception parama)
    {
      com.ideashower.readitlater.util.e.a(parama);
    }
    return null;
  }
  
  public static b a(d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(new a(paramd, null, paramBoolean1, paramBoolean2));
  }
  
  private HttpUriRequest a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      URI localURI = new URI(paramString);
      localURI = new URI(localURI.getScheme(), localURI.getUserInfo(), localURI.getHost(), localURI.getPort(), localURI.getPath(), localURI.getQuery(), null);
      paramString = localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        try
        {
          paramString = new URL(paramString);
          paramString = new URI(paramString.getProtocol(), paramString.getAuthority(), paramString.getPath(), paramString.getQuery(), null);
        }
        catch (MalformedURLException paramString)
        {
          com.ideashower.readitlater.util.e.a(paramString);
          return null;
        }
        catch (URISyntaxException paramString)
        {
          com.ideashower.readitlater.util.e.a(paramString);
          return null;
        }
        paramString = null;
      }
    }
    if (paramString != null)
    {
      paramString = new HttpGet(paramString);
      return paramString;
    }
  }
  
  private void a(HttpUriRequest paramHttpUriRequest)
  {
    Object localObject = l.a(this.c);
    if (localObject != null)
    {
      CookieStore localCookieStore = w.d().getCookieStore();
      String[] arrayOfString = ((String)localObject).split(";");
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        localObject = arrayOfString[i].split("=");
        String str = localObject[0];
        if (localObject.length > 1) {}
        for (localObject = localObject[1];; localObject = null)
        {
          localObject = new HttpCookie(str, (String)localObject);
          ((HttpCookie)localObject).setDomain(g.b(this.c));
          localCookieStore.add(paramHttpUriRequest.getURI(), (HttpCookie)localObject);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.r == 0) {
      this.r = paramInt;
    }
  }
  
  protected int a(HttpResponse paramHttpResponse)
  {
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Length");
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Type");
    if (this.f)
    {
      List localList = w.d().getCookieStore().getCookies();
      this.b.a(localList);
    }
    if (((localHeader != null) && (Integer.parseInt(localHeader.getValue()) > 4194304L)) || ((paramHttpResponse != null) && ((paramHttpResponse.toString().indexOf("video") >= 0) || (paramHttpResponse.toString().indexOf("audio") >= 0))))
    {
      this.r = -10;
      return 3;
    }
    if (paramHttpResponse != null)
    {
      paramHttpResponse = Pattern.compile("([a-z\\-\\_]*/[a-z\\-\\_]*)(?:;\\s*?charset=([a-z\\-\\_0-9]*))?", 2).matcher(paramHttpResponse.toString());
      if (paramHttpResponse.find())
      {
        this.b.c(paramHttpResponse.group(1));
        this.b.b(paramHttpResponse.group(2));
      }
    }
    return 0;
  }
  
  public void a()
  {
    boolean bool2 = false;
    k = 2;
    if ((this.q != null) && (this.q.a_()))
    {
      a(2, -2);
      return;
    }
    if (this.e != null) {}
    for (localHttpUriRequest = this.e; localHttpUriRequest == null; localHttpUriRequest = a(this.c))
    {
      a(2, -5);
      return;
    }
    localHttpUriRequest.setHeader("User-Agent", ax.a(this.g));
    localHttpUriRequest.addHeader("Accept-Encoding", "gzip");
    a(localHttpUriRequest);
    Header localHeader = null;
    HttpEntity localHttpEntity3 = null;
    localHttpEntity2 = localHttpEntity3;
    Object localObject1 = localHeader;
    for (;;)
    {
      try
      {
        localHttpResponse = this.h.execute(localHttpUriRequest);
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHeader;
        localHttpEntity3 = localHttpResponse.getEntity();
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHttpEntity3;
        j = localHttpResponse.getStatusLine().getStatusCode();
        if (localHttpEntity3 == null) {
          continue;
        }
        if (j != 200) {
          continue;
        }
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHttpEntity3;
        if (this.p == null) {
          continue;
        }
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHttpEntity3;
        i = this.p.a(localHttpResponse);
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHttpEntity3;
        this.b.a(localHttpResponse.getAllHeaders());
        j = i;
        if (i != 0) {
          continue;
        }
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHttpEntity3;
        localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
        boolean bool1 = bool2;
        if (localHeader != null)
        {
          bool1 = bool2;
          localHttpEntity2 = localHttpEntity3;
          localObject1 = localHttpEntity3;
          if (localHeader.getValue().equalsIgnoreCase("gzip")) {
            bool1 = true;
          }
        }
        localHttpEntity2 = localHttpEntity3;
        localObject1 = localHttpEntity3;
        i = a(localHttpEntity3, bool1);
      }
      catch (Throwable localThrowable)
      {
        HttpResponse localHttpResponse;
        HttpEntity localHttpEntity1 = localHttpEntity2;
        com.ideashower.readitlater.util.e.a(localThrowable);
        localHttpEntity1 = localHttpEntity2;
        localHttpUriRequest.abort();
        localHttpEntity1 = localHttpEntity2;
        this.r = -3;
        j = k;
        if (localHttpEntity2 == null) {
          continue;
        }
        try
        {
          localHttpEntity2.consumeContent();
          j = k;
        }
        catch (IOException localIOException2)
        {
          com.ideashower.readitlater.util.e.a(localIOException2);
          j = k;
        }
        continue;
      }
      finally
      {
        int j;
        if (localIOException2 == null) {
          continue;
        }
        try
        {
          localIOException2.consumeContent();
          throw ((Throwable)localObject2);
        }
        catch (IOException localIOException3)
        {
          com.ideashower.readitlater.util.e.a(localIOException3);
          continue;
        }
        int i = 0;
        continue;
        switch (j)
        {
        }
        i = 2;
        continue;
      }
      j = i;
      if (localHttpEntity3 != null) {}
      try
      {
        localHttpEntity3.consumeContent();
        j = i;
      }
      catch (IOException localIOException1)
      {
        com.ideashower.readitlater.util.e.a(localIOException1);
        j = i;
        continue;
      }
      a(j);
      return;
      localHttpEntity2 = localHttpEntity3;
      localObject1 = localHttpEntity3;
      i = a(localHttpResponse);
    }
    for (;;)
    {
      localHttpEntity2 = localHttpEntity3;
      localObject1 = localHttpEntity3;
      this.r = j;
      j = i;
      i = j;
      break;
      i = 3;
    }
  }
  
  protected void a(int paramInt)
  {
    a(paramInt, this.r);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    this.r = paramInt2;
    boolean bool1;
    if (paramInt1 == 0)
    {
      bool1 = true;
      label14:
      this.b.a(bool1, paramInt1);
      if (!this.b.f()) {
        break label136;
      }
      if ((this.b.a() == null) || (this.b.a().length() == 0))
      {
        b(-7);
        bool1 = false;
      }
    }
    for (;;)
    {
      if ((!bool1) && (this.a != null)) {
        com.pocket.m.a.e.a(this.a, false);
      }
      if (this.q != null) {
        if (bool1) {}
      }
      switch (this.d)
      {
      default: 
        return;
        b(-6);
        bool1 = false;
        break label14;
        label136:
        if (this.b.b() == null)
        {
          b(-8);
          bool1 = false;
        }
        else if (this.b.b().length > 4194304L)
        {
          b(-9);
          bool1 = false;
        }
        break;
      }
    }
    com.ideashower.readitlater.d.b localb = this.q;
    b localb1 = this.b;
    String str = this.c;
    if (paramInt1 == 3) {}
    for (;;)
    {
      localb.a(bool1, localb1, str, bool2);
      return;
      bool2 = false;
    }
    this.q.a(bool1, this.b, this.a);
    return;
    this.a.b(this.b.d());
    this.q.a(bool1, this.b, this.c, this.a);
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    if (this.q != null)
    {
      this.q = null;
      this.b = null;
    }
    this.h = null;
  }
  
  public b e()
  {
    b localb = this.b;
    this.b = null;
    return localb;
  }
  
  public b e_()
  {
    return new b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */