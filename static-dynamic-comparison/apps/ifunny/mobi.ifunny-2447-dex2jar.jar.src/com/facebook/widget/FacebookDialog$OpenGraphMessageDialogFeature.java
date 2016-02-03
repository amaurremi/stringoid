package com.facebook.widget;

public enum FacebookDialog$OpenGraphMessageDialogFeature
        implements FacebookDialog.DialogFeature {
    OG_MESSAGE_DIALOG(20140204);

    private int minVersion;

    private FacebookDialog$OpenGraphMessageDialogFeature(int paramInt) {
        this.minVersion = paramInt;
    }

    public String getAction() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$OpenGraphMessageDialogFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */