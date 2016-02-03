package com.vungle.publisher.db.model;

import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class StreamingAdReportEvent
  extends AdReportEvent<StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo, RequestStreamingAdResponse>
{
  @Inject
  Factory e;
  
  @Singleton
  static class Factory
    extends AdReportEvent.Factory<StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo, RequestStreamingAdResponse>
  {
    @Inject
    Provider<StreamingAdReportEvent> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/StreamingAdReportEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */