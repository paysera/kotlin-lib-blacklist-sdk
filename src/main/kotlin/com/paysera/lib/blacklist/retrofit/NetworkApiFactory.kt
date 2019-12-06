package com.paysera.lib.blacklist.retrofit

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.blacklist.clients.BlacklistApiClient

class NetworkApiFactory(credentials: ApiCredentials, timeout: Long? = null) : BaseApiFactory<BlacklistApiClient>(credentials, timeout) {

    override fun createClient(baseUrl: String, tokenRefresher: TokenRefresherInterface?): BlacklistApiClient {
        return BlacklistApiClient(
            createRetrofit(baseUrl, tokenRefresher).create(NetworkApiClient::class.java)
        )
    }
}