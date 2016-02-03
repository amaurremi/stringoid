package org.codehaus.jackson.map.deser.std;

import java.util.HashSet;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.deser.BeanDeserializer;
import org.codehaus.jackson.map.deser.SettableAnyProperty;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import org.codehaus.jackson.type.JavaType;

public class ThrowableDeserializer
  extends BeanDeserializer
{
  protected static final String PROP_NAME_MESSAGE = "message";
  
  public ThrowableDeserializer(BeanDeserializer paramBeanDeserializer)
  {
    super(paramBeanDeserializer);
  }
  
  protected ThrowableDeserializer(BeanDeserializer paramBeanDeserializer, boolean paramBoolean)
  {
    super(paramBeanDeserializer, paramBoolean);
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    int k = 0;
    if (this._propertyBasedCreator != null) {
      paramJsonParser = _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    boolean bool1;
    int i;
    Object localObject2;
    Object localObject1;
    int j;
    do
    {
      return paramJsonParser;
      if (this._delegateDeserializer != null) {
        return this._valueInstantiator.createUsingDelegate(this._delegateDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
      }
      if (this._beanType.isAbstract()) {
        throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
      }
      bool1 = this._valueInstantiator.canCreateFromString();
      boolean bool2 = this._valueInstantiator.canCreateUsingDefault();
      if ((!bool1) && (!bool2)) {
        throw new JsonMappingException("Can not deserialize Throwable of type " + this._beanType + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
      }
      i = 0;
      localObject2 = null;
      localObject1 = null;
      if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
      {
        Object localObject3 = paramJsonParser.getCurrentName();
        SettableBeanProperty localSettableBeanProperty = this._beanProperties.find((String)localObject3);
        paramJsonParser.nextToken();
        if (localSettableBeanProperty != null) {
          if (localObject1 != null)
          {
            localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject1);
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          paramJsonParser.nextToken();
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            j = this._beanProperties.size();
            localObject3 = new Object[j + j];
          }
          j = i + 1;
          localObject3[i] = localSettableBeanProperty;
          i = j + 1;
          localObject3[j] = localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext);
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          if (("message".equals(localObject3)) && (bool1))
          {
            localObject3 = this._valueInstantiator.createFromString(paramJsonParser.getText());
            localObject1 = localObject3;
            if (localObject2 != null)
            {
              j = 0;
              while (j < i)
              {
                ((SettableBeanProperty)localObject2[j]).set(localObject3, localObject2[(j + 1)]);
                j += 2;
              }
              localObject2 = localObject3;
              localObject1 = null;
            }
          }
          else
          {
            if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject3)))
            {
              paramJsonParser.skipChildren();
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            if (this._anySetter != null)
            {
              this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject1, (String)localObject3);
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject1, (String)localObject3);
          }
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      paramJsonParser = (JsonParser)localObject1;
    } while (localObject1 != null);
    if (bool1) {}
    for (paramDeserializationContext = this._valueInstantiator.createFromString(null);; paramDeserializationContext = this._valueInstantiator.createUsingDefault())
    {
      paramJsonParser = paramDeserializationContext;
      if (localObject2 == null) {
        break;
      }
      j = k;
      for (;;)
      {
        paramJsonParser = paramDeserializationContext;
        if (j >= i) {
          break;
        }
        ((SettableBeanProperty)localObject2[j]).set(paramDeserializationContext, localObject2[(j + 1)]);
        j += 2;
      }
    }
  }
  
  public JsonDeserializer unwrappingDeserializer()
  {
    if (getClass() != ThrowableDeserializer.class) {
      return this;
    }
    return new ThrowableDeserializer(this, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */