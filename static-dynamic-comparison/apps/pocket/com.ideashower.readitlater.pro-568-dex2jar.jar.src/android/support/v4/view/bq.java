package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class bq
  implements Comparator
{
  public int a(View paramView1, View paramView2)
  {
    paramView1 = (bk)paramView1.getLayoutParams();
    paramView2 = (bk)paramView2.getLayoutParams();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */