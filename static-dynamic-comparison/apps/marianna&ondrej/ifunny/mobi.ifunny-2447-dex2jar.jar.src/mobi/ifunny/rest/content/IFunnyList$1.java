package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IFunnyList$1
        implements Parcelable.Creator<IFunnyList> {
    public IFunnyList createFromParcel(Parcel paramParcel) {
        return new IFunnyList(paramParcel);
    }

    public IFunnyList[] newArray(int paramInt) {
        return new IFunnyList[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunnyList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */