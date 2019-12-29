package com.pawga.myapplication01

/**
 * Created by pawga on 29.12.19 17:11
 */

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@javax.inject.Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ActivityScope

@javax.inject.Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ActivityViewModelScope
