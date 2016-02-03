package mobi.ifunny.rest.retrofit;

import android.text.TextUtils;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.SearchResponse;
import mobi.ifunny.rest.content.SearchUsersResponce;

public class IFunnyRestRequest$Search {
    public static <T extends e> void searchContent(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<SearchResponse, T> paramRestHttpHandler) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty(paramString3)) {
            localObject1 = localObject2;
            if (TextUtils.isEmpty(paramString4)) {
                localObject1 = "content,users";
            }
        }
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Search.SearchContentCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4, (String) localObject1), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void searchUsers(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<SearchUsersResponce, T> paramRestHttpHandler) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty(paramString3)) {
            localObject1 = localObject2;
            if (TextUtils.isEmpty(paramString4)) {
                localObject1 = "content,users";
            }
        }
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Search.SearchUsersCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4, (String) localObject1), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Search.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */