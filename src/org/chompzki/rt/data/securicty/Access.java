package org.chompzki.rt.data.securicty;

public abstract class Access {
	
	protected ISecurityMaster master = null;
	protected AccessLevel level = null;
	protected ISecurityObject object = null;
	
	
	
	public boolean authenticate(String action) {
		// TODO Auto-generated method stub
		
		
		
		return standardCheck() || userCheck() || groupCheck();
	}
	
	protected abstract boolean standardCheck(); //Check if action is accessible to "anyone". Action, & Object
	protected abstract boolean userCheck(); //Check if action is accessible to user. User, Action, & Object
	protected abstract boolean groupCheck(); //Check if action is accessible to group. Group, Action, & Object
	
}
