package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import java.lang.reflect.Constructor;

public abstract class AbstractErrorUnmarshaller<T>
  implements Unmarshaller<AmazonServiceException, T>
{
  protected final Class<? extends AmazonServiceException> exceptionClass;
  
  public AbstractErrorUnmarshaller()
  {
    this(AmazonServiceException.class);
  }
  
  public AbstractErrorUnmarshaller(Class<? extends AmazonServiceException> paramClass)
  {
    this.exceptionClass = paramClass;
  }
  
  protected AmazonServiceException newException(String paramString)
  {
    return (AmazonServiceException)this.exceptionClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/transform/AbstractErrorUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */