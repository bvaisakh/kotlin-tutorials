package com.baeldung.exceptionhandling.contact

class DuplicateContactException(override val message: String) : RuntimeException()
