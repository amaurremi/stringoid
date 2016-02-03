package com.everimaging.fotorsdk.store.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.everimaging.fotorsdk.store.StatusAssistant.StatusInfo;

public class DetailPageInfo
        extends FotorStoreJsonObjects.DetailsBaseJsonObject
        implements Parcelable {
    public static final Parcelable.Creator<DetailPageInfo> CREATOR = new Parcelable.Creator() {
        public DetailPageInfo createFromParcel(Parcel paramAnonymousParcel) {
            return new DetailPageInfo(paramAnonymousParcel);
        }

        public DetailPageInfo[] newArray(int paramAnonymousInt) {
            return new DetailPageInfo[paramAnonymousInt];
        }
    };
    public String pkgName;
    public StatusAssistant.StatusInfo statusInfo;

    public DetailPageInfo() {
        this.price = -2.0F;
    }

    public DetailPageInfo(Parcel paramParcel) {
        this.type = paramParcel.readString();
        this.id = paramParcel.readInt();
        this.name = paramParcel.readString();
        this.description = paramParcel.readString();
        this.count = paramParcel.readInt();
        this.detailThumb = paramParcel.readString();
        this.price = paramParcel.readFloat();
        this.pkgName = paramParcel.readString();
        this.statusInfo = ((StatusAssistant.StatusInfo) paramParcel.readParcelable(getClass().getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void parseFromJsonStr(String paramString) {
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.type);
        paramParcel.writeInt(this.id);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.description);
        paramParcel.writeInt(this.count);
        paramParcel.writeString(this.detailThumb);
        paramParcel.writeFloat(this.price);
        paramParcel.writeString(this.pkgName);
        paramParcel.writeParcelable(this.statusInfo, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/entity/DetailPageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */