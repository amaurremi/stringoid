package mobi.ifunny.comments;

import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class ac
        extends SimpleRestHttpHandler<SmilesCounter, CommentsFragment> {
    private String a;
    private i b;

    private ac(Comment paramComment, boolean paramBoolean) {
        this.a = paramComment.id;
        this.b = new i(paramComment, paramBoolean);
    }

    public void a(CommentsFragment paramCommentsFragment) {
        CommentsFragment.a(paramCommentsFragment, this.a, this.b);
    }

    public void a(CommentsFragment paramCommentsFragment, Throwable paramThrowable) {
    }

    public void a(CommentsFragment paramCommentsFragment, RestError paramRestError) {
        if ((paramRestError.status == 403) && (("already_smiled".equals(paramRestError.error)) || ("not_smiled".equals(paramRestError.error)))) {
            CommentsFragment.b(paramCommentsFragment, this.a, this.b);
        }
    }

    public void a(CommentsFragment paramCommentsFragment, SmilesCounter paramSmilesCounter) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */