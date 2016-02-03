package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.cq;
import com.vungle.publisher.db.model.StreamingAd;
import com.vungle.publisher.db.model.StreamingAdPlay;
import com.vungle.publisher.db.model.StreamingAdReport;
import com.vungle.publisher.db.model.StreamingAdReportEvent;
import com.vungle.publisher.db.model.StreamingVideo;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.protocol.message.ReportStreamingAd;
import com.vungle.publisher.protocol.message.ReportStreamingAd.Factory;
import com.vungle.publisher.protocol.message.RequestStreamingAd;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class ReportStreamingAdHttpRequest
  extends ReportAdHttpRequest
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<ReportStreamingAdHttpRequest>
  {
    @Inject
    ReportStreamingAdHttpRequest.Factory a;
  }
  
  @Singleton
  public static class Factory
    extends ReportAdHttpRequest.Factory<RequestStreamingAd, RequestStreamingAdResponse, ReportStreamingAd, ReportStreamingAdHttpRequest, StreamingAdReport, StreamingAdPlay, StreamingAdReportEvent, StreamingAd, StreamingVideo>
  {
    @Inject
    ReportStreamingAd.Factory f;
    
    protected static ReportStreamingAdHttpRequest f()
    {
      return new ReportStreamingAdHttpRequest();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportStreamingAdHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */