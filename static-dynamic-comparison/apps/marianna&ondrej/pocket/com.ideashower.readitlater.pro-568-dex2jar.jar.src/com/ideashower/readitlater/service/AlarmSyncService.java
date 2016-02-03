package com.ideashower.readitlater.service;

import android.content.Intent;
import com.ideashower.readitlater.a.g;

public class AlarmSyncService
  extends b
{
  public AlarmSyncService()
  {
    super("AlarmSyncService");
  }
  
  protected void b(Intent paramIntent)
  {
    if (g.j()) {
      return;
    }
    a(1, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/service/AlarmSyncService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */