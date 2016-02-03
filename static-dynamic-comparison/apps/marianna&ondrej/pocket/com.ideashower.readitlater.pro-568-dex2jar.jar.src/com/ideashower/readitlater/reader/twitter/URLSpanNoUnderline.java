package com.ideashower.readitlater.reader.twitter;

import android.content.res.ColorStateList;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.widget.TextView;

public class URLSpanNoUnderline
  extends URLSpan
{
  private final TextView a;
  
  public URLSpanNoUnderline(String paramString, TextView paramTextView)
  {
    super(paramString);
    this.a = paramTextView;
  }
  
  public static void a(TextView paramTextView)
  {
    Spannable localSpannable = (Spannable)paramTextView.getText();
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannable.getSpans(0, localSpannable.length(), URLSpan.class);
    int j = arrayOfURLSpan.length;
    int i = 0;
    while (i < j)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      int k = localSpannable.getSpanStart(localURLSpan);
      int m = localSpannable.getSpanEnd(localURLSpan);
      localSpannable.removeSpan(localURLSpan);
      localSpannable.setSpan(new URLSpanNoUnderline(localURLSpan.getURL(), paramTextView), k, m, 0);
      i += 1;
    }
    paramTextView.setText(localSpannable);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.a.getLinkTextColors().getColorForState(this.a.getDrawableState(), 0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/twitter/URLSpanNoUnderline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */