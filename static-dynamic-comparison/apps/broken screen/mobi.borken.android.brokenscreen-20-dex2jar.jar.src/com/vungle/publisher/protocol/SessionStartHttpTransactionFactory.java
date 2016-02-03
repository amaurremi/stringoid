package com.vungle.publisher.protocol;

import com.vungle.publisher.net.http.FireAndForgetHttpResponseHandler;
import com.vungle.publisher.net.http.HttpTransaction;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
public class SessionStartHttpTransactionFactory
{
  @Inject
  SessionStartHttpRequest.Factory a;
  @Inject
  FireAndForgetHttpResponseHandler b;
  
  public final HttpTransaction a(long paramLong)
    throws JSONException
  {
    return new HttpTransaction(this.a.a(paramLong), this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/SessionStartHttpTransactionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */