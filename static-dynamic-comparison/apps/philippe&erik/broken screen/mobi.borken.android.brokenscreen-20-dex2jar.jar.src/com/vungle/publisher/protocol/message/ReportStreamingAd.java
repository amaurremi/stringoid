package com.vungle.publisher.protocol.message;

import com.vungle.publisher.db.model.StreamingAd;
import com.vungle.publisher.db.model.StreamingAdPlay;
import com.vungle.publisher.db.model.StreamingAdReport;
import com.vungle.publisher.db.model.StreamingAdReportEvent;
import com.vungle.publisher.db.model.StreamingVideo;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class ReportStreamingAd
  extends ReportAd<RequestStreamingAd, ReportStreamingAd>
{
  @Singleton
  public static class Factory
    extends ReportAd.Factory<RequestStreamingAd, RequestStreamingAdResponse, ReportStreamingAd, StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo>
  {
    @Inject
    PlayFactory a;
    @Inject
    RequestStreamingAd.Factory b;
    
    @Singleton
    static class PlayFactory
      extends ReportAd.Play.Factory<RequestStreamingAdResponse, StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo>
    {
      @Inject
      UserActionFactory a;
      
      @Singleton
      static class UserActionFactory
        extends ReportAd.Play.UserAction.Factory<RequestStreamingAdResponse, StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo>
      {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportStreamingAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */