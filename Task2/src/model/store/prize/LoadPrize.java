package model.store.prize;


import java.io.*;

public class LoadPrize {

    public Serializable load(String path){
        PrizeDraw prizeDraw;
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            prizeDraw = (PrizeDraw) objectInputStream.readObject();
            objectInputStream.close();
            return prizeDraw;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

}
