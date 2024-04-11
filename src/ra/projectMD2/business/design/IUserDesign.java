package ra.projectMD2.business.design;

import ra.projectMD2.business.entity.User;

public interface IUserDesign extends IGenericDesign<User, Integer> {
    void searchUserByName();
    User changeStatusUser(Integer id);

}
