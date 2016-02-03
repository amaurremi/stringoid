package com.pocket.widget.undobar;

import android.content.Context;
import android.content.Intent;
import com.ideashower.readitlater.db.operation.action.s;
import java.util.ArrayList;

public class a
{
  public static void a(Context paramContext)
  {
    paramContext.stopService(new Intent(paramContext, UndoBarService.class));
  }
  
  public static void a(Context paramContext, s params)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(params);
    a(paramContext, localArrayList);
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList)
  {
    UndoBarService.a = paramArrayList;
    paramContext.startService(new Intent(paramContext, UndoBarService.class));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/undobar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */