package com.google.android.gms.cast;

import com.google.android.gms.internal.gi;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MediaStatus
{
  public static final long COMMAND_PAUSE = 1L;
  public static final long COMMAND_SEEK = 2L;
  public static final long COMMAND_SET_VOLUME = 4L;
  public static final long COMMAND_SKIP_BACKWARD = 32L;
  public static final long COMMAND_SKIP_FORWARD = 16L;
  public static final long COMMAND_TOGGLE_MUTE = 8L;
  public static final int IDLE_REASON_CANCELED = 2;
  public static final int IDLE_REASON_ERROR = 4;
  public static final int IDLE_REASON_FINISHED = 1;
  public static final int IDLE_REASON_INTERRUPTED = 3;
  public static final int IDLE_REASON_NONE = 0;
  public static final int PLAYER_STATE_BUFFERING = 4;
  public static final int PLAYER_STATE_IDLE = 1;
  public static final int PLAYER_STATE_PAUSED = 3;
  public static final int PLAYER_STATE_PLAYING = 2;
  public static final int PLAYER_STATE_UNKNOWN = 0;
  private JSONObject AA;
  private MediaInfo AB;
  private long AJ;
  private double AK;
  private int AL;
  private int AM;
  private long AN;
  private long AO;
  private double AP;
  private boolean AQ;
  private long[] AR;
  
  public MediaStatus(JSONObject paramJSONObject)
  {
    a(paramJSONObject, 0);
  }
  
  public int a(JSONObject paramJSONObject, int paramInt)
  {
    int i2 = 2;
    int i1 = 0;
    int n = 1;
    long l = paramJSONObject.getLong("mediaSessionId");
    if (l != this.AJ) {
      this.AJ = l;
    }
    for (int j = 1;; j = 0)
    {
      int k = j;
      Object localObject;
      int i;
      if (paramJSONObject.has("playerState"))
      {
        localObject = paramJSONObject.getString("playerState");
        if (!((String)localObject).equals("IDLE")) {
          break label464;
        }
        i = 1;
      }
      for (;;)
      {
        int m = j;
        if (i != this.AL)
        {
          this.AL = i;
          m = j | 0x2;
        }
        k = m;
        if (i == 1)
        {
          k = m;
          if (paramJSONObject.has("idleReason"))
          {
            localObject = paramJSONObject.getString("idleReason");
            if (!((String)localObject).equals("CANCELLED")) {
              break label512;
            }
            i = i2;
          }
        }
        for (;;)
        {
          label140:
          k = m;
          if (i != this.AM)
          {
            this.AM = i;
            k = m | 0x2;
          }
          i = k;
          double d;
          if (paramJSONObject.has("playbackRate"))
          {
            d = paramJSONObject.getDouble("playbackRate");
            i = k;
            if (this.AK != d)
            {
              this.AK = d;
              i = k | 0x2;
            }
          }
          k = i;
          if (paramJSONObject.has("currentTime"))
          {
            k = i;
            if ((paramInt & 0x2) == 0)
            {
              l = gi.b(paramJSONObject.getDouble("currentTime"));
              k = i;
              if (l != this.AN)
              {
                this.AN = l;
                k = i | 0x2;
              }
            }
          }
          j = k;
          if (paramJSONObject.has("supportedMediaCommands"))
          {
            l = paramJSONObject.getLong("supportedMediaCommands");
            j = k;
            if (l != this.AO)
            {
              this.AO = l;
              j = k | 0x2;
            }
          }
          i = j;
          if (paramJSONObject.has("volume"))
          {
            i = j;
            if ((paramInt & 0x1) == 0)
            {
              localObject = paramJSONObject.getJSONObject("volume");
              d = ((JSONObject)localObject).getDouble("level");
              paramInt = j;
              if (d != this.AP)
              {
                this.AP = d;
                paramInt = j | 0x2;
              }
              boolean bool = ((JSONObject)localObject).getBoolean("muted");
              i = paramInt;
              if (bool != this.AQ)
              {
                this.AQ = bool;
                i = paramInt | 0x2;
              }
            }
          }
          if (paramJSONObject.has("activeTrackIds"))
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("activeTrackIds");
            k = localJSONArray.length();
            localObject = new long[k];
            paramInt = 0;
            for (;;)
            {
              if (paramInt < k)
              {
                localObject[paramInt] = localJSONArray.getLong(paramInt);
                paramInt += 1;
                continue;
                label464:
                if (((String)localObject).equals("PLAYING"))
                {
                  i = 2;
                  break;
                }
                if (((String)localObject).equals("PAUSED"))
                {
                  i = 3;
                  break;
                }
                if (!((String)localObject).equals("BUFFERING")) {
                  break label773;
                }
                i = 4;
                break;
                label512:
                if (((String)localObject).equals("INTERRUPTED"))
                {
                  i = 3;
                  break label140;
                }
                if (((String)localObject).equals("FINISHED"))
                {
                  i = 1;
                  break label140;
                }
                if (!((String)localObject).equals("ERROR")) {
                  break label767;
                }
                i = 4;
                break label140;
              }
            }
            if (this.AR == null) {
              paramInt = n;
            }
          }
          for (;;)
          {
            if (paramInt != 0) {
              this.AR = ((long[])localObject);
            }
            j = paramInt;
            for (;;)
            {
              paramInt = i;
              if (j != 0)
              {
                this.AR = ((long[])localObject);
                paramInt = i | 0x2;
              }
              i = paramInt;
              if (paramJSONObject.has("customData"))
              {
                this.AA = paramJSONObject.getJSONObject("customData");
                i = paramInt | 0x2;
              }
              paramInt = i;
              if (paramJSONObject.has("media"))
              {
                paramJSONObject = paramJSONObject.getJSONObject("media");
                this.AB = new MediaInfo(paramJSONObject);
                i |= 0x2;
                paramInt = i;
                if (paramJSONObject.has("metadata")) {
                  paramInt = i | 0x4;
                }
              }
              return paramInt;
              paramInt = n;
              if (this.AR.length != k) {
                break;
              }
              j = 0;
              for (;;)
              {
                if (j >= k) {
                  break label762;
                }
                paramInt = n;
                if (this.AR[j] != localObject[j]) {
                  break;
                }
                j += 1;
              }
              if (this.AR != null)
              {
                j = 1;
                localObject = null;
              }
              else
              {
                localObject = null;
                j = i1;
              }
            }
            label762:
            paramInt = 0;
          }
          label767:
          i = 0;
        }
        label773:
        i = 0;
      }
    }
  }
  
  public long ea()
  {
    return this.AJ;
  }
  
  public long[] getActiveTrackIds()
  {
    return this.AR;
  }
  
  public JSONObject getCustomData()
  {
    return this.AA;
  }
  
  public int getIdleReason()
  {
    return this.AM;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.AB;
  }
  
  public double getPlaybackRate()
  {
    return this.AK;
  }
  
  public int getPlayerState()
  {
    return this.AL;
  }
  
  public long getStreamPosition()
  {
    return this.AN;
  }
  
  public double getStreamVolume()
  {
    return this.AP;
  }
  
  public boolean isMediaCommandSupported(long paramLong)
  {
    return (this.AO & paramLong) != 0L;
  }
  
  public boolean isMute()
  {
    return this.AQ;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/MediaStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */