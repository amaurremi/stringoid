package org.codehaus.jackson.map.ser;

public abstract class FilteredBeanPropertyWriter
{
  public static BeanPropertyWriter constructViewBased(BeanPropertyWriter paramBeanPropertyWriter, Class[] paramArrayOfClass)
  {
    if (paramArrayOfClass.length == 1) {
      return new FilteredBeanPropertyWriter.SingleView(paramBeanPropertyWriter, paramArrayOfClass[0]);
    }
    return new FilteredBeanPropertyWriter.MultiView(paramBeanPropertyWriter, paramArrayOfClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/FilteredBeanPropertyWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */