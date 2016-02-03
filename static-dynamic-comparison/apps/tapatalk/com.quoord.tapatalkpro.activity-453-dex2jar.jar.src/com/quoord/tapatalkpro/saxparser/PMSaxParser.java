package com.quoord.tapatalkpro.saxparser;

import android.app.Activity;
import com.quoord.tapatalkpro.util.Base64;
import com.quoord.xmlrpc.XmlRpcParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class PMSaxParser
        implements ContentHandler {
    private String currentResultText;
    private String currentTimeString = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(XmlRpcParser.DATETIME_FORMAT);
    private ICallback mCallback;
    private Activity mContext;
    private String mCurrentFieldName;
    private HashMap mCurrentPM = null;
    private String mCurrentType;
    private ArrayList<HashMap> mCurrentUsers = null;
    private Object mCurrentValue;
    private boolean mIsAddFinish = false;
    private boolean mIsEnterPM = false;
    private boolean mIsEnterToUsers = false;
    private boolean mIsName = false;
    private boolean mIsType = false;
    private boolean mIsValue = false;
    private int mLock = 0;
    private HashMap<String, Integer> mLocks = new HashMap();
    private Integer mTotalPMCount;
    private Integer mUnreadCount;
    private String pmContent;
    private String pmTitle;

    public PMSaxParser(Activity paramActivity) {
        this.mContext = paramActivity;
    }

    private void parseName(String paramString) {
        if (paramString.equals("list")) {
            this.mIsEnterPM = true;
            this.mIsEnterToUsers = false;
            return;
        }
        if (paramString.equals("msg_to")) {
            this.mIsEnterToUsers = true;
            this.mIsEnterPM = false;
            this.mCurrentUsers = new ArrayList();
            return;
        }
        this.mCurrentFieldName = paramString;
    }

    private void parseType(String paramString) {
        this.mCurrentType = paramString;
        this.mIsValue = true;
        this.mCurrentValue = null;
    }

    private void parseValue(String paramString) {
        if (this.mCurrentFieldName != null) {
            if (!this.mCurrentType.equals("int")) {
                break label35;
            }
            this.mCurrentValue = new Integer(paramString.trim());
        }
        label35:
        do {
            return;
            if (this.mCurrentType.equals("string")) {
                if (this.mCurrentValue == null) {
                    this.mCurrentValue = new String();
                }
                this.mCurrentValue = ((String) this.mCurrentValue + paramString);
                return;
            }
            if (this.mCurrentType.equals("base64")) {
                if (this.mCurrentValue == null) {
                    this.mCurrentValue = new String();
                }
                this.mCurrentValue = ((String) this.mCurrentValue + paramString);
                return;
            }
            if (this.mCurrentType.equals("boolean")) {
                this.mCurrentValue = new Boolean(paramString.trim().equals("1"));
                return;
            }
        } while (!this.mCurrentType.equals("dateTime.iso8601"));
        if (this.mCurrentValue == null) {
            this.mCurrentValue = new String();
        }
        this.mCurrentValue = ((String) this.mCurrentValue + paramString);
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        if ((paramArrayOfChar.equals("\n")) || (paramArrayOfChar.trim().length() == 0)) {
        }
        do {
            return;
            if (this.mIsName) {
                parseName(paramArrayOfChar.trim());
                return;
            }
        } while (!this.mIsValue);
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
        if ((this.mIsEnterPM) && (paramString2.equals("struct"))) {
            this.mIsAddFinish = false;
            if (this.mCallback != null) {
                if (this.pmContent != null) {
                    this.mCurrentPM.put("short_content", Base64.decodeFast(this.pmContent));
                }
                if (this.pmTitle != null) {
                    this.mCurrentPM.put("msg_subject", Base64.decodeFast(this.pmTitle));
                }
                if (this.currentTimeString != null) {
                    this.mCurrentPM.put("time_string", Base64.decodeFast(this.currentTimeString));
                }
                this.pmContent = null;
                this.currentTimeString = null;
                this.pmTitle = null;
                this.mCallback.onAddItem(this.mCurrentPM);
            }
            while (!this.mIsAddFinish) {
            }
        }
        do {
            do {
                do {
                    do {
                        do {
                            return;
                            if ((this.mIsEnterPM) && (paramString2.equals("array"))) {
                                this.mIsEnterPM = false;
                                return;
                            }
                            if ((this.currentResultText != null) && (this.currentResultText.length() > 0)) {
                                if (this.mCallback != null) {
                                    this.mCallback.onGetResultText(new String(Base64.decode(this.currentResultText)));
                                }
                                this.currentResultText = null;
                            }
                            if ((this.mIsEnterToUsers) && (paramString2.equals("array"))) {
                                if (this.mCurrentUsers.size() > 0) {
                                    this.mCurrentPM.put("msg_to", this.mCurrentUsers.toArray());
                                }
                                this.mIsEnterToUsers = false;
                                this.mIsEnterPM = true;
                            }
                        } while (!this.mIsValue);
                        this.mIsValue = false;
                        if (this.mCurrentFieldName.equals("result_text")) {
                            if (this.currentResultText == null) {
                                this.currentResultText = ((String) this.mCurrentValue);
                                return;
                            }
                            this.currentResultText += this.mCurrentValue;
                            return;
                        }
                        if (this.mIsEnterPM) {
                            if (this.mCurrentFieldName.equals("msg_id")) {
                                this.mCurrentPM.put("msg_id", this.mCurrentValue);
                                return;
                            }
                            if (this.mCurrentFieldName.equals("msg_state")) {
                                this.mCurrentPM.put("msg_state", this.mCurrentValue);
                                return;
                            }
                            if (this.mCurrentFieldName.equals("sent_date")) {
                                try {
                                    this.mCurrentPM.put("sent_date", (Date) this.dateFormat.parseObject((String) this.mCurrentValue));
                                    return;
                                } catch (ParseException paramString1) {
                                    paramString1.printStackTrace();
                                    return;
                                }
                            }
                            if (this.mCurrentFieldName.equals("msg_from")) {
                                this.mCurrentPM.put("msg_from", Base64.decodeFast((String) this.mCurrentValue));
                                return;
                            }
                            if (this.mCurrentFieldName.equals("msg_from_display_name")) {
                                this.mCurrentPM.put("msg_from_display_name", Base64.decodeFast((String) this.mCurrentValue));
                                return;
                            }
                            if (this.mCurrentFieldName.equals("msg_from_id")) {
                                this.mCurrentPM.put("msg_from_id", (String) this.mCurrentValue);
                            }
                            if (this.mCurrentFieldName.equals("msg_subject")) {
                                if (this.pmTitle == null) {
                                    this.pmTitle = ((String) this.mCurrentValue);
                                    return;
                                }
                                this.pmTitle += (String) this.mCurrentValue;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("time_string")) {
                                if (this.currentTimeString == null) {
                                    this.currentTimeString = ((String) this.mCurrentValue);
                                    return;
                                }
                                this.currentTimeString += (String) this.mCurrentValue;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("is_online")) {
                                this.mCurrentPM.put("is_online", this.mCurrentValue);
                                return;
                            }
                            if (this.mCurrentFieldName.equals("short_content")) {
                                if (this.pmContent == null) {
                                    this.pmContent = ((String) this.mCurrentValue);
                                    return;
                                }
                                this.pmContent += (String) this.mCurrentValue;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("icon_url")) {
                                if (this.mCurrentPM.get("icon_url") == null) {
                                    this.mCurrentPM.put("icon_url", this.mCurrentValue);
                                    return;
                                }
                                this.mCurrentPM.put("icon_url", (String) this.mCurrentPM.get("icon_url") + this.mCurrentValue);
                                return;
                            }
                        }
                        if (this.mIsEnterToUsers) {
                            if (this.mCurrentFieldName.equals("username")) {
                                ((HashMap) this.mCurrentUsers.get(this.mCurrentUsers.size() - 1)).put("username", Base64.decodeFast((String) this.mCurrentValue));
                                return;
                            }
                            if (this.mCurrentFieldName.equals("display_name")) {
                                ((HashMap) this.mCurrentUsers.get(this.mCurrentUsers.size() - 1)).put("display_name", Base64.decodeFast((String) this.mCurrentValue));
                                return;
                            }
                        }
                        if (!this.mCurrentFieldName.equals("total_unread_count")) {
                            break;
                        }
                    } while (this.mCurrentValue == null);
                    this.mUnreadCount = ((Integer) this.mCurrentValue);
                } while (this.mCallback == null);
                paramString1 = new HashMap();
                paramString1.put("total_unread_count", this.mUnreadCount);
                this.mCallback.onGetPMUnReadInfo(paramString1);
                return;
            } while ((!this.mCurrentFieldName.equals("total_message_count")) || (this.mCurrentValue == null));
            this.mTotalPMCount = ((Integer) this.mCurrentValue);
        } while (this.mCallback == null);
        paramString1 = new HashMap();
        paramString1.put("total_message_count", this.mTotalPMCount);
        this.mCallback.onGetPMInfo(paramString1);
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

    public void setIsAddFinished(boolean paramBoolean) {
        this.mIsAddFinish = paramBoolean;
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
            this.mIsName = true;
            this.mIsType = false;
            this.mIsValue = false;
        }
        do {
            return;
            if (paramString2.equals("value")) {
                this.mIsName = false;
                this.mIsType = true;
                this.mIsValue = false;
                return;
            }
            if ((this.mIsEnterPM) && (paramString2.equals("struct"))) {
                this.mCurrentPM = new HashMap();
            }
            if ((this.mIsEnterToUsers) && (paramString2.equals("struct"))) {
                this.mCurrentUsers.add(new HashMap());
            }
        } while (!this.mIsType);
        parseType(paramString2);
    }

    public void startPrefixMapping(String paramString1, String paramString2)
            throws SAXException {
    }

    /* Error */
    public void tryLock() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 78	com/quoord/tapatalkpro/saxparser/PMSaxParser:mLock	I
        //   6: ifgt +29 -> 35
        //   9: aload_0
        //   10: iconst_1
        //   11: putfield 78	com/quoord/tapatalkpro/saxparser/PMSaxParser:mLock	I
        //   14: aload_0
        //   15: getfield 83	com/quoord/tapatalkpro/saxparser/PMSaxParser:mLocks	Ljava/util/HashMap;
        //   18: invokestatic 312	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   21: invokevirtual 313	java/lang/Thread:toString	()Ljava/lang/String;
        //   24: iconst_1
        //   25: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   28: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   31: pop
        //   32: aload_0
        //   33: monitorexit
        //   34: return
        //   35: ldc2_w 317
        //   38: invokestatic 322	java/lang/Thread:sleep	(J)V
        //   41: goto -39 -> 2
        //   44: astore_1
        //   45: aload_1
        //   46: invokevirtual 323	java/lang/InterruptedException:printStackTrace	()V
        //   49: goto -47 -> 2
        //   52: astore_1
        //   53: aload_0
        //   54: monitorexit
        //   55: aload_1
        //   56: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	57	0	this	PMSaxParser
        //   44	2	1	localInterruptedException	InterruptedException
        //   52	4	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   35	41	44	java/lang/InterruptedException
        //   2	32	52	finally
        //   35	41	52	finally
        //   45	49	52	finally
    }

    public void unLock() {
        if (this.mLocks.containsKey(Thread.currentThread().toString())) {
            this.mLock = 0;
            this.mLocks.remove(Thread.currentThread().toString());
        }
    }

    public static abstract interface ICallback {
        public abstract void onAddItem(HashMap paramHashMap);

        public abstract void onDocBegin();

        public abstract void onDocEnd();

        public abstract void onGetPMInfo(HashMap paramHashMap);

        public abstract void onGetPMUnReadInfo(HashMap paramHashMap);

        public abstract void onGetResultText(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/saxparser/PMSaxParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */