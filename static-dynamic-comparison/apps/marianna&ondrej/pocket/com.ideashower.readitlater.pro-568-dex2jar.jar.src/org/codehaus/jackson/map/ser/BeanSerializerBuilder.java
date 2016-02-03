package org.codehaus.jackson.map.ser;

import java.util.List;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;

public class BeanSerializerBuilder
{
  private static final BeanPropertyWriter[] NO_PROPERTIES = new BeanPropertyWriter[0];
  protected AnyGetterWriter _anyGetter;
  protected final BasicBeanDescription _beanDesc;
  protected Object _filterId;
  protected BeanPropertyWriter[] _filteredProperties;
  protected List _properties;
  
  public BeanSerializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    this._beanDesc = paramBasicBeanDescription;
  }
  
  protected BeanSerializerBuilder(BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    this._beanDesc = paramBeanSerializerBuilder._beanDesc;
    this._properties = paramBeanSerializerBuilder._properties;
    this._filteredProperties = paramBeanSerializerBuilder._filteredProperties;
    this._anyGetter = paramBeanSerializerBuilder._anyGetter;
    this._filterId = paramBeanSerializerBuilder._filterId;
  }
  
  public JsonSerializer build()
  {
    if ((this._properties == null) || (this._properties.isEmpty())) {
      if (this._anyGetter == null) {
        return null;
      }
    }
    for (BeanPropertyWriter[] arrayOfBeanPropertyWriter = NO_PROPERTIES;; arrayOfBeanPropertyWriter = (BeanPropertyWriter[])this._properties.toArray(new BeanPropertyWriter[this._properties.size()])) {
      return new BeanSerializer(this._beanDesc.getType(), arrayOfBeanPropertyWriter, this._filteredProperties, this._anyGetter, this._filterId);
    }
  }
  
  public BeanSerializer createDummy()
  {
    return BeanSerializer.createDummy(this._beanDesc.getBeanClass());
  }
  
  public BasicBeanDescription getBeanDescription()
  {
    return this._beanDesc;
  }
  
  public BeanPropertyWriter[] getFilteredProperties()
  {
    return this._filteredProperties;
  }
  
  public List getProperties()
  {
    return this._properties;
  }
  
  public boolean hasProperties()
  {
    return (this._properties != null) && (this._properties.size() > 0);
  }
  
  public void setAnyGetter(AnyGetterWriter paramAnyGetterWriter)
  {
    this._anyGetter = paramAnyGetterWriter;
  }
  
  public void setFilterId(Object paramObject)
  {
    this._filterId = paramObject;
  }
  
  public void setFilteredProperties(BeanPropertyWriter[] paramArrayOfBeanPropertyWriter)
  {
    this._filteredProperties = paramArrayOfBeanPropertyWriter;
  }
  
  public void setProperties(List paramList)
  {
    this._properties = paramList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/BeanSerializerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */