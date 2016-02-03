package com.android.ex.chips;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListPopupWindow;
import android.widget.ListView;

@TargetApi(14)
public class EmailChipsEditTextView14
  extends a
  implements ActionMode.Callback
{
  private ListPopupWindow p;
  private ListPopupWindow q;
  
  public EmailChipsEditTextView14(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == n.a)
        {
          ((ListPopupWindow)paramAnonymousMessage.obj).dismiss();
          return;
        }
        super.handleMessage(paramAnonymousMessage);
      }
    };
    setCustomSelectionActionModeCallback(this);
    this.p = new ListPopupWindow(paramContext);
    this.q = new ListPopupWindow(paramContext);
  }
  
  protected void a()
  {
    if ((this.p != null) && (this.p.isShowing())) {
      this.p.dismiss();
    }
  }
  
  protected void a(ClipData paramClipData)
  {
    removeTextChangedListener(this.l);
    if ((paramClipData != null) && (paramClipData.getDescription().hasMimeType("text/plain")))
    {
      int i = 0;
      while (i < paramClipData.getItemCount())
      {
        a(paramClipData.getItemAt(i).getText());
        i += 1;
      }
    }
    this.g.post(this.n);
  }
  
  protected void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.p.setOnItemClickListener(null);
    a(this.f, ((x)paramAdapterView.getAdapter()).a(paramInt));
    paramAdapterView = Message.obtain(this.g, a);
    paramAdapterView.obj = this.p;
    this.g.sendMessageDelayed(paramAdapterView, 300L);
    clearComposingText();
  }
  
  protected void a(final z paramz, int paramInt, Context paramContext)
  {
    int i = a(getLayout().getLineForOffset(a(paramz)));
    this.q.setWidth(paramInt);
    this.q.setAnchorView(this);
    this.q.setVerticalOffset(i);
    this.q.setAdapter(b(paramz));
    this.q.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        EmailChipsEditTextView14.this.c(paramz);
        EmailChipsEditTextView14.a(EmailChipsEditTextView14.this).dismiss();
      }
    });
    this.q.show();
    paramz = this.q.getListView();
    paramz.setChoiceMode(1);
    paramz.setItemChecked(0, true);
  }
  
  protected void b()
  {
    a(((ClipboardManager)getContext().getSystemService("clipboard")).getPrimaryClip());
  }
  
  protected void e(z paramz)
  {
    String str = paramz.e().c();
    startDrag(ClipData.newPlainText(str, str + ','), new u(this, paramz), null, 0);
    d(paramz);
  }
  
  protected ListView getAlternatesListView()
  {
    return this.p.getListView();
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    case 2: 
    case 4: 
    default: 
      return false;
    case 1: 
      return paramDragEvent.getClipDescription().hasMimeType("text/plain");
    case 5: 
      requestFocus();
      return true;
    }
    a(paramDragEvent.getClipData());
    return true;
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/EmailChipsEditTextView14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */