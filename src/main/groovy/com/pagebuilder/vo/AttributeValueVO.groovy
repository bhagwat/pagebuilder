package com.pagebuilder.vo

import com.pagebuilder.AttributeValue
import com.pagebuilder.DataType

class AttributeValueVO {
    Long id
    String name
    String title
    DataType dataType
    String value

    AttributeValueVO() {

    }

    AttributeValueVO(AttributeValue attributeValue) {
        this.id = attributeValue.id
        this.value = attributeValue.value
        this.name = attributeValue.attribute.name
        this.title = attributeValue.attribute.title
        this.dataType = attributeValue.attribute.dataType
    }
}
