package com.quoord.tapatalkpro.resourcefactory;

import android.content.Context;

public abstract class AbsDistributionColorFactory
        implements AbsColorFactory {
    public static final int COLOR_DARK = 2;
    public static final int COLOR_LIGHT = 1;
    public static final int COLOR_REBRANDING = 3;

    protected abstract int Distribute(Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/resourcefactory/AbsDistributionColorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */