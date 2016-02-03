package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.deser.BeanDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.SettableAnyProperty;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.util.HashSet;

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
    throws IOException, JsonProcessingException
  {
    if (this._propertyBasedCreator != null) {
      paramJsonParser = _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    boolean bool1;
    Object localObject2;
    Object localObject1;
    int i;
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
      localObject2 = null;
      localObject1 = null;
      i = 0;
      if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
      {
        Object localObject3 = paramJsonParser.getCurrentName();
        Object localObject4 = this._beanProperties.find((String)localObject3);
        paramJsonParser.nextToken();
        if (localObject4 != null) {
          if (localObject2 != null)
          {
            ((SettableBeanProperty)localObject4).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
            j = i;
            localObject3 = localObject1;
          }
        }
        for (;;)
        {
          paramJsonParser.nextToken();
          localObject1 = localObject3;
          i = j;
          break;
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            j = this._beanProperties.size();
            localObject3 = new Object[j + j];
          }
          int k = i + 1;
          localObject3[i] = localObject4;
          j = k + 1;
          localObject3[k] = ((SettableBeanProperty)localObject4).deserialize(paramJsonParser, paramDeserializationContext);
          continue;
          if (("message".equals(localObject3)) && (bool1))
          {
            localObject4 = this._valueInstantiator.createFromString(paramJsonParser.getText());
            localObject3 = localObject1;
            j = i;
            localObject2 = localObject4;
            if (localObject1 != null)
            {
              j = 0;
              while (j < i)
              {
                ((SettableBeanProperty)localObject1[j]).set(localObject4, localObject1[(j + 1)]);
                j += 2;
              }
              localObject3 = null;
              j = i;
              localObject2 = localObject4;
            }
          }
          else if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject3)))
          {
            paramJsonParser.skipChildren();
            localObject3 = localObject1;
            j = i;
          }
          else if (this._anySetter != null)
          {
            this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject3);
            localObject3 = localObject1;
            j = i;
          }
          else
          {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject3);
            localObject3 = localObject1;
            j = i;
          }
        }
      }
      paramJsonParser = (JsonParser)localObject2;
    } while (localObject2 != null);
    if (bool1) {}
    for (paramDeserializationContext = this._valueInstantiator.createFromString(null);; paramDeserializationContext = this._valueInstantiator.createUsingDefault())
    {
      paramJsonParser = paramDeserializationContext;
      if (localObject1 == null) {
        break;
      }
      j = 0;
      for (;;)
      {
        paramJsonParser = paramDeserializationContext;
        if (j >= i) {
          break;
        }
        ((SettableBeanProperty)localObject1[j]).set(paramDeserializationContext, localObject1[(j + 1)]);
        j += 2;
      }
    }
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer()
  {
    if (getClass() != ThrowableDeserializer.class) {
      return this;
    }
    return new ThrowableDeserializer(this, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */