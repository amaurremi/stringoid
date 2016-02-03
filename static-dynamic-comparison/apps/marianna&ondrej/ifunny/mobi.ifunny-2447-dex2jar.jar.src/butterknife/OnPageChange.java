package butterknife;

import butterknife.internal.ListenerClass;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks = OnPageChange.Callback.class, setter = "setOnPageChangeListener", targetType = "android.support.v4.view.ViewPager", type = "android.support.v4.view.ViewPager.OnPageChangeListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnPageChange {
    OnPageChange.Callback callback() default OnPageChange.Callback.PAGE_SELECTED;

    int[] value();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/OnPageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */