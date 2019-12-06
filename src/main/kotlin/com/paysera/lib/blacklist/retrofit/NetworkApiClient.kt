package com.paysera.lib.blacklist.retrofit

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.blacklist.entities.Restriction
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface NetworkApiClient {

    @GET("restrictions")
    fun getUserRestrictions(
        @Query("statuses[]") statuses: List<String>,
        @Query("hidden") hidden: String?,
        @Query("user_id") userId: Int?
    ): Deferred<MetadataAwareResponse<Restriction>>
}