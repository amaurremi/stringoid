package com.vungle.publisher.db.model;

import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class StreamingAdReport
  extends AdReport<StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo, RequestStreamingAdResponse>
{
  @Inject
  Factory l;
  @Inject
  StreamingAdPlay.Factory p;
  
  @Singleton
  public static class Factory
    extends AdReport.Factory<StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo, RequestStreamingAdResponse>
  {
    @Inject
    StreamingAdPlay.Factory a;
    @Inject
    StreamingAd.Factory c;
    @Inject
    Provider<StreamingAdReport> d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */