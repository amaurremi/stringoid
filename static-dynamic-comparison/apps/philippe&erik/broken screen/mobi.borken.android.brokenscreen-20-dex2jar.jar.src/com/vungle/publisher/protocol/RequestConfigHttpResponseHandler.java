package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.bq;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import com.vungle.publisher.net.http.InfiniteRetryHttpResponseHandler;
import com.vungle.publisher.protocol.message.RequestConfigResponse;
import com.vungle.publisher.protocol.message.RequestConfigResponse.Factory;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

public class RequestConfigHttpResponseHandler
  extends InfiniteRetryHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  @Inject
  RequestConfigResponse.Factory a;
  @Inject
  SdkConfig b;
  @Inject
  Provider<RequestConfigAsync> c;
  
  protected final void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException, JSONException
  {
    super.a(paramHttpTransaction, parambv, parama);
    parambv = (RequestConfigResponse)this.a.a(a(parambv.b));
    paramHttpTransaction = parambv.b;
    if ((paramHttpTransaction != null) && (paramHttpTransaction.intValue() > 0)) {
      ((RequestConfigAsync)this.c.get()).a(paramHttpTransaction.intValue() * 1000);
    }
    paramHttpTransaction = parambv.d;
    if (paramHttpTransaction != null) {}
    boolean bool;
    StringBuilder localStringBuilder;
    switch (1.a[paramHttpTransaction.ordinal()])
    {
    default: 
      Logger.w("VungleNetwork", "unhandled streaming connectivity type " + paramHttpTransaction);
      parama = this.b;
      bool = Boolean.TRUE.equals(parambv.a);
      localStringBuilder = new StringBuilder();
      if (!bool) {
        break;
      }
    }
    for (paramHttpTransaction = "enabling";; paramHttpTransaction = "disabling")
    {
      Logger.d("VungleConfig", paramHttpTransaction + " ad streaming");
      parama.b = bool;
      paramHttpTransaction = parambv.c;
      if (paramHttpTransaction != null) {
        break label240;
      }
      Logger.w("VungleNetwork", "null request streaming ad timeout millis");
      return;
      this.b.a(bq.values());
      break;
      this.b.a(new bq[] { bq.b });
      break;
    }
    label240:
    parambv = this.b;
    int i = paramHttpTransaction.intValue();
    Logger.d("VungleConfig", "setting streaming response timeout " + i + " ms");
    parambv.d = i;
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<RequestConfigHttpResponseHandler>
  {
    @Inject
    Provider<RequestConfigHttpResponseHandler> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestConfigHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */