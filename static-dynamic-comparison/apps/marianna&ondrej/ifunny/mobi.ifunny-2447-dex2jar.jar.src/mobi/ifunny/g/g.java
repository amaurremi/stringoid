package mobi.ifunny.g;

import mobi.ifunny.comments.i;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class g
        extends SimpleRestHttpHandler<SmilesCounter, b> {
    private String a;
    private i b;

    private g(Comment paramComment, boolean paramBoolean) {
        this.a = paramComment.id;
        this.b = new i(paramComment, paramBoolean);
    }

    public void a(b paramb) {
        b.c(paramb, this.a, this.b);
    }

    public void a(b paramb, Throwable paramThrowable) {
    }

    public void a(b paramb, RestError paramRestError) {
        if ((paramRestError.status == 403) && (("already_unsmiled".equals(paramRestError.error)) || ("not_unsmiled".equals(paramRestError.error)))) {
            b.d(paramb, this.a, this.b);
        }
    }

    public void a(b paramb, SmilesCounter paramSmilesCounter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */