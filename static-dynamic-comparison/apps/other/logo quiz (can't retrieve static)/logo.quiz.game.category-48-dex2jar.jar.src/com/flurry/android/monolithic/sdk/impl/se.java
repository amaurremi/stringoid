package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
public @interface se
{
  Class<? extends ra<?>> a() default rb.class;
  
  Class<? extends ra<?>> b() default rb.class;
  
  Class<? extends ra<?>> c() default rb.class;
  
  Class<?> d() default sl.class;
  
  Class<?> e() default sl.class;
  
  Class<?> f() default sl.class;
  
  sg g() default sg.DYNAMIC;
  
  sf h() default sf.ALWAYS;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/se.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */