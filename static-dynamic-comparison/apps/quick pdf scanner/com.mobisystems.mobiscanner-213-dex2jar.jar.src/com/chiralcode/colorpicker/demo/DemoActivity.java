package com.chiralcode.colorpicker.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.chiralcode.colorpicker.a;
import com.chiralcode.colorpicker.a.a;
import com.mobisystems.pdf.simpleViewer.R.layout;

public class DemoActivity
  extends ListActivity
{
  private String[] fw = { "Color picker view", "Color picker dialog", "Color picker preference", "Multi color picker view" };
  
  private void M(int paramInt)
  {
    Toast.makeText(this, "R: " + Color.red(paramInt) + " B: " + Color.blue(paramInt) + " G: " + Color.green(paramInt), 0).show();
  }
  
  private void ap()
  {
    new a(this, -1, new a.a()
    {
      public void onColorSelected(int paramAnonymousInt)
      {
        DemoActivity.a(DemoActivity.this, paramAnonymousInt);
      }
    }).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.act_demo);
    setListAdapter(new ArrayAdapter(this, 17367043, this.fw));
  }
  
  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      startActivity(new Intent(this, ColorPickerActivity.class));
      return;
    case 1: 
      ap();
      return;
    case 2: 
      startActivity(new Intent(this, PreferencesActivity.class));
      return;
    }
    startActivity(new Intent(this, MultiColorPickerActivity.class));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/chiralcode/colorpicker/demo/DemoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */