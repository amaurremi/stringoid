package mobi.ifunny.mynews;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class MyNewsAdapter$ViewHolder$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, MyNewsAdapter.ViewHolder paramViewHolder, Object paramObject) {
        paramViewHolder.userImage = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493183, "field 'userImage'"));
        paramViewHolder.userImageBackground = paramFinder.findRequiredView(paramObject, 2131493182, "field 'userImageBackground'");
        paramViewHolder.userImageLayout = paramFinder.findRequiredView(paramObject, 2131493181, "field 'userImageLayout'");
        paramViewHolder.text = ((TextView) paramFinder.findRequiredView(paramObject, 2131493185, "field 'text'"));
        paramViewHolder.others = ((TextView) paramFinder.findRequiredView(paramObject, 2131493186, "field 'others'"));
        paramViewHolder.hint = ((TextView) paramFinder.findRequiredView(paramObject, 2131493188, "field 'hint'"));
        paramViewHolder.eventIcon = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493187, "field 'eventIcon'"));
        paramViewHolder.thumbLayout = paramFinder.findRequiredView(paramObject, 2131493142, "field 'thumbLayout'");
        paramViewHolder.myNewsDivider = paramFinder.findRequiredView(paramObject, 2131493189, "field 'myNewsDivider'");
    }

    public static void reset(MyNewsAdapter.ViewHolder paramViewHolder) {
        paramViewHolder.userImage = null;
        paramViewHolder.userImageBackground = null;
        paramViewHolder.userImageLayout = null;
        paramViewHolder.text = null;
        paramViewHolder.others = null;
        paramViewHolder.hint = null;
        paramViewHolder.eventIcon = null;
        paramViewHolder.thumbLayout = null;
        paramViewHolder.myNewsDivider = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/mynews/MyNewsAdapter$ViewHolder$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */