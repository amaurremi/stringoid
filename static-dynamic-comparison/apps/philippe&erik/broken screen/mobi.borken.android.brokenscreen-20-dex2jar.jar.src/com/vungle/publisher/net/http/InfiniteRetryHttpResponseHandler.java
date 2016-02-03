package com.vungle.publisher.net.http;

import android.os.Parcelable.Creator;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
public class InfiniteRetryHttpResponseHandler
  extends MaxRetryAgeHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  @Inject
  public InfiniteRetryHttpResponseHandler()
  {
    this.h = 0;
    this.f = 0;
    this.g = 0;
  }
  
  public void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException, JSONException
  {}
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<InfiniteRetryHttpResponseHandler>
  {
    @Inject
    InfiniteRetryHttpResponseHandler a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/InfiniteRetryHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */