package com.pagebuilder

class DataTypeController {
    static responseFormats = ['json']

    def index() {
        respond DataType.values().collect { return [name: it.name(), value: it.title] }
    }
}
