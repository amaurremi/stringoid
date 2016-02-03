package com.pocket.q.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.e.b.a;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.z;
import com.pocket.p.c;
import com.pocket.widget.CacheLimitSeekbar;
import com.pocket.widget.b;
import org.apache.a.c.k;

public class d
  extends o
{
  private final CharSequence a = g.a(2131493639);
  private final CharSequence b = g.a(2131493635);
  private final TextView c;
  private final TextView d;
  private final TextView e;
  private final CacheLimitSeekbar f;
  private f g;
  private String h;
  private final com.pocket.m.a.f i;
  
  public d(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130903157, this);
    this.f = ((CacheLimitSeekbar)findViewById(2131231080));
    this.c = ((TextView)findViewById(2131231077));
    this.d = ((TextView)findViewById(2131231081));
    this.e = ((TextView)findViewById(2131231079));
    this.f.setOnIncrementedMbProgressChangedListener(new b()
    {
      public void a(int paramAnonymousInt, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        d.a(d.this, paramAnonymousInt);
        d.a(d.this, paramAnonymousLong);
        if ((!paramAnonymousBoolean) && (d.a(d.this) != null)) {
          d.a(d.this).a(paramAnonymousLong);
        }
      }
    });
    this.i = new e(this, null);
    com.pocket.m.a.e.a(this.i);
    this.i.a(com.pocket.m.a.e.h());
    int k = getInnerCellPaddingLeft();
    a(0, getInnerCellPaddingTop(), 0, getInnerCellPaddingBottom());
    int m = getChildCount();
    int j = 0;
    while (j < m)
    {
      paramContext = getChildAt(j);
      if ((paramContext != this.f) && (paramContext != this.e)) {
        z.e(paramContext, k);
      }
      j += 1;
    }
  }
  
  private void a(double paramDouble)
  {
    if (paramDouble <= 0.0D)
    {
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
    CharSequence localCharSequence = a.a(getContext(), 2131493628).a("item_count", String.valueOf(b(paramDouble))).a("newest_or_oldest", k.e(this.h, "")).a();
    this.d.setText(localCharSequence);
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.e.setText(2131493647);
      return;
    }
    if (paramInt < 1000) {}
    for (String str = paramInt + " " + this.a;; str = String.format("%.1f", new Object[] { Double.valueOf(paramInt / 1024.0D) }) + " " + this.b)
    {
      this.e.setText(str);
      return;
    }
  }
  
  private int b(double paramDouble)
  {
    paramDouble = Math.floor((int)((paramDouble - com.pocket.m.a.e.b) / c.a()) / 5);
    return (int)(5 * paramDouble);
  }
  
  public void a()
  {
    com.pocket.m.a.e.b(this.i);
  }
  
  public long getLimit()
  {
    return this.f.getProgressInBytes();
  }
  
  public void setItemOrder(String paramString)
  {
    this.h = paramString;
    a(this.f.getProgressInBytes());
  }
  
  public void setLimit(long paramLong)
  {
    this.f.setProgressInBytes(paramLong);
  }
  
  public void setOnCacheLimitChangedListener(f paramf)
  {
    this.g = paramf;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */