package mobi.ifunny.rest.retrofit;

import java.util.Collection;
import java.util.Iterator;

import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.DeleteResponcesList;
import mobi.ifunny.rest.content.MyCommented;
import mobi.ifunny.rest.content.RepliesFeed;
import mobi.ifunny.rest.content.SmilesCounter;

public final class IFunnyRestRequest$Comments {
    public static <T extends e> void abuseComment(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.AbuseCommentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void addReplyToComment(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, RestHttpHandler<Comment, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.AddReplyToCommentCallable(Retrofit.rest, paramString2, paramString3, paramString4), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteComment(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.DeleteCommentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteCommentSmile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.DeleteCommentSmileCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void deleteCommentUnsmile(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.DeleteCommentUnsmileCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e, C extends Comment> void deleteComments(T paramT, String paramString1, String paramString2, Collection<C> paramCollection, RestHttpHandler<DeleteResponcesList, T> paramRestHttpHandler) {
        StringBuilder localStringBuilder = new StringBuilder();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            localStringBuilder.append(((Comment) paramCollection.next()).id);
            localStringBuilder.append(',');
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        paramCollection = localStringBuilder.toString();
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.DeleteCommentsCallable(Retrofit.rest, paramString2, paramCollection), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getMyComments(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<MyCommented, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.GetMyCommentsCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getReplies(T paramT, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, RestHttpHandler<RepliesFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.GetRepliesCallable(Retrofit.rest, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void smileComment(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.SmileCommentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void unsmileComment(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilesCounter, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Comments.UnsmileCommentCallable(Retrofit.rest, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */