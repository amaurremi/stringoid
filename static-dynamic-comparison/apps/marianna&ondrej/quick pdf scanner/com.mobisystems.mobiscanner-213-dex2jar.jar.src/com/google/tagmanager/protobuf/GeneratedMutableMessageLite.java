package com.google.tagmanager.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class GeneratedMutableMessageLite<MessageType extends GeneratedMutableMessageLite<MessageType>>
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected e unknownFields = e.ajf;
  
  public abstract MessageType BM();
  
  public abstract MessageType a(MessageType paramMessageType);
  
  public q<MessageType> fA()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private byte[] asBytes;
    private String messageClassName;
    
    SerializedForm(p paramp)
    {
      this.messageClassName = paramp.getClass().getName();
      this.asBytes = paramp.toByteArray();
    }
    
    protected Object readResolve()
    {
      try
      {
        p localp = (p)Class.forName(this.messageClassName).getMethod("newMessage", new Class[0]).invoke(null, new Object[0]);
        if (!localp.b(f.l(this.asBytes))) {
          throw new RuntimeException("Unable to understand proto buffer");
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class", localClassNotFoundException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException("Unable to find newMessage method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call newMessage method", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Error calling newMessage", localInvocationTargetException.getCause());
      }
      return localInvocationTargetException;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/GeneratedMutableMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */