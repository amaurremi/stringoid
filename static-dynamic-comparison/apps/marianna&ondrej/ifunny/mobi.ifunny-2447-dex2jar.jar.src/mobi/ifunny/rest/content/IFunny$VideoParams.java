package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IFunny$VideoParams
        implements Parcelable {
    public static final Parcelable.Creator<VideoParams> CREATOR = new IFunny.VideoParams
    .1();
    public int length;
    public String url;

    public IFunny$VideoParams() {
    }

    public IFunny$VideoParams(Parcel paramParcel) {
        this.url = paramParcel.readString();
        this.length = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.url);
        paramParcel.writeInt(this.length);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunny$VideoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */