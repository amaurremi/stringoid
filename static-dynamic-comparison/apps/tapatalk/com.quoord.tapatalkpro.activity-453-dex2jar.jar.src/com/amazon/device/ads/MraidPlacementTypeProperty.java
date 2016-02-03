package com.amazon.device.ads;

import java.util.Locale;

class MraidPlacementTypeProperty
        extends MraidProperty {
    private final MraidView.PlacementType mPlacementType;

    MraidPlacementTypeProperty(MraidView.PlacementType paramPlacementType) {
        this.mPlacementType = paramPlacementType;
    }

    public static MraidPlacementTypeProperty createWithType(MraidView.PlacementType paramPlacementType) {
        return new MraidPlacementTypeProperty(paramPlacementType);
    }

    public String toJsonPair() {
        return "placementType: '" + this.mPlacementType.toString().toLowerCase(Locale.US) + "'";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidPlacementTypeProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */