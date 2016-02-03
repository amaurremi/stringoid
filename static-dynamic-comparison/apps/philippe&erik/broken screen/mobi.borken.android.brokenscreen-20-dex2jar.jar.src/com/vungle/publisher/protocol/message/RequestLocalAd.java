package com.vungle.publisher.protocol.message;

import android.util.Log;
import com.vungle.publisher.cj;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.env.SdkState.a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public final class RequestLocalAd
  extends RequestAd<RequestLocalAd>
{
  String e;
  
  public final JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = super.b();
    localJSONObject.putOpt("lastError", this.e);
    return localJSONObject;
  }
  
  @Singleton
  public static class Factory
    extends RequestAd.a<RequestLocalAd>
  {
    @Inject
    SdkState e;
    
    public final RequestLocalAd c()
    {
      RequestLocalAd localRequestLocalAd = (RequestLocalAd)super.b();
      Throwable[] arrayOfThrowable = (Throwable[])this.e.e.a.a();
      int j = arrayOfThrowable.length;
      Object localObject;
      if (j > 0)
      {
        localObject = new String[j];
        int i = 0;
        while (i < j / 2)
        {
          String str = Log.getStackTraceString(arrayOfThrowable[i]);
          localObject[i] = Log.getStackTraceString(arrayOfThrowable[(j - 1 - i)]);
          localObject[(j - 1 - i)] = str;
          i += 1;
        }
      }
      for (;;)
      {
        if ((localObject != null) && (localObject.length > 0)) {}
        for (localObject = localObject[0];; localObject = null)
        {
          localRequestLocalAd.e = ((String)localObject);
          return localRequestLocalAd;
        }
        localObject = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestLocalAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */