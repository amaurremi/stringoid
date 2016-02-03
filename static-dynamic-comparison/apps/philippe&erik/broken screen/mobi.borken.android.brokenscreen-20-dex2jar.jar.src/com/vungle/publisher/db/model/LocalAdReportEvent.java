package com.vungle.publisher.db.model;

import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalAdReportEvent
  extends AdReportEvent<LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo, RequestLocalAdResponse>
{
  @Inject
  Factory e;
  @Inject
  LocalAdPlay.Factory f;
  
  @Singleton
  static class Factory
    extends AdReportEvent.Factory<LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo, RequestLocalAdResponse>
  {
    @Inject
    Provider<LocalAdReportEvent> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdReportEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */