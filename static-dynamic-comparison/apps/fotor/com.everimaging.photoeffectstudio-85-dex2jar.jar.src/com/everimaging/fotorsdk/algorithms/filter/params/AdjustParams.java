package com.everimaging.fotorsdk.algorithms.filter.params;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdjustParams
        extends BaseParams {
    private float brightness = 0.0F;
    private float contrast = 1.0F;
    private float[] curvePoints;
    private float highlights = 0.0F;
    private boolean isProcessOrigin = false;
    private int mProcessImgHeight;
    private int mProcessImgWidth;
    private float ratio = 1.0F;
    private float rgb_B = 0.5F;
    private float rgb_G = 0.5F;
    private float rgb_R = 0.5F;
    private float samplerScale = 1.0F;
    private float saturation = 1.0F;
    private float shadows = 0.0F;
    private float sharpening = 1.0F;
    private float temperature = 0.0F;
    private float tint = 1.0F;
    private float vignette = 0.0F;

    public AdjustParams() {
        super(BaseParams.ParamsType.ADJUST);
    }

    public float getBrightness() {
        return this.brightness;
    }

    public float getContrast() {
        return this.contrast;
    }

    public float[] getCurvePoints() {
        return this.curvePoints;
    }

    public float getDisplayBrightness() {
        return this.brightness * 100.0F;
    }

    public float getDisplayContrast() {
        if (this.contrast < 1.0F) {
            return (this.contrast - 1.0F) / 0.25F * 100.0F;
        }
        return (this.contrast - 1.0F) / 0.6F * 100.0F;
    }

    public float getDisplayHighlights() {
        float f = this.highlights;
        if (f > 0.0F) {
            return f / 2.0F;
        }
        return f / 70.0F * 100.0F;
    }

    public float getDisplayRgb_B() {
        return this.rgb_B * 200.0F - 100.0F;
    }

    public float getDisplayRgb_G() {
        return this.rgb_G * 200.0F - 100.0F;
    }

    public float getDisplayRgb_R() {
        return this.rgb_R * 200.0F - 100.0F;
    }

    public float getDisplaySaturation() {
        return this.saturation * 100.0F - 100.0F;
    }

    public float getDisplayShadows() {
        float f2 = this.shadows;
        float f1 = f2;
        if (f2 < 0.0F) {
            f1 = f2 / 2.0F;
        }
        return f1;
    }

    public float getDisplaySharpening() {
        float f = this.sharpening;
        if (f < 1.0F) {
            return (f - 1.0F) * 100.0F;
        }
        return (f - 1.0F) / 3.0F * 100.0F;
    }

    public float getDisplayTemperature() {
        if (this.temperature < 0.0F) {
            return this.temperature / 0.5F * 100.0F;
        }
        return this.temperature / 0.7F * 100.0F;
    }

    public float getDisplayTint() {
        float f = this.tint;
        if (this.tint < 1.0F) {
            return (this.tint - 1.0F) / 0.5F * 100.0F;
        }
        return (this.tint - 1.0F) / 1.5F * 100.0F;
    }

    public float getDisplayVignette() {
        return this.vignette;
    }

    public float getHighlights() {
        return this.highlights;
    }

    public int getPreviewHeight() {
        return this.mProcessImgHeight;
    }

    public int getPreviewWidth() {
        return this.mProcessImgWidth;
    }

    public float getRatio() {
        return this.ratio;
    }

    public float getRgb_B() {
        return this.rgb_B;
    }

    public float getRgb_G() {
        return this.rgb_G;
    }

    public float getRgb_R() {
        return this.rgb_R;
    }

    public float getSamplerScale() {
        return this.samplerScale;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public float getShadows() {
        return this.shadows;
    }

    public float getSharpening() {
        return this.sharpening;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getTint() {
        return this.tint;
    }

    public float getVignette() {
        return this.vignette;
    }

    public boolean isProcessOrigin() {
        return this.isProcessOrigin;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (AdjustParams) new GsonBuilder().create().fromJson(paramString, getClass());
        this.paramType = paramString.paramType;
        this.isProcessOrigin = paramString.isProcessOrigin;
        this.ratio = paramString.ratio;
        this.mProcessImgWidth = paramString.mProcessImgWidth;
        this.mProcessImgHeight = paramString.mProcessImgHeight;
        this.brightness = paramString.brightness;
        this.contrast = paramString.contrast;
        this.saturation = paramString.saturation;
        this.sharpening = paramString.sharpening;
        this.samplerScale = paramString.samplerScale;
        this.vignette = paramString.vignette;
        this.shadows = paramString.shadows;
        this.highlights = paramString.highlights;
        this.temperature = paramString.temperature;
        this.tint = paramString.tint;
        this.rgb_R = paramString.rgb_R;
        this.rgb_G = paramString.rgb_G;
        this.rgb_B = paramString.rgb_B;
        this.curvePoints = paramString.curvePoints;
    }

    public void setBrightness(float paramFloat) {
        this.brightness = (paramFloat / 100.0F);
    }

    public void setContrast(float paramFloat) {
        if (paramFloat < 0.0F) {
        }
        for (paramFloat = paramFloat / 100.0F * 0.25F + 1.0F; ; paramFloat = paramFloat / 100.0F * 0.6F + 1.0F) {
            this.contrast = paramFloat;
            return;
        }
    }

    public void setCurvePoints(float[] paramArrayOfFloat) {
        this.curvePoints = paramArrayOfFloat;
    }

    public void setHighlights(float paramFloat) {
        if (paramFloat > 0.0F) {
        }
        for (paramFloat = 2.0F * paramFloat; ; paramFloat = paramFloat / 100.0F * 70.0F) {
            this.highlights = paramFloat;
            return;
        }
    }

    public void setPreviewSize(int paramInt1, int paramInt2) {
        this.mProcessImgWidth = paramInt1;
        this.mProcessImgHeight = paramInt2;
    }

    public void setProcessOrigin(boolean paramBoolean) {
        this.isProcessOrigin = paramBoolean;
    }

    public void setRatio(float paramFloat) {
        this.ratio = paramFloat;
    }

    public void setRgb_B(float paramFloat) {
        this.rgb_B = ((100.0F + paramFloat) / 200.0F);
    }

    public void setRgb_G(float paramFloat) {
        this.rgb_G = ((100.0F + paramFloat) / 200.0F);
    }

    public void setRgb_R(float paramFloat) {
        this.rgb_R = ((100.0F + paramFloat) / 200.0F);
    }

    public void setSamplerScale(float paramFloat) {
        this.samplerScale = paramFloat;
    }

    public void setSaturation(float paramFloat) {
        this.saturation = ((paramFloat + 100.0F) / 100.0F);
    }

    public void setShadows(float paramFloat) {
        float f = paramFloat;
        if (paramFloat < 0.0F) {
            f = paramFloat * 2.0F;
        }
        this.shadows = f;
    }

    public void setSharpening(float paramFloat) {
        if (paramFloat < 0.0F) {
        }
        for (paramFloat = paramFloat / 100.0F + 1.0F; ; paramFloat = paramFloat / 100.0F * 3.0F + 1.0F) {
            this.sharpening = paramFloat;
            return;
        }
    }

    public void setTemperature(float paramFloat) {
        if (paramFloat < 0.0F) {
        }
        for (paramFloat = paramFloat / 100.0F * 0.5F; ; paramFloat = paramFloat / 100.0F * 0.7F) {
            this.temperature = paramFloat;
            return;
        }
    }

    public void setTint(float paramFloat) {
        if (paramFloat < 0.0F) {
        }
        for (paramFloat = 0.5F * paramFloat / 100.0F + 1.0F; ; paramFloat = 1.5F * paramFloat / 100.0F + 1.0F) {
            this.tint = paramFloat;
            return;
        }
    }

    public void setVignette(float paramFloat) {
        this.vignette = ((100.0F + paramFloat) / 2.0F);
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */