package org.soen387.domain.model.player;


import java.util.List;

import org.dsrg.soenea.domain.interf.IDomainObject;
import org.dsrg.soenea.domain.user.IUser;

import org.soen387.domain.model.team.ITeam;
import org.soen387.domain.model.pilot.IPilot;

public interface IPlayer extends IDomainObject<Long>{

	public abstract String getFirstName();

	public abstract void setFirstName(String firstName);

	public abstract String getLastName();

	public abstract void setLastName(String lastName);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract IUser getUser();

	public abstract void setUser(IUser user);
	
	public abstract void addPilot(IPilot pilot);
	
	public abstract void removePilot(IPilot pilot);
	
	public abstract List<IPilot> getPilots();
	
	public abstract void setPilots(List<IPilot> pilots);
	
	public abstract List<ITeam> getTeams();
	
	public abstract void setTeams(List<ITeam> teams);
	
	public abstract void addTeam(ITeam team);
	
	public abstract void removeTeam(ITeam team);

}