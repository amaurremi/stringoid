package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class h
  extends GLSurfaceView
{
  static String a = "GL2JNIView";
  final ag b;
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new i(this, this, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ah localah = this.b.a(paramInt1, paramInt2);
    setMeasuredDimension(localah.a, localah.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */