package org.soen387.test;

import java.sql.SQLException;

import org.dsrg.soenea.application.servlet.impl.SmartDispatcherServlet;
import org.dsrg.soenea.service.tdg.UserTDG;
import org.soen387.domain.model.challenge.tdg.ChallengeTDG;
import org.soen387.domain.model.match.tdg.MatchTDG;
import org.soen387.domain.model.notification.challenge.tdg.ChallengeNotificationTDG;
import org.soen387.domain.model.notification.tdg.NotificationTDG;
import org.soen387.domain.model.pilot.tdg.PilotTDG;
import org.soen387.domain.model.player.tdg.PlayerTDG;
import org.soen387.domain.model.team.tdg.TeamMembershipTDG;
import org.soen387.domain.model.team.tdg.TeamTDG;

public class Teardown {

	public static void main(String[] args) throws InterruptedException {
		SmartDispatcherServlet.prepareDbRegistry("");
		try {
			PlayerTDG.dropTable();
		} catch (SQLException e) {	}
		try {
			UserTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			UserTDG.dropUserRoleTable();
		} catch (SQLException e) {	}
		
		try {
			TeamTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			PilotTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			TeamMembershipTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			MatchTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			ChallengeTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			NotificationTDG.dropTable();
		} catch (SQLException e) {	}
		
		try {
			ChallengeNotificationTDG.dropTable();
		} catch (SQLException e) {	}
		
	}

}