package ra.projectMD2.business.designImp;

import org.mindrot.jbcrypt.BCrypt;
import ra.projectMD2.business.design.IAuthentic;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;

import java.util.Comparator;
import java.util.List;

import static org.mindrot.jbcrypt.BCrypt.checkpw;

public class AuthenticationService implements IAuthentic {
    private static List<User> userList = IOFile.readFromFile(IOFile.USER_PATH);


    @Override
    public User login(String username, String password) {
        User userLogin = getUserFromUsername(username);
        if (userLogin == null) {
            return null;
        }
        boolean checkLogin = checkpw(password, userLogin.getPassword()); // kiem tra mat khau khop hay khong
        if (checkLogin) {
            return userLogin;
        }
        return null;
    }

    @Override
    public void register(User user) {
        user.setUserId(getNewId());
        user.setRole(true);
        user.setStatus(true);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5)));

        userList.add(user);
        IOFile.writeToFile(IOFile.USER_PATH, userList);
    }

    private User getUserFromUsername(String username) {
        return userList.stream().filter(user -> user.getUserName().equals(username)).findFirst().orElse(null);
    }

    public int getNewId() {
        int max = userList.stream().map(User::getUserId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}