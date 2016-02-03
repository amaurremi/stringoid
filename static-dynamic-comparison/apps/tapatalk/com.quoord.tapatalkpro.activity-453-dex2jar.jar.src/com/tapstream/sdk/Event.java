package com.tapstream.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

public class Event {
    Map<String, Object> customFields = new HashMap();
    private String encodedName;
    private double firstFiredTime = 0.0D;
    private boolean isTransaction = false;
    private String name;
    private boolean oneTimeOnly;
    private StringBuilder postData = new StringBuilder();
    private String productSku;
    private String uid = makeUid();

    public Event(String paramString1, String paramString2, int paramInt) {
        this("", false);
        this.isTransaction = true;
        this.productSku = paramString2;
        addPair("", "purchase-transaction-id", paramString1, true);
        addPair("", "purchase-product-id", paramString2, true);
        addPair("", "purchase-quantity", Integer.valueOf(paramInt), true);
    }

    public Event(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {
        this("", false);
        this.isTransaction = true;
        this.productSku = paramString2;
        addPair("", "purchase-transaction-id", paramString1, true);
        addPair("", "purchase-product-id", paramString2, true);
        addPair("", "purchase-quantity", Integer.valueOf(paramInt1), true);
        addPair("", "purchase-price", Integer.valueOf(paramInt2), true);
        addPair("", "purchase-currency", paramString3, true);
    }

    public Event(String paramString1, String paramString2, String paramString3)
            throws JSONException {
        this("", false);
        this.isTransaction = true;
        paramString2 = new JSONObject(paramString2);
        Object localObject = new JSONObject(paramString1);
        this.productSku = ((JSONObject) localObject).getString("productId");
        localObject = ((JSONObject) localObject).getString("orderId");
        try {
            String str = paramString2.getString("price_currency_code");
            int i = (int) Math.round(paramString2.getInt("price_amount_micros") / 10000.0D);
            addPair("", "purchase-transaction-id", localObject, true);
            addPair("", "purchase-product-id", this.productSku, true);
            addPair("", "purchase-quantity", Integer.valueOf(1), true);
            addPair("", "purchase-price", Integer.valueOf(i), true);
            addPair("", "purchase-currency", str, true);
            paramString2 = new JSONObject();
            paramString2.put("purchase_data", paramString1);
            paramString2.put("signature", paramString3);
            addPair("", "receipt-body", paramString2.toString(), false);
            return;
        } catch (JSONException paramString2) {
            for (; ; ) {
                addPair("", "purchase-transaction-id", localObject, true);
                addPair("", "purchase-product-id", this.productSku, true);
                addPair("", "purchase-quantity", Integer.valueOf(1), true);
            }
        }
    }

    public Event(String paramString, boolean paramBoolean) {
        this.oneTimeOnly = paramBoolean;
        setName(paramString);
    }

    private String makeUid() {
        return String.format(Locale.US, "%d:%f", new Object[]{Long.valueOf(System.currentTimeMillis()), Double.valueOf(Math.random())});
    }

    public void addPair(String paramString, Object paramObject) {
        this.customFields.put(paramString, paramObject);
    }

    protected void addPair(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
        paramString1 = Utils.encodeEventPair(paramString1, paramString2, paramObject, paramBoolean);
        if (paramString1 != null) {
            this.postData.append("&");
            this.postData.append(paramString1);
        }
    }

    public String getEncodedName() {
        return this.encodedName;
    }

    public String getName() {
        return this.name;
    }

    public String getPostData() {
        if (this.postData != null) {
            return this.postData.toString();
        }
        return "";
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isOneTimeOnly() {
        return this.oneTimeOnly;
    }

    boolean isTransaction() {
        return this.isTransaction;
    }

    void prepare(Map<String, Object> paramMap) {
        if (this.firstFiredTime == 0.0D) {
            this.firstFiredTime = System.currentTimeMillis();
            paramMap = paramMap.entrySet().iterator();
            Map.Entry localEntry;
            while (paramMap.hasNext()) {
                localEntry = (Map.Entry) paramMap.next();
                if (!this.customFields.containsKey(localEntry.getKey())) {
                    this.customFields.put(localEntry.getKey(), localEntry.getValue());
                }
            }
            this.postData.append(String.format(Locale.US, "&created-ms=%.0f", new Object[]{Double.valueOf(this.firstFiredTime)}));
            paramMap = this.customFields.entrySet().iterator();
            while (paramMap.hasNext()) {
                localEntry = (Map.Entry) paramMap.next();
                addPair("custom-", (String) localEntry.getKey(), localEntry.getValue(), true);
            }
        }
    }

    void setName(String paramString) {
        this.name = paramString.toLowerCase().trim().replace(".", "_");
        try {
            this.encodedName = URLEncoder.encode(this.name, "UTF-8").replace("+", "%20");
            return;
        } catch (UnsupportedEncodingException paramString) {
            paramString.printStackTrace();
        }
    }

    void setNamePrefix(String paramString) {
        setName(String.format(Locale.US, "android-%s-purchase-%s", new Object[]{paramString, this.productSku}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */