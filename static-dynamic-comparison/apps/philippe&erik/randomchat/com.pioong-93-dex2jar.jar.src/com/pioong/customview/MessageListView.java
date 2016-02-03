package com.pioong.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MessageListView
  extends ListView
{
  public MessageListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    post(new Runnable()
    {
      public void run()
      {
        MessageListView.this.setSelection(MessageListView.this.getCount() - 1);
      }
    });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/customview/MessageListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */