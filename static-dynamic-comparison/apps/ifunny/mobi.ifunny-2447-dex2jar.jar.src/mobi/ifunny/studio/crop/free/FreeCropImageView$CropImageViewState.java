package mobi.ifunny.studio.crop.free;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class FreeCropImageView$CropImageViewState
        implements Parcelable {
    public static final Parcelable.Creator<CropImageViewState> CREATOR = new e();
    private Parcelable a;
    private Rect b;

    private FreeCropImageView$CropImageViewState(Parcel paramParcel) {
        a(paramParcel);
    }

    public FreeCropImageView$CropImageViewState(Parcelable paramParcelable, Rect paramRect) {
        this.b = paramRect;
        this.a = paramParcelable;
    }

    public void a(Parcel paramParcel) {
        this.a = paramParcel.readParcelable(Parcelable.class.getClassLoader());
        this.b = ((Rect) paramParcel.readParcelable(Rect.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.a, paramInt);
        paramParcel.writeParcelable(this.b, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/FreeCropImageView$CropImageViewState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */