package android.support.v7.internal.view.menu;

import android.support.v4.view.j;
import android.support.v4.view.l;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class u
  extends ActionProvider
{
  final j a;
  
  public u(final t paramt, j paramj)
  {
    super(paramj.a());
    this.a = paramj;
    if (t.a(paramt)) {
      this.a.a(new l()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          if ((u.this.a.c()) && (t.b(u.this.b))) {
            u.this.b.b(paramAnonymousBoolean);
          }
        }
      });
    }
  }
  
  public boolean hasSubMenu()
  {
    return this.a.g();
  }
  
  public View onCreateActionView()
  {
    if (t.a(this.b)) {
      this.b.c();
    }
    return this.a.b();
  }
  
  public boolean onPerformDefaultAction()
  {
    return this.a.f();
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    this.a.a(this.b.a(paramSubMenu));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */