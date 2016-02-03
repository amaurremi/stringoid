package mobi.ifunny.comments.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.rest.content.Comment;

public class SmilyCommentViews<C extends Comment>
        extends CommentViews<C> {
    public boolean f;
    @InjectView(2131493006)
    public ImageView smileDown;
    @InjectView(2131493005)
    public ImageView smileUp;
    @InjectView(2131493004)
    public TextView smilesCountView;
    @InjectView(2131493003)
    public View smilesLayout;

    public SmilyCommentViews(C paramC, View paramView, a<C> parama, boolean paramBoolean) {
        super(paramC, paramView, parama);
        ButterKnife.inject(this, paramView);
        this.f = paramBoolean;
        this.smileUp.getDrawable().mutate();
        this.smileDown.getDrawable().mutate();
    }

    public void a(Context paramContext, b paramb) {
        super.a(paramContext, paramb);
        b(paramb);
        c(paramb);
    }

    protected boolean a(View paramView) {
        if (!super.a(paramView)) {
        }
        switch (paramView.getId()) {
            default:
                return false;
            case 2131493005:
                e().e(this.b, paramView);
                return true;
        }
        e().f(this.b, paramView);
        return true;
    }

    public void b() {
        super.b();
        this.smileDown.setOnClickListener(this);
        this.smileUp.setOnClickListener(this);
    }

    public void b(b paramb) {
        if (this.b.isTop()) {
            this.dateTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramb.a(), null);
            return;
        }
        this.dateTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    public void c(b paramb) {
        this.smilesLayout.setVisibility(0);
        int i;
        int j;
        boolean bool1;
        boolean bool2;
        if ((!this.f) && (paramb.a != 0) && (System.currentTimeMillis() - this.b.getDateInMillis() < paramb.a)) {
            i = 1;
            j = this.b.num_smiles;
            bool1 = this.b.is_smiled;
            int k = this.b.num_unsmiles;
            bool2 = this.b.is_unsmiled;
            j -= k;
            if (i == 0) {
                break label269;
            }
            if (j > 0) {
                break label181;
            }
            if (!bool1) {
                break label169;
            }
            this.smilesCountView.setVisibility(0);
            this.smilesCountView.setText("1");
            this.smilesCountView.setTextColor(paramb.b);
            label125:
            paramb = this.smileUp.getDrawable();
            if (!bool1) {
                break label392;
            }
            paramb.setLevel(1);
        }
        for (; ; ) {
            paramb = this.smileDown.getDrawable();
            if (!bool2) {
                break label401;
            }
            paramb.setLevel(1);
            return;
            i = 0;
            break;
            label169:
            this.smilesCountView.setVisibility(8);
            break label125;
            label181:
            if (bool1) {
                this.smilesCountView.setVisibility(0);
                this.smilesCountView.setText(Integer.toString(j));
                this.smilesCountView.setTextColor(paramb.b);
                break label125;
            }
            if (bool2) {
                this.smilesCountView.setVisibility(0);
                this.smilesCountView.setText(Integer.toString(j));
                this.smilesCountView.setTextColor(paramb.d);
                break label125;
            }
            this.smilesCountView.setVisibility(8);
            break label125;
            label269:
            if (j <= 0) {
                if (bool1) {
                    this.smilesCountView.setVisibility(0);
                    this.smilesCountView.setText("1");
                    this.smilesCountView.setTextColor(paramb.b);
                    break label125;
                }
                this.smilesCountView.setVisibility(8);
                break label125;
            }
            this.smilesCountView.setVisibility(0);
            this.smilesCountView.setText(Integer.toString(j));
            if (bool1) {
                this.smilesCountView.setTextColor(paramb.b);
                break label125;
            }
            if (bool2) {
                this.smilesCountView.setTextColor(paramb.d);
                break label125;
            }
            this.smilesCountView.setTextColor(paramb.c);
            break label125;
            label392:
            paramb.setLevel(0);
        }
        label401:
        paramb.setLevel(0);
    }

    public e<C> e() {
        return (e) super.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/SmilyCommentViews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */