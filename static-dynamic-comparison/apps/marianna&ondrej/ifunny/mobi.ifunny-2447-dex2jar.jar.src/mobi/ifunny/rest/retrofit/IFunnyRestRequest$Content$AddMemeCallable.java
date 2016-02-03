package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.TaskInfo;
import retrofit.mime.TypedOutput;

final class IFunnyRestRequest$Content$AddMemeCallable
        extends RestCallable<TaskInfo> {
    private final String bottom_text;
    private final Retrofit.RestInterface caller;
    private final TypedOutput draft;
    private final TypedOutput image;
    private final String src_id;
    private final String title;
    private final String top_text;
    private final String type;

    private IFunnyRestRequest$Content$AddMemeCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, TypedOutput paramTypedOutput1, TypedOutput paramTypedOutput2, String paramString3, String paramString4, String paramString5) {
        this.caller = paramRestInterface;
        this.type = paramString1;
        this.title = paramString2;
        this.image = paramTypedOutput1;
        this.draft = paramTypedOutput2;
        this.top_text = paramString3;
        this.bottom_text = paramString4;
        this.src_id = paramString5;
    }

    public RestResponse<TaskInfo> call() {
        return this.caller.addMeme(this.type, this.title, this.image, this.draft, this.top_text, this.bottom_text, this.src_id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$AddMemeCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */