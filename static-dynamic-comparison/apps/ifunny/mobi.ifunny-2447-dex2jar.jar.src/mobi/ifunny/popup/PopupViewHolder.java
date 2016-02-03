package mobi.ifunny.popup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PopupViewHolder {
    @InjectView(2131493195)
    public TextView counter;
    @InjectView(2131492972)
    public ImageView image;
    @InjectView(2131493101)
    public TextView text;

    public PopupViewHolder(View paramView) {
        ButterKnife.inject(this, paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/popup/PopupViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */