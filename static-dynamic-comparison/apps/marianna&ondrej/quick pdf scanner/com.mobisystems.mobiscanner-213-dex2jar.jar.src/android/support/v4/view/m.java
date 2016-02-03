package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class m
{
  public static void a(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new a(paramTextView.getContext()));
  }
  
  private static class a
    extends SingleLineTransformationMethod
  {
    private Locale bB;
    
    public a(Context paramContext)
    {
      this.bB = paramContext.getResources().getConfiguration().locale;
    }
    
    public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      paramCharSequence = super.getTransformation(paramCharSequence, paramView);
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.bB);
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */