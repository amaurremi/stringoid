package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> XU;
    private final String XV;

    public aj(String paramString, String... paramVarArgs) {
        this.XV = paramString;
        this.XU = new HashSet(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j) {
            paramString = paramVarArgs[i];
            this.XU.add(paramString);
            i += 1;
        }
    }

    boolean a(Set<String> paramSet) {
        return paramSet.containsAll(this.XU);
    }

    public abstract boolean jX();

    public String kB() {
        return this.XV;
    }

    public Set<String> kC() {
        return this.XU;
    }

    public abstract d.a x(Map<String, d.a> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */