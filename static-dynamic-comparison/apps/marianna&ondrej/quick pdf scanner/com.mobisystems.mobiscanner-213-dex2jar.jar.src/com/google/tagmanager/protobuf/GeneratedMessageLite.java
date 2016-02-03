package com.google.tagmanager.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  protected GeneratedMessageLite() {}
  
  protected GeneratedMessageLite(a parama) {}
  
  private static <MessageType extends n> boolean a(h<d> paramh, MessageType paramMessageType, f paramf, CodedOutputStream paramCodedOutputStream, g paramg, int paramInt)
  {
    int i = WireFormat.fz(paramInt);
    e locale = paramg.a(paramMessageType, WireFormat.fA(paramInt));
    int j;
    if (locale == null)
    {
      i = 0;
      j = 1;
    }
    while (j != 0)
    {
      return paramf.a(paramInt, paramCodedOutputStream);
      if (i == h.a(locale.ajS.Bz(), false))
      {
        i = 0;
        j = 0;
      }
      else if ((locale.ajS.ajP) && (locale.ajS.ajO.Ct()) && (i == h.a(locale.ajS.Bz(), true)))
      {
        i = 1;
        j = 0;
      }
      else
      {
        i = 0;
        j = 1;
      }
    }
    if (i != 0)
    {
      paramInt = paramf.eV(paramf.Bi());
      if (locale.ajS.Bz() == WireFormat.FieldType.ald) {
        while (paramf.Bn() > 0)
        {
          i = paramf.Bd();
          paramMessageType = locale.ajS.BK().aE(i);
          if (paramMessageType == null) {
            return true;
          }
          paramh.b(locale.ajS, locale.at(paramMessageType));
        }
      }
      while (paramf.Bn() > 0)
      {
        paramMessageType = h.a(paramf, locale.ajS.Bz(), false);
        paramh.b(locale.ajS, paramMessageType);
      }
      paramf.eW(paramInt);
    }
    for (;;)
    {
      return true;
      switch (1.ajG[locale.ajS.BA().ordinal()])
      {
      default: 
        paramMessageType = h.a(paramf, locale.ajS.Bz(), false);
        label306:
        if (!locale.ajS.BB()) {
          break label475;
        }
        paramh.b(locale.ajS, locale.at(paramMessageType));
      }
    }
    if (!locale.ajS.BB())
    {
      paramMessageType = (n)paramh.a(locale.ajS);
      if (paramMessageType == null) {}
    }
    for (paramMessageType = paramMessageType.fM();; paramMessageType = null)
    {
      paramCodedOutputStream = paramMessageType;
      if (paramMessageType == null) {
        paramCodedOutputStream = locale.BL().fN();
      }
      if (locale.ajS.Bz() == WireFormat.FieldType.akZ) {
        paramf.a(locale.ga(), paramCodedOutputStream, paramg);
      }
      for (;;)
      {
        paramMessageType = paramCodedOutputStream.fY();
        break;
        paramf.a(paramCodedOutputStream, paramg);
      }
      i = paramf.Bd();
      paramf = locale.ajS.BK().aE(i);
      paramMessageType = paramf;
      if (paramf != null) {
        break label306;
      }
      paramCodedOutputStream.fn(paramInt);
      paramCodedOutputStream.fb(i);
      return true;
      label475:
      paramh.a(locale.ajS, locale.at(paramMessageType));
      break;
    }
  }
  
  protected void BD() {}
  
  protected boolean a(f paramf, CodedOutputStream paramCodedOutputStream, g paramg, int paramInt)
  {
    return paramf.a(paramInt, paramCodedOutputStream);
  }
  
  public q<? extends n> fA()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>>
    extends GeneratedMessageLite
    implements GeneratedMessageLite.c<MessageType>
  {
    private final h<GeneratedMessageLite.d> extensions;
    
    protected ExtendableMessage()
    {
      this.extensions = h.Bv();
    }
    
    protected ExtendableMessage(GeneratedMessageLite.b<MessageType, ?> paramb)
    {
      this.extensions = GeneratedMessageLite.b.a(paramb);
    }
    
    protected void BD()
    {
      this.extensions.Bx();
    }
    
    protected boolean BH()
    {
      return this.extensions.isInitialized();
    }
    
    protected ExtendableMessage<MessageType>.a BI()
    {
      return new a(false, null);
    }
    
    protected int BJ()
    {
      return this.extensions.fI();
    }
    
    protected boolean a(f paramf, CodedOutputStream paramCodedOutputStream, g paramg, int paramInt)
    {
      return GeneratedMessageLite.b(this.extensions, fO(), paramf, paramCodedOutputStream, paramg, paramInt);
    }
    
    protected class a
    {
      private final Iterator<Map.Entry<GeneratedMessageLite.d, Object>> ajJ = GeneratedMessageLite.ExtendableMessage.b(GeneratedMessageLite.ExtendableMessage.this).iterator();
      private Map.Entry<GeneratedMessageLite.d, Object> ajK;
      private final boolean ajL;
      
      private a(boolean paramBoolean)
      {
        if (this.ajJ.hasNext()) {
          this.ajK = ((Map.Entry)this.ajJ.next());
        }
        this.ajL = paramBoolean;
      }
      
      public void b(int paramInt, CodedOutputStream paramCodedOutputStream)
      {
        while ((this.ajK != null) && (((GeneratedMessageLite.d)this.ajK.getKey()).ga() < paramInt))
        {
          GeneratedMessageLite.d locald = (GeneratedMessageLite.d)this.ajK.getKey();
          if ((this.ajL) && (locald.BA() == WireFormat.JavaType.alr) && (!locald.BB())) {
            paramCodedOutputStream.c(locald.ga(), (n)this.ajK.getValue());
          }
          for (;;)
          {
            if (!this.ajJ.hasNext()) {
              break label131;
            }
            this.ajK = ((Map.Entry)this.ajJ.next());
            break;
            h.a(locald, this.ajK.getValue(), paramCodedOutputStream);
          }
          label131:
          this.ajK = null;
        }
      }
    }
  }
  
  static final class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private byte[] asBytes;
    private String messageClassName;
    
    SerializedForm(n paramn)
    {
      this.messageClassName = paramn.getClass().getName();
      this.asBytes = paramn.toByteArray();
    }
    
    protected Object readResolve()
    {
      try
      {
        Object localObject = (n.a)Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
        ((n.a)localObject).j(this.asBytes);
        localObject = ((n.a)localObject).fX();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class", localClassNotFoundException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException("Unable to find newBuilder method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call newBuilder method", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Error calling newBuilder", localInvocationTargetException.getCause());
      }
      catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
      {
        throw new RuntimeException("Unable to understand proto buffer", localInvalidProtocolBufferException);
      }
    }
  }
  
  public static abstract class a<MessageType extends GeneratedMessageLite, BuilderType extends a>
    extends a.a<BuilderType>
  {
    private e unknownFields = e.ajf;
    
    public final e BE()
    {
      return this.unknownFields;
    }
    
    public abstract BuilderType a(MessageType paramMessageType);
    
    public final BuilderType e(e parame)
    {
      this.unknownFields = parame;
      return this;
    }
    
    public abstract MessageType fU();
    
    public BuilderType fV()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract class b<MessageType extends GeneratedMessageLite.ExtendableMessage<MessageType>, BuilderType extends b<MessageType, BuilderType>>
    extends GeneratedMessageLite.a<MessageType, BuilderType>
    implements GeneratedMessageLite.c<MessageType>
  {
    private boolean ajI;
    private h<GeneratedMessageLite.d> extensions = h.Bw();
    
    private void BF()
    {
      if (!this.ajI)
      {
        this.extensions = this.extensions.By();
        this.ajI = true;
      }
    }
    
    private h<GeneratedMessageLite.d> BG()
    {
      this.extensions.Bx();
      this.ajI = false;
      return this.extensions;
    }
    
    protected boolean BH()
    {
      return this.extensions.isInitialized();
    }
    
    protected final void a(MessageType paramMessageType)
    {
      BF();
      this.extensions.a(GeneratedMessageLite.ExtendableMessage.b(paramMessageType));
    }
    
    public BuilderType jg()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
  }
  
  public static abstract interface c
    extends o
  {}
  
  static final class d
    implements h.a<d>
  {
    final i.b<?> ajN;
    final WireFormat.FieldType ajO;
    final boolean ajP;
    final boolean ajQ;
    final int number;
    
    public WireFormat.JavaType BA()
    {
      return this.ajO.Cr();
    }
    
    public boolean BB()
    {
      return this.ajP;
    }
    
    public boolean BC()
    {
      return this.ajQ;
    }
    
    public i.b<?> BK()
    {
      return this.ajN;
    }
    
    public WireFormat.FieldType Bz()
    {
      return this.ajO;
    }
    
    public int a(d paramd)
    {
      return this.number - paramd.number;
    }
    
    public n.a a(n.a parama, n paramn)
    {
      return ((GeneratedMessageLite.a)parama).a((GeneratedMessageLite)paramn);
    }
    
    public p a(p paramp1, p paramp2)
    {
      return ((GeneratedMutableMessageLite)paramp1).a((GeneratedMutableMessageLite)paramp2);
    }
    
    public int ga()
    {
      return this.number;
    }
  }
  
  public static class e<ContainingType extends n, Type>
  {
    final n ajR;
    final GeneratedMessageLite.d ajS;
    
    public n BL()
    {
      return this.ajR;
    }
    
    Object at(Object paramObject)
    {
      Object localObject = paramObject;
      if (this.ajS.BA() == WireFormat.JavaType.alq) {
        localObject = Integer.valueOf(((i.a)paramObject).ga());
      }
      return localObject;
    }
    
    public int ga()
    {
      return this.ajS.ga();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/GeneratedMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */