package com.vungle.publisher.db.model;

import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class LocalAdPlay
  extends AdPlay<LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo, RequestLocalAdResponse>
{
  @Inject
  Factory e;
  @Inject
  LocalAdReportEvent.Factory f;
  
  @Singleton
  static class Factory
    extends AdPlay.Factory<LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo, RequestLocalAdResponse>
  {
    @Inject
    Provider<LocalAdPlay> a;
    @Inject
    LocalAdReportEvent.Factory c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/LocalAdPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */