package ra.projectMD2.business.utils;

import ra.projectMD2.business.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static final String USER_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\user.txt";
    public static final String USERLOGIN_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\userLogin.txt";
    public static final String SINGERS_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\singer.txt";
    public static final String SONGS_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\song.txt";
    public static final String HISTORY_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\history.txt";
    public static final String ALBUM_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\album.txt";
    public static final String SONGCATEGORY_PATH = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\PROJECT-MODULE02\\src\\ra\\projectMD2\\business\\data\\songcategory.txt";

    public static <T> void writeToFile(String path, List<T> list) {
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> List<T> readFromFile(String path) {
        List<T> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public static <T> void writeUserLoginToFile(String path, T t) {
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User readUserLoginFromFile(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User users = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            users = (User) ois.readObject();
            ois.read();
            ois.close();
        } catch (EOFException | FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}