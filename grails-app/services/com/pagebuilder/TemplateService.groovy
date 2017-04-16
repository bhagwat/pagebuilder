package com.pagebuilder

import com.pagebuilder.co.TemplateCO
import grails.transaction.Transactional

class TemplateService {
    ModelService modelService

    @Transactional
    Template save(TemplateCO templateCO) {
        Template template = templateCO.id ? getById(templateCO.id) : new Template()
        template.name = templateCO.name
        template.renderer = templateCO.renderer
        template.model = modelService.getById(templateCO.model.id)
        template.save(failOnError: true)
        return template
    }

    Template getById(Long id) {
        Template.get(id)
    }

    List<Template> list() {
        Template.list()
    }
}
