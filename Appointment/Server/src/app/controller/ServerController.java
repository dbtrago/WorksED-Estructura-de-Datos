package app.controller;
import java.util.Date;

import domain.Appointment;
import domain.Customer;
import domain.Ticket;

public class ServerController
{
    // Metodos para usar
    public Appointment openAppointment(Customer customer, Date date, String description)
    {
        return null;
    }
    public boolean closeAppointment(String id)
    {
        return false;
    }

    public boolean cancelAppointment(String id)
    {
        return false;
    }
    public Appointment getAppointmentById(String id)
    {
        return null;
    }
    public Appointment[] getAppointments()
    {
        return null;
    }
    public Ticket getTicket (String appointmentId)
    {
        return null;
    }
}
