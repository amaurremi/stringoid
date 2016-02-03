package mobi.ifunny.support;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class a {
    private static final Integer a = Integer.valueOf(300);

    public static Animation a() {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        localTranslateAnimation.setDuration(a.intValue());
        localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
        return localTranslateAnimation;
    }

    public static Animation b() {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
        localTranslateAnimation.setDuration(a.intValue());
        localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
        return localTranslateAnimation;
    }

    public static Animation c() {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, -1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        localTranslateAnimation.setDuration(a.intValue());
        localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
        return localTranslateAnimation;
    }

    public static Animation d() {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
        localTranslateAnimation.setDuration(a.intValue());
        localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
        return localTranslateAnimation;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/support/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */