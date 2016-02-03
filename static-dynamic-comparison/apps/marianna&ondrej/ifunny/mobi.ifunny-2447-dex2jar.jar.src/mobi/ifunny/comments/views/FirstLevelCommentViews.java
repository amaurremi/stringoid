package mobi.ifunny.comments.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.rest.content.Comment;

public class FirstLevelCommentViews
        extends SmilyCommentViews<Comment> {
    @InjectView(2131493069)
    public TextView repliesTextView;

    public FirstLevelCommentViews(Comment paramComment, View paramView, c paramc, boolean paramBoolean) {
        super(paramComment, paramView, paramc, paramBoolean);
        ButterKnife.inject(this, paramView);
    }

    protected boolean a(View paramView) {
        if (!super.a(paramView)) {
        }
        switch (paramView.getId()) {
            default:
                return false;
        }
        d().g(this.b, paramView);
        return true;
    }

    public void b() {
        super.b();
        this.repliesTextView.setOnClickListener(this);
    }

    public c d() {
        return (c) super.e();
    }

    public void d(Context paramContext, b paramb) {
        super.d(paramContext, paramb);
        if (this.b.num_replies > 0) {
            this.repliesTextView.setText(String.format(paramContext.getResources().getQuantityString(2131623936, this.b.num_replies), new Object[]{Integer.valueOf(this.b.num_replies)}));
            this.commentLayout.setPadding(this.commentLayout.getPaddingLeft(), this.commentLayout.getPaddingTop(), this.commentLayout.getPaddingRight(), 0);
            this.repliesTextView.setVisibility(0);
            return;
        }
        int i = paramContext.getResources().getDimensionPixelSize(2131427391);
        this.commentLayout.setPadding(this.commentLayout.getPaddingLeft(), this.commentLayout.getPaddingTop(), this.commentLayout.getPaddingRight(), i);
        this.repliesTextView.setVisibility(8);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/FirstLevelCommentViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */