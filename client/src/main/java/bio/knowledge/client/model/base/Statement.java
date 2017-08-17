package bio.knowledge.client.model.base;

import bio.knowledge.client.model.StatementsObject;
import bio.knowledge.client.model.StatementsPredicate;
import bio.knowledge.client.model.StatementsSubject;

public interface Statement extends IdentifiedEntity {
	public StatementsSubject getSubject();
	public StatementsObject getObject();
	public StatementsPredicate getPredicate();
}
