package com.everimaging.fotorsdk.editor.filter.params;

import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static BaseParams a(String paramString) {
        Object localObject;
        for (; ; ) {
            try {
                localObject = (String) new JSONObject(paramString).get("paramType");
                if (BaseParams.ParamsType.ADJUST.toString().equals(localObject)) {
                    localObject = new AdjustParams();
                    if (localObject == null) {
                    }
                }
            } catch (JSONException paramString) {
                localObject = null;
                paramString.printStackTrace();
                return (BaseParams) localObject;
            }
            try {
                ((BaseParams) localObject).parseFromJsonStr(paramString);
                return (BaseParams) localObject;
            } catch (JSONException paramString) {
                continue;
                localObject = null;
            }
            if (BaseParams.ParamsType.CROP.toString().equals(localObject)) {
                localObject = new CropParams();
            } else if (BaseParams.ParamsType.FX_EFFECT.toString().equals(localObject)) {
                localObject = new EffectsParams();
            } else if (BaseParams.ParamsType.ROTATE.toString().equals(localObject)) {
                localObject = new RotateParams();
            } else if (BaseParams.ParamsType.STICKERS.toString().equals(localObject)) {
                localObject = new StickersParams();
            } else if (BaseParams.ParamsType.TILT_SHIFT.toString().equals(localObject)) {
                localObject = new TiltShiftParams();
            } else if (BaseParams.ParamsType.TEXTS.toString().equals(localObject)) {
                localObject = new TextsParams();
            } else if (BaseParams.ParamsType.ENHANCE.toString().equals(localObject)) {
                localObject = new EnhanceParams();
            } else if (BaseParams.ParamsType.MOSAIC.toString().equals(localObject)) {
                localObject = new MosaicParams();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/params/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */