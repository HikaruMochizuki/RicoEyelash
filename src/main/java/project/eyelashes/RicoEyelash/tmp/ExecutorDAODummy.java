package project.eyelashes.RicoEyelash.tmp;

import project.eyelashes.RicoEyelash.gear.Executor.ExecutorDAO;

public class ExecutorDAODummy implements ExecutorDAO {

	@Override
	public boolean isExistingUser(String inName) {
		if("login".equals(inName)){
			return true;
		}
		return false;
	}

}
