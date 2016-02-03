package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Cover
        implements Parcelable {
    public static final Parcelable.Creator<Cover> CREATOR = new Cover
    .1();
    public String thumb_url;
    public String url;

    public Cover() {
    }

    public Cover(Parcel paramParcel) {
        this.url = paramParcel.readString();
        this.thumb_url = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.url);
        paramParcel.writeString(this.thumb_url);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Cover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */