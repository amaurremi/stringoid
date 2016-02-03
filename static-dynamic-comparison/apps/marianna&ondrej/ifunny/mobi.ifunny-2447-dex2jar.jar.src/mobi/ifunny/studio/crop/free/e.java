package mobi.ifunny.studio.crop.free;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
        implements Parcelable.Creator<FreeCropImageView.CropImageViewState> {
    public FreeCropImageView.CropImageViewState a(Parcel paramParcel) {
        return new FreeCropImageView.CropImageViewState(paramParcel, null);
    }

    public FreeCropImageView.CropImageViewState[] a(int paramInt) {
        return new FreeCropImageView.CropImageViewState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */