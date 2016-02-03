package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.eo;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice
        implements SafeParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new b();
    private final int xH;
    private String ya;
    String yb;
    private Inet4Address yc;
    private String yd;
    private String ye;
    private String yf;
    private int yg;
    private List<WebImage> yh;

    private CastDevice() {
        this(1, null, null, null, null, null, -1, new ArrayList());
    }

    CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList) {
        this.xH = paramInt1;
        this.ya = paramString1;
        this.yb = paramString2;
        if (this.yb != null) {
        }
        try {
            paramString1 = InetAddress.getByName(this.yb);
            if ((paramString1 instanceof Inet4Address)) {
                this.yc = ((Inet4Address) paramString1);
            }
            this.yd = paramString3;
            this.ye = paramString4;
            this.yf = paramString5;
            this.yg = paramInt2;
            this.yh = paramList;
            return;
        } catch (UnknownHostException paramString1) {
            for (; ; ) {
                this.yc = null;
            }
        }
    }

    public static CastDevice getFromBundle(Bundle paramBundle) {
        if (paramBundle == null) {
            return null;
        }
        paramBundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) paramBundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            do {
                return true;
                if (!(paramObject instanceof CastDevice)) {
                    return false;
                }
                paramObject = (CastDevice) paramObject;
                if (getDeviceId() != null) {
                    break;
                }
            } while (((CastDevice) paramObject).getDeviceId() == null);
            return false;
        }
        while ((eo.a(this.ya, ((CastDevice) paramObject).ya)) && (eo.a(this.yc, ((CastDevice) paramObject).yc)) && (eo.a(this.ye, ((CastDevice) paramObject).ye)) && (eo.a(this.yd, ((CastDevice) paramObject).yd)) && (eo.a(this.yf, ((CastDevice) paramObject).yf)) && (this.yg == ((CastDevice) paramObject).yg) && (eo.a(this.yh, ((CastDevice) paramObject).yh)));
        return false;
    }

    public String getDeviceId() {
        return this.ya;
    }

    public String getDeviceVersion() {
        return this.yf;
    }

    public String getFriendlyName() {
        return this.yd;
    }

    public WebImage getIcon(int paramInt1, int paramInt2) {
        Object localObject1 = null;
        if (this.yh.isEmpty()) {
            return null;
        }
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
            return (WebImage) this.yh.get(0);
        }
        Iterator localIterator = this.yh.iterator();
        Object localObject2 = null;
        WebImage localWebImage;
        int i;
        int j;
        if (localIterator.hasNext()) {
            localWebImage = (WebImage) localIterator.next();
            i = localWebImage.getWidth();
            j = localWebImage.getHeight();
            if ((i >= paramInt1) && (j >= paramInt2)) {
                if ((localObject2 != null) && ((((WebImage) localObject2).getWidth() <= i) || (((WebImage) localObject2).getHeight() <= j))) {
                    break label210;
                }
                localObject2 = localWebImage;
            }
        }
        label210:
        for (; ; ) {
            break;
            if ((i < paramInt1) && (j < paramInt2) && ((localObject1 == null) || ((((WebImage) localObject1).getWidth() < i) && (((WebImage) localObject1).getHeight() < j)))) {
                localObject1 = localWebImage;
                continue;
                if (localObject2 != null) {
                }
                for (; ; ) {
                    return (WebImage) localObject2;
                    if (localObject1 != null) {
                        localObject2 = localObject1;
                    } else {
                        localObject2 = (WebImage) this.yh.get(0);
                    }
                }
            }
        }
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.yh);
    }

    public Inet4Address getIpAddress() {
        return this.yc;
    }

    public String getModelName() {
        return this.ye;
    }

    public int getServicePort() {
        return this.yg;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasIcons() {
        return !this.yh.isEmpty();
    }

    public int hashCode() {
        if (this.ya == null) {
            return 0;
        }
        return this.ya.hashCode();
    }

    public boolean isSameDevice(CastDevice paramCastDevice) {
        if (paramCastDevice == null) {
        }
        do {
            return false;
            if (getDeviceId() != null) {
                break;
            }
        } while (paramCastDevice.getDeviceId() != null);
        return true;
        return eo.a(getDeviceId(), paramCastDevice.getDeviceId());
    }

    public void putInBundle(Bundle paramBundle) {
        if (paramBundle == null) {
            return;
        }
        paramBundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.yd, this.ya});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/cast/CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */