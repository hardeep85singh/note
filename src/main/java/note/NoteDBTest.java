package note;

public class NoteDBTest {
    public static void main(String[] args) {
        NoteDBImpl noteDB = new NoteDBImpl();

        Note note1 = new Note("1", "water", "drink plenty of water daily");
        Note note2 = new Note("2", "medicine", "take daily medicine");
        Note note3 = new Note("3", "study", "do atleast 10 hours of study daily");
        Note note4 = new Note("4", "book", " order book");
        Note note;

        for (int i = 5; i < 10; i++) {
            String str = Integer.toString(i);
            noteDB.write(new Note(str, "new", "description"));
        }


        System.out.println(noteDB.read("3"));

        noteDB.update(new Note("3", "Jogging", "Regular jogging"));
        System.out.println(noteDB.read("3"));

    }
}
