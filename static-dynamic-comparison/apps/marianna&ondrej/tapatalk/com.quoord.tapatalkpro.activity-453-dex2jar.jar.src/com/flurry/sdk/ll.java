package com.flurry.sdk;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@kb
public class ll
        extends mc<Calendar> {
    protected final Class<? extends Calendar> a;

    public ll() {
        this(null);
    }

    public ll(Class<? extends Calendar> paramClass) {
        super(Calendar.class);
        this.a = paramClass;
    }

    public Calendar b(hj paramhj, iz paramiz)
            throws IOException, hk {
        paramhj = B(paramhj, paramiz);
        if (paramhj == null) {
            return null;
        }
        if (this.a == null) {
            return paramiz.a(paramhj);
        }
        try {
            Calendar localCalendar = (Calendar) this.a.newInstance();
            localCalendar.setTimeInMillis(paramhj.getTime());
            return localCalendar;
        } catch (Exception paramhj) {
            throw paramiz.a(this.a, paramhj);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */