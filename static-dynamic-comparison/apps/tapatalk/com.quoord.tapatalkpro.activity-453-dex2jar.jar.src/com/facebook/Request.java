package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {
    // todo keys in final fields whose usages I can't find
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIGRATION_BUNDLE_PARAM = "migration_bundle";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_VIDEOS = "me/videos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess = true;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private String restMethod;
    private Session session;

    public Request() {
        this(null, null, null, null, null);
    }

    public Request(Session paramSession, String paramString) {
        this(paramSession, paramString, null, null, null);
    }

    public Request(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod) {
        this(paramSession, paramString, paramBundle, paramHttpMethod, null);
    }

    public Request(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback) {
        this.session = paramSession;
        this.graphPath = paramString;
        this.callback = paramCallback;
        setHttpMethod(paramHttpMethod);
        if (paramBundle != null) {
        }
        for (this.parameters = new Bundle(paramBundle); ; this.parameters = new Bundle()) {
            if (!this.parameters.containsKey("migration_bundle")) {
                this.parameters.putString("migration_bundle", "fbsdk:20121026");
            }
            return;
        }
    }

    Request(Session paramSession, URL paramURL) {
        this.session = paramSession;
        this.overriddenURL = paramURL.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    private void addCommonParameters() {
        if (this.session != null) {
            if (!this.session.isOpened()) {
                throw new FacebookException("Session provided to a Request in un-opened state.");
            }
            if (!this.parameters.containsKey("access_token")) {
                String str = this.session.getAccessToken();
                Logger.registerAccessToken(str);
                this.parameters.putString("access_token", str);
            }
        }
        this.parameters.putString("sdk", "android");
        this.parameters.putString("format", "json");
    }

    private String appendParametersToBaseUrl(String paramString) {
        Uri.Builder localBuilder = new Uri.Builder().encodedPath(paramString);
        Iterator localIterator = this.parameters.keySet().iterator();
        do {
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    return localBuilder.toString();
                }
                String str = (String) localIterator.next();
                Object localObject = this.parameters.get(str);
                paramString = (String) localObject;
                if (localObject == null) {
                    paramString = "";
                }
                if (!isSupportedParameterType(paramString)) {
                    break;
                }
                localBuilder.appendQueryParameter(str, parameterToString(paramString).toString());
            }
        } while (this.httpMethod != HttpMethod.GET);
        throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", new Object[]{paramString.getClass().getSimpleName()}));
    }

    static HttpURLConnection createConnection(URL paramURL)
            throws IOException {
        paramURL = (HttpURLConnection) paramURL.openConnection();
        paramURL.setRequestProperty("User-Agent", getUserAgent());
        paramURL.setRequestProperty("Content-Type", getMimeContentType());
        paramURL.setChunkedStreamingMode(0);
        return paramURL;
    }

    public static Response executeAndWait(Request paramRequest) {
        paramRequest = executeBatchAndWait(new Request[]{paramRequest});
        if ((paramRequest == null) || (paramRequest.size() != 1)) {
            throw new FacebookException("invalid state: expected a single response");
        }
        return (Response) paramRequest.get(0);
    }

    public static List<Response> executeBatchAndWait(RequestBatch paramRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(paramRequestBatch, "requests");
        try {
            HttpURLConnection localHttpURLConnection = toHttpConnection(paramRequestBatch);
            return executeConnectionAndWait(localHttpURLConnection, paramRequestBatch);
        } catch (Exception localException) {
            List localList = Response.constructErrorResponses(paramRequestBatch.getRequests(), null, new FacebookException(localException));
            runCallbacks(paramRequestBatch, localList);
            return localList;
        }
    }

    public static List<Response> executeBatchAndWait(Collection<Request> paramCollection) {
        return executeBatchAndWait(new RequestBatch(paramCollection));
    }

    public static List<Response> executeBatchAndWait(Request... paramVarArgs) {
        Validate.notNull(paramVarArgs, "requests");
        return executeBatchAndWait(Arrays.asList(paramVarArgs));
    }

    public static RequestAsyncTask executeBatchAsync(RequestBatch paramRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(paramRequestBatch, "requests");
        paramRequestBatch = new RequestAsyncTask(paramRequestBatch);
        paramRequestBatch.executeOnSettingsExecutor();
        return paramRequestBatch;
    }

    public static RequestAsyncTask executeBatchAsync(Collection<Request> paramCollection) {
        return executeBatchAsync(new RequestBatch(paramCollection));
    }

    public static RequestAsyncTask executeBatchAsync(Request... paramVarArgs) {
        Validate.notNull(paramVarArgs, "requests");
        return executeBatchAsync(Arrays.asList(paramVarArgs));
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch) {
        List localList = Response.fromHttpConnection(paramHttpURLConnection, paramRequestBatch);
        Utility.disconnectQuietly(paramHttpURLConnection);
        int i = paramRequestBatch.size();
        if (i != localList.size()) {
            throw new FacebookException(String.format("Received %d responses while expecting %d", new Object[]{Integer.valueOf(localList.size()), Integer.valueOf(i)}));
        }
        runCallbacks(paramRequestBatch, localList);
        paramHttpURLConnection = new HashSet();
        paramRequestBatch = paramRequestBatch.iterator();
        if (!paramRequestBatch.hasNext()) {
            paramHttpURLConnection = paramHttpURLConnection.iterator();
        }
        for (; ; ) {
            if (!paramHttpURLConnection.hasNext()) {
                return localList;
                Request localRequest = (Request) paramRequestBatch.next();
                if (localRequest.session == null) {
                    break;
                }
                paramHttpURLConnection.add(localRequest.session);
                break;
            }
            ((Session) paramHttpURLConnection.next()).extendAccessTokenIfNeeded();
        }
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection<Request> paramCollection) {
        return executeConnectionAndWait(paramHttpURLConnection, new RequestBatch(paramCollection));
    }

    public static RequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch) {
        Validate.notNull(paramHttpURLConnection, "connection");
        paramHttpURLConnection = new RequestAsyncTask(paramHttpURLConnection, paramRequestBatch);
        paramRequestBatch.setCallbackHandler(paramHandler);
        paramHttpURLConnection.executeOnSettingsExecutor();
        return paramHttpURLConnection;
    }

    public static RequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch) {
        return executeConnectionAsync(null, paramHttpURLConnection, paramRequestBatch);
    }

    public static RequestAsyncTask executeGraphPathRequestAsync(Session paramSession, String paramString, Callback paramCallback) {
        return newGraphPathRequest(paramSession, paramString, paramCallback).executeAsync();
    }

    public static RequestAsyncTask executeMeRequestAsync(Session paramSession, GraphUserCallback paramGraphUserCallback) {
        return newMeRequest(paramSession, paramGraphUserCallback).executeAsync();
    }

    public static RequestAsyncTask executeMyFriendsRequestAsync(Session paramSession, GraphUserListCallback paramGraphUserListCallback) {
        return newMyFriendsRequest(paramSession, paramGraphUserListCallback).executeAsync();
    }

    public static RequestAsyncTask executePlacesSearchRequestAsync(Session paramSession, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphPlaceListCallback paramGraphPlaceListCallback) {
        return newPlacesSearchRequest(paramSession, paramLocation, paramInt1, paramInt2, paramString, paramGraphPlaceListCallback).executeAsync();
    }

    public static RequestAsyncTask executePostRequestAsync(Session paramSession, String paramString, GraphObject paramGraphObject, Callback paramCallback) {
        return newPostRequest(paramSession, paramString, paramGraphObject, paramCallback).executeAsync();
    }

    public static RequestAsyncTask executeRestRequestAsync(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod) {
        return newRestRequest(paramSession, paramString, paramBundle, paramHttpMethod).executeAsync();
    }

    public static RequestAsyncTask executeStatusUpdateRequestAsync(Session paramSession, String paramString, Callback paramCallback) {
        return newStatusUpdateRequest(paramSession, paramString, paramCallback).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session paramSession, Bitmap paramBitmap, Callback paramCallback) {
        return newUploadPhotoRequest(paramSession, paramBitmap, paramCallback).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session paramSession, File paramFile, Callback paramCallback)
            throws FileNotFoundException {
        return newUploadPhotoRequest(paramSession, paramFile, paramCallback).executeAsync();
    }

    private static String getBatchAppId(RequestBatch paramRequestBatch) {
        if (!Utility.isNullOrEmpty(paramRequestBatch.getBatchApplicationId())) {
            return paramRequestBatch.getBatchApplicationId();
        }
        paramRequestBatch = paramRequestBatch.iterator();
        Session localSession;
        do {
            if (!paramRequestBatch.hasNext()) {
                return defaultBatchApplicationId;
            }
            localSession = ((Request) paramRequestBatch.next()).session;
        } while (localSession == null);
        return localSession.getApplicationId();
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{"3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"});
    }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", new Object[]{"FBAndroidSDK", "3.0.1"});
        }
        return userAgent;
    }

    private static boolean isSupportedAttachmentType(Object paramObject) {
        return ((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof ParcelFileDescriptor));
    }

    private static boolean isSupportedParameterType(Object paramObject) {
        return ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date));
    }

    public static Request newGraphPathRequest(Session paramSession, String paramString, Callback paramCallback) {
        return new Request(paramSession, paramString, null, null, paramCallback);
    }

    public static Request newMeRequest(Session paramSession, GraphUserCallback paramGraphUserCallback) {
        new Request(paramSession, "me", null, null, new Callback() {
            public void onCompleted(Response paramAnonymousResponse) {
                if (Request.this != null) {
                    Request.this.onCompleted((GraphUser) paramAnonymousResponse.getGraphObjectAs(GraphUser.class), paramAnonymousResponse);
                }
            }
        });
    }

    public static Request newMyFriendsRequest(Session paramSession, GraphUserListCallback paramGraphUserListCallback) {
        new Request(paramSession, "me/friends", null, null, new Callback() {
            public void onCompleted(Response paramAnonymousResponse) {
                if (Request.this != null) {
                    Request.this.onCompleted(Request.typedListFromResponse(paramAnonymousResponse, GraphUser.class), paramAnonymousResponse);
                }
            }
        });
    }

    public static Request newPlacesSearchRequest(Session paramSession, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphPlaceListCallback paramGraphPlaceListCallback) {
        if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString))) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle localBundle = new Bundle(5);
        localBundle.putString("type", "place");
        localBundle.putInt("limit", paramInt2);
        if (paramLocation != null) {
            localBundle.putString("center", String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude())}));
            localBundle.putInt("distance", paramInt1);
        }
        if (!Utility.isNullOrEmpty(paramString)) {
            localBundle.putString("q", paramString);
        }
        paramLocation = new Callback() {
            public void onCompleted(Response paramAnonymousResponse) {
                if (Request.this != null) {
                    Request.this.onCompleted(Request.typedListFromResponse(paramAnonymousResponse, GraphPlace.class), paramAnonymousResponse);
                }
            }
        };
        return new Request(paramSession, "search", localBundle, HttpMethod.GET, paramLocation);
    }

    public static Request newPostRequest(Session paramSession, String paramString, GraphObject paramGraphObject, Callback paramCallback) {
        paramSession = new Request(paramSession, paramString, null, HttpMethod.POST, paramCallback);
        paramSession.setGraphObject(paramGraphObject);
        return paramSession;
    }

    public static Request newRestRequest(Session paramSession, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod) {
        paramSession = new Request(paramSession, null, paramBundle, paramHttpMethod);
        paramSession.setRestMethod(paramString);
        return paramSession;
    }

    public static Request newStatusUpdateRequest(Session paramSession, String paramString, Callback paramCallback) {
        Bundle localBundle = new Bundle();
        localBundle.putString("message", paramString);
        return new Request(paramSession, "me/feed", localBundle, HttpMethod.POST, paramCallback);
    }

    public static Request newUploadPhotoRequest(Session paramSession, Bitmap paramBitmap, Callback paramCallback) {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("picture", paramBitmap);
        return new Request(paramSession, "me/photos", localBundle, HttpMethod.POST, paramCallback);
    }

    public static Request newUploadPhotoRequest(Session paramSession, File paramFile, Callback paramCallback)
            throws FileNotFoundException {
        paramFile = ParcelFileDescriptor.open(paramFile, 268435456);
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("picture", paramFile);
        return new Request(paramSession, "me/photos", localBundle, HttpMethod.POST, paramCallback);
    }

    public static Request newUploadVideoRequest(Session paramSession, File paramFile, Callback paramCallback)
            throws FileNotFoundException {
        ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.open(paramFile, 268435456);
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable(paramFile.getName(), localParcelFileDescriptor);
        return new Request(paramSession, "me/videos", localBundle, HttpMethod.POST, paramCallback);
    }

    private static String parameterToString(Object paramObject) {
        if ((paramObject instanceof String)) {
            return (String) paramObject;
        }
        if (((paramObject instanceof Boolean)) || ((paramObject instanceof Number))) {
            return paramObject.toString();
        }
        if ((paramObject instanceof Date)) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    private static void processGraphObject(GraphObject paramGraphObject, String paramString, KeyValueSerializer paramKeyValueSerializer)
            throws IOException {
        int i = 0;
        if ((paramString.startsWith("me/")) || (paramString.startsWith("/me/"))) {
            i = paramString.indexOf(":");
            int j = paramString.indexOf("?");
            if ((i <= 3) || ((j != -1) && (i >= j))) {
                break label85;
            }
        }
        label85:
        for (i = 1; ; i = 0) {
            paramGraphObject = paramGraphObject.asMap().entrySet().iterator();
            if (paramGraphObject.hasNext()) {
                break;
            }
            return;
        }
        paramString = (Map.Entry) paramGraphObject.next();
        if ((i != 0) && (((String) paramString.getKey()).equalsIgnoreCase("image"))) {
        }
        for (boolean bool = true; ; bool = false) {
            processGraphObjectProperty((String) paramString.getKey(), paramString.getValue(), paramKeyValueSerializer, bool);
            break;
        }
    }

    private static void processGraphObjectProperty(String paramString, Object paramObject, KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
            throws IOException {
        Class localClass = paramObject.getClass();
        Object localObject2;
        Object localObject1;
        if (GraphObject.class.isAssignableFrom(localClass)) {
            localObject2 = ((GraphObject) paramObject).getInnerJSONObject();
            localObject1 = localObject2.getClass();
            if (!JSONObject.class.isAssignableFrom((Class) localObject1)) {
                break label205;
            }
            paramObject = (JSONObject) localObject2;
            if (!paramBoolean) {
                break label157;
            }
            localObject1 = ((JSONObject) paramObject).keys();
            label62:
            if (((Iterator) localObject1).hasNext()) {
                break label112;
            }
        }
        label112:
        label157:
        label205:
        label280:
        do {
            for (; ; ) {
                return;
                localObject1 = localClass;
                localObject2 = paramObject;
                if (!GraphObjectList.class.isAssignableFrom(localClass)) {
                    break;
                }
                localObject2 = ((GraphObjectList) paramObject).getInnerJSONArray();
                localObject1 = localObject2.getClass();
                break;
                localObject2 = (String) ((Iterator) localObject1).next();
                processGraphObjectProperty(String.format("%s[%s]", new Object[]{paramString, localObject2}), ((JSONObject) paramObject).opt((String) localObject2), paramKeyValueSerializer, paramBoolean);
                break label62;
                if (((JSONObject) paramObject).has("id")) {
                    processGraphObjectProperty(paramString, ((JSONObject) paramObject).optString("id"), paramKeyValueSerializer, paramBoolean);
                    return;
                }
                if (((JSONObject) paramObject).has("url")) {
                    processGraphObjectProperty(paramString, ((JSONObject) paramObject).optString("url"), paramKeyValueSerializer, paramBoolean);
                    return;
                    if (!JSONArray.class.isAssignableFrom((Class) localObject1)) {
                        break label280;
                    }
                    paramObject = (JSONArray) localObject2;
                    int j = ((JSONArray) paramObject).length();
                    int i = 0;
                    while (i < j) {
                        processGraphObjectProperty(String.format("%s[%d]", new Object[]{paramString, Integer.valueOf(i)}), ((JSONArray) paramObject).opt(i), paramKeyValueSerializer, paramBoolean);
                        i += 1;
                    }
                }
            }
            if ((String.class.isAssignableFrom((Class) localObject1)) || (Number.class.isAssignableFrom((Class) localObject1)) || (Boolean.class.isAssignableFrom((Class) localObject1))) {
                paramKeyValueSerializer.writeString(paramString, localObject2.toString());
                return;
            }
        } while (!Date.class.isAssignableFrom((Class) localObject1));
        paramObject = (Date) localObject2;
        paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) paramObject));
    }

    static void runCallbacks(final RequestBatch paramRequestBatch, List<Response> paramList) {
        int j = paramRequestBatch.size();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                if (localArrayList.size() > 0) {
                    paramList = new Runnable() {
                        public void run() {
                            Iterator localIterator = Request.this.iterator();
                            if (!localIterator.hasNext()) {
                                localIterator = paramRequestBatch.getCallbacks().iterator();
                            }
                            for (; ; ) {
                                if (!localIterator.hasNext()) {
                                    return;
                                    Pair localPair = (Pair) localIterator.next();
                                    ((Request.Callback) localPair.first).onCompleted((Response) localPair.second);
                                    break;
                                }
                                ((RequestBatch.Callback) localIterator.next()).onBatchCompleted(paramRequestBatch);
                            }
                        }
                    };
                    paramRequestBatch = paramRequestBatch.getCallbackHandler();
                    if (paramRequestBatch != null) {
                        break;
                    }
                    paramList.run();
                }
                return;
            }
            Request localRequest = paramRequestBatch.get(i);
            if (localRequest.callback != null) {
                localArrayList.add(new Pair(localRequest.callback, (Response) paramList.get(i)));
            }
            i += 1;
        }
        paramRequestBatch.post(paramList);
    }

    private static void serializeAttachments(Bundle paramBundle, Serializer paramSerializer)
            throws IOException {
        Iterator localIterator = paramBundle.keySet().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            String str = (String) localIterator.next();
            Object localObject = paramBundle.get(str);
            if (isSupportedAttachmentType(localObject)) {
                paramSerializer.writeObject(str, localObject);
            }
        }
    }

    private static void serializeParameters(Bundle paramBundle, Serializer paramSerializer)
            throws IOException {
        Iterator localIterator = paramBundle.keySet().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            String str = (String) localIterator.next();
            Object localObject = paramBundle.get(str);
            if (isSupportedParameterType(localObject)) {
                paramSerializer.writeObject(str, localObject);
            }
        }
    }

    private static void serializeRequestsAsJSON(Serializer paramSerializer, Collection<Request> paramCollection, Bundle paramBundle)
            throws JSONException, IOException {
        JSONArray localJSONArray = new JSONArray();
        paramCollection = paramCollection.iterator();
        for (; ; ) {
            if (!paramCollection.hasNext()) {
                paramSerializer.writeString("batch", localJSONArray.toString());
                return;
            }
            ((Request) paramCollection.next()).serializeToBatch(localJSONArray, paramBundle);
        }
    }

    private void serializeToBatch(JSONArray paramJSONArray, final Bundle paramBundle)
            throws JSONException, IOException {
        JSONObject localJSONObject = new JSONObject();
        if (this.batchEntryName != null) {
            localJSONObject.put("name", this.batchEntryName);
            localJSONObject.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            localJSONObject.put("depends_on", this.batchEntryDependsOn);
        }
        String str1 = getUrlForBatchedRequest();
        localJSONObject.put("relative_url", str1);
        localJSONObject.put("method", this.httpMethod);
        if (this.session != null) {
            Logger.registerAccessToken(this.session.getAccessToken());
        }
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.parameters.keySet().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                if (!localArrayList.isEmpty()) {
                    localJSONObject.put("attached_files", TextUtils.join(",", localArrayList));
                }
                if (this.graphObject != null) {
                    paramBundle = new ArrayList();
                    processGraphObject(this.graphObject, str1, new KeyValueSerializer() {
                        public void writeString(String paramAnonymousString1, String paramAnonymousString2)
                                throws IOException {
                            paramBundle.add(String.format("%s=%s", new Object[]{paramAnonymousString1, URLEncoder.encode(paramAnonymousString2, "UTF-8")}));
                        }
                    });
                    localJSONObject.put("body", TextUtils.join("&", paramBundle));
                }
                paramJSONArray.put(localJSONObject);
                return;
            }
            Object localObject = (String) localIterator.next();
            localObject = this.parameters.get((String) localObject);
            if (isSupportedAttachmentType(localObject)) {
                String str2 = String.format("%s%d", new Object[]{"file", Integer.valueOf(paramBundle.size())});
                localArrayList.add(str2);
                Utility.putObjectInBundle(paramBundle, str2, localObject);
            }
        }
    }

    static final void serializeToUrlConnection(RequestBatch paramRequestBatch, HttpURLConnection paramHttpURLConnection)
            throws IOException, JSONException {
        int i = 0;
        Logger localLogger = new Logger(LoggingBehavior.REQUESTS, "Request");
        int j = paramRequestBatch.size();
        if (j == 1) {
        }
        Object localObject2;
        for (Object localObject1 = paramRequestBatch.get(0).httpMethod; ; localObject1 = HttpMethod.POST) {
            paramHttpURLConnection.setRequestMethod(((HttpMethod) localObject1).name());
            localObject2 = paramHttpURLConnection.getURL();
            localLogger.append("Request:\n");
            localLogger.appendKeyValue("Id", paramRequestBatch.getId());
            localLogger.appendKeyValue("URL", localObject2);
            localLogger.appendKeyValue("Method", paramHttpURLConnection.getRequestMethod());
            localLogger.appendKeyValue("User-Agent", paramHttpURLConnection.getRequestProperty("User-Agent"));
            localLogger.appendKeyValue("Content-Type", paramHttpURLConnection.getRequestProperty("Content-Type"));
            paramHttpURLConnection.setConnectTimeout(paramRequestBatch.getTimeout());
            paramHttpURLConnection.setReadTimeout(paramRequestBatch.getTimeout());
            if (localObject1 == HttpMethod.POST) {
                i = 1;
            }
            if (i != 0) {
                break;
            }
            localLogger.log();
            return;
        }
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
        for (; ; ) {
            try {
                localObject1 = new Serializer(paramHttpURLConnection, localLogger);
                if (j == 1) {
                    paramRequestBatch = paramRequestBatch.get(0);
                    localLogger.append("  Parameters:\n");
                    serializeParameters(paramRequestBatch.parameters, (Serializer) localObject1);
                    localLogger.append("  Attachments:\n");
                    serializeAttachments(paramRequestBatch.parameters, (Serializer) localObject1);
                    if (paramRequestBatch.graphObject != null) {
                        processGraphObject(paramRequestBatch.graphObject, ((URL) localObject2).getPath(), (KeyValueSerializer) localObject1);
                    }
                    paramHttpURLConnection.close();
                    return;
                }
                localObject2 = getBatchAppId(paramRequestBatch);
                if (Utility.isNullOrEmpty((String) localObject2)) {
                    throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
                }
            } finally {
                paramHttpURLConnection.close();
            }
            ((Serializer) localObject1).writeString("batch_app_id", (String) localObject2);
            localObject2 = new Bundle();
            serializeRequestsAsJSON((Serializer) localObject1, paramRequestBatch, (Bundle) localObject2);
            localLogger.append("  Attachments:\n");
            serializeAttachments((Bundle) localObject2, (Serializer) localObject1);
        }
    }

    public static final void setDefaultBatchApplicationId(String paramString) {
        defaultBatchApplicationId = paramString;
    }

    public static HttpURLConnection toHttpConnection(RequestBatch paramRequestBatch) {
        Object localObject = paramRequestBatch.iterator();
        if (!((Iterator) localObject).hasNext()) {
        }
        for (; ; ) {
            try {
                if (paramRequestBatch.size() == 1) {
                    localObject = new URL(paramRequestBatch.get(0).getUrlForSingleRequest());
                }
            } catch (MalformedURLException paramRequestBatch) {
                throw new FacebookException("could not construct URL for request", paramRequestBatch);
            }
            try {
                localObject = createConnection((URL) localObject);
                serializeToUrlConnection(paramRequestBatch, (HttpURLConnection) localObject);
                return (HttpURLConnection) localObject;
            } catch (IOException paramRequestBatch) {
                throw new FacebookException("could not construct request body", paramRequestBatch);
            } catch (JSONException paramRequestBatch) {
                throw new FacebookException("could not construct request body", paramRequestBatch);
            }
            ((Request) ((Iterator) localObject).next()).validate();
            break;
            localObject = new URL("https://graph.facebook.com");
        }
    }

    public static HttpURLConnection toHttpConnection(Collection<Request> paramCollection) {
        Validate.notEmptyAndContainsNoNulls(paramCollection, "requests");
        return toHttpConnection(new RequestBatch(paramCollection));
    }

    public static HttpURLConnection toHttpConnection(Request... paramVarArgs) {
        return toHttpConnection(Arrays.asList(paramVarArgs));
    }

    private static <T extends GraphObject> List<T> typedListFromResponse(Response paramResponse, Class<T> paramClass) {
        paramResponse = (GraphMultiResult) paramResponse.getGraphObjectAs(GraphMultiResult.class);
        if (paramResponse == null) {
        }
        do {
            return null;
            paramResponse = paramResponse.getData();
        } while (paramResponse == null);
        return paramResponse.castToListOf(paramClass);
    }

    private void validate() {
        if ((this.graphPath != null) && (this.restMethod != null)) {
            throw new IllegalArgumentException("Only one of a graph path or REST method may be specified per request.");
        }
    }

    public final Response executeAndWait() {
        return executeAndWait(this);
    }

    public final RequestAsyncTask executeAsync() {
        return executeBatchAsync(new Request[]{this});
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final String getRestMethod() {
        return this.restMethod;
    }

    public final Session getSession() {
        return this.session;
    }

    final String getUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        if (this.restMethod != null) {
        }
        for (String str = "method/" + this.restMethod; ; str = this.graphPath) {
            addCommonParameters();
            return appendParametersToBaseUrl(str);
        }
    }

    final String getUrlForSingleRequest() {
        if (this.overriddenURL != null) {
            return this.overriddenURL.toString();
        }
        if (this.restMethod != null) {
        }
        for (String str = "https://api.facebook.com/method/" + this.restMethod; ; str = "https://graph.facebook.com/" + this.graphPath) {
            addCommonParameters();
            return appendParametersToBaseUrl(str);
        }
    }

    public final void setBatchEntryDependsOn(String paramString) {
        this.batchEntryDependsOn = paramString;
    }

    public final void setBatchEntryName(String paramString) {
        this.batchEntryName = paramString;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean paramBoolean) {
        this.batchEntryOmitResultOnSuccess = paramBoolean;
    }

    public final void setCallback(Callback paramCallback) {
        this.callback = paramCallback;
    }

    public final void setGraphObject(GraphObject paramGraphObject) {
        this.graphObject = paramGraphObject;
    }

    public final void setGraphPath(String paramString) {
        this.graphPath = paramString;
    }

    public final void setHttpMethod(HttpMethod paramHttpMethod) {
        if ((this.overriddenURL != null) && (paramHttpMethod != HttpMethod.GET)) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (paramHttpMethod != null) {
        }
        for (; ; ) {
            this.httpMethod = paramHttpMethod;
            return;
            paramHttpMethod = HttpMethod.GET;
        }
    }

    public final void setParameters(Bundle paramBundle) {
        this.parameters = paramBundle;
    }

    public final void setRestMethod(String paramString) {
        this.restMethod = paramString;
    }

    public final void setSession(Session paramSession) {
        this.session = paramSession;
    }

    public String toString() {
        return "{Request: " + " session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", restMethod: " + this.restMethod + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
    }

    public static abstract interface Callback {
        public abstract void onCompleted(Response paramResponse);
    }

    public static abstract interface GraphPlaceListCallback {
        public abstract void onCompleted(List<GraphPlace> paramList, Response paramResponse);
    }

    public static abstract interface GraphUserCallback {
        public abstract void onCompleted(GraphUser paramGraphUser, Response paramResponse);
    }

    public static abstract interface GraphUserListCallback {
        public abstract void onCompleted(List<GraphUser> paramList, Response paramResponse);
    }

    private static abstract interface KeyValueSerializer {
        public abstract void writeString(String paramString1, String paramString2)
                throws IOException;
    }

    private static class Serializer
            implements Request.KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final BufferedOutputStream outputStream;

        public Serializer(BufferedOutputStream paramBufferedOutputStream, Logger paramLogger) {
            this.outputStream = paramBufferedOutputStream;
            this.logger = paramLogger;
        }

        public void write(String paramString, Object... paramVarArgs)
                throws IOException {
            if (this.firstWrite) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                this.outputStream.write("\r\n".getBytes());
                this.firstWrite = false;
            }
            this.outputStream.write(String.format(paramString, paramVarArgs).getBytes());
        }

        public void writeBitmap(String paramString, Bitmap paramBitmap)
                throws IOException {
            writeContentDisposition(paramString, paramString, "image/png");
            paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            this.logger.appendKeyValue("    " + paramString, "<Image>");
        }

        public void writeBytes(String paramString, byte[] paramArrayOfByte)
                throws IOException {
            writeContentDisposition(paramString, paramString, "content/unknown");
            this.outputStream.write(paramArrayOfByte);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            this.logger.appendKeyValue("    " + paramString, String.format("<Data: %d>", new Object[]{Integer.valueOf(paramArrayOfByte.length)}));
        }

        public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
                throws IOException {
            write("Content-Disposition: form-data; name=\"%s\"", new Object[]{paramString1});
            if (paramString2 != null) {
                write("; filename=\"%s\"", new Object[]{paramString2});
            }
            writeLine("", new Object[0]);
            if (paramString3 != null) {
                writeLine("%s: %s", new Object[]{"Content-Type", paramString3});
            }
            writeLine("", new Object[0]);
        }

        /* Error */
        public void writeFile(String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
                throws IOException {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: aload_1
            //   3: ldc 108
            //   5: invokevirtual 61	com/facebook/Request$Serializer:writeContentDisposition	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   8: aconst_null
            //   9: astore 6
            //   11: aconst_null
            //   12: astore 5
            //   14: iconst_0
            //   15: istore_3
            //   16: new 130	android/os/ParcelFileDescriptor$AutoCloseInputStream
            //   19: dup
            //   20: aload_2
            //   21: invokespecial 133	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
            //   24: astore_2
            //   25: new 135	java/io/BufferedInputStream
            //   28: dup
            //   29: aload_2
            //   30: invokespecial 138	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
            //   33: astore 7
            //   35: sipush 8192
            //   38: newarray <illegal type>
            //   40: astore 5
            //   42: aload 7
            //   44: aload 5
            //   46: invokevirtual 142	java/io/BufferedInputStream:read	([B)I
            //   49: istore 4
            //   51: iload 4
            //   53: iconst_m1
            //   54: if_icmpne +75 -> 129
            //   57: aload 7
            //   59: ifnull +8 -> 67
            //   62: aload 7
            //   64: invokevirtual 145	java/io/BufferedInputStream:close	()V
            //   67: aload_2
            //   68: ifnull +7 -> 75
            //   71: aload_2
            //   72: invokevirtual 146	android/os/ParcelFileDescriptor$AutoCloseInputStream:close	()V
            //   75: aload_0
            //   76: ldc 75
            //   78: iconst_0
            //   79: anewarray 4	java/lang/Object
            //   82: invokevirtual 78	com/facebook/Request$Serializer:writeLine	(Ljava/lang/String;[Ljava/lang/Object;)V
            //   85: aload_0
            //   86: invokevirtual 81	com/facebook/Request$Serializer:writeRecordBoundary	()V
            //   89: aload_0
            //   90: getfield 26	com/facebook/Request$Serializer:logger	Lcom/facebook/internal/Logger;
            //   93: new 83	java/lang/StringBuilder
            //   96: dup
            //   97: ldc 85
            //   99: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   102: aload_1
            //   103: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   106: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   109: ldc 110
            //   111: iconst_1
            //   112: anewarray 4	java/lang/Object
            //   115: dup
            //   116: iconst_0
            //   117: iload_3
            //   118: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
            //   121: aastore
            //   122: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
            //   125: invokevirtual 104	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
            //   128: return
            //   129: aload_0
            //   130: getfield 24	com/facebook/Request$Serializer:outputStream	Ljava/io/BufferedOutputStream;
            //   133: aload 5
            //   135: iconst_0
            //   136: iload 4
            //   138: invokevirtual 149	java/io/BufferedOutputStream:write	([BII)V
            //   141: iload_3
            //   142: iload 4
            //   144: iadd
            //   145: istore_3
            //   146: goto -104 -> 42
            //   149: astore_2
            //   150: aload 6
            //   152: astore_1
            //   153: aload 5
            //   155: ifnull +8 -> 163
            //   158: aload 5
            //   160: invokevirtual 145	java/io/BufferedInputStream:close	()V
            //   163: aload_1
            //   164: ifnull +7 -> 171
            //   167: aload_1
            //   168: invokevirtual 146	android/os/ParcelFileDescriptor$AutoCloseInputStream:close	()V
            //   171: aload_2
            //   172: athrow
            //   173: astore 6
            //   175: aload_2
            //   176: astore_1
            //   177: aload 6
            //   179: astore_2
            //   180: goto -27 -> 153
            //   183: astore 6
            //   185: aload 7
            //   187: astore 5
            //   189: aload_2
            //   190: astore_1
            //   191: aload 6
            //   193: astore_2
            //   194: goto -41 -> 153
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	197	0	this	Serializer
            //   0	197	1	paramString	String
            //   0	197	2	paramParcelFileDescriptor	ParcelFileDescriptor
            //   15	131	3	i	int
            //   49	96	4	j	int
            //   12	176	5	localObject1	Object
            //   9	142	6	localObject2	Object
            //   173	5	6	localObject3	Object
            //   183	9	6	localObject4	Object
            //   33	153	7	localBufferedInputStream	java.io.BufferedInputStream
            // Exception table:
            //   from	to	target	type
            //   16	25	149	finally
            //   25	35	173	finally
            //   35	42	183	finally
            //   42	51	183	finally
            //   129	141	183	finally
        }

        public void writeLine(String paramString, Object... paramVarArgs)
                throws IOException {
            write(paramString, paramVarArgs);
            write("\r\n", new Object[0]);
        }

        public void writeObject(String paramString, Object paramObject)
                throws IOException {
            if (Request.isSupportedParameterType(paramObject)) {
                writeString(paramString, Request.parameterToString(paramObject));
                return;
            }
            if ((paramObject instanceof Bitmap)) {
                writeBitmap(paramString, (Bitmap) paramObject);
                return;
            }
            if ((paramObject instanceof byte[])) {
                writeBytes(paramString, (byte[]) paramObject);
                return;
            }
            if ((paramObject instanceof ParcelFileDescriptor)) {
                writeFile(paramString, (ParcelFileDescriptor) paramObject);
                return;
            }
            throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
        }

        public void writeRecordBoundary()
                throws IOException {
            writeLine("--%s", new Object[]{"3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"});
        }

        public void writeString(String paramString1, String paramString2)
                throws IOException {
            writeContentDisposition(paramString1, null, null);
            writeLine("%s", new Object[]{paramString2});
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + paramString1, paramString2);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */