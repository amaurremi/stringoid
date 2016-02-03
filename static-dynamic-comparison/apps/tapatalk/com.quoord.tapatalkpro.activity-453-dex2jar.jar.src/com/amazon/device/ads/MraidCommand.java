package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Map;

abstract class MraidCommand {
    protected Map<String, String> mParams;
    protected MraidView mView;

    MraidCommand(Map<String, String> paramMap, MraidView paramMraidView) {
        this.mParams = paramMap;
        this.mView = paramMraidView;
    }

    abstract void execute();

    protected boolean getBooleanFromParamsForKey(String paramString) {
        return "true".equals(this.mParams.get(paramString));
    }

    protected float getFloatFromParamsForKey(String paramString) {
        if ((String) this.mParams.get(paramString) == null) {
            return 0.0F;
        }
        try {
            float f = Float.parseFloat(paramString);
            return f;
        } catch (NumberFormatException paramString) {
        }
        return 0.0F;
    }

    protected Integer[] getIntArrayFromParamsForKey(String paramString) {
        paramString = (String) this.mParams.get(paramString);
        if (paramString == null) {
            return null;
        }
        paramString = paramString.split(",");
        ArrayList localArrayList = new ArrayList();
        int j = paramString.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                String str = paramString[i];
                try {
                    localArrayList.add(Integer.valueOf(Integer.parseInt(str, 10)));
                    i += 1;
                } catch (NumberFormatException localNumberFormatException) {
                    for (; ; ) {
                        localArrayList.add(Integer.valueOf(-1));
                    }
                }
            }
        }
        return (Integer[]) localArrayList.toArray(new Integer[localArrayList.size()]);
    }

    protected int getIntFromParamsForKey(String paramString) {
        paramString = (String) this.mParams.get(paramString);
        if (paramString == null) {
            return -1;
        }
        try {
            int i = Integer.parseInt(paramString, 10);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return -1;
    }

    protected String getStringFromParamsForKey(String paramString) {
        return (String) this.mParams.get(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */