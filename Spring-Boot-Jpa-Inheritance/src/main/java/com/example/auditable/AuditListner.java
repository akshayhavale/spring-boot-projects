package com.example.auditable;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListner {

	@PrePersist
	public void onSave(Object o) {
		if (o instanceof Auditable) {
			Auditable audit = (Auditable) o;
			AuditSection auditSection = audit.getAuditSection();

			auditSection.setDateModified(new Date());
			if (auditSection.getDateCreated() == null) {
				auditSection.setDateCreated(new Date());
			}
			audit.setAuditSection(auditSection);
		}
	}

	@PreUpdate
	public void onUpdate(Object o) {
		if (o instanceof Auditable) {
			Auditable audit = (Auditable) o;
			AuditSection auditSection = audit.getAuditSection();

			auditSection.setDateModified(new Date());
			if (auditSection.getDateCreated() == null) {
				auditSection.setDateCreated(new Date());
			}
			audit.setAuditSection(auditSection);
		}
	}

}
