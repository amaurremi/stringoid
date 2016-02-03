package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
public @interface kg {
    Class<? extends jk<?>> a() default jk.a.class;

    Class<? extends jk<?>> b() default jk.a.class;

    Class<? extends jk<?>> c() default jk.a.class;

    Class<?> d() default kl.class;

    Class<?> e() default kl.class;

    Class<?> f() default kl.class;

    b g() default b.DYNAMIC;

    a h() default a.ALWAYS;

    public static enum a {
        private a() {
        }
    }

    public static enum b {
        private b() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */