package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c<T extends SafeParcelable>
        extends DataBuffer<T> {
    private static final String[] BF = {"data"};
    private final Parcelable.Creator<T> BG;

    public c(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator) {
        super(paramDataHolder);
        this.BG = paramCreator;
    }

    public T F(int paramInt) {
        Object localObject = this.BB.getByteArray("data", paramInt, 0);
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall((byte[]) localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        localObject = (SafeParcelable) this.BG.createFromParcel(localParcel);
        localParcel.recycle();
        return (T) localObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */