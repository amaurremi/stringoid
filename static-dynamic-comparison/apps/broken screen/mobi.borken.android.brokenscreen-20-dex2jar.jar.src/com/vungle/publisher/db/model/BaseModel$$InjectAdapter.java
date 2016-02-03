package com.vungle.publisher.db.model;

import com.vungle.publisher.ar;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.db.DatabaseHelper;
import java.util.Set;

public final class BaseModel$$InjectAdapter
  extends cs<ar>
  implements cp<ar>
{
  private cs<DatabaseHelper> a;
  
  public BaseModel$$InjectAdapter()
  {
    super(null, "members/com.vungle.publisher.db.model.BaseModel", false, ar.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("com.vungle.publisher.db.DatabaseHelper", ar.class, getClass().getClassLoader());
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
  }
  
  public final void injectMembers(ar paramar)
  {
    paramar.o = ((DatabaseHelper)this.a.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/BaseModel$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */