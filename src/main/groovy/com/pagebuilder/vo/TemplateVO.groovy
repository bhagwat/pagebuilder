package com.pagebuilder.vo

import com.pagebuilder.Template

class TemplateVO {
    Long id
    String name
    String renderer
    ModelDetailedVO model

    TemplateVO() {

    }

    TemplateVO(Template template) {
        this.id = template.id
        this.name = template.name
        this.renderer = template.renderer
        this.model = new ModelDetailedVO(template.model)
    }
}
