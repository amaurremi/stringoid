package com.pocket.c;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.r;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;
import java.io.InputStream;

public class ab
  extends an
{
  protected Boolean a;
  private final ItemQuery.ReadOnlyItemQuery b;
  private final ac h;
  private h p;
  
  public ab(ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, ac paramac)
  {
    super(3, 2);
    this.h = paramac;
    this.b = paramReadOnlyItemQuery;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 3) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0) {
      return;
    }
    this.p = null;
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/get", true);
    g.p();
    locala.a("positions");
    locala.a("authors");
    locala.a("images");
    locala.a("videos");
    locala.a("tags");
    locala.a("shares");
    locala.a("meta", "1");
    if (this.b.o() != null) {
      locala.a("offset", this.b.o().toString());
    }
    if (this.b.r() != null) {
      locala.a("count", this.b.r().toString());
    }
    locala.a("state", this.b.K());
    if (this.b.u() != null) {
      if (!this.b.u().booleanValue()) {
        break label303;
      }
    }
    label303:
    for (Object localObject = "1";; localObject = "0")
    {
      locala.a("favorite", (String)localObject);
      locala.a("sort", this.b.L());
      if (this.b.A() != null) {
        locala.a("tag", this.b.A());
      }
      if (this.b.x() != null)
      {
        String str = this.b.x();
        localObject = str;
        if (str.length() > 100) {
          localObject = str.substring(0, 100);
        }
        locala.a("search", (String)localObject);
      }
      if ((this.b.C() != null) && (this.b.C().intValue() != 0)) {
        locala.a("contentType", this.b.M());
      }
      if (this.b.h()) {
        locala.a("shared");
      }
      locala.a("cxt_search_type", this.b.z());
      return locala;
    }
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        int i = 1;
        if (ab.this.a_()) {
          i = 3;
        }
        int j;
        do
        {
          return i;
          paramAnonymousInputStream = new r(paramAnonymousInputStream, true);
          j = paramAnonymousInputStream.d();
          ab.a(ab.this, paramAnonymousInputStream.e());
          ab.this.a = paramAnonymousInputStream.g();
          if (ab.a(ab.this) != null) {
            ab.a(ab.this).a(ab.b(ab.this));
          }
        } while (j == 4);
        return 2;
      }
    };
  }
  
  public h n()
  {
    d();
    return this.p;
  }
  
  public Boolean o()
  {
    return this.a;
  }
  
  public ItemQuery.ReadOnlyItemQuery p()
  {
    return this.b;
  }
  
  protected void s()
  {
    this.p = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */