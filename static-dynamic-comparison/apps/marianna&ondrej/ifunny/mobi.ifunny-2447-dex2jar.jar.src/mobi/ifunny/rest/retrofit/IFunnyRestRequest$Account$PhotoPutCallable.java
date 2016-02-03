package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.UploadedPhoto;
import retrofit.mime.TypedOutput;

final class IFunnyRestRequest$Account$PhotoPutCallable
        extends RestCallable<UploadedPhoto> {
    private final Retrofit.RestInterface caller;
    private final TypedOutput photo;

    private IFunnyRestRequest$Account$PhotoPutCallable(Retrofit.RestInterface paramRestInterface, TypedOutput paramTypedOutput) {
        this.caller = paramRestInterface;
        this.photo = paramTypedOutput;
    }

    public RestResponse<UploadedPhoto> call() {
        return this.caller.putAccountPhoto(this.photo);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$PhotoPutCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */