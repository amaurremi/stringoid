package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class ce
        extends aj {
    private static final String ID = a.O.toString();
    private static final String YX = b.da.toString();
    private static final String YY = b.cZ.toString();

    public ce() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return false;
    }

    public d.a x(Map<String, d.a> paramMap) {
        Object localObject = (d.a) paramMap.get(YX);
        paramMap = (d.a) paramMap.get(YY);
        double d2;
        double d1;
        if ((localObject != null) && (localObject != dh.lT()) && (paramMap != null) && (paramMap != dh.lT())) {
            localObject = dh.k((d.a) localObject);
            paramMap = dh.k(paramMap);
            if ((localObject != dh.lR()) && (paramMap != dh.lR())) {
                d2 = ((dg) localObject).doubleValue();
                d1 = paramMap.doubleValue();
                if (d2 > d1) {
                }
            }
        }
        for (; ; ) {
            return dh.r(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
            d1 = 2.147483647E9D;
            d2 = 0.0D;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */