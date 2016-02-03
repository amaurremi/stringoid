package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ck
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private final ey lL;
  private final MediaController oG;
  private final a oH;
  private final VideoView oI;
  private long oJ;
  private String oK;
  
  public ck(Context paramContext, ey paramey)
  {
    super(paramContext);
    this.lL = paramey;
    this.oI = new VideoView(paramContext);
    paramey = new FrameLayout.LayoutParams(-1, -1, 17);
    addView(this.oI, paramey);
    this.oG = new MediaController(paramContext);
    this.oH = new a(this);
    this.oH.aX();
    this.oI.setOnCompletionListener(this);
    this.oI.setOnPreparedListener(this);
    this.oI.setOnErrorListener(this);
  }
  
  private static void a(ey paramey, String paramString)
  {
    a(paramey, paramString, new HashMap(1));
  }
  
  public static void a(ey paramey, String paramString1, String paramString2)
  {
    int i;
    if (paramString2 == null)
    {
      i = 1;
      if (i == 0) {
        break label60;
      }
    }
    label60:
    for (int j = 2;; j = 3)
    {
      HashMap localHashMap = new HashMap(j);
      localHashMap.put("what", paramString1);
      if (i == 0) {
        localHashMap.put("extra", paramString2);
      }
      a(paramey, "error", localHashMap);
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(ey paramey, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put(paramString2, paramString3);
    a(paramey, paramString1, localHashMap);
  }
  
  private static void a(ey paramey, String paramString, Map<String, String> paramMap)
  {
    paramMap.put("event", paramString);
    paramey.a("onVideoEvent", paramMap);
  }
  
  public void aV()
  {
    if (!TextUtils.isEmpty(this.oK))
    {
      this.oI.setVideoPath(this.oK);
      return;
    }
    a(this.lL, "no_src", null);
  }
  
  public void aW()
  {
    long l = this.oI.getCurrentPosition();
    if (this.oJ != l)
    {
      float f = (float)l / 1000.0F;
      a(this.lL, "timeupdate", "time", String.valueOf(f));
      this.oJ = l;
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.oI.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void destroy()
  {
    this.oH.cancel();
    this.oI.stopPlayback();
  }
  
  public void l(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oI.setMediaController(this.oG);
      return;
    }
    this.oG.hide();
    this.oI.setMediaController(null);
  }
  
  public void o(String paramString)
  {
    this.oK = paramString;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a(this.lL, "ended");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(this.lL, String.valueOf(paramInt1), String.valueOf(paramInt2));
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    float f = this.oI.getDuration() / 1000.0F;
    a(this.lL, "canplaythrough", "duration", String.valueOf(f));
  }
  
  public void pause()
  {
    this.oI.pause();
  }
  
  public void play()
  {
    this.oI.start();
  }
  
  public void seekTo(int paramInt)
  {
    this.oI.seekTo(paramInt);
  }
  
  private static final class a
  {
    private final Runnable le;
    private volatile boolean oL = false;
    
    public a(final ck paramck)
    {
      this.le = new Runnable()
      {
        private final WeakReference<ck> oM = new WeakReference(paramck);
        
        public void run()
        {
          ck localck = (ck)this.oM.get();
          if ((!ck.a.a(ck.a.this)) && (localck != null))
          {
            localck.aW();
            ck.a.this.aX();
          }
        }
      };
    }
    
    public void aX()
    {
      eu.ss.postDelayed(this.le, 250L);
    }
    
    public void cancel()
    {
      this.oL = true;
      eu.ss.removeCallbacks(this.le);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */