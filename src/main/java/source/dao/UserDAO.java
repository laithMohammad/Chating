package source.dao;

import actors.User;

public interface UserDAO {

    public User select(int id);

    public User selectAll(int[] ids);

    public void delete(int id);

    public void insert(User user);

    public void update(User user);
}