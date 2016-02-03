package org.codehaus.jackson.map;

public abstract interface ContextualDeserializer
{
  public abstract JsonDeserializer createContextual(DeserializationConfig paramDeserializationConfig, BeanProperty paramBeanProperty);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ContextualDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */