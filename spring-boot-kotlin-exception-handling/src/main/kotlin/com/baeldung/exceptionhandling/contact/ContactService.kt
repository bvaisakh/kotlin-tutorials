package com.baeldung.exceptionhandling.contact

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ContactService {
    val contacts: ConcurrentHashMap<String, Contact> = ConcurrentHashMap()
    val contactGroups: ConcurrentHashMap<String, Boolean?> = ConcurrentHashMap()

    fun createContact(contact: Contact): Contact {
        checkContactInfoValidity(contact)
        checkForDuplicates(contact)
        upsertContactGroup(contact.contactGroup)

        return contacts.put(contact.name, contact) ?: throw RuntimeException("Something unforeseen gone wrong")
    }

    private fun upsertContactGroup(contactGroup: String) {
        contactGroups[contactGroup] = true
    }

    private fun checkContactInfoValidity(contact: Contact) {
        if (contact.name == null) {
            throw InvalidContactInfoException("Contact name is missing")
        }

        if (contact.phoneNumber == null) {
            throw InvalidContactInfoException("Phone number is missing")
        }
    }

    private fun checkForDuplicates(contact: Contact) {
        val existingContact = contacts.put(contact.name, contact)

        if (existingContact != null) {
            throw DuplicateContactException("A Contact with name ${contact.name} already exists")
        }
    }

}