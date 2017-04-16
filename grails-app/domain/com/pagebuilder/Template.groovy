package com.pagebuilder

class Template {
    String name
    String renderer
    Model model

    static constraints = {
        name unique: true, blank: false, nullable: false
        renderer nullable: true
        model nullable: false
    }

    static mapping = {
        renderer sqlType: 'text'
    }
}
