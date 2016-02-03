package mobi.ifunny.comments.views;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class SmilyCommentViews$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, SmilyCommentViews paramSmilyCommentViews, Object paramObject) {
        CommentViews..ViewInjector.inject(paramFinder, paramSmilyCommentViews, paramObject);
        paramSmilyCommentViews.smileUp = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493005, "field 'smileUp'"));
        paramSmilyCommentViews.smileDown = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493006, "field 'smileDown'"));
        paramSmilyCommentViews.smilesCountView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493004, "field 'smilesCountView'"));
        paramSmilyCommentViews.smilesLayout = paramFinder.findRequiredView(paramObject, 2131493003, "field 'smilesLayout'");
    }

    public static void reset(SmilyCommentViews paramSmilyCommentViews) {
        CommentViews..ViewInjector.reset(paramSmilyCommentViews);
        paramSmilyCommentViews.smileUp = null;
        paramSmilyCommentViews.smileDown = null;
        paramSmilyCommentViews.smilesCountView = null;
        paramSmilyCommentViews.smilesLayout = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/SmilyCommentViews$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */