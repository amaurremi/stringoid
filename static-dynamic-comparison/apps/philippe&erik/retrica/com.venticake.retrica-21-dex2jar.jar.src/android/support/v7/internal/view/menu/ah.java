package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ah
  extends o
  implements SubMenu
{
  private o d;
  private s e;
  
  public ah(Context paramContext, o paramo, s params)
  {
    super(paramContext);
    this.d = paramo;
    this.e = params;
  }
  
  public void a(p paramp)
  {
    this.d.a(paramp);
  }
  
  public boolean a()
  {
    return this.d.a();
  }
  
  public boolean a(o paramo, MenuItem paramMenuItem)
  {
    return (super.a(paramo, paramMenuItem)) || (this.d.a(paramo, paramMenuItem));
  }
  
  public boolean b()
  {
    return this.d.b();
  }
  
  public boolean c(s params)
  {
    return this.d.c(params);
  }
  
  public void clearHeader() {}
  
  public boolean d(s params)
  {
    return this.d.d(params);
  }
  
  public MenuItem getItem()
  {
    return this.e;
  }
  
  public o o()
  {
    return this.d;
  }
  
  public Menu r()
  {
    return this.d;
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.a(d().getResources().getDrawable(paramInt));
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.a(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.a(d().getResources().getString(paramInt));
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.a(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.e.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.e.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.d.setQwertyMode(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */