package com.mopub.nativeads;

import com.mopub.common.Preconditions.NoThrow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoPubNativeAdPositioning$MoPubClientPositioning {
    public static final int NO_REPEAT = Integer.MAX_VALUE;
    private final ArrayList<Integer> mFixedPositions = new ArrayList();
    private int mRepeatInterval = Integer.MAX_VALUE;

    public MoPubClientPositioning addFixedPosition(int paramInt) {
        boolean bool;
        if (paramInt >= 0) {
            bool = true;
            if (Preconditions.NoThrow.checkArgument(bool)) {
                break label20;
            }
        }
        label20:
        int i;
        do {
            return this;
            bool = false;
            break;
            i = Collections.binarySearch(this.mFixedPositions, Integer.valueOf(paramInt));
        } while (i >= 0);
        this.mFixedPositions.add(i ^ 0xFFFFFFFF, Integer.valueOf(paramInt));
        return this;
    }

    public MoPubClientPositioning enableRepeatingPositions(int paramInt) {
        boolean bool = true;
        if (paramInt > 1) {
        }
        while (!Preconditions.NoThrow.checkArgument(bool, "Repeating interval must be greater than 1")) {
            this.mRepeatInterval = Integer.MAX_VALUE;
            return this;
            bool = false;
        }
        this.mRepeatInterval = paramInt;
        return this;
    }

    List<Integer> getFixedPositions() {
        return this.mFixedPositions;
    }

    int getRepeatingInterval() {
        return this.mRepeatInterval;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNativeAdPositioning$MoPubClientPositioning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */