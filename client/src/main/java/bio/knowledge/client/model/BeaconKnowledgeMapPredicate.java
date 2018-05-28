/*
 * Translator Knowledge Beacon API
 * This is the Translator Knowledge Beacon web service application programming interface (API). 
 *
 * OpenAPI spec version: 1.0.18
 * Contact: richard@starinformatics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package bio.knowledge.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BeaconKnowledgeMapPredicate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-18T12:09:55.593-07:00")
public class BeaconKnowledgeMapPredicate {
  @SerializedName("relation")
  private String relation = null;

  public BeaconKnowledgeMapPredicate relation(String relation) {
    this.relation = relation;
    return this;
  }

   /**
   * Human readable name of the maximal given predicate relation. This should be specified as Biolink predicate names like  gene_associated_with_condition. See [Biolink Model](https://biolink.github.io/biolink-model) for the full list of terms 
   * @return relation
  **/
  @ApiModelProperty(example = "null", value = "Human readable name of the maximal given predicate relation. This should be specified as Biolink predicate names like  gene_associated_with_condition. See [Biolink Model](https://biolink.github.io/biolink-model) for the full list of terms ")
  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeaconKnowledgeMapPredicate beaconKnowledgeMapPredicate = (BeaconKnowledgeMapPredicate) o;
    return Objects.equals(this.relation, beaconKnowledgeMapPredicate.relation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeaconKnowledgeMapPredicate {\n");
    
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
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

