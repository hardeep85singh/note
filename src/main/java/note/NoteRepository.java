package note;

import java.util.List;

public interface NoteRepository {// repo

    void write(Note note);

    Note read(String id);

    void update(Note note);

}
