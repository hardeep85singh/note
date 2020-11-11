package note;

import java.util.*;

public class NoteMemoryImpl implements NoteRepository {
   // private List<Note> allNotes = new ArrayList<>();
    Map<String, Note> notesData = new HashMap<String, Note>();

    @Override
    public void write(Note note) {
        notesData.put(note.getId(), note);
    }

    @Override
    public Note read(String id) {
        if(notesData.get(id) == null){
            throw new NullPointerException("Search couldn't find this note.");
        } else if (notesData.isEmpty()){
            throw new ClassCastException("You must enter valid key.");
        } else {
            return notesData.get(id);
        }
    }

    @Override
    public void update(Note note) {
        if(notesData.containsKey(note.getId())){
            write(note);
        } else {
            throw new NullPointerException("The Note you are trying to update is not present");
        }
    }

}
