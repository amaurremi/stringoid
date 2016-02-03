package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dl
  extends df
{
  private static final long me = TimeUnit.SECONDS.toMillis(3L);
  private static final long mf = TimeUnit.HOURS.toMillis(24L);
  private static final long mg = TimeUnit.SECONDS.toMillis(5L);
  private static final long mh = TimeUnit.SECONDS.toMillis(1L);
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private long mi;
  private MediaStatus mj;
  private final do mk = new do(mf);
  private final do ml = new do(mg);
  private final do mm = new do(me);
  private final do mn = new do(me);
  private final do mo = new do(me);
  private final Runnable mp = new a(null);
  private boolean mq;
  
  public dl()
  {
    super("urn:x-cast:com.google.cast.media", "MediaControlChannel");
    bd();
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    int k = 1;
    boolean bool = this.mk.i(paramLong);
    int j;
    if ((this.ml.bf()) && (!this.ml.i(paramLong)))
    {
      i = 1;
      if (this.mm.bf())
      {
        j = k;
        if (!this.mm.i(paramLong)) {}
      }
      else
      {
        if ((!this.mn.bf()) || (this.mn.i(paramLong))) {
          break label249;
        }
        j = k;
      }
      label87:
      if (i == 0) {
        break label270;
      }
    }
    label249:
    label270:
    for (int i = 2;; i = 0)
    {
      k = i;
      if (j != 0) {
        k = i | 0x1;
      }
      if ((bool) || (this.mj == null))
      {
        this.mj = new MediaStatus(paramJSONObject);
        this.mi = SystemClock.elapsedRealtime();
      }
      for (i = 7;; i = this.mj.a(paramJSONObject, k))
      {
        if ((i & 0x1) != 0)
        {
          this.mi = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x2) != 0)
        {
          this.mi = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x4) != 0) {
          onMetadataUpdated();
        }
        this.mk.c(paramLong, 0);
        this.ml.c(paramLong, 0);
        this.mm.c(paramLong, 0);
        this.mn.c(paramLong, 0);
        this.mo.c(paramLong, 0);
        return;
        i = 0;
        break;
        j = 0;
        break label87;
      }
    }
  }
  
  private void bd()
  {
    o(false);
    this.mi = 0L;
    this.mj = null;
    this.mk.clear();
    this.ml.clear();
    this.mm.clear();
  }
  
  private void o(boolean paramBoolean)
  {
    if (this.mq != paramBoolean)
    {
      this.mq = paramBoolean;
      if (paramBoolean) {
        this.mHandler.postDelayed(this.mp, mh);
      }
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.mp);
  }
  
  public final void B(String paramString)
  {
    this.lx.b("message received: %s", new Object[] { paramString });
    String str;
    long l;
    try
    {
      Object localObject = new JSONObject(paramString);
      str = ((JSONObject)localObject).getString("type");
      l = ((JSONObject)localObject).optLong("requestId", -1L);
      if (str.equals("MEDIA_STATUS"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("status");
        if (((JSONArray)localObject).length() > 0)
        {
          a(l, ((JSONArray)localObject).getJSONObject(0));
          return;
        }
        this.mj = null;
        onStatusUpdated();
        onMetadataUpdated();
        this.mo.c(l, 0);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      this.lx.d("Message is malformed (%s); ignoring: %s", new Object[] { localJSONException.getMessage(), paramString });
      return;
    }
    JSONObject localJSONObject;
    if (str.equals("INVALID_PLAYER_STATE"))
    {
      this.lx.d("received unexpected error: Invalid Player State.", new Object[0]);
      localJSONObject = localJSONException.optJSONObject("customData");
      this.mk.b(l, 1, localJSONObject);
      this.ml.b(l, 1, localJSONObject);
      this.mm.b(l, 1, localJSONObject);
      this.mn.b(l, 1, localJSONObject);
      this.mo.b(l, 1, localJSONObject);
      return;
    }
    if (str.equals("LOAD_FAILED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.mk.b(l, 1, localJSONObject);
      return;
    }
    if (str.equals("LOAD_CANCELLED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.mk.b(l, 2, localJSONObject);
      return;
    }
    if (str.equals("INVALID_REQUEST"))
    {
      this.lx.d("received unexpected error: Invalid Request.", new Object[0]);
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.mk.b(l, 1, localJSONObject);
      this.ml.b(l, 1, localJSONObject);
      this.mm.b(l, 1, localJSONObject);
      this.mn.b(l, 1, localJSONObject);
      this.mo.b(l, 1, localJSONObject);
    }
  }
  
  public long a(dn paramdn)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    this.mo.a(l, paramdn);
    o(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.mj != null) {
        localJSONObject.put("mediaSessionId", this.mj.aQ());
      }
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException paramdn)
    {
      for (;;) {}
    }
  }
  
  public long a(dn paramdn, double paramDouble, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    this.mm.a(l, paramdn);
    o(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", aQ());
      paramdn = new JSONObject();
      paramdn.put("level", paramDouble);
      localJSONObject.put("volume", paramdn);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramdn)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(dn paramdn, long paramLong, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    this.ml.a(l, paramdn);
    o(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "SEEK");
        localJSONObject.put("mediaSessionId", aQ());
        localJSONObject.put("currentTime", dh.h(paramLong));
        if (paramInt != 1) {
          continue;
        }
        localJSONObject.put("resumeState", "PLAYBACK_START");
        if (paramJSONObject != null) {
          localJSONObject.put("customData", paramJSONObject);
        }
      }
      catch (JSONException paramdn)
      {
        continue;
      }
      a(localJSONObject.toString(), l, null);
      return l;
      if (paramInt == 2) {
        localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
      }
    }
  }
  
  public long a(dn paramdn, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    this.mk.a(l, paramdn);
    o(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.aP());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", dh.h(paramLong));
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramdn)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(dn paramdn, boolean paramBoolean, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    this.mn.a(l, paramdn);
    o(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", aQ());
      paramdn = new JSONObject();
      paramdn.put("muted", paramBoolean);
      localJSONObject.put("volume", paramdn);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramdn)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.mk.c(paramLong, paramInt);
    this.ml.c(paramLong, paramInt);
    this.mm.c(paramLong, paramInt);
    this.mn.c(paramLong, paramInt);
    this.mo.c(paramLong, paramInt);
  }
  
  public long aQ()
    throws IllegalStateException
  {
    if (this.mj == null) {
      throw new IllegalStateException("No current media session");
    }
    return this.mj.aQ();
  }
  
  public void aT()
  {
    bd();
  }
  
  public void c(JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", aQ());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
  }
  
  public void d(JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", aQ());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
  }
  
  public void e(JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = aS();
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", aQ());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
    a(localJSONObject.toString(), l, null);
  }
  
  public long getApproximateStreamPosition()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo == null) {}
    while (this.mi == 0L) {
      return 0L;
    }
    double d = this.mj.getPlaybackRate();
    long l3 = this.mj.getStreamPosition();
    int i = this.mj.getPlayerState();
    if ((d == 0.0D) || (i != 2)) {
      return l3;
    }
    long l1 = SystemClock.elapsedRealtime() - this.mi;
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      if (l1 == 0L) {
        return l3;
      }
      long l2 = localMediaInfo.getStreamDuration();
      l1 = l3 + (l1 * d);
      if (l1 > l2) {
        l1 = l2;
      }
      for (;;)
      {
        return l1;
        if (l1 < 0L) {
          l1 = 0L;
        }
      }
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    if (this.mj == null) {
      return null;
    }
    return this.mj.getMediaInfo();
  }
  
  public MediaStatus getMediaStatus()
  {
    return this.mj;
  }
  
  public long getStreamDuration()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo != null) {
      return localMediaInfo.getStreamDuration();
    }
    return 0L;
  }
  
  protected void onMetadataUpdated() {}
  
  protected void onStatusUpdated() {}
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      boolean bool = false;
      dl.a(dl.this, false);
      long l = SystemClock.elapsedRealtime();
      dl.a(dl.this).d(l, 3);
      dl.b(dl.this).d(l, 3);
      dl.c(dl.this).d(l, 3);
      dl.d(dl.this).d(l, 3);
      dl.e(dl.this).d(l, 3);
      for (;;)
      {
        synchronized (do.mw)
        {
          if ((!dl.a(dl.this).bf()) && (!dl.b(dl.this).bf()) && (!dl.c(dl.this).bf()) && (!dl.d(dl.this).bf()) && (!dl.e(dl.this).bf()))
          {
            dl.b(dl.this, bool);
            return;
          }
        }
        bool = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */