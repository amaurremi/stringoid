package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gq;
import org.json.JSONObject;

abstract class i
  extends Cast.a<RemoteMediaPlayer.MediaChannelResult>
{
  gq g = new gq()
  {
    public void a(long paramAnonymousLong, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
    {
      i.this.b(new j(new Status(paramAnonymousInt), paramAnonymousJSONObject));
    }
    
    public void n(long paramAnonymousLong)
    {
      i.this.b(i.this.a(new Status(4)));
    }
  };
  
  public RemoteMediaPlayer.MediaChannelResult a(final Status paramStatus)
  {
    new RemoteMediaPlayer.MediaChannelResult()
    {
      public JSONObject getCustomData()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */