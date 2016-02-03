package com.inmobi.re.controller.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.JSController.Dimensions;
import com.inmobi.re.controller.JSController.PlayerProperties;
import java.lang.ref.WeakReference;

public class AVPlayer
  extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  public static final int MINIMAL_LAYOUT_PARAM = 1;
  private static String f = "play";
  private static String g = "pause";
  private static String h = "ended";
  private static int i = -1;
  private static int j = 2;
  private static String k = "Loading. Please Wait..";
  private JSController.PlayerProperties a;
  private AVPlayerListener b;
  private String c;
  private int d = 0;
  private RelativeLayout e;
  private boolean l = false;
  private boolean m = false;
  private IMWebView n;
  private Bitmap o = null;
  private int p;
  public boolean pseudoPause = false;
  private int q = -1;
  private playerState r;
  private MediaPlayer s;
  private boolean t;
  private ViewGroup u;
  private JSController.Dimensions v;
  private b w = new b(this);
  
  private AVPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public AVPlayer(Context paramContext, IMWebView paramIMWebView)
  {
    this(paramContext);
    setZOrderOnTop(true);
    this.r = playerState.INIT;
    setDrawingCacheEnabled(true);
    this.n = paramIMWebView;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.p = 100;
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      StringBuffer localStringBuffer = new StringBuffer();
      int i1 = 0;
      for (;;)
      {
        if (i1 < paramString.length)
        {
          if ((paramString[i1] & 0x80) > 0) {
            localStringBuffer.append("%" + UIDHelper.byteToHex(paramString[i1]));
          } else {
            localStringBuffer.append((char)paramString[i1]);
          }
        }
        else
        {
          paramString = new String(localStringBuffer.toString().getBytes(), "ISO-8859-1");
          return paramString;
        }
        i1 += 1;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  private void a()
  {
    if (this.a.showControl())
    {
      MediaController localMediaController = new MediaController(getContext());
      setMediaController(localMediaController);
      localMediaController.setAnchorView(this);
    }
  }
  
  private void a(int paramInt)
  {
    if (this.n != null) {
      this.n.injectJavaScript("window.mraidview.fireMediaErrorEvent('" + this.a.id + "'," + paramInt + ");");
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.n != null) {
      this.n.injectJavaScript("window.mraidview.fireMediaTimeUpdateEvent('" + this.a.id + "'," + paramInt1 + "," + paramInt2 + ");");
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (this.n != null)
    {
      this.n.injectJavaScript("window.mraidview.fireMediaCloseEvent('" + this.a.id + "'," + paramBoolean + "," + paramInt + ");");
      this.n.mediaPlayerReleased(this);
    }
  }
  
  private void b()
  {
    this.r = playerState.INIT;
    e();
    setVideoPath(this.c);
    a();
    setOnCompletionListener(this);
    setOnErrorListener(this);
    setOnPreparedListener(this);
  }
  
  private void b(int paramInt)
  {
    if ((this.s != null) && (this.t)) {
      this.t = false;
    }
    this.p = paramInt;
    float f1 = 1.0F - (float)(Math.log(101 - paramInt) / Math.log(101.0D));
    try
    {
      this.s.setVolume(f1, f1);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.n.raiseError("Player has been released. Cannot set the volume.", "setVolume");
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.n != null) {
      this.n.injectJavaScript("window.mraidview.fireMediaTrackingEvent('" + paramString + "','" + this.a.id + "');");
    }
  }
  
  private void c()
  {
    if (this.r == playerState.SHOWING) {
      if (this.m)
      {
        localplayerState = playerState.COMPLETED;
        this.r = localplayerState;
      }
    }
    while ((!this.a.isAutoPlay()) || (this.r != playerState.INIT)) {
      for (;;)
      {
        return;
        playerState localplayerState = playerState.PAUSED;
      }
    }
    if (this.a.doMute()) {
      mute();
    }
    start();
  }
  
  private void d()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this);
      }
      localViewGroup = (ViewGroup)this.u.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.u);
      }
      setBackgroundColor(0);
      setBackgroundDrawable(null);
      setBackGroundLayout(null);
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMAVPlayer: unable to remove view");
    }
  }
  
  private void e()
  {
    this.e = new RelativeLayout(getContext());
    this.e.setLayoutParams(getLayoutParams());
    this.e.setBackgroundColor(-16777216);
    TextView localTextView = new TextView(getContext());
    localTextView.setText(k);
    localTextView.setTextColor(-1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.e.addView(localTextView, localLayoutParams);
    ((ViewGroup)getParent()).addView(this.e);
  }
  
  private void f()
  {
    if (this.e != null) {
      ((ViewGroup)getParent()).removeView(this.e);
    }
  }
  
  private void g()
  {
    if (this.n != null) {
      this.n.injectJavaScript("window.mraidview.fireMediaVolumeChangeEvent('" + this.a.id + "'," + getVolume() + "," + isMediaMuted() + ");");
    }
  }
  
  private void h()
  {
    this.w.sendEmptyMessage(1001);
  }
  
  private void i()
  {
    this.w.removeMessages(1001);
  }
  
  private boolean j()
  {
    return (this.r == playerState.PAUSED) || (this.r == playerState.HIDDEN);
  }
  
  private boolean k()
  {
    return this.r == playerState.RELEASED;
  }
  
  private boolean l()
  {
    return this.r == playerState.PLAYING;
  }
  
  private boolean m()
  {
    return (getLayoutParams().width == 1) && (getLayoutParams().height == 1);
  }
  
  public boolean getAutoPlay()
  {
    if (this.a != null) {
      return this.a.autoPlay;
    }
    return false;
  }
  
  public ViewGroup getBackGroundLayout()
  {
    return this.u;
  }
  
  public String getMediaURL()
  {
    return this.c;
  }
  
  public JSController.Dimensions getPlayDimensions()
  {
    return this.v;
  }
  
  public JSController.PlayerProperties getPlayProperties()
  {
    return this.a;
  }
  
  public JSController.PlayerProperties getProperties()
  {
    return this.a;
  }
  
  public String getPropertyID()
  {
    return this.a.id;
  }
  
  public playerState getState()
  {
    return this.r;
  }
  
  public int getVolume()
  {
    return this.p;
  }
  
  public void hide()
  {
    try
    {
      setVisibility(4);
      this.u.setVisibility(4);
      this.r = playerState.HIDDEN;
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMAVPlayer: unable to hide video");
    }
  }
  
  public boolean isInlineVideo()
  {
    return !this.a.isFullScreen();
  }
  
  public boolean isMediaMuted()
  {
    return this.t;
  }
  
  public boolean isPrepared()
  {
    return this.l;
  }
  
  public void mute()
  {
    if ((this.s != null) && (!this.t)) {
      this.t = true;
    }
    try
    {
      this.s.setVolume(0.0F, 0.0F);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("[InMobi]-[RE]-4.1.1", "IMAVPlayer: unable to set volume (mute)");
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "AVPlayer-> onCompletion");
    this.r = playerState.COMPLETED;
    this.m = true;
    b(h);
    i();
    try
    {
      if (this.a.doLoop()) {
        try
        {
          if (!j())
          {
            this.d = 0;
            start();
          }
          return;
        }
        finally {}
      }
      if (!this.a.exitOnComplete()) {
        return;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMAvplayer onCompletion exception ", paramMediaPlayer);
      return;
    }
    releasePlayer(false);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "AVPlayer-> Player error : " + paramInt1);
    f();
    releasePlayer(false);
    if (this.b != null) {
      this.b.onError(this);
    }
    paramInt2 = i;
    if (paramInt1 == 100) {
      paramInt2 = j;
    }
    a(paramInt2);
    return false;
  }
  
  public void onIMVisibilityChanged(boolean paramBoolean)
  {
    Log.debug("[InMobi]-[RE]-4.1.1", "AVPlayer-> onIMVisibilityChanged: " + paramBoolean);
    if ((paramBoolean) && (!this.pseudoPause)) {
      setBackgroundDrawable(new BitmapDrawable(this.o));
    }
    if ((paramBoolean) && (this.pseudoPause))
    {
      this.pseudoPause = false;
      play();
    }
    if ((!paramBoolean) && (this.r == playerState.PLAYING))
    {
      this.pseudoPause = true;
      pause();
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.s = paramMediaPlayer;
    super.seekTo(this.d * 1000);
    if (this.t) {}
    try
    {
      this.s.setVolume(0.0F, 0.0F);
      Log.debug("[InMobi]-[RE]-4.1.1", "AVPlayer-> onPrepared");
      f();
      if (this.b != null) {
        this.b.onPrepared(this);
      }
      this.l = true;
      c();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        Log.internal("[InMobi]-[RE]-4.1.1", "IMAVPlayer: unable to set volume");
      }
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      onIMVisibilityChanged(bool);
      return;
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    try
    {
      super.onWindowVisibilityChanged(paramInt);
      if (Build.VERSION.SDK_INT < 8) {
        if (paramInt != 0) {
          break label25;
        }
      }
      label25:
      for (boolean bool = true;; bool = false)
      {
        onIMVisibilityChanged(bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMAVPlayer: onWindowVisibilityChanged: Something went wrong");
    }
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 113	com/inmobi/re/controller/util/AVPlayer:r	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 113	com/inmobi/re/controller/util/AVPlayer:r	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   13: astore_1
    //   14: getstatic 297	com/inmobi/re/controller/util/AVPlayer$playerState:PAUSED	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   17: astore_2
    //   18: aload_1
    //   19: aload_2
    //   20: if_acmpne +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: invokespecial 523	android/widget/VideoView:pause	()V
    //   30: aload_0
    //   31: getstatic 297	com/inmobi/re/controller/util/AVPlayer$playerState:PAUSED	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   34: putfield 113	com/inmobi/re/controller/util/AVPlayer:r	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   37: aload_0
    //   38: invokespecial 454	com/inmobi/re/controller/util/AVPlayer:i	()V
    //   41: ldc_w 334
    //   44: ldc_w 525
    //   47: invokestatic 450	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getstatic 68	com/inmobi/re/controller/util/AVPlayer:g	Ljava/lang/String;
    //   54: invokespecial 452	com/inmobi/re/controller/util/AVPlayer:b	(Ljava/lang/String;)V
    //   57: goto -34 -> 23
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	AVPlayer
    //   13	6	1	localplayerState1	playerState
    //   60	4	1	localObject	Object
    //   17	3	2	localplayerState2	playerState
    // Exception table:
    //   from	to	target	type
    //   2	18	60	finally
    //   26	57	60	finally
  }
  
  public void play()
  {
    b();
  }
  
  public void releasePlayer(boolean paramBoolean)
  {
    if (this.n != null) {
      this.n.setOnTouchListener(new a());
    }
    for (;;)
    {
      try
      {
        if (k()) {
          return;
        }
        this.r = playerState.RELEASED;
        if (this.q != -1)
        {
          i1 = this.q;
          a(paramBoolean, i1);
          i();
          stopPlayback();
          super.setMediaController(null);
          d();
          if (this.b == null) {
            break;
          }
          this.b.onComplete(this);
          this.b = null;
          return;
        }
      }
      finally {}
      int i1 = Math.round(getCurrentPosition() / 1000);
    }
  }
  
  public void seekPlayer(int paramInt)
  {
    if (paramInt <= getDuration()) {
      seekTo(paramInt);
    }
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.autoPlay = paramBoolean;
    }
  }
  
  public void setBackGroundLayout(ViewGroup paramViewGroup)
  {
    this.u = paramViewGroup;
  }
  
  public void setListener(AVPlayerListener paramAVPlayerListener)
  {
    this.b = paramAVPlayerListener;
  }
  
  public void setPlayData(JSController.PlayerProperties paramPlayerProperties, String paramString)
  {
    this.a = paramPlayerProperties;
    this.c = paramString;
    if (paramPlayerProperties.audioMuted) {
      this.t = true;
    }
    this.c = this.c.trim();
    this.c = a(this.c);
    if (this.o != null) {}
    do
    {
      return;
      this.o = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      this.o = WrapperFunctions.getVideoBitmap(this.c);
      return;
    }
    catch (Exception paramPlayerProperties)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMAVPlayer: unable to get video bitmap");
    }
  }
  
  public void setPlayDimensions(JSController.Dimensions paramDimensions)
  {
    this.v = paramDimensions;
  }
  
  public void setVolume(int paramInt)
  {
    if ((paramInt != this.p) && (this.r != playerState.RELEASED)) {
      b(paramInt);
    }
  }
  
  public void show()
  {
    this.r = playerState.SHOWING;
    setVisibility(0);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/inmobi/re/controller/util/AVPlayer:n	Lcom/inmobi/re/container/IMWebView;
    //   6: ifnull +25 -> 31
    //   9: aload_0
    //   10: invokespecial 597	com/inmobi/re/controller/util/AVPlayer:m	()Z
    //   13: ifne +18 -> 31
    //   16: aload_0
    //   17: getfield 118	com/inmobi/re/controller/util/AVPlayer:n	Lcom/inmobi/re/container/IMWebView;
    //   20: new 17	com/inmobi/re/controller/util/AVPlayer$c
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 598	com/inmobi/re/controller/util/AVPlayer$c:<init>	(Lcom/inmobi/re/controller/util/AVPlayer;)V
    //   28: invokevirtual 532	com/inmobi/re/container/IMWebView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   31: aload_0
    //   32: getfield 113	com/inmobi/re/controller/util/AVPlayer:r	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   35: ifnull +20 -> 55
    //   38: aload_0
    //   39: getfield 113	com/inmobi/re/controller/util/AVPlayer:r	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   42: astore_1
    //   43: getstatic 404	com/inmobi/re/controller/util/AVPlayer$playerState:PLAYING	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   46: astore_2
    //   47: aload_1
    //   48: aload_2
    //   49: if_acmpne +6 -> 55
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 89	com/inmobi/re/controller/util/AVPlayer:d	I
    //   60: sipush 1000
    //   63: imul
    //   64: invokevirtual 600	com/inmobi/re/controller/util/AVPlayer:seekPlayer	(I)V
    //   67: aload_0
    //   68: invokespecial 601	android/widget/VideoView:start	()V
    //   71: aload_0
    //   72: getstatic 404	com/inmobi/re/controller/util/AVPlayer$playerState:PLAYING	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   75: putfield 113	com/inmobi/re/controller/util/AVPlayer:r	Lcom/inmobi/re/controller/util/AVPlayer$playerState;
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 93	com/inmobi/re/controller/util/AVPlayer:m	Z
    //   83: aload_0
    //   84: invokespecial 603	com/inmobi/re/controller/util/AVPlayer:h	()V
    //   87: ldc_w 334
    //   90: ldc_w 605
    //   93: invokestatic 450	com/inmobi/commons/internal/Log:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 91	com/inmobi/re/controller/util/AVPlayer:l	Z
    //   100: ifeq -48 -> 52
    //   103: aload_0
    //   104: getstatic 64	com/inmobi/re/controller/util/AVPlayer:f	Ljava/lang/String;
    //   107: invokespecial 452	com/inmobi/re/controller/util/AVPlayer:b	(Ljava/lang/String;)V
    //   110: goto -58 -> 52
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	AVPlayer
    //   42	6	1	localplayerState1	playerState
    //   113	4	1	localObject	Object
    //   46	3	2	localplayerState2	playerState
    // Exception table:
    //   from	to	target	type
    //   2	31	113	finally
    //   31	47	113	finally
    //   55	110	113	finally
  }
  
  public void unMute()
  {
    b(this.p);
  }
  
  class a
    implements View.OnTouchListener
  {
    a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  static class b
    extends Handler
  {
    private final WeakReference<AVPlayer> a;
    
    public b(AVPlayer paramAVPlayer)
    {
      this.a = new WeakReference(paramAVPlayer);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AVPlayer localAVPlayer = (AVPlayer)this.a.get();
      if (localAVPlayer != null) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        do
        {
          return;
        } while (!AVPlayer.a(localAVPlayer));
        int i = Math.round(localAVPlayer.getCurrentPosition() / 1000);
        int j = Math.round(localAVPlayer.getDuration() / 1000);
        if (AVPlayer.b(localAVPlayer) != i)
        {
          AVPlayer.a(localAVPlayer, i, j);
          AVPlayer.a(localAVPlayer, i);
          AVPlayer.b(localAVPlayer, i);
        }
        sendEmptyMessageDelayed(1001, 1000L);
      }
    }
  }
  
  class c
    implements View.OnTouchListener
  {
    c() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return paramMotionEvent.getAction() == 2;
    }
  }
  
  public static enum playerState
  {
    static
    {
      PAUSED = new playerState("PAUSED", 2);
      HIDDEN = new playerState("HIDDEN", 3);
      SHOWING = new playerState("SHOWING", 4);
    }
    
    private playerState() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/util/AVPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */