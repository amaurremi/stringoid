package mobi.ifunny.view.drawable;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
        implements Parcelable.Creator<FadingCropDrawable.CropState> {
    public FadingCropDrawable.CropState a(Parcel paramParcel) {
        return new FadingCropDrawable.CropState(paramParcel, null);
    }

    public FadingCropDrawable.CropState[] a(int paramInt) {
        return new FadingCropDrawable.CropState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/drawable/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */