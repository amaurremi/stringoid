package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList a;
  private Context b;
  private j c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private m f;
  private boolean g;
  
  private n a(String paramString, n paramn)
  {
    Object localObject = null;
    int i = 0;
    if (i < this.a.size())
    {
      m localm = (m)this.a.get(i);
      if (!m.b(localm).equals(paramString)) {
        break label217;
      }
      localObject = localm;
    }
    label204:
    label217:
    for (;;)
    {
      i += 1;
      break;
      if (localObject == null) {
        throw new IllegalStateException("No tab known for tag " + paramString);
      }
      paramString = paramn;
      if (this.f != localObject)
      {
        paramString = paramn;
        if (paramn == null) {
          paramString = this.c.a();
        }
        if ((this.f != null) && (m.a(this.f) != null)) {
          paramString.b(m.a(this.f));
        }
        if (localObject != null)
        {
          if (m.a((m)localObject) != null) {
            break label204;
          }
          m.a((m)localObject, Fragment.a(this.b, m.c((m)localObject).getName(), m.d((m)localObject)));
          paramString.a(this.d, m.a((m)localObject), m.b((m)localObject));
        }
      }
      for (;;)
      {
        this.f = ((m)localObject);
        return paramString;
        paramString.c(m.a((m)localObject));
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int i = 0;
    if (i < this.a.size())
    {
      m localm = (m)this.a.get(i);
      m.a(localm, this.c.a(m.b(localm)));
      Object localObject2 = localObject1;
      if (m.a(localm) != null)
      {
        localObject2 = localObject1;
        if (!m.a(localm).q())
        {
          if (!m.b(localm).equals(str)) {
            break label109;
          }
          this.f = localm;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label109:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.c.a();
        }
        ((n)localObject2).b(m.a(localm));
      }
    }
    this.g = true;
    localObject1 = a(str, (n)localObject1);
    if (localObject1 != null)
    {
      ((n)localObject1).a();
      this.c.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.a = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.g)
    {
      n localn = a(paramString, null);
      if (localn != null) {
        localn.a();
      }
    }
    if (this.e != null) {
      this.e.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.e = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/FragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */