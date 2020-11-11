package note;

public class NoteDBTest {
    public static void main(String[]args){
        NoteDBImpl noteDB = new NoteDBImpl();

        noteDB.write(new Note("1", "Water", "Drink water every hour"));
        
    }
}
