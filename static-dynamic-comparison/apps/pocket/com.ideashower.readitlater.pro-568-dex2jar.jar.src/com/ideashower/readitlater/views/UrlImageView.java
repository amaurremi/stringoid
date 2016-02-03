package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.util.j;

public class UrlImageView
  extends ImageView
{
  private static BitmapFactory.Options a;
  private int b;
  private final boolean c = false;
  private String d;
  
  public UrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public UrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public UrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, b.UrlImageView);
    paramAttributeSet = null;
    if (j.c()) {
      paramAttributeSet = localTypedArray.getString(1);
    }
    Object localObject = paramAttributeSet;
    if (paramAttributeSet == null) {
      localObject = localTypedArray.getString(0);
    }
    if (localObject != null) {
      setImageUrl((String)localObject);
    }
    localTypedArray.recycle();
  }
  
  protected static BitmapFactory.Options getBitmapOptions()
  {
    if (a == null)
    {
      a = new BitmapFactory.Options();
      a.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }
    return a;
  }
  
  public void a()
  {
    Object localObject = getDrawable();
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    setImageDrawable(null);
  }
  
  public void setImageUrl(String paramString)
  {
    this.d = paramString;
    if (this.b != 0) {
      setImageResource(this.b);
    }
    for (;;)
    {
      new az(this, paramString, null).execute(new Void[0]);
      return;
      setImageDrawable(null);
    }
  }
  
  public void setPlaceHolder(int paramInt)
  {
    this.b = paramInt;
    setImageResource(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/UrlImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */