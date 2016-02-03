package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeedImpl;
import mobi.ifunny.rest.content.GetComment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RepublishedCounter;
import mobi.ifunny.rest.content.RepublishersFeed;
import mobi.ifunny.rest.content.SmilersFeed;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.content.TaskInfo;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedOutput;

public final class IFunnyRestRequest$Content {
    public static final String CONTENT_FROM_COLLECTIVE = "coll";
    public static final String CONTENT_FROM_FEATURED = "feat";
    public static final String CONTENT_FROM_POPULAR = "popu";
    public static final String CONTENT_FROM_PROFILE = "prof";
    public static final String CONTENT_FROM_SEARCH = "sear";
    public static final String CONTENT_FROM_SUBSCRIPTIONS = "subs";
    public static final String STAT_OP_SAVE = "save";
    public static final String STAT_OP_SHARE = "share";
    public static final String STAT_SHARE_TYPE_EMAIL = "email";
    public static final String STAT_SHARE_TYPE_FACEBOOK = "fb";
    public static final String STAT_SHARE_TYPE_TWITTER = "tw";
    public static final String STAT_SHARE_TYPE_UNKNOWN = "unknown";

    public static <T extends a> void addCaption(T paramT, String paramString1, String paramString2, String paramString3, TypedOutput paramTypedOutput1, TypedOutput paramTypedOutput2, String paramString4, RestHttpHandler<TaskInfo, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.AddCaptionCallable(Retrofit.rest, paramString2, paramString3, paramTypedOutput1, paramTypedOutput2, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void addComics(T paramT, String paramString1, String paramString2, String paramString3, TypedOutput paramTypedOutput1, TypedOutput paramTypedOutput2, String paramString4, String paramString5, RestHttpHandler<TaskInfo, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.AddComicsCallable(Retrofit.rest, paramString2, paramString3, paramTypedOutput1, paramTypedOutput2, paramString4, paramString5, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void addComment(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<Comment, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.AddCommentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static RestResponse<TaskInfo> addGifCaptionSync(String paramString1, String paramString2, TypedOutput paramTypedOutput, String paramString3) {
        paramString1 = new IFunnyRestRequest.Content.AddGifCaptionCallable(Retrofit.rest, paramString1, paramString2, paramTypedOutput, paramString3, null);
        try {
            paramString1 = paramString1.call();
            return paramString1;
        } catch (RetrofitError paramString1) {
            paramString2 = new RestResponse();
            paramString2.status = paramString1.getResponse().getStatus();
            return paramString2;
        } catch (Exception paramString1) {
        }
        return null;
    }

    public static <T extends a> void addImage(T paramT, String paramString1, String paramString2, String paramString3, TypedOutput paramTypedOutput, String paramString4, RestHttpHandler<TaskInfo, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.AddImageCallable(Retrofit.rest, paramString2, paramString3, paramTypedOutput, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static RestResponse<TaskInfo> addImageSync(String paramString1, String paramString2, TypedOutput paramTypedOutput, String paramString3) {
        paramString1 = new IFunnyRestRequest.Content.AddImageCallable(Retrofit.rest, paramString1, paramString2, paramTypedOutput, paramString3, null);
        try {
            paramString1 = paramString1.call();
            return paramString1;
        } catch (Exception paramString1) {
        }
        return null;
    }

    public static <T extends a> void addMeme(T paramT, String paramString1, String paramString2, String paramString3, TypedOutput paramTypedOutput1, TypedOutput paramTypedOutput2, String paramString4, String paramString5, String paramString6, RestHttpHandler<TaskInfo, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.AddMemeCallable(Retrofit.rest, paramString2, paramString3, paramTypedOutput1, paramTypedOutput2, paramString4, paramString5, paramString6, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void addVideo(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, RestHttpHandler<TaskInfo, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.AddVideoCallable(Retrofit.rest, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void contentStat(T paramT, String paramString1, RestHttpHandler<Void, T> paramRestHttpHandler, String paramString2, String paramString3, String paramString4) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.ContentStatCallable(Retrofit.rest, paramString2, paramString3, paramString4), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteContent(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.DeleteContentCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteRepublishContent(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<RepublishedCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.DeleteRepublishContentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteSmile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.DeleteLikeCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteUnsmile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.DeleteUnsmileCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void getComment(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<GetComment, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.GetCommentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getComments(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, RestHttpHandler<CommentsFeedImpl, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.GetCommentsCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4, paramString5), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void getContent(T paramT, String paramString1, String paramString2, RestHttpHandler<IFunny, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.GetContentCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getContent(T paramT, String paramString1, String paramString2, RestHttpHandler<IFunny, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.GetContentCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getRepublishers(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<RepublishersFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.GetRepublishersCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getSmilers(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<SmilersFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.GetSmilersCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void putAbuse(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.PutAbuseCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void putSmile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.PutLikeCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void putUnsmile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.PutUnsmileCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void republishContent(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<RepublishedCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Content.RepublishContentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */