package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IFunny$ContentSize
        implements Parcelable {
    public static final Parcelable.Creator<ContentSize> CREATOR = new IFunny.ContentSize
    .1();
    public int h;
    public int w;

    public IFunny$ContentSize() {
    }

    public IFunny$ContentSize(Parcel paramParcel) {
        this.w = paramParcel.readInt();
        this.h = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.w);
        paramParcel.writeInt(this.h);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunny$ContentSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */