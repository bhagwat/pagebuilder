package com.pagebuilder

import com.pagebuilder.co.TemplateCO
import com.pagebuilder.vo.TemplateVO

import java.util.stream.Collectors

class TemplateController {
    TemplateService templateService

    static responseFormats = ['json']
    static allowedMethods = [
            'index' : 'GET',
            'update': 'PUT',
            'save'  : 'POST'
    ]

    def index() {
        if (params.long('id')) {
            Template template = templateService.getById(params.long('id'))
            respond new TemplateVO(template)
        } else {
            List<Template> templates = templateService.list()
            respond templates.stream().map { new TemplateVO(it) }.collect(Collectors.toList())
        }
    }

    def save(TemplateCO templateCO) {
        Template template = templateService.save(templateCO)
        if (template && template.id) {
            respond 'status': 'success', id: template.id
        } else {
            respond 'status': 'failed'
        }
    }
}
