
package com.techelevator.domain.spotify.createdplaylist;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Tracks {

    private String href;
    private Integer limit;
    private Object next;
    private Integer offset;
    private Object previous;
    private Integer total;
    private List<Object> items;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.next == null)? 0 :this.next.hashCode()));
        result = ((result* 31)+((this.total == null)? 0 :this.total.hashCode()));
        result = ((result* 31)+((this.offset == null)? 0 :this.offset.hashCode()));
        result = ((result* 31)+((this.previous == null)? 0 :this.previous.hashCode()));
        result = ((result* 31)+((this.limit == null)? 0 :this.limit.hashCode()));
        result = ((result* 31)+((this.href == null)? 0 :this.href.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.items == null)? 0 :this.items.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tracks) == false) {
            return false;
        }
        Tracks rhs = ((Tracks) other);
        return (((((((((this.next == rhs.next)||((this.next!= null)&&this.next.equals(rhs.next)))&&((this.total == rhs.total)||((this.total!= null)&&this.total.equals(rhs.total))))&&((this.offset == rhs.offset)||((this.offset!= null)&&this.offset.equals(rhs.offset))))&&((this.previous == rhs.previous)||((this.previous!= null)&&this.previous.equals(rhs.previous))))&&((this.limit == rhs.limit)||((this.limit!= null)&&this.limit.equals(rhs.limit))))&&((this.href == rhs.href)||((this.href!= null)&&this.href.equals(rhs.href))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.items == rhs.items)||((this.items!= null)&&this.items.equals(rhs.items))));
    }

}
