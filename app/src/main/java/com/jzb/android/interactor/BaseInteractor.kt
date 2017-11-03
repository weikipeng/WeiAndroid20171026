package com.jzb.android.interactor

//import com.eduu.bang.http.RxErrorHandlingCallAdapterFactory;

/**
 * Created by WikiPeng on 15/7/6 下午4:55.
 */
object BaseInteractor {
//    val REQUEST_TIMEOUT: Long = 30 * 1000
//
//    var sOkHttpClient: OkHttpClient? = null
//    //    /**
////     * 纯净没有Log的client
////     */
////    var sPureOkHttpClient: OkHttpClient? = null
////    var sOkHttpClientInterceptor: Interceptor = Interceptor { chain ->
////        val t1 = System.nanoTime()
////        var request = chain.request()
////
////        request = buildRequest(request)
////
////        /*FOpenLog.e(String.format("%s Sending request type %s %s on %s%n%s%n",
////             java.lang.Thread.currentThread().getName(),
////             request.method(), request.url(), chain.connection(), request.headers()));*/
////
////
////        val response = chain.proceed(request)
////        //                        /*FOpenLog.e("jzbfocus BaseInteractor======> password ===  "+response.code());*/
////        isLogOut(response)
////        //            if (!response.isSuccessful()) {
////        //                ACRA.getErrorReporter().handleException(new JZBHttpException(chain.connection(), request, response));
////        //            }
////
////        val t2 = System.nanoTime()
////        //                        /*FOpenLog.e(String.format("Received response for %s in %.1fms%n%s",
////        //                                request.url(), (t2 - t1) / 1e6d, response.headers()));*/
////        response
////    }
////
////    //----------------------------------------------------------------
////    //--------------------------------5.2.1--------------------------------
////    //----------------------------------------------------------------
//    val okHttpClient: OkHttpClient
//        get() {
//            if (sOkHttpClient != null) {
//                return sOkHttpClient
//            }
//
//            sOkHttpClient = okHttpClientBuilder
//                    .addInterceptor(sOkHttpClientInterceptor)
//                    .build()
//
//            return sOkHttpClient
//        }
//    //
////    val postOkHttpClient: OkHttpClient
////        get() = okHttpClientBuilder
////                .connectTimeout(3, TimeUnit.MINUTES)
////                .readTimeout(3, TimeUnit.MINUTES)
////                .writeTimeout(3, TimeUnit.MINUTES)
////                .addInterceptor(sOkHttpClientInterceptor)
////                .build()
////
////    //        CookieManager cookieManager = new CookieManager();
////    //        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
////    //        AddCookiesInterceptor      addCookiesInterceptor      = new AddCookiesInterceptor(HttpManager.getCookiePreferences(), BaseHttpClient.getCookieStore());
////    //        ReceivedCookiesInterceptor receivedCookiesInterceptor = new ReceivedCookiesInterceptor(HttpManager.getCookiePreferences());
////    //                .cookieJar(new JavaNetCookieJar(cookieManager))
////    //                .addInterceptor(addCookiesInterceptor)
////    //                .addInterceptor(receivedCookiesInterceptor);
////    //                .authenticator(new Authenticator() {
////    //                    @Override
////    //                    public Request authenticate(Route route, Response response) throws IOException {
////    //                        /*FOpenLog.e("okHttpClient set authenticate");*/
////    //                        return response.request().newBuilder().addHeader("Authorization", RestfulClient.getOAuthKey()).build();
////    //                    }
////    //                });
////    ////        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
////    ////        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
////    //
////    ////                .addInterceptor(logging)
//    val okHttpClientBuilder: OkHttpClient.Builder
//        get() {
//
//            val builder = OkHttpClient.Builder()
//                    .cookieJar(CookieShareJar())
//                    .readTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
//                    .connectTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
//                    .writeTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
//
//            if (BuildConfig.DEBUG) {
//                builder.addNetworkInterceptor(StethoInterceptor())
//            }
//
//            return builder
//        }
//
//    //
////    /*FOpenLog.e(String.format("%s Sending request type %s %s on %s%n%s%n",
////                                java.lang.Thread.currentThread().getName(),
////                                request.method(), request.url(), chain.connection(), request.headers()));*/ val pureOkHttpClient: OkHttpClient
////        get() {
////            if (sPureOkHttpClient != null) {
////                return sPureOkHttpClient
////            }
////            sPureOkHttpClient = okHttpClientBuilder
////                    .addInterceptor { chain ->
////                        var request = chain.request()
////
////                        request = buildRequest(request)
////
////                        val response = chain.proceed(request)
////                        if (!response.isSuccessful) {
////                            ACRA.getErrorReporter().handleException(JZBHttpException(chain.connection(), request, response))
////                        }
////                        response
////                    }.build()
////
////            return sPureOkHttpClient
////        }
////
////    val okHttpCache: File?
////        get() {
////            var file: File? = null
////            val application = BangApplication.getInstance()
////            var cacheParentFolder = application.getExternalCacheDir()
////
////            if (cacheParentFolder == null || !cacheParentFolder!!.exists() || cacheParentFolder!!.isFile()) {
////                cacheParentFolder = application.getCacheDir()
////            }
////
////            if (cacheParentFolder == null || !cacheParentFolder!!.exists() || cacheParentFolder!!.isFile()) {
////                return null
////            }
////
////            val okHttpCacheCache = cacheParentFolder!!.getAbsolutePath() + File.separator + "okHttpCache"
////
////            file = File(okHttpCacheCache)
////
////            if (file!!.isFile) {
////                if (!file.delete()) {
////                    ACRA.getErrorReporter().handleException(IOException("OkHttpCache isFile delete failed"))
////                }
////            }
////
////            if (!file.exists()) {
////                if (!file.mkdirs()) {
////                    ACRA.getErrorReporter().handleException(IOException("OkHttpCache not exists create failed"))
////                }
////            }
////
////            return file
////        }
////
////    fun buildRequest(request: Request): Request {
////        var request = request
////        //先拼Url，如果是Get请求，需要把签名加上，并且每个请求加上版本号信息
////        var httpUrl = request.url()
////        val httpUrlBuilder = httpUrl.newBuilder()
////        //        if ("GET".equalsIgnoreCase(request.method())) {
////        httpUrlBuilder.addQueryParameter(PARAM_V, HttpManager.VERSION_NAME)
////        httpUrlBuilder.addQueryParameter(PARAM_VER, HttpManager.VERSION_NAME)
////        httpUrlBuilder.addQueryParameter(PARAM_CHANNEL, BangApplication.getInstance().getAppChannel())
////        //            httpUrlBuilder.addQueryParameter(HttpManager.PARAM_API_KEY, HttpManager.getOAuthKey());
////        //        }
////
////        httpUrl = httpUrlBuilder.build()
////
////
////        //添加头部信息
////        request = request.newBuilder()
////                .url(httpUrl)
////                .header(HttpManager.PARAM_AUTHORIZATION, RestfulClient.getOAuthKey())
////                //                        .header("User-Agent", AsyncHttpClient.AsyncHttpClient_UA)
////                .header(HttpManager.PARAM_USER_AGENT, HttpManager.getUserAgent())
////                .build()
////
////        return request
////    }
////
//    fun <S> createService(serviceClass: Class<S>, baseUrl: String): S {
//        //        if (!baseUrl.endsWith("/")) {
//        //            baseUrl += "/";
//        //        }
//        //
//        //        Retrofit.Builder builder = new Retrofit.Builder()
//        //                .client(getOkHttpClient())
//        ////                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//        //                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
//        //                .addConverterFactory(GsonConverterFactory.create(BangApplication.getInstance().getGson()))
//        //                .baseUrl(baseUrl);
//        //
//        //        Retrofit adapter = builder.build();
//        //
//        //        return adapter.create(serviceClass);
//        return createService(okHttpClient, serviceClass, baseUrl)
//    }
//
//    fun <S> createService(okHttpClient: OkHttpClient, serviceClass: Class<S>, baseUrl: String): S {
//        var baseUrl = baseUrl
//        if (!baseUrl.endsWith("/")) {
//            baseUrl += "/"
//        }
//
//        val builder = Retrofit.Builder()
//                .client(okHttpClient)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                //                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
////                .addConverterFactory(GsonConverterFactory.create(BangApplication.getInstance().getGson()))
//                .baseUrl(baseUrl)
//
//        val adapter = builder.build()
//
//        return adapter.create(serviceClass)
//    }
////
////    fun <S> createRestService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().api)
////    }
////
////    fun <S> createPhpService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().mp)
////    }
////
////    /**
////     * 搜索单独写 http ，不要https请求
////     *
////     * @param serviceClass
////     * @param <S>
////     * @return
////    </S> */
////    fun <S> createSearchPhpService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().m)
////    }
////
////    fun <S> createMJZBService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().m)
////    }
////
////    fun <S> createPayService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().pay)
////    }
////
////    fun <S> createQAService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().app)
////    }
////
////    fun <S> createSecretService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().secret)
////    }
////
////    fun <S> createNoticeService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().notice)
////    }
////
////    fun <S> createTopNewsUploadService(serviceClass: Class<S>): S {
////        return createService(serviceClass, UrlTool.getDomainInfo().topNewsUpload)
////    }
////
////    private fun bodyToString(request: Request): String {
////        try {
////            val copy = request.newBuilder().build()
////            if (copy == null || copy.body() == null) {
////                return "null"
////            }
////            val buffer = Buffer()
////            copy.body()!!.writeTo(buffer)
////            return buffer.readUtf8()
////        } catch (e: IOException) {
////            return "did not work"
////        }
////
////    }
////
////    private fun isLogOut(response: Response?): Boolean {
////        if (response == null) {
////            return false
////        }
////
////        //        /*FOpenLog.e("jzbFocus debug ======> isLogOut password ===    11 response code:" +response.code());*/
////        //----------------------------------------------------------------
////        //--------------------------------Python接口,PC端修改密码被踢出--------------------------------
////        //----------------------------------------------------------------
////        if (HttpStatus.SC_UNAUTHORIZED === response.code() && AppSettings.getInstanceUser().isLogin()) {
////            //            /*FOpenLog.e("jzbFocus debug ======> isLogOut  ===    HttpStatus.SC_UNAUTHORIZED " +HttpStatus.SC_UNAUTHORIZED);*/
////            EventBus.getDefault().post(MainEvent(MainEvent.Type.KICK_OUT))
////            return true
////        }
////
////        val responseBody = response.body()
////        val source = responseBody!!.source()
////        try {
////            source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
////        } catch (e: IOException) {
////            e.printStackTrace()
////        }
////
////        val buffer = source.buffer()
////        val UTF8 = Charset.forName("UTF-8")
////        var charset: Charset? = UTF8
////        val contentType = responseBody.contentType()
////
////        if (contentType != null) {
////            try {
////                charset = contentType.charset(UTF8)
////            } catch (e: UnsupportedCharsetException) {
////                //                logger.log("");
////                //                logger.log("Couldn't decode the response body; charset is likely malformed.");
////                //                logger.log("<-- END HTTP");
////                return false
////            }
////
////        }
////
////        //说明不是文本,可能是图片等
////        return if (!isPlaintext(buffer)) {
////            //            logger.log("");
////            //            logger.log("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
////            false
////        } else false
////
////        //        String responseBodyString = buffer.clone().readString(charset);
////        //        if (!TextUtils.isEmpty(responseBodyString) && JsonUtil.isGoodJson(responseBodyString)) {
////        //            BaseGetResult errorResult = BangApplication.getInstance().getGson().fromJson(responseBodyString, BaseGetResult.class);
////        //            if (errorResult != null && errorResult.isKickOut()) {
////        //                EventBus.getDefault().post(new MainEvent(MainEvent.Type.KICK_OUT));
////        //                return true;
////        //            }
////        //        }
////
////    }
////
////    /**
////     * Returns true if the body in question probably contains human readable text. Uses a small sample
////     * of code points to detect unicode control characters commonly used in binary file signatures.
////     */
////    internal fun isPlaintext(buffer: Buffer): Boolean {
////        try {
////            val prefix = Buffer()
////            val byteCount = if (buffer.size() < 64) buffer.size() else 64
////            buffer.copyTo(prefix, 0, byteCount)
////            for (i in 0..15) {
////                if (prefix.exhausted()) {
////                    break
////                }
////                val codePoint = prefix.readUtf8CodePoint()
////                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
////                    return false
////                }
////            }
////            return true
////        } catch (e: EOFException) {
////            return false // Truncated UTF-8 sequence.
////        }
////
////    }
////
////    fun <T> pojoToMap(model: T): Map<String, String>? {
////        val gson = Gson()
////        val stringStringMap = object : TypeToken<Map<String, String>>() {
////
////        }.type
////        return gson.fromJson<Map<String, String>>(gson.toJson(model), stringStringMap)
////    }
////
////    interface BaseCallback {
////        fun onStart()
////
////        fun onFinish()
////
////        fun onFailure(error: Throwable, content: String)
////    }
////
////    interface BaseCallbackT<T> : BaseCallback {
////        fun onSuccess(statusCode: Int, typedClass: T)
////    }
}
