package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
public @interface kd {
    Class<? extends jg<?>> a() default jg.a.class;

    Class<? extends jg<?>> b() default jg.a.class;

    Class<? extends jl> c() default jl.a.class;

    Class<?> d() default kl.class;

    Class<?> e() default kl.class;

    Class<?> f() default kl.class;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */