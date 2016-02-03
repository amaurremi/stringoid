package butterknife.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface ListenerClass {
    Class<? extends Enum<?>> callbacks() default ListenerClass.NONE.class;

    int genericArguments() default 0;

    ListenerMethod[] method() default {};

    String setter();

    String targetType();

    String type();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/ListenerClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */