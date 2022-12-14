package com.github.iipekolict.knest.injectors

import com.github.iipekolict.knest.exceptions.KNestException

abstract class AnnotationInjector<A : Annotation> {

    private var annotationInstance: A? = null

    protected val annotation: A
        get() = annotationInstance ?: throw KNestException("Can't use provided annotation here")

    fun canActivate(): Boolean {
        annotationInstance = findAnnotation()
        return annotationInstance != null
    }

    protected abstract fun findAnnotation(): A?
}