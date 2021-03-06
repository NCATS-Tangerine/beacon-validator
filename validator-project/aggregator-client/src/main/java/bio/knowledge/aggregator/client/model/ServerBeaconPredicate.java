/*
 * Translator Knowledge Beacon Aggregator API
 * This is the Translator Knowledge Beacon Aggregator web service application programming interface (API) that provides integrated access to a pool of knowledge sources publishing concepts and relations through the Translator Knowledge Beacon API. This API is similar to that of the latter mentioned API with the addition of some extra informative endpoints plus session identifier and beacon indices. These latter identifiers are locally assigned numeric indices provided to track the use of specific registered beacons within the aggregator API itself. 
 *
 * OpenAPI spec version: 1.0.10
 * Contact: richard@starinformatics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package bio.knowledge.aggregator.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Single local predicate term from a given beacon 
 */
@ApiModel(description = "Single local predicate term from a given beacon ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-04T13:48:21.751-07:00")
public class ServerBeaconPredicate {
  @SerializedName("id")
  private String id = null;

  @SerializedName("iri")
  private String iri = null;

  @SerializedName("label")
  private String label = null;

  @SerializedName("frequency")
  private Integer frequency = null;

  public ServerBeaconPredicate id(String id) {
    this.id = id;
    return this;
  }

   /**
   * the 'local' CURIE-encoded identifier of the given predicate, as published by the given beacon 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "the 'local' CURIE-encoded identifier of the given predicate, as published by the given beacon ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServerBeaconPredicate iri(String iri) {
    this.iri = iri;
    return this;
  }

   /**
   * the 'local' CURIE-encoded identifier of the given predicate, as published by the given beacon 
   * @return iri
  **/
  @ApiModelProperty(example = "null", value = "the 'local' CURIE-encoded identifier of the given predicate, as published by the given beacon ")
  public String getIri() {
    return iri;
  }

  public void setIri(String iri) {
    this.iri = iri;
  }

  public ServerBeaconPredicate label(String label) {
    this.label = label;
    return this;
  }

   /**
   * the 'local' human readable of the given predicate, as published by the given beacon 
   * @return label
  **/
  @ApiModelProperty(example = "null", value = "the 'local' human readable of the given predicate, as published by the given beacon ")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public ServerBeaconPredicate frequency(Integer frequency) {
    this.frequency = frequency;
    return this;
  }

   /**
   * the number of instances of the specified predicate relation is used in statements within the given beacon 
   * @return frequency
  **/
  @ApiModelProperty(example = "null", value = "the number of instances of the specified predicate relation is used in statements within the given beacon ")
  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerBeaconPredicate serverBeaconPredicate = (ServerBeaconPredicate) o;
    return Objects.equals(this.id, serverBeaconPredicate.id) &&
        Objects.equals(this.iri, serverBeaconPredicate.iri) &&
        Objects.equals(this.label, serverBeaconPredicate.label) &&
        Objects.equals(this.frequency, serverBeaconPredicate.frequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, iri, label, frequency);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerBeaconPredicate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    iri: ").append(toIndentedString(iri)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
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

