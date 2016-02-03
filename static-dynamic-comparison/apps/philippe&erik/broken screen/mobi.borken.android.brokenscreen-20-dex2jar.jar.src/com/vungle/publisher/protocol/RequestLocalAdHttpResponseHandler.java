package com.vungle.publisher.protocol;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.ad.AdPreparer;
import com.vungle.publisher.ai;
import com.vungle.publisher.an;
import com.vungle.publisher.bj;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAd.Factory;
import com.vungle.publisher.di;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse;
import com.vungle.publisher.protocol.message.RequestLocalAdResponse.Factory;
import com.vungle.publisher.reporting.AdServiceReportingHandler;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
public class RequestLocalAdHttpResponseHandler
  extends InfiniteRetryHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  @Inject
  AdManager a;
  @Inject
  AdPreparer b;
  @Inject
  SdkState c;
  @Inject
  di d;
  @Inject
  RequestLocalAdResponse.Factory e;
  @Inject
  AdServiceReportingHandler i;
  
  protected final void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException, JSONException
  {
    parambv = a(parambv.b);
    RequestLocalAdResponse localRequestLocalAdResponse = (RequestLocalAdResponse)this.e.a(parambv);
    Object localObject;
    if (localRequestLocalAdResponse.r == null)
    {
      parambv = null;
      localObject = this.i;
      ((AdServiceReportingHandler)localObject).b = (SystemClock.elapsedRealtime() - ((AdServiceReportingHandler)localObject).a);
      if (parambv != null) {
        break label439;
      }
      paramHttpTransaction = this.a;
      parambv = localRequestLocalAdResponse.f();
      parama = (LocalAd)paramHttpTransaction.e.a(parambv, true);
      if (parama != null) {
        break label220;
      }
    }
    for (;;)
    {
      try
      {
        parama = paramHttpTransaction.e.a(localRequestLocalAdResponse);
        Logger.i("VunglePrepare", "received new " + parama.u());
        parama.k();
        paramHttpTransaction.e.e();
        paramHttpTransaction.b.a(parambv);
        paramHttpTransaction = this.c;
        parambv = localRequestLocalAdResponse.a();
        if (parambv != null) {
          break label387;
        }
        Logger.v("VungleAd", "ignoring set null min ad delay seconds");
        return;
        parambv = Integer.valueOf(localRequestLocalAdResponse.r.intValue() * 1000);
      }
      catch (bj parama)
      {
        Logger.w("VunglePrepare", "error preparing ad " + parambv, parama);
        paramHttpTransaction.d.b(new ai());
        continue;
      }
      try
      {
        label220:
        paramHttpTransaction.e.a(parama, localRequestLocalAdResponse);
        localObject = parama.h();
        switch (com.vungle.publisher.ad.AdManager.1.a[localObject.ordinal()])
        {
        default: 
          Logger.w("VunglePrepare", "received " + parama.u() + " in status " + localObject + " - ignoring");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.w("VunglePrepare", "error updating ad " + parambv, localException);
        }
        Logger.i("VunglePrepare", "received " + parama.u() + " in status " + localException);
        paramHttpTransaction.b.a(parambv);
      }
    }
    label387:
    int j = parambv.intValue();
    Logger.d("VungleAd", "setting min ad delay seconds: " + j);
    paramHttpTransaction.h.edit().putInt("VgAdDelayDuration", j).apply();
    return;
    label439:
    parama.a(paramHttpTransaction, parambv.intValue());
  }
  
  protected final void b()
  {
    this.d.b(new an());
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<RequestLocalAdHttpResponseHandler>
  {
    @Inject
    Provider<RequestLocalAdHttpResponseHandler> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestLocalAdHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */