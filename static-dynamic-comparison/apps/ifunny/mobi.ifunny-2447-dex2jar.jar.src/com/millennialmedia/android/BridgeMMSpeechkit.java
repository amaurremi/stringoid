package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class BridgeMMSpeechkit
        extends MMJSObject
        implements MediaPlayer.OnCompletionListener, BridgeMMMedia.Audio.PeriodicListener {
    private String a = "startRecording";
    private String d = "endRecording";
    private String e = "cacheAudio";
    private String f = "getSessionId";
    private String g = "playAudio";
    private String h = "textToSpeech";
    private String i = "stopAudio";
    private String j = "sampleBackgroundAudioLevel";
    private String k = "releaseVoice";
    private String l = "addCustomVoiceWords";
    private String m = "deleteCustomVoiceWords";

    private MMJSResponse a(Map<String, String> paramMap) {
        Object localObject = (Context) this.b.get();
        String str = (String) paramMap.get("path");
        if ((localObject != null) && (str != null)) {
            BridgeMMMedia.Audio localAudio = BridgeMMMedia.Audio.a((Context) localObject);
            if (localAudio == null) {
                return null;
            }
            if (localAudio.a()) {
                return MMJSResponse.b("Audio already playing.");
            }
            if (str.startsWith("http")) {
                return localAudio.a(Uri.parse(str), Boolean.parseBoolean((String) paramMap.get("repeat")));
            }
            localObject = AdCache.g((Context) localObject, str);
            if (((File) localObject).exists()) {
                return localAudio.a(Uri.fromFile((File) localObject), Boolean.parseBoolean((String) paramMap.get("repeat")));
            }
        }
        return null;
    }

    static void a(NVASpeechKit paramNVASpeechKit) {
        b().release();
        b().setSpeechKit(paramNVASpeechKit);
    }

    static boolean a() {
        return b().release();
    }

    static BridgeMMSpeechkit.SpeechKitHolder b() {
        return BridgeMMSpeechkit.SingletonHolder.INSTANCE;
    }

    static NVASpeechKit c() {
        return b().getSpeechKit();
    }

    private NVASpeechKit e() {
        Object localObject = (MMWebView) this.c.get();
        if ((localObject != null) && (((MMWebView) localObject).y())) {
            if (c() != null) {
                return c();
            }
            Context localContext = ((MMWebView) localObject).getContext();
            if (localContext != null) {
                localObject = new NVASpeechKit((MMWebView) localObject);
                a((NVASpeechKit) localObject);
                HandShake.NuanceCredentials localNuanceCredentials = HandShake.a(localContext).j;
                if (localNuanceCredentials != null) {
                    ((NVASpeechKit) localObject).initialize(localNuanceCredentials, localContext.getApplicationContext());
                }
                return (NVASpeechKit) localObject;
            }
        }
        return null;
    }

    private NVASpeechKit f() {
        MMWebView localMMWebView = (MMWebView) this.c.get();
        if ((localMMWebView != null) && (localMMWebView.z())) {
            return c();
        }
        return null;
    }

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if (this.a.equals(paramString)) {
            localMMJSResponse = startRecording(paramMap);
        }
        do {
            return localMMJSResponse;
            if (this.d.equals(paramString)) {
                return endRecording(paramMap);
            }
            if (this.e.equals(paramString)) {
                return cacheAudio(paramMap);
            }
            if (this.f.equals(paramString)) {
                return getSessionId(paramMap);
            }
            if (this.g.equals(paramString)) {
                return playAudio(paramMap);
            }
            if (this.h.equals(paramString)) {
                return textToSpeech(paramMap);
            }
            if (this.i.equals(paramString)) {
                return stopAudio(paramMap);
            }
            if (this.j.equals(paramString)) {
                return sampleBackgroundAudioLevel(paramMap);
            }
            if (this.k.equals(paramString)) {
                return releaseVoice(paramMap);
            }
            if (this.l.equals(paramString)) {
                return addCustomVoiceWords(paramMap);
            }
        } while (!this.m.equals(paramString));
        return deleteCustomVoiceWords(paramMap);
    }

    void a(String paramString) {
        MMWebView localMMWebView = (MMWebView) this.c.get();
        if (localMMWebView != null) {
            localMMWebView.loadUrl(paramString);
        }
    }

    public MMJSResponse addCustomVoiceWords(Map<String, String> paramMap) {
        NVASpeechKit localNVASpeechKit = e();
        if (localNVASpeechKit == null) {
            return MMJSResponse.b("Unable to create speech kit");
        }
        paramMap = (String) paramMap.get("words");
        if (!TextUtils.isEmpty(paramMap)) {
            String[] arrayOfString = paramMap.split(",");
            localNVASpeechKit.updateCustomWords(NVASpeechKit.CustomWordsOp.Add, arrayOfString);
            a("javascript:MMJS.sdk.customVoiceWordsAdded()");
            return MMJSResponse.a("Added " + paramMap);
        }
        return null;
    }

    public MMJSResponse cacheAudio(Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("url");
        if (!URLUtil.isValidUrl(paramMap)) {
            return MMJSResponse.b("Invalid url");
        }
        if (this.b != null) {
            Context localContext = (Context) this.b.get();
            if ((localContext != null) && (AdCache.b(paramMap, paramMap.substring(paramMap.lastIndexOf("/") + 1), localContext))) {
                a("javascript:MMJS.sdk.audioCached()");
                return MMJSResponse.a("Successfully cached audio at " + paramMap);
            }
        }
        return MMJSResponse.b("Failed to cache audio at" + paramMap);
    }

    public MMJSResponse deleteCustomVoiceWords(Map<String, String> paramMap) {
        NVASpeechKit localNVASpeechKit = e();
        if (localNVASpeechKit == null) {
            return MMJSResponse.b("Unable to create speech kit");
        }
        paramMap = (String) paramMap.get("words");
        if (!TextUtils.isEmpty(paramMap)) {
            String[] arrayOfString = paramMap.split(",");
            localNVASpeechKit.updateCustomWords(NVASpeechKit.CustomWordsOp.Remove, arrayOfString);
            a("javascript:MMJS.sdk.customVoiceWordsDeleted()");
            return MMJSResponse.a("Deleted " + paramMap);
        }
        return null;
    }

    public MMJSResponse endRecording(Map<String, String> paramMap) {
        paramMap = f();
        if (paramMap == null) {
            return MMJSResponse.b("Unable to get speech kit");
        }
        try {
            if (paramMap.endRecording()) {
                MMJSResponse localMMJSResponse = MMJSResponse.a();
                return localMMJSResponse;
            }
        } finally {
        }
        return MMJSResponse.b("Failed in speechKit");
    }

    public MMJSResponse getSessionId(Map<String, String> paramMap) {
        paramMap = f();
        if (paramMap == null) {
            return MMJSResponse.b("No SpeechKit session open.");
        }
        paramMap = paramMap.f();
        if (!TextUtils.isEmpty(paramMap)) {
            return MMJSResponse.a(paramMap);
        }
        return MMJSResponse.b("No SpeechKit session open.");
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        a("javascript:MMJS.sdk.audioCompleted()");
        paramMediaPlayer = (Context) this.b.get();
        if (paramMediaPlayer != null) {
            paramMediaPlayer = BridgeMMMedia.Audio.a(paramMediaPlayer);
            if (paramMediaPlayer != null) {
                paramMediaPlayer.b(this);
                paramMediaPlayer.b(this);
            }
        }
    }

    public void onUpdate(int paramInt) {
        a("javascript:MMJS.sdk.audioPositionChange(" + paramInt + ")");
    }

    public MMJSResponse playAudio(Map<String, String> paramMap) {
        if (e() == null) {
            paramMap = MMJSResponse.b("Unable to create speech kit");
        }
        Object localObject1;
        do {
            do {
                return paramMap;
                if (!URLUtil.isValidUrl((String) paramMap.get("url"))) {
                    return MMJSResponse.b("Invalid url");
                }
                localObject1 = (String) paramMap.get("url");
                if (TextUtils.isEmpty((CharSequence) localObject1)) {
                    break;
                }
                Object localObject2 = (Context) this.b.get();
                if (localObject2 == null) {
                    break;
                }
                localObject2 = BridgeMMMedia.Audio.a((Context) localObject2);
                if (localObject2 != null) {
                    ((BridgeMMMedia.Audio) localObject2).a(this);
                    ((BridgeMMMedia.Audio) localObject2).a(this);
                }
                paramMap.put("path", localObject1);
                localObject1 = a(paramMap);
                paramMap = (Map<String, String>) localObject1;
            } while (localObject1 == null);
            paramMap = (Map<String, String>) localObject1;
        } while (((MMJSResponse) localObject1).c != 1);
        a("javascript:MMJS.sdk.audioStarted()");
        return (MMJSResponse) localObject1;
        return null;
    }

    public MMJSResponse releaseVoice(Map<String, String> paramMap) {
        if (a()) {
            return MMJSResponse.b("Unable to get speech kit");
        }
        return MMJSResponse.a("released speechkit");
    }

    public MMJSResponse sampleBackgroundAudioLevel(Map<String, String> paramMap) {
        paramMap = e();
        if (paramMap == null) {
            return MMJSResponse.b("Unable to create speech kit");
        }
        paramMap.startSampleRecording();
        return null;
    }

    public MMJSResponse startRecording(Map<String, String> paramMap) {
        NVASpeechKit localNVASpeechKit = e();
        if (localNVASpeechKit == null) {
            return MMJSResponse.b("Unable to create speech kit");
        }
        String str = (String) paramMap.get("language");
        paramMap = str;
        if (TextUtils.isEmpty(str)) {
            paramMap = "en_GB";
        }
        if (localNVASpeechKit.startRecording(paramMap)) {
            return MMJSResponse.a();
        }
        return MMJSResponse.b("Failed in speechKit");
    }

    public MMJSResponse stopAudio(Map<String, String> paramMap) {
        paramMap = f();
        if (paramMap == null) {
            return MMJSResponse.b("Unable to get speech kit");
        }
        paramMap.stopActions();
        if (this.b != null) {
            paramMap = BridgeMMMedia.Audio.a((Context) this.b.get());
            if (paramMap != null) {
                return paramMap.b();
            }
        }
        return MMJSResponse.a();
    }

    public MMJSResponse textToSpeech(Map<String, String> paramMap) {
        MMLog.b("BridgeMMSpeechkit", "@@-Calling textToSpeech");
        NVASpeechKit localNVASpeechKit = e();
        if (localNVASpeechKit == null) {
            return MMJSResponse.b("Unable to create speech kit");
        }
        String str1 = (String) paramMap.get("language");
        String str2 = (String) paramMap.get("text");
        paramMap = str1;
        if (TextUtils.isEmpty(str1)) {
            paramMap = "en_GB";
        }
        localNVASpeechKit.stopActions();
        if (localNVASpeechKit.textToSpeech(str2, paramMap)) {
            return MMJSResponse.a();
        }
        return MMJSResponse.b("Failed in speechKit");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMSpeechkit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */