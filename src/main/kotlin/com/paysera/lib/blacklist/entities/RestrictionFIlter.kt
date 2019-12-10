package com.paysera.lib.blacklist.entities

data class RestrictionFIlter(
    val statuses: List<String>?,
    val hidden: Boolean?,
    val userId: Int
)