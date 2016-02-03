package com.inmobi.re.container;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDBasic;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.MRAIDResizeController;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayer.playerState;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class IMWebView$i
        extends Handler {
    private final WeakReference<IMWebView> a;
    private final WeakReference<MRAIDExpandController> b;
    private final WeakReference<MRAIDResizeController> c;
    private final WeakReference<MRAIDBasic> d;
    private final WeakReference<MRAIDInterstitialController> e;
    private final WeakReference<MRAIDAudioVideoController> f;

    public IMWebView$i(IMWebView paramIMWebView, MRAIDBasic paramMRAIDBasic, MRAIDExpandController paramMRAIDExpandController, MRAIDInterstitialController paramMRAIDInterstitialController, MRAIDAudioVideoController paramMRAIDAudioVideoController, MRAIDResizeController paramMRAIDResizeController) {
        this.a = new WeakReference(paramIMWebView);
        this.b = new WeakReference(paramMRAIDExpandController);
        this.d = new WeakReference(paramMRAIDBasic);
        this.e = new WeakReference(paramMRAIDInterstitialController);
        this.f = new WeakReference(paramMRAIDAudioVideoController);
        this.c = new WeakReference(paramMRAIDResizeController);
    }

    public void handleMessage(Message paramMessage) {
        IMWebView localIMWebView;
        Object localObject3;
        MRAIDResizeController localMRAIDResizeController;
        MRAIDInterstitialController localMRAIDInterstitialController;
        Object localObject2;
        for (; ; ) {
            MRAIDExpandController localMRAIDExpandController;
            MRAIDAudioVideoController localMRAIDAudioVideoController;
            try {
                localIMWebView = (IMWebView) this.a.get();
                localObject3 = (MRAIDBasic) this.d.get();
                localMRAIDExpandController = (MRAIDExpandController) this.b.get();
                localMRAIDResizeController = (MRAIDResizeController) this.c.get();
                localMRAIDInterstitialController = (MRAIDInterstitialController) this.e.get();
                localMRAIDAudioVideoController = (MRAIDAudioVideoController) this.f.get();
                if (localIMWebView != null) {
                    Log.debug("[InMobi]-[RE]-4.5.1", "IMWebView->handleMessage: msg: " + paramMessage);
                    localObject2 = paramMessage.getData();
                }
                switch (paramMessage.what) {
                    case 1031:
                        super.handleMessage(paramMessage);
                        return;
                }
            } catch (Exception paramMessage) {
                Log.internal("[InMobi]-[RE]-4.5.1", "Webview Handle Message Exception ", paramMessage);
                return;
            }
            if (localIMWebView.mListener != null) {
                localIMWebView.mListener.onResizeClose();
                continue;
                if (localIMWebView.mListener != null) {
                    localIMWebView.mListener.onExpandClose();
                    continue;
                    switch (IMWebView.n.a[IMWebView.b(localIMWebView).ordinal()]) {
                        case 5:
                            if (localIMWebView.mIsInterstitialAd) {
                                localMRAIDInterstitialController.resetContentsForInterstitials();
                            }
                            break;
                        case 1:
                        case 2:
                            localMRAIDResizeController.closeResized();
                            break;
                        case 3:
                        case 4:
                            label364:
                            localMRAIDExpandController.closeExpanded();
                            localMRAIDExpandController.mIsExpandUrlValid = false;
                            continue;
                            localIMWebView.hide();
                            continue;
                            localIMWebView.setVisibility(4);
                            localIMWebView.setState(IMWebView.ViewState.HIDDEN);
                            continue;
                            localIMWebView.injectJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
                            localIMWebView.setVisibility(0);
                            continue;
                            if (IMWebView.b(localIMWebView) == IMWebView.ViewState.RESIZING) {
                                localMRAIDResizeController.doResize((Bundle) localObject2);
                                continue;
                                if (IMWebView.b(localIMWebView) == IMWebView.ViewState.EXPANDING) {
                                    localMRAIDExpandController.doExpand((Bundle) localObject2);
                                }
                                IMWebView.n(localIMWebView).setWebViewClosed(false);
                                continue;
                                try {
                                    localMRAIDAudioVideoController.playAudioImpl((Bundle) localObject2, IMWebView.i(localIMWebView));
                                } catch (Exception localException1) {
                                    Log.debug("[InMobi]-[RE]-4.5.1", "Play audio failed ", localException1);
                                }
                                continue;
                                try {
                                    localException1.playVideoImpl((Bundle) localObject2, IMWebView.i(localIMWebView));
                                } catch (Exception localException2) {
                                    Log.debug("[InMobi]-[RE]-4.5.1", "Play video failed ", localException2);
                                }
                                continue;
                                localObject1 = (AVPlayer) localException2.audioPlayerList.get(((Bundle) localObject2).getString("aplayerref"));
                                if (localObject1 != null) {
                                    ((AVPlayer) localObject1).pause();
                                    continue;
                                    localObject1 = (AVPlayer) ((MRAIDAudioVideoController) localObject1).audioPlayerList.get(((Bundle) localObject2).getString("aplayerref"));
                                    if (localObject1 != null) {
                                        ((AVPlayer) localObject1).mute();
                                        continue;
                                        localObject1 = (AVPlayer) ((MRAIDAudioVideoController) localObject1).audioPlayerList.get(((Bundle) localObject2).getString("aplayerref"));
                                        if (localObject1 != null) {
                                            ((AVPlayer) localObject1).unMute();
                                            continue;
                                            localObject1 = (AVPlayer) ((MRAIDAudioVideoController) localObject1).audioPlayerList.get(((Bundle) localObject2).getString("aplayerref"));
                                            if (localObject1 != null) {
                                                ((AVPlayer) localObject1).setVolume(((Bundle) localObject2).getInt("vol"));
                                                continue;
                                                ((AVPlayer) paramMessage.obj).seekPlayer(((Bundle) localObject2).getInt("seekaudio") * 1000);
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
        Object localObject1 = ((MRAIDAudioVideoController) localObject1).getVideoPlayer(((Bundle) localObject2).getString("pid"));
        if (localObject1 == null) {
        }
        for (localObject1 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"pauseVideo\")"; ; localObject1 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"pauseVideo\")") {
            localIMWebView.injectJavaScript((String) localObject1);
            break;
            if (((AVPlayer) localObject1).getState() != AVPlayer.playerState.PLAYING) {
                if (((AVPlayer) localObject1).getState() != AVPlayer.playerState.INIT) {
                    continue;
                }
                if (((AVPlayer) localObject1).isPrepared()) {
                    break;
                }
                ((AVPlayer) localObject1).setAutoPlay(false);
                break;
            }
            ((AVPlayer) localObject1).pause();
            return;
            ((AVPlayer) paramMessage.obj).releasePlayer(false);
            break;
            localObject2 = ((Bundle) localObject2).getString("pid");
            localObject3 = ((MRAIDAudioVideoController) localObject1).getVideoPlayer((String) localObject2);
            if (localObject3 == null) {
            }
            for (localObject1 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"hideVideo\")"; ; localObject1 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"hideVideo\")") {
                localIMWebView.injectJavaScript((String) localObject1);
                break;
                if (((AVPlayer) localObject3).getState() != AVPlayer.playerState.RELEASED) {
                    break label816;
                }
            }
            label816:
            ((MRAIDAudioVideoController) localObject1).videoPlayerList.put(localObject2, localObject3);
            ((AVPlayer) localObject3).hide();
            return;
            localObject2 = ((Bundle) localObject2).getString("pid");
            localObject3 = ((MRAIDAudioVideoController) localObject1).getVideoPlayer((String) localObject2);
            if (localObject3 == null) {
                localObject1 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"showVideo\")";
            }
            for (; ; ) {
                localIMWebView.injectJavaScript((String) localObject1);
                break;
                if ((((AVPlayer) localObject3).getState() != AVPlayer.playerState.RELEASED) && (((AVPlayer) localObject3).getState() != AVPlayer.playerState.HIDDEN)) {
                    localObject1 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"showVideo\")";
                } else {
                    if ((((MRAIDAudioVideoController) localObject1).videoPlayer == null) || (((MRAIDAudioVideoController) localObject1).videoPlayer.getPropertyID().equalsIgnoreCase((String) localObject2))) {
                        break label926;
                    }
                    localObject1 = "window.mraid.broadcastEvent('error',\"Show failed. There is already a video playing\", \"showVideo\")";
                }
            }
            label926:
            ((MRAIDAudioVideoController) localObject1).videoPlayerList.remove(localObject2);
            ((MRAIDAudioVideoController) localObject1).videoPlayer = ((AVPlayer) localObject3);
            ((AVPlayer) localObject3).show();
            return;
            ((AVPlayer) paramMessage.obj).mute();
            break;
            ((AVPlayer) paramMessage.obj).unMute();
            break;
            ((AVPlayer) paramMessage.obj).seekPlayer(((Bundle) localObject2).getInt("seek") * 1000);
            break;
            ((AVPlayer) paramMessage.obj).setVolume(((Bundle) localObject2).getInt("volume"));
            break;
            localObject1 = ((Bundle) localObject2).getString("message");
            localObject2 = ((Bundle) localObject2).getString("action");
            localIMWebView.injectJavaScript("window.mraid.broadcastEvent('error',\"" + (String) localObject1 + "\", \"" + (String) localObject2 + "\")");
            break;
            localIMWebView.setCloseButton();
            break;
            localIMWebView.disableCloseRegion();
            break;
            ((MRAIDAudioVideoController) localObject1).hidePlayers();
            break;
            ((MRAIDBasic) localObject3).open(((Bundle) localObject2).getString("expand_url"));
            break;
            localObject1 = ((Bundle) localObject2).getString("injectMessage");
            if (localObject1 == null) {
                break;
            }
            localIMWebView.loadUrl("javascript:" + (String) localObject1);
            break;
            localMRAIDInterstitialController.handleOrientationForInterstitial();
            break;
            if (localIMWebView.mIsInterstitialAd) {
                break;
            }
            localMRAIDResizeController.onOrientationChange();
            break;
            if (localIMWebView.mListener == null) {
                break;
            }
            localIMWebView.mListener.onDismissAdScreen();
            break;
            ((MRAIDBasic) localObject3).getCurrentPosition();
            break;
            ((MRAIDBasic) localObject3).getDefaultPosition();
            break;
            localObject1 = (HashMap) paramMessage.getData().getSerializable("map");
            if (localIMWebView.mListener == null) {
                break;
            }
            localIMWebView.mListener.onUserInteraction((Map) localObject1);
            break;
            localObject1 = (HashMap) paramMessage.getData().getSerializable("incent_ad_map");
            if (localIMWebView.mListener == null) {
                break;
            }
            localIMWebView.mListener.onIncentCompleted((Map) localObject1);
            break;
            break;
            break label364;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */