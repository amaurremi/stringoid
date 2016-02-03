package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.TYPE})
public @interface JsonAutoDetect
{
  JsonAutoDetect.Visibility creatorVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility fieldVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility getterVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility isGetterVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility setterVisibility() default JsonAutoDetect.Visibility.DEFAULT;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/annotation/JsonAutoDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */