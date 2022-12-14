package com.github.iipekolict.knest.injectors.methods.http

import com.github.iipekolict.knest.annotations.methods.Patch
import com.github.iipekolict.knest.data.EndpointData
import com.github.iipekolict.knest.injectors.methods.EndpointInjector
import io.ktor.http.*
import kotlin.reflect.full.findAnnotation

class PatchInjector : EndpointInjector<Patch>() {

    override fun findAnnotation(): Patch? {
        return handler.findAnnotation()
    }

    override fun inject(): EndpointData {
        return EndpointData(
            paths = buildPaths(annotation.path, annotation.paths),
            method = HttpMethod.Patch,
            handler = handler,
            swaggerCallback = swaggerCallback
        )
    }
}