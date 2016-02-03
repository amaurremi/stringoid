package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

import java.lang.reflect.Method;

class m {
    private Method a;
    private Method b;
    private Method c;
    private Method d;

    m() {
        try {
            this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.a.setAccessible(true);
            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b.setAccessible(true);
                try {
                    this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                    this.c.setAccessible(true);
                    try {
                        this.d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                        this.d.setAccessible(true);
                        return;
                    } catch (NoSuchMethodException localNoSuchMethodException1) {
                    }
                } catch (NoSuchMethodException localNoSuchMethodException2) {
                    for (; ; ) {
                    }
                }
            } catch (NoSuchMethodException localNoSuchMethodException3) {
                for (; ; ) {
                }
            }
        } catch (NoSuchMethodException localNoSuchMethodException4) {
            for (; ; ) {
            }
        }
    }

    void a(InputMethodManager paramInputMethodManager, View paramView, int paramInt) {
        if (this.d != null) {
            try {
                this.d.invoke(paramInputMethodManager, new Object[]{Integer.valueOf(paramInt), null});
                return;
            } catch (Exception localException) {
            }
        }
        paramInputMethodManager.showSoftInput(paramView, paramInt);
    }

    void a(AutoCompleteTextView paramAutoCompleteTextView) {
        if (this.a != null) {
        }
        try {
            this.a.invoke(paramAutoCompleteTextView, new Object[0]);
            return;
        } catch (Exception paramAutoCompleteTextView) {
        }
    }

    void a(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean) {
        if (this.c != null) {
        }
        try {
            this.c.invoke(paramAutoCompleteTextView, new Object[]{Boolean.valueOf(paramBoolean)});
            return;
        } catch (Exception paramAutoCompleteTextView) {
        }
    }

    void b(AutoCompleteTextView paramAutoCompleteTextView) {
        if (this.b != null) {
        }
        try {
            this.b.invoke(paramAutoCompleteTextView, new Object[0]);
            return;
        } catch (Exception paramAutoCompleteTextView) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */