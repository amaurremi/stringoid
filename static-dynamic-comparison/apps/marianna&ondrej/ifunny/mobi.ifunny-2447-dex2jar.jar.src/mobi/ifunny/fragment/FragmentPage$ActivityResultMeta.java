package mobi.ifunny.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;

import java.util.LinkedList;

class FragmentPage$ActivityResultMeta
        implements Parcelable {
    public static final Parcelable.Creator<ActivityResultMeta> CREATOR = new c();
    private int a;
    private LinkedList<String> b;
    private int c;

    FragmentPage$ActivityResultMeta(int paramInt, Fragment paramFragment) {
        this.b = new LinkedList();
        this.a = paramInt;
        paramFragment = paramFragment.getTag();
        this.c = ((paramInt + paramFragment).hashCode() & 0xFFFF);
    }

    FragmentPage$ActivityResultMeta(Parcel paramParcel) {
        this.a = paramParcel.readInt();
        this.b = new LinkedList();
        paramParcel.readStringList(this.b);
        this.c = paramParcel.readInt();
    }

    private String a() {
        if (this.b.isEmpty()) {
            return null;
        }
        return (String) this.b.pop();
    }

    private void a(Fragment paramFragment) {
        this.b.push(paramFragment.getTag());
    }

    private boolean b() {
        return !this.b.isEmpty();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.a);
        paramParcel.writeStringList(this.b);
        paramParcel.writeInt(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/FragmentPage$ActivityResultMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */