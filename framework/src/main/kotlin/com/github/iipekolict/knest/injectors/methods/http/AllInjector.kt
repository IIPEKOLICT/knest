package com.github.iipekolict.knest.injectors.methods.http

import com.github.iipekolict.knest.annotations.methods.All
import com.github.iipekolict.knest.data.Endpoint
import com.github.iipekolict.knest.injectors.methods.EndpointInjector
import kotlin.reflect.full.findAnnotation

class AllInjector : EndpointInjector<All>() {

    override fun findAnnotation(): All? {
        return handler.findAnnotation()
    }

    override fun inject(): Endpoint {
        return Endpoint(
            paths = buildPaths(annotation.path, annotation.paths),
            method = null,
            handler = handler,
            swaggerCallback = swaggerCallback
        )
    }
}