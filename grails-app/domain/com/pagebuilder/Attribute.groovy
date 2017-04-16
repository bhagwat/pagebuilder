package com.pagebuilder

class Attribute implements Comparable<Attribute> {
    String name
    String title
    DataType dataType
    Boolean array = Boolean.FALSE
    Boolean required = Boolean.FALSE
    Integer min
    Integer max
    String regex
    String inList
    Integer sortOrder

    static belongsTo = [model: Model]

    static constraints = {
        name nullable: false, blank: false, unique: 'model'
        title nullable: true
        dataType nullable: true
        array nullable: true
        required nullable: true
        min nullable: true
        max nullable: true
        regex nullable: true
        inList nullable: true
        sortOrder nullable: true
    }

    @Override
    int compareTo(Attribute o) {
        return this.sortOrder <=> o.sortOrder
    }
}
