package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.ap;
import com.vungle.publisher.as;
import com.vungle.publisher.at.a;
import com.vungle.publisher.at.b;
import com.vungle.publisher.bc;
import com.vungle.publisher.bj;
import com.vungle.publisher.bk;
import com.vungle.publisher.bw;
import com.vungle.publisher.cl;
import com.vungle.publisher.di;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.DownloadHttpGateway;
import com.vungle.publisher.net.http.DownloadHttpRequest;
import com.vungle.publisher.net.http.DownloadHttpRequest.Factory;
import com.vungle.publisher.net.http.DownloadHttpResponseHandler;
import com.vungle.publisher.net.http.DownloadHttpResponseHandler.Factory;
import com.vungle.publisher.net.http.DownloadHttpTransactionFactory;
import com.vungle.publisher.net.http.HttpTransaction;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalViewableDelegate
{
  as a;
  at.b b;
  public String c;
  Integer d;
  @Inject
  DownloadHttpGateway e;
  @Inject
  bc f;
  @Inject
  di g;
  
  private String h()
  {
    return this.a.f();
  }
  
  private at.b i()
  {
    return this.a.i();
  }
  
  final String a()
  {
    return ((LocalAd)this.a.g()).q();
  }
  
  final void a(ContentValues paramContentValues)
  {
    paramContentValues.put("url", this.c);
    paramContentValues.put("size", this.d);
  }
  
  final void a(Cursor paramCursor)
  {
    this.c = ap.f(paramCursor, "url");
    this.d = ap.c(paramCursor, "size");
  }
  
  final void a(StringBuilder paramStringBuilder)
  {
    cl.a(paramStringBuilder, "url", this.c);
    cl.a(paramStringBuilder, "size", this.d);
  }
  
  final File b()
  {
    String str = c();
    if (str == null) {
      return null;
    }
    return new File(str);
  }
  
  final String c()
  {
    return bk.a(new Object[] { a(), i() + "." + this.a.k() });
  }
  
  final void d()
  {
    Logger.d("VunglePrepare", "downloading " + this.b + " for ad_id " + h());
    this.a.a(at.a.b);
    DownloadHttpGateway localDownloadHttpGateway = this.e;
    Object localObject2 = this.a;
    Object localObject1 = localDownloadHttpGateway.a;
    String str1 = ((as)localObject2).f();
    at.b localb = ((as)localObject2).i();
    String str2 = ((as)localObject2).j();
    localObject2 = ((as)localObject2).x();
    DownloadHttpRequest localDownloadHttpRequest = (DownloadHttpRequest)((DownloadHttpTransactionFactory)localObject1).a.c();
    localDownloadHttpRequest.b = str2;
    localObject1 = (DownloadHttpResponseHandler)((DownloadHttpTransactionFactory)localObject1).b.a.get();
    ((DownloadHttpResponseHandler)localObject1).a = str1;
    ((DownloadHttpResponseHandler)localObject1).b = ((String)localObject2);
    ((DownloadHttpResponseHandler)localObject1).c = localb;
    localDownloadHttpGateway.a(new HttpTransaction(localDownloadHttpRequest, (bw)localObject1));
  }
  
  final boolean e()
  {
    boolean bool = this.a.A();
    if (bool)
    {
      at.a locala = at.a.d;
      Logger.i("VunglePrepare", i() + " " + locala + " for ad_id " + h());
      this.a.a(locala);
      return bool;
    }
    this.a.a(at.a.a);
    return bool;
  }
  
  final boolean f()
    throws bj
  {
    boolean bool = this.a.C();
    Object localObject = h();
    at.b localb = i();
    if (bool) {
      Logger.i("VunglePrepare", localb + " verified for ad_id " + (String)localObject);
    }
    for (localObject = at.a.d;; localObject = at.a.a)
    {
      this.a.a((at.a)localObject);
      return bool;
      Logger.w("VunglePrepare", localb + " failed verification; reprocessing ad_id " + (String)localObject);
    }
  }
  
  final boolean g()
    throws bj
  {
    if (!this.f.g()) {
      throw new bj();
    }
    Object localObject = h();
    at.b localb = i();
    if (this.d == null) {
      Logger.w("VunglePrepare", localb + " size " + this.d + " for ad_id: " + (String)localObject);
    }
    for (;;)
    {
      return false;
      File localFile = b();
      if (localFile == null) {}
      for (int i = 0; i == this.d.intValue(); i = (int)localFile.length())
      {
        Logger.d("VunglePrepare", localb + " disk size matched size " + this.d + " for ad_id: " + (String)localObject);
        return true;
      }
      Logger.d("VunglePrepare", localb + " disk size " + i + " failed to match size " + this.d + " for ad_id: " + (String)localObject);
      localObject = b();
      if (localObject == null)
      {
        Logger.w("VunglePrepare", "null " + this.b + " file for ad " + h());
        i = 0;
      }
      while (i != 0)
      {
        Logger.d("VunglePrepare", "ignoring " + localb + " size mismatch - file exists");
        return true;
        if (((File)localObject).exists())
        {
          Logger.v("VunglePrepare", localObject + " exists, " + ((File)localObject).length() + " bytes");
          i = 1;
        }
        else
        {
          Logger.d("VunglePrepare", localObject + " missing ");
          i = 0;
        }
      }
    }
  }
  
  @Singleton
  static class Factory
  {
    @Inject
    Provider<LocalViewableDelegate> a;
    
    final LocalViewableDelegate a(as paramas)
    {
      LocalViewableDelegate localLocalViewableDelegate = (LocalViewableDelegate)this.a.get();
      localLocalViewableDelegate.a = paramas;
      return localLocalViewableDelegate;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalViewableDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */