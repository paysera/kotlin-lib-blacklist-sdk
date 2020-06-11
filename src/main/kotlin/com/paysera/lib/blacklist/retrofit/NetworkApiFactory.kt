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
    override val baseUrl = "https://blacklist.paysera.com/restriction/rest/v1/"
    override val certifiedHosts = listOf("blacklist.paysera.com")

    override fun createClient(tokenRefresher: TokenRefresherInterface?): BlacklistApiClient {
        createRetrofit(tokenRefresher).apply {
            return BlacklistApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}