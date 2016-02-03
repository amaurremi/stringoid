package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

class SearchViewCompatIcs
{
  public static class MySearchView
    extends SearchView
  {
    public MySearchView(Context paramContext)
    {
      super();
    }
    
    public void onActionViewCollapsed()
    {
      setQuery("", false);
      super.onActionViewCollapsed();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/SearchViewCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */