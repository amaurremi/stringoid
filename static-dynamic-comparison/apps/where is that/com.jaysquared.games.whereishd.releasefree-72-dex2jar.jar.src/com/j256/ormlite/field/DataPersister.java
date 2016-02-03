package com.j256.ormlite.field;

import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract interface DataPersister
  extends FieldConverter
{
  public abstract Object convertIdNumber(Number paramNumber);
  
  public abstract boolean dataIsEqual(Object paramObject1, Object paramObject2);
  
  public abstract Object generateId();
  
  public abstract String[] getAssociatedClassNames();
  
  public abstract Class<?>[] getAssociatedClasses();
  
  public abstract int getDefaultWidth();
  
  public abstract Class<?> getPrimaryClass();
  
  public abstract boolean isAppropriateId();
  
  public abstract boolean isArgumentHolderRequired();
  
  public abstract boolean isComparable();
  
  public abstract boolean isEscapedDefaultValue();
  
  public abstract boolean isEscapedValue();
  
  public abstract boolean isPrimitive();
  
  public abstract boolean isSelfGeneratedId();
  
  public abstract boolean isValidForField(Field paramField);
  
  public abstract boolean isValidForVersion();
  
  public abstract boolean isValidGeneratedType();
  
  public abstract Object makeConfigObject(FieldType paramFieldType)
    throws SQLException;
  
  public abstract Object moveToNextValue(Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/DataPersister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */