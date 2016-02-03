package com.vungle.publisher.db;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vungle.publisher.be;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseBroadcastReceiver
  extends BroadcastReceiver
{
  public boolean a = false;
  @Inject
  public Context b;
  @Inject
  DatabaseHelper c;
  @Inject
  be d;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.vungle.publisher.db.DUMP_TABLES".equals(paramIntent.getAction()))
    {
      Logger.d("VungleDatabaseDump", this.d.b() + " received dump tables request");
      paramContext = paramIntent.getStringArrayExtra("tables");
      this.c.a(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/DatabaseBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */