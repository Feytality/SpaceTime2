package org.soen387.domain.model.player;

import java.sql.SQLException;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.uow.MissingMappingException;
import org.dsrg.soenea.uow.UoW;

import org.soen387.domain.model.player.tdg.PlayerTDG;

public class PlayerFactory {

	/**
	 * Registering new with unit of work.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws MissingMappingException
	 * @throws MapperException
	 */
	public static Player createNew(String firstName, String lastName,
			String email, IUser user) throws SQLException,
			MissingMappingException, MapperException {
		Player player = new Player(PlayerTDG.getMaxId(), 01, firstName,
				lastName, email, user);
		UoW.getCurrent().registerNew(player);
		return player;
	}

	/**
	 * Registering clean with unit of work.
	 * @param id
	 * @param version
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws MissingMappingException
	 * @throws MapperException
	 */
	public static Player createClean(long id, long version, String firstName,
			String lastName, String email, IUser user) throws SQLException,
			MissingMappingException, MapperException {
		Player player = new Player(id, version, firstName, lastName, email,
				user);
		UoW.getCurrent().registerClean(player);
		return player;
	}
}