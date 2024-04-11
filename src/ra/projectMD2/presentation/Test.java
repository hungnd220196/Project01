package ra.projectMD2.presentation;

import org.mindrot.jbcrypt.BCrypt;
import ra.projectMD2.business.entity.User;
import ra.projectMD2.business.utils.IOFile;

import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> users = IOFile.readFromFile(IOFile.USER_PATH);
        User admin = new User();
        admin.setUserId(1);
        admin.setUserName("admin123");
        admin.setPassword(BCrypt.hashpw("admin123", BCrypt.gensalt(5)));
        admin.setEmail("Hung@gmail.com");
        admin.setPhone("0912999999");
        admin.setCreatedAt(LocalDate.now());
        admin.setUpdatedAt(LocalDate.now());
        admin.setRole(false);
        admin.setStatus(true);
        users.add(admin);
        IOFile.writeToFile(IOFile.USER_PATH, users);
    }
}
