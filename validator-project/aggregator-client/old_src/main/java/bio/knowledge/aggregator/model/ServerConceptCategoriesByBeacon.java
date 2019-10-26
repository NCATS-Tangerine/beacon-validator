package bio.knowledge.aggregator.model;

import java.util.Objects;
import bio.knowledge.aggregator.model.ServerBeaconConceptCategory;
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
 * ServerConceptCategoriesByBeacon
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-25T19:34:49.338-07:00")

public class ServerConceptCategoriesByBeacon   {
  @JsonProperty("beacon")
  private Integer beacon = null;

  @JsonProperty("categories")
  @Valid
  private List<ServerBeaconConceptCategory> categories = null;

  public ServerConceptCategoriesByBeacon beacon(Integer beacon) {
    this.beacon = beacon;
    return this;
  }

  /**
   * Aggregator index identifier of the given beacon 
   * @return beacon
  **/
  @ApiModelProperty(value = "Aggregator index identifier of the given beacon ")


  public Integer getBeacon() {
    return beacon;
  }

  public void setBeacon(Integer beacon) {
    this.beacon = beacon;
  }

  public ServerConceptCategoriesByBeacon categories(List<ServerBeaconConceptCategory> categories) {
    this.categories = categories;
    return this;
  }

  public ServerConceptCategoriesByBeacon addCategoriesItem(ServerBeaconConceptCategory categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<ServerBeaconConceptCategory>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Get categories
   * @return categories
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ServerBeaconConceptCategory> getCategories() {
    return categories;
  }

  public void setCategories(List<ServerBeaconConceptCategory> categories) {
    this.categories = categories;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerConceptCategoriesByBeacon serverConceptCategoriesByBeacon = (ServerConceptCategoriesByBeacon) o;
    return Objects.equals(this.beacon, serverConceptCategoriesByBeacon.beacon) &&
        Objects.equals(this.categories, serverConceptCategoriesByBeacon.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beacon, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerConceptCategoriesByBeacon {\n");
    
    sb.append("    beacon: ").append(toIndentedString(beacon)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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

