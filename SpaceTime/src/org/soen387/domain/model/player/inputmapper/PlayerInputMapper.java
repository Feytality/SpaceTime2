package org.soen387.domain.model.player.inputmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.IdentityMap;
import org.dsrg.soenea.domain.user.IUser;
import org.dsrg.soenea.domain.user.UserProxy;
import org.dsrg.soenea.uow.MissingMappingException;
import org.dsrg.soenea.uow.UoW;
import org.soen387.domain.model.player.IPlayer;
import org.soen387.domain.model.player.Player;
import org.soen387.domain.model.player.PlayerFactory;
import org.soen387.domain.model.player.finder.PlayerFinder;

public class PlayerInputMapper {

	public static Player find(long id) throws SQLException,
			DomainObjectNotFoundException, MissingMappingException,
			MapperException {
		Player p = IdentityMap.get(id, Player.class);

		if (p != null) {
			return p;
		}

		ResultSet rs = PlayerFinder.find(id);
		if (rs.next()) {
			p = buildPlayer(rs);
			rs.close();
			// Register clean with UoW since just got it.
			UoW.getCurrent().registerClean(p);
			return p;
		}
		throw new DomainObjectNotFoundException(
				"Could not create a Player with id \"" + id + "\"");
	}

	public static Player find(IUser u) throws SQLException, MissingMappingException, MapperException {
		ResultSet rs = PlayerFinder.findByUser(u.getId());
		if (rs.next()) {
			long id = rs.getLong("id");
			Player p = IdentityMap.get(id, Player.class);
			if (p != null)
				return p;
			p = buildPlayer(rs);
			rs.close();
			UoW.getCurrent().registerClean(p);
			return p;
		}
		throw new DomainObjectNotFoundException(
				"Could not create a Player from User with id \"" + u.getId()
						+ "\"");
	}

	public static List<IPlayer> findAll() throws MapperException {
		try {
			ResultSet rs = PlayerFinder.findAll();
			return buildCollection(rs);
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}

	public static List<IPlayer> buildCollection(ResultSet rs)
			throws SQLException, MissingMappingException, MapperException {
		ArrayList<IPlayer> l = new ArrayList<IPlayer>();
		while (rs.next()) {
			long id = rs.getLong("id");
			Player p = null;

			if (IdentityMap.has(id, Player.class)) {
				p = IdentityMap.get(id, Player.class);
			} else {
				p = buildPlayer(rs);
				UoW.getCurrent().registerClean(p);
			}
			l.add(p);
		}
		return l;
	}

	private static Player buildPlayer(ResultSet rs) throws SQLException,
			MissingMappingException, MapperException {
		return PlayerFactory.createClean(rs.getLong("id"),
				rs.getInt("version"), rs.getString("firstname"), 
				rs.getString("lastname"), rs.getString("email"),
				new UserProxy(rs.getLong("user")));
	}

}
