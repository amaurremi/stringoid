package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class gg
        extends ga
        implements SafeParcelable {
    public static final gh CREATOR = new gh();
    private final gd Eg;
    private final Parcel En;
    private final int Eo;
    private int Ep;
    private int Eq;
    private final String mClassName;
    private final int xH;

    gg(int paramInt, Parcel paramParcel, gd paramgd) {
        this.xH = paramInt;
        this.En = ((Parcel) fq.f(paramParcel));
        this.Eo = 2;
        this.Eg = paramgd;
        if (this.Eg == null) {
        }
        for (this.mClassName = null; ; this.mClassName = this.Eg.fo()) {
            this.Ep = 2;
            return;
        }
    }

    private gg(SafeParcelable paramSafeParcelable, gd paramgd, String paramString) {
        this.xH = 1;
        this.En = Parcel.obtain();
        paramSafeParcelable.writeToParcel(this.En, 0);
        this.Eo = 1;
        this.Eg = ((gd) fq.f(paramgd));
        this.mClassName = ((String) fq.f(paramString));
        this.Ep = 2;
    }

    public static <T extends ga,extends SafeParcelable>

    gg a(T paramT) {
        String str = paramT.getClass().getCanonicalName();
        gd localgd = b(paramT);
        return new gg((SafeParcelable) paramT, localgd, str);
    }

    private static void a(gd paramgd, ga paramga) {
        Object localObject = paramga.getClass();
        if (!paramgd.b((Class) localObject)) {
            HashMap localHashMap = paramga.eY();
            paramgd.a((Class) localObject, paramga.eY());
            localObject = localHashMap.keySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                paramga = (ga.a) localHashMap.get((String) ((Iterator) localObject).next());
                Class localClass = paramga.fg();
                if (localClass != null) {
                    try {
                        a(paramgd, (ga) localClass.newInstance());
                    } catch (InstantiationException paramgd) {
                        throw new IllegalStateException("Could not instantiate an object of type " + paramga.fg().getCanonicalName(), paramgd);
                    } catch (IllegalAccessException paramgd) {
                        throw new IllegalStateException("Could not access object of type " + paramga.fg().getCanonicalName(), paramgd);
                    }
                }
            }
        }
    }

    private void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                throw new IllegalArgumentException("Unknown type = " + paramInt);
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                paramStringBuilder.append(paramObject);
                return;
            case 7:
                paramStringBuilder.append("\"").append(gp.av(paramObject.toString())).append("\"");
                return;
            case 8:
                paramStringBuilder.append("\"").append(gj.d((byte[]) paramObject)).append("\"");
                return;
            case 9:
                paramStringBuilder.append("\"").append(gj.e((byte[]) paramObject));
                paramStringBuilder.append("\"");
                return;
            case 10:
                gq.a(paramStringBuilder, (HashMap) paramObject);
                return;
        }
        throw new IllegalArgumentException("Method does not accept concrete type.");
    }

    private void a(StringBuilder paramStringBuilder, ga.a<?, ?> parama, Parcel paramParcel, int paramInt) {
        switch (parama.eX()) {
            default:
                throw new IllegalArgumentException("Unknown field out type = " + parama.eX());
            case 0:
                b(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
                return;
            case 1:
                b(paramStringBuilder, parama, a(parama, a.j(paramParcel, paramInt)));
                return;
            case 2:
                b(paramStringBuilder, parama, a(parama, Long.valueOf(a.i(paramParcel, paramInt))));
                return;
            case 3:
                b(paramStringBuilder, parama, a(parama, Float.valueOf(a.k(paramParcel, paramInt))));
                return;
            case 4:
                b(paramStringBuilder, parama, a(parama, Double.valueOf(a.l(paramParcel, paramInt))));
                return;
            case 5:
                b(paramStringBuilder, parama, a(parama, a.m(paramParcel, paramInt)));
                return;
            case 6:
                b(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
                return;
            case 7:
                b(paramStringBuilder, parama, a(parama, a.n(paramParcel, paramInt)));
                return;
            case 8:
            case 9:
                b(paramStringBuilder, parama, a(parama, a.q(paramParcel, paramInt)));
                return;
            case 10:
                b(paramStringBuilder, parama, a(parama, c(a.p(paramParcel, paramInt))));
                return;
        }
        throw new IllegalArgumentException("Method does not accept concrete type.");
    }

    private void a(StringBuilder paramStringBuilder, String paramString, ga.a<?, ?> parama, Parcel paramParcel, int paramInt) {
        paramStringBuilder.append("\"").append(paramString).append("\":");
        if (parama.fi()) {
            a(paramStringBuilder, parama, paramParcel, paramInt);
            return;
        }
        b(paramStringBuilder, parama, paramParcel, paramInt);
    }

    private void a(StringBuilder paramStringBuilder, HashMap<String, ga.a<?, ?>> paramHashMap, Parcel paramParcel) {
        paramHashMap = c(paramHashMap);
        paramStringBuilder.append('{');
        int j = a.o(paramParcel);
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            Map.Entry localEntry = (Map.Entry) paramHashMap.get(Integer.valueOf(a.R(k)));
            if (localEntry != null) {
                if (i != 0) {
                    paramStringBuilder.append(",");
                }
                a(paramStringBuilder, (String) localEntry.getKey(), (ga.a) localEntry.getValue(), paramParcel, k);
                i = 1;
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        paramStringBuilder.append('}');
    }

    private static gd b(ga paramga) {
        gd localgd = new gd(paramga.getClass());
        a(localgd, paramga);
        localgd.fm();
        localgd.fl();
        return localgd;
    }

    private void b(StringBuilder paramStringBuilder, ga.a<?, ?> parama, Parcel paramParcel, int paramInt) {
        if (parama.fd()) {
            paramStringBuilder.append("[");
            switch (parama.eX()) {
                default:
                    throw new IllegalStateException("Unknown field type out.");
                case 0:
                    gi.a(paramStringBuilder, a.t(paramParcel, paramInt));
            }
            for (; ; ) {
                paramStringBuilder.append("]");
                return;
                gi.a(paramStringBuilder, a.v(paramParcel, paramInt));
                continue;
                gi.a(paramStringBuilder, a.u(paramParcel, paramInt));
                continue;
                gi.a(paramStringBuilder, a.w(paramParcel, paramInt));
                continue;
                gi.a(paramStringBuilder, a.x(paramParcel, paramInt));
                continue;
                gi.a(paramStringBuilder, a.y(paramParcel, paramInt));
                continue;
                gi.a(paramStringBuilder, a.s(paramParcel, paramInt));
                continue;
                gi.a(paramStringBuilder, a.z(paramParcel, paramInt));
                continue;
                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                paramParcel = a.C(paramParcel, paramInt);
                int i = paramParcel.length;
                paramInt = 0;
                while (paramInt < i) {
                    if (paramInt > 0) {
                        paramStringBuilder.append(",");
                    }
                    paramParcel[paramInt].setDataPosition(0);
                    a(paramStringBuilder, parama.fk(), paramParcel[paramInt]);
                    paramInt += 1;
                }
            }
        }
        switch (parama.eX()) {
            default:
                throw new IllegalStateException("Unknown field type out");
            case 0:
                paramStringBuilder.append(a.g(paramParcel, paramInt));
                return;
            case 1:
                paramStringBuilder.append(a.j(paramParcel, paramInt));
                return;
            case 2:
                paramStringBuilder.append(a.i(paramParcel, paramInt));
                return;
            case 3:
                paramStringBuilder.append(a.k(paramParcel, paramInt));
                return;
            case 4:
                paramStringBuilder.append(a.l(paramParcel, paramInt));
                return;
            case 5:
                paramStringBuilder.append(a.m(paramParcel, paramInt));
                return;
            case 6:
                paramStringBuilder.append(a.c(paramParcel, paramInt));
                return;
            case 7:
                parama = a.n(paramParcel, paramInt);
                paramStringBuilder.append("\"").append(gp.av(parama)).append("\"");
                return;
            case 8:
                parama = a.q(paramParcel, paramInt);
                paramStringBuilder.append("\"").append(gj.d(parama)).append("\"");
                return;
            case 9:
                parama = a.q(paramParcel, paramInt);
                paramStringBuilder.append("\"").append(gj.e(parama));
                paramStringBuilder.append("\"");
                return;
            case 10:
                parama = a.p(paramParcel, paramInt);
                paramParcel = parama.keySet();
                paramParcel.size();
                paramStringBuilder.append("{");
                paramParcel = paramParcel.iterator();
                for (paramInt = 1; paramParcel.hasNext(); paramInt = 0) {
                    String str = (String) paramParcel.next();
                    if (paramInt == 0) {
                        paramStringBuilder.append(",");
                    }
                    paramStringBuilder.append("\"").append(str).append("\"");
                    paramStringBuilder.append(":");
                    paramStringBuilder.append("\"").append(gp.av(parama.getString(str))).append("\"");
                }
                paramStringBuilder.append("}");
                return;
        }
        paramParcel = a.B(paramParcel, paramInt);
        paramParcel.setDataPosition(0);
        a(paramStringBuilder, parama.fk(), paramParcel);
    }

    private void b(StringBuilder paramStringBuilder, ga.a<?, ?> parama, Object paramObject) {
        if (parama.fc()) {
            b(paramStringBuilder, parama, (ArrayList) paramObject);
            return;
        }
        a(paramStringBuilder, parama.eW(), paramObject);
    }

    private void b(StringBuilder paramStringBuilder, ga.a<?, ?> parama, ArrayList<?> paramArrayList) {
        paramStringBuilder.append("[");
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            a(paramStringBuilder, parama.eW(), paramArrayList.get(i));
            i += 1;
        }
        paramStringBuilder.append("]");
    }

    public static HashMap<String, String> c(Bundle paramBundle) {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localHashMap.put(str, paramBundle.getString(str));
        }
        return localHashMap;
    }

    private static HashMap<Integer, Map.Entry<String, ga.a<?, ?>>> c(HashMap<String, ga.a<?, ?>> paramHashMap) {
        HashMap localHashMap = new HashMap();
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramHashMap.next();
            localHashMap.put(Integer.valueOf(((ga.a) localEntry.getValue()).ff()), localEntry);
        }
        return localHashMap;
    }

    protected Object aq(String paramString) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean ar(String paramString) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        gh localgh = CREATOR;
        return 0;
    }

    public HashMap<String, ga.a<?, ?>> eY() {
        if (this.Eg == null) {
            return null;
        }
        return this.Eg.au(this.mClassName);
    }

    public Parcel fq() {
        switch (this.Ep) {
        }
        for (; ; ) {
            return this.En;
            this.Eq = b.p(this.En);
            b.F(this.En, this.Eq);
            this.Ep = 2;
            continue;
            b.F(this.En, this.Eq);
            this.Ep = 2;
        }
    }

    gd fr() {
        switch (this.Eo) {
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Eo);
            case 0:
                return null;
            case 1:
                return this.Eg;
        }
        return this.Eg;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public String toString() {
        fq.b(this.Eg, "Cannot convert to JSON on client side.");
        Parcel localParcel = fq();
        localParcel.setDataPosition(0);
        StringBuilder localStringBuilder = new StringBuilder(100);
        a(localStringBuilder, this.Eg.au(this.mClassName), localParcel);
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        gh localgh = CREATOR;
        gh.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */