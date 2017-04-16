package com.pagebuilder

class Page {
    String name
    Template template

    static hasMany = [attributeValues: AttributeValue]

    static constraints = {
        name nullable: false, blank: true
        template nullable: false
    }
}
