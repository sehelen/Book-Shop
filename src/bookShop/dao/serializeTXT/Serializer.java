package bookShop.dao.serializeTXT;

import java.io.*;

public class Serializer<T> {

    /**
     * Saves list into the txt file path
     *
     * @param list
     * @param path
     * @throws IOException
     */
    public void save(T list, String path) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(list);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            out.close();
        }
    }

    /**
     * Uploads object from txt file path
     *
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public T load(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(path));
            T obj = (T) in.readObject();
            return obj;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            in.close();
        }
    }
}
