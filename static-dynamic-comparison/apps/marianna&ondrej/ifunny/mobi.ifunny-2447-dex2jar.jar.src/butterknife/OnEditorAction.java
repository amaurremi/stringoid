package butterknife;

import butterknife.internal.ListenerClass;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method = {@butterknife.internal.ListenerMethod(defaultReturn = "false", name = "onEditorAction", parameters = {"android.widget.TextView", "int", "android.view.KeyEvent"}, returnType = "boolean")}, setter = "setOnEditorActionListener", targetType = "android.widget.TextView", type = "android.widget.TextView.OnEditorActionListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnEditorAction {
    int[] value();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/OnEditorAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */