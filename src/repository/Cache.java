package repository;

public interface Cache {

    void put(String key, Object value, long periodInMillis);

    void remove(String key);

    Object get(String key);

    void clear();

    long size();
}