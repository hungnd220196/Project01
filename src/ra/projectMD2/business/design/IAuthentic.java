package ra.projectMD2.business.design;

import ra.projectMD2.business.entity.User;

public interface IAuthentic {
    User login(String username, String password);
    void register(User user);
}
