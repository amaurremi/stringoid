package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.AbsListView;

public class ExtendableListView$ListSavedState
        extends ClassLoaderSavedState {
    public static final Parcelable.Creator<ListSavedState> CREATOR = new i();
    protected long b;
    protected long c;
    protected int d;
    protected int e;
    protected int f;

    public ExtendableListView$ListSavedState(Parcel paramParcel) {
        super(paramParcel);
        this.b = paramParcel.readLong();
        this.c = paramParcel.readLong();
        this.d = paramParcel.readInt();
        this.e = paramParcel.readInt();
        this.f = paramParcel.readInt();
    }

    public ExtendableListView$ListSavedState(Parcelable paramParcelable) {
        super(paramParcelable, AbsListView.class.getClassLoader());
    }

    public String toString() {
        return "ExtendableListView.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.b + " firstId=" + this.c + " viewTop=" + this.d + " position=" + this.e + " height=" + this.f + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeLong(this.b);
        paramParcel.writeLong(this.c);
        paramParcel.writeInt(this.d);
        paramParcel.writeInt(this.e);
        paramParcel.writeInt(this.f);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/ExtendableListView$ListSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */