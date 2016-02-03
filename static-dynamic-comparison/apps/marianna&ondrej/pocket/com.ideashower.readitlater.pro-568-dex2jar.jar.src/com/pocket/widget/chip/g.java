package com.pocket.widget.chip;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

class g
  extends InputConnectionWrapper
{
  public g(f paramf, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 == 0)) {
      f.b(this.a);
    }
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }
  
  public boolean performEditorAction(int paramInt)
  {
    if (paramInt == 6)
    {
      f.a(this.a, true);
      f.c(this.a);
    }
    return super.performEditorAction(paramInt);
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 67)) {
      f.b(this.a);
    }
    return super.sendKeyEvent(paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/chip/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */