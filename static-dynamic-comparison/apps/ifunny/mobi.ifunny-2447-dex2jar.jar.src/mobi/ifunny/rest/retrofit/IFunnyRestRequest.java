package mobi.ifunny.rest.retrofit;

import mobi.ifunny.e;

public class IFunnyRestRequest {
    private static final NotificationListener notificationListener = e.a;

    public static RestResponse<Void> setRunningTest(String paramString) {
        return setRunningTest(paramString, "None");
    }

    public static RestResponse<Void> setRunningTest(String paramString1, String paramString2) {
        return (RestResponse) CommonRestTask.callWithRetries(new IFunnyRestRequest.SetRunningTestCallable(Retrofit.rest, paramString1, paramString2, null), 1).result;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */