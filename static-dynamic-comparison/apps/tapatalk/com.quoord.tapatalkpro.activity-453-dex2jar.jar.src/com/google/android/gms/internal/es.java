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

public class es
        extends em {
    private static final String NAMESPACE = eo.X("com.google.cast.media");
    private static final long zG = TimeUnit.HOURS.toMillis(24L);
    private static final long zH = TimeUnit.HOURS.toMillis(24L);
    private static final long zI = TimeUnit.HOURS.toMillis(24L);
    private static final long zJ = TimeUnit.SECONDS.toMillis(1L);
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private long zK;
    private MediaStatus zL;
    private final ev zM = new ev(zH);
    private final ev zN = new ev(zG);
    private final ev zO = new ev(zG);
    private final ev zP = new ev(zG);
    private final ev zQ = new ev(zI);
    private final ev zR = new ev(zG);
    private final ev zS = new ev(zG);
    private final ev zT = new ev(zG);
    private final Runnable zU = new a(null);
    private boolean zV;

    public es() {
        this(null);
    }

    public es(String paramString) {
        super(NAMESPACE, "MediaControlChannel", paramString);
        dS();
    }

    private void a(long paramLong, JSONObject paramJSONObject)
            throws JSONException {
        int k = 1;
        boolean bool = this.zM.n(paramLong);
        int j;
        if ((this.zQ.dU()) && (!this.zQ.n(paramLong))) {
            i = 1;
            if (this.zR.dU()) {
                j = k;
                if (!this.zR.n(paramLong)) {
                }
            } else {
                if ((!this.zS.dU()) || (this.zS.n(paramLong))) {
                    break label279;
                }
                j = k;
            }
            label87:
            if (i == 0) {
                break label300;
            }
        }
        label279:
        label300:
        for (int i = 2; ; i = 0) {
            k = i;
            if (j != 0) {
                k = i | 0x1;
            }
            if ((bool) || (this.zL == null)) {
                this.zL = new MediaStatus(paramJSONObject);
                this.zK = SystemClock.elapsedRealtime();
            }
            for (i = 7; ; i = this.zL.a(paramJSONObject, k)) {
                if ((i & 0x1) != 0) {
                    this.zK = SystemClock.elapsedRealtime();
                    onStatusUpdated();
                }
                if ((i & 0x2) != 0) {
                    this.zK = SystemClock.elapsedRealtime();
                    onStatusUpdated();
                }
                if ((i & 0x4) != 0) {
                    onMetadataUpdated();
                }
                this.zM.c(paramLong, 0);
                this.zN.c(paramLong, 0);
                this.zO.c(paramLong, 0);
                this.zP.c(paramLong, 0);
                this.zQ.c(paramLong, 0);
                this.zR.c(paramLong, 0);
                this.zS.c(paramLong, 0);
                this.zT.c(paramLong, 0);
                return;
                i = 0;
                break;
                j = 0;
                break label87;
            }
        }
    }

    private void dS() {
        w(false);
        this.zK = 0L;
        this.zL = null;
        this.zM.clear();
        this.zQ.clear();
        this.zR.clear();
    }

    private void w(boolean paramBoolean) {
        if (this.zV != paramBoolean) {
            this.zV = paramBoolean;
            if (paramBoolean) {
                this.mHandler.postDelayed(this.zU, zJ);
            }
        } else {
            return;
        }
        this.mHandler.removeCallbacks(this.zU);
    }

    public final void U(String paramString) {
        this.yY.b("message received: %s", new Object[]{paramString});
        String str;
        long l;
        try {
            Object localObject = new JSONObject(paramString);
            str = ((JSONObject) localObject).getString("type");
            l = ((JSONObject) localObject).optLong("requestId", -1L);
            if (str.equals("MEDIA_STATUS")) {
                localObject = ((JSONObject) localObject).getJSONArray("status");
                if (((JSONArray) localObject).length() > 0) {
                    a(l, ((JSONArray) localObject).getJSONObject(0));
                    return;
                }
                this.zL = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.zT.c(l, 0);
                return;
            }
        } catch (JSONException localJSONException) {
            this.yY.d("Message is malformed (%s); ignoring: %s", new Object[]{localJSONException.getMessage(), paramString});
            return;
        }
        JSONObject localJSONObject;
        if (str.equals("INVALID_PLAYER_STATE")) {
            this.yY.d("received unexpected error: Invalid Player State.", new Object[0]);
            localJSONObject = localJSONException.optJSONObject("customData");
            this.zM.b(l, 1, localJSONObject);
            this.zN.b(l, 1, localJSONObject);
            this.zO.b(l, 1, localJSONObject);
            this.zP.b(l, 1, localJSONObject);
            this.zQ.b(l, 1, localJSONObject);
            this.zR.b(l, 1, localJSONObject);
            this.zS.b(l, 1, localJSONObject);
            this.zT.b(l, 1, localJSONObject);
            return;
        }
        if (str.equals("LOAD_FAILED")) {
            localJSONObject = localJSONObject.optJSONObject("customData");
            this.zM.b(l, 1, localJSONObject);
            return;
        }
        if (str.equals("LOAD_CANCELLED")) {
            localJSONObject = localJSONObject.optJSONObject("customData");
            this.zM.b(l, 2, localJSONObject);
            return;
        }
        if (str.equals("INVALID_REQUEST")) {
            this.yY.d("received unexpected error: Invalid Request.", new Object[0]);
            localJSONObject = localJSONObject.optJSONObject("customData");
            this.zM.b(l, 1, localJSONObject);
            this.zN.b(l, 1, localJSONObject);
            this.zO.b(l, 1, localJSONObject);
            this.zP.b(l, 1, localJSONObject);
            this.zQ.b(l, 1, localJSONObject);
            this.zR.b(l, 1, localJSONObject);
            this.zS.b(l, 1, localJSONObject);
            this.zT.b(l, 1, localJSONObject);
        }
    }

    public long a(eu parameu)
            throws IOException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zT.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "GET_STATUS");
            if (this.zL != null) {
                localJSONObject.put("mediaSessionId", this.zL.dC());
            }
            a(localJSONObject.toString(), l, null);
            return l;
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
    }

    public long a(eu parameu, double paramDouble, JSONObject paramJSONObject)
            throws IOException, IllegalStateException, IllegalArgumentException {
        if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
            throw new IllegalArgumentException("Volume cannot be " + paramDouble);
        }
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zR.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "SET_VOLUME");
            localJSONObject.put("mediaSessionId", dC());
            parameu = new JSONObject();
            parameu.put("level", paramDouble);
            localJSONObject.put("volume", parameu);
            if (paramJSONObject != null) {
                localJSONObject.put("customData", paramJSONObject);
            }
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
        a(localJSONObject.toString(), l, null);
        return l;
    }

    public long a(eu parameu, long paramLong, int paramInt, JSONObject paramJSONObject)
            throws IOException, IllegalStateException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zQ.a(l, parameu);
        w(true);
        for (; ; ) {
            try {
                localJSONObject.put("requestId", l);
                localJSONObject.put("type", "SEEK");
                localJSONObject.put("mediaSessionId", dC());
                localJSONObject.put("currentTime", eo.m(paramLong));
                if (paramInt != 1) {
                    continue;
                }
                localJSONObject.put("resumeState", "PLAYBACK_START");
                if (paramJSONObject != null) {
                    localJSONObject.put("customData", paramJSONObject);
                }
            } catch (JSONException parameu) {
                continue;
            }
            a(localJSONObject.toString(), l, null);
            return l;
            if (paramInt == 2) {
                localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
            }
        }
    }

    public long a(eu parameu, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
            throws IOException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zM.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "LOAD");
            localJSONObject.put("media", paramMediaInfo.dB());
            localJSONObject.put("autoplay", paramBoolean);
            localJSONObject.put("currentTime", eo.m(paramLong));
            if (paramJSONObject != null) {
                localJSONObject.put("customData", paramJSONObject);
            }
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
        a(localJSONObject.toString(), l, null);
        return l;
    }

    public long a(eu parameu, JSONObject paramJSONObject)
            throws IOException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zN.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "PAUSE");
            localJSONObject.put("mediaSessionId", dC());
            if (paramJSONObject != null) {
                localJSONObject.put("customData", paramJSONObject);
            }
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
        a(localJSONObject.toString(), l, null);
        return l;
    }

    public long a(eu parameu, boolean paramBoolean, JSONObject paramJSONObject)
            throws IOException, IllegalStateException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zS.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "SET_VOLUME");
            localJSONObject.put("mediaSessionId", dC());
            parameu = new JSONObject();
            parameu.put("muted", paramBoolean);
            localJSONObject.put("volume", parameu);
            if (paramJSONObject != null) {
                localJSONObject.put("customData", paramJSONObject);
            }
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
        a(localJSONObject.toString(), l, null);
        return l;
    }

    public void a(long paramLong, int paramInt) {
        this.zM.c(paramLong, paramInt);
        this.zN.c(paramLong, paramInt);
        this.zO.c(paramLong, paramInt);
        this.zP.c(paramLong, paramInt);
        this.zQ.c(paramLong, paramInt);
        this.zR.c(paramLong, paramInt);
        this.zS.c(paramLong, paramInt);
        this.zT.c(paramLong, paramInt);
    }

    public long b(eu parameu, JSONObject paramJSONObject)
            throws IOException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zP.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "STOP");
            localJSONObject.put("mediaSessionId", dC());
            if (paramJSONObject != null) {
                localJSONObject.put("customData", paramJSONObject);
            }
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
        a(localJSONObject.toString(), l, null);
        return l;
    }

    public long c(eu parameu, JSONObject paramJSONObject)
            throws IOException, IllegalStateException {
        JSONObject localJSONObject = new JSONObject();
        long l = dE();
        this.zO.a(l, parameu);
        w(true);
        try {
            localJSONObject.put("requestId", l);
            localJSONObject.put("type", "PLAY");
            localJSONObject.put("mediaSessionId", dC());
            if (paramJSONObject != null) {
                localJSONObject.put("customData", paramJSONObject);
            }
        } catch (JSONException parameu) {
            for (; ; ) {
            }
        }
        a(localJSONObject.toString(), l, null);
        return l;
    }

    public long dC()
            throws IllegalStateException {
        if (this.zL == null) {
            throw new IllegalStateException("No current media session");
        }
        return this.zL.dC();
    }

    public void dF() {
        dS();
    }

    public long getApproximateStreamPosition() {
        MediaInfo localMediaInfo = getMediaInfo();
        if (localMediaInfo == null) {
        }
        while (this.zK == 0L) {
            return 0L;
        }
        double d = this.zL.getPlaybackRate();
        long l3 = this.zL.getStreamPosition();
        int i = this.zL.getPlayerState();
        if ((d == 0.0D) || (i != 2)) {
            return l3;
        }
        long l1 = SystemClock.elapsedRealtime() - this.zK;
        if (l1 < 0L) {
            l1 = 0L;
        }
        for (; ; ) {
            if (l1 == 0L) {
                return l3;
            }
            long l2 = localMediaInfo.getStreamDuration();
            l1 = l3 + (l1 * d);
            if (l1 > l2) {
                l1 = l2;
            }
            for (; ; ) {
                return l1;
                if (l1 < 0L) {
                    l1 = 0L;
                }
            }
        }
    }

    public MediaInfo getMediaInfo() {
        if (this.zL == null) {
            return null;
        }
        return this.zL.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zL;
    }

    public long getStreamDuration() {
        MediaInfo localMediaInfo = getMediaInfo();
        if (localMediaInfo != null) {
            return localMediaInfo.getStreamDuration();
        }
        return 0L;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }

    private class a
            implements Runnable {
        private a() {
        }

        public void run() {
            boolean bool = false;
            es.a(es.this, false);
            long l = SystemClock.elapsedRealtime();
            es.a(es.this).d(l, 3);
            es.b(es.this).d(l, 3);
            es.c(es.this).d(l, 3);
            es.d(es.this).d(l, 3);
            es.e(es.this).d(l, 3);
            es.f(es.this).d(l, 3);
            es.g(es.this).d(l, 3);
            es.h(es.this).d(l, 3);
            for (; ; ) {
                synchronized (ev.Ab) {
                    if ((!es.a(es.this).dU()) && (!es.e(es.this).dU()) && (!es.f(es.this).dU()) && (!es.g(es.this).dU()) && (!es.h(es.this).dU())) {
                        es.b(es.this, bool);
                        return;
                    }
                }
                bool = true;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */