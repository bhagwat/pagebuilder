package com.pagebuilder

import com.pagebuilder.vo.PageVO

import java.util.stream.Collectors

class PageController {
    PageService pageService

    static responseFormats = ['json']
    static allowedMethods = [
            'index' : 'GET',
            'update': 'PUT',
            'save'  : 'POST'
    ]

    def index() {
        if (params.long('id')) {
            Page page = pageService.getById(params.long('id'))
            respond new PageVO(page)
        } else {
            List<Page> pages = pageService.list()
            respond pages.stream().map { new PageVO(it) }.collect(Collectors.toList())
        }
    }
}
