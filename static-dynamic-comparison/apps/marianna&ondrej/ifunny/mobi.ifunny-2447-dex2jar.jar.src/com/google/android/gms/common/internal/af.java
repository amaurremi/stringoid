package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class af {
    private final List<String> a;
    private final Object b;

    private af(Object paramObject) {
        this.b = ag.a(paramObject);
        this.a = new ArrayList();
    }

    public af a(String paramString, Object paramObject) {
        this.a.add((String) ag.a(paramString) + "=" + String.valueOf(paramObject));
        return this;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
        int j = this.a.size();
        int i = 0;
        while (i < j) {
            localStringBuilder.append((String) this.a.get(i));
            if (i < j - 1) {
                localStringBuilder.append(", ");
            }
            i += 1;
        }
        return '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */