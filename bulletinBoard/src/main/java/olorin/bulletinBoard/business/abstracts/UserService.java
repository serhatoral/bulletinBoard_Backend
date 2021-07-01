package olorin.bulletinBoard.business.abstracts;

import olorin.bulletinBoard.core.entities.User;
import olorin.bulletinBoard.core.utilities.results.DataResult;
import olorin.bulletinBoard.core.utilities.results.Result;


public interface UserService {

	Result add(User user);
	DataResult<User> getByEmail(String email);
}
