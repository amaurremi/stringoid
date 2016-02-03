package logo.quiz.commons.language;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bubble.mobile.language.support.LanguageSpinnerAdapter;
import java.util.Locale;
import logo.quiz.commons.R.layout;

public class LanguageSpinnerAdapterLogoQuiz
  extends LanguageSpinnerAdapter
{
  public LanguageSpinnerAdapterLogoQuiz(Activity paramActivity, Drawable[] paramArrayOfDrawable)
  {
    super(paramActivity, paramArrayOfDrawable);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.context.getLayoutInflater().inflate(R.layout.language_change_button, null, true);
      paramViewGroup = new ViewHolder();
      paramViewGroup.languageButton = ((Button)paramView);
      String str = this.context.getResources().getConfiguration().locale.getDisplayLanguage();
      if (str.length() > 1) {
        paramViewGroup.languageButton.setText(Character.toUpperCase(str.charAt(0)) + str.substring(1));
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.languageButton.setCompoundDrawablesWithIntrinsicBounds(this.names[paramInt], null, null, null);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  static class ViewHolder
  {
    public Button languageButton;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/language/LanguageSpinnerAdapterLogoQuiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */