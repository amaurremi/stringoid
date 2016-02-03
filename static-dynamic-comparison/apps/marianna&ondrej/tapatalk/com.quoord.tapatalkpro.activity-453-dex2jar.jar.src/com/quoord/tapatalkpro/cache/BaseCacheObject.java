package com.quoord.tapatalkpro.cache;

import java.io.Serializable;

public class BaseCacheObject
        implements Serializable {
    private static final long serialVersionUID = 3787663942776095791L;
    public String fileName;
    public boolean isForever;
    public long saveForTime;
    public long writeTime;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/cache/BaseCacheObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */