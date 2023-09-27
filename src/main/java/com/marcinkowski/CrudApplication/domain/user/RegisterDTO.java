package com.marcinkowski.CrudApplication.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
