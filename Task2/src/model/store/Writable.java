package model.store;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String FileName);
}
