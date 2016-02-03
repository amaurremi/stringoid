package mobi.ifunny.util.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.Paging;
import mobi.ifunny.util.d;

public class IFunnyCache$ListEntry
        implements Parcelable {
    public static final Parcelable.Creator<ListEntry> CREATOR = new p();
    public int a;
    private d<IFunnyList> b;
    private int c;

    public IFunnyCache$ListEntry() {
        this(-1);
    }

    public IFunnyCache$ListEntry(int paramInt) {
        this.b = new d(paramInt);
        a();
    }

    public IFunnyCache$ListEntry(Parcel paramParcel) {
        this.b = new d(paramParcel.readInt());
        int j = paramParcel.readInt();
        int i = 0;
        while (i < j) {
            IFunnyList localIFunnyList = (IFunnyList) paramParcel.readParcelable(IFunnyList.class.getClassLoader());
            this.b.offer(localIFunnyList);
            i += 1;
        }
        this.a = paramParcel.readInt();
        this.c = paramParcel.readInt();
    }

    private void g() {
        this.c = 0;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            IFunnyList localIFunnyList = (IFunnyList) localIterator.next();
            int i = this.c;
            this.c = (localIFunnyList.items.size() + i);
        }
    }

    public IFunny a(int paramInt) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            IFunnyList localIFunnyList = (IFunnyList) localIterator.next();
            int i = localIFunnyList.items.size();
            if (paramInt >= i) {
                paramInt -= i;
            } else {
                return (IFunny) localIFunnyList.items.get(paramInt);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public void a() {
        this.b.clear();
        this.c = 0;
        this.a = 0;
    }

    public boolean a(IFunny paramIFunny) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            IFunnyList localIFunnyList = (IFunnyList) localIterator.next();
            int i = localIFunnyList.items.indexOf(paramIFunny);
            if (i >= 0) {
                localIFunnyList.items.remove(i);
                this.c -= 1;
                return true;
            }
        }
        return false;
    }

    public boolean a(IFunnyList paramIFunnyList) {
        boolean bool = this.b.offer(paramIFunnyList);
        g();
        return bool;
    }

    public int b(IFunny paramIFunny) {
        Iterator localIterator = this.b.iterator();
        IFunnyList localIFunnyList;
        for (int i = 0; localIterator.hasNext(); i = localIFunnyList.items.size() + i) {
            localIFunnyList = (IFunnyList) localIterator.next();
            int j = localIFunnyList.items.indexOf(paramIFunny);
            if (j >= 0) {
                return j + i;
            }
        }
        return -1;
    }

    public IFunny b(int paramInt) {
        IFunny localIFunny;
        do {
            Iterator localIterator1 = this.b.iterator();
            Iterator localIterator2;
            while (!localIterator2.hasNext()) {
                if (!localIterator1.hasNext()) {
                    break;
                }
                localIterator2 = ((IFunnyList) localIterator1.next()).items.iterator();
            }
            localIFunny = (IFunny) localIterator2.next();
        } while (localIFunny.uniqueId != paramInt);
        return localIFunny;
        return null;
    }

    public Paging b() {
        if (this.b.size() == 0) {
            return null;
        }
        return ((IFunnyList) this.b.peek()).paging;
    }

    public Paging c() {
        if (this.b.size() == 0) {
            return null;
        }
        return ((IFunnyList) this.b.d()).paging;
    }

    public int d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<IFunny> e() {
        ArrayList localArrayList = new ArrayList(this.c);
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            localArrayList.addAll(((IFunnyList) localIterator.next()).items);
        }
        return localArrayList;
    }

    public ListEntry f() {
        ListEntry localListEntry = new ListEntry();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            localListEntry.a(new IFunnyList((IFunnyList) localIterator.next()));
        }
        localListEntry.a = this.a;
        return localListEntry;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.b.a());
        paramParcel.writeInt(this.b.size());
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            paramParcel.writeParcelable((IFunnyList) localIterator.next(), paramInt);
        }
        paramParcel.writeInt(this.a);
        paramParcel.writeInt(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/IFunnyCache$ListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */