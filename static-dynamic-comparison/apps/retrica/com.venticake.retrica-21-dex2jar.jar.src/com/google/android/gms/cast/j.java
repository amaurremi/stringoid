package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class j
  implements RemoteMediaPlayer.MediaChannelResult
{
  private final Status a;
  private final JSONObject b;
  
  j(Status paramStatus, JSONObject paramJSONObject)
  {
    this.a = paramStatus;
    this.b = paramJSONObject;
  }
  
  public JSONObject getCustomData()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */