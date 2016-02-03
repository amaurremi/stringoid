package com.pocket.gsf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ideashower.readitlater.util.j;
import java.util.ArrayList;
import java.util.HashMap;

public class b
  extends BaseAdapter
{
  private static final int a = j.a(6.0F);
  private final ArrayList b;
  private final Context c;
  private final LayoutInflater d;
  private final Paint e;
  private final HashMap f = new HashMap();
  
  public b(ArrayList paramArrayList, Context paramContext)
  {
    this.b = paramArrayList;
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.e = new Paint();
    this.e.setColor(Color.rgb(0, 192, 255));
    this.e.setMaskFilter(new BlurMaskFilter(a, BlurMaskFilter.Blur.OUTER));
  }
  
  private BitmapDrawable a(BitmapDrawable paramBitmapDrawable)
  {
    paramBitmapDrawable = paramBitmapDrawable.getBitmap();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmapDrawable.getWidth() + a * 2, paramBitmapDrawable.getHeight() + a * 2, Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawBitmap(paramBitmapDrawable, a, a, null);
    return new BitmapDrawable(this.c.getResources(), localBitmap);
  }
  
  private Drawable a(a parama)
  {
    Drawable localDrawable = (Drawable)this.f.get(parama.b());
    Object localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = a(parama.a(this.c));
      this.f.put(parama.b(), localObject);
    }
    return (Drawable)localObject;
  }
  
  private StateListDrawable a(Drawable paramDrawable)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    BitmapDrawable localBitmapDrawable = b((BitmapDrawable)paramDrawable);
    localStateListDrawable.addState(new int[] { 16842919 }, localBitmapDrawable);
    localStateListDrawable.addState(StateSet.WILD_CARD, a((BitmapDrawable)paramDrawable));
    return localStateListDrawable;
  }
  
  private BitmapDrawable b(BitmapDrawable paramBitmapDrawable)
  {
    paramBitmapDrawable = paramBitmapDrawable.getBitmap();
    Bitmap localBitmap1 = paramBitmapDrawable.extractAlpha();
    Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmapDrawable.getWidth() + a * 2, paramBitmapDrawable.getHeight() + a * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localCanvas.drawBitmap(localBitmap1, a, a, this.e);
    localCanvas.drawBitmap(paramBitmapDrawable, a, a, null);
    return new BitmapDrawable(this.c.getResources(), localBitmap2);
  }
  
  public a a(int paramInt)
  {
    return (a)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    if ((this.b != null) && (this.b.size() != 0)) {
      return this.b.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      c localc = (c)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localc;
    }
    for (;;)
    {
      paramView.a((a)this.b.get(paramInt));
      return paramViewGroup;
      paramViewGroup = this.d.inflate(2130903071, null);
      paramView = new c(this, paramViewGroup);
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/gsf/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */