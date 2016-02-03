package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
        implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
    String mName;
    private final int xH;
    String xI;
    List<WebImage> xJ;
    List<String> xK;
    String xL;
    Uri xM;

    private ApplicationMetadata() {
        this.xH = 1;
        this.xJ = new ArrayList();
        this.xK = new ArrayList();
    }

    ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri) {
        this.xH = paramInt;
        this.xI = paramString1;
        this.mName = paramString2;
        this.xJ = paramList;
        this.xK = paramList1;
        this.xL = paramString3;
        this.xM = paramUri;
    }

    public boolean areNamespacesSupported(List<String> paramList) {
        return (this.xK != null) && (this.xK.containsAll(paramList));
    }

    public int describeContents() {
        return 0;
    }

    public Uri dz() {
        return this.xM;
    }

    public String getApplicationId() {
        return this.xI;
    }

    public List<WebImage> getImages() {
        return this.xJ;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.xL;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean isNamespaceSupported(String paramString) {
        return (this.xK != null) && (this.xK.contains(paramString));
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */