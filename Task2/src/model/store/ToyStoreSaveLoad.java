package model.store;

import java.io.*;
import java.util.List;

public class ToyStoreSaveLoad implements Writable {

    @Override
    public boolean save(Serializable serializable, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }


    /**
     * Передаем строкой список всех файлов с расширением txt в папке с проектом (для вывода списка всех
     * сохраненных файлов программы
     * @return
     */
    public String showAllSavedFiles(){
        StringBuilder stringBuilder = new StringBuilder();
        String path = new File("").getAbsolutePath();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files){
            if (file.getName().toLowerCase().contains("txt")){
                if (stringBuilder.isEmpty()){
                    stringBuilder.append("Список сохранненых файлов: ").append("\n");
                }
                stringBuilder.append(file.getName()).append("\n");
            }
        }
        if(stringBuilder.isEmpty()){
            return null;
        } else {
            return stringBuilder.toString();
        }
    }



    public Serializable load(String path){
        ToyStore toyStore;
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            toyStore = (ToyStore) objectInputStream.readObject();
            objectInputStream.close();
            return toyStore;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

}
