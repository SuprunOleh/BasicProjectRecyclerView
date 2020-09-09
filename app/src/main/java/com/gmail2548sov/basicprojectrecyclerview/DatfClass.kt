package com.gmail2548sov.basicprojectrecyclerview

import java.util.*

data class DatfClass(
    val id: UUID = UUID.randomUUID(),
    var name: String? = null,
    var surname: String? = null,
    var tel: String? = null,
    var dataCreator: Date = Date(119, 0,15),
    var poto: Boolean = false
)