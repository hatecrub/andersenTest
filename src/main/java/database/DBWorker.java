package database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by user on 22.08.2015.
 */
public class DBWorker {
    private final String HOST = "jdbc:postgresql://localhost:5432/bdnotes";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "root";

    private final String SELECT_USERS = "select * from users";
    private final String SELECT_LAST_NOTES = "select * from notes where username = ? order by id desc limit 10  ";
    private final String SELECT_ALL_NOTES = "select * from notes where username = ? order by id desc  ";
    private final String SELECT_NOTE = "select note from notes where id = ?  ";
    private final String INSERT_NOTE = "insert into notes (username, note) values(?,?)";
    private final String REMOVE_NOTE = "delete from notes where id = ?";
    private final String UPDATE_NOTE = "update notes set note = ? where id = ?";

    private Connection connection;

    public DBWorker() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println("connection success!");
        } catch (SQLException e) {
            System.out.println("connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            e.printStackTrace();
        }
    }

    public boolean remove() {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println("close connection failed!");
            return false;
        }
    }

    public boolean insertNote(String username, String note) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTE);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, note);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Insert note failed!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeNote(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_NOTE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Remove note failed!");
            return false;
        }
    }

    public boolean updateNote(String newNote, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NOTE);
            preparedStatement.setString(1, newNote);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Remove note failed!");
            return false;
        }
    }

    public ArrayList selectUsers() {

        if(connection == null) {
            try {
                connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("connection failed");
                e.printStackTrace();
            }
        }

        ArrayList<User>users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet res =  statement.executeQuery(SELECT_USERS);
            while (res.next()) {
                User user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                users.add(user);
                System.out.println(user.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public ArrayList selectLastNotes(String username) {

        ArrayList<Note>notes = new ArrayList<Note>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_LAST_NOTES);
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Note note = new Note();
                note.setId(res.getInt("id"));
                note.setUsername(res.getString("username"));
                note.setNote(res.getString("note"));
                notes.add(note);
                System.out.println(note.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

    public ArrayList selectAllNotes(String username) {

        ArrayList<Note>notes = new ArrayList<Note>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NOTES);
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Note note = new Note();
                note.setId(res.getInt("id"));
                note.setUsername(res.getString("username"));
                note.setNote(res.getString("note"));
                notes.add(note);
                System.out.println(note.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

    public String selectNote(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_NOTE);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            res.next();
            return res.getString("note");
        } catch (SQLException e) {
            System.out.println("can't select note with id = " + id);
            e.printStackTrace();
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
