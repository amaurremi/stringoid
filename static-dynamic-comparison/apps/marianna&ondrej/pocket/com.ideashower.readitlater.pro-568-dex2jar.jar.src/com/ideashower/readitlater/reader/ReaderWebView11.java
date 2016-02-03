package com.ideashower.readitlater.reader;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

@TargetApi(11)
public class ReaderWebView11
  extends ReaderWebView
{
  public ReaderWebView11(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReaderWebView11(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReaderWebView11(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ActionMode startActionMode(final ActionMode.Callback paramCallback)
  {
    super.startActionMode(new ActionMode.Callback()
    {
      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        return paramCallback.onActionItemClicked(paramAnonymousActionMode, paramAnonymousMenuItem);
      }
      
      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        ReaderWebView11.this.b.b(true);
        ReaderWebView11.this.setIsSelectingText(true);
        return paramCallback.onCreateActionMode(paramAnonymousActionMode, paramAnonymousMenu);
      }
      
      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
        paramCallback.onDestroyActionMode(paramAnonymousActionMode);
        ReaderWebView11.this.setIsSelectingText(false);
      }
      
      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        return paramCallback.onPrepareActionMode(paramAnonymousActionMode, paramAnonymousMenu);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/ReaderWebView11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */