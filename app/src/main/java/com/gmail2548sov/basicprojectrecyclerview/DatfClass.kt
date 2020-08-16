package com.gmail2548sov.basicprojectrecyclerview

import java.util.*

data class DatfClass(
    val id: UUID = UUID.randomUUID(),
    val name: String? = null,
    val surname: String? = null,
    val tel: String? = null,
    val dataCreator: Date = Date()
)