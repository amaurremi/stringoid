package mobi.ifunny.social.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
        implements Parcelable.Creator<SharingContent> {
    public SharingContent a(Parcel paramParcel) {
        return new SharingContent(paramParcel);
    }

    public SharingContent[] a(int paramInt) {
        return new SharingContent[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */