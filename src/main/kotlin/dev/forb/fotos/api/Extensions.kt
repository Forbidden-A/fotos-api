package dev.forb.fotos.api

import dev.forb.fotos.api.repositories.UserRepository

fun UserRepository.findForLogin(login: String) = findByEmail(login) ?: findByUsername(login)
