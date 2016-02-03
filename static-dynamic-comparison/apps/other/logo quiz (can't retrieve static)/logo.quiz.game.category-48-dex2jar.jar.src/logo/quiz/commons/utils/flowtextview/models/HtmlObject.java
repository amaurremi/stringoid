package logo.quiz.commons.utils.flowtextview.models;

import android.text.TextPaint;

public class HtmlObject
{
  public String content;
  public int end;
  public TextPaint paint;
  public boolean recycle = false;
  public int start;
  public float xOffset;
  
  public HtmlObject(String paramString, int paramInt1, int paramInt2, float paramFloat, TextPaint paramTextPaint)
  {
    this.content = paramString;
    this.start = paramInt1;
    this.end = paramInt2;
    this.xOffset = paramFloat;
    this.paint = paramTextPaint;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/models/HtmlObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */