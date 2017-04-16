package com.pagebuilder

class PageService {

    Page getById(Long id) {
        Page.get(id)
    }

    List<Page> list() {
        Page.list()
    }
}
