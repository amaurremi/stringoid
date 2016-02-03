package mobi.ifunny.comments.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.view.DotsView;

public class AnswersCommentViews
        extends SmilyCommentViews<Comment> {
    protected Comment a;
    private boolean d;
    @InjectView(2131492994)
    public View dotsLayout;
    @InjectView(2131492996)
    public DotsView dotsView;

    public AnswersCommentViews(Comment paramComment1, Comment paramComment2, View paramView, boolean paramBoolean1, e<Comment> parame, boolean paramBoolean2) {
        super(paramComment1, paramView, parame, paramBoolean2);
        ButterKnife.inject(this, paramView);
        this.a = paramComment2;
        a(paramBoolean1);
    }

    public void a(Context paramContext, b paramb) {
        super.a(paramContext, paramb);
        a(paramb);
    }

    public void a(b paramb) {
        int j = this.b.depth - 1;
        int i = j;
        if (j > paramb.i) {
            i = paramb.i;
        }
        if (i > 0) {
            this.dotsLayout.setVisibility(0);
            this.dotsView.setDotsCount(i);
            return;
        }
        this.dotsLayout.setVisibility(8);
    }

    public void a(boolean paramBoolean) {
        this.d = paramBoolean;
        Drawable localDrawable = this.commentLayout.getBackground();
        if (paramBoolean) {
        }
        for (int i = 2; ; i = 0) {
            localDrawable.setLevel(i);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/AnswersCommentViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */