package com.flurry.sdk;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class qc {
    protected static final jk<Object> a = new qb();
    protected static final jk<Object> b = new c();

    public static jk<Object> a(sh paramsh) {
        if (paramsh == null) {
            return a;
        }
        paramsh = paramsh.p();
        if (paramsh == String.class) {
            return b;
        }
        if (paramsh == Object.class) {
            return a;
        }
        if (Date.class.isAssignableFrom(paramsh)) {
            return b.a;
        }
        if (Calendar.class.isAssignableFrom(paramsh)) {
            return a.a;
        }
        return a;
    }

    public static class a
            extends pw<Calendar> {
        protected static final jk<?> a = new a();

        public a() {
            super();
        }

        public void a(Calendar paramCalendar, hf paramhf, jw paramjw)
                throws IOException, he {
            paramjw.b(paramCalendar.getTimeInMillis(), paramhf);
        }
    }

    public static class b
            extends pw<Date> {
        protected static final jk<?> a = new b();

        public b() {
            super();
        }

        public void a(Date paramDate, hf paramhf, jw paramjw)
                throws IOException, he {
            paramjw.b(paramDate, paramhf);
        }
    }

    public static class c
            extends pw<String> {
        public c() {
            super();
        }

        public void a(String paramString, hf paramhf, jw paramjw)
                throws IOException, he {
            paramhf.a(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */