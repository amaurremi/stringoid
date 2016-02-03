package org.codehaus.jackson.annotate;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@JacksonAnnotation
public @interface JsonAutoDetect
{
  JsonAutoDetect.Visibility creatorVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility fieldVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility getterVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility isGetterVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonAutoDetect.Visibility setterVisibility() default JsonAutoDetect.Visibility.DEFAULT;
  
  JsonMethod[] value() default {JsonMethod.ALL};
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/annotate/JsonAutoDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */