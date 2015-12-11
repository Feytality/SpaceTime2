package org.soen387.domain.model.match.inputmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.domain.mapper.IdentityMap;
import org.dsrg.soenea.uow.MissingMappingException;
import org.dsrg.soenea.uow.UoW;
import org.soen387.domain.model.match.GameStatus;
import org.soen387.domain.model.match.IMatch;
import org.soen387.domain.model.match.Match;
import org.soen387.domain.model.match.MatchFactory;
import org.soen387.domain.model.match.finder.MatchFinder;
import org.soen387.domain.model.team.TeamProxy;

public class MatchInputMapper {
	public static Match find(long id) throws SQLException,
			MissingMappingException, MapperException {

		Match m = IdentityMap.get(id, Match.class);

		if (m != null) {
			return m;
		}

		ResultSet rs = MatchFinder.find(id);
		if (rs.next()) {
			m = buildMatch(rs);
			rs.close();
			UoW.getCurrent().registerClean(m);
			return m;
		}
		throw new DomainObjectNotFoundException(
				"Could not start a Match with id \"" + id + "\"");
	}

	public static List<IMatch> findAll() throws MapperException {
		try {
			ResultSet rs = MatchFinder.findAll();
			return buildCollection(rs);
		} catch (SQLException e) {
			throw new MapperException(e);
		}
	}

	public static List<IMatch> buildCollection(ResultSet rs)
			throws SQLException, MissingMappingException, MapperException {
		ArrayList<IMatch> l = new ArrayList<IMatch>();
		while (rs.next()) {
			long id = rs.getLong("id");
			Match m = null;

			if (IdentityMap.has(id, Match.class)) {
				m = IdentityMap.get(id, Match.class);
			} else {
				m = buildMatch(rs);
				UoW.getCurrent().registerClean(m);
			}
			l.add(m);
		}
		return l;
	}

	private static Match buildMatch(ResultSet rs) throws SQLException,
			MissingMappingException, MapperException {
		return MatchFactory.createClean(rs.getLong("id"),
				rs.getLong("version"), new TeamProxy(rs.getLong("firstTeam")),
				new TeamProxy(rs.getLong("secondTeam")),
				GameStatus.valueOf(rs.getString("status")));
	}
}