package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
        implements SafeParcelable, Filter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new g();
    private List<Filter> GD;
    final Operator GG;
    final List<FilterHolder> GS;
    final int xH;

    LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList) {
        this.xH = paramInt;
        this.GG = paramOperator;
        this.GS = paramList;
    }

    public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs) {
        this.xH = 1;
        this.GG = paramOperator;
        this.GS = new ArrayList(paramVarArgs.length + 1);
        this.GS.add(new FilterHolder(paramFilter));
        this.GD = new ArrayList(paramVarArgs.length + 1);
        this.GD.add(paramFilter);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j) {
            paramOperator = paramVarArgs[i];
            this.GS.add(new FilterHolder(paramOperator));
            this.GD.add(paramOperator);
            i += 1;
        }
    }

    public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable) {
        this.xH = 1;
        this.GG = paramOperator;
        this.GD = new ArrayList();
        this.GS = new ArrayList();
        paramOperator = paramIterable.iterator();
        while (paramOperator.hasNext()) {
            paramIterable = (Filter) paramOperator.next();
            this.GD.add(paramIterable);
            this.GS.add(new FilterHolder(paramIterable));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */