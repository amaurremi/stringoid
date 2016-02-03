package dalvik.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Deprecated
public @interface TestTarget {
    String methodName() default "";

    String conceptName() default "";

    Class<?>[] methodArgs() default {};
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/dalvik/annotation/TestTarget.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */