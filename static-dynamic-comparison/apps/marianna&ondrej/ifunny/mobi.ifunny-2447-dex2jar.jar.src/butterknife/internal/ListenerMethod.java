package butterknife.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ListenerMethod {
    String defaultReturn() default "null";

    String name();

    String[] parameters() default {};

    String returnType() default "void";
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/internal/ListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */