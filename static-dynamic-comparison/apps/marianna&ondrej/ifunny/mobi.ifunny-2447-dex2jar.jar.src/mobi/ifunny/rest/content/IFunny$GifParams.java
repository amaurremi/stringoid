package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IFunny$GifParams
        implements Parcelable {
    public static final Parcelable.Creator<GifParams> CREATOR = new IFunny.GifParams
    .1();
    public int bytes;
    public String thumb_full_url;
    public int webm_bytes;
    public String webm_url;

    public IFunny$GifParams() {
    }

    public IFunny$GifParams(Parcel paramParcel) {
        this.thumb_full_url = paramParcel.readString();
        this.webm_url = paramParcel.readString();
        this.webm_bytes = paramParcel.readInt();
        this.bytes = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.thumb_full_url);
        paramParcel.writeString(this.webm_url);
        paramParcel.writeInt(this.webm_bytes);
        paramParcel.writeInt(this.bytes);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunny$GifParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */