package com.flurry.sdk;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class mh
        extends mc<Timestamp> {
    public mh() {
        super(Timestamp.class);
    }

    public Timestamp b(hj paramhj, iz paramiz)
            throws IOException, hk {
        return new Timestamp(B(paramhj, paramiz).getTime());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */