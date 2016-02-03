package com.vungle.publisher.protocol;

import android.os.Parcelable.Creator;
import com.vungle.publisher.al;
import com.vungle.publisher.am;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.di;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.net.http.HttpTransaction.a;
import com.vungle.publisher.net.http.MaxRetryAgeHttpResponseHandler;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse.Factory;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
public class RequestStreamingAdHttpResponseHandler
  extends MaxRetryAgeHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  @Inject
  di a;
  @Inject
  RequestStreamingAdResponse.Factory b;
  
  RequestStreamingAdHttpResponseHandler()
  {
    this.g = 1;
    this.f = 1;
  }
  
  protected final void a()
  {
    this.a.b(new al());
  }
  
  protected final void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException, JSONException
  {
    paramHttpTransaction = a(parambv.b);
    paramHttpTransaction = (RequestStreamingAdResponse)this.b.a(paramHttpTransaction);
    this.a.b(new am(paramHttpTransaction));
  }
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<RequestStreamingAdHttpResponseHandler>
  {
    @Inject
    Provider<RequestStreamingAdHttpResponseHandler> a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/RequestStreamingAdHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */