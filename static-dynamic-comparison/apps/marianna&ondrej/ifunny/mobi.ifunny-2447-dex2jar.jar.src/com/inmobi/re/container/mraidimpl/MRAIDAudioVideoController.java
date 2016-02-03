package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.JSController.Dimensions;
import com.inmobi.re.controller.JSController.ExpandProperties;
import com.inmobi.re.controller.JSController.PlayerProperties;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayer.playerState;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MRAIDAudioVideoController {
    private IMWebView a;
    public Hashtable<String, AVPlayer> audioPlayerList = new Hashtable();
    public AVPlayer audioplayer;
    public AVPlayer videoPlayer;
    public Hashtable<String, AVPlayer> videoPlayerList = new Hashtable();
    public int videoValidateWidth;

    public MRAIDAudioVideoController(IMWebView paramIMWebView) {
        this.a = paramIMWebView;
    }

    private AVPlayer a(String paramString) {
        if (!this.videoPlayerList.isEmpty()) {
            return (AVPlayer) this.videoPlayerList.get(paramString);
        }
        return null;
    }

    private void a(AVPlayer paramAVPlayer, JSController.Dimensions paramDimensions) {
        int i = (int) (-99999.0F * this.a.getDensity());
        FrameLayout.LayoutParams localLayoutParams1;
        FrameLayout.LayoutParams localLayoutParams2;
        if (paramAVPlayer.isInlineVideo()) {
            localLayoutParams1 = new FrameLayout.LayoutParams(paramDimensions.width, paramDimensions.height);
            localLayoutParams2 = (FrameLayout.LayoutParams) paramAVPlayer.getLayoutParams();
            if ((paramDimensions.x != i) || (paramDimensions.y != i)) {
                break label94;
            }
            localLayoutParams1.leftMargin = localLayoutParams2.leftMargin;
        }
        for (localLayoutParams1.topMargin = localLayoutParams2.topMargin; ; localLayoutParams1.topMargin = paramDimensions.y) {
            localLayoutParams1.gravity = 3;
            paramAVPlayer.setLayoutParams(localLayoutParams1);
            return;
            label94:
            localLayoutParams1.leftMargin = paramDimensions.x;
        }
    }

    private boolean a(String paramString1, String paramString2, Activity paramActivity) {
        if (!this.audioPlayerList.isEmpty()) {
            this.audioplayer = ((AVPlayer) this.audioPlayerList.get(paramString1));
            if (this.audioplayer == null) {
                if (this.audioPlayerList.size() > 4) {
                    this.a.raiseError("Too many audio players", "playAudio");
                    return false;
                }
                this.audioplayer = new AVPlayer(paramActivity, this.a);
            }
        }
        for (; ; ) {
            return true;
            if ((this.audioplayer.getMediaURL().equals(paramString2)) || (paramString2.length() == 0)) {
                if (this.audioplayer.getState() == AVPlayer.playerState.PLAYING) {
                    return false;
                }
                if (this.audioplayer.getState() == AVPlayer.playerState.INIT) {
                    if (this.audioplayer.isPrepared()) {
                        this.audioplayer.start();
                    }
                    for (; ; ) {
                        return false;
                        this.audioplayer.setAutoPlay(true);
                    }
                }
                if (this.audioplayer.getState() == AVPlayer.playerState.PAUSED) {
                    this.audioplayer.start();
                    return false;
                }
                paramString2 = this.audioplayer.getProperties();
                String str = this.audioplayer.getMediaURL();
                this.audioplayer.releasePlayer(false);
                this.audioPlayerList.remove(paramString1);
                this.audioplayer = new AVPlayer(paramActivity, this.a);
                this.audioplayer.setPlayData(paramString2, str);
            } else {
                this.audioplayer.releasePlayer(false);
                this.audioPlayerList.remove(paramString1);
                this.audioplayer = new AVPlayer(paramActivity, this.a);
                continue;
                this.audioplayer = new AVPlayer(paramActivity, this.a);
            }
        }
    }

    private boolean a(String paramString1, String paramString2, Activity paramActivity, JSController.Dimensions paramDimensions) {
        if ((this.videoPlayer == null) || (!paramString1.equalsIgnoreCase(this.videoPlayer.getPropertyID()))) {
            return b(paramString1, paramString2, paramActivity);
        }
        AVPlayer.playerState localplayerState = this.videoPlayer.getState();
        if (paramString1.equalsIgnoreCase(this.videoPlayer.getPropertyID())) {
            paramString1 = this.videoPlayer.getMediaURL();
            if ((paramString2.length() == 0) || (paramString2.equalsIgnoreCase(paramString1))) {
                switch (MRAIDAudioVideoController.e.a[localplayerState.ordinal()]) {
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
                for (; ; ) {
                    a(this.videoPlayer, paramDimensions);
                    return false;
                    this.videoPlayer.setAutoPlay(true);
                }
            }
            if (!URLUtil.isValidUrl(paramString2)) {
                this.a.raiseError("Request must specify a valid URL", "playVideo");
                return false;
            }
            this.videoPlayer.releasePlayer(false);
            this.videoPlayer = new AVPlayer(paramActivity, this.a);
        }
        return true;
    }

    private boolean a(Hashtable<String, AVPlayer> paramHashtable, AVPlayer paramAVPlayer) {
        paramHashtable = paramHashtable.entrySet().iterator();
        Map.Entry localEntry;
        do {
            if (!paramHashtable.hasNext()) {
                break;
            }
            localEntry = (Map.Entry) paramHashtable.next();
        } while (localEntry.getValue() != paramAVPlayer);
        for (paramHashtable = (String) localEntry.getKey(); ; paramHashtable = null) {
            if (paramHashtable != null) {
                this.audioPlayerList.remove(paramHashtable);
                return true;
            }
            return false;
        }
    }

    private boolean b(String paramString1, String paramString2, Activity paramActivity) {
        if (((paramString2.length() != 0) && (!URLUtil.isValidUrl(paramString2))) || ((paramString2.length() == 0) && (!this.videoPlayerList.containsKey(paramString1)))) {
            this.a.raiseError("Request must specify a valid URL", "playVideo");
            return false;
        }
        if (this.videoPlayer != null) {
            this.videoPlayer.hide();
            this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
        }
        AVPlayer localAVPlayer = a(paramString1);
        if (localAVPlayer == null) {
        }
        for (this.videoPlayer = new AVPlayer(paramActivity, this.a); ; this.videoPlayer = localAVPlayer) {
            if (paramString2.length() == 0) {
                this.videoPlayer.setPlayData(localAVPlayer.getProperties(), localAVPlayer.getMediaURL());
                this.videoPlayer.setPlayDimensions(localAVPlayer.getPlayDimensions());
            }
            this.videoPlayerList.remove(paramString1);
            return true;
        }
    }

    /* Error */
    public AVPlayer getCurrentAudioPlayer(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aconst_null
        //   3: astore_3
        //   4: aload_0
        //   5: getfield 92	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   8: ifnull +26 -> 34
        //   11: aload_0
        //   12: getfield 92	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   15: invokevirtual 166	com/inmobi/re/controller/util/AVPlayer:getPropertyID	()Ljava/lang/String;
        //   18: aload_1
        //   19: invokevirtual 170	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   22: ifeq +12 -> 34
        //   25: aload_0
        //   26: getfield 92	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   29: astore_2
        //   30: aload_0
        //   31: monitorexit
        //   32: aload_2
        //   33: areturn
        //   34: aload_3
        //   35: astore_2
        //   36: aload_0
        //   37: getfield 27	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
        //   40: invokevirtual 36	java/util/Hashtable:isEmpty	()Z
        //   43: ifne -13 -> 30
        //   46: aload_3
        //   47: astore_2
        //   48: aload_0
        //   49: getfield 27	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
        //   52: aload_1
        //   53: invokevirtual 230	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
        //   56: ifeq -26 -> 30
        //   59: aload_0
        //   60: getfield 27	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
        //   63: aload_1
        //   64: invokevirtual 40	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   67: checkcast 42	com/inmobi/re/controller/util/AVPlayer
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
    public AVPlayer getVideoPlayer(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aconst_null
        //   3: astore_3
        //   4: aload_0
        //   5: getfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   8: ifnull +26 -> 34
        //   11: aload_0
        //   12: getfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   15: invokevirtual 166	com/inmobi/re/controller/util/AVPlayer:getPropertyID	()Ljava/lang/String;
        //   18: aload_1
        //   19: invokevirtual 170	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   22: ifeq +12 -> 34
        //   25: aload_0
        //   26: getfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   29: astore_2
        //   30: aload_0
        //   31: monitorexit
        //   32: aload_2
        //   33: areturn
        //   34: aload_3
        //   35: astore_2
        //   36: aload_0
        //   37: getfield 25	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
        //   40: invokevirtual 36	java/util/Hashtable:isEmpty	()Z
        //   43: ifne -13 -> 30
        //   46: aload_3
        //   47: astore_2
        //   48: aload_0
        //   49: getfield 25	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
        //   52: aload_1
        //   53: invokevirtual 230	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
        //   56: ifeq -26 -> 30
        //   59: aload_0
        //   60: getfield 25	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
        //   63: aload_1
        //   64: invokevirtual 40	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   67: checkcast 42	com/inmobi/re/controller/util/AVPlayer
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

    public void hidePlayers() {
        Log.debug("[InMobi]-[RE]-4.5.1", "MRAIDAudioVideoController: hiding all players");
        if ((this.videoPlayer != null) && (this.videoPlayer.getState() != AVPlayer.playerState.RELEASED)) {
            this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
            this.videoPlayer.hide();
        }
        Iterator localIterator = this.audioPlayerList.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            AVPlayer localAVPlayer = (AVPlayer) localEntry.getValue();
            switch (MRAIDAudioVideoController.e.a[localAVPlayer.getState().ordinal()]) {
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

    public void mediaPlayerReleased(AVPlayer paramAVPlayer) {
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

    public void playAudioImpl(Bundle paramBundle, Activity paramActivity) {
        JSController.PlayerProperties localPlayerProperties = (JSController.PlayerProperties) paramBundle.getParcelable("player_properties");
        Object localObject = paramBundle.getString("expand_url");
        paramBundle = (Bundle) localObject;
        if (localObject == null) {
            paramBundle = "";
        }
        if (!a(localPlayerProperties.id, paramBundle, paramActivity)) {
        }
        do {
            return;
            if (((paramBundle.length() != 0) && (!URLUtil.isValidUrl(paramBundle))) || ((paramBundle.length() == 0) && (!this.audioPlayerList.containsKey(localPlayerProperties.id)))) {
                this.a.raiseError("Request must specify a valid URL", "playAudio");
                return;
            }
        } while (this.audioplayer == null);
        if (paramBundle.length() != 0) {
            this.audioplayer.setPlayData(localPlayerProperties, paramBundle);
        }
        this.audioPlayerList.put(localPlayerProperties.id, this.audioplayer);
        paramBundle = (FrameLayout) paramActivity.findViewById(16908290);
        if (localPlayerProperties.isFullScreen()) {
            localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
            ((RelativeLayout.LayoutParams) localObject).addRule(13);
            this.audioplayer.setLayoutParams((ViewGroup.LayoutParams) localObject);
            paramActivity = new RelativeLayout(paramActivity);
            paramActivity.setOnTouchListener(new MRAIDAudioVideoController.g(this));
            paramActivity.setBackgroundColor(-16777216);
            paramBundle.addView(paramActivity, new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            paramActivity.addView(this.audioplayer);
            this.audioplayer.setBackGroundLayout(paramActivity);
            this.audioplayer.requestFocus();
            this.audioplayer.setOnKeyListener(new MRAIDAudioVideoController.f(this));
        }
        for (; ; ) {
            this.audioplayer.setListener(new MRAIDAudioVideoController.b(this, localPlayerProperties));
            this.audioplayer.play();
            return;
            this.audioplayer.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            paramBundle.addView(this.audioplayer);
        }
    }

    public void playVideoImpl(Bundle paramBundle, Activity paramActivity) {
        Object localObject1 = (JSController.PlayerProperties) paramBundle.getParcelable("player_properties");
        Object localObject2 = (JSController.Dimensions) paramBundle.getParcelable("expand_dimensions");
        Log.debug("[InMobi]-[RE]-4.5.1", "Final dimensions: " + localObject2);
        paramBundle = paramBundle.getString("expand_url");
        if (!a(((JSController.PlayerProperties) localObject1).id, paramBundle, paramActivity, (JSController.Dimensions) localObject2)) {
            return;
        }
        this.a.setBusy(true);
        if (paramBundle.length() == 0) {
            localObject1 = this.videoPlayer.getProperties();
            paramBundle = this.videoPlayer.getPlayDimensions();
            this.videoPlayer.getMediaURL();
        }
        while (this.videoPlayer.getState() == AVPlayer.playerState.HIDDEN) {
            this.videoPlayer.pseudoPause = true;
            this.videoPlayer.show();
            return;
            this.videoPlayer.setPlayData((JSController.PlayerProperties) localObject1, paramBundle);
            this.videoPlayer.setPlayDimensions((JSController.Dimensions) localObject2);
            paramBundle = (Bundle) localObject2;
        }
        localObject2 = (FrameLayout) paramActivity.findViewById(16908290);
        if (((JSController.PlayerProperties) localObject1).isFullScreen()) {
            paramBundle = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
            paramBundle.addRule(13);
            this.videoPlayer.setLayoutParams(paramBundle);
            paramBundle = new RelativeLayout(paramActivity);
            paramBundle.setOnTouchListener(new MRAIDAudioVideoController.a(this));
            paramBundle.setBackgroundColor(-16777216);
            ((FrameLayout) localObject2).addView(paramBundle, new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            paramBundle.addView(this.videoPlayer);
            this.videoPlayer.setBackGroundLayout(paramBundle);
            this.videoPlayer.requestFocus();
            this.videoPlayer.setOnKeyListener(new MRAIDAudioVideoController.d(this));
            this.videoPlayer.setListener(new MRAIDAudioVideoController.c(this));
            this.videoPlayer.play();
            return;
        }
        localObject1 = new FrameLayout.LayoutParams(paramBundle.width, paramBundle.height);
        paramActivity = new FrameLayout(paramActivity);
        if (this.a.mExpandController.expandProperties == null) {
            ((FrameLayout.LayoutParams) localObject1).leftMargin = paramBundle.x;
        }
        for (((FrameLayout.LayoutParams) localObject1).topMargin = paramBundle.y; ; ((FrameLayout.LayoutParams) localObject1).topMargin = (paramBundle.y + this.a.mExpandController.expandProperties.currentY)) {
            ((FrameLayout.LayoutParams) localObject1).gravity = 3;
            this.videoPlayer.setLayoutParams((ViewGroup.LayoutParams) localObject1);
            ((FrameLayout) localObject2).addView(paramActivity, new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            this.videoPlayer.setBackGroundLayout(paramActivity);
            paramActivity.addView(this.videoPlayer);
            break;
            ((FrameLayout.LayoutParams) localObject1).leftMargin = (paramBundle.x + this.a.mExpandController.expandProperties.currentX);
        }
    }

    /* Error */
    public void releaseAllPlayers() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   4: ifnull +22 -> 26
        //   7: aload_0
        //   8: getfield 25	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
        //   11: aload_0
        //   12: getfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   15: invokevirtual 166	com/inmobi/re/controller/util/AVPlayer:getPropertyID	()Ljava/lang/String;
        //   18: aload_0
        //   19: getfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   22: invokevirtual 237	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   25: pop
        //   26: aload_0
        //   27: getfield 25	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
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
        //   46: if_icmpge +49 -> 95
        //   49: aload_3
        //   50: iload_1
        //   51: aaload
        //   52: astore 4
        //   54: aload 4
        //   56: checkcast 42	com/inmobi/re/controller/util/AVPlayer
        //   59: getstatic 449	com/inmobi/re/container/IMWebView:userInitiatedClose	Z
        //   62: invokevirtual 153	com/inmobi/re/controller/util/AVPlayer:releasePlayer	(Z)V
        //   65: iload_1
        //   66: iconst_1
        //   67: iadd
        //   68: istore_1
        //   69: goto -25 -> 44
        //   72: astore 4
        //   74: ldc -4
        //   76: ldc_w 451
        //   79: invokestatic 454	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   82: goto -17 -> 65
        //   85: astore_3
        //   86: ldc -4
        //   88: ldc_w 456
        //   91: aload_3
        //   92: invokestatic 459	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   95: aload_0
        //   96: getfield 25	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayerList	Ljava/util/Hashtable;
        //   99: invokevirtual 462	java/util/Hashtable:clear	()V
        //   102: aload_0
        //   103: aconst_null
        //   104: putfield 163	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:videoPlayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   107: aload_0
        //   108: getfield 27	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
        //   111: invokevirtual 440	java/util/Hashtable:values	()Ljava/util/Collection;
        //   114: invokeinterface 446 1 0
        //   119: astore_3
        //   120: aload_3
        //   121: arraylength
        //   122: istore_2
        //   123: iconst_0
        //   124: istore_1
        //   125: iload_1
        //   126: iload_2
        //   127: if_icmpge +49 -> 176
        //   130: aload_3
        //   131: iload_1
        //   132: aaload
        //   133: astore 4
        //   135: aload 4
        //   137: checkcast 42	com/inmobi/re/controller/util/AVPlayer
        //   140: getstatic 449	com/inmobi/re/container/IMWebView:userInitiatedClose	Z
        //   143: invokevirtual 153	com/inmobi/re/controller/util/AVPlayer:releasePlayer	(Z)V
        //   146: iload_1
        //   147: iconst_1
        //   148: iadd
        //   149: istore_1
        //   150: goto -25 -> 125
        //   153: astore 4
        //   155: ldc -4
        //   157: ldc_w 451
        //   160: invokestatic 454	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   163: goto -17 -> 146
        //   166: astore_3
        //   167: ldc -4
        //   169: ldc_w 456
        //   172: aload_3
        //   173: invokestatic 459	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   176: iconst_0
        //   177: putstatic 449	com/inmobi/re/container/IMWebView:userInitiatedClose	Z
        //   180: aload_0
        //   181: getfield 27	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioPlayerList	Ljava/util/Hashtable;
        //   184: invokevirtual 462	java/util/Hashtable:clear	()V
        //   187: aload_0
        //   188: aconst_null
        //   189: putfield 92	com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController:audioplayer	Lcom/inmobi/re/controller/util/AVPlayer;
        //   192: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	193	0	this	MRAIDAudioVideoController
        //   43	107	1	i	int
        //   41	87	2	j	int
        //   38	12	3	arrayOfObject1	Object[]
        //   85	7	3	localException1	Exception
        //   119	12	3	arrayOfObject2	Object[]
        //   166	7	3	localException2	Exception
        //   52	3	4	localObject1	Object
        //   72	1	4	localException3	Exception
        //   133	3	4	localObject2	Object
        //   153	1	4	localException4	Exception
        // Exception table:
        //   from	to	target	type
        //   54	65	72	java/lang/Exception
        //   26	42	85	java/lang/Exception
        //   74	82	85	java/lang/Exception
        //   135	146	153	java/lang/Exception
        //   107	123	166	java/lang/Exception
        //   155	163	166	java/lang/Exception
    }

    public void validateVideoDimensions(JSController.Dimensions paramDimensions) {
        paramDimensions.width = ((int) (paramDimensions.width * this.a.getDensity()));
        paramDimensions.height = ((int) (paramDimensions.height * this.a.getDensity()));
        paramDimensions.x = ((int) (paramDimensions.x * this.a.getDensity()));
        paramDimensions.y = ((int) (paramDimensions.y * this.a.getDensity()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */