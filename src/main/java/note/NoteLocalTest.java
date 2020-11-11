package note;

public class NoteLocalTest {
    public static void main(String[]args){
        Note note1 = new Note("1","water", "drink plenty of water daily");
        Note note2 = new Note("2","medicine", "take daily medicine");
        Note note3 = new Note("3","study", "do atleast 10 hours of study daily");
        Note note4 = new Note("4","book", " order book");

        NoteLocalImpl notes = new NoteLocalImpl();

        notes.write(note1);
        notes.write(note2);
        notes.write(note3);
        notes.write(note4);

        System.out.println(notes.read("3"));

        Note note5 = new Note("4", "Books", "New Books");
        notes.update(note5);
//        notes.update(new Note("5", "Laptop", "Repair"));
        System.out.println(notes.read("4"));

    }
}
