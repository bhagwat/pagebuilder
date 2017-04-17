package com.pagebuilder.vo

import com.pagebuilder.Template

class TemplateVO {
    Long id
    String name
    ModelVO model

    TemplateVO() {

    }

    TemplateVO(Template template) {
        this.id = template.id
        this.name = template.name
        this.model = new ModelVO(template.model)
    }
}
