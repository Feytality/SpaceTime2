package org.soen387.domain.model.notification;

import org.dsrg.soenea.domain.DomainObject;
import org.soen387.domain.model.player.IPlayer;

public class Notification extends DomainObject<Long> implements INotification {
	
	private boolean seen;
	private IPlayer recipient;

	public Notification(long id, long version, IPlayer recipient, boolean seen) {
		super(id, version);
		this.recipient = recipient;
		this.seen = seen;
	}
	
	@Override
	public boolean isSeen() {
		return seen;
	}

	@Override
	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	@Override
	public IPlayer getRecipient() {
		return recipient;
	}

	@Override
	public void setRecipient(IPlayer recipient) {
		this.recipient = recipient;
	}

}
