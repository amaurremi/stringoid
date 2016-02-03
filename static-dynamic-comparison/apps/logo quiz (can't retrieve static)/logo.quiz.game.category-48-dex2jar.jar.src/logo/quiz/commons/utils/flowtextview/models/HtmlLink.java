package logo.quiz.commons.utils.flowtextview.models;

import android.text.TextPaint;

public class HtmlLink
  extends HtmlObject
{
  public float height;
  public String url;
  public float width;
  public float yOffset;
  
  public HtmlLink(String paramString1, int paramInt1, int paramInt2, float paramFloat, TextPaint paramTextPaint, String paramString2)
  {
    super(paramString1, paramInt1, paramInt2, paramFloat, paramTextPaint);
    this.url = paramString2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/flowtextview/models/HtmlLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */