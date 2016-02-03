package com.quoord.tapatalkpro.saxparser;

import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.util.Base64;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class OnlineSaxParser
        implements ContentHandler {
    private String currentDisplayName;
    private String currentDisplaytext;
    private String currentName = null;
    private String currentUsername;
    private int level = 0;
    private ICallback mCallback;
    private String mCurrentFieldName;
    private User mCurrentUser = null;
    private boolean mIsEnterUser = false;
    private boolean mIsName = false;
    private boolean mIsType = false;
    private boolean mIsValue = false;

    private void parseName(String paramString) {
        if (paramString.equals("list")) {
            this.mIsEnterUser = true;
            return;
        }
        this.mCurrentFieldName = paramString;
    }

    private void parseType(String paramString) {
        this.mIsValue = true;
    }

    private void parseValue(String paramString) {
        int i;
        if (this.mCurrentFieldName != null) {
            if (!this.mCurrentFieldName.equals("member_count")) {
                break label45;
            }
            i = Integer.parseInt(paramString.trim());
            if (this.mCallback != null) {
                this.mCallback.onGetOnlineNum(i);
            }
        }
        label45:
        do {
            do {
                do {
                    return;
                    if (!this.mCurrentFieldName.equals("guest_count")) {
                        break;
                    }
                    i = Integer.parseInt(paramString.trim());
                } while (this.mCallback == null);
                this.mCallback.onGetGuestNum(i);
                return;
            } while (!this.mIsEnterUser);
            if (this.mCurrentFieldName.equals("icon_url")) {
                if (this.mCurrentUser.getIconUrl() == null) {
                    this.mCurrentUser.setIconUrl(paramString.trim().toString());
                    return;
                }
                this.mCurrentUser.setIconUrl(this.mCurrentUser.getIconUrl() + paramString.trim());
                return;
            }
            if (this.mCurrentFieldName.equals("user_name")) {
                if (this.currentUsername != null) {
                    this.currentUsername += paramString;
                    return;
                }
                this.currentUsername = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("display_text")) {
                if (this.currentDisplaytext != null) {
                    this.currentDisplaytext += paramString;
                    return;
                }
                this.currentDisplaytext = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("display_name")) {
                if (this.currentDisplayName != null) {
                    this.currentDisplayName += paramString;
                    return;
                }
                this.currentDisplayName = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("topic_id")) {
                this.mCurrentUser.setTopicId(paramString);
            }
        } while (!this.mCurrentFieldName.equals("user_id"));
        this.mCurrentUser.setId(paramString);
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        if (paramArrayOfChar.equals("\n")) {
        }
        do {
            return;
            if (this.mIsName) {
                if (this.currentName != null) {
                    this.currentName += paramArrayOfChar;
                    parseName(this.currentName);
                    return;
                }
                this.currentName = paramArrayOfChar;
                parseName(paramArrayOfChar);
                return;
            }
        } while (!this.mIsValue);
        parseValue(paramArrayOfChar);
    }

    public void endDocument()
            throws SAXException {
        if (this.mCallback != null) {
            this.mCallback.onDocEnd();
        }
    }

    public void endElement(String paramString1, String paramString2, String paramString3)
            throws SAXException {
        if (paramString2.equals("struct")) {
            this.level -= 1;
        }
        if ((this.mIsEnterUser) && (paramString2.equals("struct"))) {
            this.currentName = null;
            if (this.currentDisplaytext != null) {
                this.mCurrentUser.setDisplayText(new String(Base64.decode(this.currentDisplaytext)));
            }
            if (this.currentDisplayName != null) {
                this.mCurrentUser.setDisplay_name(new String(Base64.decode(this.currentDisplayName)));
            }
            if (this.currentUsername != null) {
                this.mCurrentUser.setName(new String(Base64.decodeFast(this.currentUsername)));
            }
            this.currentDisplaytext = null;
            this.currentDisplayName = null;
            this.currentUsername = null;
            if (this.mCallback != null) {
                this.mCallback.onAddItem(this.mCurrentUser);
            }
        }
        while ((!this.mIsEnterUser) || (!paramString2.equals("array")) || (this.level != 1)) {
            return;
        }
        this.mIsEnterUser = false;
    }

    public void endPrefixMapping(String paramString)
            throws SAXException {
    }

    public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
    }

    public void processingInstruction(String paramString1, String paramString2)
            throws SAXException {
    }

    public void setCallback(ICallback paramICallback) {
        this.mCallback = paramICallback;
    }

    public void setDocumentLocator(Locator paramLocator) {
    }

    public void skippedEntity(String paramString)
            throws SAXException {
    }

    public void startDocument()
            throws SAXException {
        if (this.mCallback != null) {
            this.mCallback.onDocBegin();
        }
    }

    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
            throws SAXException {
        if (paramString2.equals("struct")) {
            this.level += 1;
        }
        if (paramString2.equals("name")) {
            this.currentName = null;
            this.mIsName = true;
            this.mIsType = false;
        }
        do {
            return;
            if (paramString2.equals("value")) {
                this.currentName = null;
                this.mIsName = false;
                this.mIsType = true;
                return;
            }
            if ((this.mIsEnterUser) && (paramString2.equals("struct"))) {
                this.mCurrentUser = new User();
            }
        } while (!this.mIsType);
        parseType(paramString2);
    }

    public void startPrefixMapping(String paramString1, String paramString2)
            throws SAXException {
    }

    public static abstract interface ICallback {
        public abstract void onAddItem(User paramUser);

        public abstract void onDocBegin();

        public abstract void onDocEnd();

        public abstract void onGetGuestNum(int paramInt);

        public abstract void onGetOnlineNum(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/saxparser/OnlineSaxParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */