package note;

import java.io.*;
import java.util.Scanner;

public class NoteLocalImpl implements NoteRepository {
    final String SEPARATOR = "#=";

    @Override
    public void write(Note note) {
        try {
            File inputFile = new File("NotesData.txt");
            FileWriter writer = new FileWriter(inputFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(note.getId() + SEPARATOR + note.getTitle() + SEPARATOR + note.getDescription());
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
                // code for reading string title
                String[] lineArray = line.split(SEPARATOR);
                if (lineArray[0].equals(id)) {
//                    note.setTitle(lineArray[1]);
//                    note.setDescription(lineArray[2]);
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
//        if (read(note.getId()) != null) {
//            write(note);
//        } else {
//            throw new NullPointerException("The Note you are trying to update is not present");
//        }
    }
}
