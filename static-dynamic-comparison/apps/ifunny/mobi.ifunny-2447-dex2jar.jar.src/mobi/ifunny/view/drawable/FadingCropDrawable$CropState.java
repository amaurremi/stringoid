package mobi.ifunny.view.drawable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FadingCropDrawable$CropState
        implements Parcelable, Cloneable {
    public static final Parcelable.Creator<CropState> CREATOR = new d();
    private final float[] a = new float[4];
    private int b;
    private int c;
    private float d;
    private float e;

    public FadingCropDrawable$CropState() {
    }

    private FadingCropDrawable$CropState(Parcel paramParcel) {
        this();
        a(paramParcel);
    }

    private void a(Parcel paramParcel) {
        int i = 0;
        while (i < 4) {
            this.a[i] = paramParcel.readFloat();
            i += 1;
        }
        this.b = paramParcel.readInt();
        this.c = paramParcel.readInt();
    }

    public final int a() {
        return this.b;
    }

    public final void a(float paramFloat) {
        this.d = paramFloat;
    }

    public final void a(int paramInt) {
        this.b = paramInt;
    }

    public void a(int paramInt, float paramFloat) {
        this.a[paramInt] = paramFloat;
    }

    public final int b() {
        return this.c;
    }

    public final void b(float paramFloat) {
        this.e = paramFloat;
    }

    public final void b(int paramInt) {
        this.c = paramInt;
    }

    public final float c() {
        return this.d;
    }

    public float c(int paramInt) {
        return this.a[paramInt];
    }

    protected Object clone() {
        CropState localCropState = new CropState();
        localCropState.a(a());
        localCropState.a(c());
        localCropState.b(b());
        localCropState.b(d());
        System.arraycopy(this.a, 0, localCropState.a, 0, 4);
        return localCropState;
    }

    public final float d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramInt = 0;
        while (paramInt < 4) {
            paramParcel.writeFloat(this.a[paramInt]);
            paramInt += 1;
        }
        paramParcel.writeInt(this.b);
        paramParcel.writeInt(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/drawable/FadingCropDrawable$CropState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */