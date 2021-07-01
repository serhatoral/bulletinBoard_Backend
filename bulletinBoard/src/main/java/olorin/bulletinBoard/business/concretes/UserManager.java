package olorin.bulletinBoard.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import olorin.bulletinBoard.business.abstracts.UserService;
import olorin.bulletinBoard.core.dataAccess.UserDao;
import olorin.bulletinBoard.core.entities.User;
import olorin.bulletinBoard.core.utilities.results.DataResult;
import olorin.bulletinBoard.core.utilities.results.Result;
import olorin.bulletinBoard.core.utilities.results.SuccessDataResult;
import olorin.bulletinBoard.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.getByEmail(email),"Kullanıcı bulundu.");
	}

}
