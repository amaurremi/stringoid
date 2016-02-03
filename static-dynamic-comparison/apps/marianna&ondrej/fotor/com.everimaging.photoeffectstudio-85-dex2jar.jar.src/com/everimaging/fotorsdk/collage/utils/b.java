package com.everimaging.fotorsdk.collage.utils;

import com.everimaging.fotorsdk.collage.widget.ICollageViewItem;

import java.util.Comparator;

public class b
        implements Comparator<ICollageViewItem> {
    public int a(ICollageViewItem paramICollageViewItem1, ICollageViewItem paramICollageViewItem2) {
        int j = paramICollageViewItem1.getZIndex();
        int k = paramICollageViewItem2.getZIndex();
        int i = 0;
        if (j < k) {
            i = -1;
        }
        while (j <= k) {
            return i;
        }
        return 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */