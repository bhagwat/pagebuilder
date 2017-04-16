package com.pagebuilder

class AttributeValue {
    Attribute attribute
    String value

    static belongsTo = [Page]

    static constraints = {
        value nullable: true
    }

    static mapping = {
        value sqlType: 'text'
    }
}
