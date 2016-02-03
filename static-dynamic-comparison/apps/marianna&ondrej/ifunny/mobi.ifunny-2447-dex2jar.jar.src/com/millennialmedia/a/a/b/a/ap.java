package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;

import java.util.Calendar;
import java.util.GregorianCalendar;

final class ap
        extends ae<Calendar> {
    public Calendar a(a parama) {
        int j = 0;
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        parama.c();
        int k = 0;
        int m = 0;
        int n = 0;
        int i1 = 0;
        int i2 = 0;
        while (parama.f() != c.d) {
            String str = parama.g();
            int i = parama.m();
            if ("year".equals(str)) {
                i2 = i;
            } else if ("month".equals(str)) {
                i1 = i;
            } else if ("dayOfMonth".equals(str)) {
                n = i;
            } else if ("hourOfDay".equals(str)) {
                m = i;
            } else if ("minute".equals(str)) {
                k = i;
            } else if ("second".equals(str)) {
                j = i;
            }
        }
        parama.d();
        return new GregorianCalendar(i2, i1, n, m, k, j);
    }

    public void a(d paramd, Calendar paramCalendar) {
        if (paramCalendar == null) {
            paramd.f();
            return;
        }
        paramd.d();
        paramd.a("year");
        paramd.a(paramCalendar.get(1));
        paramd.a("month");
        paramd.a(paramCalendar.get(2));
        paramd.a("dayOfMonth");
        paramd.a(paramCalendar.get(5));
        paramd.a("hourOfDay");
        paramd.a(paramCalendar.get(11));
        paramd.a("minute");
        paramd.a(paramCalendar.get(12));
        paramd.a("second");
        paramd.a(paramCalendar.get(13));
        paramd.e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */