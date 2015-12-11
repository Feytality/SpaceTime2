package org.soen387.test;

import java.sql.SQLException;

import org.dsrg.soenea.application.servlet.impl.SmartDispatcherServlet;
import org.dsrg.soenea.service.tdg.UserTDG;
import org.soen387.domain.model.challenge.tdg.ChallengeTDG;
import org.soen387.domain.model.match.tdg.MatchTDG;
import org.soen387.domain.model.notification.tdg.ChallengeNotificationTDG;
import org.soen387.domain.model.pilot.tdg.PilotTDG;
import org.soen387.domain.model.player.tdg.PlayerTDG;
import org.soen387.domain.model.team.tdg.TeamMembershipTDG;
import org.soen387.domain.model.team.tdg.TeamTDG;

public class Setup {

	public static void main(String[] args) throws InterruptedException {
		SmartDispatcherServlet.prepareDbRegistry("");
		try {
			PlayerTDG.createTable();
			UserTDG.createTable();
			UserTDG.createUserRoleTable();
			TeamTDG.createTable();
			PilotTDG.createTable();
			TeamMembershipTDG.createTable();
			MatchTDG.createTable();
			ChallengeTDG.createTable();
			ChallengeNotificationTDG.createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}