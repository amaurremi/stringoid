package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
        extends AbstractFilter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new i();
    final Operator a;
    final List<FilterHolder> b;
    final int c;

    LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList) {
        this.c = paramInt;
        this.a = paramOperator;
        this.b = paramList;
    }

    public <T> T a(f<T> paramf) {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            localArrayList.add(((FilterHolder) localIterator.next()).a().a(paramf));
        }
        return (T) paramf.b(this.a, localArrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */