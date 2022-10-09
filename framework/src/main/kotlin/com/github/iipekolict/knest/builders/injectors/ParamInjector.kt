package com.github.iipekolict.knest.builders.injectors

import com.github.iipekolict.knest.annotations.properties.Param
import kotlin.reflect.full.findAnnotation

class ParamInjector : PropertyInjector<Param, Any?>() {

    override fun findAnnotation(): Param? {
        return parameter.findAnnotation()
    }

    override suspend fun inject(): Any? {
        return if (annotation.name.isNotBlank()) {
            pipeParameter(call.parameters[annotation.name])
        } else {
            call.parameters
        }
    }
}