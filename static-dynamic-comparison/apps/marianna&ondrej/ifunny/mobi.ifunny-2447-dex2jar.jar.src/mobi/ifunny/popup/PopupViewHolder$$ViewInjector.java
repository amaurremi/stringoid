package mobi.ifunny.popup;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class PopupViewHolder$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, PopupViewHolder paramPopupViewHolder, Object paramObject) {
        paramPopupViewHolder.image = ((ImageView) paramFinder.findRequiredView(paramObject, 2131492972, "field 'image'"));
        paramPopupViewHolder.text = ((TextView) paramFinder.findRequiredView(paramObject, 2131493101, "field 'text'"));
        paramPopupViewHolder.counter = ((TextView) paramFinder.findRequiredView(paramObject, 2131493195, "field 'counter'"));
    }

    public static void reset(PopupViewHolder paramPopupViewHolder) {
        paramPopupViewHolder.image = null;
        paramPopupViewHolder.text = null;
        paramPopupViewHolder.counter = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/popup/PopupViewHolder$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */