package com.quoord.tapatalkpro.util;

import android.text.Editable;
import android.text.Selection;
import android.widget.EditText;

public class InsertContent {
    public static final int IMATEXT = 1;
    public static final int URLTEXT = 0;
    private EditText content = null;
    private Editable editable = null;
    private String imgText = "[IMG][/IMG]";
    private int length = 0;
    private String urlText = "[URL][/URL]";

    public InsertContent(EditText paramEditText, int paramInt) {
        this.content = paramEditText;
        this.editable = this.content.getText();
        switch (paramInt) {
        }
        for (; ; ) {
            Selection.setSelection(this.editable, this.content.getSelectionStart() - 6);
            return;
            this.length = this.urlText.length();
            this.editable.insert(this.content.getSelectionStart(), this.urlText, 0, this.length);
            continue;
            this.length = this.imgText.length();
            this.editable.insert(this.content.getSelectionStart(), this.imgText, 0, this.length);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/InsertContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */