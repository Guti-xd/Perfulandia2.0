package com.soporte.service;

import com.soporte.models.Ticket;
import com.soporte.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TicketService {

    @Autowired 
    private TicketRepository ticketRepository;

    public List<Ticket> getAll() {
        return ticketRepository.findAll(); 
    }

    // Buscar 
    public Ticket getById(Integer id) {
        Optional<Ticket> ticket = ticketRepository.findById(id); 
        return ticket.orElse(null); 
    }

    // Crear   
    public Ticket add(Ticket ticket) {
        return ticketRepository.save(ticket); // Guarda y retorna   
    }

    // Actualizar 
    public Ticket update(Integer id, Ticket ticket) {
        if (ticketRepository.existsById(id)) {
            ticket.setIdTicket(id); // Aseguramos que se use el mismo ID
            return ticketRepository.save(ticket); // Guarda los cambios
        }
        return null; 
    }

    // Eliminar 
    public Ticket delete(Integer id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            ticketRepository.deleteById(id); // Elimina 
            return ticket.get(); // Retorna 
        }
        return null; 
    }
}