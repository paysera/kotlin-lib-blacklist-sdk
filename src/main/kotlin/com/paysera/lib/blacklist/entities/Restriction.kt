package com.paysera.lib.blacklist.entities

import java.util.*

data class Restriction(
    val id: Int,
    val userId: String,
    val type: String?,
    val status: String?,
    val createMethod: String?,
    val awaitedConditionRemovalType: String?,
    val awaitedConditionType: String?,
    val createdAt: Date?,
    val hidden: Boolean?,
    val reviewStatus: String?,
    val comments: RestrictionComment?,
    val resolvedAt: Date?
    )