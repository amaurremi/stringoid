package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.vungle.publisher.ap;
import com.vungle.publisher.at.b;
import com.vungle.publisher.cl;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class StreamingVideo
  extends Video<StreamingAd, StreamingVideo, RequestStreamingAdResponse>
{
  @Inject
  StreamingAd.Factory e;
  @Inject
  Factory f;
  public String g;
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = super.a(paramBoolean);
    localContentValues.put("url", this.g);
    return localContentValues;
  }
  
  protected final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "url", this.g);
    return localStringBuilder;
  }
  
  public final Uri q()
  {
    return Uri.parse(this.g);
  }
  
  @Singleton
  public static class Factory
    extends Video.Factory<StreamingAd, StreamingVideo, RequestStreamingAdResponse>
  {
    private static final at.b c = at.b.d;
    @Inject
    Provider<StreamingVideo> a;
    
    private StreamingVideo a(StreamingAd paramStreamingAd, RequestStreamingAdResponse paramRequestStreamingAdResponse)
    {
      paramStreamingAd = (StreamingVideo)super.b(paramStreamingAd, paramRequestStreamingAdResponse);
      if (paramStreamingAd != null)
      {
        paramStreamingAd.g = paramRequestStreamingAdResponse.l();
        paramStreamingAd.c = c;
      }
      return paramStreamingAd;
    }
    
    private StreamingVideo a(StreamingVideo paramStreamingVideo, Cursor paramCursor, boolean paramBoolean)
    {
      super.a(paramStreamingVideo, paramCursor, paramBoolean);
      paramStreamingVideo.g = ap.f(paramCursor, "url");
      return paramStreamingVideo;
    }
    
    private StreamingVideo d()
    {
      return (StreamingVideo)this.a.get();
    }
    
    protected final at.b c()
    {
      return c;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */