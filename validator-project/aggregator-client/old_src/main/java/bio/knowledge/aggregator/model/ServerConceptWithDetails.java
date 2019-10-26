package bio.knowledge.aggregator.model;

import java.util.Objects;
import bio.knowledge.aggregator.model.ServerConceptWithDetailsBeaconEntry;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A single record of a given concept clique with details 
 */
@ApiModel(description = "A single record of a given concept clique with details ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-25T19:34:49.338-07:00")

public class ServerConceptWithDetails   {
  @JsonProperty("clique")
  private String clique = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("categories")
  @Valid
  private List<String> categories = null;

  @JsonProperty("aliases")
  @Valid
  private List<String> aliases = null;

  @JsonProperty("entries")
  @Valid
  private List<ServerConceptWithDetailsBeaconEntry> entries = null;

  public ServerConceptWithDetails clique(String clique) {
    this.clique = clique;
    return this;
  }

  /**
   * CURIE identifying the equivalent concept clique to which the concept belongs. 
   * @return clique
  **/
  @ApiModelProperty(value = "CURIE identifying the equivalent concept clique to which the concept belongs. ")


  public String getClique() {
    return clique;
  }

  public void setClique(String clique) {
    this.clique = clique;
  }

  public ServerConceptWithDetails name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Canonical human readable name of the key concept of the clique 
   * @return name
  **/
  @ApiModelProperty(value = "Canonical human readable name of the key concept of the clique ")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServerConceptWithDetails categories(List<String> categories) {
    this.categories = categories;
    return this;
  }

  public ServerConceptWithDetails addCategoriesItem(String categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<String>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Concept semantic type as a CURIE into a data type ontology 
   * @return categories
  **/
  @ApiModelProperty(value = "Concept semantic type as a CURIE into a data type ontology ")


  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public ServerConceptWithDetails aliases(List<String> aliases) {
    this.aliases = aliases;
    return this;
  }

  public ServerConceptWithDetails addAliasesItem(String aliasesItem) {
    if (this.aliases == null) {
      this.aliases = new ArrayList<String>();
    }
    this.aliases.add(aliasesItem);
    return this;
  }

  /**
   * set of alias CURIES in the equivalent concept clique of the concept 
   * @return aliases
  **/
  @ApiModelProperty(value = "set of alias CURIES in the equivalent concept clique of the concept ")


  public List<String> getAliases() {
    return aliases;
  }

  public void setAliases(List<String> aliases) {
    this.aliases = aliases;
  }

  public ServerConceptWithDetails entries(List<ServerConceptWithDetailsBeaconEntry> entries) {
    this.entries = entries;
    return this;
  }

  public ServerConceptWithDetails addEntriesItem(ServerConceptWithDetailsBeaconEntry entriesItem) {
    if (this.entries == null) {
      this.entries = new ArrayList<ServerConceptWithDetailsBeaconEntry>();
    }
    this.entries.add(entriesItem);
    return this;
  }

  /**
   * List of details specifically harvested from beacons, indexed by beacon 
   * @return entries
  **/
  @ApiModelProperty(value = "List of details specifically harvested from beacons, indexed by beacon ")

  @Valid

  public List<ServerConceptWithDetailsBeaconEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<ServerConceptWithDetailsBeaconEntry> entries) {
    this.entries = entries;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerConceptWithDetails serverConceptWithDetails = (ServerConceptWithDetails) o;
    return Objects.equals(this.clique, serverConceptWithDetails.clique) &&
        Objects.equals(this.name, serverConceptWithDetails.name) &&
        Objects.equals(this.categories, serverConceptWithDetails.categories) &&
        Objects.equals(this.aliases, serverConceptWithDetails.aliases) &&
        Objects.equals(this.entries, serverConceptWithDetails.entries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clique, name, categories, aliases, entries);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerConceptWithDetails {\n");
    
    sb.append("    clique: ").append(toIndentedString(clique)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    aliases: ").append(toIndentedString(aliases)).append("\n");
    sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

