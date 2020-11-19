package note;

import java.util.*;

public class NoteMemoryImpl implements NoteRepository {
    private Map<String, Note> notesData = new HashMap<String, Note>();

    @Override
    public void write(Note note) {
        notesData.put(note.getId(), note);
    }

    @Override
    public Note read(String id) {
        if(notesData.get(id) == null){
            throw new NullPointerException("Search couldn't find this note.");// note note found exception
        }  else {
            return notesData.get(id);
        }
    }

    @Override
    public void update(Note note) {
        if(notesData.containsKey(note.getId())){
            write(note);
        } else {
            throw new NullPointerException("The Note you are trying to update is not present");// Note not found exception
        }
    }

}
