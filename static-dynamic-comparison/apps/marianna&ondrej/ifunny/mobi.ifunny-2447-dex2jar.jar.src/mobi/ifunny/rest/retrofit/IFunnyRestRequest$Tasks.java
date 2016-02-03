package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.TaskInfo;

public final class IFunnyRestRequest$Tasks {
    public static RestResponse<TaskInfo> getAsyncProcess(String paramString) {
        return (RestResponse) CommonRestTask.callWithRetries(new IFunnyRestRequest.Tasks.GetAsyncProcessCallable(Retrofit.rest, paramString, null), 1).result;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Tasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */