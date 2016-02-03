package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.WrapperFunctions;
import com.inmobi.re.controller.JSController.Dimensions;
import com.inmobi.re.controller.JSController.ExpandProperties;
import com.inmobi.re.controller.JSController.PlayerProperties;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayer.playerState;
import com.inmobi.re.controller.util.AVPlayerListener;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MRAIDAudioVideoController
{
  private IMWebView a;
  public Hashtable<String, AVPlayer> audioPlayerList = new Hashtable();
  public AVPlayer audioplayer;
  public AVPlayer videoPlayer;
  public Hashtable<String, AVPlayer> videoPlayerList = new Hashtable();
  public int videoValidateWidth;
  
  public MRAIDAudioVideoController(IMWebView paramIMWebView)
  {
    this.a = paramIMWebView;
  }
  
  private AVPlayer a(String paramString)
  {
    if (!this.videoPlayerList.isEmpty()) {
      return (AVPlayer)this.videoPlayerList.get(paramString);
    }
    return null;
  }
  
  private void a(AVPlayer paramAVPlayer, JSController.Dimensions paramDimensions)
  {
    int i = (int)(-99999.0F * this.a.getDensity());
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (paramAVPlayer.isInlineVideo())
    {
      localLayoutParams1 = new FrameLayout.LayoutParams(paramDimensions.width, paramDimensions.height);
      localLayoutParams2 = (FrameLayout.LayoutParams)paramAVPlayer.getLayoutParams();
      if ((paramDimensions.x != i) || (paramDimensions.y != i)) {
        break label94;
      }
      localLayoutParams1.leftMargin = localLayoutParams2.leftMargin;
    }
    for (localLayoutParams1.topMargin = localLayoutParams2.topMargin;; localLayoutParams1.topMargin = paramDimensions.y)
    {
      localLayoutParams1.gravity = 3;
      paramAVPlayer.setLayoutParams(localLayoutParams1);
      return;
      label94:
      localLayoutParams1.leftMargin = paramDimensions.x;
    }
  }
  
  private boolean a(String paramString1, String paramString2, Activity paramActivity)
  {
    if (!this.audioPlayerList.isEmpty())
    {
      this.audioplayer = ((AVPlayer)this.audioPlayerList.get(paramString1));
      if (this.audioplayer == null)
      {
        if (this.audioPlayerList.size() > 4)
        {
          this.a.raiseError("Too many audio players", "playAudio");
          return false;
        }
        this.audioplayer = new AVPlayer(paramActivity, this.a);
      }
    }
    for (;;)
    {
      return true;
      if ((this.audioplayer.getMediaURL().equals(paramString2)) || (paramString2.length() == 0))
      {
        if (this.audioplayer.getState() == AVPlayer.playerState.PLAYING) {
          return false;
        }
        if (this.audioplayer.getState() == AVPlayer.playerState.INIT)
        {
          if (this.audioplayer.isPrepared()) {
            this.audioplayer.start();
          }
          for (;;)
          {
            return false;
            this.audioplayer.setAutoPlay(true);
          }
        }
        if (this.audioplayer.getState() == AVPlayer.playerState.PAUSED)
        {
          this.audioplayer.start();
          return false;
        }
        paramString2 = this.audioplayer.getProperties();
        String str = this.audioplayer.getMediaURL();
        this.audioplayer.releasePlayer(false);
        this.audioPlayerList.remove(paramString1);
        this.audioplayer = new AVPlayer(paramActivity, this.a);
        this.audioplayer.setPlayData(paramString2, str);
      }
      else
      {
        this.audioplayer.releasePlayer(false);
        this.audioPlayerList.remove(paramString1);
        this.audioplayer = new AVPlayer(paramActivity, this.a);
        continue;
        this.audioplayer = new AVPlayer(paramActivity, this.a);
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, Activity paramActivity, JSController.Dimensions paramDimensions)
  {
    if ((this.videoPlayer == null) || (!paramString1.equalsIgnoreCase(this.videoPlayer.getPropertyID()))) {
      return b(paramString1, paramString2, paramActivity);
    }
    AVPlayer.playerState localplayerState = this.videoPlayer.getState();
    if (paramString1.equalsIgnoreCase(this.videoPlayer.getPropertyID()))
    {
      paramString1 = this.videoPlayer.getMediaURL();
      if ((paramString2.length() == 0) || (paramString2.equalsIgnoreCase(paramString1)))
      {
        switch (e.a[localplayerState.ordinal()])
        {
        default: 
          return false;
        case 1: 
          this.videoPlayer.start();
          a(this.videoPlayer, paramDimensions);
          return false;
        case 2: 
          a(this.videoPlayer, paramDimensions);
          return false;
        case 3: 
          if (!this.videoPlayer.getProperties().doLoop()) {
            this.videoPlayer.start();
          }
          a(this.videoPlayer, paramDimensions);
          return false;
        }
        if (this.videoPlayer.isPrepared()) {
          this.videoPlayer.start();
        }
        for (;;)
        {
          a(this.videoPlayer, paramDimensions);
          return false;
          this.videoPlayer.setAutoPlay(true);
        }
      }
      if (!URLUtil.isValidUrl(paramString2))
      {
        this.a.raiseError("Request must specify a valid URL", "playVideo");
        return false;
      }
      this.videoPlayer.releasePlayer(false);
      this.videoPlayer = new AVPlayer(paramActivity, this.a);
    }
    return true;
  }
  
  private boolean a(Hashtable<String, AVPlayer> paramHashtable, AVPlayer paramAVPlayer)
  {
    paramHashtable = paramHashtable.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!paramHashtable.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)paramHashtable.next();
    } while (localEntry.getValue() != paramAVPlayer);
    for (paramHashtable = (String)localEntry.getKey();; paramHashtable = null)
    {
      if (paramHashtable != null)
      {
        this.audioPlayerList.remove(paramHashtable);
        return true;
      }
      return false;
    }
  }
  
  private boolean b(String paramString1, String paramString2, Activity paramActivity)
  {
    if (((paramString2.length() != 0) && (!URLUtil.isValidUrl(paramString2))) || ((paramString2.length() == 0) && (!this.videoPlayerList.containsKey(paramString1))))
    {
      this.a.raiseError("Request must specify a valid URL", "playVideo");
      return false;
    }
    if (this.videoPlayer != null)
    {
      this.videoPlayer.hide();
      this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
    }
    AVPlayer localAVPlayer = a(paramString1);
    if (localAVPlayer == null) {}
    for (this.videoPlayer = new AVPlayer(paramActivity, this.a);; this.videoPlayer = localAVPlayer)
    {
      if (paramString2.length() == 0)
      {
        this.videoPlayer.setPlayData(localAVPlayer.getProperties(), localAVPlayer.getMediaURL());
        this.videoPlayer.setPlayDimensions(localAVPlayer.getPlayDimensions());
      }
      this.videoPlayerList.remove(paramString1);
      return true;
    }
  }
  
  /* Error */
  public AVPlayer getCurrentAudioPlayer(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 106	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   8: ifnull +26 -> 34
    //   11: aload_0
    //   12: getfield 106	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   15: invokevirtual 180	com/inmobi/re/controller/util/AVPlayer:getPropertyID	()Ljava/lang/String;
    //   18: aload_1
    //   19: invokevirtual 184	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   22: ifeq +12 -> 34
    //   25: aload_0
    //   26: getfield 106	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 41	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
    //   40: invokevirtual 50	java/util/Hashtable:isEmpty	()Z
    //   43: ifne -13 -> 30
    //   46: aload_3
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 41	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
    //   52: aload_1
    //   53: invokevirtual 242	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   56: ifeq -26 -> 30
    //   59: aload_0
    //   60: getfield 41	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
    //   63: aload_1
    //   64: invokevirtual 54	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 56	com/inmobi/re/controller/util/AVPlayer
    //   70: astore_2
    //   71: goto -41 -> 30
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	MRAIDAudioVideoController
    //   0	79	1	paramString	String
    //   29	42	2	localObject1	Object
    //   3	44	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	30	74	finally
    //   36	46	74	finally
    //   48	71	74	finally
  }
  
  /* Error */
  public AVPlayer getVideoPlayer(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   8: ifnull +26 -> 34
    //   11: aload_0
    //   12: getfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   15: invokevirtual 180	com/inmobi/re/controller/util/AVPlayer:getPropertyID	()Ljava/lang/String;
    //   18: aload_1
    //   19: invokevirtual 184	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   22: ifeq +12 -> 34
    //   25: aload_0
    //   26: getfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 39	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
    //   40: invokevirtual 50	java/util/Hashtable:isEmpty	()Z
    //   43: ifne -13 -> 30
    //   46: aload_3
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 39	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
    //   52: aload_1
    //   53: invokevirtual 242	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   56: ifeq -26 -> 30
    //   59: aload_0
    //   60: getfield 39	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
    //   63: aload_1
    //   64: invokevirtual 54	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 56	com/inmobi/re/controller/util/AVPlayer
    //   70: astore_2
    //   71: goto -41 -> 30
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	MRAIDAudioVideoController
    //   0	79	1	paramString	String
    //   29	42	2	localObject1	Object
    //   3	44	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	30	74	finally
    //   36	46	74	finally
    //   48	71	74	finally
  }
  
  public void hidePlayers()
  {
    Log.debug("IMRE_3.7.1", "MRAIDAudioVideoController: hiding all players");
    if ((this.videoPlayer != null) && (this.videoPlayer.getState() != AVPlayer.playerState.RELEASED))
    {
      this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
      this.videoPlayer.hide();
    }
    Iterator localIterator = this.audioPlayerList.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      AVPlayer localAVPlayer = (AVPlayer)localEntry.getValue();
      switch (e.a[localAVPlayer.getState().ordinal()])
      {
      case 3: 
      default: 
        break;
      case 2: 
        localAVPlayer.pause();
        break;
      case 4: 
        localAVPlayer.releasePlayer(false);
        this.audioPlayerList.remove(localEntry.getKey());
      }
    }
  }
  
  public void mediaPlayerReleased(AVPlayer paramAVPlayer)
  {
    if (paramAVPlayer == this.audioplayer) {
      this.audioplayer = null;
    }
    if (paramAVPlayer == this.videoPlayer) {
      this.videoPlayer = null;
    }
    if (a(this.audioPlayerList, paramAVPlayer)) {
      return;
    }
    a(this.videoPlayerList, paramAVPlayer);
  }
  
  public void playAudioImpl(Bundle paramBundle, Activity paramActivity)
  {
    final JSController.PlayerProperties localPlayerProperties = (JSController.PlayerProperties)paramBundle.getParcelable("player_properties");
    Object localObject = paramBundle.getString("expand_url");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    if (!a(localPlayerProperties.id, paramBundle, paramActivity)) {}
    do
    {
      return;
      if (((paramBundle.length() != 0) && (!URLUtil.isValidUrl(paramBundle))) || ((paramBundle.length() == 0) && (!this.audioPlayerList.containsKey(localPlayerProperties.id))))
      {
        this.a.raiseError("Request must specify a valid URL", "playAudio");
        return;
      }
    } while (this.audioplayer == null);
    if (paramBundle.length() != 0) {
      this.audioplayer.setPlayData(localPlayerProperties, paramBundle);
    }
    this.audioPlayerList.put(localPlayerProperties.id, this.audioplayer);
    paramBundle = (FrameLayout)paramActivity.findViewById(16908290);
    if (localPlayerProperties.isFullScreen())
    {
      localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.audioplayer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramActivity = new RelativeLayout(paramActivity);
      paramActivity.setOnTouchListener(new g());
      paramActivity.setBackgroundColor(-16777216);
      paramBundle.addView(paramActivity, new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
      paramActivity.addView(this.audioplayer);
      this.audioplayer.setBackGroundLayout(paramActivity);
      this.audioplayer.requestFocus();
      this.audioplayer.setOnKeyListener(new f());
    }
    for (;;)
    {
      this.audioplayer.setListener(new b(localPlayerProperties));
      this.audioplayer.play();
      return;
      this.audioplayer.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
      paramBundle.addView(this.audioplayer);
    }
  }
  
  public void playVideoImpl(Bundle paramBundle, Activity paramActivity)
  {
    Object localObject1 = (JSController.PlayerProperties)paramBundle.getParcelable("player_properties");
    Object localObject2 = (JSController.Dimensions)paramBundle.getParcelable("expand_dimensions");
    Log.debug("IMRE_3.7.1", "Final dimensions: " + localObject2);
    paramBundle = paramBundle.getString("expand_url");
    if (!a(((JSController.PlayerProperties)localObject1).id, paramBundle, paramActivity, (JSController.Dimensions)localObject2)) {
      return;
    }
    this.a.setBusy(true);
    if (paramBundle.length() == 0)
    {
      localObject1 = this.videoPlayer.getProperties();
      paramBundle = this.videoPlayer.getPlayDimensions();
      this.videoPlayer.getMediaURL();
    }
    while (this.videoPlayer.getState() == AVPlayer.playerState.HIDDEN)
    {
      this.videoPlayer.pseudoPause = true;
      this.videoPlayer.show();
      return;
      this.videoPlayer.setPlayData((JSController.PlayerProperties)localObject1, paramBundle);
      this.videoPlayer.setPlayDimensions((JSController.Dimensions)localObject2);
      paramBundle = (Bundle)localObject2;
    }
    localObject2 = (FrameLayout)paramActivity.findViewById(16908290);
    if (((JSController.PlayerProperties)localObject1).isFullScreen())
    {
      paramBundle = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
      paramBundle.addRule(13);
      this.videoPlayer.setLayoutParams(paramBundle);
      paramBundle = new RelativeLayout(paramActivity);
      paramBundle.setOnTouchListener(new a());
      paramBundle.setBackgroundColor(-16777216);
      ((FrameLayout)localObject2).addView(paramBundle, new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
      paramBundle.addView(this.videoPlayer);
      this.videoPlayer.setBackGroundLayout(paramBundle);
      this.videoPlayer.requestFocus();
      this.videoPlayer.setOnKeyListener(new d());
      this.videoPlayer.setListener(new c());
      this.videoPlayer.play();
      return;
    }
    localObject1 = new FrameLayout.LayoutParams(paramBundle.width, paramBundle.height);
    paramActivity = new FrameLayout(paramActivity);
    if (this.a.mExpandController.expandProperties == null) {
      ((FrameLayout.LayoutParams)localObject1).leftMargin = paramBundle.x;
    }
    for (((FrameLayout.LayoutParams)localObject1).topMargin = paramBundle.y;; ((FrameLayout.LayoutParams)localObject1).topMargin = (paramBundle.y + this.a.mExpandController.expandProperties.currentY))
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = 3;
      this.videoPlayer.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((FrameLayout)localObject2).addView(paramActivity, new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
      this.videoPlayer.setBackGroundLayout(paramActivity);
      paramActivity.addView(this.videoPlayer);
      break;
      ((FrameLayout.LayoutParams)localObject1).leftMargin = (paramBundle.x + this.a.mExpandController.expandProperties.currentX);
    }
  }
  
  /* Error */
  public void releaseAllPlayers()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   4: ifnull +22 -> 26
    //   7: aload_0
    //   8: getfield 39	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
    //   11: aload_0
    //   12: getfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   15: invokevirtual 180	com/inmobi/re/controller/util/AVPlayer:getPropertyID	()Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   22: invokevirtual 249	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: aload_0
    //   27: getfield 39	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
    //   30: invokevirtual 440	java/util/Hashtable:values	()Ljava/util/Collection;
    //   33: invokeinterface 446 1 0
    //   38: astore_3
    //   39: aload_3
    //   40: arraylength
    //   41: istore_2
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_1
    //   45: iload_2
    //   46: if_icmpge +51 -> 97
    //   49: aload_3
    //   50: iload_1
    //   51: aaload
    //   52: astore 4
    //   54: aload 4
    //   56: checkcast 56	com/inmobi/re/controller/util/AVPlayer
    //   59: getstatic 449	com/inmobi/re/container/IMWebView:userInitiatedClose	Z
    //   62: invokevirtual 167	com/inmobi/re/controller/util/AVPlayer:releasePlayer	(Z)V
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -25 -> 44
    //   72: astore 4
    //   74: ldc_w 264
    //   77: ldc_w 451
    //   80: invokestatic 454	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: goto -18 -> 65
    //   86: astore_3
    //   87: ldc_w 264
    //   90: ldc_w 456
    //   93: aload_3
    //   94: invokestatic 459	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload_0
    //   98: getfield 39	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
    //   101: invokevirtual 462	java/util/Hashtable:clear	()V
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 177	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   109: aload_0
    //   110: getfield 41	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
    //   113: invokevirtual 440	java/util/Hashtable:values	()Ljava/util/Collection;
    //   116: invokeinterface 446 1 0
    //   121: astore_3
    //   122: aload_3
    //   123: arraylength
    //   124: istore_2
    //   125: iconst_0
    //   126: istore_1
    //   127: iload_1
    //   128: iload_2
    //   129: if_icmpge +51 -> 180
    //   132: aload_3
    //   133: iload_1
    //   134: aaload
    //   135: astore 4
    //   137: aload 4
    //   139: checkcast 56	com/inmobi/re/controller/util/AVPlayer
    //   142: getstatic 449	com/inmobi/re/container/IMWebView:userInitiatedClose	Z
    //   145: invokevirtual 167	com/inmobi/re/controller/util/AVPlayer:releasePlayer	(Z)V
    //   148: iload_1
    //   149: iconst_1
    //   150: iadd
    //   151: istore_1
    //   152: goto -25 -> 127
    //   155: astore 4
    //   157: ldc_w 264
    //   160: ldc_w 451
    //   163: invokestatic 454	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -18 -> 148
    //   169: astore_3
    //   170: ldc_w 264
    //   173: ldc_w 456
    //   176: aload_3
    //   177: invokestatic 459	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: iconst_0
    //   181: putstatic 449	com/inmobi/re/container/IMWebView:userInitiatedClose	Z
    //   184: aload_0
    //   185: getfield 41	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
    //   188: invokevirtual 462	java/util/Hashtable:clear	()V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 106	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
    //   196: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	MRAIDAudioVideoController
    //   43	109	1	i	int
    //   41	89	2	j	int
    //   38	12	3	arrayOfObject1	Object[]
    //   86	8	3	localException1	Exception
    //   121	12	3	arrayOfObject2	Object[]
    //   169	8	3	localException2	Exception
    //   52	3	4	localObject1	Object
    //   72	1	4	localException3	Exception
    //   135	3	4	localObject2	Object
    //   155	1	4	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   54	65	72	java/lang/Exception
    //   26	42	86	java/lang/Exception
    //   74	83	86	java/lang/Exception
    //   137	148	155	java/lang/Exception
    //   109	125	169	java/lang/Exception
    //   157	166	169	java/lang/Exception
  }
  
  public void validateVideoDimensions(JSController.Dimensions paramDimensions)
  {
    paramDimensions.width = ((int)(paramDimensions.width * this.a.getDensity()));
    paramDimensions.height = ((int)(paramDimensions.height * this.a.getDensity()));
    paramDimensions.x = ((int)(paramDimensions.x * this.a.getDensity()));
    paramDimensions.y = ((int)(paramDimensions.y * this.a.getDensity()));
  }
  
  class a
    implements View.OnTouchListener
  {
    a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  class b
    implements AVPlayerListener
  {
    b(JSController.PlayerProperties paramPlayerProperties) {}
    
    public void onComplete(AVPlayer paramAVPlayer)
    {
      try
      {
        ViewGroup localViewGroup;
        if (localPlayerProperties.isFullScreen())
        {
          localViewGroup = (ViewGroup)paramAVPlayer.getBackGroundLayout().getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView(paramAVPlayer.getBackGroundLayout());
          }
        }
        else
        {
          localViewGroup = (ViewGroup)paramAVPlayer.getParent();
          if (localViewGroup != null)
          {
            localViewGroup.removeView(paramAVPlayer);
            return;
          }
        }
      }
      catch (Exception paramAVPlayer)
      {
        Log.debug("IMRE_3.7.1", "Problem removing the audio relativelayout", paramAVPlayer);
      }
    }
    
    public void onError(AVPlayer paramAVPlayer)
    {
      onComplete(paramAVPlayer);
    }
    
    public void onPrepared(AVPlayer paramAVPlayer) {}
  }
  
  class c
    implements AVPlayerListener
  {
    c() {}
    
    public void onComplete(AVPlayer paramAVPlayer)
    {
      MRAIDAudioVideoController.a(MRAIDAudioVideoController.this).setBusy(false);
      try
      {
        ViewGroup localViewGroup = paramAVPlayer.getBackGroundLayout();
        if (localViewGroup != null) {
          ((ViewGroup)localViewGroup.getParent()).removeView(paramAVPlayer.getBackGroundLayout());
        }
        paramAVPlayer.setBackGroundLayout(null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            if ((MRAIDAudioVideoController.this.videoPlayer != null) && (paramAVPlayer.getPropertyID().equalsIgnoreCase(MRAIDAudioVideoController.this.videoPlayer.getPropertyID()))) {
              MRAIDAudioVideoController.this.videoPlayer = null;
            }
            return;
          }
          finally {}
          localException = localException;
          Log.debug("IMRE_3.7.1", "Problem removing the video framelayout or relativelayout depending on video startstyle", localException);
        }
      }
    }
    
    public void onError(AVPlayer paramAVPlayer)
    {
      onComplete(paramAVPlayer);
    }
    
    public void onPrepared(AVPlayer paramAVPlayer) {}
  }
  
  class d
    implements View.OnKeyListener
  {
    d() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
      {
        Log.debug("IMRE_3.7.1", "Back pressed while fullscreen video is playing");
        MRAIDAudioVideoController.this.videoPlayer.releasePlayer(true);
        return true;
      }
      return false;
    }
  }
  
  class f
    implements View.OnKeyListener
  {
    f() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
      {
        Log.debug("IMRE_3.7.1", "Back button pressed while fullscreen audio was playing");
        MRAIDAudioVideoController.this.audioplayer.releasePlayer(true);
        return true;
      }
      return false;
    }
  }
  
  class g
    implements View.OnTouchListener
  {
    g() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */