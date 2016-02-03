package com.quoord.tapatalkpro.util;

import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;

import java.util.Comparator;

public class TabItemOrder
        implements Comparator {
    public int compare(Object paramObject1, Object paramObject2) {
        paramObject1 = (TabItem) paramObject1;
        paramObject2 = (TabItem) paramObject2;
        try {
            int i = ((TabItem) paramObject1).getOrder().compareTo(((TabItem) paramObject2).getOrder());
            return i;
        } catch (Exception paramObject1) {
            ((Exception) paramObject1).printStackTrace();
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TabItemOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */