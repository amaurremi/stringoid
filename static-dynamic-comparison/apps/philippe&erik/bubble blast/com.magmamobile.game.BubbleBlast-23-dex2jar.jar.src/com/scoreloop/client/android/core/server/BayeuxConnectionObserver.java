package com.scoreloop.client.android.core.server;

import org.json.JSONObject;

abstract interface BayeuxConnectionObserver
{
  public abstract void a(a parama, Integer paramInteger, Object paramObject, String paramString, int paramInt);
  
  public abstract void a(a parama, JSONObject paramJSONObject);
  
  public abstract JSONObject b(a parama, JSONObject paramJSONObject);
  
  public static abstract interface SecureBayeuxConnectionObserver
    extends BayeuxConnectionObserver
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/BayeuxConnectionObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */