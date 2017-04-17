package com.pagebuilder.vo

import com.pagebuilder.Page

import java.util.stream.Collectors

class PageVO {
    Long id
    String name
    TemplateDetailedVO template
    List<AttributeValueVO> attributeValues

    PageVO() {

    }

    PageVO(Page page) {
        this.id = page.id
        this.name = page.name
        this.template = new TemplateDetailedVO(page.template)
        attributeValues = page.attributeValues.stream().map { new AttributeValueVO(it) }.collect(Collectors.toList())
    }
}
