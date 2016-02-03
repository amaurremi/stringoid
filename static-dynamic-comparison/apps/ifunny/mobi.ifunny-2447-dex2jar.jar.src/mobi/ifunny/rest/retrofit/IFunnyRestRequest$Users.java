package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.NewsFeed;
import mobi.ifunny.rest.content.NickAvailability;
import mobi.ifunny.rest.content.User;

public final class IFunnyRestRequest$Users {
    public static <T extends e> void abuseProfile(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.AbuseCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void blockProfile(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.BlockCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void checkNick(T paramT, String paramString1, String paramString2, RestHttpHandler<NickAvailability, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.CheckNickCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void checkNick(T paramT, String paramString1, String paramString2, RestHttpHandler<NickAvailability, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.CheckNickCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void get(T paramT, String paramString1, String paramString2, RestHttpHandler<User, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.GetCallable(Retrofit.rest, paramString2, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getByNick(T paramT, String paramString1, String paramString2, RestHttpHandler<User, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.GetByNickCallable(Retrofit.rest, paramString2, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getMyNews(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<NewsFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.GetMyNewsCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getMySmiles(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<IFunnyFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.GetMySmilesCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    private static <T extends e> void register(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.RegisterCallable(Retrofit.rest, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void registerFacebook(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, RestHttpHandler<Void, T> paramRestHttpHandler) {
        register(paramT, paramString1, "fb", paramString2, paramString3, paramString4, paramString5, null, null, paramRestHttpHandler);
    }

    public static <T extends e> void registerGPlus(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, RestHttpHandler<Void, T> paramRestHttpHandler) {
        register(paramT, paramString1, "gplus", paramString2, paramString3, paramString4, paramString5, null, null, paramRestHttpHandler);
    }

    public static <T extends e> void registerPassword(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, RestHttpHandler<Void, T> paramRestHttpHandler) {
        register(paramT, paramString1, "pwd", paramString2, paramString3, null, null, null, paramString4, paramRestHttpHandler);
    }

    public static <T extends e> void registerTwitter(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, RestHttpHandler<Void, T> paramRestHttpHandler) {
        register(paramT, paramString1, "tw", paramString2, paramString3, paramString4, paramString5, paramString6, null, paramRestHttpHandler);
    }

    public static <T extends e> void shareProfile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.ShareCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void unblockProfile(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Users.UnblockCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */