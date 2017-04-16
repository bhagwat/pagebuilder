package com.pagebuilder.vo

import com.pagebuilder.Model

import java.util.stream.Collectors

class ModelDetailedVO extends ModelVO {
    List<AttributeVO> attributes

    ModelDetailedVO() {

    }

    ModelDetailedVO(Model model) {
        super(model)
        attributes = model.attributes.stream().map { new AttributeVO(it) }.collect(Collectors.toList())
    }
}
