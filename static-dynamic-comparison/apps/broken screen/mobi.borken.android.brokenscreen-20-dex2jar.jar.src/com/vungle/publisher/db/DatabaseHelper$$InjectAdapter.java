package com.vungle.publisher.db;

import android.content.Context;
import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.be;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import com.vungle.publisher.di;
import java.util.Set;
import javax.inject.Provider;

public final class DatabaseHelper$$InjectAdapter
  extends cs<DatabaseHelper>
  implements cp<DatabaseHelper>, Provider<DatabaseHelper>
{
  private cs<di> a;
  private cs<be> b;
  private cs<ScheduledPriorityExecutor> c;
  private cs<Provider<String>> d;
  private cs<Context> e;
  
  public DatabaseHelper$$InjectAdapter()
  {
    super("com.vungle.publisher.db.DatabaseHelper", "members/com.vungle.publisher.db.DatabaseHelper", true, DatabaseHelper.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.e = paramcy.a("android.content.Context", DatabaseHelper.class, getClass().getClassLoader());
    this.a = paramcy.a("com.vungle.publisher.di", DatabaseHelper.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.be", DatabaseHelper.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.async.ScheduledPriorityExecutor", DatabaseHelper.class, getClass().getClassLoader());
    this.d = paramcy.a("@com.vungle.publisher.inject.annotations.AdTempDirectory()/javax.inject.Provider<java.lang.String>", DatabaseHelper.class, getClass().getClassLoader());
  }
  
  public final DatabaseHelper get()
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper((Context)this.e.get());
    injectMembers(localDatabaseHelper);
    return localDatabaseHelper;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet1.add(this.e);
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
    paramSet2.add(this.d);
  }
  
  public final void injectMembers(DatabaseHelper paramDatabaseHelper)
  {
    paramDatabaseHelper.a = ((di)this.a.get());
    paramDatabaseHelper.b = ((be)this.b.get());
    paramDatabaseHelper.c = ((ScheduledPriorityExecutor)this.c.get());
    paramDatabaseHelper.d = ((Provider)this.d.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/DatabaseHelper$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */