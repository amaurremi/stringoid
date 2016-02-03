package android.support.v7.internal.view.menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.b.h;
import android.support.v7.b.j;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;

public class r
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, ac
{
  private o a;
  m b;
  private AlertDialog c;
  private ac d;
  
  public r(o paramo)
  {
    this.a = paramo;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  public void a(IBinder paramIBinder)
  {
    Object localObject = this.a;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(((o)localObject).d());
    this.b = new m(h.abc_list_menu_item_layout, j.Theme_AppCompat_CompactMenu_Dialog);
    this.b.a(this);
    this.a.a(this.b);
    localBuilder.setAdapter(this.b.a(), this);
    View localView = ((o)localObject).n();
    if (localView != null) {
      localBuilder.setCustomTitle(localView);
    }
    for (;;)
    {
      localBuilder.setOnKeyListener(this);
      this.c = localBuilder.create();
      this.c.setOnDismissListener(this);
      localObject = this.c.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).type = 1003;
      if (paramIBinder != null) {
        ((WindowManager.LayoutParams)localObject).token = paramIBinder;
      }
      ((WindowManager.LayoutParams)localObject).flags |= 0x20000;
      this.c.show();
      return;
      localBuilder.setIcon(((o)localObject).m()).setTitle(((o)localObject).l());
    }
  }
  
  public void a(o paramo, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramo == this.a)) {
      a();
    }
    if (this.d != null) {
      this.d.a(paramo, paramBoolean);
    }
  }
  
  public boolean b(o paramo)
  {
    if (this.d != null) {
      return this.d.b(paramo);
    }
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a((s)this.b.a().getItem(paramInt), 0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.b.a(this.a, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.c.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.c.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.a.a(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.a.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */