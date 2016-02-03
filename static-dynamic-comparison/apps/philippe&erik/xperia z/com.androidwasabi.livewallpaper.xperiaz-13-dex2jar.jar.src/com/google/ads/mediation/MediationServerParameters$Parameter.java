package com.google.ads.mediation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface MediationServerParameters$Parameter
{
  String name();
  
  boolean required() default true;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/mediation/MediationServerParameters$Parameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */