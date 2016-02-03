package cmn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;

@TargetApi(11)
public class s
  extends w
{
  public final void a(Activity paramActivity)
  {
    paramActivity.getWindow().setFlags(16777216, 16777216);
  }
  
  public final void a(View paramView)
  {
    paramView.setLayerType(1, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */