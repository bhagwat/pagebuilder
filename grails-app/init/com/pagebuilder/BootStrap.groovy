package com.pagebuilder

class BootStrap {

    def init = { servletContext ->
        log.info ">>>>>>>>>>>>>>> Bootstrap started"
        Model person = new Model(name: "Person Model")
        new Attribute().with {
            sortOrder = 1
            name = 'name'
            title = "Enter name: "
            dataType = DataType.PLAIN_TEXT
            required = true
            max = 100
            person.addToAttributes(it)
        }
        new Attribute().with {
            sortOrder = 2
            name = 'age'
            title = "Enter age: "
            dataType = DataType.INTEGER
            min = 10
            max = 100
            person.addToAttributes(it)
        }
        new Attribute().with {
            sortOrder = 3
            name = 'male'
            title = "Male: "
            dataType = DataType.BOOLEAN
            person.addToAttributes(it)
        }
        new Attribute().with {
            sortOrder = 4
            name = 'separator'
            dataType = DataType.PLACEHOLDER
            person.addToAttributes(it)
        }
        new Attribute().with {
            sortOrder = 5
            name = 'bio'
            title = "About: "
            dataType = DataType.RICH_TEXT
            required = false
            max = 500
            person.addToAttributes(it)
        }

        person.save(failOnError: true)

        Template personTemplate = new Template(name: 'Person List Template', model: person, renderer: 'kjkjhk')
        personTemplate.save(failOnError: true)

        Page ram = new Page(template: personTemplate, name: 'Ram')
        person.attributes.each { Attribute modelAttribute ->
            AttributeValue attr = ram.attributeValues?.find { it.attribute.id == modelAttribute.id }
            if (!attr) {
                attr = new AttributeValue(attribute: modelAttribute)
                ram.addToAttributeValues(attr)
            }
            attr.value = "Ram Value for ${modelAttribute.name}"
        }

        ram.save(failOnError: true)

        Page jony = new Page(template: personTemplate, name: 'Jony')
        person.attributes.each { Attribute modelAttribute ->
            AttributeValue attributeValue = jony.attributeValues.find { it.attribute.id == modelAttribute.id }
            if (!attributeValue) {
                attributeValue = new AttributeValue(attribute: modelAttribute)
                jony.addToAttributeValues(attributeValue)
            }
            attributeValue.value = "Jony Value for ${modelAttribute.name}"
        }
        jony.save(failOnError: true)

        Model bookModel = new Model(name: 'Book Model')
        new Attribute().with {
            sortOrder = 1
            name = 'bookName'
            title = "Enter Book name: "
            dataType = DataType.PLAIN_TEXT
            required = true
            min = 5
            max = 100
            bookModel.addToAttributes(it)
        }
        new Attribute().with {
            sortOrder = 2
            name = 'pages'
            title = "Enter Number of pages: "
            dataType = DataType.INTEGER
            min = 1
            max = 5000
            bookModel.addToAttributes(it)
        }

        new Attribute().with {
            sortOrder = 3
            name = 'authorName'
            title = "Enter Author Name: "
            dataType = DataType.PLAIN_TEXT
            min = 1
            max = 500
            bookModel.addToAttributes(it)
        }

        bookModel.save(failOnError: true)

        Template bookTemplate = new Template(name: 'Book List Template', model: bookModel, renderer: 'kjkjhk')
        bookTemplate.save(failOnError: true)

        Page book1 = new Page(template: bookTemplate, name: 'Grails')
        bookModel.attributes.each { Attribute modelAttribute ->
            AttributeValue attributeValue = new AttributeValue(attribute: modelAttribute)
            book1.addToAttributeValues(attributeValue)
            attributeValue.value = "book1 Value for ${modelAttribute.name}"
        }
        book1.save(failOnError: true)

        Page book2 = new Page(template: bookTemplate, name: 'Spring Boot')
        bookModel.attributes.each { Attribute modelAttribute ->
            AttributeValue attributeValue = new AttributeValue(attribute: modelAttribute)
            book2.addToAttributeValues(attributeValue)
            attributeValue.value = "book2 Value for ${modelAttribute.name}"
        }
        book2.save(failOnError: true)

        log.info ">>>>>>>>>>>>>>> Bootstrap finished"
    }
    def destroy = {
    }
}
