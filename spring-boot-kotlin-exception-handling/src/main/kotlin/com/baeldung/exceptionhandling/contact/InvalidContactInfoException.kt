package com.baeldung.exceptionhandling.contact

class InvalidContactInfoException(override val message: String) : RuntimeException()
