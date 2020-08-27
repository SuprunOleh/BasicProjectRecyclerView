package com.gmail2548sov.basicprojectrecyclerview

import java.util.*

data class DatfClass(
    val id: UUID = UUID.randomUUID(),
    var name: String? = null,
    var surname: String? = null,
    var tel: String? = null,
    val dataCreator: Date = Date(),
    var poto: Boolean = false
)