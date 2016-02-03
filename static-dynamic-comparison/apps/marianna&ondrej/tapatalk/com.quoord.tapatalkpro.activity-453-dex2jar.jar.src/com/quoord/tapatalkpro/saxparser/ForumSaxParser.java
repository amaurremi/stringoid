package com.quoord.tapatalkpro.saxparser;

import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.Base64;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class ForumSaxParser
        implements ContentHandler {
    private String currentForumName;
    String currentName;
    private Forum currentParentForum;
    private String currentResultText;
    private ForumStatus forumStatus;
    private boolean isEnterPrefix = false;
    private ICallback mCallback;
    private String mCurrentFieldName;
    private Forum mCurrentForum;
    private String mCurrentType;
    private boolean mIsName = false;
    private boolean mIsType = false;
    private boolean mIsValue = false;
    private int maxLevel;

    public ForumSaxParser(ForumStatus paramForumStatus) {
        this.forumStatus = paramForumStatus;
    }

    private void parseName(String paramString) {
        if (paramString.equals("child")) {
            this.currentParentForum = this.mCurrentForum;
            return;
        }
        if (paramString.equals("prefixes")) {
            this.isEnterPrefix = true;
            return;
        }
        this.mCurrentFieldName = paramString;
    }

    private void parseType(String paramString) {
        this.mCurrentType = paramString;
        this.mIsValue = true;
    }

    private void parseValue(String paramString) {
        if (this.mCurrentFieldName != null) {
            if (!this.mCurrentFieldName.equals("result_text")) {
                break label58;
            }
            if (this.currentResultText != null) {
                break label32;
            }
            this.currentResultText = paramString;
        }
        label32:
        label58:
        do {
            do {
                return;
                this.currentResultText += paramString;
                return;
                if (!this.mCurrentFieldName.equals("forum_id")) {
                    break;
                }
            } while (!this.mCurrentType.equals("string"));
            if (this.mCurrentForum.getId() == null) {
                this.mCurrentForum.setId(paramString.trim());
                return;
            }
            this.mCurrentForum.setId(this.mCurrentForum.getId() + paramString.trim());
            return;
            if ((this.mCurrentFieldName.equals("new_post")) && (paramString.trim().equals("1")) && (!this.forumStatus.checkNewPost(this.mCurrentForum.getId()))) {
                this.forumStatus.addNewPostForForum(this.mCurrentForum.getId());
            }
            if (this.mCurrentFieldName.equals("forum_name")) {
                if (this.currentForumName == null) {
                }
                for (this.currentForumName = paramString; ; this.currentForumName += paramString) {
                    try {
                        this.mCurrentForum.setName(new String(Base64.decodeFast(this.currentForumName)));
                        return;
                    } catch (Exception paramString) {
                        return;
                    }
                }
            }
            if ((!this.mCurrentFieldName.equals("forum_name")) && (this.currentForumName != null)) {
                this.mCurrentForum.setName(new String(Base64.decodeFast(this.currentForumName)));
                this.currentForumName = null;
            }
            if (this.mCurrentFieldName.equals("sub_only")) {
                this.mCurrentForum.setSubOnly(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("is_protected")) {
                this.mCurrentForum.setProtected(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("logo_url")) {
                if (this.mCurrentForum.getLogoURL() == null) {
                    this.mCurrentForum.setLogoURL(paramString.trim());
                    return;
                }
                this.mCurrentForum.setLogoURL(this.mCurrentForum.getLogoURL() + paramString.trim());
                return;
            }
            if (this.mCurrentFieldName.equals("url")) {
                if (this.mCurrentForum.getUrl() == null) {
                    this.mCurrentForum.setUrl(paramString.trim());
                    return;
                }
                this.mCurrentForum.setUrl(this.mCurrentForum.getUrl() + paramString.trim());
                return;
            }
            if (this.mCurrentFieldName.equals("is_subscribed")) {
                this.mCurrentForum.setSubscribe(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("can_subscribe")) {
                this.mCurrentForum.setCanSubscribe(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
        } while (!this.mCurrentFieldName.equals("child"));
        this.currentParentForum = this.mCurrentForum;
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        if ((paramArrayOfChar.equals("\n")) || (paramArrayOfChar.trim().length() == 0)) {
        }
        do {
            return;
            if (this.mIsName) {
                if (this.currentName != null) {
                    this.currentName += paramArrayOfChar;
                    parseName(this.currentName.trim());
                    return;
                }
                this.currentName = paramArrayOfChar;
                parseName(paramArrayOfChar.trim());
                return;
            }
        } while ((!this.mIsValue) || (paramArrayOfChar.trim().length() <= 0));
        this.currentName = null;
        parseValue(paramArrayOfChar.trim());
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
            if (this.mCurrentForum.getParentForum() == null) {
                this.mCallback.onAddItem(this.mCurrentForum);
                this.currentParentForum = null;
            }
            this.mCallback.onFlattenAdd(this.mCurrentForum);
        }
        do {
            do {
                do {
                    return;
                    if ((this.currentResultText != null) && (this.currentResultText.length() > 0)) {
                        if (this.mCallback != null) {
                            this.mCallback.onGetResultText(new String(Base64.decodeFast(this.currentResultText)));
                        }
                        this.currentResultText = null;
                    }
                } while (!paramString2.equals("array"));
                if (this.isEnterPrefix) {
                    this.isEnterPrefix = false;
                    return;
                }
            } while (this.currentParentForum == null);
            this.mCurrentForum = this.currentParentForum;
        } while (this.mCurrentForum.getParentForum() == null);
        this.currentParentForum = this.mCurrentForum.getParentForum();
    }

    public void endPrefixMapping(String paramString)
            throws SAXException {
    }

    public int getMaxLevel() {
        return this.maxLevel;
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

    public void setIsAddFinished(boolean paramBoolean) {
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
        if (paramString2.equals("name")) {
            this.currentName = null;
            this.mIsName = true;
            this.mIsType = false;
        }
        do {
            for (; ; ) {
                return;
                if (paramString2.equals("value")) {
                    this.currentName = null;
                    this.mIsName = false;
                    this.mIsType = true;
                    return;
                }
                if (!paramString2.equals("struct")) {
                    break;
                }
                this.mCurrentForum = new Forum();
                if (this.currentParentForum != null) {
                    this.mCurrentForum.setLevel(this.currentParentForum.getLevel() + 1);
                    this.currentParentForum.addChildForum(this.mCurrentForum);
                    this.mCurrentForum.setParentForum(this.currentParentForum);
                }
                while (this.mCurrentForum.getLevel() > this.maxLevel) {
                    this.maxLevel = this.mCurrentForum.getLevel();
                    return;
                    this.mCurrentForum.setLevel(0);
                }
            }
        } while ((paramString2.equals("array")) || (!this.mIsType));
        parseType(paramString2);
    }

    public void startPrefixMapping(String paramString1, String paramString2)
            throws SAXException {
    }

    public static abstract interface ICallback {
        public abstract void onAddItem(Forum paramForum);

        public abstract void onDocBegin();

        public abstract void onDocEnd();

        public abstract void onFlattenAdd(Forum paramForum);

        public abstract void onGetResultText(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/saxparser/ForumSaxParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */