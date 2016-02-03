package mobi.borken.android.brokenscreen.preference;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarPreference
  extends DialogPreference
  implements SeekBar.OnSeekBarChangeListener
{
  private static final String androidns = "http://schemas.android.com/apk/res/android";
  private Context mContext;
  private int mDefault;
  private String mDialogMessage;
  private int mMax;
  private SeekBar mSeekBar;
  private TextView mSplashText;
  private String mSuffix;
  private int mValue = 0;
  private TextView mValueText;
  
  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mDialogMessage = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "dialogMessage");
    this.mSuffix = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
    this.mDefault = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "defaultValue", 0);
    this.mMax = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 100);
  }
  
  public int getMax()
  {
    return this.mMax;
  }
  
  public int getProgress()
  {
    return this.mValue;
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    this.mSeekBar.setMax(this.mMax);
    this.mSeekBar.setProgress(this.mValue);
  }
  
  protected View onCreateDialogView()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(6, 6, 6, 6);
    this.mSplashText = new TextView(this.mContext);
    if (this.mDialogMessage != null) {
      this.mSplashText.setText(this.mDialogMessage);
    }
    localLinearLayout.addView(this.mSplashText);
    this.mValueText = new TextView(this.mContext);
    this.mValueText.setGravity(1);
    this.mValueText.setTextSize(32.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout.addView(this.mValueText, localLayoutParams);
    this.mSeekBar = new SeekBar(this.mContext);
    this.mSeekBar.setOnSeekBarChangeListener(this);
    localLinearLayout.addView(this.mSeekBar, new LinearLayout.LayoutParams(-1, -2));
    if (shouldPersist()) {
      this.mValue = getPersistedInt(this.mDefault);
    }
    this.mSeekBar.setMax(this.mMax);
    this.mSeekBar.setProgress(this.mValue);
    return localLinearLayout;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = String.valueOf(paramInt);
    TextView localTextView = this.mValueText;
    if (this.mSuffix == null) {}
    for (;;)
    {
      localTextView.setText(paramSeekBar);
      if (shouldPersist()) {
        persistInt(paramInt);
      }
      callChangeListener(new Integer(paramInt));
      return;
      paramSeekBar = paramSeekBar.concat(this.mSuffix);
    }
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    super.onSetInitialValue(paramBoolean, paramObject);
    if (paramBoolean)
    {
      if (shouldPersist()) {}
      for (int i = getPersistedInt(this.mDefault);; i = 0)
      {
        this.mValue = i;
        return;
      }
    }
    this.mValue = ((Integer)paramObject).intValue();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public void setMax(int paramInt)
  {
    this.mMax = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.mValue = paramInt;
    if (this.mSeekBar != null) {
      this.mSeekBar.setProgress(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/brokenscreen/preference/SeekBarPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */