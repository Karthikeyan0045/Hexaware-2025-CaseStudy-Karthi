package com.petpals.dao;

public interface AdoptionEventDAO {
    void listEvents();
    void registerParticipant(String name, String type, int eventId);
}
