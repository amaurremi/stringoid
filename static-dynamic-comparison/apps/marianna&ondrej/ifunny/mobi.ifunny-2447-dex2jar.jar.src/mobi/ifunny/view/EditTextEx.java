package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import mobi.ifunny.j;

public class EditTextEx
        extends EditText {
    public EditTextEx(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    public EditTextEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext, paramAttributeSet);
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_EditTextEx);
        int j = paramAttributeSet.getIndexCount();
        paramContext = null;
        int i = 0;
        if (i < j) {
            int k = paramAttributeSet.getIndex(i);
            switch (k) {
            }
            for (; ; ) {
                i += 1;
                break;
                paramContext = Typeface.createFromAsset(getContext().getAssets(), paramAttributeSet.getString(k));
            }
        }
        paramAttributeSet.recycle();
        if (paramContext != null) {
            setTypeface(paramContext);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
        InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
        int i = paramEditorInfo.imeOptions & 0xFF;
        if ((i & 0x6) != 0) {
            paramEditorInfo.imeOptions = (i ^ paramEditorInfo.imeOptions);
            paramEditorInfo.imeOptions |= 0x6;
        }
        if ((paramEditorInfo.imeOptions & 0x40000000) != 0) {
            paramEditorInfo.imeOptions &= 0xBFFFFFFF;
        }
        return localInputConnection;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        try {
            super.onMeasure(paramInt1, paramInt2);
            return;
        } catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
            Editable localEditable = getText();
            localEditable.clearSpans();
            setText(localEditable);
            super.onMeasure(paramInt1, paramInt2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/EditTextEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */