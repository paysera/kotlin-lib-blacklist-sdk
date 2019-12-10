package com.paysera.lib.blacklist.clients

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.common.interfaces.BaseApiClient
import com.paysera.lib.blacklist.entities.*
import com.paysera.lib.blacklist.retrofit.NetworkApiClient
import kotlinx.coroutines.Deferred

class BlacklistApiClient(
    private val networkApiClient: NetworkApiClient
) : BaseApiClient {

    fun getUserRestrictions(filter: RestrictionFilter): Deferred<MetadataAwareResponse<Restriction>> {
        return networkApiClient.getUserRestrictions(
            statuses = filter.statuses,
            hidden = filter.hidden,
            userId = filter.userId
        )
    }
}