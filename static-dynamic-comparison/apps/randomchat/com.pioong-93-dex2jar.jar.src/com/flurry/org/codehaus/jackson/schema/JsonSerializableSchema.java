package com.flurry.org.codehaus.jackson.schema;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JsonSerializableSchema
{
  String schemaItemDefinition() default "##irrelevant";
  
  String schemaObjectPropertiesDefinition() default "##irrelevant";
  
  String schemaType() default "any";
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/schema/JsonSerializableSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */