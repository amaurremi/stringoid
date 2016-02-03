package com.androidwasabi.livewallpaper.xperiaz;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;
import com.androidwasabi.ads.NewAppManager.AppItem;
import com.androidwasabi.ads.NewAppManager.OnNewAppListener;

class b
  extends NewAppManager.OnNewAppListener
{
  b(AppLauncher paramAppLauncher) {}
  
  public void loaded(NewAppManager.AppItem[] paramArrayOfAppItem)
  {
    if (paramArrayOfAppItem != null) {
      try
      {
        ((LinearLayout)this.a.findViewById(2131296263)).setVisibility(0);
        int i = (int)TypedValue.applyDimension(1, 48.0F, this.a.getResources().getDisplayMetrics());
        if (paramArrayOfAppItem.length == 1)
        {
          paramArrayOfAppItem = paramArrayOfAppItem[0];
          localObject1 = (Button)this.a.findViewById(2131296264);
          ((Button)localObject1).setVisibility(0);
          ((Button)localObject1).setText(paramArrayOfAppItem.name);
          localObject2 = new BitmapDrawable(paramArrayOfAppItem.bitmap);
          ((BitmapDrawable)localObject2).setBounds(new Rect(0, 0, i, i));
          ((Button)localObject1).setCompoundDrawables(null, (Drawable)localObject2, null, null);
          ((Button)localObject1).setOnClickListener(new c(this, paramArrayOfAppItem));
          ((Button)this.a.findViewById(2131296265)).setVisibility(8);
          return;
        }
        Object localObject1 = paramArrayOfAppItem[0];
        Object localObject2 = (Button)this.a.findViewById(2131296264);
        ((Button)localObject2).setVisibility(0);
        ((Button)localObject2).setText(((NewAppManager.AppItem)localObject1).name);
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(((NewAppManager.AppItem)localObject1).bitmap);
        localBitmapDrawable.setBounds(new Rect(0, 0, i, i));
        ((Button)localObject2).setCompoundDrawables(null, localBitmapDrawable, null, null);
        ((Button)localObject2).setOnClickListener(new d(this, (NewAppManager.AppItem)localObject1));
        paramArrayOfAppItem = paramArrayOfAppItem[1];
        localObject1 = (Button)this.a.findViewById(2131296265);
        ((Button)localObject1).setVisibility(0);
        ((Button)localObject1).setText(paramArrayOfAppItem.name);
        localObject2 = new BitmapDrawable(paramArrayOfAppItem.bitmap);
        ((BitmapDrawable)localObject2).setBounds(new Rect(0, 0, i, i));
        ((Button)localObject1).setCompoundDrawables(null, (Drawable)localObject2, null, null);
        ((Button)localObject1).setOnClickListener(new e(this, paramArrayOfAppItem));
        return;
      }
      catch (Exception paramArrayOfAppItem) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */