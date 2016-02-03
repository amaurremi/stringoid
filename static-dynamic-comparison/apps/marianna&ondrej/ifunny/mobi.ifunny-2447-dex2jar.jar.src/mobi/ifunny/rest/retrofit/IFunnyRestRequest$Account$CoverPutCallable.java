package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.UploadedCover;
import retrofit.mime.TypedOutput;

final class IFunnyRestRequest$Account$CoverPutCallable
        extends RestCallable<UploadedCover> {
    private final Retrofit.RestInterface caller;
    private final TypedOutput cover;

    private IFunnyRestRequest$Account$CoverPutCallable(Retrofit.RestInterface paramRestInterface, TypedOutput paramTypedOutput) {
        this.caller = paramRestInterface;
        this.cover = paramTypedOutput;
    }

    public RestResponse<UploadedCover> call() {
        return this.caller.putAccountCover(this.cover);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$CoverPutCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */