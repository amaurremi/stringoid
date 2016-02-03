package com.google.api.client.http;

import com.google.api.client.util.aa;
import com.google.api.client.util.x;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ab
  extends a
{
  private ArrayList<a> abU = new ArrayList();
  
  public ab()
  {
    super(new p("multipart/related").j("boundary", "__END_OF_PART__"));
  }
  
  public ab a(a parama)
  {
    this.abU.add(x.ad(parama));
    return this;
  }
  
  public ab d(Collection<? extends j> paramCollection)
  {
    this.abU = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(new a((j)paramCollection.next()));
    }
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, xj());
    String str = xX();
    Iterator localIterator = this.abU.iterator();
    n localn;
    Object localObject1;
    long l;
    if (localIterator.hasNext())
    {
      localObject2 = (a)localIterator.next();
      localn = new n().bO(null);
      if (((a)localObject2).abp != null) {
        localn.b(((a)localObject2).abp);
      }
      localn.bQ(null).bY(null).bS(null).a(null).h("Content-Transfer-Encoding", null);
      localObject1 = ((a)localObject2).abv;
      if (localObject1 == null) {
        break label336;
      }
      localn.h("Content-Transfer-Encoding", Arrays.asList(new String[] { "binary" }));
      localn.bS(((j)localObject1).getType());
      localObject2 = ((a)localObject2).aba;
      if (localObject2 == null)
      {
        l = ((j)localObject1).getLength();
        label172:
        localObject2 = localObject1;
        if (l != -1L) {
          localn.a(Long.valueOf(l));
        }
      }
    }
    label336:
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("\r\n");
      n.a(localn, null, null, localOutputStreamWriter);
      if (localObject2 == null) {
        break;
      }
      localOutputStreamWriter.write("\r\n");
      localOutputStreamWriter.flush();
      ((aa)localObject2).writeTo(paramOutputStream);
      localOutputStreamWriter.write("\r\n");
      break;
      localn.bQ(((k)localObject2).getName());
      localObject2 = new l((aa)localObject1, (k)localObject2);
      l = a.b((j)localObject1);
      localObject1 = localObject2;
      break label172;
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write("\r\n");
      localOutputStreamWriter.flush();
      return;
    }
  }
  
  public final String xX()
  {
    return xi().getParameter("boundary");
  }
  
  public boolean xl()
  {
    Iterator localIterator = this.abU.iterator();
    while (localIterator.hasNext()) {
      if (!((a)localIterator.next()).abv.xl()) {
        return false;
      }
    }
    return true;
  }
  
  public static final class a
  {
    k aba;
    n abp;
    j abv;
    
    public a()
    {
      this(null);
    }
    
    public a(j paramj)
    {
      this(null, paramj);
    }
    
    public a(n paramn, j paramj)
    {
      d(paramn);
      d(paramj);
    }
    
    public a d(j paramj)
    {
      this.abv = paramj;
      return this;
    }
    
    public a d(n paramn)
    {
      this.abp = paramn;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */