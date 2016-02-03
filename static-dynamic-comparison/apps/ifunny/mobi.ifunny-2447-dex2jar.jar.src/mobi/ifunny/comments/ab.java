package mobi.ifunny.comments;

public class ab
        implements Runnable {
    private boolean b;
    private int c;

    public ab(CommentsFragment paramCommentsFragment, int paramInt, boolean paramBoolean) {
        this.c = paramInt;
        this.b = paramBoolean;
    }

    public void run() {
        if (this.b) {
            CommentsFragment.a(this.a, this.c);
            return;
        }
        CommentsFragment.b(this.a, this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */