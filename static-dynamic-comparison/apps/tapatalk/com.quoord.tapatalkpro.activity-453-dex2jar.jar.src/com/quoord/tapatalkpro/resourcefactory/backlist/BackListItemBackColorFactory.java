package com.quoord.tapatalkpro.resourcefactory.backlist;

import android.content.Context;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;
import com.quoord.tapatalkpro.resourcefactory.AbsDistributionColorFactory;
import com.quoord.tapatalkpro.util.Prefs;

public class BackListItemBackColorFactory
        extends AbsDistributionColorFactory {
    private AbsColorRender colorRender;

    private AbsColorRender createColorRender(Context paramContext) {
        switch (Distribute(paramContext)) {
        }
        for (; ; ) {
            return this.colorRender;
            this.colorRender = new BackListItemBackLightColorRender(paramContext);
            continue;
            this.colorRender = new BackListItemBackDarkColorRender(paramContext);
        }
    }

    protected int Distribute(Context paramContext) {
        Prefs.get(paramContext);
        if (SettingsFragment.isLightTheme(paramContext)) {
            return 1;
        }
        return 2;
    }

    public AbsColorRender createColorRender(Context paramContext, int paramInt) {
        return createColorRender(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/resourcefactory/backlist/BackListItemBackColorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */