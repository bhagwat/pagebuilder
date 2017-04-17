package com.pagebuilder.vo

import com.pagebuilder.Template

class TemplateDetailedVO extends TemplateVO {
    String renderer
    ModelDetailedVO model

    TemplateDetailedVO() {

    }

    TemplateDetailedVO(Template template) {
        super(template)
        this.renderer = template.renderer
        this.model = new ModelDetailedVO(template.model)
    }
}
