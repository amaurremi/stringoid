package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
public @interface JsonSerialize
{
  Class<?> as() default NoClass.class;
  
  Class<?> contentAs() default NoClass.class;
  
  Class<? extends JsonSerializer<?>> contentUsing() default JsonSerializer.None.class;
  
  @Deprecated
  JsonSerialize.Inclusion include() default JsonSerialize.Inclusion.ALWAYS;
  
  Class<?> keyAs() default NoClass.class;
  
  Class<? extends JsonSerializer<?>> keyUsing() default JsonSerializer.None.class;
  
  JsonSerialize.Typing typing() default JsonSerialize.Typing.DYNAMIC;
  
  Class<? extends JsonSerializer<?>> using() default JsonSerializer.None.class;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/annotation/JsonSerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */