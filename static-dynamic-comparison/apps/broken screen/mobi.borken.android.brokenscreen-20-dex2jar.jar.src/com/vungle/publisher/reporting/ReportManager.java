package com.vungle.publisher.reporting;

import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.AdReport;
import com.vungle.publisher.db.model.AdReport.a;
import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAdReport;
import com.vungle.publisher.db.model.LocalAdReport.Factory;
import com.vungle.publisher.db.model.StreamingAd;
import com.vungle.publisher.db.model.StreamingAdReport;
import com.vungle.publisher.db.model.StreamingAdReport.Factory;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import com.vungle.publisher.protocol.ReportAdHttpTransactionFactory;
import com.vungle.publisher.protocol.ReportLocalAdHttpRequest.Factory;
import com.vungle.publisher.protocol.ReportStreamingAdHttpRequest.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ReportManager
{
  @Inject
  public LocalAdReport.Factory a;
  @Inject
  public ProtocolHttpGateway b;
  @Inject
  public SdkState c;
  @Inject
  StreamingAdReport.Factory d;
  
  public final AdReport a(Ad paramAd)
  {
    if ((paramAd instanceof LocalAd)) {
      return a((LocalAd)paramAd);
    }
    if ((paramAd instanceof StreamingAd)) {
      return this.d.a((StreamingAd)paramAd);
    }
    throw new IllegalArgumentException("unknown ad type " + paramAd);
  }
  
  public final LocalAdReport a(LocalAd paramLocalAd)
  {
    return (LocalAdReport)this.a.a(paramLocalAd);
  }
  
  public final void a(AdReport paramAdReport)
  {
    String str = paramAdReport.u();
    try
    {
      Logger.d("VungleReport", "sending " + str);
      ProtocolHttpGateway localProtocolHttpGateway = this.b;
      Object localObject1 = localProtocolHttpGateway.d;
      Object localObject2;
      if ((paramAdReport instanceof LocalAdReport)) {
        localObject2 = (LocalAdReport)paramAdReport;
      }
      for (localObject1 = new HttpTransaction(((ReportAdHttpTransactionFactory)localObject1).b.a((AdReport)localObject2), ((ReportAdHttpTransactionFactory)localObject1).a);; localObject1 = new HttpTransaction(((ReportAdHttpTransactionFactory)localObject1).c.a((AdReport)localObject2), ((ReportAdHttpTransactionFactory)localObject1).a))
      {
        localProtocolHttpGateway.a((HttpTransaction)localObject1);
        return;
        if (!(paramAdReport instanceof StreamingAdReport)) {
          break;
        }
        localObject2 = (StreamingAdReport)paramAdReport;
      }
      throw new UnsupportedOperationException("unknown report type " + paramAdReport);
    }
    catch (Exception localException)
    {
      Logger.e("VungleReport", "error sending " + str, localException);
      paramAdReport.a(AdReport.a.b);
      paramAdReport.l();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/reporting/ReportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */