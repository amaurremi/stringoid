package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface si
{
  Class<? extends yj<?>> a();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/si.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */