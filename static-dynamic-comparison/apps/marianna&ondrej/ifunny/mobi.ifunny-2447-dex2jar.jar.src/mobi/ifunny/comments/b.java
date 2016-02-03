package mobi.ifunny.comments;

import mobi.ifunny.rest.content.GetComment;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class b
        extends SimpleRestHttpHandler<GetComment, AnswersActivity> {
    public void a(AnswersActivity paramAnswersActivity, Throwable paramThrowable) {
        AnswersActivity.a(paramAnswersActivity);
    }

    public void a(AnswersActivity paramAnswersActivity, GetComment paramGetComment) {
        AnswersActivity.a(paramAnswersActivity, paramGetComment.comment);
    }

    public void a(AnswersActivity paramAnswersActivity, RestError paramRestError) {
        AnswersActivity.a(paramAnswersActivity);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */