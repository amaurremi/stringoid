package mobi.ifunny.comments.views;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.gallery.a.j;
import mobi.ifunny.rest.content.MyCommented.CommentedContent;

public class MyCommentViews
        extends SmilyCommentViews<MyCommented.CommentedContent> {
    protected String a;
    protected String d;
    public j e;
    @InjectView(2131493142)
    public View thumbLayout;

    public MyCommentViews(MyCommented.CommentedContent paramCommentedContent, String paramString1, String paramString2, View paramView, d paramd, boolean paramBoolean) {
        super(paramCommentedContent, paramView, paramd, paramBoolean);
        this.a = paramString1;
        this.d = paramString2;
        ButterKnife.inject(this, paramView);
        this.e = new j();
        this.e.e = paramCommentedContent.content;
        this.e.a(this.thumbLayout);
    }

    protected boolean a(View paramView) {
        if (!super.a(paramView)) {
        }
        switch (paramView.getId()) {
            default:
                return false;
        }
        d().a((MyCommented.CommentedContent) this.b, paramView);
        return true;
    }

    public void b() {
        super.b();
        this.imageViewLayout.setOnClickListener(this);
        this.thumbLayout.setOnClickListener(this);
    }

    public void b(Context paramContext, b paramb) {
        this.nicknameTextView.setText(this.a);
    }

    public String c() {
        return this.d;
    }

    public d d() {
        return (d) super.e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/MyCommentViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */