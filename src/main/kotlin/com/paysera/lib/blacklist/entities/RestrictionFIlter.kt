package com.paysera.lib.blacklist.entities

data class RestrictionFIlter(
    val statuses: List<String>,
    val hidden: String?,
    val userId: Int?
)