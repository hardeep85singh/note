package note;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoteDBImpl implements NoteRepository {

    String url = "jbdc:postgresql://localhost:5432/postgres";
    String user = "hardeep";
    String password = "root";
//    Map<String, Note> notesData = new HashMap<>();

    @Override
    public void write(Note note) {
        String id = note.getId();
        String title = note.getTitle();
        String description = note.getDescription();
        String query = "INSERT INTO notesDB(id, title, description) VALUES (?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            pst.setString(2, title);
            pst.setString(3, description);
//            notesData.put(id, note);

        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(NoteDBImpl.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }

    }

    @Override
    public Note read(String id) {
        String query = "select * from notesDB";
        Note note = null;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                note = new Note(id, title, description);
            }

        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(NoteDBImpl.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }
        return note;
    }

    @Override
    public void update(Note note) {

    }
}
