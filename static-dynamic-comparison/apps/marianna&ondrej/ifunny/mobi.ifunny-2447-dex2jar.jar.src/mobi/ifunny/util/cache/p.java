package mobi.ifunny.util.cache;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class p
        implements Parcelable.Creator<IFunnyCache.ListEntry> {
    public IFunnyCache.ListEntry a(Parcel paramParcel) {
        return new IFunnyCache.ListEntry(paramParcel);
    }

    public IFunnyCache.ListEntry[] a(int paramInt) {
        return new IFunnyCache.ListEntry[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */