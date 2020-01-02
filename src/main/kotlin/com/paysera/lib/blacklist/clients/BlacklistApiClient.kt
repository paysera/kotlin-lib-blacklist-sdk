package com.paysera.lib.blacklist.clients

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.blacklist.entities.*
import com.paysera.lib.blacklist.retrofit.NetworkApiClient
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import kotlinx.coroutines.Deferred

class BlacklistApiClient(
    private val networkApiClient: NetworkApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getUserRestrictions(filter: RestrictionFilter): Deferred<MetadataAwareResponse<Restriction>> {
        return networkApiClient.getUserRestrictions(
            statuses = filter.statuses,
            hidden = filter.hidden,
            userId = filter.userId
        )
    }
}