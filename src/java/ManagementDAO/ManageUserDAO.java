/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagementDAO;

import DAO.UserDAO;
import Entity.User;
import Exception.MyException;
import java.util.List;

/**
 *
 * @author bactv
 */
public class ManageUserDAO {
     public static List<User> getUser() throws MyException {
         return UserDAO.getUser();
     }
     public static boolean insertUser(User user) throws MyException {
         return UserDAO.insertUser(user);
     }
       public static User getOneUser(String userName)throws MyException{
          return UserDAO.getOneUser(userName);
      }
}
