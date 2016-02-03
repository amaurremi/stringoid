package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.cq;
import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAdPlay;
import com.vungle.publisher.db.model.LocalAdReport;
import com.vungle.publisher.db.model.LocalAdReportEvent;
import com.vungle.publisher.db.model.LocalVideo;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.protocol.message.ReportLocalAd;
import com.vungle.publisher.protocol.message.ReportLocalAd.Factory;
import com.vungle.publisher.protocol.message.RequestLocalAd;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class ReportLocalAdHttpRequest
  extends ReportAdHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<ReportLocalAdHttpRequest>
  {
    @Inject
    ReportLocalAdHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ReportAdHttpRequest.Factory<RequestLocalAd, RequestLocalAdResponse, ReportLocalAd, ReportLocalAdHttpRequest, LocalAdReport, LocalAdPlay, LocalAdReportEvent, LocalAd, LocalVideo>
  {
    @Inject
    ReportLocalAd.Factory f;
    
    protected static ReportLocalAdHttpRequest f()
    {
      return new ReportLocalAdHttpRequest();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportLocalAdHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */