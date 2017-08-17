package bio.knowledge.client.model.base;

import java.util.List;

public interface Concept extends IdentifiedEntity {
//	public InlineResponse2002 id(String id);
	public String getId();
	public void setId(String id);
//	public InlineResponse2002 name(String name);
	public String getName();
	public void setName(String name);
//	public InlineResponse2002 semanticGroup(String semanticGroup);
	public String getSemanticGroup();
	public void setSemanticGroup(String semanticGroup);
//	public InlineResponse2002 synonyms(List<String> synonyms);
//	public InlineResponse2002 addSynonymsItem(String synonymsItem);
	public List<String> getSynonyms();
	public void setSynonyms(List<String> synonyms);
//	public InlineResponse2002 definition(String definition);
	public String getDefinition();
	public void setDefinition(String definition);
}
