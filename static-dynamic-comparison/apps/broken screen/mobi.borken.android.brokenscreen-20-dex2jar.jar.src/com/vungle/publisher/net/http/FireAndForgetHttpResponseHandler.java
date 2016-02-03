package com.vungle.publisher.net.http;

import android.os.Parcelable.Creator;
import com.vungle.publisher.bv;
import com.vungle.publisher.cq;
import com.vungle.publisher.inject.Injector;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FireAndForgetHttpResponseHandler
  extends MaxRetryAgeHttpResponseHandler
{
  public static final Creator CREATOR = (Creator)Injector.getInstance().a.a(Creator.class);
  
  @Inject
  public FireAndForgetHttpResponseHandler()
  {
    this.g = 1;
    this.f = 10;
  }
  
  public void a(HttpTransaction paramHttpTransaction, bv parambv, HttpTransaction.a parama)
    throws IOException
  {}
  
  @Singleton
  public static class Creator
    implements Parcelable.Creator<FireAndForgetHttpResponseHandler>
  {
    @Inject
    FireAndForgetHttpResponseHandler a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/http/FireAndForgetHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */