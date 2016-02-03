package com.flurry.sdk;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ku
        extends iz {
    protected hj c;
    protected final jc d;
    protected final jf e;
    protected qw f;
    protected re g;
    protected DateFormat h;

    public ku(iy paramiy, hj paramhj, jc paramjc, jf paramjf) {
        super(paramiy);
        this.c = paramhj;
        this.d = paramjc;
        this.e = paramjf;
    }

    public jh a(hj paramhj, hm paramhm, String paramString) {
        return jh.a(paramhj, "Unexpected token (" + paramhj.e() + "), expected " + paramhm + ": " + paramString);
    }

    public jh a(sh paramsh, String paramString) {
        return jh.a(this.c, "Could not resolve type id '" + paramString + "' into a subtype of " + paramsh);
    }

    public jh a(Class<?> paramClass, hm paramhm) {
        paramClass = c(paramClass);
        return jh.a(this.c, "Can not deserialize instance of " + paramClass + " out of " + paramhm + " token");
    }

    public jh a(Class<?> paramClass, String paramString) {
        return jh.a(this.c, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramString);
    }

    public jh a(Class<?> paramClass, String paramString1, String paramString2) {
        return jh.a(this.c, "Can not construct Map key of type " + paramClass.getName() + " from String \"" + c(paramString1) + "\": " + paramString2);
    }

    public jh a(Class<?> paramClass, Throwable paramThrowable) {
        return jh.a(this.c, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramThrowable.getMessage(), paramThrowable);
    }

    public jh a(Object paramObject, String paramString) {
        return mk.a(this.c, paramObject, paramString);
    }

    public Object a(Object paramObject1, is paramis, Object paramObject2) {
        if (this.e == null) {
            throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + paramObject1 + "]");
        }
        return this.e.a(paramObject1, this, paramis, paramObject2);
    }

    public Calendar a(Date paramDate) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        return localCalendar;
    }

    public Date a(String paramString)
            throws IllegalArgumentException {
        try {
            paramString = i().parse(paramString);
            return paramString;
        } catch (ParseException paramString) {
            throw new IllegalArgumentException(paramString.getMessage());
        }
    }

    public final void a(re paramre) {
        if ((this.g == null) || (paramre.b() >= this.g.b())) {
            this.g = paramre;
        }
    }

    public boolean a(hj paramhj, jg<?> paramjg, Object paramObject, String paramString)
            throws IOException, hk {
        rd localrd = this.a.f();
        if (localrd != null) {
            localhj = this.c;
            this.c = paramhj;
            paramhj = localrd;
        }
        for (; ; ) {
            if (paramhj != null) {
            }
            try {
                boolean bool = ((ja) paramhj.b()).a(this, paramjg, paramObject, paramString);
                if (bool) {
                    return true;
                }
                paramhj = paramhj.a();
            } finally {
                this.c = localhj;
            }
        }
        this.c = localhj;
        return false;
    }

    public jc b() {
        return this.d;
    }

    public jh b(Class<?> paramClass) {
        return a(paramClass, this.c.e());
    }

    public jh b(Class<?> paramClass, String paramString) {
        return jh.a(this.c, "Can not construct instance of " + paramClass.getName() + " from String value '" + j() + "': " + paramString);
    }

    public jh c(Class<?> paramClass, String paramString) {
        return jh.a(this.c, "Can not construct instance of " + paramClass.getName() + " from number value (" + j() + "): " + paramString);
    }

    protected String c(Class<?> paramClass) {
        if (paramClass.isArray()) {
            return c(paramClass.getComponentType()) + "[]";
        }
        return paramClass.getName();
    }

    protected String c(String paramString) {
        String str = paramString;
        if (paramString.length() > 500) {
            str = paramString.substring(0, 500) + "]...[" + paramString.substring(paramString.length() - 500);
        }
        return str;
    }

    public hj d() {
        return this.c;
    }

    public final re g() {
        re localre = this.g;
        if (localre == null) {
            return new re();
        }
        this.g = null;
        return localre;
    }

    public final qw h() {
        if (this.f == null) {
            this.f = new qw();
        }
        return this.f;
    }

    protected DateFormat i() {
        if (this.h == null) {
            this.h = ((DateFormat) this.a.n().clone());
        }
        return this.h;
    }

    protected String j() {
        try {
            String str = c(this.c.k());
            return str;
        } catch (Exception localException) {
        }
        return "[N/A]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */