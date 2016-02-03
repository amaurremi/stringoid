package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class cf
  implements Comparator<View>
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (bz)paramView1.getLayoutParams();
    paramView2 = (bz)paramView2.getLayoutParams();
    if (paramView1.a != paramView2.a)
    {
      if (paramView1.a) {
        return 1;
      }
      return -1;
    }
    return paramView1.e - paramView2.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */