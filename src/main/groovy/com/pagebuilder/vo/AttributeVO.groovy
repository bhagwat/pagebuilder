package com.pagebuilder.vo

import com.pagebuilder.Attribute
import com.pagebuilder.DataType

class AttributeVO {
    Long id
    String name
    String title
    DataType dataType
    Boolean array
    Boolean required
    Integer min
    Integer max
    String regex
    String inList
    Integer sortOrder

    AttributeVO() {

    }

    AttributeVO(Attribute attribute) {
        this.id = attribute.id
        this.name = attribute.name
        this.title = attribute.title
        this.dataType = attribute.dataType
        this.array = attribute.array
        this.required = attribute.required
        this.min = attribute.min
        this.max = attribute.max
        this.regex = attribute.regex
        this.inList = attribute.inList
        this.sortOrder = attribute.sortOrder
    }
}
