package com.vungle.publisher.image;

import android.content.Context;
import com.vungle.publisher.cp;
import com.vungle.publisher.cs;
import com.vungle.publisher.cy;
import java.util.Set;
import javax.inject.Provider;

public final class AssetBitmapFactory$$InjectAdapter
  extends cs<AssetBitmapFactory>
  implements cp<AssetBitmapFactory>, Provider<AssetBitmapFactory>
{
  private cs<Context> a;
  private cs<BaseBitmapFactory> b;
  
  public AssetBitmapFactory$$InjectAdapter()
  {
    super("com.vungle.publisher.image.AssetBitmapFactory", "members/com.vungle.publisher.image.AssetBitmapFactory", true, AssetBitmapFactory.class);
  }
  
  public final void attach(cy paramcy)
  {
    this.a = paramcy.a("android.content.Context", AssetBitmapFactory.class, getClass().getClassLoader());
    this.b = paramcy.a("members/com.vungle.publisher.image.BaseBitmapFactory", AssetBitmapFactory.class, getClass().getClassLoader(), false);
  }
  
  public final AssetBitmapFactory get()
  {
    AssetBitmapFactory localAssetBitmapFactory = new AssetBitmapFactory();
    injectMembers(localAssetBitmapFactory);
    return localAssetBitmapFactory;
  }
  
  public final void getDependencies(Set<cs<?>> paramSet1, Set<cs<?>> paramSet2)
  {
    paramSet2.add(this.a);
    paramSet2.add(this.b);
  }
  
  public final void injectMembers(AssetBitmapFactory paramAssetBitmapFactory)
  {
    paramAssetBitmapFactory.a = ((Context)this.a.get());
    this.b.injectMembers(paramAssetBitmapFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/image/AssetBitmapFactory$$InjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */