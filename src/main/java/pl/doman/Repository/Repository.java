package pl.doman.Repository;

public interface Repository<T> {

    T save(T entity);

}
