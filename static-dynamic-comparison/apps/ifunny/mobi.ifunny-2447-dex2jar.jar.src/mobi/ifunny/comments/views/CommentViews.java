package mobi.ifunny.comments.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import butterknife.InjectView;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.util.r;
import mobi.ifunny.view.ImageViewEx;

public abstract class CommentViews<C extends Comment>
        implements View.OnClickListener, View.OnLongClickListener {
    private final a<C> a;
    public C b;
    public View c;
    @InjectView(2131492993)
    public View commentLayout;
    @InjectView(2131493007)
    public TextView commentTextView;
    @InjectView(2131493002)
    public TextView dateTextView;
    @InjectView(2131492999)
    public ImageViewEx imageView;
    @InjectView(2131492998)
    public View imageViewBackground;
    @InjectView(2131492997)
    public View imageViewLayout;
    @InjectView(2131493001)
    public TextView nicknameTextView;
    @InjectView(2131493000)
    public View titleLayout;

    public CommentViews(C paramC, View paramView, a<C> parama) {
        this.b = paramC;
        this.c = paramView;
        this.a = parama;
    }

    public a<C> a() {
        return this.a;
    }

    public void a(Context paramContext, b paramb) {
        b(paramContext, paramb);
        c(paramContext, paramb);
        d(paramContext, paramb);
        b();
    }

    protected boolean a(View paramView) {
        if (!this.a.a(this.b, paramView)) {
        }
        switch (paramView.getId()) {
            default:
                return false;
            case 2131492997:
            case 2131493000:
                this.a.c(this.b, paramView);
                return true;
        }
        this.a.b(this.b, paramView);
        return true;
    }

    public void b() {
        this.titleLayout.setOnClickListener(this);
        this.commentLayout.setOnClickListener(this);
        this.commentLayout.setOnLongClickListener(this);
        if ((this.b.user != null) && (!this.b.user.is_banned)) {
            this.imageViewLayout.setOnClickListener(this);
            return;
        }
        this.imageViewLayout.setOnClickListener(null);
    }

    public void b(Context paramContext, b paramb) {
        paramb = this.nicknameTextView;
        if (this.b.user == null) {
        }
        for (paramContext = paramContext.getString(2131689661); ; paramContext = this.b.user.nick) {
            paramb.setText(paramContext);
            return;
        }
    }

    public String c() {
        if ((this.b.user == null) || (this.b.user.is_banned)) {
            return null;
        }
        return this.b.user.getPhotoThumbSmallUrl();
    }

    public void c(Context paramContext, b paramb) {
        paramContext = r.b(this.b.getDateInMillis(), paramContext);
        this.dateTextView.setText(paramContext);
    }

    public void d(Context paramContext, b paramb) {
        this.commentTextView.setText(this.b.text);
    }

    public final void onClick(View paramView) {
        a(paramView);
    }

    public boolean onLongClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return false;
        }
        return this.a.d(this.b, paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/CommentViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */