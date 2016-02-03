package com.facebook.widget;

public enum FacebookDialog$OpenGraphActionDialogFeature
        implements FacebookDialog.DialogFeature {
    OG_ACTION_DIALOG(20130618);

    private int minVersion;

    private FacebookDialog$OpenGraphActionDialogFeature(int paramInt) {
        this.minVersion = paramInt;
    }

    public String getAction() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$OpenGraphActionDialogFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */