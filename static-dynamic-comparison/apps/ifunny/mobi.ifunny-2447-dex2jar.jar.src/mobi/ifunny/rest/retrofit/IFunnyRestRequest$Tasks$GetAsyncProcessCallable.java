package mobi.ifunny.rest.retrofit;

import java.util.concurrent.Callable;

import mobi.ifunny.rest.content.TaskInfo;

final class IFunnyRestRequest$Tasks$GetAsyncProcessCallable
        implements Callable<RestResponse<TaskInfo>> {
    private final Retrofit.RestInterface caller;
    private final String id;

    private IFunnyRestRequest$Tasks$GetAsyncProcessCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.id = paramString;
    }

    public RestResponse<TaskInfo> call() {
        return this.caller.getTask(this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Tasks$GetAsyncProcessCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */