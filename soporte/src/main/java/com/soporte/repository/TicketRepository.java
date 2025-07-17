package com.soporte.repository;

import com.soporte.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}