package com.google.api.client.http;

import com.google.api.client.util.ae;
import com.google.api.client.util.i;
import com.google.api.client.util.l;
import com.google.api.client.util.x;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ac
  extends a
{
  private Object data;
  
  public ac(Object paramObject)
  {
    super(ad.MEDIA_TYPE);
    Z(paramObject);
  }
  
  private static boolean a(boolean paramBoolean, Writer paramWriter, String paramString, Object paramObject)
  {
    boolean bool = paramBoolean;
    if (paramObject != null)
    {
      if (i.ag(paramObject)) {
        bool = paramBoolean;
      }
    }
    else {
      return bool;
    }
    if (paramBoolean)
    {
      paramBoolean = false;
      label26:
      paramWriter.write(paramString);
      if (!(paramObject instanceof Enum)) {
        break label86;
      }
    }
    label86:
    for (paramString = l.a((Enum)paramObject).getName();; paramString = paramObject.toString())
    {
      paramString = com.google.api.client.util.a.a.cu(paramString);
      bool = paramBoolean;
      if (paramString.length() == 0) {
        break;
      }
      paramWriter.write("=");
      paramWriter.write(paramString);
      return paramBoolean;
      paramWriter.write("&");
      break label26;
    }
  }
  
  public ac Z(Object paramObject)
  {
    this.data = x.ad(paramObject);
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream = new BufferedWriter(new OutputStreamWriter(paramOutputStream, xj()));
    Iterator localIterator = i.ah(this.data).entrySet().iterator();
    boolean bool = true;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = ((Map.Entry)localObject2).getValue();
      if (localObject1 == null) {
        break label173;
      }
      localObject2 = com.google.api.client.util.a.a.cu((String)((Map.Entry)localObject2).getKey());
      Class localClass = localObject1.getClass();
      if (((localObject1 instanceof Iterable)) || (localClass.isArray()))
      {
        localObject1 = ae.ak(localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          bool = a(bool, paramOutputStream, (String)localObject2, ((Iterator)localObject1).next());
        }
      }
    }
    label173:
    for (;;)
    {
      break;
      bool = a(bool, paramOutputStream, (String)localObject2, localObject1);
      continue;
      paramOutputStream.flush();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */