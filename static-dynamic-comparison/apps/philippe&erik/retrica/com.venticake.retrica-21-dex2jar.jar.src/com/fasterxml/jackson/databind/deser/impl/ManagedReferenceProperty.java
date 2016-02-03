package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ManagedReferenceProperty
  extends SettableBeanProperty
{
  protected final SettableBeanProperty _backProperty;
  protected final boolean _isContainer;
  protected final SettableBeanProperty _managedProperty;
  protected final String _referenceName;
  
  public ManagedReferenceProperty(SettableBeanProperty paramSettableBeanProperty1, String paramString, SettableBeanProperty paramSettableBeanProperty2, Annotations paramAnnotations, boolean paramBoolean)
  {
    super(paramSettableBeanProperty1.getName(), paramSettableBeanProperty1.getType(), paramSettableBeanProperty1.getValueTypeDeserializer(), paramAnnotations);
    this._referenceName = paramString;
    this._managedProperty = paramSettableBeanProperty1;
    this._backProperty = paramSettableBeanProperty2;
    this._isContainer = paramBoolean;
  }
  
  protected ManagedReferenceProperty(ManagedReferenceProperty paramManagedReferenceProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramManagedReferenceProperty, paramJsonDeserializer);
    this._referenceName = paramManagedReferenceProperty._referenceName;
    this._isContainer = paramManagedReferenceProperty._isContainer;
    this._managedProperty = paramManagedReferenceProperty._managedProperty;
    this._backProperty = paramManagedReferenceProperty._backProperty;
  }
  
  protected ManagedReferenceProperty(ManagedReferenceProperty paramManagedReferenceProperty, String paramString)
  {
    super(paramManagedReferenceProperty, paramString);
    this._referenceName = paramManagedReferenceProperty._referenceName;
    this._isContainer = paramManagedReferenceProperty._isContainer;
    this._managedProperty = paramManagedReferenceProperty._managedProperty;
    this._backProperty = paramManagedReferenceProperty._backProperty;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    set(paramObject, this._managedProperty.deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    return setAndReturn(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public AnnotatedMember getMember()
  {
    return this._managedProperty.getMember();
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    setAndReturn(paramObject1, paramObject2);
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = this._managedProperty.setAndReturn(paramObject1, paramObject2);
    if (paramObject2 != null)
    {
      if (this._isContainer)
      {
        Object localObject2;
        if ((paramObject2 instanceof Object[]))
        {
          paramObject2 = (Object[])paramObject2;
          int j = paramObject2.length;
          int i = 0;
          while (i < j)
          {
            localObject2 = paramObject2[i];
            if (localObject2 != null) {
              this._backProperty.set(localObject2, paramObject1);
            }
            i += 1;
          }
        }
        if ((paramObject2 instanceof Collection))
        {
          paramObject2 = ((Collection)paramObject2).iterator();
          while (((Iterator)paramObject2).hasNext())
          {
            localObject2 = ((Iterator)paramObject2).next();
            if (localObject2 != null) {
              this._backProperty.set(localObject2, paramObject1);
            }
          }
        }
        if ((paramObject2 instanceof Map))
        {
          paramObject2 = ((Map)paramObject2).values().iterator();
          while (((Iterator)paramObject2).hasNext())
          {
            localObject2 = ((Iterator)paramObject2).next();
            if (localObject2 != null) {
              this._backProperty.set(localObject2, paramObject1);
            }
          }
        }
        throw new IllegalStateException("Unsupported container type (" + paramObject2.getClass().getName() + ") when resolving reference '" + this._referenceName + "'");
      }
      this._backProperty.set(paramObject2, paramObject1);
    }
    return localObject1;
  }
  
  public ManagedReferenceProperty withName(String paramString)
  {
    return new ManagedReferenceProperty(this, paramString);
  }
  
  public ManagedReferenceProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new ManagedReferenceProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/ManagedReferenceProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */