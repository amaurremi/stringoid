package com.google.android.gms.fitness.data;

import java.util.List;

public class u {
    public static <T> int a(T paramT, List<T> paramList) {
        int i;
        if (paramT == null) {
            i = -1;
        }
        int j;
        do {
            return i;
            j = paramList.indexOf(paramT);
            i = j;
        } while (j >= 0);
        paramList.add(paramT);
        return paramList.size() - 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */