package mobi.ifunny.comments;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class c
        extends SimpleRestHttpHandler<IFunny, AnswersActivity> {
    public void a(AnswersActivity paramAnswersActivity, Throwable paramThrowable) {
        AnswersActivity.a(paramAnswersActivity);
    }

    public void a(AnswersActivity paramAnswersActivity, IFunny paramIFunny) {
        AnswersActivity.a(paramAnswersActivity, paramIFunny);
    }

    public void a(AnswersActivity paramAnswersActivity, RestError paramRestError) {
        AnswersActivity.a(paramAnswersActivity);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */