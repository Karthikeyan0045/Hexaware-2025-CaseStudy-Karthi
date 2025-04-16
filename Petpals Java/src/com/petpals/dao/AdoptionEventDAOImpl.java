package com.petpals.dao;

import com.petpals.util.DBConnUtil;

import java.sql.*;

public class AdoptionEventDAOImpl implements AdoptionEventDAO {

    public void listEvents() {
        try (Connection con = DBConnUtil.getConnection()) {
            String sql = "SELECT * FROM AdoptionEvents";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("EventID") + ", " +
                                   "Name: " + rs.getString("Eventname") + ", " +
                                   "Date: " + rs.getTimestamp("EventDate") + ", " +
                                   "Location: " + rs.getString("Location"));
            }
        } catch (Exception e) {
            System.out.println("Error fetching events: " + e.getMessage());
        }
    }

    public void registerParticipant(String name, String type, int eventId) {
        try (Connection con = DBConnUtil.getConnection()) {
            String sql = "INSERT INTO Participants (Participantname, ParticipantType, EventID) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, eventId);
            ps.executeUpdate();
            System.out.println("Participant registered.");
        } catch (Exception e) {
            System.out.println("Error registering participant: " + e.getMessage());
        }
    }
}
