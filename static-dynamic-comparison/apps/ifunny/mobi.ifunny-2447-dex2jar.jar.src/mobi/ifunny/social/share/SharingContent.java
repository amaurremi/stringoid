package mobi.ifunny.social.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SharingContent
        implements Parcelable {
    public static final Parcelable.Creator<SharingContent> CREATOR = new c();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public SharingContent(Parcel paramParcel) {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readString();
        this.d = paramParcel.readString();
        this.e = paramParcel.readString();
        this.f = paramParcel.readString();
        this.g = paramParcel.readString();
    }

    public SharingContent(String paramString1, String paramString2, String paramString3, String paramString4) {
        this(paramString1, paramString2, null, paramString3, null, null, paramString4);
    }

    public SharingContent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.d = paramString4;
        this.e = paramString5;
        this.f = paramString6;
        this.g = paramString7;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        paramParcel.writeString(this.f);
        paramParcel.writeString(this.g);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/SharingContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */