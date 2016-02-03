package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import java.util.Collection;

public class nu
        implements ni<nu> {
    protected JsonTypeInfo.Id a;
    protected JsonTypeInfo.As b;
    protected String c;
    protected Class<?> d;
    protected nh e;

    public static nu b() {
        return new nu().b(JsonTypeInfo.Id.NONE, null);
    }

    public jy a(iy paramiy, sh paramsh, Collection<nf> paramCollection, is paramis) {
        if (this.a == JsonTypeInfo.Id.NONE) {
            return null;
        }
        paramiy = a(paramiy, paramsh, paramCollection, false, true);
        switch (1. a[this.b.ordinal()])
        {
            default:
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
            case 1:
                return new nj(paramsh, paramiy, paramis, this.d);
            case 2:
                return new nn(paramsh, paramiy, paramis, this.d, this.c);
            case 3:
                return new np(paramsh, paramiy, paramis, this.d);
        }
        return new nl(paramsh, paramiy, paramis, this.d, this.c);
    }

    public jz a(ju paramju, sh paramsh, Collection<nf> paramCollection, is paramis) {
        if (this.a == JsonTypeInfo.Id.NONE) {
            return null;
        }
        paramju = a(paramju, paramsh, paramCollection, true, false);
        switch (1. a[this.b.ordinal()])
        {
            default:
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
            case 1:
                return new nk(paramju, paramis);
            case 2:
                return new no(paramju, paramis, this.c);
            case 3:
                return new nq(paramju, paramis);
        }
        return new nm(paramju, paramis, this.c);
    }

    protected nh a(jn<?> paramjn, sh paramsh, Collection<nf> paramCollection, boolean paramBoolean1, boolean paramBoolean2) {
        if (this.e != null) {
            return this.e;
        }
        if (this.a == null) {
            throw new IllegalStateException("Can not build, 'init()' not yet called");
        }
        switch (1. b[this.a.ordinal()])
        {
            default:
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.a);
            case 1:
                return new nr(paramsh, paramjn.m());
            case 2:
                return new ns(paramsh, paramjn.m());
            case 3:
                return nx.a(paramjn, paramsh, paramCollection, paramBoolean1, paramBoolean2);
        }
        return null;
    }

    public Class<?> a() {
        return this.d;
    }

    public nu b(JsonTypeInfo.As paramAs) {
        if (paramAs == null) {
            throw new IllegalArgumentException("includeAs can not be null");
        }
        this.b = paramAs;
        return this;
    }

    public nu b(JsonTypeInfo.Id paramId, nh paramnh) {
        if (paramId == null) {
            throw new IllegalArgumentException("idType can not be null");
        }
        this.a = paramId;
        this.e = paramnh;
        this.c = paramId.getDefaultPropertyName();
        return this;
    }

    public nu b(Class<?> paramClass) {
        this.d = paramClass;
        return this;
    }

    public nu b(String paramString) {
        String str;
        if (paramString != null) {
            str = paramString;
            if (paramString.length() != 0) {
            }
        } else {
            str = this.a.getDefaultPropertyName();
        }
        this.c = str;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */