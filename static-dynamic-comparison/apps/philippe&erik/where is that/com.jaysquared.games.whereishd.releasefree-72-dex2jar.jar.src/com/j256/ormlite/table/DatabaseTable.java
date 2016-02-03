package com.j256.ormlite.table;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface DatabaseTable
{
  Class<?> daoClass() default Void.class;
  
  String tableName() default "";
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/table/DatabaseTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */