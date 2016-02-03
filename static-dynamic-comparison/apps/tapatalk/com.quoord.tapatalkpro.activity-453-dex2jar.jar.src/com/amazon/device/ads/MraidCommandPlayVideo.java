package com.amazon.device.ads;

import java.util.Map;

class MraidCommandPlayVideo
        extends MraidCommand {
    MraidCommandPlayVideo(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        Controller.Dimensions localDimensions = null;
        Object localObject = getIntArrayFromParamsForKey("position");
        if (localObject[0].intValue() != -1) {
            localDimensions = new Controller.Dimensions();
            localDimensions.y = localObject[0].intValue();
            localDimensions.x = localObject[1].intValue();
            localDimensions.width = localObject[2].intValue();
            localDimensions.height = localObject[3].intValue();
        }
        localObject = getStringFromParamsForKey("url");
        Controller.PlayerProperties localPlayerProperties = new Controller.PlayerProperties();
        localPlayerProperties.setProperties(getBooleanFromParamsForKey("audioMuted"), getBooleanFromParamsForKey("autoPlay"), getBooleanFromParamsForKey("controls"), true, getBooleanFromParamsForKey("loop"), getStringFromParamsForKey("startStyle"), getStringFromParamsForKey("stopStyle"));
        this.mView.getDisplayController().playVideo((String) localObject, localDimensions, localPlayerProperties);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidCommandPlayVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */