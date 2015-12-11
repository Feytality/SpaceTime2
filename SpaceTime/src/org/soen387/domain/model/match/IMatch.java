package org.soen387.domain.model.match;

import org.dsrg.soenea.domain.interf.IDomainObject;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.team.ITeam;

public interface IMatch extends IDomainObject<Long> {

	public ITeam getFirstTeam();

	public void setFirstTeam(ITeam firstTeam);

	public ITeam getSecondTeam();

	public void setSecondTeam(ITeam secondTeam);

	public GameStatus getStatus();

	public void setStatus(GameStatus status);

	public IPlayer getWinner();

	public void setWinner(IPlayer player);

	public boolean isTied();

	public boolean isOver();

}