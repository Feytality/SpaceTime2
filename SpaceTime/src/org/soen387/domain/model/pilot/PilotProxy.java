package org.soen387.domain.model.pilot;

import org.dsrg.soenea.domain.DomainObjectCreationException;
import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.proxy.DomainObjectProxy;
import org.soen387.domain.model.pilot.inputmapper.PilotInputMapper;
import org.soen387.domain.model.player.IPlayer;

public class PilotProxy extends DomainObjectProxy<Long, Pilot> implements IPilot {

	public PilotProxy(long id) {
		super(id);
	}

	@Override
	protected Pilot getFromMapper(Long id) throws MapperException,
			DomainObjectCreationException {
		try {
			return PilotInputMapper.find(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getName() {
		return getInnerObject().getName();
	}

	@Override
	public void setName(String name) {
		getInnerObject().setName(name);
	}

	@Override
	public IPlayer getPlayer() {
		return getInnerObject().getPlayer();
	}

	@Override
	public void setPlayer(IPlayer player) {
		getInnerObject().setPlayer(player);
	}

}
