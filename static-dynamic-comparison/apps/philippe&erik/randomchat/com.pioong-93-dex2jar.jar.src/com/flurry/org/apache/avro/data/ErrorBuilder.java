package com.flurry.org.apache.avro.data;

public abstract interface ErrorBuilder<T>
  extends RecordBuilder<T>
{
  public abstract ErrorBuilder<T> clearCause();
  
  public abstract ErrorBuilder<T> clearValue();
  
  public abstract Throwable getCause();
  
  public abstract Object getValue();
  
  public abstract boolean hasCause();
  
  public abstract boolean hasValue();
  
  public abstract ErrorBuilder<T> setCause(Throwable paramThrowable);
  
  public abstract ErrorBuilder<T> setValue(Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/data/ErrorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */