package mobi.ifunny.userlists;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class UserListAdapter$ViewHolder$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, UserListAdapter.ViewHolder paramViewHolder, Object paramObject) {
        paramViewHolder.avatarView = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493357, "field 'avatarView'"));
        paramViewHolder.avatarViewBackground = paramFinder.findRequiredView(paramObject, 2131493356, "field 'avatarViewBackground'");
        paramViewHolder.avatarViewLayout = paramFinder.findRequiredView(paramObject, 2131493355, "field 'avatarViewLayout'");
        paramViewHolder.nickView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493358, "field 'nickView'"));
        paramViewHolder.nickIsVerifiedView = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493359, "field 'nickIsVerifiedView'"));
        paramViewHolder.numView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493360, "field 'numView'"));
        paramViewHolder.subscribeBtn = paramFinder.findRequiredView(paramObject, 2131493361, "field 'subscribeBtn'");
        paramViewHolder.unsubscribeBtn = paramFinder.findRequiredView(paramObject, 2131493362, "field 'unsubscribeBtn'");
        paramViewHolder.worksGrid = ((GridView) paramFinder.findRequiredView(paramObject, 2131493363, "field 'worksGrid'"));
    }

    public static void reset(UserListAdapter.ViewHolder paramViewHolder) {
        paramViewHolder.avatarView = null;
        paramViewHolder.avatarViewBackground = null;
        paramViewHolder.avatarViewLayout = null;
        paramViewHolder.nickView = null;
        paramViewHolder.nickIsVerifiedView = null;
        paramViewHolder.numView = null;
        paramViewHolder.subscribeBtn = null;
        paramViewHolder.unsubscribeBtn = null;
        paramViewHolder.worksGrid = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/UserListAdapter$ViewHolder$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */