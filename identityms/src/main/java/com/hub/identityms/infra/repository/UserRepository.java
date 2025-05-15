package com.hub.identityms.infra.repository;

import com.hub.identityms.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
}
