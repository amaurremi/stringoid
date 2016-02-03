package com.flurry.sdk;

import java.io.IOException;
import java.util.Calendar;

@kb
public class pd
        extends pt<Calendar> {
    public static pd a = new pd();

    public pd() {
        super(Calendar.class);
    }

    public void a(Calendar paramCalendar, hf paramhf, jw paramjw)
            throws IOException, he {
        paramjw.a(paramCalendar.getTimeInMillis(), paramhf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */