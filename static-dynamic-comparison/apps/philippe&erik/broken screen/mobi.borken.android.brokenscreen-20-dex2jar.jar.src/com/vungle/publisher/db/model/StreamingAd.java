package com.vungle.publisher.db.model;

import android.database.sqlite.SQLiteDatabase;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class StreamingAd
  extends Ad<StreamingAd, StreamingVideo, RequestStreamingAdResponse>
{
  @Inject
  Factory p;
  
  @Singleton
  public static class Factory
    extends Ad.Factory<StreamingAd, StreamingVideo, RequestStreamingAdResponse>
  {
    @Inject
    Provider<StreamingAd> c;
    @Inject
    StreamingVideo.Factory d;
    
    public final StreamingAd a(RequestStreamingAdResponse paramRequestStreamingAdResponse)
    {
      paramRequestStreamingAdResponse = (StreamingAd)super.a(paramRequestStreamingAdResponse);
      paramRequestStreamingAdResponse.g = Ad.b.b;
      paramRequestStreamingAdResponse.a(Ad.a.e);
      return paramRequestStreamingAdResponse;
    }
    
    public final int c()
    {
      Logger.d("VungleDatabase", "deleting expired " + Ad.b.b + " records without pending reports");
      return this.b.getWritableDatabase().delete("ad", "type = ? AND id NOT IN (SELECT DISTINCT ad_id FROM ad_report)", new String[] { Ad.b.b.toString() });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */