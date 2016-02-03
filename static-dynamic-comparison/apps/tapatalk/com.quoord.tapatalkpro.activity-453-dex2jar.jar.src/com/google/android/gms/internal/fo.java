package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class fo {
    public static a e(Object paramObject) {
        return new a(paramObject, null);
    }

    public static boolean equal(Object paramObject1, Object paramObject2) {
        return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    }

    public static int hashCode(Object... paramVarArgs) {
        return Arrays.hashCode(paramVarArgs);
    }

    public static final class a {
        private final List<String> DI;
        private final Object DJ;

        private a(Object paramObject) {
            this.DJ = fq.f(paramObject);
            this.DI = new ArrayList();
        }

        public a a(String paramString, Object paramObject) {
            this.DI.add((String) fq.f(paramString) + "=" + String.valueOf(paramObject));
            return this;
        }

        public String toString() {
            StringBuilder localStringBuilder = new StringBuilder(100).append(this.DJ.getClass().getSimpleName()).append('{');
            int j = this.DI.size();
            int i = 0;
            while (i < j) {
                localStringBuilder.append((String) this.DI.get(i));
                if (i < j - 1) {
                    localStringBuilder.append(", ");
                }
                i += 1;
            }
            return '}';
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */