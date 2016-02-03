package mobi.ifunny.view;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;

public class PlainEditText
        extends EditTextEx {
    public PlainEditText(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public PlainEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public boolean onTextContextMenuItem(int paramInt) {
        int i = 0;
        boolean bool = super.onTextContextMenuItem(paramInt);
        switch (paramInt) {
        }
        do {
            return bool;
            localObject = getText();
        } while (localObject == null);
        Object localObject = new SpannableString((CharSequence) localObject);
        CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[]) ((Spannable) localObject).getSpans(0, ((Spannable) localObject).length(), CharacterStyle.class);
        int j = arrayOfCharacterStyle.length;
        paramInt = i;
        while (paramInt < j) {
            ((Spannable) localObject).removeSpan(arrayOfCharacterStyle[paramInt]);
            paramInt += 1;
        }
        setText((CharSequence) localObject);
        return bool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/PlainEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */