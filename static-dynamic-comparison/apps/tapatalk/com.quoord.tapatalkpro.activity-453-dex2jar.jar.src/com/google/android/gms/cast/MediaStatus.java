package com.google.android.gms.cast;

import com.google.android.gms.internal.eo;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1L;
    public static final long COMMAND_SEEK = 2L;
    public static final long COMMAND_SET_VOLUME = 4L;
    public static final long COMMAND_SKIP_BACKWARD = 32L;
    public static final long COMMAND_SKIP_FORWARD = 16L;
    public static final long COMMAND_TOGGLE_MUTE = 8L;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    private long yA;
    private long yB;
    private double yC;
    private boolean yD;
    private JSONObject yn;
    private MediaInfo yo;
    private long yw;
    private double yx;
    private int yy;
    private int yz;

    public MediaStatus(JSONObject paramJSONObject)
            throws JSONException {
        a(paramJSONObject, 0);
    }

    public int a(JSONObject paramJSONObject, int paramInt)
            throws JSONException {
        int n = 2;
        long l = paramJSONObject.getLong("mediaSessionId");
        if (l != this.yw) {
            this.yw = l;
        }
        for (int j = 1; ; j = 0) {
            int k = j;
            Object localObject;
            int i;
            if (paramJSONObject.has("playerState")) {
                localObject = paramJSONObject.getString("playerState");
                if (!((String) localObject).equals("IDLE")) {
                    break label485;
                }
                i = 1;
            }
            for (; ; ) {
                int m = j;
                if (i != this.yy) {
                    this.yy = i;
                    m = j | 0x2;
                }
                k = m;
                if (i == 1) {
                    k = m;
                    if (paramJSONObject.has("idleReason")) {
                        localObject = paramJSONObject.getString("idleReason");
                        if (!((String) localObject).equals("CANCELLED")) {
                            break label533;
                        }
                        i = n;
                    }
                }
                for (; ; ) {
                    k = m;
                    if (i != this.yz) {
                        this.yz = i;
                        k = m | 0x2;
                    }
                    i = k;
                    double d;
                    if (paramJSONObject.has("playbackRate")) {
                        d = paramJSONObject.getDouble("playbackRate");
                        i = k;
                        if (this.yx != d) {
                            this.yx = d;
                            i = k | 0x2;
                        }
                    }
                    j = i;
                    if (paramJSONObject.has("currentTime")) {
                        j = i;
                        if ((paramInt & 0x2) == 0) {
                            l = eo.b(paramJSONObject.getDouble("currentTime"));
                            j = i;
                            if (l != this.yA) {
                                this.yA = l;
                                j = i | 0x2;
                            }
                        }
                    }
                    i = j;
                    if (paramJSONObject.has("supportedMediaCommands")) {
                        l = paramJSONObject.getLong("supportedMediaCommands");
                        i = j;
                        if (l != this.yB) {
                            this.yB = l;
                            i = j | 0x2;
                        }
                    }
                    j = i;
                    if (paramJSONObject.has("volume")) {
                        j = i;
                        if ((paramInt & 0x1) == 0) {
                            localObject = paramJSONObject.getJSONObject("volume");
                            d = ((JSONObject) localObject).getDouble("level");
                            paramInt = i;
                            if (d != this.yC) {
                                this.yC = d;
                                paramInt = i | 0x2;
                            }
                            boolean bool = ((JSONObject) localObject).getBoolean("muted");
                            j = paramInt;
                            if (bool != this.yD) {
                                this.yD = bool;
                                j = paramInt | 0x2;
                            }
                        }
                    }
                    paramInt = j;
                    if (paramJSONObject.has("customData")) {
                        this.yn = paramJSONObject.getJSONObject("customData");
                        paramInt = j | 0x2;
                    }
                    i = paramInt;
                    if (paramJSONObject.has("media")) {
                        paramJSONObject = paramJSONObject.getJSONObject("media");
                        this.yo = new MediaInfo(paramJSONObject);
                        paramInt |= 0x2;
                        i = paramInt;
                        if (paramJSONObject.has("metadata")) {
                            i = paramInt | 0x4;
                        }
                    }
                    return i;
                    label485:
                    if (((String) localObject).equals("PLAYING")) {
                        i = 2;
                        break;
                    }
                    if (((String) localObject).equals("PAUSED")) {
                        i = 3;
                        break;
                    }
                    if (!((String) localObject).equals("BUFFERING")) {
                        break label587;
                    }
                    i = 4;
                    break;
                    label533:
                    if (((String) localObject).equals("INTERRUPTED")) {
                        i = 3;
                    } else if (((String) localObject).equals("FINISHED")) {
                        i = 1;
                    } else if (((String) localObject).equals("ERROR")) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                }
                label587:
                i = 0;
            }
        }
    }

    public long dC() {
        return this.yw;
    }

    public JSONObject getCustomData() {
        return this.yn;
    }

    public int getIdleReason() {
        return this.yz;
    }

    public MediaInfo getMediaInfo() {
        return this.yo;
    }

    public double getPlaybackRate() {
        return this.yx;
    }

    public int getPlayerState() {
        return this.yy;
    }

    public long getStreamPosition() {
        return this.yA;
    }

    public double getStreamVolume() {
        return this.yC;
    }

    public boolean isMediaCommandSupported(long paramLong) {
        return (this.yB & paramLong) != 0L;
    }

    public boolean isMute() {
        return this.yD;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/cast/MediaStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */