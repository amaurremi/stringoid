package mobi.ifunny.comments.views;

import butterknife.ButterKnife.Finder;

public class MyCommentViews$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, MyCommentViews paramMyCommentViews, Object paramObject) {
        SmilyCommentViews..ViewInjector.inject(paramFinder, paramMyCommentViews, paramObject);
        paramMyCommentViews.thumbLayout = paramFinder.findRequiredView(paramObject, 2131493142, "field 'thumbLayout'");
    }

    public static void reset(MyCommentViews paramMyCommentViews) {
        SmilyCommentViews..ViewInjector.reset(paramMyCommentViews);
        paramMyCommentViews.thumbLayout = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/MyCommentViews$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */