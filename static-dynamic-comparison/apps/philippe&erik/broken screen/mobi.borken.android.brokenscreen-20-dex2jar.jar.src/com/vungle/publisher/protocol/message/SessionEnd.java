package com.vungle.publisher.protocol.message;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

public final class SessionEnd
  extends BaseJsonSerializable
{
  public Long a;
  public SessionStart b;
  
  public final JSONObject b()
    throws JSONException
  {
    if (this.b == null) {}
    for (JSONObject localJSONObject = super.b();; localJSONObject = this.b.b())
    {
      a("end", this.a);
      localJSONObject.put("end", this.a);
      return localJSONObject;
    }
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public SessionStart.Factory a;
    
    public static SessionEnd a()
    {
      return new SessionEnd();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/SessionEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */