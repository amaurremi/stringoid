package mobi.ifunny.g;

import mobi.ifunny.comments.i;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class f
        extends SimpleRestHttpHandler<SmilesCounter, b> {
    private String a;
    private i b;

    private f(Comment paramComment, boolean paramBoolean) {
        this.a = paramComment.id;
        this.b = new i(paramComment, paramBoolean);
    }

    public void a(b paramb) {
        b.a(paramb, this.a, this.b);
    }

    public void a(b paramb, Throwable paramThrowable) {
    }

    public void a(b paramb, RestError paramRestError) {
        if ((paramRestError.status == 403) && (("already_smiled".equals(paramRestError.error)) || ("not_smiled".equals(paramRestError.error)))) {
            b.b(paramb, this.a, this.b);
        }
    }

    public void a(b paramb, SmilesCounter paramSmilesCounter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */