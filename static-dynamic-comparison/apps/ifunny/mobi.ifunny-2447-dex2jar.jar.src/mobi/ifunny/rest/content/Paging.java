package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Paging
        implements Parcelable {
    public static final Parcelable.Creator<Paging> CREATOR = new Paging
    .1();
    public Paging.Cursors cursors;
    public boolean hasNext;
    public boolean hasPrev;

    public Paging() {
        this.cursors = new Paging.Cursors();
    }

    public Paging(Parcel paramParcel) {
        this.cursors = ((Paging.Cursors) paramParcel.readParcelable(Paging.Cursors.class.getClassLoader()));
        if (paramParcel.readInt() == 1) {
            bool1 = true;
            this.hasPrev = bool1;
            if (paramParcel.readInt() != 1) {
                break label58;
            }
        }
        label58:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.hasNext = bool1;
            return;
            bool1 = false;
            break;
        }
    }

    public Paging(Paging paramPaging) {
        this();
        update(paramPaging);
    }

    public void clear() {
        this.hasNext = false;
        this.hasPrev = false;
        this.cursors = new Paging.Cursors();
    }

    public int describeContents() {
        return 0;
    }

    public void update(Paging paramPaging) {
        updateNext(paramPaging);
        updatePrev(paramPaging);
    }

    public void updateNext(Paging paramPaging) {
        this.cursors.next = paramPaging.cursors.next;
        this.hasNext = paramPaging.hasNext;
    }

    public void updatePrev(Paging paramPaging) {
        this.cursors.prev = paramPaging.cursors.prev;
        this.hasPrev = paramPaging.hasPrev;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int i = 1;
        paramParcel.writeParcelable(this.cursors, paramInt);
        if (this.hasPrev) {
            paramInt = 1;
            paramParcel.writeInt(paramInt);
            if (!this.hasNext) {
                break label45;
            }
        }
        label45:
        for (paramInt = i; ; paramInt = 0) {
            paramParcel.writeInt(paramInt);
            return;
            paramInt = 0;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Paging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */