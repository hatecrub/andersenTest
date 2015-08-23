package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 22.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String selectUsers = "select * from users";
        String selectNotes = "select * from notes";
        String selectUserNotes = "select users.id, users.username, notes.note from users, notes";
        String selectUserNotes2 = "select users.id, users.username, notes.note from users, notes where user.id = 1 and notes.user_id = 1";

        try {

            /*for(int i = 1; i < 15; i++) {
                worker.insertNote("zxc", "note" + i);
            }*/


            worker.updateNote("11111111",82);

            Statement statement = worker.getConnection().createStatement();

           // worker.insertNote(1, "jopa jopa");

            ResultSet res = statement.executeQuery(selectNotes);

            /*while (res.next()) {
                System.out.print(res.getInt("id") + " ");
                System.out.print(res.getString("username")+ " ");
                System.out.println(res.getString("note" + " "));
                //System.out.println(user.toString());
            }*/

            while (res.next()) {
                Note note = new Note();
                note.setId(res.getInt("id"));
                note.setUsername(res.getString("username"));
                note.setNote(res.getString("note"));
                System.out.println(note.toString());
            }


        } catch (SQLException e) {
            System.out.println("can't create statement");
        }
    }
}
