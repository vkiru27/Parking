package Parking.controller;

import Parking.dtos.IssueTicketRequestDTO;
import Parking.dtos.IssueTicketResponseDTO;

public class TicketController {
    private TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
        // private constructor to prevent instantiation
    }
    
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request){
        IssueTicketRequestDTO response = new IssueTicketResponseDTO();

        try {
            Ticket ticket= ticketService.issueTicket();
            response.setTicketID(ticket.getId());
            response.setSlotNumber(ticket.getParkingSlot().getSlotNumber());
            response.setResponseStatus(ResponseStatus.Success);
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Failure);
            response.setFailureMessage(e.getMessage());
        }
        return response;
        
    }
}
