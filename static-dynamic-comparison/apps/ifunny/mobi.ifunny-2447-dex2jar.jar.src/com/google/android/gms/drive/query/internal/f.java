package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.g;

import java.util.List;

public abstract interface f<F> {
    public abstract F a(F paramF);

    public abstract F b();

    public abstract F b(a<?> parama);

    public abstract <T> F b(a<T> parama, T paramT);

    public abstract <T> F b(g<T> paramg, T paramT);

    public abstract <T> F b(Operator paramOperator, a<T> parama, T paramT);

    public abstract F b(Operator paramOperator, List<F> paramList);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */