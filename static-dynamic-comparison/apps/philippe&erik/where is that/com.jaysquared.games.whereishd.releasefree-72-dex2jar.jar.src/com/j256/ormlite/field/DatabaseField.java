package com.j256.ormlite.field;

import com.j256.ormlite.field.types.VoidType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface DatabaseField
{
  public static final int DEFAULT_MAX_FOREIGN_AUTO_REFRESH_LEVEL = 2;
  public static final String DEFAULT_STRING = "__ormlite__ no default value string was specified";
  public static final int NO_MAX_FOREIGN_AUTO_REFRESH_LEVEL_SPECIFIED = -1;
  
  boolean allowGeneratedIdInsert() default false;
  
  boolean canBeNull() default true;
  
  String columnDefinition() default "";
  
  String columnName() default "";
  
  DataType dataType() default DataType.UNKNOWN;
  
  String defaultValue() default "__ormlite__ no default value string was specified";
  
  boolean foreign() default false;
  
  boolean foreignAutoCreate() default false;
  
  boolean foreignAutoRefresh() default false;
  
  String foreignColumnName() default "";
  
  String format() default "";
  
  boolean generatedId() default false;
  
  String generatedIdSequence() default "";
  
  boolean id() default false;
  
  boolean index() default false;
  
  String indexName() default "";
  
  int maxForeignAutoRefreshLevel() default -1;
  
  boolean persisted() default true;
  
  Class<? extends DataPersister> persisterClass() default VoidType.class;
  
  boolean readOnly() default false;
  
  boolean throwIfNull() default false;
  
  boolean unique() default false;
  
  boolean uniqueCombo() default false;
  
  boolean uniqueIndex() default false;
  
  String uniqueIndexName() default "";
  
  String unknownEnumName() default "";
  
  boolean useGetSet() default false;
  
  boolean version() default false;
  
  int width() default 0;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/DatabaseField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */