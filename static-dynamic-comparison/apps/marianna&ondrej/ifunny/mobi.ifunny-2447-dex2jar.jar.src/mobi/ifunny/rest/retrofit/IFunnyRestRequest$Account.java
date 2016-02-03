package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.CoverFeed;
import mobi.ifunny.rest.content.UploadedCover;
import mobi.ifunny.rest.content.UploadedPhoto;
import mobi.ifunny.rest.content.User;
import retrofit.mime.TypedOutput;

public final class IFunnyRestRequest$Account {
    public static <T extends e> void coverDelete(T paramT, String paramString, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.CoverDeleteCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void coverFeed(T paramT, String paramString, RestHttpHandler<CoverFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.CoverFeedCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void coverPut(T paramT, String paramString, TypedOutput paramTypedOutput, RestHttpHandler<UploadedCover, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.CoverPutCallable(Retrofit.rest, paramTypedOutput, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void emailPutRequest(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Account.EmailPutCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void get(T paramT, String paramString, RestHttpHandler<User, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.GetCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void get(T paramT, String paramString, RestHttpHandler<User, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.GetCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void passwordChangeRequest(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Account.GetPasswordChangeRequestCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void passwordChangeRequest(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Account.GetPasswordChangeRequestCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void photoDelete(T paramT, String paramString, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.PhotoDeleteCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void photoPut(T paramT, String paramString, TypedOutput paramTypedOutput, RestHttpHandler<UploadedPhoto, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Account.PhotoPutCallable(Retrofit.rest, paramTypedOutput, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void put(T paramT, String paramString1, RestHttpHandler<Void, T> paramRestHttpHandler, String paramString2, String paramString3) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Account.PutCallable(Retrofit.rest, paramString2, paramString3, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void socialsDelete(T paramT, String paramString1, RestHttpHandler<Void, T> paramRestHttpHandler, String paramString2) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Account.SocialsDeleteCallable(Retrofit.rest, paramString2, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void socialsPut(T paramT, String paramString1, RestHttpHandler<Void, T> paramRestHttpHandler, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Account.SocialsPutCallable(Retrofit.rest, paramString2, paramString3, paramString4, paramString5, paramBoolean, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */