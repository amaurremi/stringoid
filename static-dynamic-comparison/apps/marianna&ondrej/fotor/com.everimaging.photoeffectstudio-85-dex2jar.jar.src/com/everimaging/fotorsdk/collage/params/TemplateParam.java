package com.everimaging.fotorsdk.collage.params;

import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.plugins.FeaturePack;

public class TemplateParam {
    private FeaturePack featurePack;
    private int previewCanvasH;
    private int previewCanvasW;
    private Template template;

    public FeaturePack getFeaturePack() {
        return this.featurePack;
    }

    public int getPreviewCanvasH() {
        return this.previewCanvasH;
    }

    public int getPreviewCanvasW() {
        return this.previewCanvasW;
    }

    public Template getTemplate() {
        return this.template;
    }

    public void setFeaturePack(FeaturePack paramFeaturePack) {
        this.featurePack = paramFeaturePack;
    }

    public void setPreviewCanvasH(int paramInt) {
        this.previewCanvasH = paramInt;
    }

    public void setPreviewCanvasW(int paramInt) {
        this.previewCanvasW = paramInt;
    }

    public void setTemplate(Template paramTemplate) {
        this.template = paramTemplate;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/params/TemplateParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */