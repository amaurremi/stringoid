package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.TaskInfo;

class IFunnyRestRequest$Content$AddVideoCallable
        extends RestCallable<TaskInfo> {
    private final Retrofit.RestInterface caller;
    private final String id;
    private final String length;
    private final String provider;
    private final String screens;
    private final String title;
    private final String type;

    private IFunnyRestRequest$Content$AddVideoCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        this.caller = paramRestInterface;
        this.type = paramString1;
        this.title = paramString2;
        this.provider = paramString3;
        this.id = paramString4;
        this.screens = paramString5;
        this.length = paramString6;
    }

    public RestResponse<TaskInfo> call() {
        return this.caller.addVideo(this.type, this.title, this.provider, this.id, this.screens, this.length);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$AddVideoCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */