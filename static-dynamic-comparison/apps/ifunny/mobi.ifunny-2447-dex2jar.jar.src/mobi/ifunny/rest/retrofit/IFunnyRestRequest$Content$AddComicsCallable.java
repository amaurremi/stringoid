package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.TaskInfo;
import retrofit.mime.TypedOutput;

class IFunnyRestRequest$Content$AddComicsCallable
        extends RestCallable<TaskInfo> {
    private final Retrofit.RestInterface caller;
    private final TypedOutput draft;
    private final TypedOutput image;
    private final String src_ids;
    private final String texts;
    private final String title;
    private final String type;

    private IFunnyRestRequest$Content$AddComicsCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, TypedOutput paramTypedOutput1, TypedOutput paramTypedOutput2, String paramString3, String paramString4) {
        this.caller = paramRestInterface;
        this.type = paramString1;
        this.title = paramString2;
        this.image = paramTypedOutput1;
        this.draft = paramTypedOutput2;
        this.texts = paramString3;
        this.src_ids = paramString4;
    }

    public RestResponse<TaskInfo> call() {
        return this.caller.addComics(this.type, this.title, this.image, this.draft, this.texts, this.src_ids);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$AddComicsCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */