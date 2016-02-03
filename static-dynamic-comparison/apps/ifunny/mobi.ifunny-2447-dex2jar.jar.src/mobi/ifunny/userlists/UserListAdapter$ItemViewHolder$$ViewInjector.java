package mobi.ifunny.userlists;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class UserListAdapter$ItemViewHolder$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, UserListAdapter.ItemViewHolder paramItemViewHolder, Object paramObject) {
        paramItemViewHolder.textView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493352, "field 'textView'"));
    }

    public static void reset(UserListAdapter.ItemViewHolder paramItemViewHolder) {
        paramItemViewHolder.textView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/UserListAdapter$ItemViewHolder$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */