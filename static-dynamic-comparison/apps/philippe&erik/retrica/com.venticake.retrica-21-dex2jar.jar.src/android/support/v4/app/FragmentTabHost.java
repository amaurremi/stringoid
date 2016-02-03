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
  private final ArrayList<o> a;
  private Context b;
  private l c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private o f;
  private boolean g;
  
  private p a(String paramString, p paramp)
  {
    Object localObject = null;
    int i = 0;
    if (i < this.a.size())
    {
      o localo = (o)this.a.get(i);
      if (!o.b(localo).equals(paramString)) {
        break label217;
      }
      localObject = localo;
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
      paramString = paramp;
      if (this.f != localObject)
      {
        paramString = paramp;
        if (paramp == null) {
          paramString = this.c.a();
        }
        if ((this.f != null) && (o.a(this.f) != null)) {
          paramString.b(o.a(this.f));
        }
        if (localObject != null)
        {
          if (o.a((o)localObject) != null) {
            break label204;
          }
          o.a((o)localObject, Fragment.instantiate(this.b, o.c((o)localObject).getName(), o.d((o)localObject)));
          paramString.a(this.d, o.a((o)localObject), o.b((o)localObject));
        }
      }
      for (;;)
      {
        this.f = ((o)localObject);
        return paramString;
        paramString.c(o.a((o)localObject));
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
      o localo = (o)this.a.get(i);
      o.a(localo, this.c.a(o.b(localo)));
      Object localObject2 = localObject1;
      if (o.a(localo) != null)
      {
        localObject2 = localObject1;
        if (!o.a(localo).isDetached())
        {
          if (!o.b(localo).equals(str)) {
            break label109;
          }
          this.f = localo;
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
        ((p)localObject2).b(o.a(localo));
      }
    }
    this.g = true;
    localObject1 = a(str, (p)localObject1);
    if (localObject1 != null)
    {
      ((p)localObject1).a();
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
      p localp = a(paramString, null);
      if (localp != null) {
        localp.a();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/app/FragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */