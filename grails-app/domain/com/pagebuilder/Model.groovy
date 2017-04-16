package com.pagebuilder

class Model {
    String name
    List<Attribute> attributes

    static hasMany = [attributes: Attribute]

    static constraints = {
        name unique: true
    }
}
