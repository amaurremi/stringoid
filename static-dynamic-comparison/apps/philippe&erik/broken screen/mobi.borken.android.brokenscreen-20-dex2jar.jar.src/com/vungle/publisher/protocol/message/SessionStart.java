package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bc;
import com.vungle.publisher.be;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public final class SessionStart
  extends BaseJsonSerializable
{
  String a;
  String b;
  Long c;
  
  public final JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = super.b();
    a("isu", this.a);
    localJSONObject.putOpt("isu", this.a);
    a("pubAppId", this.b);
    localJSONObject.put("pubAppId", this.b);
    a("start", this.c);
    localJSONObject.put("start", this.c);
    return localJSONObject;
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    bc a;
    @Inject
    be b;
    
    public final SessionStart a(long paramLong)
    {
      SessionStart localSessionStart = new SessionStart();
      localSessionStart.c = Long.valueOf(paramLong);
      localSessionStart.a = this.a.a();
      localSessionStart.b = this.b.b();
      return localSessionStart;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/SessionStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */