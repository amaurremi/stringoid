package mobi.ifunny.rest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Features$RateTexts
        implements Parcelable {
    public static final Parcelable.Creator<RateTexts> CREATOR = new Features.RateTexts
    .1();
    public String later;
    public String message;
    public String never;
    public String ok;
    public String teaser;
    public String title;

    private Features$RateTexts(Parcel paramParcel) {
        this.teaser = paramParcel.readString();
        this.title = paramParcel.readString();
        this.message = paramParcel.readString();
        this.ok = paramParcel.readString();
        this.never = paramParcel.readString();
        this.later = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.teaser);
        paramParcel.writeString(this.title);
        paramParcel.writeString(this.message);
        paramParcel.writeString(this.ok);
        paramParcel.writeString(this.never);
        paramParcel.writeString(this.later);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/Features$RateTexts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */