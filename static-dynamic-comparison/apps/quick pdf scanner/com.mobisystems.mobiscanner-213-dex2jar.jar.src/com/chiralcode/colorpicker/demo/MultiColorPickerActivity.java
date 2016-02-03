package com.chiralcode.colorpicker.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.chiralcode.colorpicker.MultiColorPicker;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;

public class MultiColorPickerActivity
  extends Activity
{
  private Button fu;
  private MultiColorPicker fy;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.act_multi_picker);
    this.fy = ((MultiColorPicker)findViewById(R.id.multiColorPicker));
    this.fu = ((Button)findViewById(R.id.button));
    this.fu.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = MultiColorPickerActivity.a(MultiColorPickerActivity.this).getColor();
        paramAnonymousView = "R: " + Color.red(i) + " B: " + Color.blue(i) + " G: " + Color.green(i);
        Toast.makeText(MultiColorPickerActivity.this, paramAnonymousView, 0).show();
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/chiralcode/colorpicker/demo/MultiColorPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */