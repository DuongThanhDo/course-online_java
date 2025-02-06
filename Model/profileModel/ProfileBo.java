package profileModel;

public class ProfileBo {
	ProfileDao pdao = new ProfileDao();
	
	public Profile getProfileByUserId(int user_id) throws Exception {
		return pdao.getProfileByUserId(user_id);
	}
	
	public int add(Profile profile) throws Exception {
		return pdao.add(profile);
	}
	
	public int update(Profile profile) throws Exception {
		return pdao.update(profile);
	}
}
