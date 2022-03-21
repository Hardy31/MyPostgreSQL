package Lesson3_DAO.jdbc;

import Lesson3_DAO.model.User;
import com.sun.istack.internal.NotNull;

public interface DAO <Entity, Key> {
//    boolean creat(Entity model);


    Entity read(Key key);
    boolean update(Entity entity);
    boolean delete (Entity entity);
}
