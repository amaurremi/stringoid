package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
public @interface sb
{
  Class<? extends qu<?>> a() default qv.class;
  
  Class<? extends qu<?>> b() default qv.class;
  
  Class<? extends rc> c() default rd.class;
  
  Class<?> d() default sl.class;
  
  Class<?> e() default sl.class;
  
  Class<?> f() default sl.class;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */