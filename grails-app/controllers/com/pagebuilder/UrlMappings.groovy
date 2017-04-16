package com.pagebuilder

class UrlMappings {

    static mappings = {
        "/api/v1/model/$id?"(controller: "model", parseRequest: true) {
            action = [GET: "index", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/api/v1/template/$id?"(controller: "template", parseRequest: true) {
            action = [GET: "index", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/api/v1/dataType/$id?"(controller: "dataType", parseRequest: true) {
            action = [GET: "index", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/api/v1/page/$id?"(controller: "page", parseRequest: true) {
            action = [GET: "index", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/api/v1/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/template"(view:"/index")
        "/model"(view:"/index")
        "/page"(view:"/index")
        "/aboutus"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
