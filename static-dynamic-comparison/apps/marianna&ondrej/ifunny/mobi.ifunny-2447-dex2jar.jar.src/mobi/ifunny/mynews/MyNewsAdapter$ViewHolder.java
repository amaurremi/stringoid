package mobi.ifunny.mynews;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.gallery.a.j;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.News;

final class MyNewsAdapter$ViewHolder {
    j a;
    News b;
    @InjectView(2131493187)
    ImageView eventIcon;
    @InjectView(2131493188)
    TextView hint;
    @InjectView(2131493189)
    View myNewsDivider;
    @InjectView(2131493186)
    TextView others;
    @InjectView(2131493185)
    TextView text;
    @InjectView(2131493142)
    View thumbLayout;
    @InjectView(2131493183)
    ImageView userImage;
    @InjectView(2131493182)
    View userImageBackground;
    @InjectView(2131493181)
    View userImageLayout;

    public MyNewsAdapter$ViewHolder(View paramView) {
        ButterKnife.inject(this, paramView);
        this.a = new j();
        this.a.a(this.thumbLayout);
    }

    public void a(int paramInt) {
        this.myNewsDivider.setVisibility(paramInt);
    }

    public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, CharSequence paramCharSequence3, IFunny paramIFunny) {
        this.text.setText(paramCharSequence1);
        if (TextUtils.isEmpty(paramCharSequence2)) {
            this.others.setVisibility(8);
            if (paramDrawable != null) {
                break label93;
            }
            this.eventIcon.setVisibility(8);
        }
        for (; ; ) {
            this.hint.setText(paramCharSequence3);
            this.a.e = paramIFunny;
            return;
            this.others.setVisibility(0);
            this.others.setText(" " + paramCharSequence2);
            break;
            label93:
            this.eventIcon.setVisibility(0);
            this.eventIcon.setImageDrawable(paramDrawable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/mynews/MyNewsAdapter$ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */