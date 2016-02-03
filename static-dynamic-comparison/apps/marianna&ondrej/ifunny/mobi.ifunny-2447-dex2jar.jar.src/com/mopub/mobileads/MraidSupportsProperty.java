package com.mopub.mobileads;

class MraidSupportsProperty
        extends MraidProperty {
    private boolean calendar;
    private boolean inlineVideo;
    private boolean sms;
    private boolean storePicture;
    private boolean tel;

    public String toJsonPair() {
        return "supports: {sms: " + String.valueOf(this.sms) + ", " + "tel: " + String.valueOf(this.tel) + ", " + "calendar: " + String.valueOf(this.calendar) + ", " + "storePicture: " + String.valueOf(this.storePicture) + ", " + "inlineVideo: " + String.valueOf(this.inlineVideo) + "}";
    }

    public MraidSupportsProperty withCalendar(boolean paramBoolean) {
        this.calendar = paramBoolean;
        return this;
    }

    public MraidSupportsProperty withInlineVideo(boolean paramBoolean) {
        this.inlineVideo = paramBoolean;
        return this;
    }

    public MraidSupportsProperty withSms(boolean paramBoolean) {
        this.sms = paramBoolean;
        return this;
    }

    public MraidSupportsProperty withStorePicture(boolean paramBoolean) {
        this.storePicture = paramBoolean;
        return this;
    }

    public MraidSupportsProperty withTel(boolean paramBoolean) {
        this.tel = paramBoolean;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidSupportsProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */