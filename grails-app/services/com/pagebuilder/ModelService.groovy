package com.pagebuilder

import com.pagebuilder.co.ModelCO
import com.pagebuilder.vo.AttributeVO
import grails.transaction.Transactional

class ModelService {

    @Transactional
    Model save(ModelCO modelCO) {
        Model model = modelCO.id ? getById(modelCO.id) : new Model()
        model.name = modelCO.name
        List<Long> updatedAttributeIds = modelCO.attributes.id
        List<Attribute> attributesToRemove = model.attributes.findAll { !updatedAttributeIds.contains(it.id) }
        for (AttributeVO attributeVO : modelCO.attributes) {
            Attribute attribute = model.attributes.find { it.id == attributeVO.id }
            if (!attribute) {
                attribute = new Attribute()
                model.addToAttributes(attribute)
            }
            attribute.sortOrder = attributeVO.sortOrder
            attribute.name = attributeVO.name
            attribute.title = attributeVO.title
            attribute.dataType = attributeVO.dataType
            attribute.array = attributeVO.array
            attribute.required = attributeVO.required
            attribute.min = attributeVO.min
            attribute.max = attributeVO.max
            attribute.regex = attributeVO.regex
            attribute.inList = attributeVO.inList
        }
        attributesToRemove.each { model.removeFromAttributes(it) }
        model.save(failOnError: true)
        return model
    }

    Model getById(Long id) {
        Model.get(id)
    }

    List<Model> list() {
        Model.list()
    }
}
