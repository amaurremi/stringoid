package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IFunnyFeed$1
        implements Parcelable.Creator<IFunnyFeed> {
    public IFunnyFeed createFromParcel(Parcel paramParcel) {
        return new IFunnyFeed(paramParcel);
    }

    public IFunnyFeed[] newArray(int paramInt) {
        return new IFunnyFeed[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunnyFeed$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */