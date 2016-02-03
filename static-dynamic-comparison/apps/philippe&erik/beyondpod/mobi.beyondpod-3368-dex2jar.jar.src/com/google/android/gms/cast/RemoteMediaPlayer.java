package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.dn;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer
  implements Cast.MessageReceivedCallback
{
  public static final int RESUME_STATE_PAUSE = 2;
  public static final int RESUME_STATE_PLAY = 1;
  public static final int RESUME_STATE_UNCHANGED = 0;
  public static final int STATUS_CANCELED = 2;
  public static final int STATUS_FAILED = 1;
  public static final int STATUS_REPLACED = 4;
  public static final int STATUS_SUCCEEDED = 0;
  public static final int STATUS_TIMED_OUT = 3;
  private final Object fx = new Object();
  private final dl ld = new dl()
  {
    protected void onMetadataUpdated()
    {
      RemoteMediaPlayer.b(RemoteMediaPlayer.this);
    }
    
    protected void onStatusUpdated()
    {
      RemoteMediaPlayer.a(RemoteMediaPlayer.this);
    }
  };
  private final a le = new a();
  private OnMetadataUpdatedListener lf;
  private OnStatusUpdatedListener lg;
  
  public RemoteMediaPlayer()
  {
    this.ld.a(this.le);
  }
  
  private void onMetadataUpdated()
  {
    if (this.lf != null) {
      this.lf.onMetadataUpdated();
    }
  }
  
  private void onStatusUpdated()
  {
    if (this.lg != null) {
      this.lg.onStatusUpdated();
    }
  }
  
  public long getApproximateStreamPosition()
  {
    synchronized (this.fx)
    {
      long l = this.ld.getApproximateStreamPosition();
      return l;
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    synchronized (this.fx)
    {
      MediaInfo localMediaInfo = this.ld.getMediaInfo();
      return localMediaInfo;
    }
  }
  
  public MediaStatus getMediaStatus()
  {
    synchronized (this.fx)
    {
      MediaStatus localMediaStatus = this.ld.getMediaStatus();
      return localMediaStatus;
    }
  }
  
  public String getNamespace()
  {
    return this.ld.getNamespace();
  }
  
  public long getStreamDuration()
  {
    synchronized (this.fx)
    {
      long l = this.ld.getStreamDuration();
      return l;
    }
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo)
  {
    return load(paramGoogleApiClient, paramMediaInfo, true, 0L, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, 0L, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, paramLong, null);
  }
  
  public PendingResult<MediaChannelResult> load(final GoogleApiClient paramGoogleApiClient, final MediaInfo paramMediaInfo, final boolean paramBoolean, final long paramLong, JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(dg arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.lv, paramMediaInfo, paramBoolean, paramLong, this.lm);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void onMessageReceived(CastDevice paramCastDevice, String paramString1, String paramString2)
  {
    this.ld.B(paramString2);
  }
  
  public void pause(GoogleApiClient paramGoogleApiClient)
    throws IOException
  {
    pause(paramGoogleApiClient, null);
  }
  
  public void pause(GoogleApiClient paramGoogleApiClient, JSONObject paramJSONObject)
    throws IOException
  {
    synchronized (this.fx)
    {
      this.le.b(paramGoogleApiClient);
      try
      {
        this.ld.c(paramJSONObject);
        this.le.b(null);
        return;
      }
      finally
      {
        paramGoogleApiClient = finally;
        this.le.b(null);
        throw paramGoogleApiClient;
      }
    }
  }
  
  public void play(GoogleApiClient paramGoogleApiClient)
    throws IOException, IllegalStateException
  {
    play(paramGoogleApiClient, null);
  }
  
  public void play(GoogleApiClient paramGoogleApiClient, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    synchronized (this.fx)
    {
      this.le.b(paramGoogleApiClient);
      try
      {
        this.ld.e(paramJSONObject);
        this.le.b(null);
        return;
      }
      finally
      {
        paramGoogleApiClient = finally;
        this.le.b(null);
        throw paramGoogleApiClient;
      }
    }
  }
  
  public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(dg arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.lv);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong)
  {
    return seek(paramGoogleApiClient, paramLong, 0, null);
  }
  
  public PendingResult<MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong, int paramInt)
  {
    return seek(paramGoogleApiClient, paramLong, paramInt, null);
  }
  
  public PendingResult<MediaChannelResult> seek(final GoogleApiClient paramGoogleApiClient, final long paramLong, int paramInt, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(dg arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.lv, paramLong, paramJSONObject, this.lm);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener paramOnMetadataUpdatedListener)
  {
    this.lf = paramOnMetadataUpdatedListener;
  }
  
  public void setOnStatusUpdatedListener(OnStatusUpdatedListener paramOnStatusUpdatedListener)
  {
    this.lg = paramOnStatusUpdatedListener;
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return setStreamMute(paramGoogleApiClient, paramBoolean, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b()
    {
      protected void a(dg arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.lv, paramBoolean, paramJSONObject);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient paramGoogleApiClient, double paramDouble)
    throws IllegalArgumentException
  {
    return setStreamVolume(paramGoogleApiClient, paramDouble, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamVolume(final GoogleApiClient paramGoogleApiClient, final double paramDouble, JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    paramGoogleApiClient.b(new b()
    {
      protected void a(dg arg1)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.lv, paramDouble, this.lm);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              a(k(new Status(1)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void stop(GoogleApiClient paramGoogleApiClient)
    throws IOException
  {
    stop(paramGoogleApiClient, null);
  }
  
  public void stop(GoogleApiClient paramGoogleApiClient, JSONObject paramJSONObject)
    throws IOException
  {
    synchronized (this.fx)
    {
      this.le.b(paramGoogleApiClient);
      try
      {
        this.ld.d(paramJSONObject);
        this.le.b(null);
        return;
      }
      finally
      {
        paramGoogleApiClient = finally;
        this.le.b(null);
        throw paramGoogleApiClient;
      }
    }
  }
  
  public static abstract interface MediaChannelResult
    extends Result
  {}
  
  public static abstract interface OnMetadataUpdatedListener
  {
    public abstract void onMetadataUpdated();
  }
  
  public static abstract interface OnStatusUpdatedListener
  {
    public abstract void onStatusUpdated();
  }
  
  private class a
    implements dm
  {
    private GoogleApiClient lr;
    private long ls = 0L;
    
    public a() {}
    
    public void a(String paramString1, String paramString2, long paramLong, String paramString3)
      throws IOException
    {
      if (this.lr == null) {
        throw new IOException("No GoogleApiClient available");
      }
      Cast.CastApi.sendMessage(this.lr, paramString1, paramString2).setResultCallback(new a(paramLong));
    }
    
    public long aR()
    {
      long l = this.ls + 1L;
      this.ls = l;
      return l;
    }
    
    public void b(GoogleApiClient paramGoogleApiClient)
    {
      this.lr = paramGoogleApiClient;
    }
    
    private final class a
      implements ResultCallback<Status>
    {
      private final long lt;
      
      a(long paramLong)
      {
        this.lt = paramLong;
      }
      
      public void j(Status paramStatus)
      {
        if (!paramStatus.isSuccess()) {
          RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.lt, paramStatus.getStatusCode());
        }
      }
    }
  }
  
  private static abstract class b
    extends Cast.a<RemoteMediaPlayer.MediaChannelResult>
  {
    dn lv = new dn()
    {
      public void a(long paramAnonymousLong, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        RemoteMediaPlayer.b.this.a(new RemoteMediaPlayer.c(new Status(paramAnonymousInt), paramAnonymousJSONObject));
      }
      
      public void g(long paramAnonymousLong)
      {
        RemoteMediaPlayer.b.this.a(RemoteMediaPlayer.b.this.k(new Status(4)));
      }
    };
    
    public RemoteMediaPlayer.MediaChannelResult k(final Status paramStatus)
    {
      new RemoteMediaPlayer.MediaChannelResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static final class c
    implements RemoteMediaPlayer.MediaChannelResult
  {
    private final Status jY;
    private final JSONObject kM;
    
    c(Status paramStatus, JSONObject paramJSONObject)
    {
      this.jY = paramStatus;
      this.kM = paramJSONObject;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/cast/RemoteMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */