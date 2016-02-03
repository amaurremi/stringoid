package com.google.api.client.json;

import com.google.api.client.util.DateTime;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ae;
import com.google.api.client.util.h;
import com.google.api.client.util.l;
import com.google.api.client.util.x;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class e
{
  private void c(boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      return;
    }
    Object localObject1 = paramObject.getClass();
    if (com.google.api.client.util.i.ag(paramObject))
    {
      yi();
      return;
    }
    if ((paramObject instanceof String))
    {
      writeString((String)paramObject);
      return;
    }
    if ((paramObject instanceof Number))
    {
      if (paramBoolean)
      {
        writeString(paramObject.toString());
        return;
      }
      if ((paramObject instanceof BigDecimal))
      {
        a((BigDecimal)paramObject);
        return;
      }
      if ((paramObject instanceof BigInteger))
      {
        a((BigInteger)paramObject);
        return;
      }
      if ((paramObject instanceof Long))
      {
        z(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        float f = ((Number)paramObject).floatValue();
        if ((!Float.isInfinite(f)) && (!Float.isNaN(f))) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          x.av(paramBoolean);
          s(f);
          return;
        }
      }
      if (((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))
      {
        eK(((Number)paramObject).intValue());
        return;
      }
      double d = ((Number)paramObject).doubleValue();
      if ((!Double.isInfinite(d)) && (!Double.isNaN(d))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        x.av(paramBoolean);
        j(d);
        return;
      }
    }
    if ((paramObject instanceof Boolean))
    {
      writeBoolean(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof DateTime))
    {
      writeString(((DateTime)paramObject).yL());
      return;
    }
    if (((paramObject instanceof Iterable)) || (((Class)localObject1).isArray()))
    {
      ye();
      paramObject = ae.ak(paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        c(paramBoolean, ((Iterator)paramObject).next());
      }
      yf();
      return;
    }
    if (((Class)localObject1).isEnum())
    {
      paramObject = l.a((Enum)paramObject).getName();
      if (paramObject == null)
      {
        yi();
        return;
      }
      writeString((String)paramObject);
      return;
    }
    yg();
    int i;
    label394:
    label409:
    Object localObject3;
    Object localObject2;
    if (((paramObject instanceof Map)) && (!(paramObject instanceof GenericData)))
    {
      i = 1;
      if (i == 0) {
        break label486;
      }
      localObject1 = null;
      paramObject = com.google.api.client.util.i.ah(paramObject).entrySet().iterator();
      do
      {
        if (!((Iterator)paramObject).hasNext()) {
          break;
        }
        localObject3 = (Map.Entry)((Iterator)paramObject).next();
        localObject2 = ((Map.Entry)localObject3).getValue();
      } while (localObject2 == null);
      localObject3 = (String)((Map.Entry)localObject3).getKey();
      if (i == 0) {
        break label496;
      }
      bool = paramBoolean;
    }
    for (;;)
    {
      cp((String)localObject3);
      c(bool, localObject2);
      break label409;
      i = 0;
      break;
      label486:
      localObject1 = h.i((Class)localObject1);
      break label394;
      label496:
      Field localField = ((h)localObject1).getField((String)localObject3);
      if ((localField != null) && (localField.getAnnotation(i.class) != null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    yh();
  }
  
  public abstract void a(BigDecimal paramBigDecimal);
  
  public abstract void a(BigInteger paramBigInteger);
  
  public final void ab(Object paramObject)
  {
    c(false, paramObject);
  }
  
  public abstract void cp(String paramString);
  
  public abstract void eK(int paramInt);
  
  public abstract void flush();
  
  public abstract void j(double paramDouble);
  
  public abstract void s(float paramFloat);
  
  public abstract void writeBoolean(boolean paramBoolean);
  
  public abstract void writeString(String paramString);
  
  public abstract void ye();
  
  public abstract void yf();
  
  public abstract void yg();
  
  public abstract void yh();
  
  public abstract void yi();
  
  public void yj() {}
  
  public abstract void z(long paramLong);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */