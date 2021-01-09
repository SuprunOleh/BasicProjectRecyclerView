package com.gmail2548sov.basicprojectrecyclerview

import java.util.*

data class DatfClass(
    var id: UUID = UUID.randomUUID(),
    var name: String? = "null",
    var surname: String? = "null",
    var tel: String? = "null",
    var dataCreator: Date = Date(),
    var photo: Boolean = false
) {constructor(id: UUID): this(){
    this.id = id
}


}
