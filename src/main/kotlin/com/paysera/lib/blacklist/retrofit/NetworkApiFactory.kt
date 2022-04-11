package com.paysera.lib.blacklist.retrofit

import com.paysera.lib.blacklist.clients.BlacklistApiClient
import com.paysera.lib.common.entities.AuthorizationApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    baseUrl: String,
    locale: String?,
    userAgent: String?,
    credentials: AuthorizationApiCredentials,
    certifiedHosts: List<String> = emptyList(),
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface
) : BaseApiFactory<BlacklistApiClient>(
    baseUrl,
    locale,
    userAgent,
    credentials,
    certifiedHosts,
    timeout,
    httpLoggingInterceptorLevel,
    errorLogger
) {
    override fun createClient(tokenRefresher: TokenRefresherInterface?): BlacklistApiClient {
        createRetrofit(tokenRefresher).apply {
            return BlacklistApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}