package database;

/**
 * Created by user on 22.08.2015.
 */
public class Note {

    private int id;
    private String username;
    private String note;

    public Note() {
    }

    public Note(String username, String note) {
        this.username = username;
        this.note = note;
    }

    public Note(int id, String username, String note) {
        this.id = id;
        this.username = username;
        this.note = note;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String print() {
        return id + "   " + note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "Username=" + username +
                ", note='" + note + '\'' +
                '}';
    }
}
