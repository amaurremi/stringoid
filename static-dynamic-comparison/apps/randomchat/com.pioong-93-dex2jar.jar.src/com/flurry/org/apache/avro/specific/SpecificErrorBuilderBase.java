package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.data.ErrorBuilder;
import com.flurry.org.apache.avro.data.RecordBuilderBase;
import java.lang.reflect.Constructor;

public abstract class SpecificErrorBuilderBase<T extends SpecificExceptionBase>
  extends RecordBuilderBase<T>
  implements ErrorBuilder<T>
{
  private Throwable cause;
  private Constructor<T> errorConstructor;
  private boolean hasCause;
  private boolean hasValue;
  private Object value;
  
  protected SpecificErrorBuilderBase(Schema paramSchema)
  {
    super(paramSchema, SpecificData.get());
  }
  
  protected SpecificErrorBuilderBase(SpecificErrorBuilderBase<T> paramSpecificErrorBuilderBase)
  {
    super(paramSpecificErrorBuilderBase, SpecificData.get());
    this.errorConstructor = paramSpecificErrorBuilderBase.errorConstructor;
    this.value = paramSpecificErrorBuilderBase.value;
    this.hasValue = paramSpecificErrorBuilderBase.hasValue;
    this.cause = paramSpecificErrorBuilderBase.cause;
    this.hasCause = paramSpecificErrorBuilderBase.hasCause;
  }
  
  protected SpecificErrorBuilderBase(T paramT)
  {
    super(paramT.getSchema(), SpecificData.get());
    Object localObject = paramT.getValue();
    if (localObject != null) {
      setValue(localObject);
    }
    paramT = paramT.getCause();
    if (paramT != null) {
      setCause(paramT);
    }
  }
  
  public SpecificErrorBuilderBase<T> clearCause()
  {
    this.cause = null;
    this.hasCause = false;
    return this;
  }
  
  public SpecificErrorBuilderBase<T> clearValue()
  {
    this.value = null;
    this.hasValue = false;
    return this;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public boolean hasCause()
  {
    return this.hasCause;
  }
  
  public boolean hasValue()
  {
    return this.hasValue;
  }
  
  public SpecificErrorBuilderBase<T> setCause(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
    this.hasCause = true;
    return this;
  }
  
  public SpecificErrorBuilderBase<T> setValue(Object paramObject)
  {
    this.value = paramObject;
    this.hasValue = true;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/specific/SpecificErrorBuilderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */