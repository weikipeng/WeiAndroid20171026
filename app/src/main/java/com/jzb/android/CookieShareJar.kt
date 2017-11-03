package com.jzb.android.web

import android.webkit.CookieManager
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * Created by wikipeng on 2017/5/25.
 */
class CookieShareJar : CookieJar {
    private val webViewCookieManager = CookieManager.getInstance()

    //Cookie:FDX_sid=w3946702_fd60213a8178241c0793cfb; FDX_auth=2fc1ccc569ymiR1%2FYvs7bGjLmAbGP6%2BcnmpPcqx2nlBKmtUCWAP5ibKtEHxVQkixyf6GzLzApO5hCa0nXgwV48VggWGAQTDTnAa7WBYFipTPIEcoNDm5lOwzHiqQ;
    // api_key="b9e8bbc6c8GLVn0nyu3okhmCUxBJ+gvtnoq/dCBjiN/g3MlJcasOkzFEyzTsGiOtwz871ux1H5+eoWPJbZXf2wtIxnbGb5iTjBGCS1jiA3hQ"
    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
//        val urlString = url.toString()
//
//        for (cookie in cookies) {
//            webViewCookieManager.setCookie(urlString, cookie.toString())
//
//            DevLogTool.getInstance(BangApplication.getInstance()).saveLog(
//                    "<<<<<<<<<<<<<<<<<<<<< saveFromResponse  " + url + "\ncookiesString:" + cookie.toString())
//        }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
//        val urlString = url.toString()
//        val cookiesString = webViewCookieManager.getCookie(urlString)
//
//        //        String cookieKey0 = "FDX_sid";
//        //        String cookieKey1 = "FDX_auth";
//        //        String cookieKey2 = "api_key";
//
//        val cookieKeyArray = arrayOf("FDX_sid", "FDX_auth", "api_key")
//
//        val checkCookieArray = arrayOfNulls<Cookie>(3)
//
//        val cookieKeyArrayLength = cookieKeyArray.size
//        ///////////////////////////////////////////////////////////////////////////
//        //
//        ///////////////////////////////////////////////////////////////////////////
//        val oAuthKey = RestfulClient.getOAuthKey()
//        if (cookiesString != null && !cookiesString.isEmpty()) {
//            //We can split on the ';' char as the cookie manager only returns cookies
//            //that match the url and haven't expired, so the cookie attributes aren't included
//            val cookieHeaders = cookiesString.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//            val cookies = ArrayList<Cookie>(cookieHeaders.size)
//            DevLogTool.getInstance(BangApplication.getInstance()).saveLog(
//                    "============================================================" + "loadForRequest" + url + "\n======" + RestfulClient.getOAuthKey())
//            var tCookie: Cookie? = null
//            var cookieName = ""
//            var isAdd: Boolean
//            for (header in cookieHeaders) {
//                isAdd = true
//                tCookie = Cookie.parse(url, header)
//                cookieName = tCookie!!.name()
//                DevLogTool.getInstance(BangApplication.getInstance()).saveLog(
//                        " cookieName:" + cookieName + "-----" + tCookie.value() + "------")
//                for (i in 0 until cookieKeyArrayLength) {
//                    if (cookieKeyArray[i] == cookieName) {
//                        checkCookieArray[i] = tCookie
//                        isAdd = false
//                    }
//                }
//
//                if (isAdd) {
//                    cookies.add(tCookie)
//                }
//            }
//
//            ///////////////////////////////////////////////////////////////////////////
//            // 检查 FDX_auth 是否 与 授权 用户信息一致
//            ///////////////////////////////////////////////////////////////////////////
//            if (checkCookieArray[1] != null) {
//                var value = checkCookieArray[1].value()
//                if (!TextUtils.isEmpty(value)) {
//                    value = value.trim { it <= ' ' }
//                    try {
//                        value = URLDecoder.decode(value, "utf-8")
//                    } catch (e: UnsupportedEncodingException) {
//                        e.printStackTrace()
//                    }
//
//                    if (oAuthKey == value) {
//                        if (checkCookieArray[0] != null) {
//                            cookies.add(checkCookieArray[0])
//                        }
//
//                        cookies.add(checkCookieArray[1])
//                        DevLogTool.getInstance(BangApplication.getInstance()).saveLog(
//                                "======> setCookie " + checkCookieArray[1].name() + ": " + checkCookieArray[1].value() + "------")
//                    }
//
//                }
//            }
//
//            if (checkCookieArray[2] != null) {
//                var value = checkCookieArray[2].value()
//                if (!TextUtils.isEmpty(value)) {
//                    value = value.trim { it <= ' ' }
//                    value = value.substring(1, value.length - 2)
//                }
//
//                if (oAuthKey == value) {
//                    cookies.add(checkCookieArray[2])
//                    DevLogTool.getInstance(BangApplication.getInstance()).saveLog(
//                            "======> setCookie " + checkCookieArray[2].name() + ": " + checkCookieArray[2].value())
//                }
//            }
//
//
//            DevLogTool.getInstance(BangApplication.getInstance()).saveLog(
//                    " ======> setCookie loadForRequest $url\ncookiesString:$cookiesString")
//
//            return cookies
//        }

        return emptyList()
    }
}
