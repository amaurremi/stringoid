package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public abstract class DateTimeSerializerBase<T>
  extends StdScalarSerializer<T>
  implements ContextualSerializer
{
  protected final DateFormat _customFormat;
  protected final boolean _useTimestamp;
  
  protected DateTimeSerializerBase(Class<T> paramClass, boolean paramBoolean, DateFormat paramDateFormat)
  {
    super(paramClass);
    this._useTimestamp = paramBoolean;
    this._customFormat = paramDateFormat;
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    Object localObject = this;
    if (paramBeanProperty != null)
    {
      paramBeanProperty = paramSerializerProvider.getAnnotationIntrospector().findFormat(paramBeanProperty.getMember());
      localObject = this;
      if (paramBeanProperty != null)
      {
        if (!paramBeanProperty.getShape().isNumeric()) {
          break label45;
        }
        localObject = withFormat(true, null);
      }
    }
    return (JsonSerializer<?>)localObject;
    label45:
    TimeZone localTimeZone = paramBeanProperty.getTimeZone();
    String str = paramBeanProperty.getPattern();
    if (str.length() > 0)
    {
      localObject = paramBeanProperty.getLocale();
      paramBeanProperty = (BeanProperty)localObject;
      if (localObject == null) {
        paramBeanProperty = paramSerializerProvider.getLocale();
      }
      paramBeanProperty = new SimpleDateFormat(str, paramBeanProperty);
      if (localTimeZone != null) {
        break label168;
      }
    }
    label168:
    for (paramSerializerProvider = paramSerializerProvider.getTimeZone();; paramSerializerProvider = localTimeZone)
    {
      paramBeanProperty.setTimeZone(paramSerializerProvider);
      return withFormat(false, paramBeanProperty);
      localObject = this;
      if (localTimeZone == null) {
        break;
      }
      paramSerializerProvider = paramSerializerProvider.getConfig().getDateFormat();
      if (paramSerializerProvider.getClass() == StdDateFormat.class) {
        paramSerializerProvider = StdDateFormat.getISO8601Format(localTimeZone);
      }
      for (;;)
      {
        return withFormat(false, paramSerializerProvider);
        paramSerializerProvider = (DateFormat)paramSerializerProvider.clone();
        paramSerializerProvider.setTimeZone(localTimeZone);
      }
    }
  }
  
  public abstract DateTimeSerializerBase<T> withFormat(boolean paramBoolean, DateFormat paramDateFormat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/DateTimeSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */