package com.paysera.lib.blacklist.retrofit

import com.paysera.lib.blacklist.clients.BlacklistApiClient
import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    userAgent: String?,
    credentials: ApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC
) : BaseApiFactory<BlacklistApiClient>(
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel
) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): BlacklistApiClient {
        createRetrofit(baseUrl, tokenRefresher).apply {
            return BlacklistApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}