package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.vungle.publisher.ap;
import com.vungle.publisher.as;
import com.vungle.publisher.at.b;
import com.vungle.publisher.cl;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalVideo
  extends Video<LocalAd, LocalVideo, RequestLocalAdResponse>
  implements as
{
  String e;
  public LocalViewableDelegate f;
  @Inject
  LocalAd.Factory g;
  @Inject
  Factory h;
  
  public final boolean A()
  {
    return this.f.f();
  }
  
  public final boolean B()
  {
    return this.f.f();
  }
  
  public final boolean C()
  {
    return this.f.g();
  }
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = super.a(paramBoolean);
    this.f.a(localContentValues);
    localContentValues.put("checksum", this.e);
    return localContentValues;
  }
  
  public final void a(Integer paramInteger)
  {
    this.f.d = paramInteger;
  }
  
  public final String j()
  {
    return this.f.c;
  }
  
  public final String k()
  {
    return "mp4";
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    this.f.a(localStringBuilder);
    cl.a(localStringBuilder, "checksum", this.e);
    return localStringBuilder;
  }
  
  public final Uri q()
  {
    return Uri.parse(this.f.c());
  }
  
  public final String x()
  {
    return this.f.c();
  }
  
  public final void y()
  {
    this.f.d();
  }
  
  public final boolean z()
  {
    return this.f.e();
  }
  
  @Singleton
  public static class Factory
    extends Video.Factory<LocalAd, LocalVideo, RequestLocalAdResponse>
  {
    private static final at.b d = at.b.a;
    @Inject
    Provider<LocalVideo> a;
    @Inject
    LocalViewableDelegate.Factory c;
    
    private LocalVideo a(LocalAd paramLocalAd, RequestLocalAdResponse paramRequestLocalAdResponse)
    {
      paramLocalAd = (LocalVideo)super.b(paramLocalAd, paramRequestLocalAdResponse);
      if (paramLocalAd != null)
      {
        paramLocalAd.e = paramRequestLocalAdResponse.w;
        paramLocalAd.a(paramRequestLocalAdResponse.v);
        paramRequestLocalAdResponse = paramRequestLocalAdResponse.l();
        paramLocalAd.f.c = paramRequestLocalAdResponse;
        paramLocalAd.c = d;
      }
      return paramLocalAd;
    }
    
    private LocalVideo a(LocalVideo paramLocalVideo, Cursor paramCursor, boolean paramBoolean)
    {
      super.a(paramLocalVideo, paramCursor, paramBoolean);
      paramLocalVideo.f.a(paramCursor);
      paramLocalVideo.e = ap.f(paramCursor, "checksum");
      return paramLocalVideo;
    }
    
    private LocalVideo d()
    {
      LocalVideo localLocalVideo = (LocalVideo)this.a.get();
      localLocalVideo.f = this.c.a(localLocalVideo);
      return localLocalVideo;
    }
    
    protected final at.b c()
    {
      return d;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */