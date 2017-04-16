package com.pagebuilder.vo

import com.pagebuilder.Model

class ModelVO {
    Long id
    String name

    ModelVO() {

    }

    ModelVO(Model model) {
        this.id = model.id
        this.name = model.name
    }
}
