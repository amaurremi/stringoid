package com.quoord.tapatalkpro.bean;

import android.text.Editable;
import android.text.Html.TagHandler;
import org.xml.sax.XMLReader;

public class MyTagHandler
        implements Html.TagHandler {
    boolean first = true;
    int index = 1;
    String parent = null;

    public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader) {
        if (paramString.equals("ul")) {
            this.parent = "ul";
        }
        for (; ; ) {
            if (paramString.equals("li")) {
                if (!this.parent.equals("ul")) {
                    break label82;
                }
                if (!this.first) {
                    break;
                }
                paramEditable.append("\n\t");
                this.first = false;
            }
            return;
            if (paramString.equals("ol")) {
                this.parent = "ol";
            }
        }
        this.first = true;
        return;
        label82:
        if (this.first) {
            paramEditable.append("\n\t" + this.index + ". ");
            this.first = false;
            this.index += 1;
            return;
        }
        this.first = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/MyTagHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */