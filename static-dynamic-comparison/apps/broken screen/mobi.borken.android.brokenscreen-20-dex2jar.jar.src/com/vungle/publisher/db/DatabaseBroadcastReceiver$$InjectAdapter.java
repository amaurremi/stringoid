package com.vungle.publisher.db;

import android.content.Context;
import com.vungle.publisher.be;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class DatabaseBroadcastReceiver$$InjectAdapter
  extends cs<DatabaseBroadcastReceiver>
  implements cp<DatabaseBroadcastReceiver>, Provider<DatabaseBroadcastReceiver>
{
  private cs<Context> a;
  private cs<DatabaseHelper> b;
  private cs<be> c;
  
  public DatabaseBroadcastReceiver$$InjectAdapter()
  {
    super("com.vungle.publisher.db.DatabaseBroadcastReceiver", "members/com.vungle.publisher.db.DatabaseBroadcastReceiver", true, DatabaseBroadcastReceiver.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", DatabaseBroadcastReceiver.class, getClass().getClassLoader());
    this.b = paramcy.a("com.vungle.publisher.db.DatabaseHelper", DatabaseBroadcastReceiver.class, getClass().getClassLoader());
    this.c = paramcy.a("com.vungle.publisher.be", DatabaseBroadcastReceiver.class, getClass().getClassLoader());
  }
  
  public final DatabaseBroadcastReceiver get()
  {
    DatabaseBroadcastReceiver localDatabaseBroadcastReceiver = new DatabaseBroadcastReceiver();
    injectMembers(localDatabaseBroadcastReceiver);
    return localDatabaseBroadcastReceiver;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
    paramSet2.add(this.c);
  }
  
  public final void injectMembers(DatabaseBroadcastReceiver paramDatabaseBroadcastReceiver)
  {
    paramDatabaseBroadcastReceiver.b = ((Context)this.a.get());
    paramDatabaseBroadcastReceiver.c = ((DatabaseHelper)this.b.get());
    paramDatabaseBroadcastReceiver.d = ((be)this.c.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/DatabaseBroadcastReceiver$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */