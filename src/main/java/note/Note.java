package note;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private String id;
    private String title;
    private String description;
//    private List<Note> noteList = new ArrayList<>();

    public Note(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s%s%n%s%s%n", "Title: ", getTitle(),
                "Description: ", getDescription());
    }
}
