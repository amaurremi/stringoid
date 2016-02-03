package com.vungle.publisher.protocol;

import android.os.Bundle;
import android.os.Parcel;
import com.vungle.publisher.bo;
import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.AdPlay;
import com.vungle.publisher.db.model.AdReport;
import com.vungle.publisher.db.model.AdReportEvent;
import com.vungle.publisher.db.model.Video;
import com.vungle.publisher.net.http.HttpRequest;
import com.vungle.publisher.net.http.HttpRequest.a;
import com.vungle.publisher.net.http.HttpRequest.b;
import com.vungle.publisher.protocol.message.ReportAd;
import com.vungle.publisher.protocol.message.ReportAd.Factory;
import com.vungle.publisher.protocol.message.RequestAd;
import com.vungle.publisher.protocol.message.RequestAdResponse;
import org.json.JSONException;

public abstract class ReportAdHttpRequest
  extends ProtocolHttpRequest
{
  Integer e;
  
  protected final HttpRequest.a a()
  {
    return HttpRequest.a.c;
  }
  
  protected final <T extends HttpRequest> T a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.e = ((Integer)paramParcel.readValue(ReportAdHttpRequest.class.getClassLoader()));
    return this;
  }
  
  protected final HttpRequest.b b()
  {
    return HttpRequest.b.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeValue(this.e);
  }
  
  public static abstract class Factory<Q extends RequestAd<Q>, R extends RequestAdResponse, O extends ReportAd<Q, O>, H extends ReportAdHttpRequest, T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>>
    extends ProtocolHttpRequest.a<H>
  {
    public final H a(T paramT)
      throws bo
    {
      try
      {
        ReportAdHttpRequest localReportAdHttpRequest = (ReportAdHttpRequest)a();
        if (paramT == null) {}
        for (Integer localInteger = null;; localInteger = (Integer)paramT.p())
        {
          localReportAdHttpRequest.e = localInteger;
          localReportAdHttpRequest.b = (this.e + "reportAd");
          localReportAdHttpRequest.c.putString("Content-Type", "application/json");
          paramT = d().a(paramT);
          if (paramT == null) {
            break;
          }
          localReportAdHttpRequest.d = paramT.a();
          return localReportAdHttpRequest;
        }
        return localReportAdHttpRequest;
      }
      catch (JSONException paramT)
      {
        throw new bo(paramT);
      }
    }
    
    protected abstract ReportAd.Factory<Q, R, O, T, P, E, A, V> d();
    
    protected abstract H e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/ReportAdHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */