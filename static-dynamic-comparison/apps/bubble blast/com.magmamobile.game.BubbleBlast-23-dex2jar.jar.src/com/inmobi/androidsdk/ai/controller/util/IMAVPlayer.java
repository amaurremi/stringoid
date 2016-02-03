package com.inmobi.androidsdk.ai.controller.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.controller.JSController.Dimensions;
import com.inmobi.androidsdk.ai.controller.JSController.PlayerProperties;
import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.lang.ref.WeakReference;

public class IMAVPlayer
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
  private AudioManager b;
  private IMAVPlayerListener c;
  private String d;
  private RelativeLayout e;
  private boolean l = false;
  private boolean m = false;
  private IMWebView n;
  private int o;
  private int p;
  private int q = -1;
  private playerState r;
  private MediaPlayer s;
  private boolean t;
  private ViewGroup u;
  private JSController.Dimensions v;
  private a w = new a(this);
  
  private IMAVPlayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public IMAVPlayer(Context paramContext, IMWebView paramIMWebView)
  {
    this(paramContext);
    setZOrderOnTop(true);
    this.b = ((AudioManager)getContext().getSystemService("audio"));
    this.n = paramIMWebView;
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.o = this.b.getStreamVolume(3);
    this.p = this.o;
    getHolder().addCallback(new SurfaceHolder.Callback()
    {
      public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder) {}
      
      public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        IMAVPlayer.this.post(new Runnable()
        {
          public void run()
          {
            IMAVPlayer.this.releasePlayer(false);
          }
        });
      }
    });
  }
  
  private static String a(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        paramString = paramString.getBytes();
        StringBuffer localStringBuffer = new StringBuffer();
        i1 = 0;
        if (i1 >= paramString.length) {
          return new String(localStringBuffer.toString().getBytes(), "ISO-8859-1");
        }
        if ((paramString[i1] & 0x80) > 0) {
          localStringBuffer.append("%" + InternalSDKUtil.byteToHex(paramString[i1]));
        } else {
          localStringBuffer.append((char)paramString[i1]);
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      i1 += 1;
    }
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
    if (this.n != null) {
      this.n.injectJavaScript("window.mraidview.fireMediaCloseEvent('" + this.a.id + "'," + paramBoolean + "," + paramInt + ");");
    }
  }
  
  private int b(int paramInt)
  {
    return this.b.getStreamMaxVolume(3) * paramInt / 100;
  }
  
  private void b()
  {
    this.d = this.d.trim();
    this.d = a(this.d);
    this.r = playerState.INIT;
    e();
    setVideoPath(this.d);
    a();
    setOnCompletionListener(this);
    setOnErrorListener(this);
    setOnPreparedListener(this);
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
      return;
    }
    catch (Exception localException) {}
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
  
  private void m()
  {
    this.b.setStreamVolume(3, this.p, 4);
  }
  
  private boolean n()
  {
    return (getLayoutParams().width == 1) && (getLayoutParams().height == 1);
  }
  
  public ViewGroup getBackGroundLayout()
  {
    return this.u;
  }
  
  public String getMediaURL()
  {
    return this.d;
  }
  
  public JSController.Dimensions getPlayDimensions()
  {
    return this.v;
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
    try
    {
      if (!isPlaying()) {
        this.o = this.b.getStreamVolume(3);
      }
      return this.o * 100 / this.b.getStreamMaxVolume(3);
    }
    finally {}
  }
  
  public void hide()
  {
    try
    {
      if (isPlaying()) {
        pause();
      }
      this.u.setVisibility(8);
      this.r = playerState.HIDDEN;
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean isInlineVideo()
  {
    return !this.a.isFullScreen();
  }
  
  public boolean isMediaMuted()
  {
    return (this.o == 0) || (this.t);
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
      for (;;) {}
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "AVPlayer-> onCompletion");
    this.r = playerState.COMPLETED;
    this.m = true;
    b(h);
    i();
    if (this.a.doLoop()) {
      try
      {
        if (!j()) {
          start();
        }
        return;
      }
      finally {}
    }
    if (this.a.exitOnComplete()) {
      releasePlayer(false);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "AVPlayer-> Player error : " + paramInt1);
    f();
    releasePlayer(false);
    if (this.c != null) {
      this.c.onError(this);
    }
    paramInt2 = i;
    if (paramInt1 == 100) {
      paramInt2 = j;
    }
    a(paramInt2);
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.s = paramMediaPlayer;
    if (this.t) {}
    try
    {
      this.s.setVolume(0.0F, 0.0F);
      IMLog.debug("InMobiAndroidSDK_3.6.1", "AVPlayer-> onPrepared");
      f();
      if (this.c != null) {
        this.c.onPrepared(this);
      }
      this.l = true;
      c();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;) {}
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    try
    {
      super.onWindowVisibilityChanged(paramInt);
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 265	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:r	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 265	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:r	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   13: astore_1
    //   14: getstatic 300	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState:PAUSED	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   17: astore_2
    //   18: aload_1
    //   19: aload_2
    //   20: if_acmpne +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: invokespecial 489	android/widget/VideoView:pause	()V
    //   30: aload_0
    //   31: getstatic 300	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState:PAUSED	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   34: putfield 265	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:r	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   37: aload_0
    //   38: invokespecial 453	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:i	()V
    //   41: ldc_w 441
    //   44: ldc_w 491
    //   47: invokestatic 449	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getstatic 71	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:g	Ljava/lang/String;
    //   54: invokespecial 451	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:b	(Ljava/lang/String;)V
    //   57: goto -34 -> 23
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	IMAVPlayer
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
      this.n.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
      });
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
          this.q = -1;
          i();
          unMute();
          m();
          stopPlayback();
          d();
          if (this.c == null) {
            break;
          }
          this.c.onComplete(this);
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
  
  public void setBackGroundLayout(ViewGroup paramViewGroup)
  {
    this.u = paramViewGroup;
  }
  
  public void setListener(IMAVPlayerListener paramIMAVPlayerListener)
  {
    this.c = paramIMAVPlayerListener;
  }
  
  public void setPlayData(JSController.PlayerProperties paramPlayerProperties, String paramString)
  {
    this.a = paramPlayerProperties;
    this.d = paramString;
  }
  
  public void setPlayDimensions(JSController.Dimensions paramDimensions)
  {
    this.v = paramDimensions;
  }
  
  public void setVolume(int paramInt)
  {
    try
    {
      this.o = b(paramInt);
      this.b.setStreamVolume(3, this.o, 4);
      if (this.t)
      {
        unMute();
        return;
      }
    }
    finally {}
    g();
  }
  
  public void show()
  {
    this.r = playerState.SHOWING;
    this.u.setVisibility(0);
    setVisibility(0);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:n	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   6: ifnull +25 -> 31
    //   9: aload_0
    //   10: invokespecial 545	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:n	()Z
    //   13: ifne +18 -> 31
    //   16: aload_0
    //   17: getfield 123	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:n	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   20: new 18	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$3
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 546	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$3:<init>	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)V
    //   28: invokevirtual 498	com/inmobi/androidsdk/ai/container/IMWebView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   31: aload_0
    //   32: getfield 265	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:r	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   35: ifnull +20 -> 55
    //   38: aload_0
    //   39: getfield 265	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:r	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   42: astore_1
    //   43: getstatic 390	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState:PLAYING	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   46: astore_2
    //   47: aload_1
    //   48: aload_2
    //   49: if_acmpne +6 -> 55
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: invokespecial 547	android/widget/VideoView:start	()V
    //   59: aload_0
    //   60: getstatic 390	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState:PLAYING	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   63: putfield 265	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:r	Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer$playerState;
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 92	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:m	Z
    //   71: aload_0
    //   72: invokespecial 549	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:h	()V
    //   75: ldc_w 441
    //   78: ldc_w 551
    //   81: invokestatic 449	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 90	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:l	Z
    //   88: ifeq -36 -> 52
    //   91: aload_0
    //   92: getstatic 67	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:f	Ljava/lang/String;
    //   95: invokespecial 451	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:b	(Ljava/lang/String;)V
    //   98: goto -46 -> 52
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	IMAVPlayer
    //   42	6	1	localplayerState1	playerState
    //   101	4	1	localObject	Object
    //   46	3	2	localplayerState2	playerState
    // Exception table:
    //   from	to	target	type
    //   2	31	101	finally
    //   31	47	101	finally
    //   55	98	101	finally
  }
  
  public void unMute()
  {
    if (this.s != null) {
      this.t = false;
    }
    try
    {
      this.s.setVolume(1.0F, 1.0F);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<IMAVPlayer> a;
    
    public a(IMAVPlayer paramIMAVPlayer)
    {
      this.a = new WeakReference(paramIMAVPlayer);
    }
    
    /* Error */
    public void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$a:a	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 28	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 6	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer
      //   10: astore 4
      //   12: aload 4
      //   14: ifnull +26 -> 40
      //   17: aload_1
      //   18: getfield 34	android/os/Message:what	I
      //   21: tableswitch	default:+19->40, 1001:+25->46
      //   40: aload_0
      //   41: aload_1
      //   42: invokespecial 36	android/os/Handler:handleMessage	(Landroid/os/Message;)V
      //   45: return
      //   46: aload 4
      //   48: invokestatic 39	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:a	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)Z
      //   51: ifeq -6 -> 45
      //   54: ldc 6
      //   56: monitorenter
      //   57: aload 4
      //   59: invokestatic 43	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:b	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)Landroid/media/AudioManager;
      //   62: iconst_3
      //   63: invokevirtual 49	android/media/AudioManager:getStreamVolume	(I)I
      //   66: istore_2
      //   67: iload_2
      //   68: aload 4
      //   70: invokestatic 53	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:c	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)I
      //   73: if_icmpeq +32 -> 105
      //   76: aload 4
      //   78: iload_2
      //   79: invokestatic 56	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:a	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;I)V
      //   82: aload 4
      //   84: aload 4
      //   86: invokestatic 53	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:c	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)I
      //   89: invokestatic 58	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:b	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;I)V
      //   92: aload 4
      //   94: invokestatic 61	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:d	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)Z
      //   97: ifeq +75 -> 172
      //   100: aload 4
      //   102: invokevirtual 64	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:unMute	()V
      //   105: ldc 6
      //   107: monitorexit
      //   108: aload 4
      //   110: invokevirtual 68	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:getCurrentPosition	()I
      //   113: sipush 1000
      //   116: idiv
      //   117: i2f
      //   118: invokestatic 74	java/lang/Math:round	(F)I
      //   121: istore_2
      //   122: aload 4
      //   124: invokevirtual 77	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:getDuration	()I
      //   127: sipush 1000
      //   130: idiv
      //   131: i2f
      //   132: invokestatic 74	java/lang/Math:round	(F)I
      //   135: istore_3
      //   136: aload 4
      //   138: invokestatic 80	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:f	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)I
      //   141: iload_2
      //   142: if_icmpeq +16 -> 158
      //   145: aload 4
      //   147: iload_2
      //   148: iload_3
      //   149: invokestatic 83	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:a	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;II)V
      //   152: aload 4
      //   154: iload_2
      //   155: invokestatic 85	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:c	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;I)V
      //   158: aload_0
      //   159: sipush 1001
      //   162: ldc2_w 86
      //   165: invokevirtual 91	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer$a:sendEmptyMessageDelayed	(IJ)Z
      //   168: pop
      //   169: goto -129 -> 40
      //   172: aload 4
      //   174: invokestatic 94	com/inmobi/androidsdk/ai/controller/util/IMAVPlayer:e	(Lcom/inmobi/androidsdk/ai/controller/util/IMAVPlayer;)V
      //   177: goto -72 -> 105
      //   180: astore_1
      //   181: ldc 6
      //   183: monitorexit
      //   184: aload_1
      //   185: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	186	0	this	a
      //   0	186	1	paramMessage	android.os.Message
      //   66	89	2	i	int
      //   135	14	3	j	int
      //   10	163	4	localIMAVPlayer	IMAVPlayer
      // Exception table:
      //   from	to	target	type
      //   57	105	180	finally
      //   105	108	180	finally
      //   172	177	180	finally
      //   181	184	180	finally
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
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/util/IMAVPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */