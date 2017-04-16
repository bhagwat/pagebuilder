package com.pagebuilder

import com.pagebuilder.co.ModelCO
import com.pagebuilder.vo.ModelDetailedVO
import com.pagebuilder.vo.ModelVO

import java.util.stream.Collectors

class ModelController {
    ModelService modelService

    static responseFormats = ['json']
    static allowedMethods = [
            'index': 'GET',
            'save' : 'POST'
    ]

    def index() {
        if (params.long('id')) {
            Model model = modelService.getById(params.long('id'))
            respond new ModelDetailedVO(model)
        } else {
            Boolean shortVersion = params.boolean('short')
            List<Model> models = modelService.list()
            respond models.stream().map {
                shortVersion ? new ModelVO(it) : new ModelDetailedVO(it)
            }
            .collect(Collectors.toList())
        }
    }

    def save(ModelCO modelCO) {
        Model model = modelService.save(modelCO)
        if (model && model.id) {
            respond 'status': 'success', id: model.id
        } else {
            respond 'status': 'failed'
        }
    }
}
