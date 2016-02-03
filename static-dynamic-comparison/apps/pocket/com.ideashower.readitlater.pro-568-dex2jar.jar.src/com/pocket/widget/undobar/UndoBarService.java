package com.pocket.widget.undobar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.e.b.a;
import com.ideashower.readitlater.db.operation.action.al;
import com.ideashower.readitlater.db.operation.action.s;
import java.util.ArrayList;
import java.util.Iterator;

public class UndoBarService
  extends Service
  implements c
{
  public static ArrayList a;
  private b b;
  
  public void a()
  {
    stopSelf();
  }
  
  public void b()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).j();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    int i = a.size();
    String str2;
    String str1;
    if ((a.get(0) instanceof al)) {
      if (i > 1)
      {
        str2 = a.a(this, 2131493761).a("number_of_item", i).a().toString();
        str1 = a.a(this, 2131493763).a("number_of_item", String.valueOf(i)).a().toString();
      }
    }
    for (;;)
    {
      this.b = new b(this, str2, str1, this);
      this.b.a();
      return;
      str2 = getString(2131493755);
      str1 = getString(2131493758);
      continue;
      if (i > 1)
      {
        str2 = a.a(this, 2131493762).a("number_of_item", i).a().toString();
        str1 = a.a(this, 2131493764).a("number_of_item", String.valueOf(i)).a().toString();
      }
      else
      {
        str2 = getString(2131493756);
        str1 = getString(2131493759);
      }
    }
  }
  
  public void onDestroy()
  {
    this.b.b();
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/undobar/UndoBarService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */