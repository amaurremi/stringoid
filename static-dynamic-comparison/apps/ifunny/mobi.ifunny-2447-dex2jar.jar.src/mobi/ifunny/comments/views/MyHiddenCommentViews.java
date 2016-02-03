package mobi.ifunny.comments.views;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.rest.content.MyCommented.CommentedContent;
import mobi.ifunny.util.g;

public class MyHiddenCommentViews
        extends MyCommentViews {
    private static final g<String, Integer> g = new g();
    @InjectView(2131493143)
    public View hideReasonLayout;
    @InjectView(2131493144)
    public TextView reasonView;

    static {
        g.a(Integer.valueOf(2131689740));
        g.put("del_content", Integer.valueOf(2131689737));
        g.put("del_content_creator", Integer.valueOf(2131689734));
        g.put("del_for_abuses", Integer.valueOf(2131689733));
        g.put("del_root_comment", Integer.valueOf(2131689739));
        g.put("del_via_portal", Integer.valueOf(2131689735));
        g.put("del_by_spam_filter", Integer.valueOf(2131689738));
    }

    public MyHiddenCommentViews(MyCommented.CommentedContent paramCommentedContent, String paramString1, String paramString2, View paramView, d paramd, boolean paramBoolean) {
        super(paramCommentedContent, paramString1, paramString2, paramView, paramd, paramBoolean);
        ButterKnife.inject(this, paramView);
    }

    public void a(Context paramContext, b paramb) {
        super.a(paramContext, paramb);
        a(paramb, paramContext.getString(((Integer) g.get(((MyCommented.CommentedContent) this.b).deletion_reason)).intValue()));
        if (((MyCommented.CommentedContent) this.b).isAbused()) {
            this.c.setEnabled(false);
            this.commentLayout.setEnabled(false);
        }
    }

    public void a(b paramb, String paramString) {
        this.reasonView.setText(paramString);
    }

    public void b(Context paramContext, b paramb) {
        this.nicknameTextView.setText(this.a);
    }

    public String c() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/MyHiddenCommentViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */