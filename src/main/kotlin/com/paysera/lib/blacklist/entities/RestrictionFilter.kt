package com.paysera.lib.blacklist.entities

data class RestrictionFilter(
    val statuses: List<String>?,
    val hidden: Boolean?,
    val userId: Int
)