package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.image.BitmapFactory;

public abstract interface bn
{
  public abstract void a(Context paramContext, String paramString);
  
  public abstract void a(Class<? extends FullScreenAdActivity> paramClass);
  
  public abstract void b(Class<? extends VungleService> paramClass);
  
  public abstract void setBitmapFactory(BitmapFactory paramBitmapFactory);
  
  public abstract void setWrapperFramework(WrapperFramework paramWrapperFramework);
  
  public abstract void setWrapperFrameworkVersion(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */