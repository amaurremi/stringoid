package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.io.Externalizable;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VideoAd
        extends CachedAd
        implements Parcelable, Externalizable {
    public static final Parcelable.Creator<VideoAd> CREATOR = new VideoAd
    .1();
    static final long serialVersionUID = 2679125946930815832L;
    boolean g;
    boolean h;
    String i;
    String j;
    String k;
    String l;
    boolean m;
    boolean n;
    String[] o;
    String[] p;
    long q;
    long r;
    long s;
    String[] t;
    String[] u;
    String[] v;
    boolean w;
    ArrayList<VideoImage> x = new ArrayList();
    ArrayList<VideoLogEvent> y = new ArrayList();
    private String z;

    public VideoAd() {
    }

    VideoAd(Parcel paramParcel) {
        super(paramParcel);
        try {
            this.o = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.o);
            this.p = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.p);
            boolean[] arrayOfBoolean = new boolean[5];
            paramParcel.readBooleanArray(arrayOfBoolean);
            this.g = arrayOfBoolean[0];
            this.m = arrayOfBoolean[1];
            this.n = arrayOfBoolean[2];
            this.w = arrayOfBoolean[3];
            this.h = arrayOfBoolean[4];
            this.i = paramParcel.readString();
            this.j = paramParcel.readString();
            this.k = paramParcel.readString();
            this.l = paramParcel.readString();
            this.z = paramParcel.readString();
            this.q = paramParcel.readLong();
            this.r = paramParcel.readLong();
            this.s = paramParcel.readLong();
            this.x = paramParcel.readArrayList(VideoImage.class.getClassLoader());
            this.y = paramParcel.readArrayList(VideoLogEvent.class.getClassLoader());
            this.t = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.t);
            this.u = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.u);
            this.v = new String[paramParcel.readInt()];
            paramParcel.readStringArray(this.v);
            return;
        } catch (Exception paramParcel) {
            MMLog.a("VideoAd", "Exception with videoad parcel creation: ", paramParcel);
        }
    }

    VideoAd(String paramString) {
        if (paramString != null) {
        }
        try {
            paramString = new JSONObject(paramString);
            if (paramString != null) {
                paramString = paramString.optJSONObject("video");
                if (paramString != null) {
                    a(paramString);
                }
            }
            return;
        } catch (JSONException paramString) {
            for (; ; ) {
                MMLog.a("VideoAd", "VideoAd json exception: ", paramString);
                paramString = null;
            }
        }
    }

    static void a(Context paramContext, String paramString, HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl) {
        if (paramString != null) {
            VideoAd localVideoAd = (VideoAd) AdCache.i(paramContext, paramString);
            if ((localVideoAd != null) && (localVideoAd.a(paramContext, null, false))) {
                paramRedirectionListenerImpl.updateLastVideoViewedTime();
                MMLog.a("VideoAd", String.format("mmvideo: attempting to play video %s", new Object[]{paramString}));
                localVideoAd.a(paramContext, paramRedirectionListenerImpl.e);
                paramRedirectionListenerImpl.startingVideo();
            }
        } else {
            return;
        }
        MMLog.d("VideoAd", String.format("mmvideo: Ad %s cannot be shown at this time.", new Object[]{paramString}));
    }

    static boolean a(Context paramContext, String paramString) {
        return AdCache.h(paramContext, paramString + "video.dat");
    }

    static boolean a(Context paramContext, String paramString1, String paramString2) {
        boolean bool = AdCache.b(paramString1, paramString2 + "video.dat", paramContext);
        MMLog.a("VideoAd", String.format("Caching completed successfully (" + paramString2 + "video.dat" + ")? %b", new Object[]{Boolean.valueOf(bool)}));
        return bool;
    }

    static Uri b(Context paramContext, String paramString) {
        return Uri.fromFile(AdCache.g(paramContext, paramString + "video.dat"));
    }

    private void e(Context paramContext) {
        AdCache.a(paramContext, 2, new VideoAd.VideoIterator(paramContext, this));
    }

    void a(Context paramContext, long paramLong) {
        Utils.IntentUtils.b(paramContext, b(paramContext, paramLong));
    }

    protected void a(JSONObject paramJSONObject) {
        int i2 = 0;
        super.a(paramJSONObject);
        Object localObject1 = paramJSONObject.optJSONArray("startActivity");
        this.j = paramJSONObject.optString("overlayURL", null);
        this.k = paramJSONObject.optString("endURL", null);
        this.l = paramJSONObject.optString("cacheMissURL", null);
        this.z = paramJSONObject.optString("videoFileId", null);
        int i1;
        if (localObject1 != null) {
            this.o = new String[((JSONArray) localObject1).length()];
            i1 = 0;
            while (i1 < ((JSONArray) localObject1).length()) {
                this.o[i1] = ((JSONArray) localObject1).optString(i1);
                i1 += 1;
            }
        }
        this.o = new String[0];
        localObject1 = paramJSONObject.optJSONArray("endActivity");
        if (localObject1 != null) {
            this.p = new String[((JSONArray) localObject1).length()];
            i1 = 0;
            while (i1 < ((JSONArray) localObject1).length()) {
                this.p[i1] = ((JSONArray) localObject1).optString(i1);
                i1 += 1;
            }
        }
        this.p = new String[0];
        localObject1 = paramJSONObject.optJSONArray("cacheComplete");
        if (localObject1 != null) {
            this.t = new String[((JSONArray) localObject1).length()];
            i1 = 0;
            while (i1 < ((JSONArray) localObject1).length()) {
                this.t[i1] = ((JSONArray) localObject1).optString(i1);
                i1 += 1;
            }
        }
        this.t = new String[0];
        localObject1 = paramJSONObject.optJSONArray("cacheFailed");
        if (localObject1 != null) {
            this.u = new String[((JSONArray) localObject1).length()];
            i1 = 0;
            while (i1 < ((JSONArray) localObject1).length()) {
                this.u[i1] = ((JSONArray) localObject1).optString(i1);
                i1 += 1;
            }
        }
        this.u = new String[0];
        localObject1 = paramJSONObject.optJSONArray("videoError");
        if (localObject1 != null) {
            this.v = new String[((JSONArray) localObject1).length()];
            i1 = 0;
            while (i1 < ((JSONArray) localObject1).length()) {
                this.v[i1] = ((JSONArray) localObject1).optString(i1);
                i1 += 1;
            }
        }
        this.v = new String[0];
        this.g = paramJSONObject.optBoolean("showVideoPlayerControls");
        this.n = paramJSONObject.optBoolean("showCountdownHUD");
        this.w = paramJSONObject.optBoolean("reloadOverlayOnRestart");
        localObject1 = paramJSONObject.optJSONObject("onCompletion");
        if (localObject1 != null) {
            this.i = ((JSONObject) localObject1).optString("url", null);
            this.m = ((JSONObject) localObject1).optBoolean("stayInPlayer");
        }
        this.q = ((paramJSONObject.optDouble("duration", 0.0D) * 1000.0D));
        this.r = paramJSONObject.optLong("contentLength");
        this.s = paramJSONObject.optLong("closeAfterDelay");
        localObject1 = paramJSONObject.optJSONArray("buttons");
        if (localObject1 != null) {
            i1 = 0;
            while (i1 < ((JSONArray) localObject1).length()) {
                Object localObject2 = ((JSONArray) localObject1).optJSONObject(i1);
                if (localObject2 != null) {
                    localObject2 = new VideoImage((JSONObject) localObject2);
                    this.x.add(localObject2);
                }
                i1 += 1;
            }
        }
        paramJSONObject = paramJSONObject.optJSONArray("log");
        if (paramJSONObject != null) {
            i1 = i2;
            while (i1 < paramJSONObject.length()) {
                localObject1 = paramJSONObject.optJSONObject(i1);
                if (localObject1 != null) {
                    localObject1 = new VideoLogEvent((JSONObject) localObject1);
                    this.y.add(localObject1);
                }
                i1 += 1;
            }
        }
    }

    boolean a(Context paramContext) {
        return true;
    }

    boolean a(Context paramContext, MMAdImpl paramMMAdImpl, boolean paramBoolean) {
        if (paramBoolean) {
            if ((a()) || (!d(paramContext)) || (!HandShake.a(paramContext).a(paramMMAdImpl.f, this.c))) {
            }
        }
        while ((!a()) && (d(paramContext))) {
            return true;
            return false;
        }
        return false;
    }

    Intent b(Context paramContext, long paramLong) {
        Intent localIntent = new Intent();
        localIntent.putExtra("videoId", e());
        if (paramLong != -4L) {
            localIntent.putExtra("internalId", paramLong);
        }
        localIntent.setData(Uri.parse(AdCache.g(paramContext).getAbsolutePath() + File.separator + this.z + "video.dat"));
        return localIntent;
    }

    boolean b(Context paramContext) {
        boolean bool2 = AdCache.b(this.d, this.z + "video.dat", paramContext);
        boolean bool1 = bool2;
        int i1;
        if (bool2) {
            i1 = 0;
            bool1 = bool2;
            if (i1 < this.x.size()) {
                VideoImage localVideoImage = (VideoImage) this.x.get(i1);
                bool1 = AdCache.a(localVideoImage.a, e() + localVideoImage.a(), paramContext);
                if (bool1) {
                    break label155;
                }
            }
        }
        if (!bool1) {
            if (this.f) {
                c(paramContext);
            }
            HttpGetRequest.a(this.u);
        }
        for (; ; ) {
            MMLog.a("VideoAd", String.format("Caching completed successfully? %b", new Object[]{Boolean.valueOf(bool1)}));
            return bool1;
            label155:
            i1 += 1;
            break;
            if (bool1) {
                if ((this.a != null) && (this.a.length() > 0)) {
                    AdCache.a(paramContext, this.a);
                }
                HttpGetRequest.a(this.t);
            }
        }
    }

    int c() {
        return 1;
    }

    void c(Context paramContext) {
        super.c(paramContext);
        e(paramContext);
        AdCache.b(paramContext, this.a);
        MMLog.a("VideoAd", String.format("Ad %s was deleted.", new Object[]{e()}));
    }

    String d() {
        return "Video";
    }

    boolean d(Context paramContext) {
        int i1 = this.x.size();
        File localFile = AdCache.h(paramContext);
        paramContext = AdCache.g(paramContext);
        if ((localFile != null) && (paramContext != null)) {
            Object localObject = localFile.list(new VideoAd.VideoFilenameFilter(this));
            if ((localObject != null) && (localObject.length >= i1 + 1)) {
            }
            for (boolean bool = true; ; bool = false) {
                if ((bool) && (paramContext != null)) {
                    if (!new File(paramContext, this.z + "video.dat").exists()) {
                        return false;
                    }
                    paramContext = this.x.iterator();
                    while (paramContext.hasNext()) {
                        localObject = (VideoImage) paramContext.next();
                        if (!new File(localFile, e() + ((VideoImage) localObject).a()).exists()) {
                            return false;
                        }
                    }
                }
                return bool;
            }
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    void f() {
        if (this.o != null) {
            MMLog.b("VideoAd", "Cached video begin event logged");
            int i1 = 0;
            while (i1 < this.o.length) {
                MMSDK.Event.a(this.o[i1]);
                i1 += 1;
            }
        }
    }

    void g() {
        if (this.p != null) {
            MMLog.b("VideoAd", "Cached video end event logged");
            int i1 = 0;
            while (i1 < this.p.length) {
                MMSDK.Event.a(this.p[i1]);
                i1 += 1;
            }
        }
    }

    boolean h() {
        Iterator localIterator = this.x.iterator();
        while (localIterator.hasNext()) {
            if (((VideoImage) localIterator.next()).s) {
                return true;
            }
        }
        return false;
    }

    public void readExternal(ObjectInput paramObjectInput) {
        int i2 = 0;
        super.readExternal(paramObjectInput);
        this.g = paramObjectInput.readBoolean();
        this.i = ((String) paramObjectInput.readObject());
        this.j = ((String) paramObjectInput.readObject());
        this.k = ((String) paramObjectInput.readObject());
        this.l = ((String) paramObjectInput.readObject());
        this.z = ((String) paramObjectInput.readObject());
        this.m = paramObjectInput.readBoolean();
        this.n = paramObjectInput.readBoolean();
        this.w = paramObjectInput.readBoolean();
        int i3 = paramObjectInput.readInt();
        this.o = new String[i3];
        int i1 = 0;
        while (i1 < i3) {
            this.o[i1] = ((String) paramObjectInput.readObject());
            i1 += 1;
        }
        i3 = paramObjectInput.readInt();
        this.p = new String[i3];
        i1 = 0;
        while (i1 < i3) {
            this.p[i1] = ((String) paramObjectInput.readObject());
            i1 += 1;
        }
        this.q = paramObjectInput.readLong();
        this.h = paramObjectInput.readBoolean();
        this.r = paramObjectInput.readLong();
        this.s = paramObjectInput.readLong();
        i3 = paramObjectInput.readInt();
        this.t = new String[i3];
        i1 = 0;
        while (i1 < i3) {
            this.t[i1] = ((String) paramObjectInput.readObject());
            i1 += 1;
        }
        i3 = paramObjectInput.readInt();
        this.u = new String[i3];
        i1 = 0;
        while (i1 < i3) {
            this.u[i1] = ((String) paramObjectInput.readObject());
            i1 += 1;
        }
        i3 = paramObjectInput.readInt();
        this.v = new String[i3];
        i1 = 0;
        while (i1 < i3) {
            this.v[i1] = ((String) paramObjectInput.readObject());
            i1 += 1;
        }
        this.x.clear();
        i3 = paramObjectInput.readInt();
        i1 = 0;
        Object localObject;
        while (i1 < i3) {
            localObject = (VideoImage) paramObjectInput.readObject();
            this.x.add(localObject);
            i1 += 1;
        }
        this.y.clear();
        i3 = paramObjectInput.readInt();
        i1 = i2;
        while (i1 < i3) {
            localObject = (VideoLogEvent) paramObjectInput.readObject();
            this.y.add(localObject);
            i1 += 1;
        }
    }

    public void writeExternal(ObjectOutput paramObjectOutput) {
        int i2 = 0;
        super.writeExternal(paramObjectOutput);
        paramObjectOutput.writeBoolean(this.g);
        paramObjectOutput.writeObject(this.i);
        paramObjectOutput.writeObject(this.j);
        paramObjectOutput.writeObject(this.k);
        paramObjectOutput.writeObject(this.l);
        paramObjectOutput.writeObject(this.z);
        paramObjectOutput.writeBoolean(this.m);
        paramObjectOutput.writeBoolean(this.n);
        paramObjectOutput.writeBoolean(this.w);
        paramObjectOutput.writeInt(this.o.length);
        Object localObject = this.o;
        int i3 = localObject.length;
        int i1 = 0;
        while (i1 < i3) {
            paramObjectOutput.writeObject(localObject[i1]);
            i1 += 1;
        }
        paramObjectOutput.writeInt(this.p.length);
        localObject = this.p;
        i3 = localObject.length;
        i1 = 0;
        while (i1 < i3) {
            paramObjectOutput.writeObject(localObject[i1]);
            i1 += 1;
        }
        paramObjectOutput.writeLong(this.q);
        paramObjectOutput.writeBoolean(this.h);
        paramObjectOutput.writeLong(this.r);
        paramObjectOutput.writeLong(this.s);
        paramObjectOutput.writeInt(this.t.length);
        localObject = this.t;
        i3 = localObject.length;
        i1 = 0;
        while (i1 < i3) {
            paramObjectOutput.writeObject(localObject[i1]);
            i1 += 1;
        }
        paramObjectOutput.writeInt(this.u.length);
        localObject = this.u;
        i3 = localObject.length;
        i1 = 0;
        while (i1 < i3) {
            paramObjectOutput.writeObject(localObject[i1]);
            i1 += 1;
        }
        paramObjectOutput.writeInt(this.v.length);
        localObject = this.v;
        i3 = localObject.length;
        i1 = i2;
        while (i1 < i3) {
            paramObjectOutput.writeObject(localObject[i1]);
            i1 += 1;
        }
        paramObjectOutput.writeInt(this.x.size());
        localObject = this.x.iterator();
        while (((Iterator) localObject).hasNext()) {
            paramObjectOutput.writeObject((VideoImage) ((Iterator) localObject).next());
        }
        paramObjectOutput.writeInt(this.y.size());
        localObject = this.y.iterator();
        while (((Iterator) localObject).hasNext()) {
            paramObjectOutput.writeObject((VideoLogEvent) ((Iterator) localObject).next());
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.o.length);
        paramParcel.writeStringArray(this.o);
        paramParcel.writeInt(this.p.length);
        paramParcel.writeStringArray(this.p);
        paramParcel.writeBooleanArray(new boolean[]{this.g, this.m, this.n, this.w, this.h});
        paramParcel.writeString(this.i);
        paramParcel.writeString(this.k);
        paramParcel.writeString(this.j);
        paramParcel.writeString(this.l);
        paramParcel.writeString(this.z);
        paramParcel.writeLong(this.q);
        paramParcel.writeLong(this.r);
        paramParcel.writeLong(this.s);
        paramParcel.writeList(this.x);
        paramParcel.writeList(this.y);
        paramParcel.writeInt(this.t.length);
        paramParcel.writeStringArray(this.t);
        paramParcel.writeInt(this.u.length);
        paramParcel.writeStringArray(this.u);
        paramParcel.writeInt(this.v.length);
        paramParcel.writeStringArray(this.v);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */