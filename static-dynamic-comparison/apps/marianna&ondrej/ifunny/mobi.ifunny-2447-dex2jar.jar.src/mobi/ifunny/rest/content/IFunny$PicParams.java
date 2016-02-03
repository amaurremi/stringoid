package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IFunny$PicParams
        implements Parcelable {
    public static final Parcelable.Creator<PicParams> CREATOR = new IFunny.PicParams
    .1();
    public String webp_url;

    public IFunny$PicParams() {
    }

    public IFunny$PicParams(Parcel paramParcel) {
        this.webp_url = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.webp_url);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunny$PicParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */