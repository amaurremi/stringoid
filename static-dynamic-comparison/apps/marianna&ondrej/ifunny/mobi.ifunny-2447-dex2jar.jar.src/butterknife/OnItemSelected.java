package butterknife;

import butterknife.internal.ListenerClass;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks = OnItemSelected.Callback.class, setter = "setOnItemSelectedListener", targetType = "android.widget.AdapterView<?>", type = "android.widget.AdapterView.OnItemSelectedListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnItemSelected {
    OnItemSelected.Callback callback() default OnItemSelected.Callback.ITEM_SELECTED;

    int[] value();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/OnItemSelected.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */