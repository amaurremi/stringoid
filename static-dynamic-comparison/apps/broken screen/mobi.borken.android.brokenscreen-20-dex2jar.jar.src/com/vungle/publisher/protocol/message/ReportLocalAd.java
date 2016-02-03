package com.vungle.publisher.protocol.message;

import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAdPlay;
import com.vungle.publisher.db.model.LocalAdReport;
import com.vungle.publisher.db.model.LocalAdReportEvent;
import com.vungle.publisher.db.model.LocalVideo;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class ReportLocalAd
  extends ReportAd<RequestLocalAd, ReportLocalAd>
{
  @Singleton
  public static class Factory
    extends ReportAd.Factory<RequestLocalAd, RequestLocalAdResponse, ReportLocalAd, LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo>
  {
    @Inject
    PlayFactory a;
    @Inject
    RequestLocalAd.Factory b;
    
    @Singleton
    static class PlayFactory
      extends ReportAd.Play.Factory<RequestLocalAdResponse, LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo>
    {
      @Inject
      UserActionFactory a;
      
      @Singleton
      static class UserActionFactory
        extends ReportAd.Play.UserAction.Factory<RequestLocalAdResponse, LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo>
      {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportLocalAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */