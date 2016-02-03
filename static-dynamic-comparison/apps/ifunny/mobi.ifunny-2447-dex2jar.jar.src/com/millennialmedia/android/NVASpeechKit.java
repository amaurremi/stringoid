package com.millennialmedia.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadCommand.Listener;
import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericCommand.Listener;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.Recognizer.Listener;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.SpeechKit.CmdSetType;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.Vocalizer.Listener;
import com.nuance.nmdp.speechkit.recognitionresult.DetailedResult;
import com.nuance.nmdp.speechkit.util.dataupload.Action;
import com.nuance.nmdp.speechkit.util.dataupload.Action.ActionType;
import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.dataupload.Data.DataType;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary;

import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NVASpeechKit {
    private static String s = null;
    public NVASpeechKit.Result[] _results = null;
    HandShake.NuanceCredentials a;
    private WeakReference<MMWebView> b;
    private Vocalizer c;
    private SpeechKit d;
    private Handler e;
    private Recognizer.Listener f;
    private Vocalizer.Listener g;
    private Recognizer h;
    private NVASpeechKit.State i;
    private NVASpeechKit.AudioLevelTracker j = new NVASpeechKit.AudioLevelTracker();
    private DataUploadCommand k;
    private NVASpeechKit.CustomWordsOp l;
    private String m;
    private Runnable n = new NVASpeechKit
    .1(this);
    private Runnable o = new NVASpeechKit
    .2(this);
    private GenericCommand.Listener p = new NVASpeechKit
    .3(this);
    private DataUploadCommand.Listener q = new NVASpeechKit
    .4(this);
    private NVASpeechKit.Listener r = new NVASpeechKit
    .5(this);
    private String t;

    public NVASpeechKit(MMWebView paramMMWebView) {
        if (paramMMWebView != null) {
            this.b = new WeakReference(paramMMWebView);
            a(paramMMWebView.getContext().getApplicationContext());
        }
        this.i = NVASpeechKit.State.READY;
    }

    private String a(SpeechError paramSpeechError) {
        if (paramSpeechError == null) {
            return "No Error given";
        }
        return "Speech Kit Error code:" + paramSpeechError.getErrorCode() + " detail:" + paramSpeechError.getErrorDetail() + " suggestions:" + paramSpeechError.getSuggestion();
    }

    private JSONArray a(NVASpeechKit.Result[] paramArrayOfResult) {
        JSONArray localJSONArray = new JSONArray();
        int i1 = 0;
        while (i1 < paramArrayOfResult.length) {
            JSONObject localJSONObject = new JSONObject();
            try {
                localJSONObject.put("score", "" + paramArrayOfResult[i1].getResultScore());
                localJSONObject.put("result", paramArrayOfResult[i1].getResultString());
                localJSONArray.put(localJSONObject);
                i1 += 1;
            } catch (JSONException paramArrayOfResult) {
                MMLog.a("NVASpeechKit", "JSON creation error.", paramArrayOfResult);
                return null;
            }
        }
        return localJSONArray;
    }

    private void a(Context paramContext) {
        if (this.t == null) {
            this.t = paramContext.getApplicationContext().getPackageName();
        }
    }

    private void a(NVASpeechKit.State paramState) {
        try {
            MMLog.b("NVASpeechKit", "recording results returned. state=" + paramState);
            NVASpeechKit.State localState = this.i;
            this.i = paramState;
            if ((this.r != null) && (this.i != localState)) {
                this.r.onStateChange(paramState);
            }
            return;
        } finally {
            paramState =finally;
            throw paramState;
        }
    }

    private void a(Recognizer paramRecognizer) {
        this.e.removeCallbacks(this.o);
        this.e.postDelayed(this.o, 50L);
    }

    private void a(List<DetailedResult> paramList) {
        MMLog.b("NVASpeechKit", "processResults called.");
        this._results = new NVASpeechKit.Result[paramList.size()];
        paramList = paramList.iterator();
        int i1 = 0;
        while (paramList.hasNext()) {
            DetailedResult localDetailedResult = (DetailedResult) paramList.next();
            this._results[i1] = new NVASpeechKit.Result(this, localDetailedResult.toString(), localDetailedResult.getConfidenceScore());
            i1 += 1;
        }
    }

    private void b(SpeechError paramSpeechError) {
        switch (paramSpeechError.getErrorCode()) {
            case 3:
            case 4:
            default:
                if (this.r != null) {
                    this.r.onError();
                    a(NVASpeechKit.State.ERROR);
                    b(a(paramSpeechError));
                }
                return;
            case 2:
                if (!this.j.d) {
                    a(NVASpeechKit.State.PROCESSING);
                }
                this._results = new NVASpeechKit.Result[0];
                m();
                return;
        }
        a(NVASpeechKit.State.READY);
        this.h = null;
    }

    private byte[] c(String paramString) {
        if (paramString == null) {
            return null;
        }
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        int i1 = 0;
        while (i1 < arrayOfByte.length) {
            arrayOfByte[i1] = ((byte) Integer.parseInt(paramString.substring(i1 * 2, i1 * 2 + 2), 16));
            i1 += 1;
        }
        return arrayOfByte;
    }

    private MMWebView h() {
        if (this.b != null) {
            return (MMWebView) this.b.get();
        }
        return null;
    }

    private void i() {
        if (h() != null) {
            this.b.clear();
        }
    }

    private String j() {
        if (this.b != null) {
            MMWebView localMMWebView = (MMWebView) this.b.get();
            if (localMMWebView != null) {
                return localMMWebView.x();
            }
        }
        return "DEFAULT_AD_ID";
    }

    private Vocalizer.Listener k() {
        return new NVASpeechKit .6 (this);
    }

    private Recognizer.Listener l() {
        return new NVASpeechKit .7 (this);
    }

    private void m() {
        if ((this.r != null) && (this._results != null)) {
            if (!this.j.d) {
                break label60;
            }
            this.r.onAudioSampleUpdate(this.j.b);
            this.j.reset();
        }
        for (; ; ) {
            a(NVASpeechKit.State.READY);
            this.h = null;
            return;
            label60:
            this.r.onResults();
        }
    }

    private void n() {
        if (this.e != null) {
            this.e.removeCallbacks(this.n);
            this.e.removeCallbacks(this.o);
        }
    }

    void a() {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.voiceStateChange('ready')");
        }
    }

    void a(double paramDouble) {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.audioLevelChange(" + paramDouble + ")");
        }
    }

    void a(String paramString) {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.recognitionResult(" + paramString + ")");
        }
    }

    void b() {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.voiceStateChange('recording')");
        }
    }

    void b(double paramDouble) {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.backgroundAudioLevel(" + paramDouble + ")");
        }
    }

    void b(String paramString) {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.voiceError('" + paramString + "')");
        }
    }

    void c() {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.voiceStateChange('processing')");
        }
    }

    public void cancelRecording() {
        if (this.h != null) {
            MMLog.b("NVASpeechKit", "cancel RECORDING");
            this.h.cancel();
            this.h = null;
            a(NVASpeechKit.State.READY);
        }
    }

    void d() {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.voiceStateChange('vocalizing')");
        }
    }

    void e() {
        MMWebView localMMWebView = h();
        if (localMMWebView != null) {
            localMMWebView.loadUrl("javascript:MMJS.sdk.voiceStateChange('error')");
        }
    }

    public boolean endRecording() {
        if (this.h != null) {
            MMLog.b("NVASpeechKit", "end RECORDING");
            this.h.stopRecording();
            this.h = null;
            return true;
        }
        return false;
    }

    String f() {
        if (this.d != null) {
            return this.d.getSessionId();
        }
        return "";
    }

    String g() {
        for (; ; ) {
            try {
                if (s != null) {
                    localObject1 = s;
                    return (String) localObject1;
                }
                if (this.b == null) {
                    break label110;
                }
                localObject1 = (MMWebView) this.b.get();
                if (localObject1 == null) {
                    break label110;
                }
                localObject1 = ((MMWebView) localObject1).getContext();
                break label112;
                localObject1 = Settings.Secure.getString(((Context) localObject1).getContentResolver(), "android_id");
                if (localObject1 == null) {
                    localObject1 = null;
                    continue;
                }
            } finally {
                try {
                    Object localObject1 = MMSDK.a(MessageDigest.getInstance("SHA1").digest(((String) localObject1).getBytes()));
                    s = (String) localObject1;
                } catch (Exception localException) {
                    MMLog.a("NVASpeechKit", "Problem with nuanceid", localException);
                    localObject3 = null;
                }
                localObject2 =finally;
            }
            continue;
            label110:
            Object localObject3 = null;
            label112:
            if (localObject3 == null) {
                localObject3 = null;
            }
        }
    }

    public NVASpeechKit.Result[] getResults() {
        return this._results;
    }

    public NVASpeechKit.State getState() {
        try {
            NVASpeechKit.State localState = this.i;
            return localState;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean initialize(HandShake.NuanceCredentials paramNuanceCredentials, Context paramContext) {
        MMLog.b("NVASpeechKit", "initialize called.");
        if ((paramNuanceCredentials == null) || (paramContext == null)) {
            return false;
        }
        this.a = paramNuanceCredentials;
        if (this.d != null) {
        }
        try {
            this.d.connect();
            if (this.d == null) {
                byte[] arrayOfByte = c(paramNuanceCredentials.b);
                MMLog.b("NVASpeechKit", paramNuanceCredentials.toString());
                this.d = SpeechKit.initialize(paramContext, "1.0", paramNuanceCredentials.a, paramNuanceCredentials.c, paramNuanceCredentials.d, false, arrayOfByte, SpeechKit.CmdSetType.NVC);
                this.g = k();
                this.f = l();
                this.e = new Handler(Looper.getMainLooper());
                this.d.connect();
                a(NVASpeechKit.State.READY);
                return true;
            }
        } catch (IllegalStateException localIllegalStateException) {
            for (; ; ) {
                this.d = null;
            }
            MMLog.b("NVASpeechKit", "Already initialized. Skipping.");
        }
        return false;
    }

    public void logEvent() {
        if (this.d == null) {
            return;
        }
        PdxValue.Dictionary localDictionary = new PdxValue.Dictionary();
        localDictionary.put("nva_ad_network_id", "MillenialMedia");
        localDictionary.put("nva_device_id", g());
        localDictionary.put("nva_ad_publisher_id", this.t);
        String str2 = "";
        String str1 = str2;
        if (this.a != null) {
            str1 = str2;
            if (!TextUtils.isEmpty(this.a.e)) {
                str1 = this.a.e;
                localDictionary.put("nva_ad_session_id", this.a.e);
            }
        }
        str2 = j();
        if (!TextUtils.isEmpty(str2)) {
            localDictionary.put("nva_ad_id", str2);
        }
        if (this.m != null) {
            localDictionary.put("nva_nvc_session_id", this.m);
            String str3 = this.m;
            this.m = null;
        }
        for (; ; ) {
            MMLog.b("NVASpeechKit", "Sending log revision command to server. sessionId[" + this.d.getSessionId() + "] deviceId[" + g() + "] adId[" + str2 + "] mmSessionId[" + str1 + "]");
            this.d.createLogRevisionCmd("NVA_LOG_EVENT", localDictionary, this.d.getSessionId(), this.p, this.e).start();
            return;
            this.d.getSessionId();
        }
    }

    public void release() {
        MMLog.b("NVASpeechKit", "release called.");
        stopActions();
        n();
        if (this.d != null) {
            this.d.release();
            a(NVASpeechKit.State.READY);
            this.d = null;
        }
        this.k = null;
        i();
    }

    public void setSpeechKitListener(NVASpeechKit.Listener paramListener) {
        this.r = paramListener;
    }

    public boolean startRecording(String paramString) {
        MMLog.b("NVASpeechKit", "RECORDING INVOKED.");
        if ((this.i == NVASpeechKit.State.READY) && (this.d != null)) {
            this.m = null;
            this.h = this.d.createRecognizer("dictation", 1, paramString, this.f, this.e);
            MMLog.b("NVASpeechKit", "START RECORDING");
            this.h.start();
            return true;
        }
        return false;
    }

    public void startSampleRecording() {
        this.j.startTrackingAudioSample();
        startRecording("en_US");
    }

    public void stopActions() {
        if (this.d != null) {
        }
        try {
            this.d.cancelCurrent();
            return;
        } catch (Exception localException) {
            MMLog.a("NVASpeechKit", "No speech kit to disconnect.", localException);
        }
    }

    public boolean textToSpeech(String paramString1, String paramString2) {
        MMLog.b("NVASpeechKit", "TTS INVOKED.");
        if ((this.i == NVASpeechKit.State.READY) && (this.d != null)) {
            this.c = this.d.createVocalizerWithLanguage(paramString2, this.g, this.e);
            this.c.speakString(paramString1, this);
            return true;
        }
        return false;
    }

    public void updateCustomWords(NVASpeechKit.CustomWordsOp paramCustomWordsOp, String[] paramArrayOfString) {
        if (this.d == null) {
            return;
        }
        DataBlock localDataBlock = new DataBlock();
        Object localObject2 = new StringBuilder().append("Creating dataupload command and ");
        if (paramCustomWordsOp == NVASpeechKit.CustomWordsOp.Add) {
            localObject1 = "adding";
            MMLog.b("NVASpeechKit", (String) localObject1 + " words.");
            localObject2 = new Data("nva_custom_word_uploads", Data.DataType.CUSTOMWORDS);
            if (paramCustomWordsOp != NVASpeechKit.CustomWordsOp.Add) {
                break label174;
            }
        }
        label174:
        for (Object localObject1 = Action.ActionType.ADD; ; localObject1 = Action.ActionType.REMOVE) {
            localObject1 = new Action((Action.ActionType) localObject1);
            int i2 = paramArrayOfString.length;
            i1 = 0;
            while (i1 < i2) {
                String str = paramArrayOfString[i1];
                ((Action) localObject1).addWord(str);
                MMLog.b("NVASpeechKit", "\tword: '" + str + "'");
                i1 += 1;
            }
            localObject1 = "deleting";
            break;
        }
        ((Data) localObject2).addAction((Action) localObject1);
        localDataBlock.addData((Data) localObject2);
        int i1 = localDataBlock.getChecksum();
        this.l = paramCustomWordsOp;
        this.k = this.d.createDataUploadCmd(localDataBlock, i1, i1, this.q, this.e);
        this.k.start();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */