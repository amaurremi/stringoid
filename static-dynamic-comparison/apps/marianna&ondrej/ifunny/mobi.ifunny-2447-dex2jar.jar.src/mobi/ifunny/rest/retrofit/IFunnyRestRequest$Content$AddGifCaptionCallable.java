package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.TaskInfo;
import retrofit.mime.TypedOutput;

final class IFunnyRestRequest$Content$AddGifCaptionCallable
        extends RestCallable<TaskInfo> {
    private final Retrofit.RestInterface caller;
    private final TypedOutput image;
    private final String text;
    private final String title;
    private final String type;

    private IFunnyRestRequest$Content$AddGifCaptionCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, TypedOutput paramTypedOutput, String paramString3) {
        this.caller = paramRestInterface;
        this.type = paramString1;
        this.title = paramString2;
        this.image = paramTypedOutput;
        this.text = paramString3;
    }

    public RestResponse<TaskInfo> call() {
        return this.caller.addGifCaption(this.type, this.title, this.image, this.text);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$AddGifCaptionCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */