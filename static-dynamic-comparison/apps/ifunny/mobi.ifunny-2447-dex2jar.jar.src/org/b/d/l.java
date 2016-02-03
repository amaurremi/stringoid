package org.b.d;

import java.util.Date;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class l
        extends a<Date> {
    static final l a = new l();

    public static l a() {
        return a;
    }

    public Date a(q paramq, Date paramDate, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return new Date(paramq.m());
    }

    public void a(e parame, Date paramDate, boolean paramBoolean) {
        if (paramDate == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramDate.getTime());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */