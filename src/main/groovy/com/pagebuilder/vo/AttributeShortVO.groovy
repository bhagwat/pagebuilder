package com.pagebuilder.vo

import com.pagebuilder.Attribute

class AttributeShortVO {
    Long id
    String name
    String title

    AttributeShortVO() {

    }

    AttributeShortVO(Attribute attribute) {
        this.id = attribute.id
        this.name = attribute.name
        this.title = attribute.title
    }
}
