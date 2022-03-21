package Lesson3_DAO.jdbc;


//https://www.youtube.com/watch?v=42feBSSKA9Q&list=PL7Bt6mWpiiza6CY8dJ9baIW6YokXkkAFy&index=3





public interface DAO <Entity, Key> {

//    boolean creat(Entity model);

    Entity read(Key key);
    boolean update(Entity entity);
    boolean delete (Entity entity);
}
