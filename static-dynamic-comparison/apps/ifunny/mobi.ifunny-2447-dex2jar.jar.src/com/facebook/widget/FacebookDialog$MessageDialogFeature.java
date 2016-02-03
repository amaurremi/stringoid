package com.facebook.widget;

public enum FacebookDialog$MessageDialogFeature
        implements FacebookDialog.DialogFeature {
    MESSAGE_DIALOG(20140204), PHOTOS(20140324);

    private int minVersion;

    private FacebookDialog$MessageDialogFeature(int paramInt) {
        this.minVersion = paramInt;
    }

    public String getAction() {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$MessageDialogFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */