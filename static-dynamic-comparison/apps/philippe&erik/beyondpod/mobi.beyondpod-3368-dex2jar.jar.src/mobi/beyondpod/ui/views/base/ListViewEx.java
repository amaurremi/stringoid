package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewEx
  extends ListView
  implements AdapterView.OnItemClickListener
{
  public volatile boolean ViewIsScrolling = false;
  
  public ListViewEx(Context paramContext)
  {
    super(paramContext);
    InitializeView();
  }
  
  public ListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    InitializeView();
  }
  
  public ListViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    InitializeView();
  }
  
  public boolean CanScrollLeft()
  {
    return false;
  }
  
  public boolean CanScrollRight()
  {
    return false;
  }
  
  protected void InitializeView()
  {
    setOnItemClickListener(this);
  }
  
  protected void OnItemChecked(int paramInt)
  {
    Toast.makeText(getContext(), "Checked", 0).show();
  }
  
  protected void OnItemSelected(int paramInt)
  {
    Toast.makeText(getContext(), "Selected", 0).show();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (getChoiceMode() == 0)
    {
      OnItemSelected(paramInt);
      return;
    }
    OnItemChecked(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEmptyText(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/ListViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */