package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ga {
    private void a(StringBuilder paramStringBuilder, a parama, Object paramObject) {
        if (parama.eW() == 11) {
            paramStringBuilder.append(((ga) parama.fg().cast(paramObject)).toString());
            return;
        }
        if (parama.eW() == 7) {
            paramStringBuilder.append("\"");
            paramStringBuilder.append(gp.av((String) paramObject));
            paramStringBuilder.append("\"");
            return;
        }
        paramStringBuilder.append(paramObject);
    }

    private void a(StringBuilder paramStringBuilder, a parama, ArrayList<Object> paramArrayList) {
        paramStringBuilder.append("[");
        int i = 0;
        int j = paramArrayList.size();
        while (i < j) {
            if (i > 0) {
                paramStringBuilder.append(",");
            }
            Object localObject = paramArrayList.get(i);
            if (localObject != null) {
                a(paramStringBuilder, parama, localObject);
            }
            i += 1;
        }
        paramStringBuilder.append("]");
    }

    protected <O, I> I a(a<I, O> parama, Object paramObject) {
        Object localObject = paramObject;
        if (a.c(parama) != null) {
            localObject = parama.g(paramObject);
        }
        return (I) localObject;
    }

    protected boolean a(a parama) {
        if (parama.eX() == 11) {
            if (parama.fd()) {
                return at(parama.fe());
            }
            return as(parama.fe());
        }
        return ar(parama.fe());
    }

    protected abstract Object aq(String paramString);

    protected abstract boolean ar(String paramString);

    protected boolean as(String paramString) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean at(String paramString) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object b(a parama) {
        boolean bool = true;
        String str = parama.fe();
        if (parama.fg() != null) {
            if (aq(parama.fe()) == null) {
                fq.a(bool, "Concrete field shouldn't be value object: " + parama.fe());
                if (!parama.fd()) {
                    break label80;
                }
            }
            label80:
            for (parama = fa(); ; parama = eZ()) {
                if (parama == null) {
                    break label88;
                }
                return parama.get(str);
                bool = false;
                break;
            }
            try {
                label88:
                parama = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
                parama = getClass().getMethod(parama, new Class[0]).invoke(this, new Object[0]);
                return parama;
            } catch (Exception parama) {
                throw new RuntimeException(parama);
            }
        }
        return aq(parama.fe());
    }

    public abstract HashMap<String, a<?, ?>> eY();

    public HashMap<String, Object> eZ() {
        return null;
    }

    public HashMap<String, Object> fa() {
        return null;
    }

    public String toString() {
        HashMap localHashMap = eY();
        StringBuilder localStringBuilder = new StringBuilder(100);
        Iterator localIterator = localHashMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            a locala = (a) localHashMap.get(str);
            if (a(locala)) {
                Object localObject = a(locala, b(locala));
                if (localStringBuilder.length() == 0) {
                    localStringBuilder.append("{");
                }
                for (; ; ) {
                    localStringBuilder.append("\"").append(str).append("\":");
                    if (localObject != null) {
                        break label135;
                    }
                    localStringBuilder.append("null");
                    break;
                    localStringBuilder.append(",");
                }
                label135:
                switch (locala.eX()) {
                    default:
                        if (locala.fc()) {
                            a(localStringBuilder, locala, (ArrayList) localObject);
                        }
                        break;
                    case 8:
                        localStringBuilder.append("\"").append(gj.d((byte[]) localObject)).append("\"");
                        break;
                    case 9:
                        localStringBuilder.append("\"").append(gj.e((byte[]) localObject)).append("\"");
                        break;
                    case 10:
                        gq.a(localStringBuilder, (HashMap) localObject);
                        continue;
                        a(localStringBuilder, locala, localObject);
                }
            }
        }
        if (localStringBuilder.length() > 0) {
            localStringBuilder.append("}");
        }
        for (; ; ) {
            return localStringBuilder.toString();
            localStringBuilder.append("{}");
        }
    }

    public static class a<I, O>
            implements SafeParcelable {
        public static final gb CREATOR = new gb();
        protected final int DY;
        protected final boolean DZ;
        protected final int Ea;
        protected final boolean Eb;
        protected final String Ec;
        protected final int Ed;
        protected final Class<? extends ga> Ee;
        protected final String Ef;
        private gd Eg;
        private ga.b<I, O> Eh;
        private final int xH;

        a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, fv paramfv) {
            this.xH = paramInt1;
            this.DY = paramInt2;
            this.DZ = paramBoolean1;
            this.Ea = paramInt3;
            this.Eb = paramBoolean2;
            this.Ec = paramString1;
            this.Ed = paramInt4;
            if (paramString2 == null) {
                this.Ee = null;
            }
            for (this.Ef = null; paramfv == null; this.Ef = paramString2) {
                this.Eh = null;
                return;
                this.Ee = gg.class;
            }
            this.Eh = paramfv.eU();
        }

        protected a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends ga> paramClass, ga.b<I, O> paramb) {
            this.xH = 1;
            this.DY = paramInt1;
            this.DZ = paramBoolean1;
            this.Ea = paramInt2;
            this.Eb = paramBoolean2;
            this.Ec = paramString;
            this.Ed = paramInt3;
            this.Ee = paramClass;
            if (paramClass == null) {
            }
            for (this.Ef = null; ; this.Ef = paramClass.getCanonicalName()) {
                this.Eh = paramb;
                return;
            }
        }

        public static a a(String paramString, int paramInt, ga.b<?, ?> paramb, boolean paramBoolean) {
            return new a(paramb.eW(), paramBoolean, paramb.eX(), false, paramString, paramInt, null, paramb);
        }

        public static <T extends ga> a<T, T> a(String paramString, int paramInt, Class<T> paramClass) {
            return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
        }

        public static <T extends ga> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass) {
            return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
        }

        public static a<Integer, Integer> g(String paramString, int paramInt) {
            return new a(0, false, 0, false, paramString, paramInt, null, null);
        }

        public static a<Double, Double> h(String paramString, int paramInt) {
            return new a(4, false, 4, false, paramString, paramInt, null, null);
        }

        public static a<Boolean, Boolean> i(String paramString, int paramInt) {
            return new a(6, false, 6, false, paramString, paramInt, null, null);
        }

        public static a<String, String> j(String paramString, int paramInt) {
            return new a(7, false, 7, false, paramString, paramInt, null, null);
        }

        public static a<ArrayList<String>, ArrayList<String>> k(String paramString, int paramInt) {
            return new a(7, true, 7, true, paramString, paramInt, null, null);
        }

        public void a(gd paramgd) {
            this.Eg = paramgd;
        }

        public int describeContents() {
            gb localgb = CREATOR;
            return 0;
        }

        public int eW() {
            return this.DY;
        }

        public int eX() {
            return this.Ea;
        }

        public a<I, O> fb() {
            return new a(this.xH, this.DY, this.DZ, this.Ea, this.Eb, this.Ec, this.Ed, this.Ef, fj());
        }

        public boolean fc() {
            return this.DZ;
        }

        public boolean fd() {
            return this.Eb;
        }

        public String fe() {
            return this.Ec;
        }

        public int ff() {
            return this.Ed;
        }

        public Class<? extends ga> fg() {
            return this.Ee;
        }

        String fh() {
            if (this.Ef == null) {
                return null;
            }
            return this.Ef;
        }

        public boolean fi() {
            return this.Eh != null;
        }

        fv fj() {
            if (this.Eh == null) {
                return null;
            }
            return fv.a(this.Eh);
        }

        public HashMap<String, a<?, ?>> fk() {
            fq.f(this.Ef);
            fq.f(this.Eg);
            return this.Eg.au(this.Ef);
        }

        public I g(O paramO) {
            return (I) this.Eh.g(paramO);
        }

        public int getVersionCode() {
            return this.xH;
        }

        public String toString() {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("Field\n");
            localStringBuilder1.append("            versionCode=").append(this.xH).append('\n');
            localStringBuilder1.append("                 typeIn=").append(this.DY).append('\n');
            localStringBuilder1.append("            typeInArray=").append(this.DZ).append('\n');
            localStringBuilder1.append("                typeOut=").append(this.Ea).append('\n');
            localStringBuilder1.append("           typeOutArray=").append(this.Eb).append('\n');
            localStringBuilder1.append("        outputFieldName=").append(this.Ec).append('\n');
            localStringBuilder1.append("      safeParcelFieldId=").append(this.Ed).append('\n');
            localStringBuilder1.append("       concreteTypeName=").append(fh()).append('\n');
            if (fg() != null) {
                localStringBuilder1.append("     concreteType.class=").append(fg().getCanonicalName()).append('\n');
            }
            StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
            if (this.Eh == null) {
            }
            for (String str = "null"; ; str = this.Eh.getClass().getCanonicalName()) {
                localStringBuilder2.append(str).append('\n');
                return localStringBuilder1.toString();
            }
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            gb localgb = CREATOR;
            gb.a(this, paramParcel, paramInt);
        }
    }

    public static abstract interface b<I, O> {
        public abstract int eW();

        public abstract int eX();

        public abstract I g(O paramO);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */