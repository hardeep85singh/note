package note;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoteDBImpl implements NoteRepository {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "hardeep"; // environment variable impliment
    String password = "root"; // environment variable

    @Override
    public void write(Note note) {
        String id = note.getId();
        String title = note.getTitle();
        String description = note.getDescription();
        String query = "INSERT INTO notesdb(id, title, description) VALUES (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            pst.setString(2, title);
            pst.setString(3, description);
            pst.execute();

            pst.close();
            con.close();

        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(NoteDBImpl.class.getName());// convert exception to database error
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public Note read(String id) {
        String query = "SELECT * FROM notesdb WHERE id = ?";
        Note note = null;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                note = new Note(id, title, description);
            }
            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);// wrong
        }
        return note;
    }

    @Override
    public void update(Note note) {
        String query = "UPDATE notesdb SET title = ?, description = ? WHERE id = ?";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, note.getTitle());
            pst.setString(2, note.getDescription());
            pst.setString(3, note.getId());
            pst.executeUpdate();

            pst.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0); // wrong,
        }
    }
}
