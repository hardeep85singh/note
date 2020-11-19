package note;

import java.io.*;

public class NoteLocalImpl implements NoteRepository {
    final String SEPARATOR = "#=";

    @Override
    public void write(Note note) {
        try {
            File inputFile = new File("NotesData.txt");
            FileWriter writer = new FileWriter(inputFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(note.getId() + SEPARATOR + note.getTitle() + SEPARATOR + note.getDescription());// separate function
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Note read(String id) {
        try {
            FileReader reader = new FileReader("NotesData.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(SEPARATOR);// should have been a function
                if (lineArray[0].equals(id)) {// sho
                    return new Note(lineArray[0], lineArray[1], lineArray[2]);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Note note) {
        try {
            FileReader file = new FileReader("NotesData.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] lineArray = line.split(SEPARATOR);
                if(note.getId().equals(lineArray[0])){
                    lineArray[1] = note.getTitle();
                    lineArray[2] = note.getDescription();
                }
            }
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
